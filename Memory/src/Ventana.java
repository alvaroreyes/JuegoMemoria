
import java.awt.GridLayout;
import javax.swing.JFrame;
/*
 * @author Hamster
 */
public class Ventana extends JFrame
{
    tabla _t1,_t2;
    public Ventana()
    {
        super("Memori");
        //setLayout(null);
        //setBounds(0, 0, 1350, 700);
        setSize(1350, 700);
        GridLayout miembros = new GridLayout(1,2, 100,100);
        setLayout(miembros);
        _t1 = new tabla(3);
        _t2 = new tabla(6);
        
        addItems();
        //posicionar();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void addItems()
    {
        add(_t1);
        add(_t2);
    }
    private void posicionar()
    {
        _t1.setBounds(50, 50, 550, 550);
        _t2.setBounds(700, 50, 550, 550);
    }
    public static void main(String []Hams)
    {
        new Ventana();
    }
    
}
