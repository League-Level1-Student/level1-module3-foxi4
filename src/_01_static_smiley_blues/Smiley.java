package _01_static_smiley_blues;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Smiley extends JLabel {
	public static final String YELLOW = "yellow";
	public static final String RED = "red";
	public static final String GREEN = "green";
	public static final String BLUE = "blue";
	//public static String color = BLUE;
	//public static String color = YELLOW;
	//public static String color = GREEN;
	public static String color = RED;
	//those that are green are the other colors you can make the smiley faces as :D
	
	Smiley(){
		super(loadIcon("_01_static_smiley_blues/smiley_"+ color +".jpg"));
	}
	
	private static Icon loadIcon(String fileName) {
		URL imageURL = Smiley.class.getClassLoader().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return icon;
	}
	
	public static void setColor(String newColor) {
		color = newColor;
	}
}
