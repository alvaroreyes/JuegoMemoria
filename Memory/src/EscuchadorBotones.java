
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hamster
 */
public class EscuchadorBotones implements ActionListener 
{
    Tabla t;
    EscuchadorBotones(Tabla precionado)
    {
        t= precionado;
    }
    public void actionPerformed(ActionEvent evento)     //Metodo oyente del panel
    {
        Object e = evento.getSource();    
        for(int i=0;i<t._n;i++)
        {
            for(int j=0;j<t._n;j++)
            {                
                if(e==t._botones[i][j])
                {   
                    //JOptionPane.showMessageDialog(null,"fila: "+(i+1)   + "  columna:"+(j+1) , "posicion", 1, null);                   
                       t._botones[i][j].setIcon(t._imagen[i][j]);
                       t._botones[i][j].repaint();
                }
            }
            
        }
    }
}
