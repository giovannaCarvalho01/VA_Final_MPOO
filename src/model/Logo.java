package model;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Logo {

	private ImageIcon logoImageIcon;
	
	public Logo() {
		try {
			File file = new File("img/img.jpg");
			BufferedImage bufferedImage = ImageIO.read(file);
			logoImageIcon = new ImageIcon(bufferedImage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ImageIcon getLogoImageIcon() {
		return logoImageIcon;
	}
	
}
