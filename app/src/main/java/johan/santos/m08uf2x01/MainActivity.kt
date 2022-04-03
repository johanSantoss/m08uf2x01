package johan.santos.m08uf2x01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import johan.santos.m08uf2x01.ex1.Ejercicio1Activity
import johan.santos.m08uf2x01.ex2.Ejercicio2Activity
import johan.santos.m08uf2x01.ex3.Ejercicio3Activity
import johan.santos.m08uf2x01.ex4.Ejercicio4Activity
import johan.santos.m08uf2x01.ex5.Ejercicio5Activity
import johan.santos.m08uf2x01.ex6.Ejercicio6Activity
import johan.santos.m08uf2x01.ex7.Ejercicio7Activity
import johan.santos.m08uf2x01.ex8.Ejercicio8Activity
import johan.santos.m08uf2x01.ex9.Ejercicio9Activity

class MainActivity : AppCompatActivity() {
    lateinit var bEjer1 : Button
    lateinit var bEjer2 : Button
    lateinit var bEjer3 : Button
    lateinit var bEjer4 : Button
    lateinit var bEjer5 : Button
    lateinit var bEjer6 : Button
    lateinit var bEjer7 : Button
    lateinit var bEjer8 : Button
    lateinit var bEjer9 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bEjer1 = findViewById(R.id.btnProximity)
        bEjer2 = findViewById(R.id.btnLight)
        bEjer3 = findViewById(R.id.btnPressure)
        bEjer4 = findViewById(R.id.btnEjer4)
        bEjer5 = findViewById(R.id.btnEjer5)
        bEjer6 = findViewById(R.id.btnEjer6)
        bEjer7 = findViewById(R.id.btnEjer7)
        bEjer8 = findViewById(R.id.btnEjer8)
        bEjer9 = findViewById(R.id.btnEjer9)

        bEjer1.setOnClickListener {
            val next = Intent(this, Ejercicio1Activity::class.java)
            startActivity(next)
        }
        bEjer2.setOnClickListener {
            val next = Intent(this, Ejercicio2Activity::class.java)
            startActivity(next)
        }
        bEjer3.setOnClickListener {
            val next = Intent(this, Ejercicio3Activity::class.java)
            startActivity(next)
        }
        bEjer4.setOnClickListener {
            val next = Intent(this, Ejercicio4Activity::class.java)
            startActivity(next)
        }
        bEjer5.setOnClickListener {
            val next = Intent(this, Ejercicio5Activity::class.java)
            startActivity(next)
        }
        bEjer6.setOnClickListener {
            val next = Intent(this, Ejercicio6Activity::class.java)
            startActivity(next)
        }
        bEjer7.setOnClickListener {
            val next = Intent(this, Ejercicio7Activity::class.java)
            startActivity(next)
        }
        bEjer8.setOnClickListener {
            val next = Intent(this, Ejercicio8Activity::class.java)
            startActivity(next)
        }
        bEjer9.setOnClickListener {
            val next = Intent(this, Ejercicio9Activity::class.java)
            startActivity(next)
        }
    }
}