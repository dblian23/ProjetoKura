package controller;

import dao.UsuarioDAO;
import Model.Usuario;

public class UsuarioController {

    UsuarioDAO dao = new UsuarioDAO();

    public boolean cadastrar(String nome, String email, String senha, String dataNascimento) {
        Usuario u = new Usuario(nome, email, senha, dataNascimento);
        return dao.cadastrar(u);
    }

    public Usuario login(String email, String senha) {
        return dao.login(email, senha);
    }
}
