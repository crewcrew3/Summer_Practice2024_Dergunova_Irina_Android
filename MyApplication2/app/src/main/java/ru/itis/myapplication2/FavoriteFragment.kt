package ru.itis.myapplication2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import ru.itis.myapplication2.databinding.FragmentFavoriteBinding

class FavoriteFragment : Fragment(R.layout.fragment_favorite) {

    private var binding: FragmentFavoriteBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavoriteBinding.bind(view)

        binding?.apply {
            sendButton.setOnClickListener {
                when {
                    !etMessage.text.isNullOrEmpty() -> {
                        findNavController().navigate( //получаем доступ к NavigationController
                            resId = R.id.action_favoriteFragment_to_coolPictureFragment,
                            args = CoolPictureFragment.bundle(
                                message = etMessage.text.toString(),
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