package ru.itis.myapplication2.recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.itis.myapplication2.databinding.ItemAnimeBinding

class AnimeAdapter(
    //Принимает список анимешек (данные)
    private val list: List<Anime>,
    private val glide: RequestManager,
    private val onClick: (Anime) -> Unit,
) : RecyclerView.Adapter<AnimeHolder>() {

    //вызывается когда мы первый раз обращаемся к Адаптеру. Создает необходимое ограниченное кол-во холдеров.
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AnimeHolder = AnimeHolder(
        binding = ItemAnimeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        glide = glide,
        onClick = onClick,
    )

    //вызывается при скролле. Тогда, когда нам снова нужно будет сеттить данные в холдер.
    //в метод холдера onBind() передаем элемент списка типа Anime (это экземпляр дата класса, один элемент из набора данных,
    //информацию о котором нужно отобразить), потом сам холдер связывает
    //данные(название, жанры) с xml файлом, чтобы отобразить их на экране
    override fun onBindViewHolder(holder: AnimeHolder, position: Int) {
        holder.onBind(list[position])
    }

    //даем знать Адептеру сколько у нас элементов в списке
    override fun getItemCount(): Int = list.size
}