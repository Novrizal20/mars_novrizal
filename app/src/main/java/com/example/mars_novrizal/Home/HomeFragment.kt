package com.example.mars_novrizal.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.mars_novrizal.AuthActivity
import com.example.mars_novrizal.Home.pertemuan_2.SecondActivity
import com.example.mars_novrizal.Home.pertemuan_3.ThirdActivity
import com.example.mars_novrizal.Home.pertemuan_4.FourthActivity
import com.example.mars_novrizal.Home.pertemuan_5.FifthActivity
import com.example.mars_novrizal.Home.pertemuan_6.SixthActivity
import com.example.mars_novrizal.Home.pertemuan_10.TenthActivity
import com.example.mars_novrizal.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Home"
        }
        binding.btnToFourth.setOnClickListener {
            val intent = Intent(requireContext(), FourthActivity::class.java)
            /*tambahkan bagian berikut*/
            intent.putExtra("name", "Politeknik Caltex Riau")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 22)
            startActivity(intent)
        }
        binding.btnToFifth.setOnClickListener {
            val intent = Intent(requireContext(), FifthActivity::class.java)
            startActivity(intent)
        }
        binding.btnToThird.setOnClickListener {
            val intent = Intent(requireContext(), ThirdActivity::class.java)
            startActivity(intent)
        }
        binding.btnToSecond.setOnClickListener {
            val intent = Intent(requireContext(), SecondActivity::class.java)
            startActivity(intent)
        }

        binding.btnToSixth.setOnClickListener {
            val intent = Intent(requireContext(), SixthActivity::class.java)
            startActivity(intent)
        }

        binding.btnToNinth.setOnClickListener {
            val intent = Intent(requireContext(), TenthActivity::class.java)
            startActivity(intent)
        }
        // Fitur Logout
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Konfirmasi Logout")
                .setMessage("Apakah Anda yakin ingin logout?")
                .setNegativeButton("Tidak", null)
                .setPositiveButton("Ya") { dialog, _ ->

                    val sharedPref =
                        requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)

                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()

                    dialog.dismiss()
                    val intent = Intent(requireContext(), AuthActivity::class.java)
                    startActivity(intent)
                    requireActivity().finish()
                }
                .show()
        }
    }
}