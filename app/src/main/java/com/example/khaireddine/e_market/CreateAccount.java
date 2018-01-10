package com.example.khaireddine.e_market;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccount extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

    }

    public void validation(View view) {
        EditText username=(EditText)findViewById(R.id.User_name);
        EditText password=(EditText)findViewById(R.id.User_name);
        EditText phonenumber=(EditText)findViewById(R.id.User_name);
        EditText cardnumber=(EditText)findViewById(R.id.User_name);
        EditText email =(EditText)findViewById(R.id.User_name);
        String user=username.getText().toString();
        String pass=password.getText().toString();
        String phone=phonenumber.getText().toString();
        String card=cardnumber.getText().toString();
        String mail=email.getText().toString();
        UserListOpenHelper mDB = new UserListOpenHelper(this);
        mDB.insert(user,pass,phone,card,mail);
        Toast.makeText(this,"subscribe Succeed!!!!!!",Toast.LENGTH_SHORT).show();
        Intent intentproduit=new Intent(this,Produits.class);
        startActivity(intentproduit);
    }
}
