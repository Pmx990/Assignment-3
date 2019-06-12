import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveFile {
    SaveFile(JTextPane d){
        File fileToWrite = null;
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showSaveDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION)
            fileToWrite = fc.getSelectedFile();
        try {
            PrintWriter out = new PrintWriter(new FileWriter(fileToWrite));
            out.println(d.getText());
            JOptionPane.showMessageDialog(null, "File is saved successfully...");
            out.close();
        } catch (IOException ex) {
            System.err.println("Save fail, IOEexception");
        }catch(NullPointerException np){
            System.err.println("No file being saved, NullPointerException");
        }
    }

}

