
import java.util.*;
import java.io.*;
public class Fichero {
 
private     File archivo;
   
 public  void DarPuntaje(String nombre, String [] atr, String [] puntaje ){
       //escribo el archivo xml
         archivo = new File("D:\\Datos.txt");
        try
        {
            FileWriter escritor = new FileWriter(archivo);
            BufferedWriter ayudaEscritor= new BufferedWriter(escritor);
            ayudaEscritor.write("<"+nombre+">");
            ayudaEscritor.newLine();
            for(int i=0;i<atr.length;i++)
            {
                ayudaEscritor.write("<"+atr[i]+">");
                ayudaEscritor.newLine();
                ayudaEscritor.write(puntaje[i]);
                ayudaEscritor.newLine();
                ayudaEscritor.write("</"+atr[i]+">");
                ayudaEscritor.newLine();
            }
            ayudaEscritor.write("</"+nombre+">");
            ayudaEscritor.close();
            
        }
        catch(Exception e){}

 }
 public static void main(String args []){
     Fichero f=new Fichero();
     String [] vectorI={"intentos","tiempo"};
     String [] puntaje={"3","12"};
     f.DarPuntaje("juan",vectorI,puntaje);
 }
    
}

