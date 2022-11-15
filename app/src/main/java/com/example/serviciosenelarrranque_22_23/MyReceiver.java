package com.example.serviciosenelarrranque_22_23;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)){
            //Arrancamos el servicio
        }

        throw new UnsupportedOperationException("Not yet implemented");
    }
}