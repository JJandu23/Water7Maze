package Model.Hero;

import Model.MazeCharacter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Nami extends Hero {
    public Nami() {
        super("Nami", 90, 10, 10,
                20, 0.5, 0.4, 0.20, 6);
        try {
            BufferedImage downIm1 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Nami/down1.png")));
            BufferedImage downIm2 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Nami/down2.png")));
            BufferedImage downIm3 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Nami/down3.png")));

            BufferedImage leftIm1 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Nami/left1.png")));
            BufferedImage leftIm2 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Nami/left2.png")));
            BufferedImage leftIm3 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Nami/left3.png")));

            BufferedImage rightIm1 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Nami/right1.png")));
            BufferedImage rightIm2 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Nami/right2.png")));
            BufferedImage rightIm3 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Nami/right3.png")));

            BufferedImage upIm1 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Nami/up1.png")));
            BufferedImage upIm2 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Nami/up2.png")));
            BufferedImage upIm3 = (ImageIO.read(getClass().getResourceAsStream("../../View/Sprites/Nami/up3.png")));

            setImages(downIm1, downIm2, downIm3, leftIm1, leftIm2, leftIm3, rightIm1, rightIm2, rightIm3,  upIm1, upIm2, upIm3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method represents the special attack of the hero.
     * @param theEnemy the enemy that is being attacked
     * @Override the specialAttack method in the MazeCharacter class.
     */
    @Override
    public void specialAttack(final MazeCharacter theEnemy) {
        Random chance = new Random();
        if (chance.nextFloat() <= getSpecialChance()) {
            System.out.println(getName() + " used mirage tempo!");
            if (getDodgeChance() < 1.0) {
                setDodgeChance(getDodgeChance() + 0.1);
                System.out.println(getName() + "'s dodge is now " + getDodgeChance() + "!");
            } else {
                System.out.println(getName() + "'s dodge is already at max!");
            }
        } else {
            System.out.println(getName() + " failed to use mirage tempo!");
        }
    }
}
