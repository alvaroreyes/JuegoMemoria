
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 * @author Hamster
 */
class Tabla extends JPanel
{
    int _n;
    JButton[][] _botones; 
    ImageIcon[][] _imagen;
    ArrayList<ImageIcon> arrayImagenes = new ArrayList<ImageIcon>();
    EscuchadorBotones presionada = new EscuchadorBotones(this);
    public Tabla(int n)
    {
        this._n=n;
        _botones = new JButton[n][n];
        _imagen = new ImageIcon[n][n];
        //setSize(600, 600);
        
        GridLayout miembros = new GridLayout(n, n, 5, 5);
        setLayout(miembros);
        llenarArray();
        llenarArray();
        imagenes();
        botones();
        
        setVisible(true);
    }
    private void llenarArray()
    {
        for(int i = 0; i<(_n*_n)/2;i++)
        {
            arrayImagenes.add(new ImageIcon("imagenes/"+i+".gif"));
        }
    }
    private void imagenes()
    {
        int cont = 0;
        for(int i=0;i<_n;i++)
        {
            for(int j=0;j<_n;j++)
                {                    
                    _imagen [i][j]=arrayImagenes.get(cont);
                    cont++;                    
                }
        }
        
    }
    private void botones()
    {
        for(int i=0;i<_n;i++)
        {
            for(int j=0;j<_n;j++)
                {                    
                    _botones [i][j]=new JButton();      //Crear boton                    
                    add(_botones[i][j]);                  //Colocar en el panel los botones para agregar el boton a la ventana                 
                    _botones[i][j].addActionListener(presionada);    //Metodo para teclear Action Listener
                }
        }
        
    }
    

}
