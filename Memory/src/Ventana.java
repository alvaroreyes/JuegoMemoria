
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
/*
 * @author Hamster
 */
public class Ventana extends JFrame
{
    Tabla _t1; // instanciamos un objeto del tipo tabla
    EscuchadorBotones e;
    Datos d;
    public Ventana()
    {
        super("Memori"); // aqui se pone el titulo que tendra la ventana en la parte superior izquierda
        //setLayout(null); //esto es para quitar el layout que controla el posicionamiento
        setSize(700, 700); //con esto le damos el tamaño a la ventana
        BorderLayout bl = new BorderLayout( 5,5); //este Layout es para posicionar las cosas dentro de la ventana por el momento solo la tabla
        setLayout(bl);//colocamos el layout
        _t1 = new Tabla(4); // creamos el objeto de tipo tabla le mandamos el 6 y cera una matris de 6X6
        
        e=_t1.getEscuchador();
        d=e.getDatos();
        addItems(); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // esto es pa que el programa deje de correr internamente cuando se cierre la ventana
        setVisible(true); // sin esto la ventana no seria visible
    }
    private void addItems()
    {
        add(_t1,BorderLayout.CENTER); // aderimos la tabla a la ventana
        add(d,BorderLayout.NORTH);
    }
    private void posicionar() // no estamos ocupando este metodo
    {
        _t1.setBounds(50, 50, 550, 550);
    }
    public static void main(String []Hams)
    {
        new Ventana();
    }
    
}
