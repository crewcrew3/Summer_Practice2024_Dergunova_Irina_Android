package ru.itis.myapplication2.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import ru.itis.myapplication2.R
import ru.itis.myapplication2.databinding.FragmentAnimeDetailsBinding
import ru.itis.myapplication2.recycler_view.AnimeRepository

class AnimeDetailsFragment : Fragment(R.layout.fragment_anime_details) {

    private var binding: FragmentAnimeDetailsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAnimeDetailsBinding.bind(view)

        val id = arguments?.getInt(ARG_ID)
        val anime = AnimeRepository.animes.find{it.id == id} ?: return

        binding?.apply {
            tvTitle.text = anime.name
            tvGenres.text = anime.genres
            tvShortDescription.text = anime.shortDescription
            tvLongDescription.text = anime.longDescription

            Glide.with(this@AnimeDetailsFragment)
                .load(anime.url)
                .error(R.drawable.pic_miku)
                .placeholder(R.drawable.pic_bochi)
                .into(ivImage)

            ivButton.setOnClickListener {
                findNavController().navigate(R.id.action_animeDetailsFragment_to_animeCatalogFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {

        private const val ARG_ID = "ARG_ID"

        fun bundle(id: Int): Bundle = Bundle().apply {
            putInt(ARG_ID, id)
        }
    }
}