package com.example.demokotlin.datepicker

import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.demokotlin.R
import kotlinx.android.synthetic.main.activity_datepicker.*
import java.util.*
import android.app.Activity
import android.support.v7.app.AlertDialog
import kotlinx.android.synthetic.main.item_calendar_layout.view.*


class DatepickerActivity : AppCompatActivity() {

    private lateinit var mDateSetListener: DatePickerDialog.OnDateSetListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datepicker)

        btnCalendar.setOnClickListener {
            startActivityForResult(Intent(this, CalendarActivity::class.java), 1001)
        }

        btnDateDialog.setOnClickListener {
            datepickerDialog()
        }
        mDateSetListener = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            val m = month + 1
            val date = "$dayOfMonth/$m/$year"
            displayDate.text = "dialog: $date"
        }

        btnCalendarDialog.setOnClickListener {
            buildDateDialog()
        }
    }

    private fun buildDateDialog() {
        val calendarDialog = AlertDialog.Builder(this)
        val inflater = this.layoutInflater
        val view = inflater.inflate(R.layout.item_calendar_layout, null)

        view.calendarDialog.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val m = month + 1
            val date = "$dayOfMonth/$m/$year"
            displayDate.text = "custom: $date"
        }

        calendarDialog.setPositiveButton("OK") { dialog, witch ->
            dialog.dismiss()
        }

        calendarDialog.setView(view)
        calendarDialog.show()
    }

    private fun datepickerDialog() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val dialog = DatePickerDialog(
            this,
            android.R.style.Theme_Holo_Light_Dialog_MinWidth,
            mDateSetListener,
            year,
            month,
            day
        )

        dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1001) {
            if (resultCode == Activity.RESULT_OK) {
                val date = data?.getStringExtra("calendar_date")
                displayDate.text = "result: $date"
            }
        }
    }
}
