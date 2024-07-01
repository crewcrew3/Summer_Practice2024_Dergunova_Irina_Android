package ru.itis.myapplication2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.itis.myapplication2.databinding.FragmentCoolPictureBinding

class CoolPictureFragment : Fragment(R.layout.fragment_cool_picture) {

    private var binding: FragmentCoolPictureBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCoolPictureBinding.bind(view)

        val message = arguments?.getString(ARG_MESSAGE) ?: "To send a text fill in the field"

        binding?.apply {
            tvMessage.text = "$message"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {

        private const val ARG_MESSAGE = "ARG_MESSAGE"

        fun bundle(message: String): Bundle = Bundle().apply {
            putString(ARG_MESSAGE, message)
        }
    }
}