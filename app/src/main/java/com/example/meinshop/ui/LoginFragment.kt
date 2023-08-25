package com.example.meinshop.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.meinshop.databinding.FragmentLoginBinding
import com.example.meinshop.viewModel.LoginViewModel

class LoginFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLoginBinding = FragmentLoginBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        // Setzt die ErrorCardView standardmäßig auf GONE
        binding.errorLoginCV.visibility = View.GONE

        // Beobachten des Login-Status
        viewModel.loginStatus.observe(viewLifecycleOwner, Observer { isSuccess ->
            if (isSuccess) {
                // Navigieren zum WelcomeScreen
                binding.errorLoginCV.visibility = View.GONE // Verstecken der ErrorCardView
            } else {
                // Zeigt die ErrorCardView an
                binding.errorLoginCV.visibility = View.VISIBLE // Anzeigen der ErrorCardView
            }
        })

        binding.loginBTN.setOnClickListener {
            val username = binding.usernameLoginTEF.text.toString()
            val password = binding.passwortLoginTEF.text.toString()
            viewModel.login(username, password)
        }

        return binding.root
    }
}