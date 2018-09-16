package com.example.user.phonenumberspinner

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    // Define spinnerLabel for the label (the spinner item that the user chooses).
    private var spinnerLabel = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (label_spinner != null) {
            label_spinner.onItemSelectedListener = this
        }

        // Create ArrayAdapter using the string array and default spinner layout.
        val adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item)

        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Apply the adapter to the spinner.
        if (label_spinner != null) {
            label_spinner.adapter = adapter
        }

    }

    fun showText(view: View) {
        if (editText_main != null) {
            // Assign to showString both the entered string and spinnerLabel.
            val showString = editText_main.text.toString() + " - " + spinnerLabel

            // Show the showString in the phoneNumberResult.
            if (text_phonelabel != null) text_phonelabel.text = showString
        }
    }


    override fun onItemSelected(adapterView: AdapterView<*>, view: View, pos: Int, id: Long) {
        spinnerLabel = adapterView.getItemAtPosition(pos).toString()
        showText(view)
    }


    override fun onNothingSelected(adapterView: AdapterView<*>) {
        Log.d(TAG, getString(R.string.nothing_selected))
    }

    companion object {
        // Define TAG for logging.
        private val TAG = MainActivity::class.java.simpleName
    }
}