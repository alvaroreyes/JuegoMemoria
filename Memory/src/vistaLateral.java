
import java.awt.GridLayout;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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

    class contador extends TimerTask{
        public void run(){
            seg++;
            hora.setText(seg/60+":"+seg%60);
        }
    }

}
