package com.pe.cheeff.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.pe.cheeff.MainActivity;
import com.pe.cheeff.R;
import com.pe.cheeff.socket.SocketManager;
import com.pe.cheeff.socket.SocketUtils;
import com.pe.cheeff.utilities.Utilities;

import io.socket.emitter.Emitter;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }

    @Override
    protected void onResume() {
        super.onResume();
        setupSocket();
        nuevaOrdenDeCompra();
    }

    private void setupSocket() {
        SocketManager.getInstance(this).connect();
    }

    private void nuevaOrdenDeCompra() {
        SocketManager.getInstance(this).on(SocketUtils.ON_ORDER, new Emitter.Listener() {
            @Override
            public void call(final Object... args) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Object arg = args[0];
                        Utilities.createNotification(getApplicationContext());
                        //Toast.makeText(getBaseContext(), "" + arg, Toast.LENGTH_LONG).show();
                        //Log.v("ordendecompra: ", "" + arg);
                    }
                });

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SocketManager.getInstance(this).disconnect();
    }
}
