package com.example.cmsc436groupproject

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CreateGroupActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_group)

        // Initialize Firebase Database reference
        database = FirebaseDatabase.getInstance().reference

        val groupNameInput: EditText = findViewById(R.id.group_name)
        val subjectInput: EditText = findViewById(R.id.subject)
        val locationInput: EditText = findViewById(R.id.location)
        val timeInput: EditText = findViewById(R.id.time)
        val maxSizeInput: EditText = findViewById(R.id.max_size)

        val createGroupButton: Button = findViewById(R.id.create_group_button)
        createGroupButton.setOnClickListener {

            val groupName = groupNameInput.text.toString().trim()
            val subject = subjectInput.text.toString().trim()
            val location = locationInput.text.toString().trim()
            val time = timeInput.text.toString().trim()
            val maxSize = maxSizeInput.text.toString().trim().toIntOrNull()


            if (groupName.isEmpty() || subject.isEmpty() || location.isEmpty() || time.isEmpty() || maxSize == null) {
                Toast.makeText(this, "Please fill out all fields correctly", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            val group = Group(groupName, subject, location, time, maxSize)

            // Save the group object to Firebase
            database.child("groups").push().setValue(group)
                .addOnSuccessListener {
                    Toast.makeText(this, "Group created successfully!", Toast.LENGTH_SHORT).show()
                    finish()
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Failed to create group", Toast.LENGTH_SHORT).show()
                }
        }
    }

    // Data class to represent a Group
    data class Group(
        val groupName: String,
        val subject: String,
        val location: String,
        val time: String,
        val maxSize: Int
    )
}
