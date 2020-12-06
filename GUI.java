import javax.swing.JFrame;
import java.awt.*;

public abstract class GUI extends JFrame {
    /**
     * Creates a GUI skeleton that all of the forms are based off
     */
    public GUI() {
        Container c = getContentPane();
        setBounds(100, 100, 470, 495);
        setBackground(new Color(204,204,204));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Song Ranker!");
        setResizable(false);
        c.setLayout(null);
        
    }
}
