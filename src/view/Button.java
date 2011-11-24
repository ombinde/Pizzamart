package view;

import java.awt.Color;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JLabel;

/**
 * Contains static methods for creating buttons. It also contains methods for
 * changing the color or icon of a button.
 * 
 */
public class Button {

	/**
	 * Creates and returns a JLabel with the text given as parameter. The color
	 * of the button will be set according to the color string. The icon will be
	 * set according to the icon string.
	 * 
	 * @param text
	 * @param color
	 * @param icon
	 * @return JLabel A button implemented as a JLabel.
	 */
	public static JLabel createButton(String text, String color, String icon) {
		JLabel button = new JLabel();

		button.setOpaque(true);
		button.setFont(new java.awt.Font("Georgia", 0, 18));
		button.setIconTextGap(10);
		button.setText(text);

		java.net.URL URL;
		try {
			URL = new URL("http://folk.ntnu.no/mortnod/it1901/" + icon + ".png");
			button.setIcon(new javax.swing.ImageIcon(URL));
		} catch (MalformedURLException e) {
		}

		Color background, foreground, border;

		if (color.equals("blue")) {
			background = new Color(225, 230, 235);
			foreground = new Color(45, 65, 105);
			border = new Color(170, 180, 200);
		} else if (color.equals("green")) {
			background = new Color(230, 240, 200);
			foreground = new Color(64, 80, 25);
			border = new Color(180, 190, 130);
		} else if (color.equals("red")) {
			background = new Color(235, 210, 210);
			foreground = new Color(115, 35, 35);
			border = new Color(205, 135, 135);
		} else {
			background = new Color(245, 245, 215);
			foreground = new Color(100, 70, 20);
			border = new Color(235, 210, 155);
		}

		button.setBackground(background);
		button.setForeground(foreground);
		button.setBorder(javax.swing.BorderFactory.createCompoundBorder(
				javax.swing.BorderFactory.createLineBorder(border, 2),
				javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));

		return button;
	}

	/**
	 * Takes in a JLabel, and changes the color of it to the color given as
	 * parameter.
	 * 
	 * @param button
	 * @param color
	 */
	public static void changeColor(JLabel button, String color) {
		Color background, foreground, border;

		if (color.equals("blue")) {
			background = new Color(225, 230, 235);
			foreground = new Color(45, 65, 105);
			border = new Color(170, 180, 200);
		} else if (color.equals("green")) {
			background = new Color(230, 240, 200);
			foreground = new Color(65, 80, 25);
			border = new Color(180, 190, 130);
		} else if (color.equals("red")) {
			background = new Color(235, 210, 210);
			foreground = new Color(115, 35, 35);
			border = new Color(205, 135, 135);
		} else {
			background = new Color(245, 245, 215);
			foreground = new Color(100, 70, 20);
			border = new Color(235, 210, 155);
		}

		button.setBackground(background);
		button.setForeground(foreground);
		button.setBorder(javax.swing.BorderFactory.createCompoundBorder(
				javax.swing.BorderFactory.createLineBorder(border, 2),
				javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));

	}

	/**
	 * Takes a JLabel in and changes the icon to the icon given as a string.
	 * 
	 * @param button
	 * @param icon
	 */
	public static void changeIcon(JLabel button, String icon) {
		java.net.URL URL;
		try {
			URL = new URL("http://folk.ntnu.no/mortnod/it1901/" + icon + ".png");
			button.setIcon(new javax.swing.ImageIcon(URL));
		} catch (MalformedURLException e) {
		}
	}
}