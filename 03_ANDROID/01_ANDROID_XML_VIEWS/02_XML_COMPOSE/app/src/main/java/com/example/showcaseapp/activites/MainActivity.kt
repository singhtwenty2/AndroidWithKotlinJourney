package com.example.showcaseapp.activites

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.util.Log
import com.example.showcaseapp.R
import com.example.showcaseapp.databinding.ActivityMainBinding
import com.example.showcaseapp.utilities.UiUtils
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        UiUtils().setNoLimitsFlag(this.window)
        UiUtils().setStatusBar(this,R.color.white)

        val currentHour: Int = getCurrentTime()
        val message: String = generateMessage(currentHour)
        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator

        binding.greetText.text = message

        binding.getStartedButton.setOnClickListener {
            vibrator?.vibrate(30)
            startActivity(Intent(this@MainActivity,DestinationList::class.java))
        }
    }
    private fun getCurrentTime(): Int {
        val calender = Calendar.getInstance()
        return calender.get(Calendar.HOUR_OF_DAY)
    }
    private fun generateMessage(currentHour: Int): String {
        return when (currentHour) {
            in 0..11 -> "Good Morning"
            in 12..16 -> "Good Afternoon"
            in 17..23 -> "Good Evening"
            else -> "Hello"
        }
    }
}