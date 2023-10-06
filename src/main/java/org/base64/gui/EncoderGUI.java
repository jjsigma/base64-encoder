package org.base64.gui;

import org.base64.Base64Tool;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Font;
import java.nio.charset.Charset;
import java.util.Objects;

/**
 *
 * @author tylepants
 */
public class EncoderGUI extends javax.swing.JFrame {
    private Base64Tool base64Tool;

    public EncoderGUI() {
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jTextArea2 = new JTextArea();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jComboBox1 = new JComboBox<>();
        jLabel2 = new JLabel();
        jTextArea3 = new JTextArea();
        jScrollPane2 = new JScrollPane();
        jScrollPane4 = new JScrollPane();

        base64Tool = new Base64Tool();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Base64 Encoder");
        setResizable(false);
        setBackground(new Color(51, 255, 204));
        setBounds(new Rectangle(550, 250, 800, 700));
        getContentPane().setLayout(new AbsoluteLayout());

        jPanel1.setBackground(new Color(0, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255), 8));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 600));
        jPanel1.setLayout(new AbsoluteLayout());

        jLabel1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 30));
        jLabel1.setText("Base64 Encoder/Decoder");
        jPanel1.add(jLabel1, new AbsoluteConstraints(190, 20, 370, 50));

        jTextArea2.setBackground(new java.awt.Color(204, 255, 255));
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);
        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 640, 190));

        jButton1.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 24));
        jButton1.setText("Decode");
        jButton1.addActionListener(e -> {

        });
        jPanel1.add(jButton1, new AbsoluteConstraints(510, 290, 150, 60));

        jButton2.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        jButton2.setText("Encode");
        jButton2.addActionListener(e -> {
            String data = jTextArea3.getText();
            String encoded = base64Tool.encode(data.getBytes(Charset.forName((String) Objects.requireNonNull(jComboBox1.getSelectedItem()))));
            jTextArea2.setText(encoded);
        });
        jPanel1.add(jButton2, new AbsoluteConstraints(330, 290, 150, 60));

        jComboBox1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "UTF-8", "ASCII", "UTF-16", "Windows-1251", "Windows-1252" }));
        jPanel1.add(jComboBox1, new AbsoluteConstraints(40, 320, 130, 30));

        jLabel2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        jLabel2.setText("Character set");
        jPanel1.add(jLabel2, new AbsoluteConstraints(40, 280, 130, 30));

        jTextArea3.setBackground(new java.awt.Color(204, 255, 255));
        jTextArea3.setColumns(20);
        jTextArea3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        jTextArea3.setRows(5);
        jScrollPane4.setViewportView(jTextArea3);
        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 640, 190));

        getContentPane().add(jPanel1, new AbsoluteConstraints(0, 0, -1, 600));
        jPanel1.getAccessibleContext().setAccessibleName("");

        pack();
    }

    private JButton jButton1;
    private JButton jButton2;
    private JComboBox<String> jComboBox1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JTextArea jTextArea2;
    private JTextArea jTextArea3;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane4;
}

