package com.freedman.funregistrationform

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.button_preview
import kotlinx.android.synthetic.main.activity_main.edit_text_firstname
import kotlinx.android.synthetic.main.activity_main.edit_text_lastname
import kotlinx.android.synthetic.main.activity_preview.text_view_email
import kotlinx.android.synthetic.main.activity_preview.text_view_name
import kotlinx.android.synthetic.main.activity_preview.text_view_password
import kotlinx.android.synthetic.main.activity_preview.text_view_phone_Number
import kotlinx.android.synthetic.main.activity_preview.text_view_title

class PreviewActivity : AppCompatActivity() {

    private lateinit var information: Information

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)

        displayMessage()

        listenforClicks()


    }

    private fun listenforClicks() {

        text_view_email.setOnClickListener(){
            val intentEmail = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto: ${information.email}") // Only email apps handle this.
                putExtra(Intent.EXTRA_SUBJECT, information.title)
            }
                    startActivity(intentEmail)
        }



        text_view_phone_Number.setOnClickListener(){
                val intentPhone = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("smsto: ${information.phone}")
                    putExtra("sms_body", information.lastName )
                }
            startActivity(intentPhone)
        }

    }

    private fun displayMessage() {
        information = intent.getSerializableExtra("Info") as Information

        text_view_name.text = "${information.title} ${information.firstName} ${information.lastName}"
        text_view_email.text = "Email: ${information.email}"
        text_view_password.text = "password: ${information.password}"
        text_view_phone_Number.text = "Phone Number: ${information.phone}"
    }

}