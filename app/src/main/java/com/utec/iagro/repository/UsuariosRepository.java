package com.utec.iagro.repository;

import com.utec.iagro.models.Usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UsuariosRepository {
    private static UsuariosRepository repository = new UsuariosRepository();
    private HashMap<Long, Usuario> usuarios = new HashMap<>();

    public static UsuariosRepository getInstance() {
        return repository;
    }

    public UsuariosRepository() {
        usuarios.put(1L, new Usuario("1", "Juan", "Pedro", "juan.pedro", "pepe.1234",
                "a@com", "ACTIVE", "ADMINISTRADOR", "", "", "", "", ""));
    }

    public List<Usuario> getUsuarios(String userType) {
        return new ArrayList<>(usuarios.values());
    }
}
