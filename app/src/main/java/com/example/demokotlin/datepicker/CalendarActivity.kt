package com.example.demokotlin.datepicker

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.demokotlin.R
import kotlinx.android.synthetic.main.activity_calendar.*
import android.app.Activity
import android.content.Intent



class CalendarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        calendarVIew.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val m = month + 1
            val date = "$dayOfMonth/$m/$year"
            val returnIntent = Intent()
            returnIntent.putExtra("calendar_date", date)
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }
    }
}
