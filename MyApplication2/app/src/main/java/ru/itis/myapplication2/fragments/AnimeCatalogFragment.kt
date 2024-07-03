package ru.itis.myapplication2.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import ru.itis.myapplication2.R
import ru.itis.myapplication2.databinding.FragmentAnimeCatalogBinding
import ru.itis.myapplication2.recycler_view.AnimeAdapter
import ru.itis.myapplication2.recycler_view.AnimeRepository

class AnimeCatalogFragment : Fragment(R.layout.fragment_anime_catalog) {

    private var binding: FragmentAnimeCatalogBinding? = null

    private var adapter: AnimeAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAnimeCatalogBinding.bind(view)

        initAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter() {
        binding?.apply {
            //передаем в адептер список наших анимешек
            adapter = AnimeAdapter(
                list = AnimeRepository.animes,
                glide = Glide.with(this@AnimeCatalogFragment),
                //реализуем то, что надо сделать при нажатии
                onClick = {
                    findNavController().navigate(
                        resId = R.id.action_animeCatalogFragment_to_animeDetailsFragment,
                        args = AnimeDetailsFragment.bundle(
                            id = it.id,
                        )
                    )
                }
            )
            //Поставили адаптер в RecycleView
            rvAnime.adapter = adapter
            rvAnime.layoutManager = LinearLayoutManager(requireContext())
        }
    }
}