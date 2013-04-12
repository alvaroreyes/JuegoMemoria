
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @author Hamster
 */
public class EscuchadorBotones implements ActionListener 
{
    Tabla t; //creamos un objeto del tipo tabla
    EscuchadorBotones(Tabla precionado) //como parametro de entrada le mandamos la interfaz de tabla asi podremos accionar sus botones desde esta clase
    {
        t= precionado;  
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
