import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class Image {
    public ImageIcon icon;
}

class User extends Unit implements Accessible {
    public int flag=0;
    public User(JFrame frame, JLabel label) {
        move(frame, label);
        label.setBounds(x, y,50,50); // 유저위치에 이미지 삽입
    }

    public void move(JFrame frame, JLabel k) {
        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        if (k.getY() > 0) {
                            if ((k.getX() < 220 && k.getX() > 30) && (k.getY() < 160 && k.getY() > 50) ||
                                    (k.getX() < 220 && k.getX() > 30) && (k.getY() < 310 && k.getY() > 200) ||
                                    (k.getX() < 420 && k.getX() > 230) && (k.getY() < 160 && k.getY() > 50) ||
                                    (k.getX() < 420 && k.getX() > 230) && (k.getY() < 310 && k.getY() > 200)) {
                                System.out.println("UP error");
                            } else {
                                k.setLocation(k.getX(), k.getY() - 10);
                                System.out.println("x: " + k.getX() + " y:" + k.getY());
                            }
                        }
                        break;

                    case KeyEvent.VK_DOWN:
                        if (k.getY() < height - 80) {
                            if ((k.getX() < 220 && k.getX() > 30) && (k.getY() > 30 && k.getY() < 150) ||
                                    (k.getX() < 220 && k.getX() > 30) && (k.getY() > 180 && k.getY() < 300) ||
                                    (k.getX() < 420 && k.getX() > 230) && (k.getY() > 30 && k.getY() < 150) ||
                                    (k.getX() < 420 && k.getX() > 230) && (k.getY() > 180 && k.getY() < 300)) {
                                System.out.println("DOWN error");
                            } else {
                                k.setLocation(k.getX(), k.getY() + 10);
                                System.out.println("x: " + k.getX() + " y:" + k.getY());
                            }
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                        if (k.getX() > 0) {
                            if ((k.getX() > 40 && k.getX() < 230) && (k.getY() < 150 && k.getY() > 40) ||
                                    (k.getX() > 40 && k.getX() < 230) && (k.getY() < 300 && k.getY() > 190) ||
                                    (k.getX() > 240 && k.getX() < 430) && (k.getY() < 150 && k.getY() > 40) ||
                                    (k.getX() > 240 && k.getX() < 430) && (k.getY() < 300 && k.getY() > 190)) {
                                System.out.println("LEFT error");
                            } else {
                                k.setLocation(k.getX() - 10, k.getY());
                                System.out.println("x: " + k.getX() + " y:" + k.getY());
                            }
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (k.getX() < width - 65) {
                            if ((k.getX() >= 30 && k.getX() < 220) && (k.getY() < 150 && k.getY() > 40) ||
                                    (k.getX() >= 30 && k.getX() < 220) && (k.getY() < 300 && k.getY() > 190) ||
                                    (k.getX() >= 230 && k.getX() < 420) && (k.getY() < 150 && k.getY() > 40) ||
                                    (k.getX() >= 230 && k.getX() < 420) && (k.getY() < 300 && k.getY() > 190)
                            ) {
                                System.out.println("RIGHT error");
                            } else {
                                k.setLocation(k.getX() + 10, k.getY());
                                System.out.println("x: " + k.getX() + " y:" + k.getY());
                            }
                        }
                        break;
                    case KeyEvent.VK_ENTER:
                        if ((k.getX() >= 100 && k.getX() <= 150) && (k.getY() >= 150 && k.getY() <= 170)) {
                            press(frame, k);
                        }
                        if ((k.getX() >= 100 && k.getX() <= 150) && (k.getY() >= 300 && k.getY() <= 320)) {
                            press(frame, k);
                        }
                        if ((k.getX() >= 300 && k.getX() <= 350) && (k.getY() >= 150 && k.getY() <= 170)) {
                            press(frame, k);
                        }
                        if ((k.getX() >= 300 && k.getX() <= 350) && (k.getY() >= 300 && k.getY() <= 320)) {
                            press(frame, k);
                        }
                }
            }
        });
    }

    public void press(JFrame frame, JLabel k) {
        System.out.println(flag);
        if(flag==0) {
            frame.getContentPane().setBackground(Color.pink);
            flag=1;
        } else {
            frame.getContentPane().setBackground(Color.white);
            flag=0;
        }
    }
}
class Unit {
    public static int width=500;
    public static int height=450;
    int y; // 캐릭터 좌표
    int x; // 캐릭터 좌표
}

interface Moveable { void move(JFrame frame, JLabel label); } // 캐릭터가 움직이는 여부 (모서리 나감 x, 모니터 밟지 않기)
interface Pressable { void press(JFrame frame, JLabel k); } // 모니터 앞 의자에 앉아 엔터를 눌러 스터디창 여는 여부 (x,y 제한 범위)
interface Accessible extends Moveable, Pressable { } //

public class MainFrame extends JFrame {

    public JFrame frame = new JFrame("studyTool");
    public static int width=500;
    public static int height=450;
    ImageIcon monitorIcon = new ImageIcon(MainFrame.class.getResource("images/monitor.PNG"));
    ImageIcon seatIcon = new ImageIcon(MainFrame.class.getResource("images/seat.PNG"));
    ImageIcon userIcon = new ImageIcon(MainFrame.class.getResource("images/user.PNG"));

    JLabel k = new JLabel(userIcon);
    User user = new User(frame, k);

    paint draw = new paint();

    MainFrame() {
        frame.setContentPane(draw);
        frame.setLayout(null);
        frame.add(k);
        frame.setFocusable(true);
        frame.getContentPane().setBackground(Color.white);
        frame.setSize(width, height); //프레임 크기
        frame.setResizable(false);//창 크기 변경x
        frame.setLocationRelativeTo(null);//창 가운데 나옴
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 창 종료버튼
    }

    class paint extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            java.awt.Image img = monitorIcon.getImage();
            java.awt.Image img2 = seatIcon.getImage();

            //모니터
            g.drawImage(img, 80, 87, 140,67, this);
            g.drawImage(img, 80, 237, 140,67, this);
            g.drawImage(img, 280, 87, 140,67, this);
            g.drawImage(img, 280, 237, 140,67, this);

            //의자
            g.drawImage(img2, 110, 155, 70,35, this);
            g.drawImage(img2, 110, 305, 70,35, this);
            g.drawImage(img2, 310, 155, 70,35, this);
            g.drawImage(img2, 310, 305, 70,35, this);
        }
    }

    public static void main(String[] args) {
        MainFrame c = new MainFrame();
    }
}