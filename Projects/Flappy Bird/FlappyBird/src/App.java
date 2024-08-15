import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        int bwidth = 360;
        int bheight = 640;

        JFrame frame = new JFrame("Flappy Bird");
        frame.setSize(bwidth, bheight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FlappyBird flappyBird = new FlappyBird();
        frame.add(flappyBird);
        frame.pack();
        frame.setVisible(true);
    }
}
