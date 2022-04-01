package johan.santos.m08uf2x01.ex3

import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import johan.santos.m08uf2x01.R
import johan.santos.m08uf2x01.ex3.light.SensorLightActivity
import johan.santos.m08uf2x01.ex3.proximity.SensorProximityActivity
import johan.santos.m08uf2x01.ex3.temperature.ambient.SensorAmbientTemperatureActivity
import johan.santos.m08uf2x01.ex3.temperature.device.SensorTemperatureActivity

class Ejercicio3Activity : AppCompatActivity() {

    private lateinit var btnTemperature         : Button
    private lateinit var btnAmbient_Temperature : Button
    private lateinit var btnLight               : Button
    private lateinit var btnProximity           : Button

    private lateinit var sensorManager: SensorManager
    private  var sensor: Sensor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio3)

        btnTemperature = findViewById(R.id.btnTemperature)
        btnAmbient_Temperature = findViewById(R.id.btnAbiemtTemperature)
        btnLight = findViewById(R.id.btnLight)
        btnProximity = findViewById(R.id.btnProximity)

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager

        btnTemperature.setOnClickListener {
            sensor = sensorManager.getDefaultSensor(Sensor.TYPE_TEMPERATURE)

            if (sensor != null){
                val next = Intent(this, SensorTemperatureActivity::class.java)
                startActivity(next)
            } else {
                Toast.makeText(applicationContext, "Not have Temperature Sensor", Toast.LENGTH_LONG).show()
            }
        }
        btnAmbient_Temperature.setOnClickListener {
            sensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)

            if (sensor != null){
                val next = Intent(this, SensorAmbientTemperatureActivity::class.java)
                startActivity(next)
            } else {
                Toast.makeText(applicationContext, "Not have Ambient_Temperature Sensor", Toast.LENGTH_LONG).show()
            }
        }
        btnLight.setOnClickListener {
            sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)

            if (sensor != null){
                val next = Intent(this, SensorLightActivity::class.java)
                startActivity(next)
            } else {
                Toast.makeText(applicationContext, "Not have Light Sensor", Toast.LENGTH_LONG).show()
            }
        }
        btnProximity.setOnClickListener {
            sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)

            if (sensor != null){
                val next = Intent(this, SensorProximityActivity::class.java)
                startActivity(next)
            } else {
                Toast.makeText(applicationContext, "Not have Proximity Sensor", Toast.LENGTH_LONG).show()
            }
        }


    }
}