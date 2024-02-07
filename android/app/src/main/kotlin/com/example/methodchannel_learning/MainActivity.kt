package com.example.methodchannel_learning

import android.content.Intent
import android.util.Log
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity : FlutterActivity() {
    private val CHANNEL = "your_channel_name"
    lateinit var result: MethodChannel.Result
    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler { call, result ->
          this.result=result;

            if (call.method == "getDataFromNative") {
                val data = getDataFromNative(result)
               // result.success(data)
            } else {
                result.notImplemented()
            }
        }

    }

    override fun onRestart() {
        super.onRestart()
        this.result.success(ResultModel().filePath.toString()+"dddddddddddddddddddddd")
    }
    private fun getDataFromNative(result: MethodChannel.Result): String {
        var intent : Intent= Intent(this@MainActivity,DemoActivity()::class.java)
        startActivityForResult(intent,200);
        return "Data from Native"
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null) {
            Log.e("ssssssssssssssssssssss",data.getStringExtra("result").toString()+"dddddddddddddddddddddd")
        }
    }
}