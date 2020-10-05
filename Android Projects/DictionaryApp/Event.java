package Dictionary.bin.Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Dictionary.bin.Connector.*;

public class Event{
    protected DataConnector Data=null;
    protected JTextArea jtxout=null;
    protected JTextField jtxinput=null;
    protected JTextArea jtxout2=null;

    //constructor 
    public Event(DataConnector Data,JTextArea jtxout,JTextField jtxinput){
        this.Data=Data;
        this.jtxout=jtxout;
        this.jtxinput=jtxinput;
    }

    public Event(DataConnector Data,JTextArea jtxout,JTextArea jtxout2,JTextField jtxinput){
        this(Data,jtxout,jtxinput);
        this.jtxout2=jtxout2;
    }
}