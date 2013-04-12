
import java.awt.GridLayout;
import javax.swing.JFrame;
/*
 * @author Hamster
 */
public class Ventana extends JFrame
{
    Tabla _t1; // instanciamos un objeto del tipo tabla
    public Ventana()
    {
        super("Memori"); // aqui se pone el titulo que tendra la ventana en la parte superior izquierda
        //setLayout(null); //esto es para quitar el layout que controla el posicionamiento
        setSize(700, 700); //con esto le damos el tamaño a la ventana
        GridLayout miembros = new GridLayout(1,2, 100,100); //este Layout es para posicionar las cosas dentro de la ventana por el momento solo la tabla
        setLayout(miembros);//colocamos el layout
        _t1 = new Tabla(6); // creamos el objeto de tipo tabla le mandamos el 6 y cera una matris de 6X6
        
        addItems(); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // esto es pa que el programa deje de correr internamente cuando se cierre la ventana
        setVisible(true); // sin esto la ventana no seria visible
    }
    private void addItems()
    {
        add(_t1); // aderimos la tabla a la ventana
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
