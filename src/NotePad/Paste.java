import javax.swing.*;
import javax.swing.text.Position;
import javax.swing.text.StyledDocument;

public class Paste {
    Paste(JTextPane d){
        StyledDocument doc = d.getStyledDocument();
        Position position = doc.getEndPosition();
        System.out.println("offset" + position.getOffset());
        d.paste();

    }
}
