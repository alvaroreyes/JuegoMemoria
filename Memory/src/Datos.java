import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Datos extends JPanel{
    
    int jugadas,aciertos,fallas;
    JLabel labelJudadas;
    JLabel labelAciertos;
    JLabel labelFallas;
    
    
    public Datos(){
    
        jugadas=0;
        aciertos=0;
        fallas=0;
        labelJudadas=new JLabel();
        labelAciertos=new JLabel();
        labelFallas=new JLabel();
       
        BorderLayout bl= new BorderLayout(5, 5);
        setLayout(bl);
        add(labelJudadas,BorderLayout.NORTH);
        add(labelAciertos,BorderLayout.WEST);
        add(labelFallas,BorderLayout.EAST);
        intentos();
        setVisible(true);
        }
  
 
    public void setDatos(int n){
       jugadas=n;
    } 
    public int getDatos(){
       return jugadas;
    }
      public void setAciertos(int n){
       aciertos=n;
    }
       public int getAciertos(){
       return aciertos;
    }
      public void setFallas(int n){
      fallas=n;
      }
       public int getFallas(){
       return fallas;
    }
    public void intentos(){
      labelJudadas.setText("numero de jugadas"+"     "+getDatos());
      labelFallas.setText("numero de fallas"+"     "+getFallas());
      labelAciertos.setText("numero de aciertos"+"     "+getAciertos());
    } 
 

}
