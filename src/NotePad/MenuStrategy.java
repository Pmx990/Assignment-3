import javax.swing.*;
import java.nio.file.Paths;

public class MenuStrategy {
    Recent r;
    MenuStrategy(JMenu recent){
        Recent r1 = new Recent(recent);
        r=r1;
    }
     public void menuCall(String type, JTextPane d,UiStructure ui,JMenuItem adr1) {
        /*
        * Through strategy, call different functions while different action was requested
        * */
         switch (type) {
             case "new": {
                 CreateNew n = new CreateNew(d);
                 break;
             }
             case "save":{
                 SaveFile s = new SaveFile(d);
                 break;
             }
             case "print":{
                 Print p = new Print(d);
                 break;
             }
             case "copy":{
                 Copy cp = new Copy(d);
                 break;
             }
             case "paste":{
                 Paste ps = new Paste(d);
                 break;
             }
             case "undo":{
                 Undo ud = new Undo(d);
                 break;
             }
             case "open":{
                 Open op = new Open(d,ui,r);
                 break;
             }
             case "replace":{
                 Replace rp = new Replace(d,ui);
                 break;
             }
             case"recent":{
                 String temp = Paths.get(adr1.getText()).toString();
                 Open op = new Open(temp,d);
                 break;
             }
             default:
                 System.err.println("Wrong choice");
                break;
         }
     }
    // public void recentCall(JMenuItem adr1,JTextPane d){

     //}
}
