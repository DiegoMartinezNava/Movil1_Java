
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
public class Cronometro2 extends JFrame implements ActionListener{
    JLabel etiquetaContador;
    JButton btnIniciar, btnReiniciar;
    int contador;
    boolean btnActivo=false;
    HiloContador hc;
    
    public Cronometro2(){
        JFrame ventana = new JFrame();
        ventana.setTitle("Cronometro");
        ventana.setSize(300,300);
        
        
        
        
        JPanel p = new JPanel(new GridLayout(3,1));
        
        etiquetaContador = new JLabel("0");
        btnIniciar = new JButton("Iniciar");
        btnIniciar.addActionListener(this);
        btnReiniciar = new JButton("Reiniciar");
        btnReiniciar.addActionListener(this);
        
        p.add(etiquetaContador);
        p.add(btnIniciar);
        p.add(btnReiniciar);
        ventana.setDefaultCloseOperation(3);
        ventana.setVisible(true);
        ventana.add(p);
    }
    
    public static void main(String[] args) {
        Cronometro2 c = new Cronometro2();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource().equals(btnIniciar)){
        btnActivo=true;
        hc = new HiloContador();
        hc.start();
      }
      if (e.getSource().equals(btnReiniciar)){
        btnActivo=false;
        contador=0;
        etiquetaContador.setText(contador+"");
    }
  }
    
  private class HiloContador extends Thread{
      public void run(){
         while(true){
             try{
             if(btnActivo){
                 contador++;
             etiquetaContador.setText(contador+"");
             Thread.sleep(1000);
             }
            }
             catch(Exception e){}             
            } 
        }
    }
}
