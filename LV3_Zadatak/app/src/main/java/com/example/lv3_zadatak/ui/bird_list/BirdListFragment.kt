package com.example.lv3_zadatak.ui.bird_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lv3_zadatak.databinding.FragmentBirdListBinding
import com.example.lv3_zadatak.di.BirdRepositoryFactory
import com.example.lv3_zadatak.model.Bird

class BirdListFragment: Fragment(),OnBirdEventListener {
    private lateinit var binding: FragmentBirdListBinding
    private lateinit var adapter: BirdAdapter
    private val taskRepository = BirdRepositoryFactory.birdRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentBirdListBinding.inflate(layoutInflater)
        setupRecyclerView()
        binding.fabAddNote.setOnClickListener {showCreateNewBirdFragment()}
        return binding.root
    }

    private fun setupRecyclerView() {
        binding.birdListRvBirds.layoutManager =LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        adapter = BirdAdapter()
        adapter.onTaskSelectedListener = this
        binding.birdListRvBirds.adapter = adapter
    }
    override fun onResume() {
        super.onResume()
        updateData()
    }

    private fun updateData() {
        adapter.setBirds(taskRepository.getAllBirds())
    }

    companion object {
        val Tag = "TasksList"

        fun create(): Fragment {
            return BirdListFragment()
        }
    }

    override fun onBirdSelected(id: Long?) {
        val action =
        BirdListFragmentDirections.actionTaskListFragmentToDetailsFragment(id?:-1)
        findNavController().navigate(action)
    }


    override fun onBirdLongPress(bird: Bird?): Boolean {
        bird?.let { it ->
            taskRepository.delete(it)
            adapter.setBirds(taskRepository.getAllBirds())
        }
        return true
    }

    private fun showCreateNewBirdFragment() {
        val action = BirdListFragmentDirections.actionTaskListFragmentToNewBirdFragment()
        findNavController().navigate(action)
    }
}