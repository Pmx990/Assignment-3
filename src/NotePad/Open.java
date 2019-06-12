import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Open {
    JTextPane d;
    Recent r;
    Open(JTextPane dx,UiStructure ui,Recent r) {
        /*
        * Opening the file from file chooser
        * */
        d=dx;
        JFileChooser jc = new JFileChooser();
        jc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jc.showDialog(new JLabel(),"Select");
        File file = jc.getSelectedFile();
        d.setText(file.toString());
        try{
            int temp=0;
            InputStream in = new FileInputStream(file);
            StringBuffer sb = new StringBuffer();
            while(temp!=-1){
                temp = in.read();
                char by = (char)temp;
                sb.append(by);
            }
            System.out.println(sb.toString());
            d.setText(sb.toString());
            in.close();
            r.setRecent(file.getAbsolutePath(),ui);

        }catch (java.io.FileNotFoundException ff){
            System.out.println("File not found");
        }catch (java.io.IOException io){

        }
    }
    Open(String adr,JTextPane dx){
        /*
        * Opening the recent file
        * */
        d=dx;
        File file = new File(adr);
        try{
            int temp=0;
            InputStream in = new FileInputStream(file);
            StringBuffer sb = new StringBuffer();
            while(temp!=-1){
                temp = in.read();
                char by = (char)temp;
                sb.append(by);
            }
            System.out.println(sb.toString());
            d.setText(sb.toString());
            in.close();

        }catch (java.io.FileNotFoundException ff){
            System.out.println("File not found");
        }catch (java.io.IOException io){

        }
    }

}
