package ru.itis.myapplication2.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import ru.itis.myapplication2.R
import ru.itis.myapplication2.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment(R.layout.fragment_registration) {

    private var binding: FragmentRegistrationBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegistrationBinding.bind(view)

        binding?.apply {
            registrationButton.setOnClickListener {
                when {
                    !etEmail.text.isNullOrEmpty() -> {
                        findNavController().navigate( //получаем доступ к NavigationController
                            resId = R.id.action_registrationFragment_to_mainFragment,
                            args = MainFragment.bundle(
                                //вызываем статическую функцию у класса MainFragment, чтобы передать введенный текст
                                email = etEmail.text.toString(),
                            )
                        )
                    }
                    else -> Snackbar.make(root, "To send a text fill in the field", Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}