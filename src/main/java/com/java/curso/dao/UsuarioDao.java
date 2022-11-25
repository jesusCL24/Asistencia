package com.java.curso.dao;

import com.java.curso.models.Usuario;

import java.util.List;

public interface UsuarioDao {
    List<Usuario> getUsuarios();

    void eliminar(long id);

    void registrar(Usuario usuario);

    boolean verificarDatos(Usuario usuario);
}
