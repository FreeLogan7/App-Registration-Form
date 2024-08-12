package com.freedman.funregistrationform

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView.Adapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSpinner()

        button_preview.setOnClickListener {
            buttonClicked()
        }

    }


    private fun setSpinner() {
        val titleArray: Array<String> = arrayOf("Miss", "Mrs", "Ms", "Mx", "Mr", "Dr", "Prof")
        val myAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, titleArray)
        spinner_title.adapter = myAdapter
    }

    private fun buttonClicked() {
            val information = Information(
                spinner_title.selectedItem?.toString(),
                edit_text_firstname.text.toString(),
                edit_text_lastname.text.toString(),
                edit_text_email.text.toString(),
                edit_text_phone.text.toString().toLong(),
                edit_text_password.text.toString()
            )

            val activityIntent = Intent(this, PreviewActivity::class.java)
            activityIntent.putExtra("Info", information)
            startActivity(activityIntent)
    }


}


/*
1) I want to connect this page to the id's on activity_main
2) when clicking the button, i want it to use an intent to move to the next page
3) Create an onclick method



 */