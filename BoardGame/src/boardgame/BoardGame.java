/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardgame;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Furkan
 */
public class BoardGame extends javax.swing.JFrame {

    /**
     * Creates new form BoardGame_
     */
    public ArrayList<JButton> buttons = new ArrayList<>();
    public ArrayList<Piece> allPieces = new ArrayList<>();

    public ArrayList<String> moveList = new ArrayList<>();
    
    public Player player1;
    public Player player2;
    public Player Playing;
    public Player thisPlayer;

    boolean selected = false; // HAndle multiplayer

    Socket socket = null;

    public static ObjectInputStream iStream;
    public static ObjectOutputStream oStream;

    boolean lastC = false; // Handling for rivals virtual movement

    public BoardGame() {
        initComponents();
        this.setResizable(false);
        startGame();
    }
    public void startGame(){
        this.player1 = new Player(true);
        this.player2 = new Player(false);
        player1.setRival(player2);
        player2.setRival(player1);
        this.findButtons();
        this.setButtons();
    }
    public void findButtons() { // Only executed once at starting
        try {
            ArrayList<JButton> but = new ArrayList<>();
            Class c = Class.forName(this.getClass().getName());
            Field[] f = c.getDeclaredFields();
            for (Field f1 : f) {
                if (!f1.getType().equals(JButton.class)) {
                    continue;
                }
                JButton b = (JButton) f1.get(this);
                but.add(b);
            }
            buttons = but;
        } catch (Exception e) {

        }
    }

    public void setButtons() { // Executes when play area has changes
        for (JButton bu : buttons) {
            if (player1.isHere(bu.getName())) {
                if (player1.isOne) {
                    bu.setIcon(new ImageIcon(this.getClass().getResource("/pictures/blue.png")));
                } else {
                    bu.setIcon(new ImageIcon(this.getClass().getResource("/pictures/red.png")));
                }
            } else if (player2.isHere(bu.getName())) {
                if (player2.isOne) {
                    bu.setIcon(new ImageIcon(this.getClass().getResource("/pictures/blue.png")));
                } else {
                    bu.setIcon(new ImageIcon(this.getClass().getResource("/pictures/red.png")));
                }
            } else {
                bu.setIcon(new ImageIcon(this.getClass().getResource("/pictures/empty.png")));
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        L0_0 = new javax.swing.JButton();
        L1_0 = new javax.swing.JButton();
        L1_1 = new javax.swing.JButton();
        L1_2 = new javax.swing.JButton();
        L1_3 = new javax.swing.JButton();
        L1_4 = new javax.swing.JButton();
        L1_5 = new javax.swing.JButton();
        L1_6 = new javax.swing.JButton();
        L1_7 = new javax.swing.JButton();
        L2_0 = new javax.swing.JButton();
        L2_1 = new javax.swing.JButton();
        L2_2 = new javax.swing.JButton();
        L2_3 = new javax.swing.JButton();
        L2_4 = new javax.swing.JButton();
        L2_5 = new javax.swing.JButton();
        L2_6 = new javax.swing.JButton();
        L2_7 = new javax.swing.JButton();
        L3_0 = new javax.swing.JButton();
        L3_1 = new javax.swing.JButton();
        L3_2 = new javax.swing.JButton();
        L3_3 = new javax.swing.JButton();
        L3_4 = new javax.swing.JButton();
        L3_5 = new javax.swing.JButton();
        L3_6 = new javax.swing.JButton();
        L3_7 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        console = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setSize(new java.awt.Dimension(1093, 599));
        getContentPane().setLayout(null);

        L0_0.setBorderPainted(false);
        L0_0.setContentAreaFilled(false);
        L0_0.setFocusPainted(false);
        L0_0.setMaximumSize(new java.awt.Dimension(32, 32));
        L0_0.setMinimumSize(new java.awt.Dimension(32, 32));
        L0_0.setName("L0_0"); // NOI18N
        L0_0.setPreferredSize(new java.awt.Dimension(32, 32));
        L0_0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                L0_0MousePressed(evt);
            }
        });
        getContentPane().add(L0_0);
        L0_0.setBounds(390, 290, 32, 32);

        L1_0.setContentAreaFilled(false);
        L1_0.setMaximumSize(new java.awt.Dimension(32, 32));
        L1_0.setMinimumSize(new java.awt.Dimension(32, 32));
        L1_0.setName("L1_0"); // NOI18N
        L1_0.setPreferredSize(new java.awt.Dimension(32, 32));
        L1_0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                L1_0MousePressed(evt);
            }
        });
        getContentPane().add(L1_0);
        L1_0.setBounds(390, 200, 32, 32);

        L1_1.setContentAreaFilled(false);
        L1_1.setMaximumSize(new java.awt.Dimension(32, 32));
        L1_1.setMinimumSize(new java.awt.Dimension(32, 32));
        L1_1.setName("L1_1"); // NOI18N
        L1_1.setPreferredSize(new java.awt.Dimension(32, 32));
        L1_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                L1_1MousePressed(evt);
            }
        });
        getContentPane().add(L1_1);
        L1_1.setBounds(450, 230, 32, 32);

        L1_2.setBorderPainted(false);
        L1_2.setContentAreaFilled(false);
        L1_2.setFocusPainted(false);
        L1_2.setMaximumSize(new java.awt.Dimension(32, 32));
        L1_2.setMinimumSize(new java.awt.Dimension(32, 32));
        L1_2.setName("L1_2"); // NOI18N
        L1_2.setPreferredSize(new java.awt.Dimension(32, 32));
        L1_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                L1_2MousePressed(evt);
            }
        });
        getContentPane().add(L1_2);
        L1_2.setBounds(460, 290, 32, 32);

        L1_3.setContentAreaFilled(false);
        L1_3.setMaximumSize(new java.awt.Dimension(32, 32));
        L1_3.setMinimumSize(new java.awt.Dimension(32, 32));
        L1_3.setName("L1_3"); // NOI18N
        L1_3.setPreferredSize(new java.awt.Dimension(32, 32));
        L1_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                L1_3MousePressed(evt);
            }
        });
        getContentPane().add(L1_3);
        L1_3.setBounds(450, 340, 32, 32);

        L1_4.setContentAreaFilled(false);
        L1_4.setMaximumSize(new java.awt.Dimension(32, 32));
        L1_4.setMinimumSize(new java.awt.Dimension(32, 32));
        L1_4.setName("L1_4"); // NOI18N
        L1_4.setPreferredSize(new java.awt.Dimension(32, 32));
        L1_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                L1_4MousePressed(evt);
            }
        });
        getContentPane().add(L1_4);
        L1_4.setBounds(390, 370, 32, 32);

        L1_5.setContentAreaFilled(false);
        L1_5.setMaximumSize(new java.awt.Dimension(32, 32));
        L1_5.setMinimumSize(new java.awt.Dimension(32, 32));
        L1_5.setName("L1_5"); // NOI18N
        L1_5.setPreferredSize(new java.awt.Dimension(32, 32));
        L1_5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                L1_5MousePressed(evt);
            }
        });
        getContentPane().add(L1_5);
        L1_5.setBounds(320, 330, 32, 32);

        L1_6.setContentAreaFilled(false);
        L1_6.setMaximumSize(new java.awt.Dimension(32, 32));
        L1_6.setMinimumSize(new java.awt.Dimension(32, 32));
        L1_6.setName("L1_6"); // NOI18N
        L1_6.setPreferredSize(new java.awt.Dimension(32, 32));
        L1_6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                L1_6MousePressed(evt);
            }
        });
        getContentPane().add(L1_6);
        L1_6.setBounds(300, 290, 32, 32);

        L1_7.setContentAreaFilled(false);
        L1_7.setMaximumSize(new java.awt.Dimension(32, 32));
        L1_7.setMinimumSize(new java.awt.Dimension(32, 32));
        L1_7.setName("L1_7"); // NOI18N
        L1_7.setPreferredSize(new java.awt.Dimension(32, 32));
        L1_7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                L1_7MousePressed(evt);
            }
        });
        getContentPane().add(L1_7);
        L1_7.setBounds(320, 230, 32, 32);

        L2_0.setContentAreaFilled(false);
        L2_0.setMaximumSize(new java.awt.Dimension(32, 32));
        L2_0.setMinimumSize(new java.awt.Dimension(32, 32));
        L2_0.setName("L2_0"); // NOI18N
        L2_0.setPreferredSize(new java.awt.Dimension(32, 32));
        L2_0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                L2_0MousePressed(evt);
            }
        });
        getContentPane().add(L2_0);
        L2_0.setBounds(390, 140, 32, 32);

        L2_1.setContentAreaFilled(false);
        L2_1.setMaximumSize(new java.awt.Dimension(32, 32));
        L2_1.setMinimumSize(new java.awt.Dimension(32, 32));
        L2_1.setName("L2_1"); // NOI18N
        L2_1.setPreferredSize(new java.awt.Dimension(32, 32));
        L2_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                L2_1MousePressed(evt);
            }
        });
        getContentPane().add(L2_1);
        L2_1.setBounds(500, 200, 32, 32);

        L2_2.setContentAreaFilled(false);
        L2_2.setMaximumSize(new java.awt.Dimension(32, 32));
        L2_2.setMinimumSize(new java.awt.Dimension(32, 32));
        L2_2.setName("L2_2"); // NOI18N
        L2_2.setPreferredSize(new java.awt.Dimension(32, 32));
        L2_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                L2_2MousePressed(evt);
            }
        });
        getContentPane().add(L2_2);
        L2_2.setBounds(530, 290, 32, 32);

        L2_3.setContentAreaFilled(false);
        L2_3.setMaximumSize(new java.awt.Dimension(32, 32));
        L2_3.setMinimumSize(new java.awt.Dimension(32, 32));
        L2_3.setName("L2_3"); // NOI18N
        L2_3.setPreferredSize(new java.awt.Dimension(32, 32));
        L2_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                L2_3MousePressed(evt);
            }
        });
        getContentPane().add(L2_3);
        L2_3.setBounds(510, 370, 32, 32);

        L2_4.setContentAreaFilled(false);
        L2_4.setMaximumSize(new java.awt.Dimension(32, 32));
        L2_4.setMinimumSize(new java.awt.Dimension(32, 32));
        L2_4.setName("L2_4"); // NOI18N
        L2_4.setPreferredSize(new java.awt.Dimension(32, 32));
        L2_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                L2_4MousePressed(evt);
            }
        });
        getContentPane().add(L2_4);
        L2_4.setBounds(390, 430, 32, 32);

        L2_5.setContentAreaFilled(false);
        L2_5.setMaximumSize(new java.awt.Dimension(32, 32));
        L2_5.setMinimumSize(new java.awt.Dimension(32, 32));
        L2_5.setName("L2_5"); // NOI18N
        L2_5.setPreferredSize(new java.awt.Dimension(32, 32));
        L2_5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                L2_5MousePressed(evt);
            }
        });
        getContentPane().add(L2_5);
        L2_5.setBounds(270, 370, 32, 32);

        L2_6.setContentAreaFilled(false);
        L2_6.setMaximumSize(new java.awt.Dimension(32, 32));
        L2_6.setMinimumSize(new java.awt.Dimension(32, 32));
        L2_6.setName("L2_6"); // NOI18N
        L2_6.setPreferredSize(new java.awt.Dimension(32, 32));
        L2_6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                L2_6MousePressed(evt);
            }
        });
        getContentPane().add(L2_6);
        L2_6.setBounds(240, 290, 32, 32);

        L2_7.setContentAreaFilled(false);
        L2_7.setMaximumSize(new java.awt.Dimension(32, 32));
        L2_7.setMinimumSize(new java.awt.Dimension(32, 32));
        L2_7.setName("L2_7"); // NOI18N
        L2_7.setPreferredSize(new java.awt.Dimension(32, 32));
        L2_7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                L2_7MousePressed(evt);
            }
        });
        getContentPane().add(L2_7);
        L2_7.setBounds(260, 200, 32, 32);

        L3_0.setContentAreaFilled(false);
        L3_0.setMaximumSize(new java.awt.Dimension(32, 32));
        L3_0.setMinimumSize(new java.awt.Dimension(32, 32));
        L3_0.setName("L3_0"); // NOI18N
        L3_0.setPreferredSize(new java.awt.Dimension(32, 32));
        L3_0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                L3_0MousePressed(evt);
            }
        });
        getContentPane().add(L3_0);
        L3_0.setBounds(390, 80, 32, 32);

        L3_1.setContentAreaFilled(false);
        L3_1.setMaximumSize(new java.awt.Dimension(32, 32));
        L3_1.setMinimumSize(new java.awt.Dimension(32, 32));
        L3_1.setName("L3_1"); // NOI18N
        L3_1.setPreferredSize(new java.awt.Dimension(32, 32));
        L3_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                L3_1MousePressed(evt);
            }
        });
        getContentPane().add(L3_1);
        L3_1.setBounds(560, 160, 32, 32);

        L3_2.setContentAreaFilled(false);
        L3_2.setMaximumSize(new java.awt.Dimension(32, 32));
        L3_2.setMinimumSize(new java.awt.Dimension(32, 32));
        L3_2.setName("L3_2"); // NOI18N
        L3_2.setPreferredSize(new java.awt.Dimension(32, 32));
        L3_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                L3_2MousePressed(evt);
            }
        });
        getContentPane().add(L3_2);
        L3_2.setBounds(600, 290, 32, 32);

        L3_3.setContentAreaFilled(false);
        L3_3.setMaximumSize(new java.awt.Dimension(32, 32));
        L3_3.setMinimumSize(new java.awt.Dimension(32, 32));
        L3_3.setName("L3_3"); // NOI18N
        L3_3.setPreferredSize(new java.awt.Dimension(32, 32));
        L3_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                L3_3MousePressed(evt);
            }
        });
        getContentPane().add(L3_3);
        L3_3.setBounds(550, 410, 32, 32);

        L3_4.setContentAreaFilled(false);
        L3_4.setMaximumSize(new java.awt.Dimension(32, 32));
        L3_4.setMinimumSize(new java.awt.Dimension(32, 32));
        L3_4.setName("L3_4"); // NOI18N
        L3_4.setPreferredSize(new java.awt.Dimension(32, 32));
        L3_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                L3_4MousePressed(evt);
            }
        });
        getContentPane().add(L3_4);
        L3_4.setBounds(390, 500, 32, 32);

        L3_5.setContentAreaFilled(false);
        L3_5.setMaximumSize(new java.awt.Dimension(32, 32));
        L3_5.setMinimumSize(new java.awt.Dimension(32, 32));
        L3_5.setName("L3_5"); // NOI18N
        L3_5.setPreferredSize(new java.awt.Dimension(32, 32));
        L3_5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                L3_5MousePressed(evt);
            }
        });
        getContentPane().add(L3_5);
        L3_5.setBounds(220, 410, 32, 32);

        L3_6.setContentAreaFilled(false);
        L3_6.setMaximumSize(new java.awt.Dimension(32, 32));
        L3_6.setMinimumSize(new java.awt.Dimension(32, 32));
        L3_6.setName("L3_6"); // NOI18N
        L3_6.setPreferredSize(new java.awt.Dimension(32, 32));
        L3_6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                L3_6MousePressed(evt);
            }
        });
        getContentPane().add(L3_6);
        L3_6.setBounds(180, 290, 32, 32);

        L3_7.setContentAreaFilled(false);
        L3_7.setMaximumSize(new java.awt.Dimension(32, 32));
        L3_7.setMinimumSize(new java.awt.Dimension(32, 32));
        L3_7.setName("L3_7"); // NOI18N
        L3_7.setPreferredSize(new java.awt.Dimension(32, 32));
        L3_7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                L3_7MousePressed(evt);
            }
        });
        getContentPane().add(L3_7);
        L3_7.setBounds(210, 160, 32, 32);

        jButton1.setText("Start Game (Connect)");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(10, 10, 190, 60);

        console.setEditable(false);
        console.setColumns(20);
        console.setRows(5);
        jScrollPane1.setViewportView(console);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(210, 10, 570, 70);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 110, 190, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/background.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void L0_0MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L0_0MousePressed
        Handler((JButton) evt.getSource());
    }//GEN-LAST:event_L0_0MousePressed

    private void L1_0MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L1_0MousePressed
        Handler((JButton) evt.getSource());
    }//GEN-LAST:event_L1_0MousePressed

    private void L1_1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L1_1MousePressed
        Handler((JButton) evt.getSource());
    }//GEN-LAST:event_L1_1MousePressed

    private void L1_2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L1_2MousePressed
        Handler((JButton) evt.getSource());
    }//GEN-LAST:event_L1_2MousePressed

    private void L1_3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L1_3MousePressed
        Handler((JButton) evt.getSource());
    }//GEN-LAST:event_L1_3MousePressed

    private void L1_4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L1_4MousePressed
        Handler((JButton) evt.getSource());
    }//GEN-LAST:event_L1_4MousePressed

    private void L1_5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L1_5MousePressed
        Handler((JButton) evt.getSource());
    }//GEN-LAST:event_L1_5MousePressed

    private void L1_6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L1_6MousePressed
        Handler((JButton) evt.getSource());
    }//GEN-LAST:event_L1_6MousePressed

    private void L1_7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L1_7MousePressed
        Handler((JButton) evt.getSource());
    }//GEN-LAST:event_L1_7MousePressed

    private void L2_0MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L2_0MousePressed
        Handler((JButton) evt.getSource());
    }//GEN-LAST:event_L2_0MousePressed

    private void L2_1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L2_1MousePressed
        Handler((JButton) evt.getSource());
    }//GEN-LAST:event_L2_1MousePressed

    private void L2_2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L2_2MousePressed
        Handler((JButton) evt.getSource());
    }//GEN-LAST:event_L2_2MousePressed

    private void L2_3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L2_3MousePressed
        Handler((JButton) evt.getSource());
    }//GEN-LAST:event_L2_3MousePressed

    private void L2_4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L2_4MousePressed
        Handler((JButton) evt.getSource());
    }//GEN-LAST:event_L2_4MousePressed

    private void L2_5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L2_5MousePressed
        Handler((JButton) evt.getSource());
    }//GEN-LAST:event_L2_5MousePressed

    private void L2_6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L2_6MousePressed
        Handler((JButton) evt.getSource());
    }//GEN-LAST:event_L2_6MousePressed

    private void L2_7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L2_7MousePressed
        Handler((JButton) evt.getSource());
    }//GEN-LAST:event_L2_7MousePressed

    private void L3_0MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L3_0MousePressed
        Handler((JButton) evt.getSource());
    }//GEN-LAST:event_L3_0MousePressed

    private void L3_1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L3_1MousePressed
        Handler((JButton) evt.getSource());
    }//GEN-LAST:event_L3_1MousePressed

    private void L3_2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L3_2MousePressed
        Handler((JButton) evt.getSource());
    }//GEN-LAST:event_L3_2MousePressed

    private void L3_3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L3_3MousePressed
        Handler((JButton) evt.getSource());
    }//GEN-LAST:event_L3_3MousePressed

    private void L3_4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L3_4MousePressed
        Handler((JButton) evt.getSource());
    }//GEN-LAST:event_L3_4MousePressed

    private void L3_5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L3_5MousePressed
        Handler((JButton) evt.getSource());
    }//GEN-LAST:event_L3_5MousePressed

    private void L3_6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L3_6MousePressed
        Handler((JButton) evt.getSource());
    }//GEN-LAST:event_L3_6MousePressed

    private void L3_7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L3_7MousePressed
        Handler((JButton) evt.getSource());
    }//GEN-LAST:event_L3_7MousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            int i;
            socket = new Socket("0.0.0.0", 7187);
            addConsole("Connecting success");
            oStream = new ObjectOutputStream(socket.getOutputStream());
            oStream.flush();
            iStream = new ObjectInputStream(socket.getInputStream());
            i = (Integer) iStream.readObject();
            if (i == 1) {
                thisPlayer = player1;
                addConsole("YOUR TURN");
                jLabel2.setText("YOUR PIECES BLUE");
            } else if (i == 2) {
                thisPlayer = player2;
                addConsole("YOUR RIVALS TURN");
                jLabel2.setText("YOUR PIECES RED");
            }
            Playing = player1;
            ThreadClient tc = new ThreadClient(iStream);
            tc.start();
            System.out.println("Created thread");
        } catch (Exception ex) {
            addConsole("Server must created first");
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    /*
     *Handler function has got two section
     *1-
     *Program counter enters first section
     *when piece is selected. And this action
     *will not and until player select a valid
     *piece to play.
     *2-
     *If player selects valid piece;
     *selected boolean changes value to true
     *and next handler func. comes from a JButton
     *PC enters second section. In this section,
     *control functions makes decision to move
     *to piece and make the action. After end 
     *of this section. Playing side will changes 
     *and board refreshes.
     *
     */
    void Handler(JButton b) {
        if((thisPlayer.equals(Playing) || lastC) && !Playing.equals(null)){
            if (!selected) { // First section
                if(lastC == true) Playing = thisPlayer.getRival();
                if (Playing.playFrom(b)) {
                    addConsole("Now you can select somewhere to move !");
                    selected = true;
                    moveList.add(b.getName()); // Adding move queue ..
                    if (Playing == player1) {
                        b.setIcon(new ImageIcon(this.getClass().getResource("/pictures/blue_move.png")));
                    } else {
                        b.setIcon(new ImageIcon(this.getClass().getResource("/pictures/red_move.png")));
                    }
                } else {
                    addConsole("You have to select a piece that is yours ! "+b.getName());
                }
            } else { // Second section
                if (!isSamePiece(b)) {
                    if (this.isEmpty(b.getName()) && Playing.isInPossibleSet(b.getName())) { // Valid play movements
                        if (Playing.isInScoreSet(b.getName())) {
                            Playing.scoreMoveTo(b.getName());
                            if (!Playing.isScoreSetEmpty(b.getName())) {
                                this.setButtons();
                                moveList.add(b.getName()); // Adding move queue ..
                                //Note there is no sending because turn is not over..
                                Handler(b);
                                addConsole("Yeni hareket geliyor");
                            } else {
                                moveList.add(b.getName()); // Adding move queue ..
                                if (thisPlayer == Playing) { write(moveList); }// sending moveList to rival
                                moveList = new ArrayList<>();
                                if(lastC == true) Playing = Playing.getRival();
                                this.setButtons();
                                selected = false;
                            }
                        } else {
                            Playing.defaultMoveTo(b.getName());
                            moveList.add(b.getName()); // Adding move queue ..
                            if (thisPlayer == Playing) { write(moveList); Playing = Playing.getRival();} // sending moveList to rival
                            moveList = new ArrayList<>();
                            if(lastC == true) Playing = Playing.getRival();
                            this.setButtons();
                            selected = false;
                        }
                    } else {
                        addConsole("This piece is not in possible movement set");
                    }
                } else {
                    // Selected her or his own piece :)
                    // Redirected to handle again :))
                    selected = false;
                    Handler(b);
                }
            }
        }else addConsole("NOT YOUR TURN !!!");
        scoreControl();
    }

    String toHandler(String s) { // This string is button name that rival play.
        for (JButton button : buttons) {
            if(button.getName().equals(s)){Handler(button); return "Basarili";}
        }
        return null;
    }

    void write(ArrayList<String> al) {
        try {
            oStream.writeObject(al);
            oStream.flush();
        } catch (IOException ex) {
            Logger.getLogger(BoardGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    String read() throws ClassNotFoundException {
        
        try {
            iStream = new ObjectInputStream(socket.getInputStream());
            return (String) iStream.readObject();
        } catch (IOException ex) {
            Logger.getLogger(BoardGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    boolean isEmpty(String b) {
        if (Playing.isHere(b) || Playing.rival.isHere(b)) {
            return false;
        }

        return true;
    }

    boolean isSamePiece(JButton b) {
        if (Playing.isHere(b.getName())) {
            return true;
        }

        return false;
    }

    void addConsole(String s) {
        char carrige = 10;
        console.setText(console.getText()+s + carrige);
    }
    void scoreControl(){
        try{
        if(player1.pieces.size()<3){
            if(thisPlayer.equals(player1)){
                JOptionPane.showMessageDialog(rootPane, "Player 2 is won, YOU LOSE !");
            }else{
                JOptionPane.showMessageDialog(rootPane, "YOU WIN !");
            }
        socket.close();
        oStream.close();
        iStream.close();
        startGame(); // Starting game again. This method will build board again.
        }else if(player2.pieces.size()<3){
            if(thisPlayer.equals(player1)){
                JOptionPane.showMessageDialog(rootPane, "Player 1 is won, YOU LOSE !");
            }else{
                JOptionPane.showMessageDialog(rootPane, "YOU WIN !");
            }
        socket.close();
        oStream.close();
        iStream.close();
        startGame();
        }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BoardGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BoardGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BoardGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BoardGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BoardGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton L0_0;
    private javax.swing.JButton L1_0;
    private javax.swing.JButton L1_1;
    private javax.swing.JButton L1_2;
    private javax.swing.JButton L1_3;
    private javax.swing.JButton L1_4;
    private javax.swing.JButton L1_5;
    private javax.swing.JButton L1_6;
    private javax.swing.JButton L1_7;
    private javax.swing.JButton L2_0;
    private javax.swing.JButton L2_1;
    private javax.swing.JButton L2_2;
    private javax.swing.JButton L2_3;
    private javax.swing.JButton L2_4;
    private javax.swing.JButton L2_5;
    private javax.swing.JButton L2_6;
    private javax.swing.JButton L2_7;
    private javax.swing.JButton L3_0;
    private javax.swing.JButton L3_1;
    private javax.swing.JButton L3_2;
    private javax.swing.JButton L3_3;
    private javax.swing.JButton L3_4;
    private javax.swing.JButton L3_5;
    private javax.swing.JButton L3_6;
    private javax.swing.JButton L3_7;
    private javax.swing.JTextArea console;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    public class ThreadClient implements Runnable { // First thread that 

        private Thread t;
        ObjectInputStream ois;
        public ArrayList<String> moveList = new ArrayList<>();

        public ThreadClient(ObjectInputStream is) {
            ois = is;
        }

        public void run() {
            try {
                while(true){
                moveList = (ArrayList<String>) ois.readObject();
                addConsole("Move recieved from"+ moveList.get(0).toString());
                lastC = true;
                for (String string : moveList) {
                    System.out.println(string);
                    System.out.println(toHandler(string)); // Plays recieved String from rival..
                }
                lastC = false;
                }
            } catch (Exception e) {
                //e.printStackTrace(); // Catch when connection end..
            }
        }

        public void start() {
            if (t == null) {
                t = new Thread(this, "");
                t.start();
            }
        }
    }

}
