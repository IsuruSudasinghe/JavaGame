package MInefront;

import javax.swing.*;
import java.awt.*;


public class Display  extends Canvas{
    private static final int height = 400;
    private static final int width = 800;
    private static final String title = "Test Game 1.0";


    public static void  main(String[] args) {
        Display game = new Display();
        JFrame window = new JFrame();
        window.add(game);
        window.setSize(width,height);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setVisible(true);
        window.setTitle(title);
    }

}
