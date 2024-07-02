package ru.itis.myapplication2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import ru.itis.myapplication2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //спасибо за совет про то что нужно сделать чтобы не писать каждый раз binding?.., но мне лень в каждом классе прописывать по два байдинга((
    private var binding: ActivityMainBinding? = null

    private var controller: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        controller = (supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment)
            .navController

        controller?.let { navController ->
            binding?.bottomNavigation?.setupWithNavController(navController)
        }
    }

    override fun onBackPressed() { //этот метод был на лекции, но я не стала смотреть аналоги и оставила как есть
        super.onBackPressed()
        controller?.navigateUp()
        //у контроллера навигация вперед, поэтому мы хотим ходить еще и назад
        //срабатывает когда пользователь делает жест/кнопку "назад"
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}