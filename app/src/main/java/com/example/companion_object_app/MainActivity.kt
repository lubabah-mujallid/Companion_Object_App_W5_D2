package com.example.companion_object_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cl = findViewById<ConstraintLayout>(R.id.clMain)
        val et = findViewById<EditText>(R.id.et)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            var type: String = et.text.toString()
            if (type == "Day"){ Background.isDay = true }
            else if (type == "Night") { Background.isDay = false }
            else { Toast.makeText(this, "Please Enter Day or Night only!", Toast.LENGTH_LONG).show() }
            Background.changeBackground(cl)
        }
    }
}

class Background(){
    companion object {
        var isDay: Boolean? = null
        val day = R.drawable.pinkpink
        val night = R.drawable.sundown
        fun changeBackground(cl: ConstraintLayout){
            if (isDay == true) cl.setBackgroundResource(day)
            else if (isDay == false) cl.setBackgroundResource(night)
        }
    }

}

/*
1- Create a class for the constant values of your application

2- Create a class that will be responsible for changing the background of the main activity

3- use a companion object to hold a static value of the class that indicates day or night

4- create an Edit Text in the main activity that will take day or night from the user which will change the background accordingly
* */