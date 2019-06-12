import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Replace extends JFrame{
   //private JFrame replace;
    Replace(JTextPane d,UiStructure ui){
        JPanel repnl = new JPanel();
        JTextField replacetext = new JTextField(20);
        JButton btn = new JButton("Replace");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.replaceSelection(replacetext.getText());
            }
        });
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 0.5;
        c.weighty = 0.5;
        repnl.add(replacetext,c);
        c.gridy=2;
        repnl.add(btn,c);
        add(repnl);
        pack();
        setVisible(true);

    }

}
