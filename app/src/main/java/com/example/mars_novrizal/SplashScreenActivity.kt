package com.example.mars_novrizal

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 1. Cek status login SEBELUM menampilkan layout splash
        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
        val isLogin = sharedPref.getBoolean("isLogin", false)

        if (isLogin) {
            // Jika SUDAH login: Langsung ke BaseActivity tanpa render layout splash
            val intent = Intent(this, BaseActivity::class.java)
            startActivity(intent)
            finish()
            return // Stop eksekusi onCreate agar setContentView tidak dipanggil
        }

        // 2. Jika BELUM login: Tampilkan layout splash screen & jalankan delay 2 detik
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        lifecycleScope.launch {
            delay(2000) //simulasi pengambilan data selama 2 detik

            val sharedPref = getSharedPreferences("user_pref", Context.MODE_PRIVATE)
            val isLogin = sharedPref.getBoolean("isLogin", false)
            val intent = if (isLogin) {
                Intent(this@SplashScreenActivity, BaseActivity::class.java)
            } else {
                Intent(this@SplashScreenActivity, AuthActivity::class.java)
            }
            startActivity(intent)
            finish()
        }
    }
}