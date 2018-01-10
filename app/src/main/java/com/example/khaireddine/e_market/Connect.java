package com.example.khaireddine.e_market;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Connect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);
    }

    public void verifier(View view) {
        //chercher dans la base de donnée le nom et verifier le mot de passe

        //Si nom est trouver est mdp valide alors intent vers l'activité des produit
        // else afficher une boite de dialog d'erreur
    }
}
