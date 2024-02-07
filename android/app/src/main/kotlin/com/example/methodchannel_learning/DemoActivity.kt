package com.example.methodchannel_learning

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import java.io.Serializable


class DemoActivity() : Activity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)

        (findViewById<Button>(R.id.btn_hit)).setOnClickListener {
            val returnIntent = Intent()
            returnIntent.putExtra("result", " as Serializable?")
            setResult(RESULT_OK, returnIntent)
            finish()
        }
        ResultModel().filePath="AnandSharma"

    }

    override fun onBackPressed() {
        super.onBackPressed()
      //  MainActivity().result.success("backFromLastScreen")
    }


}