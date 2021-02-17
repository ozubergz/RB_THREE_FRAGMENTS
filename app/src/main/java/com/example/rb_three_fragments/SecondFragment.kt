package com.example.rb_three_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.rb_three_fragments.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private val args by navArgs<SecondFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentSecondBinding.inflate(inflater, container, false).also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textView.text = args.msg

        val parts = args.msg.split(" ")
        val first = parts[0]
        val second = parts[1]

        binding.btnOne.setOnClickListener{
            val action = SecondFragmentDirections.actionSecondFragmentToThirdFragment(first)
            findNavController().navigate(action)
        }

        binding.btnTwo.setOnClickListener{
            val action = SecondFragmentDirections.actionSecondFragmentToThirdFragment(second)
            findNavController().navigate(action)
        }
    }

}