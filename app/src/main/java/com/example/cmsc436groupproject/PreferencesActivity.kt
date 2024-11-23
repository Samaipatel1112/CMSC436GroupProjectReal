package com.example.cmsc436groupproject

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PreferencesActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferences)

        sharedPreferences = getSharedPreferences("Preferences", MODE_PRIVATE)

        val seekBar: SeekBar = findViewById(R.id.group_size_seekbar)
        val seekBarText: TextView = findViewById(R.id.group_size_text)

        seekBar.progress = sharedPreferences.getInt("preferredGroupSize", 3)
        seekBarText.text = "Preferred Group Size: ${seekBar.progress}"

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                seekBarText.text = "Preferred Group Size: $progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                sharedPreferences.edit().putInt("preferredGroupSize", seekBar.progress).apply()
            }
        })
    }
}
