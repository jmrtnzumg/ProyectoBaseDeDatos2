
package BASE;
import java.sql.*;
public class conectaBD {
 public Connection cnn;  //OBJETO CONECCION PARA LA BD
 public Statement stm; // CLASE PARA CONECTAR LOS OBJETOS BD
 public ResultSet rs; // CLASE QUE MANIPULA LOS DATOS
 
   String servidor="LOCALHOST";
  String usuario="sa";
  String clave="12345678";
  String puerto="1433";
  String base="BDBODEGAPEREZ";

    
 public void conectar(){

try{
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
String cadena="jdbc:sqlserver://"+servidor+":"+puerto+";"+"database="+base+";user="+usuario+";password="+clave+";";
cnn=DriverManager.getConnection(cadena);
stm=cnn.createStatement();
           
  }
   catch(Exception e)  {   
    System.out.println(e.getMessage());
    
 }
}
 
}
