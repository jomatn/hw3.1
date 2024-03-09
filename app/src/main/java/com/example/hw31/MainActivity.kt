package com.example.hw31

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etEmail = findViewById<EditText>(R.id.email)
        val etTheme = findViewById<EditText>(R.id.theme)
        val etText = findViewById<EditText>(R.id.text)
        val sendButton = findViewById<Button>(R.id.button)

        sendButton.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val theme = etTheme.text.toString().trim()
            val text = etText.text.toString().trim()


            val uriString = "mailto:$email?subject=${Uri.encode(theme)}&body=${Uri.encode(text)}"
            val mIntent = Intent(Intent.ACTION_SENDTO, Uri.parse(uriString))



            try {
                startActivity(mIntent)
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }
    }
}
