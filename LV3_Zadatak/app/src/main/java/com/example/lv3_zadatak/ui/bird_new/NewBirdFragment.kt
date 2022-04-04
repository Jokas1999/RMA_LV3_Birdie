package com.example.lv3_zadatak.ui.bird_new

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lv3_zadatak.R
import com.example.lv3_zadatak.databinding.FragmentNewBirdBinding
import com.example.lv3_zadatak.di.BirdRepositoryFactory
import com.example.lv3_zadatak.model.Bird
import com.example.lv3_zadatak.utils.getDate
import com.example.lv3_zadatak.utils.getTime

class NewBirdFragment : Fragment() {
    private val birdRepository = BirdRepositoryFactory.birdRepository
    lateinit var binding : FragmentNewBirdBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewBirdBinding.inflate(layoutInflater)
        binding.bSaveBird.setOnClickListener{saveBird()}
        return binding.root
    }
    private fun saveBird(){
        val name = binding.etBirdNameInput.text.toString()
        val colour = binding.etBirdColourInput.text.toString()
        val place = binding.etBirdPlaceInput.text.toString()
        val date = binding.dpDateAddedInput.getDate()
        val time = binding.tpTimeAddedInput.getTime()

        birdRepository.save(Bird(0,colour,date,place,time,name))

        Toast.makeText(context, getString(R.string.message_saving), Toast.LENGTH_SHORT).show()
        val action = NewBirdFragmentDirections.actionNewBirdFragmentToTaskListFragment()
        findNavController().navigate(action)
    }

    companion object {
        val Tag = "NewTask"

        fun create(): Fragment {
            return NewBirdFragment()
        }
    }
}