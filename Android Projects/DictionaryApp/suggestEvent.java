package Dictionary.bin.Event;

import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;

import Dictionary.bin.Connector.*;

public class suggestEvent extends Event implements DocumentListener{
    public suggestEvent(DataConnector Data,JTextArea jtxout,JTextArea jtxout2,JTextField jtxinput){
        super(Data, jtxout,jtxout2,jtxinput);
    }

    protected void Respond(){
        //clear text
        jtxout.setText(null);
        //check exits word that user type in
        if(jtxinput.getText().length()<1) return;
        //add function to components
        try{
            String[] wordsList=Data.getSuggestList(jtxinput.getText());
            for(String a:wordsList){
                if(a==null) break;
                jtxout.append(a+"\n");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        jtxout2.setText(null);
    }

    //@overwride
    public void insertUpdate(DocumentEvent e){
        Respond();
    }
    public void removeUpdate(DocumentEvent e){
        Respond();
    }
    public void changedUpdate(DocumentEvent e){
        Respond();
    }
}