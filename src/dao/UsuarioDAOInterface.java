package dao;

import Model.Usuario;

public interface UsuarioDAOInterface {

    boolean cadastrar(Usuario usuario);

    Usuario login(String email, String senha);
}
