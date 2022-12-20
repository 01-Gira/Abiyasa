package com.gira.myapplication.ui.auth.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.gira.myapplication.R
import com.gira.myapplication.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginFragment : Fragment() {
    private var _binding : FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private lateinit var auth : FirebaseAuth
    

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = Firebase.auth

        binding.tvRegister.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        actionLogin()
    }

    private fun actionLogin() {
        binding.apply {
            btnLogin.setOnClickListener {
                val email = edEmailLogin.text.toString()
                val password = edPasswordLogin.text.toString()
                when {
                    email.isEmpty() && password.isEmpty() -> {
                        edEmailLogin.error = getString(R.string.enter_email)
                        edPasswordLogin.error = getString(R.string.enter_password)
                        tvWrongEmailOrPasssword.visibility = View.VISIBLE
                    }
                    else -> {

                    }
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        showLoading(false)
        (activity as AppCompatActivity).supportActionBar?.hide()
        val currentUser = auth.currentUser
        currentUser(currentUser)
    }

    private fun currentUser(currentUser: FirebaseUser?) {
        if (currentUser != null) {
            showLoading(true)
            Toast.makeText(context, getString(R.string.already_sign_in), Toast.LENGTH_SHORT).show()
        }
    }

    private fun showLoading(isLoading: Boolean) {
        binding.pbLogin.visibility = if(isLoading) View.VISIBLE else View.GONE
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}