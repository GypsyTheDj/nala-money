package money.nala.pay.interview.app

import android.app.Application
import android.content.Context

class NalaApp : Application() {

    override fun onCreate() {
        super.onCreate()

        appContext = applicationContext
    }

    companion object {
        lateinit var appContext: Context
    }
}