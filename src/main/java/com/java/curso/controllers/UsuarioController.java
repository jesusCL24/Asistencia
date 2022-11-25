package com.java.curso.controllers;

import com.java.curso.dao.UsuarioDao;
import com.java.curso.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao; //se crea un objeto de la clase usuariodaoimp se guarda esto se llama inyeccion de dependencia

    /*@RequestMapping(value="api/usuarios/{id}")
    public Usuario getUsuario(@PathVariable Long id){
        Usuario usu=new Usuario();
        usu.setId(id);
        usu.setNombre("clau");
        usu.setAppaterno("vargas");
        usu.setApmaterno("lujan");
        usu.setCI(3453245);
        usu.setContrasena("hola");
        return usu;
    }*/

    @RequestMapping(value="api/usuarios",method = RequestMethod.GET)
    public List<Usuario> getUsuarios(){
        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value="api/usuarios",method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario){
        usuarioDao.registrar(usuario);
    }

    /*@RequestMapping(value="daf")
    public Usuario editar(){
        Usuario usu=new Usuario();
        usu.setNombre("clau");
        usu.setApmaterno("vargas");
        usu.setApmaterno("lujan");
        usu.setCI(3453245);
        usu.setContrasena("hola");
        return usu;
    }*/

    @RequestMapping(value="api/usuarios/{id}",method= RequestMethod.DELETE)
    public void eliminar(@PathVariable long id){
        usuarioDao.eliminar(id);
    }




    @RequestMapping(value="usudafario")
    public Usuario buscar(){
        Usuario usu=new Usuario();
        usu.setNombre("clau");
        usu.setApmaterno("vargas");
        usu.setApmaterno("lujan");
        usu.setCI(3453245);
        usu.setContrasena("hola");
        return usu;
    }
}
