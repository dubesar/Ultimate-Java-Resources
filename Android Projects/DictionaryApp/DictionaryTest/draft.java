package Dict;

import javax.swing.*;
import java.sql.*;

public class MySQLAccess {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;



    public void findFromDataBase(String wordtyped, JTextArea JTextArea, boolean isEnter) throws Exception{
        try{
            // This will load the mySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Set up the connection with the DB
            connect = DriverManager.getConnection("jdbc:mysql://localhost/OOP?"+"user=root&password=zxcvbnm,./");
            // Statement allow to issue SQL queries to the DB
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            //resultSet = statement.executeQuery("select * from OOP.Dict");
            //writeResultSet(resultSet);
            // Prepared statements can use variables and are more efficient
            //preparedStatement = connect.prepareStatement("insert into feedback.comments value (default, ?,?,?,?,?,?)");
            // "myuser, webpage, datum, summary, COMMENTS from feedback.comments")
            // Parameters start with 1
            //preparedStatement.setString(1, "Test");
            //preparedStatement.setString(2, "TestEmail");
            //preparedStatement.setString(3, "TestWebpage");
            //preparedStatement.setDate(4, new Date(2009, 12, 11));
            //preparedStatement.setString(5, "TestSummary");
            //preparedStatement.setString(6, "TestComments");
            //preparedStatement.executeUpdate();
            //preparedStatement = connect.prepareStatement("SELECT myuser, webpage, datum, summary, COMMENTS from feedback.comments");
            //resultSet = preparedStatement.executeQuery();
            //writeResultSet(resultSet);

            // Remove again the insert comments
            //preparedStatement = connect.prepareStatement("delete from feedback.comments where myuser=?;");
            //preparedStatement.setString(1, "Test");
            //preparedStatement.executeUpdate();

            //resultSet = statement.executeQuery("select * from OOP.Dict");
            //writeMetaData(resultSet);






            //if (!isEnter) {
            resultSet = statement.executeQuery("select word from Dict where word regexp '^" + wordtyped + "'");
                //writeResultSet(resultSet, JSuggest);
            while (resultSet.next()) {
                JTextArea.append(resultSet.getString("word") + "\n");
            }
            //}
            //else{
                //resultSet = statement.executeQuery("select def from Dict where word = '"+wordtyped+"'");
                //if(!resultSet.isBeforeFirst()){
                    //JTextArea.append("No word match");
                //} else
                //JTextArea.append(resultSet.getString("def"));
            //}
        } catch (Exception e){
            throw e;
        } finally {
            close();
        }
    }
    private void writeMetaData(ResultSet resultSet) throws SQLException{
        // Now get some metadata from the database
        // Result  set get the resultof the SQL query
        System.out.println("The column in the table are: ");
        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for(int i = 1; i<=resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " + i + " " + resultSet.getMetaData().getColumnName(i));
        }
    }
    private void writeResultSet(ResultSet resultSet, JTextArea JSuggest) throws SQLException {
         //Result set is initially before the first dataset
        while (resultSet.next()){
            System.out.println(resultSet.getString("word"));
            JSuggest.append(resultSet.getString("word") + "\n");
            //It is possible to get the column via name
            //also possible to get the column via column number
            //which start at 1
            // e.g resultSet.getString(2);
            //String user = resultSet.getString("myuser");
            //String website = resultSet.getString("webpage");
            //String summary = resultSet.getString("summary");
            //Date date = resultSet.getDate("datum");
            //String comment = resultSet.getString("comments");
            //System.out.println("User: " + user);
            //System.out.println("Website: " + website);
            //System.out.println("Summary: " + summary);
            //System.out.println("Date: " + date);
            //System.out.println("Comment: " + comment);
            //System.out.println("word: " + resultSet.getString("word"));
        }
    }

    // You need to close the resultSet
    private void close(){
        try{
            if (resultSet != null){
                resultSet.close();;
            }
            if (statement != null){
                statement.close();
            }
            if (connect != null){
                connect.close();
            }
        } catch (Exception e){

        }
    }
}
