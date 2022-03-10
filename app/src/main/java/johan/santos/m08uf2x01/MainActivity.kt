package johan.santos.m08uf2x01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.Button
import johan.santos.m08uf2x01.ex1.Ejercicio1Activity
import johan.santos.m08uf2x01.ex2.Ejercicio2Activity
import johan.santos.m08uf2x01.ex3.Ejercicio3Activity
import johan.santos.m08uf2x01.ex4.Ejercicio4Activity

class MainActivity : AppCompatActivity() {
    lateinit var bEjer1 : Button
    lateinit var bEjer2 : Button
    lateinit var bEjer3 : Button
    lateinit var bEjer4 : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bEjer1 = findViewById(R.id.btnEjer1)
        bEjer2 = findViewById(R.id.btnEjer2)
        bEjer3 = findViewById(R.id.btnEjer3)
        bEjer4 = findViewById(R.id.btnEjer4)

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

    }
}