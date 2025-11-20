/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Timer;

    

/**
 *
 * @author lianp
 */
public class Pomodoro extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Pomodoro.class.getName());
     
     private int tempoRestante;
     private Timer timer;
     private int ciclo = 0;  // conta quantos ciclos de pomodoro foram feitos
     private boolean emPausa = false;
     private boolean emTrabalho = true;
    /**
     * Creates new form Pomodoro
     */
     
    public Pomodoro() {
        initComponents();
        configurarTimer();
        iniciarTrabalho(); 
        
        jButtonIniciar.addActionListener(e -> jButtonIniciarActionPerformed(e));
        jButtonPausar.addActionListener(e -> jButtonPausarActionPerformed(e));
        jButtonResetar.addActionListener(e -> jButtonResetarActionPerformed(e));
        
    }
    
      private void configurarTimer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tempoRestante > 0) {
                    tempoRestante--;
                    atualizarLabel();
                } else {
                    timer.stop();
                    tocarSom("bip.wav");

                    if (emTrabalho) {
                        ciclo++;

                        if (ciclo % 4 == 0) {
                            iniciarPausaLonga(); // a cada 4 ciclos → pausa longa
                        } else {
                            iniciarPausaCurta();
                        }
                    } else {
                        iniciarTrabalho();
                    }
                }
            }
        });
    }

    private void iniciarTrabalho() {
        tempoRestante = 25 * 60; // 25 min
        emTrabalho = true;
        emPausa = false;
        jLabelStatus.setText("Trabalho");
        atualizarLabel();
    }

    private void iniciarPausaCurta() {
        tempoRestante = 5 * 60; // 5 min
        emTrabalho = false;
        emPausa = true;
        jLabelStatus.setText("Pausa Curta");
        atualizarLabel();
    }

    private void iniciarPausaLonga() {
        tempoRestante = 15 * 60; // 15 min
        emTrabalho = false;
        emPausa = true;
        jLabelStatus.setText("Pausa Longa");
        atualizarLabel();
    }

    private void atualizarLabel() {
        int min = tempoRestante / 60;
        int seg = tempoRestante % 60;
        jLabelTimer.setText(String.format("%02d:%02d", min, seg));
    }

    private void tocarSom(String bip) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(
                getClass().getResource("/View/sounds/bip.wav")
            ));
            clip.start();
        } catch (Exception e) {
            System.out.println("Erro ao reproduzir o som: " + e.getMessage());
        }
    }

    private void jButtonIniciarActionPerformed(java.awt.event.ActionEvent evt) {
        timer.start();
    }

    private void jButtonPausarActionPerformed(java.awt.event.ActionEvent evt) {
        timer.stop();
    }

    private void jButtonResetarActionPerformed(java.awt.event.ActionEvent evt) {
        timer.stop();
        ciclo = 0;
        iniciarTrabalho();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonPausar = new javax.swing.JButton();
        jButtonIniciar = new javax.swing.JButton();
        jButtonResetar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabelStatus = new javax.swing.JLabel();
        jLabelTimer = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonPausar.setContentAreaFilled(false);
        getContentPane().add(jButtonPausar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 643, 140, 130));

        jButtonIniciar.setContentAreaFilled(false);
        getContentPane().add(jButtonIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 660, 150, 120));

        jButtonResetar.setContentAreaFilled(false);
        getContentPane().add(jButtonResetar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 650, 150, 130));

        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 210, 60));

        jLabelStatus.setFont(new java.awt.Font("Gill Sans MT", 0, 48)); // NOI18N
        jLabelStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelStatus.setText("Status");
        getContentPane().add(jLabelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 470, 90));

        jLabelTimer.setFont(new java.awt.Font("Segoe UI", 0, 120)); // NOI18N
        jLabelTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTimer.setText("25:00");
        jLabelTimer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabelTimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 350, 360, 170));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagens/Inicio (13) (1).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        InicioTarefas tarefa = new InicioTarefas();
        tarefa.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Pomodoro().setVisible(true));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonIniciar;
    private javax.swing.JButton jButtonPausar;
    private javax.swing.JButton jButtonResetar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelTimer;
    // End of variables declaration//GEN-END:variables
}
