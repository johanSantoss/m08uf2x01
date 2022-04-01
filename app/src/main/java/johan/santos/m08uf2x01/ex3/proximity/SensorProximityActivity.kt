package johan.santos.m08uf2x01.ex3.proximity

import android.annotation.SuppressLint
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.WindowManager
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import johan.santos.m08uf2x01.R


class SensorProximityActivity : AppCompatActivity(), SensorEventListener {

    lateinit var swAgafa: Switch
    lateinit var tvTotal : TextView
    lateinit var tvMoment: TextView
    private lateinit var sensorManager: SensorManager
    lateinit var sensor: Sensor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor_proximity)

        tvTotal = findViewById(R.id.tvTotalValue)
        tvMoment = findViewById(R.id.tvMoment)
        swAgafa = findViewById(R.id.swSensor)

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)



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
            tvTotal.text = event.values[0].toString() + " cm"

            val params: WindowManager.LayoutParams = this.window.attributes
            /*
            screenBrightness -> valor del brillo entre 0.0F - 1.0F
             */

            // set estado
            if (event.values[0].toInt() == 0) {
                tvMoment.text = "Estás pegado!"
                params.flags = params.flags or WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                params.screenBrightness = 0F
                window.attributes = params
            } else {
                tvMoment.text = "Estás lejos !"
                params.flags = params.flags or WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                params.screenBrightness = 1f
                window.attributes = params
            }
        }else{
            clearValues()
        }
    }

    private fun clearValues(){
        tvTotal.text    = ""
        tvMoment.text   = ""
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
//        TODO("Not yet implemented")
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

}