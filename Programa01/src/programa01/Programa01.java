/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package programa01;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author diegomartineznava
 */
public class Programa01 extends JFrame implements ActionListener{
    
        JButton btnSaludar;
        JTextField texto01;
        
    public Programa01() {
        setSize(400, 400); 
        texto01 = new JTextField("Tu nombre es: ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btnSaludar = new JButton("Saludar");
        setTitle("Programa 01"); 
        btnSaludar.addActionListener(this);
        add(btnSaludar,BorderLayout.SOUTH);
        add(texto01, BorderLayout.CENTER);
    }
    
    public static void main (String[]args){
        Programa01 p = new Programa01();
        p.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog(null, "Hola " + texto01.getText());
    }
}
    