
package dungeon;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Dungeon {

    
    public static void main(String[] args) {
         try{
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e){  
            
        } 
        
        
        Select p = new Select();
        
        p.setTitle("201114164");
        p.setSize(800, 600);
        p.setResizable(false);
        p.setLocationRelativeTo(null);
        p.setVisible(true);
        p.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        p.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent e) {
        PrintStream nullStream = new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {
            }

            @Override
            public void write(byte b[]) throws IOException {
            }

            @Override
            public void write(byte b[], int off, int len) throws IOException {
            }
        });
        System.setErr(nullStream);
        System.setOut(nullStream);
        System.exit(0);
            }
        });
    }    
    
}
