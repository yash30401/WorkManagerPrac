package com.workmanagerprac.workManager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class logWorker(context: Context, workParams:WorkerParameters):Worker(context,workParams) {
    override fun doWork(): Result {

        val data = inputData.getString("name")

        Log.d("WORKER",data.toString())

        return Result.success()
    }

}