package com.example.guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    val secretNumber = SecretNumber()
    val TAG = MainActivity::class.java.simpleName



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG,"secret:"+secretNumber.secret)

    }
    fun check(view : View){

        val n = ed_number.text.toString().toInt()
        println("number: $n")
        Log.d(TAG,"number:"+n)
        val diff = secretNumber.validate(n)
        var message = getString(R.string.well_done)
        if (diff < 0){
            message = getString(R.string.bigger)
        }
        else if (diff > 0){
            message = getString(R.string.smaller)
        }
//        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.title_message))
            .setMessage(message)
            .setPositiveButton(getString(R.string.ok),null)
            .show()

    }


}