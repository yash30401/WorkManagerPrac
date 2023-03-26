package com.workmanagerprac

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.work.*
import com.workmanagerprac.databinding.ActivityMainBinding
import com.workmanagerprac.workManager.logWorker
import com.workmanagerprac.workManager.outputDataWorker
import java.time.Duration
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val logConstraints = Constraints.Builder()
            .setRequiresCharging(false)
            .build()

        val  logData = Data.Builder()
            .putString("name","Yash")
            .build()

        val logWorkRequest:WorkRequest = OneTimeWorkRequestBuilder<logWorker>()
            .setConstraints(logConstraints)
            .setInputData(logData)
            .setInitialDelay(Duration.ofSeconds(2))
            .build()

        val nameWorkRequest:WorkRequest = OneTimeWorkRequestBuilder<outputDataWorker>()
            .setInitialDelay(Duration.ofSeconds(3))
            .build()



        WorkManager.getInstance(this).enqueue(logWorkRequest)

        WorkManager.getInstance(this).getWorkInfoByIdLiveData(nameWorkRequest.id).observe(this, Observer {workInfo->
            if(workInfo!=null && workInfo.state ==WorkInfo.State.SUCCEEDED){
                val name = workInfo.outputData.getString("name")
                Log.d("WORKER","NAME ${name.toString()}")
            }else{
                Toast.makeText(this, workInfo.state.name.toString(), Toast.LENGTH_SHORT).show()
            }
        })


    }
}