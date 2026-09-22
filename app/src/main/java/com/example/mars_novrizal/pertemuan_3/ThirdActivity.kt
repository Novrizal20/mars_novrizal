package com.example.mars_novrizal.pertemuan_3

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mars_novrizal.R
import com.example.mars_novrizal.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        val inputNoTujuan: EditText = findViewById(R.id.inputNoTujuan)
//        val btnKirim: Button = findViewById(R.id.btnKirim)
//        btnKirim.setOnClickListener {
//
//                //Mengambil value dari inputNama dan menampilkan di Logcat
//                val nomor = inputNoTujuan.text
// //               Log.e("Klik btnSubmit", "Tombol berhasil di tekan. Isi dari inputNama = $nama")
//
//                Toast.makeText(this, "Pesan Berhasil dikirim ke $nomor", Toast.LENGTH_SHORT).show()
//            }
        binding.btnKirim.setOnClickListener {
            val noTujuan = binding.inputNoTujuan.text
            Toast.makeText(this, "Pesan berhasil dikirim ke $noTujuan", Toast.LENGTH_SHORT).show()
        }
        }
    }

