package johan.santos.m08uf2x01.ex2

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import johan.santos.m08uf2x01.R

class Ejercicio2Activity() : AppCompatActivity(), SensorEventListener {

    lateinit var swAgafa: Switch
    lateinit var tvX: TextView
    lateinit var tvY: TextView
    lateinit var tvZ: TextView
    lateinit var tvTotal: TextView
    lateinit var radioGroup : RadioGroup
    private lateinit var sensorManager: SensorManager
    lateinit var sensor: Sensor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio2)

        tvX = findViewById(R.id.tvX)
        tvY = findViewById(R.id.tvY)
        tvZ = findViewById(R.id.tvZ)
        tvTotal = findViewById(R.id.tvTotal)
        radioGroup = findViewById(R.id.radioG)
        swAgafa = findViewById(R.id.swSensor)

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.radioButton2){
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
            } else if (checkedId == R.id.radioButton){
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)
            }
        }

        swAgafa.setOnCheckedChangeListener { buttonView, isChecked ->
            if( isChecked ){
                // sensorManager.unregisterListener(this)
                sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
            }else{
                // sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
                sensorManager.unregisterListener(this)
                clearTextBox()
            }
        }


    }

    override fun onResume() {
        super.onResume()
        /*sensor?.also { acceleracion ->
            sensorManager.registerListener(this, sensor , SensorManager.SENSOR_DELAY_NORMAL)
        }*/
        clearTextBox()
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event != null) {
            tvX.text = String.format ("%.3f", event.values[0])
            tvY.text = String.format ("%.3f", event.values[1])
            tvZ.text = String.format ("%.3f", event.values[2])
            tvTotal.text = String.format ("%.3f", Math.sqrt( 1.0 * (event.values[0] * event.values[0] + event.values[1] * event.values[1] + event.values[2] * event.values[2])))
        }else{
            clearTextBox()
        }
    }

    private fun clearTextBox(){
        tvX.text = ""
        tvY.text = ""
        tvZ.text = ""
        tvTotal.text = ""
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
//        TODO("Not yet implemented")
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }



}