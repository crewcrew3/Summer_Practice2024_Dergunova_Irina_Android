package ru.itis.summerpractice2024

import android.os.Bundle
import android.text.TextUtils
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doOnTextChanged
import ru.itis.summerpractice2024.databinding.ActivityMainBinding
import java.util.regex.Pattern
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var viewBinding: ActivityMainBinding? = null //создали байдинг

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewBinding = ActivityMainBinding.inflate(layoutInflater) //инициализация байдинга
        setContentView(viewBinding?.root) //корень всего бандинга
        initViews()
    }

    private fun initViews() { //с байдингом
        viewBinding?.apply {
            textInput.doOnTextChanged { text, start, before, count ->
                text?.let {
                    val pattern = Pattern.compile("-?\\d+")
                    beginButton.isEnabled = pattern.matcher(text).matches()
                }
            }
            beginButton.setOnClickListener {
                //Toast.makeText(this@MainActivity, "Current number: ${textInput.text}", Toast.LENGTH_SHORT).show()
                if (textInput.text.toString().isNotEmpty() && TextUtils.isDigitsOnly(textInput.text.toString())) {
                    fighting(createMonsterArmy(textInput.text.toString().toInt()))
                }

            }
        }
    }

    fun fighting(army: ArrayList<Monster>): Monster {
        if (army.size == 1) {
            println("WINNER IS ${army.get(0)}!!!")
            return army.get(0)
        }
        val random = Random
        val winners = ArrayList<Monster>()
        for (i in 0..army.size/2 - 1) {
            val monster1Index = random.nextInt(0, army.size)
            val monster1 = army.get(monster1Index)
            army.remove(monster1)

            val monster2Index = random.nextInt(0, army.size)
            val monster2 = army.get(monster2Index)
            army.remove(monster2)

            val winner = compareATKPower(monster1, monster2)
            winners.add(winner)
            println("Battle between ${monster1.name} and ${monster2.name}, the winner is ${winner.name}!")
        }
        if (!army.isEmpty()) {
            val lucky = army.get(0)
            println("${lucky.name} - no partner, next round")
            army.remove(lucky)
            winners.add(lucky)
        }
        return fighting(winners)
    }

    fun createMonsterArmy(number: Int): ArrayList<Monster> {
        var army = ArrayList<Monster>()
        var names = ArrayList<String>()

        for (i in 0..number - 1) {
            names.add(i.toString())
        }
        val random = Random

        for (i in 0..number - 1) {
            val randomNamePosition = random.nextInt(0, names.size)
            val randomAge = random.nextInt(1, 10000)
            army.add(createRandomMonster(names.get(randomNamePosition), randomAge))
            names.removeAt(randomNamePosition)
        }

        return army
    }

    fun createRandomMonster(randomName: String, randomAge: Int): Monster {
        val newMonster = Monster(
            name = randomName,
            age = randomAge,
        )
        return newMonster
    }

    fun compareATKPower(monster1: Monster, monster2: Monster): Monster {
        if (monster1.attackPower > monster2.attackPower) {
            return monster1
        }
        return monster2
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}

open class Monster(
    val name: String,
    val age: Int,
    open var hp: Int = (10 * (age * 0.5)).toInt(),
    open var attackPower: Int = (100 * (age * 0.3)).toInt(),
) {

    fun attack(): String {
        return "$name attacked you!"
    }

    fun monsterInfo(): String = "Name: $name; Age: $age; HP: $hp; ATK: $attackPower"

    override fun toString(): String = name
}

class Dragon(
    name: String,
    age: Int,
    override var hp: Int  = (1000 * (age * 0.5)).toInt(),
    override var attackPower: Int = (10000 * (age * 0.3)).toInt(),
    var fireBreathAttackPower: Int = (attackPower * 1.5).toInt(),
) : Monster(
    name = name,
    age = age,
    hp = hp,
    attackPower = attackPower,
), FireBreathing { //Ctrl+O чтобы реализовать методы интерфейса

    override fun breath(): String = "Fire!!!"
}

class FireSpirit(
    name: String,
    age: Int,
    override var hp: Int  = (500 * (age * 0.5)).toInt(),
    override var attackPower: Int = (5000 * (age * 0.3)).toInt(),
    var fireBreathAttackPower: Int,
    val visible: Boolean,
) : Monster(
    name = name,
    age = age,
    hp = hp,
    attackPower = attackPower,
), FireBreathing { //Ctrl+O чтобы реализовать методы интерфейса

    override fun breath(): String = "Fireeeeee!!!"

}

interface FireBreathing {
    fun breath(): String
}


open class MonsterWithWeapon(
    name: String,
    age: Int,
    hp: Int,
    attackPower: Int,
    var weapon: String,
    open var weaponATK: Int = (attackPower * 1.5).toInt()
) : Monster(
    name = name,
    age = age,
    hp = hp,
    attackPower = attackPower,
) {
    fun attackWithWeapon(): String = "$name beat you with the $weapon!"
}

class Zombie(
    name: String,
    age: Int,
    override var hp: Int  = (5 * (age * 0.5)).toInt(),
    attackPower: Int,
    weapon: String,
    weaponATK: Int,
    val attackBoostFactor: Int = 2,
) : MonsterWithWeapon(
    name = name,
    age = age,
    hp = hp,
    attackPower = attackPower,
    weapon = weapon,
    weaponATK = weaponATK,
) {
    fun boost() {
        attackPower *= attackBoostFactor
        weaponATK *= attackBoostFactor
    }

    fun battleCry(): String {
        boost()
        return "$name is crying HRAAARHH!!!!"
    }
}

class DeadKnight(
    name: String,
    age: Int,
    override var hp: Int  = (15 * (age * 0.5)).toInt(),
    attackPower: Int,
    weapon: String,
    val skillWithWeapon: Double = 1.5,
    override var weaponATK: Int = (attackPower * 1.5 * skillWithWeapon).toInt()
) : MonsterWithWeapon(
    name = name,
    age = age,
    hp = hp,
    attackPower = attackPower,
    weapon = weapon,
    weaponATK = weaponATK,
) {

    fun resurrection(): String {
        hp = (15 * (age * 0.5)).toInt()
        return "Knight is alive again!"
    }
}