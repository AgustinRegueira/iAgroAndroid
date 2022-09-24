package com.utec.iagro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void listAdministradores(View view) {
        Intent intent = new Intent(this, UserListActivity.class);
        intent.putExtra("USER_TYPE", "ADMINISTRADOR");
        startActivity(intent);
    }

    public void listInvestigadores(View view) {
        Intent intent = new Intent(this, UserListActivity.class);
        intent.putExtra("USER_TYPE", "INVESTIGADOR");
        startActivity(intent);
    }

    public void listAficionados(View view) {
        Intent intent = new Intent(this, UserListActivity.class);
        intent.putExtra("USER_TYPE", "AFICIONADO");
        startActivity(intent);
    }
}