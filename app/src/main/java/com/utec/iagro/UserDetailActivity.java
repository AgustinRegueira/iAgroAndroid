package com.utec.iagro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.utec.iagro.models.Usuario;

public class UserDetailActivity extends AppCompatActivity {
    TextView txtNombre, txtApellido, txtNombreUsuario, txtMail, txtDocumento, txtDomicilio, txtTelefono, txtCiudad, txtOcupacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtNombreUsuario = findViewById(R.id.txtNombreUsuario);
        txtMail = findViewById(R.id.txtMail);
        txtDocumento = findViewById(R.id.txtDocumento);
        txtDomicilio = findViewById(R.id.txtDomicilio);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtCiudad = findViewById(R.id.txtCiudad);
        txtOcupacion = findViewById(R.id.txtOcupacion);

        Intent intent = getIntent();
        Usuario usuario = (Usuario) intent.getSerializableExtra("USER");
        txtNombre.setText(usuario.getNombre());
        txtApellido.setText(usuario.getApellido());
        txtNombreUsuario.setText(usuario.getNombreUsuario());
        txtMail.setText(usuario.getMail());
        txtDocumento.setText(usuario.getDocumento());
        txtDomicilio.setText(usuario.getDomicilio());
        txtTelefono.setText(usuario.getTelefono());
        txtCiudad.setText(usuario.getCiudad());
        txtOcupacion.setText(usuario.getOcupacion());
    }
}