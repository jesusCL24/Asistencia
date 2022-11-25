package com.java.curso.controllers;

import com.java.curso.dao.UsuarioDao;
import com.java.curso.models.Usuario;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private UsuarioDao usuarioDao;

    public AuthController(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    @RequestMapping(value="api/login",method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){

        if (usuarioDao.verificarDatos(usuario)){
            return "ok";
        }
        return "fail";
    }
}
