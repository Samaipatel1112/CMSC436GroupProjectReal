package com.example.cmsc436groupproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

class MainActivity : AppCompatActivity() {

    private lateinit var adView: AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupAdView()

        val groupDetailsButton: Button = findViewById(R.id.group_details_button)
        groupDetailsButton.setOnClickListener {
            val intent = Intent(this, GroupDetailsActivity::class.java)
            startActivity(intent)
        }

        val preferencesButton: Button = findViewById(R.id.preferences_button)
        preferencesButton.setOnClickListener {
            val intent = Intent(this, PreferencesActivity::class.java)
            startActivity(intent)
        }

        // Link create_group button to CreateGroupActivity
        val createGroupButton: Button = findViewById(R.id.create_group)
        createGroupButton.setOnClickListener {
            val intent = Intent(this, CreateGroupActivity::class.java)
            startActivity(intent)
        }

        // Link go button to GroupsActivity
        val goButton: Button = findViewById(R.id.go)
        goButton.setOnClickListener {
            val intent = Intent(this, GroupsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupAdView() {
        adView = AdView(this).apply {
            setAdSize(AdSize.BANNER)
            adUnitId = "ca-app-pub-3940256099942544/6300978111"
        }

        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)

        val adContainer: FrameLayout = findViewById(R.id.ad_container)
        adContainer.addView(adView)
    }
}
