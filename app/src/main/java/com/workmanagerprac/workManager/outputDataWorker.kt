package com.workmanagerprac.workManager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf

class outputDataWorker(context: Context,workerParameters: WorkerParameters):Worker(context,workerParameters) {
    override fun doWork(): Result {

        val name = "Mohit"
        val outputName = workDataOf("name" to name)
        return Result.success(outputName)
    }

}