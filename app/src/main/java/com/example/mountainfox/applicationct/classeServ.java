package com.example.mountainfox.applicationct;

import android.app.IntentService;
import android.content.Intent;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import static android.R.attr.id;

/**
 * Created by mbp on 20/03/2017.
 */

public class classeServ extends IntentService {

    private int tempsRestant;

    public classeServ() {
        super("Service Test A");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Messenger msg = intent.getParcelableExtra("msg");

        for(tempsRestant=10;tempsRestant>-1;tempsRestant--){
            try {
                Thread.sleep(1000);
                try {
                    msg.send(Message.obtain(null,1,tempsRestant,0));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }




        Log.d("Service ", " 10 secondes > fin ");
    }
}
