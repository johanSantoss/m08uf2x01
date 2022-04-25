package johan.santos.m08uf2x01.ex8.mail

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import johan.santos.m08uf2x01.R
import johan.santos.m08uf2x01.databinding.ActivityMailBinding

class MailActivity : AppCompatActivity() {

    lateinit var emails: String
    lateinit var subject: String
    lateinit var message: String
    private lateinit var binding : ActivityMailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mail)

        binding = ActivityMailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // enviar mail abriendo un selector de App para el mail
        binding.buttonSend.setOnClickListener {
            getData()

            val toEmail = emails.split(",".toRegex()).toTypedArray()

            val intent = Intent(Intent.ACTION_SEND)

            intent.putExtra(Intent.EXTRA_EMAIL, toEmail)
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TEXT, message)

            intent.type = "message/rfc822"
            startActivity(Intent.createChooser(intent, "Select email"))
        }

        // emviar mail aabriendo el mail directamente
        binding.buttonSend2.setOnClickListener {
            getData()

            val toEmail = emails.split(",".toRegex()).toTypedArray()

            val intent = Intent(Intent.ACTION_SENDTO).apply {

                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, toEmail)
                putExtra(Intent.EXTRA_SUBJECT, subject)
                putExtra(Intent.EXTRA_TEXT, message)
            }

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }

    }

    private fun getData() {
        emails  = binding.editTextMail.text.toString()
        subject = binding.editTextSubject.text.toString()
        message = binding.editTextMessage.text.toString()
    }

}