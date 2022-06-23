package com.example.shieldpay.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.shieldpay.basesetup.BaseSharedPreferenceManager
import com.example.shieldpay.home.BottomNavigationActivity
import com.example.shieldpay.onboarding.OnBoardingActivity
import com.example.shieldpay.webservices.RetrofitOrHttpActivity
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCenter.start(
            application,
            "1cc54ef4-3c49-47d4-9e6c-6d3a399e40d2",
            Analytics::class.java,
            Crashes::class.java
        )

        if(BaseSharedPreferenceManager.getInstance(this@SplashActivity).isOnboard()) {
            if (BaseSharedPreferenceManager.getInstance(this@SplashActivity).isLoggedIn()) {
                startActivity(Intent(this@SplashActivity, BottomNavigationActivity::class.java))
            } else {
                startActivity(Intent(this@SplashActivity, RetrofitOrHttpActivity::class.java))
            }
        } else {
            startActivity(Intent(this@SplashActivity, OnBoardingActivity::class.java))
        }
        finish()
    }
}