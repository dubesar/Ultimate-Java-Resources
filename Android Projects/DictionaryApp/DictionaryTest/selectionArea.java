package Dictionary.Test.bin.Interface;

import javax.swing.*;
import java.awt.*;

public class selectionArea extends JPanel{
    protected JButton b1=null;
    protected JButton b2=null;
    protected JButton b3=null;

    //constructor
    public selectionArea(JButton b1, JButton b2, JButton b3 ){
        //set LayoutManager is GridLayout
        super(new GridLayout(1,3));

        //add buttom to selectionArea
        add(b1);
        this.b1=b1;
        add(b2);
        this.b2=b2;
        add(b3);
        this.b3=b3;
    }
}