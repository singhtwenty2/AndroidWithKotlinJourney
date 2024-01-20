package com.example.showcaseapp.activites

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.widget.Toast
import com.example.showcaseapp.R
import com.example.showcaseapp.databinding.ActivityAddDestinationBinding
import com.example.showcaseapp.utilities.UiUtils

class AddDestination : AppCompatActivity() {
    private lateinit var binding: ActivityAddDestinationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddDestinationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        UiUtils().setNoLimitsFlag(this.window)
        UiUtils().setStatusBar(this,R.color.white)

        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator

        binding.submitButton.setOnClickListener {
            vibrator?.vibrate(30)
            Toast.makeText(this,"Saved .",Toast.LENGTH_LONG).show()
        }

    }
}