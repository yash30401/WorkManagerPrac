package com.workmanagerprac

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.workmanagerprac.databinding.ActivityMainBinding
import com.workmanagerprac.workManager.logWorker
import java.time.Duration

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val logWorkRequest:WorkRequest = OneTimeWorkRequestBuilder<logWorker>()
            .setInitialDelay(Duration.ofSeconds(5))
            .build()

        WorkManager.getInstance(this).enqueue(logWorkRequest)

    }
}