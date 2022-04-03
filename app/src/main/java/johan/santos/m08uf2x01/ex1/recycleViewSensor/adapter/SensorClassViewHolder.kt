package johan.santos.m08uf2x01.ex1.recycleViewSensor.adapter

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import johan.santos.m08uf2x01.databinding.ItemSensorBinding
import johan.santos.m08uf2x01.ex1.recycleViewSensor.SensorClass

class SensorClassViewHolder (view : View) : RecyclerView.ViewHolder(view) {

    val binding = ItemSensorBinding.bind(view)

    fun render (sensorItem : SensorClass, onClickListener: (SensorClass) -> Unit) {
        binding.tvItemSensorName.text = sensorItem.name
        binding.tvItemSensorType.text = sensorItem.sensorType
        binding.tvItemSensorPower.text= sensorItem.power
        Glide.with(binding.ivSensor.context).load(sensorItem.photo).into(binding.ivSensor)

        binding.ivSensor.setOnClickListener {
            Toast.makeText(binding.ivSensor.context, sensorItem.sensorType, Toast.LENGTH_SHORT).show()
        }

        itemView.setOnClickListener {
            onClickListener(sensorItem)
        }
    }

}