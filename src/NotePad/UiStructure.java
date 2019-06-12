import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
/*
 * Change list
 * 1. make the main independent from the UI
 * 2. use strategy pattern instead of the original ifelse
 * 3. make the function independent from the UI
 * 4. add null pointer exception err mesg to the save file
 * 5. add comments
 * */



public class UiStructure extends JFrame implements ActionListener {
    private JMenuBar menubar = new JMenuBar();
    private JMenu filemenu = new JMenu("File");
    private JMenu editmenu = new JMenu("Edit");
    private JMenu recent = new JMenu("Recent");
    private JTextPane d = new JTextPane();
    private JMenuItem newfile = new JMenuItem("New File");
    private JMenuItem savefile = new JMenuItem("Save File");
    private JMenuItem printfile = new JMenuItem("Print File");
    private JMenuItem openfile = new JMenuItem("Open File");
    private JMenuItem copy = new JMenuItem("Copy");
    private JMenuItem paste = new JMenuItem("Paste");
    private JMenuItem replace = new JMenuItem("Replace");



    public UiStructure() {
        setTitle("A Simple Notepad Tool");
        filemenu.add(newfile);
        filemenu.addSeparator();
        filemenu.add(openfile);
        filemenu.add(savefile);
        filemenu.addSeparator();
        filemenu.add(printfile);
        filemenu.add(recent);
        editmenu.add(copy);
        editmenu.add(paste);
        editmenu.add(replace);
        newfile.addActionListener(this);
        newfile.setActionCommand("new");
        openfile.addActionListener(this);
        openfile.setActionCommand("open");
        savefile.addActionListener(this);
        savefile.setActionCommand("save");
        printfile.setActionCommand("print");
        copy.addActionListener(this);
        copy.setActionCommand("copy");
        paste.addActionListener(this);
        paste.setActionCommand("paste");
        replace.addActionListener(this);
        replace.setActionCommand("replace");
        menubar.add(filemenu);
        menubar.add(editmenu);
        setJMenuBar(menubar);
        add(new JScrollPane(d));
        setPreferredSize(new Dimension(600, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MenuStrategy ms = new MenuStrategy(recent);
        System.out.println(e.getActionCommand());
            JMenuItem a = (JMenuItem)e.getSource();
            ms.menuCall(e.getActionCommand(), d, this,a);
    }



}

