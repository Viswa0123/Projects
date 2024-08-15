import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class FlappyBird extends JPanel implements ActionListener {
    int bwidth = 360;
    int bheight = 640;

    Image background;
    Image bird;
    Image tpipe;
    Image bpipe;

    int birdx = bwidth / 8;
    int birdy = bheight / 2;
    int birdheight = 34;
    int birdwidth = 24;

    class Bird {
        int x = birdx;
        int y = birdy;
        int width = birdwidth;
        int height = birdheight;
        Image img;

        Bird(Image i) {
            img = i;
        }
    }

    Bird bird2;
    int velocityY = 8;

    Timer gloop;

    FlappyBird(){
        setPreferredSize(new Dimension(bwidth,bheight));

        background = new ImageIcon(getClass().getResource("./flappybirdbg.png")).getImage();
        bird = new ImageIcon(getClass().getResource("./flappybird.png")).getImage();
        tpipe = new ImageIcon(getClass().getResource("./toppipe.png")).getImage();
        bpipe = new ImageIcon(getClass().getResource("./bottempipe.png")).getImage();

        bird2 = new Bird(bird);

        gloop = new Timer(1000/60, this);
        gloop.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.drawImage(background, 0, 0, bwidth, bheight, null);

        g.drawImage(bird2.img, bird2.x, bird2.y, bird2.width, bird2.height, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
