package ru.itis.myapplication2.recycler_view

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import ru.itis.myapplication2.R
import ru.itis.myapplication2.databinding.ItemAnimeBinding

class AnimeHolder(
    private val binding: ItemAnimeBinding,
    private val glide: RequestManager,
    //то, что мы делаем при нажатии
    private val onClick: (Anime) -> Unit,
) : ViewHolder(binding.root) {

    //достает данные
    fun onBind(anime: Anime) {
        binding.apply {
            tvAnime.text = anime.name
            tvGenres.text = anime.genres

            //получаем картинку из сети
            glide
                .load(anime.url)
                .error(R.drawable.pic_miku)
                .placeholder(R.drawable.pic_bochi)
                .into(ivImage)
            root.setOnClickListener {
                //заставляем функцию у onClick`а выполниться при нажатии. Передаем в качестве параметра аниме, на которое мы кликнули
                onClick.invoke(anime)
            }
        }
    }
}