package GraphicsGames;

import MInefront.Display;

public class Render {
    public final int width;
    public final int height;
    public final int[] pixels;



    public Render(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
    }

    public void draw(Render render, int xOffset, int yOffset) {
        for (int y = 0; y < render.height; y++) {
            int yPix = y + yOffset;
            if (yPix < 0 || yPix >= Display.height) continue;
            for (int x = 0; x < render.width; x++) {
                int xPix = x + xOffset;
                if (xPix < 0 || xPix >= Display.width) continue;
                int alpha = render.pixels[x + y * render.width];

//                //without alpha support
//                pixels[xPix + yPix * width] = alpha;

                //with alpha support
                if (alpha > 0) {
                    pixels[xPix + yPix * width] = alpha;

                }
            }
        }
    }

}
