package com.example.mountainfox.applicationct;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import static java.lang.Thread.sleep;

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

        for(tempsRestant=10;tempsRestant>-1;tempsRestant--){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        Log.d("Service ", " 10 secondes > fin ");
    }
}
