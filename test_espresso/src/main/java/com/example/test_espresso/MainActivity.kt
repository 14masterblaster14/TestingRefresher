package com.example.test_espresso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.R
import android.app.Activity
import android.view.View
import android.widget.Button
import com.example.test_espresso.databinding.ActivityMainBinding
import androidx.core.app.ActivityCompat.startActivityForResult

import android.provider.AlarmClock.EXTRA_MESSAGE

import android.content.Intent
import android.provider.AlarmClock
import android.util.Log
import android.widget.EditText
import androidx.core.content.PackageManagerCompat

import androidx.core.content.PackageManagerCompat.LOG_TAG





class MainActivity : AppCompatActivity() {

    // Textview to show the language
    // chosen by the user
    //var preferred_language: TextView? = null
    private lateinit var binding: ActivityMainBinding
    private lateinit var inputMessage: EditText
    private lateinit var outputMessage: TextView

    companion object{
        // Class name for Log tag
        private val LOG_TAG = MainActivity::class.java.simpleName

        // Unique tag required for the intent extra
        val EXTRA_MESSAGE = "com.example.test_espresso.extra.MESSAGE"

        // Unique tag for the intent reply
        val TEXT_REQUEST = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        // initializing the textview
        //preferred_language = findViewById(R.id.preferred_language);
        inputMessage = binding.editTextMain
        outputMessage = binding.textMessageReply
        setContentView(binding.root)
    }

    // onClick is called whenever
    // a user clicks a button
    fun onClick(view: View) {

        // whenever a user chooses a preferred language
        // by tapping button, it changes the chosen
        // language textView
        when (view.id) {
            binding.english.id -> binding.preferredLanguage!!.text = "English"
            binding.french.id -> binding.preferredLanguage!!.text = "French"
            binding.german.id  -> binding.preferredLanguage!!.text = "German"
            binding.hindi.id  -> binding.preferredLanguage!!.text = "Hindi"
            binding.urdu.id  -> binding.preferredLanguage!!.text = "Urdu"
        }
    }

    /**
     * Handles the onClick for the "Send" button. Gets the value of the main EditText,
     * creates an intent, and launches the second activity with that intent.
     *
     * The return intent from the second activity is onActivityResult().
     *
     * @param view The view (Button) that was clicked.
     */
    fun launchSecondActivity(view: View?) {
        Log.d(LOG_TAG, "Button clicked!")
        val intent = Intent(this, SecondActivity::class.java)
        val message: String = inputMessage.text.toString()
        Log.i(LOG_TAG,"message:- $message")
        intent.putExtra(EXTRA_MESSAGE, message)
        startActivityForResult(intent, TEXT_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Test for the right intent reply.
        if (requestCode == TEXT_REQUEST) {
            // Test to make sure the intent reply result was good.
            if (resultCode == RESULT_OK) {
                val reply = data?.getStringExtra(SecondActivity.EXTRA_REPLY)

                // Make the reply head visible.
                binding.textHeaderReply.setVisibility(View.VISIBLE)

                // Set the reply and make it visible.
                outputMessage.setText(reply)
                outputMessage.setVisibility(View.VISIBLE)
            }
        }
    }

}