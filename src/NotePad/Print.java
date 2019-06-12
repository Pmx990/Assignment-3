import javax.swing.*;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class Print {
    Print(JTextPane d){
        System.out.println("abc");
                try {
        PrinterJob pjob = PrinterJob.getPrinterJob();
        pjob.setJobName("Sample Command Pattern");
        pjob.setCopies(1);
        pjob.setPrintable(new Printable() {
            public int print(Graphics pg, PageFormat pf, int pageNum) {
                if (pageNum > 0)
                    return Printable.NO_SUCH_PAGE;
                pg.drawString(d.getText(), 500, 500);
                d.paint(pg);
                return Printable.PAGE_EXISTS;
            }
        });

        if (pjob.printDialog() == false)
            return;
        pjob.print();
    } catch (
    PrinterException pe) {
        JOptionPane.showMessageDialog(null,
                "Printer error" + pe, "Printing error",
                JOptionPane.ERROR_MESSAGE);
    }
}
}