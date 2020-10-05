package Dictionary.bin.Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import Dictionary.bin.Connector.*;

public class addEvent extends Event implements ActionListener{

    //constructor
    public addEvent(DataConnector Data,JTextArea jtxout,JTextField jtxinput){
        super(Data,jtxout,jtxinput);
    }

    //@overwrite
    public void actionPerformed(ActionEvent ae){
        //check allowed case can add
        if(jtxinput.getText().length()<1||jtxout.getText().length()<1){
            return;
        }
        try{
            Data.insertWord(jtxinput.getText(),jtxout.getText());
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}