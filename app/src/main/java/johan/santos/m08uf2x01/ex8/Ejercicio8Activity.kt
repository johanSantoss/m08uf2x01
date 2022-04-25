package johan.santos.m08uf2x01.ex8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import johan.santos.m08uf2x01.R
import johan.santos.m08uf2x01.databinding.ActivityEjercicio8Binding
import johan.santos.m08uf2x01.databinding.ActivityMailBinding
import johan.santos.m08uf2x01.ex2.Ejercicio2Activity
import johan.santos.m08uf2x01.ex8.mail.MailActivity
import johan.santos.m08uf2x01.ex8.mailAndFile.MailAndFileActivity

class Ejercicio8Activity : AppCompatActivity() {

    private lateinit var binding : ActivityEjercicio8Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_ejercicio8)

        binding = ActivityEjercicio8Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEmail.setOnClickListener {
            val next = Intent(this, MailActivity::class.java)
            startActivity(next)
        }

        binding.btnEmailFile.setOnClickListener {
            val next = Intent(this, MailAndFileActivity::class.java)
            startActivity(next)
        }

    }
}