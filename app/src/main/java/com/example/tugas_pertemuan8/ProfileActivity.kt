package com.example.tugas_pertemuan8


import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas_pertemuan8.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("UserSession", Context.MODE_PRIVATE)
        val name = sharedPref.getString("name", "Unknown")
        val email = sharedPref.getString("email", "Unknown")

        binding.nameTextView.text = name
        binding.nimTextView.text = "NIM: 123456789" // Contoh NIM statis
    }
}