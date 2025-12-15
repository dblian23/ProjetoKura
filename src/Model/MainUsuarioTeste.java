package Model;

import controller.UsuarioController;
import java.time.LocalDate;

public class MainUsuarioTeste {

    public static void main(String[] args) {

        UsuarioController controller = new UsuarioController();

        // ===== Criar primeiro usuário =====
        Usuario u1 = new Usuario(
                0,
                "Usuario Teste 1",
                "teste1@email.com",
                "1234",
                LocalDate.of(2000, 1, 1)
        );

        boolean cadastrado1 = controller.cadastrar(u1);
        System.out.println("Usuário 1 cadastrado: " + cadastrado1);

        // ===== Criar segundo usuário =====
        Usuario u2 = new Usuario(
                0,
                "Usuario Teste 2",
                "teste2@email.com",
                "abcd",
                LocalDate.of(1999, 5, 10)
        );

        boolean cadastrado2 = controller.cadastrar(u2);
        System.out.println("Usuário 2 cadastrado: " + cadastrado2);

        // ===== Fazer login do primeiro usuário =====
        Usuario usuarioLogado = controller.fazerLogin("teste1@email.com", "1234");

        if (usuarioLogado != null) {
            System.out.println("Login do usuário 1 realizado. ID: " + usuarioLogado.getIdUsuario());

            // ===== Editar dados do primeiro usuário =====
            usuarioLogado.setNome("Usuario Teste 1 - EDITADO");
            usuarioLogado.setSenha("novaSenha123");

            boolean editado = controller.editar(usuarioLogado);
            System.out.println("Usuário 1 editado: " + editado);
        } else {
            System.out.println("Falha no login do usuário 1");
        }

        // ===== Fazer login do segundo usuário =====
        Usuario usuarioExcluir = controller.fazerLogin("teste2@email.com", "abcd");

        if (usuarioExcluir != null) {
            boolean excluido = controller.excluir(usuarioExcluir.getIdUsuario());
            System.out.println("Usuário 2 excluído: " + excluido);
        } else {
            System.out.println("Usuário 2 não encontrado para exclusão");
        }

        System.out.println("=== FIM DO TESTE DE USUÁRIO ===");
    }
}
