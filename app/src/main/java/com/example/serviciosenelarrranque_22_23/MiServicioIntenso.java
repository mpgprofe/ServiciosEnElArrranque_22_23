package com.example.serviciosenelarrranque_22_23;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;
import androidx.core.app.NotificationCompat;

import java.util.Random;


public class MiServicioIntenso extends JobIntentService {

    private int ID=111;
    int contador=0;

    public MiServicioIntenso() {
    }

    public static void encolarTrabajo(Context ctx, Intent intent){
        enqueueWork(ctx, MiServicioIntenso.class, MainActivity.ID_TRABAJO, intent);
    }


    @Override
    protected void onHandleWork(@NonNull Intent intent) {

        while (true){
            mandarNotificaciones(getApplicationContext());
            try {
                Thread.sleep(15*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    void mandarNotificaciones(Context ctx){
        NotificationManager notificationManager = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);

        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        int nAleatorio = random.nextInt(1000);
        Intent intent = new Intent(ctx, MainActivity.class);
        intent.putExtra(MainActivity.MENSAJE, "El número es: " +nAleatorio );

        PendingIntent pendingIntent = PendingIntent.getActivity(ctx, ID, intent, 0);

        Notification notification = new NotificationCompat.Builder(ctx, MainActivity.ID_CANAL).
                setContentTitle("Notificación desde el Servicio").
                setContentText("Hola. El número es: "+nAleatorio).
                setSmallIcon(android.R.drawable.ic_media_next).
                setContentIntent(pendingIntent).build();
        notificationManager.notify(contador++, notification);



    }

}