import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Datos extends JPanel{
    
    int intentos;
    JLabel label;
    
    public Datos(){
    
        intentos=0;
        label=new JLabel();
        BorderLayout bl= new BorderLayout(5, 5);
        setLayout(bl);
        add(label,BorderLayout.NORTH);
        intentos();
        setVisible(true);
        }
  
 
    public void setDatos(int n){
       intentos=n;
    } 
    public int getDatos(){
       return intentos;
    }
    public void intentos(){
      label.setText("numero de intentos"+"     "+getDatos());
    } 

}
