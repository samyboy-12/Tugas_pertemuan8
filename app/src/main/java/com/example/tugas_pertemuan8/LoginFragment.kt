package com.example.tugas_pertemuan8

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.tugas_pertemuan8.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.loginButton.setOnClickListener {
            val email = binding.emailInput.text.toString()
            val password = binding.passwordInput.text.toString()

            val sharedPref = requireActivity().getSharedPreferences("UserSession", Context.MODE_PRIVATE)
            val registeredEmail = sharedPref.getString("email", "")
            val registeredPassword = sharedPref.getString("password", "")

            if (email == registeredEmail && password == registeredPassword) {
                Toast.makeText(context, "Login successful!", Toast.LENGTH_SHORT).show()

                // Navigate to Dashboard
                val intent = Intent(activity, DashboardActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(context, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }
}