package Dictionary.bin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import Dictionary.bin.Connector.*;
import Dictionary.bin.GUI.*;
import Dictionary.bin.Event.*;


public class DictionaryMain{
    protected DataConnector Data=null;
    protected Dic GUI=null;

    protected JTextArea jtxout=null;
    protected JTextField jtxinput=null;

    private JButton search=null,add=null,delete=null,edit=null;
    private JTextArea suggest=null;

    //constructor
    public DictionaryMain() throws SQLException,Exception{
        GUI=new Dic();
        Data =new DataConnector();

        jtxout=GUI.getJtxout();
        jtxinput=GUI.getJtxinput();

        search=GUI.getsearch();
        add=GUI.getAddword();
        delete=GUI.getDeleteword();
        edit=GUI.getEditword();

        search.addActionListener(new searchEvent(Data,jtxout,jtxinput));
        add.addActionListener(new addEvent(Data,jtxout,jtxinput));
        delete.addActionListener(new deleteEvent(Data,jtxout,jtxinput));
        edit.addActionListener(new editEvent(Data,jtxout,jtxinput));

        suggest=GUI.getJtxsuggest();

        jtxinput.getDocument().addDocumentListener(new suggestEvent(Data,suggest,jtxout,jtxinput));

    }

    public static void main(String[] args) throws SQLException,Exception{
        DictionaryMain obj= new DictionaryMain();
    } 
}