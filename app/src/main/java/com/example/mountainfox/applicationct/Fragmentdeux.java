package com.example.mountainfox.applicationct;

import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Mountainfox on 09-Feb-17.
 */

public class Fragmentdeux extends Fragment {
    View myview;
    String txt=null;
    TextView tv,tvmodele,tvimat,tvmark,tvan,tvkm,tvtype;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        myview=inflater.inflate(R.layout.fragment_deux,container,false);
        return myview;


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        tv = (TextView) myview.findViewById(R.id.textView2);
        tvmodele = (TextView) myview.findViewById(R.id.TextViewModele);
        tvmark = (TextView) myview.findViewById(R.id.textViewMarque);
        tvan = (TextView) myview.findViewById(R.id.textViewAnn);
        tvkm = (TextView) myview.findViewById(R.id.textViewKM);
        tvimat = (TextView) myview.findViewById(R.id.textViewImat);
        tvtype = (TextView)myview.findViewById(R.id.textViewType);



        if(txt!=null){
            tv.setText(txt);

        }


    }

    @Override
    public void onStart() {
        super.onStart();


        tv.setText(getContext().getResources().getString(R.string.Vehicule)+" "+Menu.numList);
        tvmodele.setText(getContext().getResources().getString(R.string.Mod)+" "+Menu.ListeV.get(Menu.numList).Modele);
        tvan.setText(getContext().getResources().getString(R.string.Ann)+" "+Menu.ListeV.get(Menu.numList).annee);
        tvimat.setText(getContext().getResources().getString(R.string.Imat)+" "+Menu.ListeV.get(Menu.numList).Immatriculation);
        tvkm.setText(getContext().getResources().getString(R.string.Km)+" "+Menu.ListeV.get(Menu.numList).km);
        tvmark.setText(getContext().getResources().getString(R.string.Mark)+" "+Menu.ListeV.get(Menu.numList).Marque);
        tvtype.setText(getContext().getResources().getString(R.string.Type)+" "+Menu.ListeC.get(Menu.ListeV.get(Menu.numList).type).nom);

    }
}
