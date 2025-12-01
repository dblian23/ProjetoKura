package controller;

import dao.UsuarioDAO;
import Model.Usuario;

public class UsuarioController {

    private UsuarioDAO dao;

    public UsuarioController() {
        this.dao = new UsuarioDAO();
    }

    public boolean cadastrar(Usuario u) {
        return dao.cadastrar(u);
    }

    public Usuario fazerLogin(String email, String senha) {
        return dao.fazerLogin(email, senha);
    }
}
