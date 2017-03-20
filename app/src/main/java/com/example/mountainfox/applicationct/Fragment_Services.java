package com.example.mountainfox.applicationct;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.preference.PreferenceFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by mbp on 20/03/2017.
 */

public class Fragment_Services extends Fragment {

    View myview;
    Button btnServ1;
    private Messenger mailbox = new Messenger(new RecvMsg());

    private class RecvMsg extends Handler {
        @Override
        public void handleMessage(Message msg) {
            Log.d("MainActivity", "recu " + msg.what + "_" + msg.arg1);
            if(msg.arg1==0)
                btnServ1.setText("Boom !");
            else
            btnServ1.setText(String.valueOf(msg.arg1));
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview=inflater.inflate(R.layout.services,container,false);
        return myview;
    }

    @Override
    public void onStart() {
        super.onStart();

        btnServ1 = (Button)myview.findViewById(R.id.btn_serv1);

        btnServ1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),classeServ.class);
                intent.putExtra("msg", mailbox);
                getActivity().startService(intent);
            }
        });




    }

}


