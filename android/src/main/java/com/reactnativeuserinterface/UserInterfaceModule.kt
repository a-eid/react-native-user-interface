package com.reactnativeuserinterface

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Promise

import androidx.appcompat.app.AppCompatDelegate
import android.os.Handler
import android.os.Looper


class UserInterfaceModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    override fun getName(): String {
        return "UserInterface"
    }

    @ReactMethod
    fun setUserInterface(style: String) {
      Handler(Looper.getMainLooper()).post {
        if(style == "light"){
          AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }else if(style == "dark"){
          AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }else {
          AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }
      }
    }
}
