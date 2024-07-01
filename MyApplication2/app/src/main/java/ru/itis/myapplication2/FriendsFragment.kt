package ru.itis.myapplication2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.itis.myapplication2.databinding.FragmentFriendsBinding

class FriendsFragment : Fragment(R.layout.fragment_friends) {

    private var binding: FragmentFriendsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFriendsBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}