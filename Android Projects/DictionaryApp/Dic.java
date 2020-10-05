package Dictionary.bin.GUI;

import javax.swing.*;
import java.awt.*;

public class Dic extends JFrame {

    private JPanel jp = new JPanel();
    private JPanel jp1 = new JPanel();
    private JPanel jp2 = new JPanel();
    private JPanel jp3 = new JPanel();
    private JPanel jp4 = new JPanel();
    private JPanel jp5 = new JPanel();
    private JPanel jp6 = new JPanel();
    protected JButton search = new JButton("SEARCH");
    private JLabel jlb1 = new JLabel("OOP DICTIONARY", JLabel.CENTER);
    private JLabel jlb2 = new JLabel("    Enter word");
    private JLabel jlb3 = new JLabel("Meaning");
    protected JTextField jtxinput = new JTextField();
    protected JTextArea jtxsuggest = new JTextArea(6, 20);
    protected JTextArea jtxmean = new JTextArea();
    protected JTextArea jtxbot = new JTextArea(1, 20);
    protected JButton addword = new JButton("Add Word");
    protected JButton deleteword = new JButton("Delete Word");
    protected JButton editword = new JButton("Edit Word");

    public JButton getsearch() {
        return this.search;
    }

    public JTextField getJtxinput() {
        return this.jtxinput;
    }

    public JTextArea getJtxout() {
        return this.jtxmean;
    }

    public JTextArea getJtxsuggest(){
        return this.jtxsuggest;
    }

    public JTextArea getJtxbot(){
        return this.jtxbot;
    }

    public JButton getAddword() {
        return this.addword;
    }

    public JButton getDeleteword() {
        return this.deleteword;
    }

    public JButton getEditword() {
        return this.editword;
    }

    public Dic() {
        setResizable(false);
        setLayout(new BorderLayout(10, 20));
        setTitle("OOP Dictionary");
        setPreferredSize(new Dimension(600, 500));
        //setSize(650, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLocationRelativeTo(null);
        jp.setLayout(new BorderLayout(10, 10));
        //jp.setBackground(Color.white);
        jp2.setLayout(new BorderLayout(10, 10));
        jp1.setLayout(new BorderLayout(0, 10));
        //jp2.setAlignmentY(100);
        jp3.setLayout(new BorderLayout(10, 10));
        jp4.setLayout(new BorderLayout(10, 10));
        jp5.setLayout(new BorderLayout(10, 10));
        jp6.setLayout(new GridLayout(3, 1, 0, 10));

        Font f1 = new Font("Times New Roman", Font.PLAIN, 16);
        Font f2 = new Font("Times New Roman", Font.BOLD, 16);
        Font f3 = new Font("Times New Roman", Font.BOLD, 38);

        jlb1.setFont(f3);
        jlb1.setForeground(Color.black);

        search.setFont(f2);
        search.setForeground(Color.white);
        search.setBackground(Color.black);
        search.setSize(50, 25);

        jlb2.setFont(f1);
        jlb2.setForeground(Color.black);

        jtxinput.setFont(f1);

        jlb3.setFont(f1);

        jtxsuggest.setLineWrap(true);
        jtxsuggest.setWrapStyleWord(true);
        jtxsuggest.setEnabled(false);
        JScrollPane sp2 = new JScrollPane(jtxsuggest);
        jtxsuggest.setFont(f1);

        jtxmean.setLineWrap(true);
        jtxmean.setWrapStyleWord(true);
        JScrollPane sp3 = new JScrollPane(jtxmean);
        jtxmean.setFont(f1);

        jtxbot.setLineWrap(true);
        jtxbot.setWrapStyleWord(true);
        jtxbot.setEnabled(false);
        JScrollPane sp4 = new JScrollPane(jtxbot);
        jtxbot.setFont(f1);

        addword.setFont(f2);
        addword.setForeground(Color.white);
        addword.setBackground(Color.black);

        editword.setFont(f2);
        editword.setForeground(Color.white);
        editword.setBackground(Color.black);

        deleteword.setFont(f2);
        deleteword.setForeground(Color.white);
        deleteword.setBackground(Color.black);

        add(jlb1, BorderLayout.NORTH);
        add(jp, BorderLayout.CENTER);
        jp.add(jp2, BorderLayout.NORTH);
        jp2.add(new Panel(), BorderLayout.EAST);
        jp2.add(new Panel(), BorderLayout.WEST);
        jp2.add(jlb2, BorderLayout.NORTH);
        jp1.add(jtxinput, BorderLayout.CENTER);
        jp1.add(search, BorderLayout.EAST);
        jp2.add(jp1, BorderLayout.CENTER);
        jp.add(jp3, BorderLayout.CENTER);
        jp3.add(new Panel(), BorderLayout.EAST);
        jp3.add(new Panel(), BorderLayout.WEST);

        //jp4.add(jlb3, BorderLayout.WEST);
        jp4.add(new Panel(), BorderLayout.WEST);
        jp4.add(sp2, BorderLayout.CENTER);
        jp4.add(new Panel(), BorderLayout.EAST);
        jp3.add(jp4, BorderLayout.NORTH);
        jp3.add(jp5, BorderLayout.CENTER);

        jp6.add(editword);
        jp6.add(addword);

        jp6.add(deleteword);
        jp5.add(jlb3, BorderLayout.NORTH);
        jp5.add(sp3, BorderLayout.CENTER);
        jp5.add(jp6, BorderLayout.EAST);
        jp5.add(sp4, BorderLayout.SOUTH);
        jp3.add(new Panel(), BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        Dic t = new Dic();
    }
}







