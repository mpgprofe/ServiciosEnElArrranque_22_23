package com.example.serviciosenelarrranque_22_23;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String ID_CANAL = "Peñarroya";
    public static final CharSequence NOMBRE_CANAL = "Canal favorito";
    public static final int ID_TRABAJO = 666;
    Button buttonArrancar;
    public final static String MENSAJE = "MENSAJE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        if (extras!=null){
            String mensaje = extras.getString(MENSAJE);
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
            extras.clear();
        }


        buttonArrancar = findViewById(R.id.buttonStart);
        buttonArrancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MiServicioIntenso.encolarTrabajo(getApplicationContext(), new Intent());
            }
        });

        crearCanalNotificaciones(); //Creamos el canal de notificaciones
    }

    void crearCanalNotificaciones(){

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        NotificationChannel notificationChannel = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notificationChannel = new NotificationChannel(ID_CANAL, NOMBRE_CANAL, NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.GREEN);
            notificationChannel.enableVibration(true);
            notificationChannel.setShowBadge(true);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}