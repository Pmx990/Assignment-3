import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


public class Recent {
    private int count = 0;
    JMenu recent;

    Recent(JMenu recent1){ //,
        recent = recent1;
    }

    public void setRecent(String adr,UiStructure ui){
        JMenuItem adr1 = new JMenuItem(adr);
        adr1.addActionListener(ui);
        adr1.setActionCommand("recent");
        JMenuItem[] temp = new JMenuItem[count];
        if(count == 0){
            recent.add(adr1,count);
            count+=1;
        }else{
            System.out.println(recent.getItemCount());
            for(int i = 0; i<count;i++){
                temp[i] = recent.getItem(i);

            }
            recent.removeAll();
            System.out.println(recent.getItemCount());

            recent.add(adr1);
            System.out.println(temp.length);

            for(int i = 0; i<temp.length;i++){
                recent.add(temp[i]);
            }
            if(count < 4){
                count++;
            }
        }

    }

 //   }

}
