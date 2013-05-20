
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

/**
 * @author Hamster
 */
class Tabla extends JPanel
{
    int _n; // este n sera el tamaño de la matriz si n es 6 entonces sera una matriz de  6X6
    JButton[][] _botones;  // matriz de botones
    ImageIcon[][] _imagen;// matris de imagenes
    ArrayList<ImageIcon> arrayImagenes = new ArrayList<ImageIcon>(); //array de imagenes
    EscuchadorBotones presionada = new EscuchadorBotones(this);// creo un objeto Escuchador botones y le mando la misma tabla para que tenga el control de los botones de la tabla
    Random ram; // ocuparemos esto para generar numeros randomicos
    int nivel = 1;
    Ventana v;
    public Tabla(int n , Ventana v)
    {
        n = getNivel(n);
        this.v = v;
        _botones = new JButton[n][n]; //ponemos el tamaño a la matriz de botones
        _imagen = new ImageIcon[n][n]; //ponemos el tamaño a la matriz de botones
        ram = new Random(); // creamos el numero randomico
        GridLayout miembros = new GridLayout(n, n, 5, 5); // le ponemos un layout para que los botones se acomoden en el panel en morma de matriz (cantidad de filas,cantidad de columnas,espacio entre botones en X,espacio entre botones en Y)
        setLayout(miembros);// le agregamos el layout de arriba
        llenarArray(); // este metodo llena el array con imagenes, llenamos la mitad del array
        llenarArray(); // llamamos otra ves al metodo para llenar la 2da mitad con las mismas imganes que ya se pusieron antes
        RandomisarImagen(); // este metodo agarra el array que contiene las imagenes y desordena de posicion las imagenes
        imagenes();
        botones();
        
        setVisible(true); 
    }
    
    public int getNivel(int n)
    {
        _n = n*2;
        return _n;
    }
    public EscuchadorBotones getEscuchador(){
    return presionada;
    }
    public void subirNivel(int num)
    {
        v.cambiarNivel(num);
    }
    private void llenarArray()
    {
        for(int i = 0; i<(_n*_n)/2;i++)
        {
            arrayImagenes.add(new ImageIcon("imagenes/"+i+".gif")); //aderimos la imagen al array que se encuentra en "imagenes/"+i+".gif"  i es un numero que ira cambiando
        }
    }
    private void imagenes() // con este metodo llenamos la matriz de imagenes con el contenido de el array de imagenes
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
    private void botones() //aqui creamos los botones y le ponemos su escuchador
    {
        for(int i=0;i<_n;i++)
        {
            for(int j=0;j<_n;j++)
                {                    
                    _botones [i][j]=new JButton();      //Crear boton                    
                    add(_botones[i][j]);                  //Colocar en el panel los botones para agregar el boton a la ventana                 
                    _botones[i][j].repaint();
                    _botones[i][j].addActionListener(presionada);    //Metodo para teclear Action Listener
                    
                }
        }
        
    }
    
    public void RandomisarImagen()
    {
        int ramd;
        ArrayList<ImageIcon> arrayImagenes1 = new ArrayList<ImageIcon>(); // creamos un nuevo array array2
        while(arrayImagenes.size()!=0) // mientras el antiguo array no este basio 
         {
            ramd = ram.nextInt(arrayImagenes.size()); // rand es un numero random que como maximo valor toma el tamaño del array de imagenes
            arrayImagenes1.add(arrayImagenes.get(ramd)); //aderimos el contenido de la poscicion  ramd de el primer array al segundo array
            arrayImagenes.remove(ramd); // borramos del array 1 la  posicion ramd para que asi pueda salir del while
         }  // una vez terminado el while debemos tener un nuevo array con todos los datos del 1er array pero en desorden y el 1er array esta basio
        arrayImagenes = arrayImagenes1; // le ponemos al 1er array todo el contenido del array 2 por que el 1er array es una variable de clase y la usaran todos
    }
    

}
