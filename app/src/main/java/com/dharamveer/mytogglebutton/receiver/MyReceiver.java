package com.dharamveer.mytogglebutton.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    private static final String TAG = "MyReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
//        Log.d(TAG, "onReceive: Flight mode changed");
        if (isAirplaneModeOn(context.getApplicationContext())) {
            Toast.makeText(context, "Broadcast: Flight mode on", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, "Broadcast: Flight mode off", Toast.LENGTH_LONG).show();
        }
    }

    private static boolean isAirplaneModeOn(Context ctx) {
        return Settings.System.getInt(ctx.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
    }
}
