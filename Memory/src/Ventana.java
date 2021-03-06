
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import javax.swing.*;
/*
 * @author Hamster
 */
public class Ventana extends JFrame
{
    Tabla _t1; // instanciamos un objeto del tipo tabla
    EscuchadorBotones e;
    EscuchadorMenu esM = new EscuchadorMenu(this);
    Datos d;
    JLabel tiempo= new JLabel("   Tiempo transcurrido: "); 
    JMenuItem j = new JMenuItem("Nivel 1");               //Botones del menu
    JMenuItem j1 = new JMenuItem("Nivel 2");
    JMenuItem j2 = new JMenuItem("Nivel 3");
    JMenuItem j3 = new JMenuItem("Nivel 4");
    JMenuItem j4 = new JMenuItem("Nivel 5");
    JMenuItem j5 = new JMenuItem("Nivel 6");
    
    JMenuItem mR = new JMenuItem("Reiniciar Partida");
    JMenuItem mA = new JMenuItem("Ayuda");
    JMenuItem mS = new JMenuItem("Salir");
    JMenu niveles = new JMenu("Nivel");
    JMenu menu = new JMenu("Menu");//este es el boton menu que contiene los botnes de arriba XD
    JMenuBar menuBar = new JMenuBar();                      //esta es una barra que contiene al boton menu
    vistaLateral vistal;
    int n= 0 ;
    public Ventana()
    {
        super("Memori"); // aqui se pone el titulo que tendra la ventana en la parte superior izquierda
        //setLayout(null); //esto es para quitar el layout que controla el posicionamiento
        setSize(700, 700); //con esto le damos el tamaño a la ventana
        BorderLayout bl = new BorderLayout( 5,5); //este Layout es para posicionar las cosas dentro de la ventana por el momento solo la tabla
        setLayout(bl);//colocamos el layout
        _t1 = new Tabla(1 , this); // creamos el objeto de tipo tabla le mandamos el 6 y cera una matris de 6X6
        
        e=_t1.getEscuchador();
        d=e.getDatos();
        vistal=new vistaLateral();
        oyentesMenu();   
        addMenu();
        addItems(); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // esto es pa que el programa deje de correr internamente cuando se cierre la ventana
        setVisible(true); // sin esto la ventana no seria visible
    }
    public void cambiarNivel(int n)
    {
        menuBar.remove(vistal);
        menuBar.remove(niveles);
        menuBar.remove(menu);
        vistal = new vistaLateral();
        menuBar.add(menu);
        menuBar.add(niveles);
        menuBar.add(vistal);
        menuBar.repaint();
        _t1.removeAll();
        _t1 = new Tabla(n , this);
        e=_t1.getEscuchador();
        d=e.getDatos();
        addItems();
        this.repaint();
        _t1.repaint();
        this.setExtendedState(JFrame.ICONIFIED);
        this.setExtendedState(JFrame.NORMAL);
    }
    private void addItems()
    {
        
        add(_t1,BorderLayout.CENTER); // aderimos la tabla a la ventana
        add(d,BorderLayout.SOUTH);
        menuBar.add(tiempo);
        menuBar.add(vistal);
    }
    private void addMenu()
    {
        menuBar.add(menu);
        menuBar.add(niveles);
        
        
        add(menuBar,BorderLayout.NORTH);
        niveles.add(j);
        j.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,KeyEvent.CTRL_MASK));     //Acceso directo al boton
        niveles.addSeparator();                                                            //Serarador entre botones
        niveles.add(j1);                                                                   
        j1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,KeyEvent.CTRL_MASK));
        niveles.addSeparator();
        niveles.add(j2);
        j2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3,KeyEvent.CTRL_MASK));
        niveles.addSeparator();
        niveles.add(j3);
        j3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4,KeyEvent.CTRL_MASK));
        niveles.addSeparator();
        niveles.add(j4);
        j4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5,KeyEvent.CTRL_MASK));
        niveles.addSeparator();
        niveles.add(j5);
        j5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_6,KeyEvent.CTRL_MASK));
        niveles.addSeparator();
        
        menu.add(mR);
        mR.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,KeyEvent.CTRL_MASK));
        menu.addSeparator();
        menu.add(mA);
        mA.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_MASK));
        menu.addSeparator();
        menu.add(mS);
        mS.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_MASK));
        niveles.addSeparator();
        
        
    }
     public void salir(){
     System.exit(0);
     }
    void oyentesMenu()                                                                  //Activa los escuchadores del menu
    {
        j.addActionListener(esM);
        j1.addActionListener(esM);
        j2.addActionListener(esM);
        j3.addActionListener(esM);
        j4.addActionListener(esM);
        j5.addActionListener(esM);
        
        mA.addActionListener(esM);
        mR.addActionListener(esM);
        mS.addActionListener(esM);
    }
    public static void main(String []Hams)
    {
        new Ventana();
    }
    
}
