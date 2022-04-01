package johan.santos.m08uf2x01.ex1

import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import johan.santos.m08uf2x01.R

class Ejercicio1Activity : AppCompatActivity() {
    // variable de sensor
    private var mSensorManager: SensorManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio1)

        // Get the sensor service and retrieve the list of sensors.
        mSensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        val sensorList = mSensorManager!!.getSensorList(Sensor.TYPE_ALL)

        // Iterate through the list of sensors, get the sensor name,
        // append it to the string.
        val sensorText = StringBuilder()
        //String sensorText = "";
        for (currentSensor in sensorList) {
            sensorText.append(currentSensor.name).append(
                System.getProperty("line.separator")
            )
            sensorText.append("type: " + currentSensor.stringType ).append(
                System.getProperty("line.separator")
            )
            sensorText.append("power: " + currentSensor.power).append(
                System.getProperty("line.separator")
            )
            sensorText.append("resolution: " + currentSensor.resolution).append(
                System.getProperty("line.separator")
            )
            sensorText.append("------------------------------").append(
                System.getProperty("line.separator")
            )
        }

        // Update the sensor list text view to display the list of sensors.
        val sensorTextView = findViewById<View>(R.id.sensor_list) as TextView
        sensorTextView.text = sensorText

    }
}