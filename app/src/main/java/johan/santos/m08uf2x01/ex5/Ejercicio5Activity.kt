package johan.santos.m08uf2x01.ex5

import johan.santos.m08uf2x01.databinding.ActivityEjercicio5Binding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.media.MediaPlayer
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.util.Log
import johan.santos.m08uf2x01.R
import java.util.*


class Ejercicio5Activity : AppCompatActivity(), TextToSpeech.OnInitListener  {

    private lateinit var mp: MediaPlayer
    private lateinit var binding: ActivityEjercicio5Binding
    lateinit var tts: TextToSpeech
    private var posicionAudio = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio5)

        mp = MediaPlayer.create(this, R.raw.numeros)
        binding = ActivityEjercicio5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStartAudio.setOnClickListener {
            if (binding.txTextoToVoz.text.toString().equals("")) {
                Log.d("Ejercicio5Activity", "audio-start")
                mp.start()
                Log.d("Ejercicio5Activity", "audio-midd")
                mp.isLooping = binding.btnLoopAudio.text != "No reproducir en forma circular"
                Log.d("Ejercicio5Activity", "audio-end")
            } else parlar()
        }

        binding.btnPauseAudio.setOnClickListener {
            if (mp.isPlaying) {
                // guardamos la posición donde lo paramos
                posicionAudio = mp.currentPosition
                mp.pause()
            }
        }

        binding.btnContinueAudio.setOnClickListener {
            if (!mp.isPlaying) {
                // nos colocamos en la posicion indicada
                mp.seekTo(posicionAudio)
                mp.start()
            }
        }

        binding.btnStopAudio.setOnClickListener {
            mp.pause()
            posicionAudio = 0
            mp.seekTo(0)
        }

        binding.btnLoopAudio.setOnClickListener {
            if (binding.btnLoopAudio.text  == "No reproducir en forma circular") {
                binding.btnLoopAudio.text = "Reproducir en forma circular"
                mp.isLooping = true
            } else{
                binding.btnLoopAudio.text = "No reproducir en forma circular"
                mp.isLooping = false
            }
        }

        tts = TextToSpeech(this, this)

        val speechListener = object : UtteranceProgressListener() {
            // https://developer.android.com/reference/kotlin/android/speech/tts/UtteranceProgressListener
            override fun onStart(p: String?) {
                binding.btnStartAudio.post {
                    disableButtons()
                }
            }

            override fun onDone(p: String?) {
                binding.btnStartAudio.post {
                    enableButtons()
                }
            }

            override fun onError(p: String?) {
                binding.btnStartAudio.post {
                    enableButtons()
                }
            }
        }

        tts.setOnUtteranceProgressListener(speechListener)

    }

    private fun enableButtons(){
        binding.btnStartAudio.isEnabled = true
        binding.btnPauseAudio.isEnabled = true
        binding.btnContinueAudio.isEnabled = true
        binding.btnStopAudio.isEnabled = true
        binding.btnLoopAudio.isEnabled = true
    }

    private fun disableButtons(){
        binding.btnStartAudio.isEnabled = false
        binding.btnPauseAudio.isEnabled = false
        binding.btnContinueAudio.isEnabled = false
        binding.btnStopAudio.isEnabled = false
        binding.btnLoopAudio.isEnabled = false
    }

    private fun parlar(){
        Log.d("Ejercicio5Activity", "parlar-start")
        val text = binding.txTextoToVoz.text
        Log.d("Ejercicio5Activity", "parlar-mid")
        // https://developer.android.com/reference/android/speech/tts/TextToSpeech --> constants
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
        Log.d("Ejercicio5Activity", "parlar-end")
    }

    override fun onDestroy() {
        super.onDestroy()
        mp.release()

        // Shutdown TTS
        if (tts != null) {
            tts!!.stop()
            tts!!.shutdown()
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            // set US English as language for tts
            val result = tts!!.setLanguage(Locale.getDefault())

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS","The Language specified is not supported!")
            }

        } else {
            Log.e("TTS", "Initilization Failed!")
        }
    }
}