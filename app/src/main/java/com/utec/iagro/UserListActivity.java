package com.utec.iagro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.utec.iagro.adapters.UsuariosAdapter;
import com.utec.iagro.models.Usuario;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        Intent intent = getIntent();
        String userType = intent.getStringExtra("USER_TYPE");

        UsuariosFragment usuariosFragment = (UsuariosFragment) getSupportFragmentManager().findFragmentById(R.id.usuarios_container);
        if(usuariosFragment == null) {
            usuariosFragment = UsuariosFragment.newInstance(userType);
            getSupportFragmentManager().beginTransaction().add(R.id.usuarios_container, usuariosFragment).commit();
        }
    }
}
