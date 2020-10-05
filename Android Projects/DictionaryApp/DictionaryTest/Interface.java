package Dictionary.Test.bin.Interface;

import javax.swing.*;
import java.awt.*;
import Dictionary.bin.Interface.*;
import Dictionary.bin.Interface.Componnet.*;

public class Interface extends JFrame{
    protected JPanel main=null;
    protected JPanel select=null;
    protected JPanel adv=null;
    
    //constructor
    public Interface(){
        //exit program when frame close
        super("OOP Dictionary");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set size for frame
        setPreferredSize(new Dimension(700,500));
        pack();
        setVisible(true);
    }

    //mainPage part
    public void setMainArea(JPanel main){
        add(main,BorderLayout.CENTER);
        this.main=main;
    }

    //selection part
    public void setSelectionArea(JPanel select){
        add(select,BorderLayout.NORTH);
        this.select=select;
    } 

    //advertisement part
    public void setAdv(){
        add(new JLabel("advertisements area",JLabel.CENTER),BorderLayout.WEST);
    }
    public void setAdv(JPanel adv){
        add(adv,BorderLayout.WEST);
        this.adv=adv;
    }

    //main run test
    public static void main(String[] args){
        //create discription
        JTextArea textBox=new JTextArea();
        textBox.setLineWrap(true);
        textBox.setWrapStyleWord(true);
        textBox.setFont(new Font("Times New Roman", Font.PLAIN,16));


        //create search box
        searchArea search=new searchArea();
        search.setSearch(new JButton("SEARCH"));
        search.setTextBox(new JTextField());

        //create main area of search
        mainArea main=new mainArea();
        main.setSearchArea(search);
        main.setDiscription(textBox);

        //create SelectionArea
        selectionArea selectedA=new selectionArea(new JButton("search"),new JButton("edit"),new JButton("insert"));

        //create whole GUI
        Interface GUI=new Interface();
        GUI.setAdv();
        GUI.setSelectionArea(selectedA);
        GUI.setMainArea(main);
    }
}