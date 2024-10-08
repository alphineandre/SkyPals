package com.example.skypals

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SupportFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_support, container, false)

        val editTextName = view.findViewById<EditText>(R.id.editTextName)
        val editTextEmail = view.findViewById<EditText>(R.id.editTextEmail)
        val editTextSupportRequest = view.findViewById<EditText>(R.id.editTextSupportRequest)
        val buttonSubmitRequest = view.findViewById<Button>(R.id.buttonSubmitRequest)
        val textViewAgentMessage = view.findViewById<TextView>(R.id.textViewAgentMessage)

        buttonSubmitRequest.setOnClickListener {
            val name = editTextName.text.toString()
            val email = editTextEmail.text.toString()
            val supportRequest = editTextSupportRequest.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && supportRequest.isNotEmpty()) {
                // You can implement logic to submit the support request and user credentials, e.g., to a server.
                // For this example, we'll display a message.
                val message = "Thank you, $name! An agent will be in contact at $email soon."
                textViewAgentMessage.text = message

                // Clear input fields
                editTextName.text.clear()
                editTextEmail.text.clear()
                editTextSupportRequest.text.clear()
            } else {
                textViewAgentMessage.text = "Please fill in all fields."
            }
        }

        return view
    }
}