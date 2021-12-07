package com.example.test_espresso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.R
import android.app.Activity

import android.widget.TextView

import android.content.Intent
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.test_espresso.databinding.ActivityMainBinding
import com.example.test_espresso.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    companion object {
        private val TAG = SecondActivity::class.java.simpleName

        // Unique tag for the intent reply.
        val EXTRA_REPLY = "com.example.test_espresso.extra.REPLY"

        // Tags to be used as the keys in OnSavedInstanceState
        const val STATE_SCORE_1 = "Team 1 Score"
        const val STATE_SCORE_2 = "Team 2 Score"
    }

    private lateinit var binding: ActivitySecondBinding
    private var mSpinnerLabel = ""

    // Member variables for holding the score
    private var mScore1 = 0
    private var mScore2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)


        setContentView(binding.root)
        //setContentView(R.layout.activity_second)

        // Get the intent that launched this activity, and the message in the intent extra.
        val intent = intent
        val message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)

        // Put that message into the text_message TextView
        binding.textMessage.text = message

        // Create the spinner.
        val spinner = binding.labelSpinner
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

        // Create ArrayAdapter using the string array and default spinner layout.
        val adapter: ArrayAdapter<CharSequence> =
            ArrayAdapter.createFromResource(
                this,
                com.example.test_espresso.R.array.labels_array,
                android.R.layout.simple_spinner_item
            )

        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter)

        }

        // Restores the scores if there is savedInstanceState.
        if (savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1)
            mScore2 = savedInstanceState.getInt(STATE_SCORE_2)

            //Set the score text views
            binding.score1.text = mScore1.toString()
            binding.score2.text = mScore2.toString()
        }

    }

    /**
     * Handles the onClick for the "Reply" button. Gets the message from the
     * second EditText, creates an intent, and returns that message back to
     * the main activity.
     *
     * @param view The view (Button) that was clicked.
     */
    fun returnReply(view: View?) {
        // Get the reply message from the edit text.
        val reply: String = binding.editTextSecond.text.toString()

        // Create a new intent for the reply, add the reply message to it
        // as an extra, set the intent result, and close the activity.
        val replyIntent = Intent()
        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(RESULT_OK, replyIntent)
        finish()
    }

    override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, p2: Int, p3: Long) {
        mSpinnerLabel = adapterView?.getItemAtPosition(p2).toString()
        showText(view)
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        Log.d(TAG, "onNothingSelected: ");
    }

    fun showText(view: View?) {
        binding.editTextMain?.let {
            // Assign to showString both the entered string and mSpinnerLabel.
            val showString = it.text.toString() + " - " + mSpinnerLabel
            // Display a Toast message with showString
            Toast.makeText(this, showString, Toast.LENGTH_SHORT).show()
            // Set the TextView to showString.
            binding.textPhonelabel.text = showString

        }
    }


    /**
     * Handles the onClick of both the decrement buttons.
     *
     * @param view The button view that was clicked
     */
    fun decreaseScore(view: View) {
        // Get the ID of the button that was clicked.
        val viewID = view.id
        when (viewID) {
            binding.decreaseTeam1.id -> {
                // Decrement the score and update the TextView.
                mScore1--
                binding.score1.text = mScore1.toString()
            }
            binding.decreaseTeam2.id -> {
                // Decrement the score and update the TextView.
                mScore2--
                binding.score2.text = mScore2.toString()

            }
        }
    }

    /**
     * Handles the onClick of both the increment buttons.
     *
     * @param view The button view that was clicked
     */
    fun increaseScore(view: View) {
        // Get the ID of the button that was clicked.
        val viewID = view.id
        when (viewID) {
            binding.increaseTeam1.id -> {
                // Increment the score and update the TextView.
                mScore1++
                binding.score1.text = mScore1.toString()
            }
            binding.increaseTeam2.id -> {
                // Increment the score and update the TextView.
                mScore2++
                binding.score2.text = mScore2.toString()
            }
        }
    }


    /**
     * Method that is called when the configuration changes,
     * used to preserve the state of the app.
     *
     * @param outState The bundle that will be passed in to the Activity when it is restored.
     */
    override fun onSaveInstanceState(outState: Bundle) {
        // Save the scores.
        outState.putInt(STATE_SCORE_1, mScore1)
        outState.putInt(STATE_SCORE_2, mScore2)
        super.onSaveInstanceState(outState)
    }
}

