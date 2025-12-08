package controller;

import Model.Usuario;
import View.Cadastro;
import View.Login;
import View.InicioTarefas;
import java.time.LocalDate;



import javax.swing.*;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Liga as telas Login e Cadastro ao UsuarioController (que chama o DAO)
 * sem alterar o código gerado pelas interfaces.
 */
public class UsuarioUIBinder {

    private static final Logger logger = Logger.getLogger(UsuarioUIBinder.class.getName());

    // ===================== LOGIN =====================
    public static void bindToLogin(Login login) {
        try {
            // botão "Entrar"
            Field fBtnEntrar = login.getClass().getDeclaredField("jButtonEntrar");
            fBtnEntrar.setAccessible(true);
            JButton btnEntrar = (JButton) fBtnEntrar.get(login);
            btnEntrar.addActionListener(e -> realizarLogin(login));

            // botão "Realizar Cadastro"
            Field fBtnCadastro = login.getClass().getDeclaredField("jButtonCad");
            fBtnCadastro.setAccessible(true);
            JButton btnCadastro = (JButton) fBtnCadastro.get(login);
            btnCadastro.addActionListener(e -> {
                Cadastro cad = new Cadastro();
                UsuarioUIBinder.bindToCadastro(cad);
                cad.setVisible(true);
            });

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao anexar eventos ao Login", e);
        }
    }

private static void realizarLogin(Login login) {
    try {
        Field fEmail = login.getClass().getDeclaredField("jTextField2");
        Field fSenha = login.getClass().getDeclaredField("jPasswordField1");

        fEmail.setAccessible(true);
        fSenha.setAccessible(true);

        String email = ((JTextField) fEmail.get(login)).getText();
        String senha = new String(((JPasswordField) fSenha.get(login)).getPassword());

        System.out.println("[DEBUG] EMAIL DIGITADO = [" + email + "]");
        System.out.println("[DEBUG] SENHA DIGITADA = [" + senha + "]");

        // Remove espaços
        email = email.trim();
        senha = senha.trim();

        System.out.println("[DEBUG] EMAIL APÓS TRIM = [" + email + "]");
        System.out.println("[DEBUG] SENHA APÓS TRIM = [" + senha + "]");

        UsuarioController controller = new UsuarioController();
     //   Usuario u = controller.login(email, senha);
        Usuario u = controller.fazerLogin(email, senha);


        System.out.println("[DEBUG] RETORNO DO controller.login = " + u);

        if (u != null) {
            JOptionPane.showMessageDialog(login, "Login realizado com sucesso!");
            new InicioTarefas().setVisible(true);
            login.dispose();
        } else {
            JOptionPane.showMessageDialog(login, "Email ou senha incorretos.");
        }

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(login, "Erro interno: " + e.getMessage());
    }
}

    // ===================== CADASTRO =====================
    public static void bindToCadastro(Cadastro cadastro) {
        try {
            // botão cadastrar
            Field fBtnCadastrar = cadastro.getClass().getDeclaredField("jButtonCadastrar");
            fBtnCadastrar.setAccessible(true);
            JButton btnCadastrar = (JButton) fBtnCadastrar.get(cadastro);
            btnCadastrar.addActionListener(e -> realizarCadastro(cadastro));

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao anexar eventos ao Cadastro", e);
        }
    }

    private static void realizarCadastro(Cadastro cadastro) {
        try {
            Field fNome = cadastro.getClass().getDeclaredField("jTextField5");
            Field fEmail = cadastro.getClass().getDeclaredField("jTextField6");
            Field fSenha = cadastro.getClass().getDeclaredField("jPasswordField1");
            Field fData  = cadastro.getClass().getDeclaredField("jTextField4");

            fNome.setAccessible(true);
            fEmail.setAccessible(true);
            fSenha.setAccessible(true);
            fData.setAccessible(true);

            String nome = ((JTextField) fNome.get(cadastro)).getText().trim();
            String email = ((JTextField) fEmail.get(cadastro)).getText().trim();
            String senha = new String(((JPasswordField) fSenha.get(cadastro)).getPassword()).trim();
            String data  = ((JTextField) fData.get(cadastro)).getText().trim();

                
            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || data.isEmpty()) {
                JOptionPane.showMessageDialog(cadastro, "Preencha todos os campos!");
                return;
            }

            UsuarioController controller = new UsuarioController();
//            boolean sucesso = controller.cadastrar(nome, email, senha, data);
            LocalDate dataNasc = LocalDate.parse(data);
//            Usuario novo = new Usuario(nome, email, senha, dataNasc);
            Usuario novo = new Usuario(0, nome, email, senha, dataNasc);

            boolean sucesso = controller.cadastrar(novo);

            if (sucesso) {
                JOptionPane.showMessageDialog(cadastro, "Usuário cadastrado com sucesso!");
                cadastro.dispose();
            } else {
                JOptionPane.showMessageDialog(cadastro, "Falha ao cadastrar usuário.", "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao realizar cadastro", e);
        }
    }
}
