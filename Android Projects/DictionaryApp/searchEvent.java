package Dictionary.bin.Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import Dictionary.bin.Connector.*;

public class searchEvent extends Event implements ActionListener{

    public searchEvent(DataConnector Data,JTextArea jtxout,JTextField jtxinput){
        super(Data, jtxout,jtxinput);
    }

    //@overwrite
    public void actionPerformed(ActionEvent ae){
        System.out.println(ae.getActionCommand() );
        //clear text
        jtxout.setText(null);
        //add funtion to components
        try{
            String out=Data.searchWord(jtxinput.getText());
            if(!(Data.hasWord(jtxinput.getText()))) 
                jtxout.append("Word does not exits !");
            else
                jtxout.append(out);
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}





