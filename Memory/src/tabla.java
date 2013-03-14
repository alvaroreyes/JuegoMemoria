
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * @author Hamster
 */
public class tabla extends JPanel implements ActionListener
{
    int _n;
    JButton[][] _botones; 
    ImageIcon[][] _imagen;
    public tabla(int n)
    {
        this._n=n;
        _botones = new JButton[n][n];
        _imagen = new ImageIcon[n][n];
        //setSize(600, 600);
        
        GridLayout miembros = new GridLayout(n, n, 5, 5);
        setLayout(miembros);
        
        imagenes();
        botones();
        
        
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        
        
    }
    private void imagenes()
    {
        int cont = 0;
        for(int i=0;i<_n;i++)
        {
            for(int j=0;j<_n;j++)
                {                    
                    _imagen [i][j]=new ImageIcon("imagenes/"+cont+".gif");
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
                    _botones[i][j].addActionListener(this);    //Metodo para teclear Action Listener
                }
        }
        
    }
    public void actionPerformed(ActionEvent evento)     //Metodo oyente del panel
    {
        Object e = evento.getSource();    
        for(int i=0;i<_n;i++)
        {
            for(int j=0;j<_n;j++)
            {                
                if(e==_botones[i][j])
                {   
                    //JOptionPane.showMessageDialog(null,"fila: "+(i+1)   + "  columna:"+(j+1) , "posicion", 1, null);                   
                       _botones[i][j].setIcon(_imagen[i][j]);
                       _botones[i][j].repaint();
                }
            }
            
        }
    }

}
