package com.utec.iagro;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

public class UsuariosFragment extends Fragment {
    private static final String USER_TYPE = "userType";

    String userType;

    ListView mUsuariosList;

    public UsuariosFragment() {
        // Required empty public constructor
    }

    public static UsuariosFragment newInstance(String userType) {
        UsuariosFragment fragment = new UsuariosFragment();
        Bundle args = new Bundle();
        args.putString(USER_TYPE, userType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            userType = getArguments().getString(USER_TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_usuarios, container,
                false);
        mUsuariosList = (ListView)root.findViewById(R.id.usuarios_list);

        GetUsuariosHttp httpRequest = new GetUsuariosHttp();
        httpRequest.execute();

        mUsuariosList.setClickable(true);
        mUsuariosList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Usuario item = (Usuario) mUsuariosList.getItemAtPosition(position);
                Log.i("Click", "click en el elemento " + item.getNombre() + " de mi ListView");
                Intent intent = new Intent(getActivity(), UserDetailActivity.class);
                intent.putExtra("USER", item);
                startActivity(intent);
            }
        });
        return root;
    }

    private class GetUsuariosHttp extends AsyncTask<Void,Void,Boolean> {
        private ArrayAdapter<Usuario> mUsuariosAdapter;
        @Override
        protected Boolean doInBackground(Void... params) {
            boolean result = true;
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                String urlServicio
                        = "http://192.168.0.100:8080/iAgro/rest/obtenerTodosPorRol?rol=" + userType;
                url = new URL(urlServicio);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestProperty("content-type",
                        "application/json");
                InputStream in = new
                        BufferedInputStream(urlConnection.getInputStream());
                //Me traigo el json con los usuarios
                JSONArray respJSON = new JSONArray(getResponseText(in));
                List<Usuario> usuarios = new ArrayList<>();
                for(int i=0; i<respJSON.length(); i++){
                    JSONObject obj = respJSON.getJSONObject(i);
                    String idUsuario = obj.getString("idUsuario");
                    String nombre = obj.getString("nombre");
                    String apellido = obj.getString("apellido");
                    String nombreUsuario = obj.getString("nombreUsuario");
                    String email = obj.getString("mail");
                    String tipoUsuario = obj.getString("tipoUsuario");
                    String documento = "";
                    String domicilio = "";
                    String telefono = "";
                    String ciudad = "";
                    String ocupacion = "";

                    if (obj.has("documento")) {
                        documento = obj.getString("documento");
                    }
                    if (obj.has("domicilio")) {
                        domicilio = obj.getString("domicilio");
                    }
                    if (obj.has("telefono")) {
                        telefono = obj.getString("telefono");
                    }
                    if (obj.has("ciudad")) {
                        ciudad = obj.getString("ciudad");
                    }
                    if (obj.has("ocupacion")) {
                        ocupacion = obj.getString("ocupacion");
                    }

                    usuarios.add(new Usuario(idUsuario, nombre, apellido, nombreUsuario, "", email, "ACTIVE", tipoUsuario, documento, domicilio, telefono, ciudad, ocupacion));
                }
                mUsuariosAdapter = new UsuariosAdapter(getActivity(),
                        usuarios);
            }
            catch(Exception ex) {
                Log.e("ServicioRest","Error!", ex);
                result = false;
            }
            return result;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            if(aBoolean==true){
                //Relacionando la lista con el adaptador
                mUsuariosList.setAdapter(mUsuariosAdapter);
            }
        }
        private String getResponseText(InputStream inStream) {
            return new Scanner(inStream).useDelimiter("\\A").next();
        }
    }
}