package Dictionary.Test.bin.Connecter;

import java.sql.*;
//import com.mysql.jdbc.*;

class connectJDBC{
    private static Connection con=null;
    private static Statement state=null;
    private static ResultSet rs=null;
    public static void main(String[] args) throws SQLException,Exception{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database ...");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels?autoReconnect=true&useSSL=false","foo","MysqlFooUser1.");
            System.out.println("Creating statement...");
            state=con.createStatement();
            ResultSet rs=state.executeQuery("select * from employees;");
            ResultSetMetaData rsmd=rs.getMetaData();
            int fini=rsmd.getColumnCount();
            System.out.println(fini);
            for(int i=1;i<fini+1;i++){
                System.out.println(rsmd.getColumnName(i)+"\t");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(rs!=null) {
                rs.close();
                System.out.println("CLose resultSet");
            }
            if(state!=null) {
                state.close();
                System.out.println("CLose statement");
            }
            if(con!=null) {
                con.close();
                System.out.println("Close connection");
            }
            System.out.println("Goodbye!");
        }
    }
}