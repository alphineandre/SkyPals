package com.example.skypals

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class FeedbackFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_feedback, container, false)

        val editTextFeedback = view.findViewById<EditText>(R.id.editTextFeedback)
        val buttonSubmit = view.findViewById<Button>(R.id.buttonSubmit)
        val textViewMessage = view.findViewById<TextView>(R.id.textViewMessage)

        buttonSubmit.setOnClickListener {
            val feedbackText = editTextFeedback.text.toString()

            if (feedbackText.isNotEmpty()) {
                // You can save the feedback data to a database or perform any required actions here.
                // For this example, we'll simply display a message.
                textViewMessage.text = "Your feedback is appreciated!"
                editTextFeedback.text.clear()
            } else {
                textViewMessage.text = "Please enter your feedback."
            }
        }

        return view
    }
}