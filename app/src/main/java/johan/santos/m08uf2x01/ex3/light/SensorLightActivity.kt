package johan.santos.m08uf2x01.ex3.light

import android.annotation.SuppressLint
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Switch
import android.widget.TextView
import johan.santos.m08uf2x01.R

class SensorLightActivity : AppCompatActivity(), SensorEventListener {

    lateinit var swAgafa: Switch
    lateinit var tvTotal : TextView
    lateinit var tvMoment: TextView
    private lateinit var sensorManager: SensorManager
    lateinit var sensor: Sensor
    lateinit var progressBar: ProgressBar

    companion object {
        const val MAX_VALUE = 1000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor_light)

        tvTotal = findViewById(R.id.tvTotalValue)
        tvMoment = findViewById(R.id.tvMoment)
        swAgafa = findViewById(R.id.swSensor)
        progressBar = findViewById(R.id.progressBar)

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)

        // estado progressBar
        progressBar.progress = 0
        progressBar.max      = MAX_VALUE

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
            //tvTotal.text = String.format ("%.3f", event.values[0])
            tvTotal.text = event.values[0].toString() + " lx"

            if (event.values[0].toInt() <= MAX_VALUE) progressBar.progress = event.values[0].toInt()

            when (event.values[0].toInt()) {
                in 0..10        -> tvMoment.text = "Dark"
                in 11..50       -> tvMoment.text = "Grey"
                in 51..100      -> tvMoment.text = "Normal"
                in 101..1000    -> tvMoment.text = "Incredibly light"
                else            -> {
                    tvMoment.text = "This light will blind you"
                    progressBar.progress = MAX_VALUE
                }
            }
        }else{
            clearValues()
        }
    }

    private fun clearValues(){
        tvTotal.text    = ""
        tvMoment.text   = ""
        progressBar.progress = 0
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
//        TODO("Not yet implemented")
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

}