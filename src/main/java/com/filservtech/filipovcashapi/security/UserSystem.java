package com.filservtech.filipovcashapi.security;

import com.filservtech.filipovcashapi.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UserSystem extends User {

    private static final long serialVersionUID = 1L;

    private Usuario usuario;

    public UserSystem(Usuario usuario, Collection<? extends GrantedAuthority> authorities) {
        super(usuario.getEmail(), usuario.getSenha(), authorities);
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

}
