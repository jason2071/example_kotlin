package com.example.demokotlin.menu

import android.app.Activity

data class MainMenu(
    var mExampleActivityClass: Class<out Activity>
    , var mExampleName: String
)