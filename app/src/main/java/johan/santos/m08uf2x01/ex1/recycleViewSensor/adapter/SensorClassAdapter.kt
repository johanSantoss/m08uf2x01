package johan.santos.m08uf2x01.ex1.recycleViewSensor.adapter

import android.service.autofill.OnClickAction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import johan.santos.m08uf2x01.R
import johan.santos.m08uf2x01.ex1.recycleViewSensor.SensorClass

class SensorClassAdapter (private val llistaSensors : MutableList<SensorClass>, private val onClickListener: (SensorClass) -> Unit) : RecyclerView.Adapter<SensorClassViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SensorClassViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SensorClassViewHolder(layoutInflater.inflate(R.layout.item_sensor, parent, false))
    }

    override fun onBindViewHolder(holder: SensorClassViewHolder, position: Int) {
        val item = llistaSensors[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = llistaSensors.size
}