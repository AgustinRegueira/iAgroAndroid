package com.utec.iagro.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.utec.iagro.R;
import com.utec.iagro.models.Usuario;

import java.util.List;

public class UsuariosAdapter extends ArrayAdapter<Usuario> {
    public UsuariosAdapter(Context context, List<Usuario> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtener inflater.
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // ¿Existe el view actual?
        if (null == convertView) {
            convertView = inflater.inflate(
                    R.layout.list_item_user,
                    parent,
                    false);
        }
        // Referencias UI.
        ImageView imagen = (ImageView)
                convertView.findViewById(R.id.img_user);
        TextView nombreUsuario = (TextView)
                convertView.findViewById(R.id.txtNombreUsuario);
        TextView idUsuario = (TextView)
                convertView.findViewById(R.id.txtIdUsuario);
        // Usuario actual.
        Usuario usuario = getItem(position);
        // Setup.
        //Glide.with(getContext()).load().into(imagen);
        nombreUsuario.setText(usuario.getNombreUsuario());
        idUsuario.setText(usuario.getIdUsuario());
        return convertView;
    }
}
