package com.workmanagerprac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.workmanagerprac.databinding.ActivityMainBinding
import com.workmanagerprac.workManager.logWorker

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val logWorkRequest:WorkRequest = OneTimeWorkRequestBuilder<logWorker>().build()

        WorkManager.getInstance(this).enqueue(logWorkRequest)

    }
}