package johan.santos.m08uf2x01.ex9

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import johan.santos.m08uf2x01.R
import johan.santos.m08uf2x01.databinding.ActivityEjercicio1Binding
import johan.santos.m08uf2x01.databinding.ActivityEjercicio9Binding

class Ejercicio9Activity : AppCompatActivity() {

    private lateinit var binding : ActivityEjercicio9Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio9)

        binding = ActivityEjercicio9Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            // Search for restaurants nearby
            val gmmIntentUri = Uri.parse("geo:0,0?q=restaurants")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

        binding.btn2.setOnClickListener {
            // Search for restaurants in San Francisco
            val gmmIntentUri =
                Uri.parse("geo:37.7749,-122.4194?q=restaurants")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }
        binding.btn3.setOnClickListener {
            val gmmIntentUri =
                Uri.parse("geo:37.7749,-122.4194?z=10&q=restaurants")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }
        binding.btn4.setOnClickListener {
            // specific localization
            val gmmIntentUri =
                Uri.parse("geo:0,0?q=1600 Amphitheatre Parkway, Mountain+View, California")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }
        binding.btn5.setOnClickListener {
            // Create a Uri from an intent string. Use the result to create an Intent.
            val gmmIntentUri = Uri.parse("google.streetview:cbll=46.414382,10.013988")

            // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            // Make the Intent explicit by setting the Google Maps package
            mapIntent.setPackage("com.google.android.apps.maps")

            // Attempt to start an activity that can handle the Intent
            startActivity(mapIntent)
        }
        binding.btn6.setOnClickListener {
            val gmmIntentUri =
                Uri.parse("geo:0,0?q=casa")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }
        binding.btn7.setOnClickListener {
            // Display the location of Google, San Francisco using a global plus code.
            var gmmIntentUri = Uri.parse("http://plus.codes/HX9W+WG3, Terrassa")
            // Equivalently, define the same location using a local plus code
            //val gmmIntentUri = Uri.parse("https://plus.codes/QJQ5+XX,San%20Francisco")
            // Construct and use the Intent as in the examples above
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }
        binding.btn8.setOnClickListener {
            val gmmIntentUri =
                Uri.parse("google.navigation:q=copernic")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }
        binding.btn9.setOnClickListener {
            val gmmIntentUri =
                Uri.parse("google.navigation:q=8+carrer de torrent del batlle, terrassa, barcelona, spain")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }
        binding.btn10.setOnClickListener {

        }
        binding.btn11.setOnClickListener {

        }
    }
}