package com.gira.myapplication.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.gira.myapplication.R
import com.gira.myapplication.databinding.FragmentAuthBinding

class AuthFragment : Fragment() {

    private var _binding : FragmentAuthBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentAuthBinding.inflate(inflater, container, false)
        val view: View = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        binding.btnLogin.setOnClickListener {
//            it.findNavController().navigate(R.id.action_authFragment_to_loginFragment)
//        }
//
//        binding.btnRegister.setOnClickListener {
//            it.findNavController().navigate(R.id.action_authFragment_to_registerFragment)
//        }
    }

    override fun onStart() {
        super.onStart()
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}