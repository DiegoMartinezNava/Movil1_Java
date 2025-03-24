package calculadora;

import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author diegomartineznava
 */

public class Calculadora extends JFrame implements ActionListener {
    JTextField pantalla;
    JButton[] botones = new JButton[10];
    JButton bsuma, bresta, bdivision, bmultiplicacion, bpunto, bigual, bborrar;

    double num1, num2, resultado;
    char operador;

    public Calculadora() {
        setTitle("Calculadora");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Pantalla
        pantalla = new JTextField();
        pantalla.setBounds(20, 20, 350, 80);
        Font f = new Font("Arial", Font.PLAIN, 40);
        pantalla.setFont(f);
        pantalla.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        pantalla.setEditable(false);
        add(pantalla);

        // Botón "C" (borrar) - ahora está arriba a la derecha
        bborrar = new JButton("C");
        bborrar.setBounds(380, 20, 80, 80);
        bborrar.setFont(new Font("Arial", Font.BOLD, 30));
        bborrar.addActionListener(this);
        add(bborrar);

        // Creación de botones numéricos (0-9)
        int x = 20, y = 380;
        for (int i = 1; i <= 9; i++) {
            botones[i] = new JButton(i + "");
            botones[i].setBounds(x, y, 100, 100);
            botones[i].setFont(new Font("Arial", Font.BOLD, 30));
            botones[i].addActionListener(this);
            add(botones[i]);
            x += 110;
            if (i % 3 == 0) { // Salto de línea
                x = 20;
                y -= 110;
            }
        }

        // Botón "0"
        botones[0] = new JButton("0");
        botones[0].setBounds(20, 490, 210, 100); 
        botones[0].setFont(new Font("Arial", Font.BOLD, 30));
        botones[0].addActionListener(this);
        add(botones[0]);

        // Botón "punto" (.)
        bpunto = new JButton(".");
        bpunto.setBounds(240, 490, 100, 100);
        bpunto.setFont(new Font("Arial", Font.BOLD, 30));
        bpunto.addActionListener(this);
        add(bpunto);

        // Botón "igual" (=)
        bigual = new JButton("=");
        bigual.setBounds(350, 490, 100, 100);
        bigual.setFont(new Font("Arial", Font.BOLD, 30));
        bigual.addActionListener(this);
        add(bigual);

        // Botones de operaciones
        bsuma = new JButton("+");
        bsuma.setBounds(350, 380, 100, 100);
        bsuma.setFont(new Font("Arial", Font.BOLD, 30));
        bsuma.addActionListener(this);
        add(bsuma);

        bresta = new JButton("-");
        bresta.setBounds(350, 270, 100, 100);
        bresta.setFont(new Font("Arial", Font.BOLD, 30));
        bresta.addActionListener(this);
        add(bresta);

        bmultiplicacion = new JButton("×");
        bmultiplicacion.setBounds(350, 160, 100, 100);
        bmultiplicacion.setFont(new Font("Arial", Font.BOLD, 30));
        bmultiplicacion.addActionListener(this);
        add(bmultiplicacion);

        bdivision = new JButton("÷");
        bdivision.setBounds(240, 160, 100, 100);
        bdivision.setFont(new Font("Arial", Font.BOLD, 30));
        bdivision.addActionListener(this);
        add(bdivision);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botonpresionado = (JButton) e.getSource();

        if (botonpresionado == bborrar) {
            pantalla.setText("");
            num1 = num2 = resultado = 0;
            operador = ' ';
            return;
        }

        if (botonpresionado == bigual) {
            num2 = Double.parseDouble(pantalla.getText());
            switch (operador) {
                case '+': resultado = num1 + num2; break;
                case '-': resultado = num1 - num2; break;
                case '×': resultado = num1 * num2; break;
                case '÷': resultado = num2 != 0 ? num1 / num2 : 0; break;
            }
            pantalla.setText(String.valueOf(resultado));
            num1 = resultado;
            return;
        }

        if (botonpresionado == bsuma || botonpresionado == bresta || 
            botonpresionado == bmultiplicacion || botonpresionado == bdivision) {
            num1 = Double.parseDouble(pantalla.getText());
            operador = botonpresionado.getText().charAt(0);
            pantalla.setText("");
            return;
        }

        pantalla.setText(pantalla.getText() + botonpresionado.getText());
    }

    public static void main(String[] args) {
        new Calculadora();
    }
}
