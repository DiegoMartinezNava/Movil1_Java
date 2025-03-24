import java.awt.BorderLayout;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author diegomartineznava
 */
public class Programa03 extends JFrame{
    private PanelBolita panelbolita;
    private JPanel panelInfo;
    private JPanel panelGanaste;
    private JLabel coordenadas;
    private JLabel ganaste;
    
    public Programa03(){
        setTitle("Bolita 01");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panelInfo = new JPanel();
        coordenadas = new JLabel ("x=100 y=100");
        panelInfo.add(coordenadas);
        
        panelGanaste = new JPanel();
        ganaste = new JLabel("No");
        panelGanaste.add(coordenadas);
        
        panelbolita = new PanelBolita(coordenadas, ganaste);
        
        add(panelInfo, BorderLayout.NORTH);
        add(panelbolita, BorderLayout.CENTER);
        add(panelGanaste, BorderLayout.SOUTH);
    }
    public static void main(String[] args){
        Programa03 p= new Programa03();
        p.setVisible(true);
    }   
}
