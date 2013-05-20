
import java.awt.GridLayout;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author oz
 */
class vistaLateral extends JPanel {
    JLabel hora = new JLabel("");
    int seg = 0;
    public vistaLateral() {
        
        GridLayout vista = new GridLayout(1,1,1,1);
        setLayout(vista);
        add(hora);
        Timer timer = new Timer();
        contador cont = new contador();
        timer.schedule(cont,0,1000);
        
    }
    public int getSeg(){
       
    return seg%60;
    }
    public int getMin(){
       
    return seg/60;
    }

    class contador extends TimerTask{
        public void run(){
            seg++;
            hora.setText(seg/60+":"+seg%60);
        }
     
    }
    public static void main(String args []){
          
        vistaLateral v=new vistaLateral();
        
        } 
     

}
 
