import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


class ImagePaint extends JPanel {
    public JPanel panel;
    ImagePaint(String source) {
        panel = new JPanel() { // 한개로 4개를 만들기 때문에 static x, public으로 해야함
            Image background = new ImageIcon(MainFrame.class.getResource(source)).getImage();
            public void paint(Graphics g) {//그리는 함수
                g.drawImage(background, 0, 0, null);//background를 그려줌
            }
        };
    }
}

class MonitorPaint extends JPanel {
    ImageIcon MonitorIcon= new ImageIcon(MainFrame.class.getResource("images/monitor.PNG"));
    JLabel[] monitor = new JLabel[4];
    MonitorPaint(JFrame fr) {
        for(int i=0; i<4; i++) {
            monitor[i] = new JLabel(MonitorIcon);
        }
        for(int i=0; i<4; i++) {
            switch (i) {
                case 0: monitor[i].setBounds(50, 75, 200, 100);
                    break;
                case 1: monitor[i].setBounds(50, 225, 200, 100);
                    break;
                case 2: monitor[i].setBounds(250, 75, 200, 100);
                    break;
                case 3: monitor[i].setBounds(250, 225, 200, 100);
                    break;
            }
            fr.add(monitor[i]);
        }
    }
}

class SeatPaint extends JPanel {
    ImageIcon seatIcon= new ImageIcon(MainFrame.class.getResource("images/seat.PNG"));
    JLabel[] seat = new JLabel[4];
    SeatPaint(JFrame fr) {
        for(int i=0; i<4; i++) {
            seat[i] = new JLabel(seatIcon);
        }
        for(int i=0; i<4; i++) {
            switch (i) {
                case 0: seat[i].setBounds(110, 150, 70, 50);
                    break;
                case 1: seat[i].setBounds(110, 300, 70, 50);
                    break;
                case 2: seat[i].setBounds(310, 150, 70, 50);
                    break;
                case 3: seat[i].setBounds(310, 300, 70, 50);
                    break;
            }
            fr.add(seat[i]);
        }
    }
}

public class MainFrame extends JFrame {
    public JFrame frame = new JFrame("studyTool");
    ImageIcon userIcon= new ImageIcon(MainFrame.class.getResource("images/user.PNG"));
    JLabel k = new JLabel(userIcon);
    JLabel basis = new JLabel();
    MonitorPaint monitor = new MonitorPaint(frame);
    SeatPaint seat = new SeatPaint(frame);
    MainFrame() {
        frame.setLayout(null);
        k.setBounds(0,0,50,50);
        frame.add(k);
        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                switch(e.getKeyCode()){
                    case KeyEvent.VK_UP:
                        k.setLocation(k.getX(), k.getY()-10);
                        break;

                    case KeyEvent.VK_DOWN:
                        k.setLocation(k.getX(), k.getY()+10);
                        break;
                    case KeyEvent.VK_LEFT:
                        k.setLocation(k.getX()-10, k.getY());
                        break;
                    case KeyEvent.VK_RIGHT:
                        k.setLocation(k.getX()+10, k.getY());
                        break;
                }

            }
        });

        frame.setFocusable(true);
        frame.setSize(500,450); //프레임 크기
        frame.setResizable(false);//창 크기 변경x
        frame.setLocationRelativeTo(null);//창 가운데 나옴
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 창 종료버튼
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}