
/*
import javax.swing.*;
import java.awt.*;

class ImagePaint extends JPanel {
    public JPanel panel;
    ImagePaint(String source) {
        panel = new JPanel() { // 한개로 4개를 만들기 때문에 static x, public으로 해야함
            Image background = new ImageIcon(Main.class.getResource(source)).getImage();
            public void paint(Graphics g) {//그리는 함수
                g.drawImage(background, 0, 0, null);//background를 그려줌
            }
        };
    }
}

class MonitorPaint extends JPanel {
    public ImagePaint[] monitor = new ImagePaint[4];
    MonitorPaint(JFrame fr) {
        for(int i=0; i<4; i++) {
            monitor[i] = new ImagePaint("images/monitor.PNG");
        }
        for(int i=0; i<4; i++) {
            monitor[i].setLayout(null);
            switch (i) {
                case 0: monitor[i].panel.setBounds(50, 50, 200, 100);
                    break;
                case 1: monitor[i].panel.setBounds(50, 200, 200, 100);
                    break;
                case 2: monitor[i].panel.setBounds(250, 50, 200, 100);
                    break;
                case 3: monitor[i].panel.setBounds(250, 200, 200, 100);
                    break;
            }
            fr.add(monitor[i].panel);
        }
    }
}

class SeatPaint extends JPanel {
    public ImagePaint[] seat = new ImagePaint[4];
    SeatPaint(JFrame fr) {
        for(int i=0; i<4; i++) {
            seat[i] = new ImagePaint("images/seat.PNG");
        }
        for(int i=0; i<4; i++) {
            seat[i].setLayout(null);
            switch (i) {
                case 0: seat[i].panel.setBounds(80, 120, 70, 50);
                    break;
                case 1: seat[i].panel.setBounds(80, 270, 70, 50);
                    break;
                case 2: seat[i].panel.setBounds(280, 120, 70, 50);
                    break;
                case 3: seat[i].panel.setBounds(280, 270, 70, 50);
                    break;
            }
            fr.add(seat[i].panel);
        }
    }
}

class userPaint extends JPanel {
    public ImagePaint user;
    userPaint(JFrame fr) {
        user = new ImagePaint("images/user.PNG");
        user.panel.setBounds(0,0,155,155);
        user.setLayout(null);
        fr.add(user.panel);
    }
}

public class MainFrame extends JFrame {
    public JFrame frame = new JFrame("studyTool");
    userPaint user = new userPaint(frame);
    MonitorPaint monitor = new MonitorPaint(frame);
    SeatPaint seat = new SeatPaint(frame);


    MainFrame() {
        frame.setSize(440,400); //프레임 크기
        frame.setResizable(false);//창 크기 변경x
        frame.setLocationRelativeTo(null);//창 가운데 나옴
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 창 종료버튼
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}*/