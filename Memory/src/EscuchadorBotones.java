
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class EscuchadorBotones implements ActionListener 
{
    Tabla t; //creamos un objeto del tipo tabla
    int x = 0;
    int y = 0;
    int x1 = 0;
    int y1 = 0;
    int fin = 0;
    int cont = 0;
    Datos datos;
    int jugadas=0;
    int aciertos=0;
    int fallas=0;
    EscuchadorBotones(Tabla precionado) //como parametro de entrada le mandamos la interfaz de tabla asi podremos accionar sus botones desde esta clase
    {
        t= precionado;  
        datos=new Datos();
    }
    public void actionPerformed(ActionEvent evento)     //Metodo oyente del panel
    {
        Object e = evento.getSource();    
        for(int i=0;i<t._n;i++) //este for avansa en las filas de la matriz
        {
            for(int j=0;j<t._n;j++) //este for avansa en las columnas de la matriz
            {                
                if(e==t._botones[i][j])
                {   
                       t._botones[i][j].setIcon(t._imagen[i][j]); // si el boton que esta en la posicion[i][j] de la matriz es apretado se le coloca una imagen que se encuentra en la misma posicion de una matriz de imagenes
                       t._botones[i][j].repaint();               // repintamos el boton para que se actualice
                       
                       if(cont == 2)
                       {
                           if(compararImagen(t._imagen[x][y],t._imagen[x1][y1]))
                                {
                                    t._botones[i][j].setEnabled(false);
                                    fin =fin +2;
                                    jugadas++;
                                    aciertos++;
                                    datos.setDatos(jugadas);
                                    datos.setAciertos(aciertos);
                                    datos.intentos();
                                    
                                 
                                }
                                else
                                {
                                    t._botones[x][y].setEnabled(true);
                                    t._botones[x1][y1].setEnabled(true);
                                    t._botones[x1][y1].setIcon(null);
                                    t._botones[x][y].setIcon(null);
                                    jugadas++;
                                    fallas++;
                                    datos.setDatos(jugadas);
                                    datos.setFallas(fallas);
                                    datos.intentos();
                                    
                                    
                                }
                           cont = 0;
                       }
                       if(cont == 1)
                       {
                           x1 = i; 
                           y1 = j;
                           t._botones[i][j].setEnabled(false);
                           cont = 2;
                           if(fin+2 == t._n*t._n)
                                    {
                                        int nivel = t._n/2+1;
                                        JOptionPane.showMessageDialog(null, "Felicidades ganaste\n Subiste al nivel "+nivel);
                                        //datos.setDatos(0);
                                        //datos.intentos();
                                        //datos=new Datos();
                                        t.subirNivel(nivel);
                                    }
                       }
                       if(cont == 0)
                       {
                           x = i; 
                           y = j;
                           t._botones[i][j].setEnabled(false);
                           
                           cont = 1;
                       }
                }
                    
            }
            
        }
    }
    public Datos getDatos(){
    return datos;
    }
    public void verificarJuego(){
    if (jugadas >=2){
        for(int i=0; i<=t._n; i++){
              for(int j=0; j<=t._n; j++){
                  
                  JOptionPane.showMessageDialog(null, "perdiste");
                  break;
              
              }
        }
    }
    }
    public boolean compararImagen(ImageIcon imagen1,ImageIcon imagen2) // este metodo compara las imagenes, aun no lo estamos usando pero se usara para terminar el juego
    {
        boolean res;
        String a,b;
        res=false;
      a=imagen1.toString(); // con esto se saca la direccion de la imagen
      b=imagen2.toString();
       
        if(a.equals(b)){ // aqui en realidad esta comparando si tienen la misma direccion y mismo nombre 
        res=true;
        }
        else
        res=false;
        return res;
    }
    
}
