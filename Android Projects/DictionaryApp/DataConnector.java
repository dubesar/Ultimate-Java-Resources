package Dictionary.bin.Connector;

import java.sql.*;
import java.util.ArrayList;

public class DataConnector {
    private String Url = "jdbc:mysql://localhost/OOP?autoReconnect=true&useSSL=false&useUnicode=true";
    private Connection connect;
    //private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public DataConnector() throws Exception {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(Url,"foo","MysqlFooUser1.");
            if(connect!=null){
                System.out.println("Connected with mySQL...");
            }
            else {
                System.out.println("Fail to connect with mySQL!");
            }
    }

    public String searchWord(String word) throws SQLException {
        preparedStatement = connect.prepareStatement("select def from Dict where word = '"+word+"'");
        resultSet = preparedStatement.executeQuery();
        if (!resultSet.isBeforeFirst()){
            System.out.println("Word dont exit");
        }
        else{
            resultSet.next();
            return resultSet.getString("def");
        }
        return null;
    }

    public String[] getSuggestList(String wordTyped) throws SQLException {
        String[] SuggestList = new String[5];
        int i = 0;
        preparedStatement = connect.prepareStatement("select word from Dict where word regexp '^"+wordTyped+"'");
        resultSet = preparedStatement.executeQuery();
        if(resultSet.isBeforeFirst()) {
            while (resultSet.next()) {
                String word = resultSet.getString("word");
                SuggestList[i++] = word;
            }
        }
        return SuggestList;
    }

    public boolean hasWord(String word) throws SQLException {
        preparedStatement = connect.prepareStatement("select word from Dict where word = '"+word+"'");
        resultSet = preparedStatement.executeQuery();
        if (!resultSet.isBeforeFirst()){
            return false;
        }
        else {
            return true;
        }
    }

    public void insertWord(String word, String def) throws SQLException {
        if (this.hasWord(word) == false) {
            preparedStatement = connect.prepareStatement("insert into Dict (word, def) values ('" + word + "','" + def + "')");
            preparedStatement.executeUpdate();
            System.out.println("Inserted successfully...");
        }
        else{
            System.out.println("This word has existed inside dictionary, please delete it before adding new definition!");
        }
    }

    public void deleteWord(String word) throws SQLException {
        if(this.hasWord(word)){
            preparedStatement = connect.prepareStatement("delete from Dict where word ='"+word+"'");
            preparedStatement.executeUpdate();
            System.out.println("Deleted successfully...");
        } else {
            System.out.println("WARNING: Word does not exist!");
        }

    }

    public static void main(String[] args) throws Exception {
        try {
            DataConnector con = new DataConnector();
            String[] suggestList = con.getSuggestList("p");
            for (int i = 0; i < 5; i++){
                System.out.println(suggestList[i]);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}


