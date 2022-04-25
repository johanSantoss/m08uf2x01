package johan.santos.m08uf2x01.ex8.mailAndFile

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import johan.santos.m08uf2x01.R
import johan.santos.m08uf2x01.databinding.ActivityMailAndFileBinding

class MailAndFileActivity : AppCompatActivity() {

    private lateinit var email: String
    private lateinit var subject: String
    private lateinit var message: String
    private lateinit var uri: Uri
    private lateinit var binding : ActivityMailAndFileBinding
    private val pickFromGallery:Int = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mail_and_file)

        binding = ActivityMailAndFileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "KotlinApp"

        binding.btSend.setOnClickListener { sendEmail() }
        binding.btAttachment.setOnClickListener {
            openFolder()
        }
    }

    private fun openFolder() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        intent.putExtra("return-data", true)
        startActivityForResult(Intent.createChooser(intent, "Complete action using"), pickFromGallery)
    }

    private fun sendEmail() {
        try {
            email   = binding.etTo.text.toString()
            subject = binding.etSubject.text.toString()
            message = binding.etMessage.text.toString()

            val toEmail = email.split(",".toRegex()).toTypedArray()

            val emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.type = "plain/text"

            // pasar el text del "email" to Array con "arrayOf"
//            emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
            emailIntent.putExtra(Intent.EXTRA_EMAIL, toEmail)
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
            emailIntent.putExtra(Intent.EXTRA_STREAM, uri)
            emailIntent.putExtra(Intent.EXTRA_TEXT, message)
            this.startActivity(Intent.createChooser(emailIntent, "Sending email..."))
        }
        catch (t: Throwable) {
            Toast.makeText(this, "Request failed try again: $t", Toast.LENGTH_LONG).show()
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == pickFromGallery && resultCode == RESULT_OK) {
            if (data != null) {
                uri = data.data!!
            }
            binding.tvAttachment.text = uri.lastPathSegment
            binding.tvAttachment.visibility = View.VISIBLE
        }
    }

}