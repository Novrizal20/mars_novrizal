package com.example.mars_novrizal.Message

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mars_novrizal.Message.Tutorial.TutorialMessageActivity
import com.example.mars_novrizal.R
import com.example.mars_novrizal.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {
    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!
    private val messageList = listOf(
        MessageModel("Alya", "Halo! Apa kabar?", "20 thn", "https://i.pravatar.cc/150?img=1"),
        MessageModel("Budi", "Sudah makan?", "21 thn", "https://i.pravatar.cc/150?img=2"),
        MessageModel("Citra", "Jangan lupa tugasnya ya!", "22 thn", "https://i.pravatar.cc/150?img=3"),
        MessageModel("Dika", "Besok kita rapat jam 9", "23 thn", "https://i.pravatar.cc/150?img=4"),
        MessageModel("Eka", "Nice job kemarin!", "24 thn", "https://i.pravatar.cc/150?img=5"),
        MessageModel("Fajar", "Lagi ngapain?", "25 thn", "https://i.pravatar.cc/150?img=6"),
        MessageModel("Gita", "Boleh minta tolong?", "26 thn", "https://i.pravatar.cc/150?img=7"),
        MessageModel("Hana", "Lihat email ya", "27 thn", "https://i.pravatar.cc/150?img=8"),
        MessageModel("Irfan", "Oke noted", "28 thn", "https://i.pravatar.cc/150?img=9"),
        MessageModel("Joko", "Sampai jumpa besok", "29 thn", "https://i.pravatar.cc/150?img=10")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Message"
            setHasOptionsMenu(true)
        }

        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter
    }

    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.message_toolbar_menu, menu)
    }
    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_tutorial -> {
                val intent = Intent(requireContext(), TutorialMessageActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}