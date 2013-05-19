
import java.sql.*;
import java.util.*;

public class Consultas {
    
            Connection              db;        // A connection to the database
	    Statement               sql;       // Our statement to run queries with
	    DatabaseMetaData        dbmd;
            Cnx con;
public void insertar(){
   		 
try{      
        db= new Cnx().getConexion(); 
    	dbmd = db.getMetaData(); //get MetaData to confirm connection	
    	sql = db.createStatement(); //create a statement that we can use later
        sql.executeQuery("INSERT INTO datos(nombre, puntaje, tiempo, fecha)\n" +"VALUES ('luciana',1, '8:11', '9/11/12')");
	db.close();
        sql.close();
}catch(Exception ex) {
    System.out.println(ex.toString());
}
}
  
 public String MostrarPuntuacion(){
   String dato="";		 
try{      
        db= new Cnx().getConexion();
    	dbmd = db.getMetaData(); //get MetaData to confirm connection	
    	sql = db.createStatement(); //create a statement that we can use later
        ResultSet rs = sql.executeQuery("SELECT puntaje(max) " +"  FROM datos");
        while(rs.next()){
        dato=rs.getString("puntaje");
        System.out.println(dato);
        }
	db.close();
        sql.close();
}catch(Exception ex) {
    System.out.println(ex.toString());
}
return dato;
}

 public static void main(String[] args){
    Consultas t=new Consultas();
    t.insertar();
    t.MostrarPuntuacion(); 
 
 }
}
