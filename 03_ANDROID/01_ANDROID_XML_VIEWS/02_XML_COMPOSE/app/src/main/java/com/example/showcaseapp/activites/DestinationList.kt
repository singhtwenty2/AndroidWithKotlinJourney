package com.example.showcaseapp.activites

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import com.example.showcaseapp.R
import com.example.showcaseapp.databinding.ActivityDestinationListBinding
import com.example.showcaseapp.databinding.ActivityMainBinding
import com.example.showcaseapp.utilities.UiUtils

class DestinationList : AppCompatActivity() {

    private lateinit var binding: ActivityDestinationListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDestinationListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        UiUtils().setNoLimitsFlag(this.window)
        UiUtils().setStatusBar(this,R.color.white)

        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator

        binding.fab.setOnClickListener {
            vibrator?.vibrate(30)
            startActivity(Intent(this@DestinationList,AddDestination::class.java))
        }
    }
}