package Dictionary.Test.bin.Interface;

import javax.swing.*;
import java.awt.*;

public class mainArea extends JPanel{
    protected JPanel Search=null;
    protected JTextArea textDiscription=null;

    //constructor
    public mainArea(){       
        //construct layout as BorderLayout
        super(new BorderLayout());
    }

    // add search area
    public void setSearchArea(JPanel Search){
        add(Search,BorderLayout.NORTH);
        this.Search=Search;
    }

    //add discription area
    public void setDiscription(JTextArea textDiscription){
        add(textDiscription,BorderLayout.CENTER);
        this.textDiscription=textDiscription;
    }
}