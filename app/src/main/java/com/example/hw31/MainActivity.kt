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

        val anEmail = findViewById<EditText>(R.id.email)
        val theTheme = findViewById<EditText>(R.id.theme)
        val allText = findViewById<EditText>(R.id.text)
        val sendButton = findViewById<Button>(R.id.button)

        sendButton.setOnClickListener {
            val email = anEmail.text.toString().trim()
            val theme = theTheme.text.toString().trim()
            val text = allText.text.toString().trim()



            val mIntent = Intent(Intent.ACTION_SENDTO)
            mIntent.data = Uri.parse("mailto:" + email)
            mIntent.putExtra(Intent.EXTRA_SUBJECT, theme)
            mIntent.putExtra(Intent.EXTRA_TEXT, text)



            try {
                startActivity(mIntent)
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }}
    }
}
