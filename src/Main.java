import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main(){
        setTitle("Drawing a Circle");
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawOval(25, 25, 50, 50);

    }

    public static void main(String[] args) {
        new Main();
    }
}