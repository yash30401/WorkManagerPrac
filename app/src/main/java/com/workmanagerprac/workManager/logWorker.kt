package com.workmanagerprac.workManager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class logWorker(context: Context, workParams:WorkerParameters):Worker(context,workParams) {
    override fun doWork(): Result {
        Log.d("WORKER","Work Called")

        return Result.success()
    }

}