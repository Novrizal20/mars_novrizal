package com.example.mars_novrizal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.example.mars_novrizal.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // SharedPreferences
        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

        // Cek apakah user sudah login
        val isLogin = sharedPref.getBoolean("isLogin", false)

        if (isLogin) {
            val intent = Intent(this, BaseActivity::class.java)
            startActivity(intent)
            finish()
            return
        }

        binding.btnLogin.setOnClickListener {

            val username = binding.username.text.toString()
            val password = binding.Password.text.toString()

            if (username.isNotEmpty() && username == password) {

                // Simpan status login dan username
                sharedPref.edit {
                    putBoolean("isLogin", true)
                    putString("username", username)
                }

                // Masuk ke MainActivity
                val intent = Intent(this, BaseActivity::class.java)
                startActivity(intent)
                finish()

            } else {

                AlertDialog.Builder(this)
                    .setMessage("Silahkan coba lagi")
                    .setPositiveButton("OK", null)
                    .show()
            }
        }
    }
}

