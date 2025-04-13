
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author diegomartineznava
 */
public class Cronometro extends JFrame implements ActionListener{
    JLabel etiquetaContador;
    JButton btnIniciar, btnReiniciar;
    int contador;
    boolean btnActivo=false;
    
    public Cronometro(){
        JFrame ventana = new JFrame();
        ventana.setTitle("Cronometro");
        ventana.setSize(300,300);
        
        
        JPanel p = new JPanel(new GridLayout(3,1));
        
        etiquetaContador = new JLabel("0");
        btnIniciar = new JButton("Iniciar");
        btnIniciar.addActionListener(this);
        btnReiniciar = new JButton("Reiniciar");
        
        p.add(etiquetaContador);
        p.add(btnIniciar);
        p.add(btnReiniciar);
        ventana.setDefaultCloseOperation(3);
        ventana.setVisible(true);
        ventana.add(p);
    }
    
    public static void main(String[] args) {
        //Cronometro c = new Cronometro();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource().equals(btnIniciar)){
        btnActivo=true;
        //while(btnActivo){
        contador=contador+1;
        etiquetaContador.setText(contador+"");
        //}
      }
      if (e.getSource().equals(btnReiniciar)){
        contador=0;
        btnActivo=false;
    }
  }
}
