import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JWindow {
    private static final int SPLASH_WIDTH = 500;
    private static final int SPLASH_HEIGHT = 300;

    public SplashScreen() {
        JPanel content = new JPanel(new BorderLayout());
        JLabel label = new JLabel(new ImageIcon("splash_image.png"));
        content.add(label, BorderLayout.CENTER);
        setContentPane(content);
        setSize(SPLASH_WIDTH, SPLASH_HEIGHT);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SplashScreen splash = new SplashScreen();
        splash.setVisible(true);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        splash.dispose();
        new LoginForm().setVisible(true);
    }
}