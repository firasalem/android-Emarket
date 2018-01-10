package com.example.khaireddine.e_market;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void To_Map(View view) {

        Uri googlemap = Uri.parse("https://www.google.fr/maps");
        Intent intent = new Intent(Intent.ACTION_VIEW, googlemap);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);

        }
    }

    public void To_Connect(View view) {
        Intent intent = new Intent(this, Connect.class);
        startActivity(intent);
    }

    public void To_Create_Account(View view) {
        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);
    }
    public void to_produit(View view)
    {        Intent intent = new Intent(this, Produits.class);
        startActivity(intent);

    }
}
