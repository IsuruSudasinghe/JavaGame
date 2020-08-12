package GraphicsGames;


import MInefront.Game;

import java.util.Random;

public class Screen extends Render {
    private Render testSC;


    public Screen(int width, int height) {
        super(width, height);
        Random random = new Random();
        testSC = new Render(254, 254);


        for (int i = 0; i < 254 * 254; i++) {
            testSC.pixels[i] = random.nextInt();
        }
    }

    public void render(Game game) {
        for (int i = 0; i < height * width; i++) pixels[i] = 0;

        //modified version
        for (int i = 0; i < 50; i++) {
            int xAnim = (int) (Math.sin((game.time + i * 2) % 1000.0 / 100) * 100);
            int yAnim = (int) (Math.cos((game.time + i * 2) % 1000.0 / 100) * 100);

            draw(testSC, (width - 254) / 2 + xAnim, (height - 254) / 2 - yAnim);
//            System.out.println(yAnim);
        }

//            //basic circles
//            int xAnim = (int) (Math.sin(System.currentTimeMillis() % 2000.0 / 2000.0  * Math.PI * 2) * 200);
//            int yAnim = (int) (Math.cos(System.currentTimeMillis() % 2000.0 / 2000.0  * Math.PI * 2) * 200);
//
//            draw(testSC, (width - 254) / 2 + xAnim, (height - 254) / 2 + yAnim);


    }

}
