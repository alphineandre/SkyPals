package com.example.skypals

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class ProfileFragment : Fragment() {

    private lateinit var displayNameTextView: TextView
    private lateinit var emailTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        displayNameTextView = view.findViewById(R.id.displayNameTextView)
        emailTextView = view.findViewById(R.id.emailTextView)

        // Retrieve user information from Firebase Authentication
        val currentUser: FirebaseUser? = FirebaseAuth.getInstance().currentUser
        if (currentUser != null) {
            val displayName = currentUser.displayName
            val email = currentUser.email

            // Display user information
            displayNameTextView.text = "Display Name: $displayName"
            emailTextView.text = "Email: $email"
        }

        return view    }

}