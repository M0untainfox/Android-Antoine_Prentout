package com.example.mountainfox.applicationct;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final String EXTRA_VAL = "USER";
    String USER = "undefined";
    EditText editUser;
    EditText editMDP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button loginButton = (Button) findViewById(R.id.btnCo);
        editMDP = (EditText) findViewById(R.id.editPass);
        editUser = (EditText) findViewById(R.id.editUser);

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(CondiConnex(editUser.getText().toString(),editMDP.getText().toString())==true){
                Intent intent = new Intent(MainActivity.this, Menu.class);
                intent.putExtra(EXTRA_VAL, USER);
                startActivity(intent);
                }

            }
        });
    }


    public boolean  CondiConnex(String username,String pass) {

        database db = new database(this);
        SQLiteDatabase database = db.getWritableDatabase();
        Cursor sql = database.rawQuery("SELECT login,password,username FROM Users WHERE login = ?", new String[]{username});
        String[][] user = cursorToString(sql);
        if (user != null && user.length != 0) {
           if(user[0][1].equals(pass)){
               USER = user[0][2];
               return true;
           }
           else {
               Toast.makeText(MainActivity.this, "Mot de passe érroné", Toast.LENGTH_SHORT).show();
               return false;
           }
        }
        else {
            Toast.makeText(MainActivity.this, "Erreur de connexion", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public String[][] cursorToString(Cursor c){
        if(c != null) {
            String[][] sql = new String[c.getCount()][c.getColumnCount()];
            int i = 0;
            if (c.getCount() == 0)
                return sql;
            c.moveToFirst();
            while (true) {
                // nb de resultat attendu dans le select
                sql[i][0] = c.getString(0);
                sql[i][1] = c.getString(1);
                sql[i][2] = c.getString(2);

                //
                i++;
                if (!c.moveToNext())
                    break;
            }
            c.close();
            return sql;
        }else{
            return null;
        }
    }

}

