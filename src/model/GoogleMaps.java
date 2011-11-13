package model;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class GoogleMaps extends JFrame {
	
	public static JLabel map(String input) throws MalformedURLException, IOException {
		String address = "http://maps.googleapis.com/maps/api/staticmap?markers=size:mid%7Ccolor:red%7C" + validateAddress(input) + "&zoom=14&size=380x455&maptype=roadmap&&sensor=false";
		
		Image image = ImageIO.read(new URL(address));
		JLabel label = new JLabel(new ImageIcon(image));

		return label;
	}
	
	
	public static String validateAddress(String input) {
		String output = "";
		
	
		
		for (int i = 0; i < input.length(); i++) {
			
			int value = (char)input.charAt(i);
			
			if ((value >= 65) && (value <= 93))
				output += input.charAt(i);
			else if ((value >= 97) && (value <= 125))
				output += input.charAt(i);
			else if ((value >= 48) && (value <= 57))
				output += input.charAt(i);
			else if (value == 32)
				output += "%20";
		}
			
		
		return output;
		
	}
}