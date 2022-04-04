package com.example.lv3_zadatak.ui.bird_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.lv3_zadatak.R
import com.example.lv3_zadatak.databinding.FragmentBirdDetailsBinding
import com.example.lv3_zadatak.databinding.FragmentNewBirdBinding
import com.example.lv3_zadatak.di.BirdRepositoryFactory
import com.example.lv3_zadatak.model.Bird
import java.text.SimpleDateFormat

class BirdDetailsFragment : Fragment() {

    private val dateDisplayFormat = SimpleDateFormat("yyyy-MM-dd")
    private val timeDisplayFormat = SimpleDateFormat("h:mm a")
    lateinit var binding : FragmentBirdDetailsBinding
    private val birdRepository = BirdRepositoryFactory.birdRepository
    private val args: BirdDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentBirdDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bird =birdRepository.getBirdById(args.birdID)
        display(bird);
    }
    private fun display(bird: Bird?){
        bird?.let {
            binding.apply {
                tvBirdDateAdded.text = dateDisplayFormat.format(it.date)
                tvBirdTimeAdded.text = timeDisplayFormat.format(it.date)
                clBirdDetailsRoot.setBackgroundResource(R.color.red)
                tvBirdPlace.text = bird.place
                tvBirdColour.text = bird.colour
                tvBirdName.text=bird.name
            }
        }
    }
    companion object {
        val Tag = "BirdDetails"
        val TaskIdKey = "BirdId"

        fun create(id: Long): Fragment {
            val fragment = BirdDetailsFragment()
            return fragment
        }
    }


}