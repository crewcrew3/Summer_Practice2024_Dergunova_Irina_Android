package ru.itis.myapplication2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.itis.myapplication2.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private var binding: FragmentMainBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        val email = arguments?.getString(ARG_EMAIL) ?: "cutie"

        binding?.apply {
            tvAccountName.text = "Welcome $email!"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        //статик поле и метод, принадлежащее классу MainFragment

        private const val ARG_EMAIL = "ARG_EMAIL"

        fun bundle(email: String): Bundle = Bundle().apply {
            putString(ARG_EMAIL, email)
        }
    }
}