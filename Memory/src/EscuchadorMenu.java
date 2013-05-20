
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


/**
 * @author Hamster
 */
public class EscuchadorMenu implements ActionListener 
{
    Ventana v; //creamos un objeto del tipo tabla
    EscuchadorMenu(Ventana v) //como parametro de entrada le mandamos la interfaz de tabla asi podremos accionar sus botones desde esta clase
    {
        this.v= v;  
    }
    public void actionPerformed(ActionEvent evento)  
    {
        Object objeto = evento.getSource();
        if(objeto == v.j)                                       
        {
            v.cambiarNivel(1);
        }
        if(objeto == v.j1) 
        {
            v.cambiarNivel(2);
        }
        if(objeto == v.j2) 
        {
            v.cambiarNivel(3);
        }
        if(objeto == v.j3)
        {
            v.cambiarNivel(4);
        }
        if(objeto == v.j4) 
        {
            v.cambiarNivel(5);
        }
        if(objeto == v.j5)
        {
            v.cambiarNivel(6);
        }
    }
}
