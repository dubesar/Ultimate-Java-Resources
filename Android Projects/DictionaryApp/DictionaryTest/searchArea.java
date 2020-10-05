package Dictionary.Test.bin.Interface.Componnet;

import javax.swing.*;
import java.awt.*;

public class searchArea extends JPanel{
    JButton search=null;
    JTextField textBox=null;

    //constructor
    public searchArea(){
        //construct layout as BorderLayout
        super(new BorderLayout());
    }
    
    //add search buttom
    public void setSearch(JButton search){
        add(search,BorderLayout.EAST);
        this.search=search;
    }

    //add textBox
    public void setTextBox(JTextField textBox){
        add(textBox,BorderLayout.CENTER);
        this.textBox=textBox;
    }
}