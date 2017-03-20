package com.example.mountainfox.applicationct;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by mbp on 20/03/2017.
 */

public class Fragment_Services extends PreferenceFragment {

    View myview;
    Button btnServ1;

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
                getActivity().startService(new Intent(getActivity(),classeServ.class));
            }
        });




    }

}
