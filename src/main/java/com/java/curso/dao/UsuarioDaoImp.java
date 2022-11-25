package com.java.curso.dao;

import com.java.curso.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository         //acceder al repositorio de la BD
@Transactional      //como ejecuta las consultas en fracmentos de transacciones
public class UsuarioDaoImp implements UsuarioDao{

    @PersistenceContext
    EntityManager entityManager;        //sirve para hacer la conexion con la BD

    @Override
    @Transactional
    public List<Usuario> getUsuarios() {
        String query= "FROM Usuario";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(long id) {
        Usuario usuario=entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }

    @Override
    public void registrar(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public boolean verificarDatos(Usuario usuario) {
        String query= "FROM Usuario where nombre = :nombre and contrasena=:password";
        List <Usuario> lista=entityManager.createQuery(query).setParameter("nombre",usuario.getNombre()).setParameter("password",usuario.getContrasena()).getResultList();
        return !lista.isEmpty();
    }
}
