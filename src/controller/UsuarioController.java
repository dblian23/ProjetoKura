    package controller;
    
    import Model.Usuario;
    import dao.UsuarioDAO;
    import dao.UsuarioDAOInterface;


public class UsuarioController {

    private UsuarioDAOInterface dao;

    public UsuarioController() {
        this.dao = new UsuarioDAO();
    }

    public boolean cadastrar(Usuario u) {
        return dao.cadastrar(u);
    }

    public Usuario fazerLogin(String email, String senha) {
   //     return dao.fazerLogin(email, senha);
           return dao.login(email, senha);
           
    }
    
    public boolean editar(Usuario u) {
        return dao.editar(u);
    }

    public boolean excluir(int idUsuario) {
        return dao.excluir(idUsuario);
    }
    
}
