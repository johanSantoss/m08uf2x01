package johan.santos.m08uf2x01.ex3.temperature.ambient

import android.annotation.SuppressLint
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import android.widget.TextView
import johan.santos.m08uf2x01.R

class SensorAmbientTemperatureActivity : AppCompatActivity(), SensorEventListener {

    lateinit var swAgafa: Switch
    lateinit var tvTotal : TextView
    private lateinit var sensorManager: SensorManager
    lateinit var sensor: Sensor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor_ambient_temperature)

        tvTotal = findViewById(R.id.tvTotalValue)
        swAgafa = findViewById(R.id.swSensor)

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)

        swAgafa.setOnCheckedChangeListener { buttonView, isChecked ->
            if( isChecked ){
                sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
            }else{
                sensorManager.unregisterListener(this)
                clearValues()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        clearValues()
    }

    @SuppressLint("SetTextI18n")
    override fun onSensorChanged(event: SensorEvent?) {
        if (event != null) {
            // value
            //tvTotal.text = String.format ("%.3f", event.values[0])
            tvTotal.text = event.values[0].toString() + "ºC"
        }else{
            clearValues()
        }
    }

    private fun clearValues(){
        tvTotal.text    = ""
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
//        TODO("Not yet implemented")
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

}