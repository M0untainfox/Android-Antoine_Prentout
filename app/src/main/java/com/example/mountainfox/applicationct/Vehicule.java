package com.example.mountainfox.applicationct;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Mountainfox on 15-Feb-17.
 */

public class Vehicule implements Parcelable {

    public String Marque;
    public String Immatriculation;
    public String Modele;
    public int annee;
    public int km;
    public int type;



    public Vehicule(String mar,String mod,String imat,int an,int km,int type){
        Marque=mar;
        Modele=mod;
        Immatriculation= imat;
        annee = an;
        this.km=km;
        this.type= type;
    }

    protected Vehicule(Parcel in) {
        Marque = in.readString();
        Immatriculation = in.readString();
        Modele = in.readString();
        annee = in.readInt();
        km = in.readInt();
        type = in.readInt();
    }

    public static final Creator<Vehicule> CREATOR = new Creator<Vehicule>() {
        @Override
        public Vehicule createFromParcel(Parcel in) {
            return new Vehicule(in);
        }

        @Override
        public Vehicule[] newArray(int size) {
            return new Vehicule[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Marque);
        dest.writeString(Immatriculation);
        dest.writeString(Modele);
        dest.writeInt(annee);
        dest.writeInt(km);
        dest.writeInt(type);
    }
}
