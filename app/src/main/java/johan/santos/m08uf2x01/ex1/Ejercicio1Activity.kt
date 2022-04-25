package johan.santos.m08uf2x01.ex1

import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import johan.santos.m08uf2x01.R
import johan.santos.m08uf2x01.databinding.ActivityEjercicio1Binding
import johan.santos.m08uf2x01.ex1.recycleViewSensor.SensorClass
import johan.santos.m08uf2x01.ex1.recycleViewSensor.adapter.SensorClassAdapter

class Ejercicio1Activity : AppCompatActivity() {
    // Variable de sensor
    private var mSensorManager: SensorManager? = null
    private val llistaSensors : MutableList<SensorClass> = mutableListOf()
    private lateinit var binding : ActivityEjercicio1Binding

    companion object{
        const val PATH_PHOTO = "https://somoviles.files.wordpress.com/2014/08/androidf6o.jpg"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio1)

        binding = ActivityEjercicio1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get the sensor service and retrieve the list of sensors.
        mSensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        val sensorList: MutableList<Sensor> = mSensorManager!!.getSensorList(Sensor.TYPE_ALL)

        // generar lista de "SensorClass"
        reloadListSensor(sensorList)
        // inicializar el recycler view
        initRecycleView()

    }

    private fun reloadListSensor(sensorList: MutableList<Sensor>){
        for (currentSensor in sensorList) {
            // obtener un valor del array del "Split" generado
            val typeSensor = currentSensor.stringType.split(".").get(currentSensor.stringType.split(".").size-1)
            // generar el sen
            val sensorItem = SensorClass(currentSensor.name, typeSensor, "" + currentSensor.power, PATH_PHOTO)
            llistaSensors.add(sensorItem)
        }
    }

    private fun initRecycleView() {
        //val manager = GridLayoutManager(this, 2)
        val manager = LinearLayoutManager(this)
        //val decoration = DividerItemDecoration(this, manager.orientation)
        binding.recyclerSensors.layoutManager = manager
        binding.recyclerSensors.adapter = SensorClassAdapter(llistaSensors) { sensorSelected ->
            onItemSelected(
                sensorSelected
            )
        }
        //binding.recyclerSensors.addItemDecoration(decoration)
    }

    fun onItemSelected (sensorSelected : SensorClass){
        Toast.makeText(this, "Has seleccionado el item: " + sensorSelected.name, Toast.LENGTH_SHORT).show()
    }



}