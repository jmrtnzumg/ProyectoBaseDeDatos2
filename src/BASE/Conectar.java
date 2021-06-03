package Base;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conectar {
 
      String servidor="LOCALHOST";
    String puerto="1433";
    String base="BDBODEGAPEREZ";
    String usuario="sa";
    String clave="12345678";
    
    
    Connection conectar = null;
    public Connection conexion(){
        try{
          Class.forName("com.mysql.jdbc.Driver");
          conectar = DriverManager.getConnection("jdbc:sqlserver://"+servidor+":"+puerto+";"+"database="+base+";user="+usuario+";password="+clave+";");
        }catch(ClassNotFoundException | SQLException e){
            System.out.print(e.getMessage());
        }
        return conectar;
    }  
 
}
