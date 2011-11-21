package view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class Labels {
	
	public static JLabel createOneLineLabel(String text, String color) {
		javax.swing.JLabel label = new javax.swing.JLabel();
		
		Color background, foreground, border;
		
		if (color.equals("yellow")) {
			background = new java.awt.Color(245, 245, 215);
			foreground = new java.awt.Color(100, 70, 20);
			border = new java.awt.Color(235, 210, 155);
		}
		else if (color.equals("red")) {
			background = new java.awt.Color(235, 210, 210);
			foreground = new java.awt.Color(115, 35, 35);
			border = new java.awt.Color(205, 135, 135);
		}
		else {
			background = new java.awt.Color(225, 230, 235);
			foreground = new java.awt.Color(45, 65, 105);
			border = new java.awt.Color(170, 180, 200);
		}	

		label.setText(text);
		label.setBackground(background);
        label.setForeground(foreground);
        label.setBorder(javax.swing.BorderFactory.createCompoundBorder(
        		javax.swing.BorderFactory.createLineBorder(border, 2), 
        		javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        label.setFont(new java.awt.Font("Georgia", 0, 18));
        label.setPreferredSize(new java.awt.Dimension(140, 20));
        label.setOpaque(true);
		
		return label;
	}
	
	public static ArrayList<JLabel> createTwoLineLabel(String firstLine, String secondLine, String color) {
		Color background, foreground, border;

		if (color.equals("yellow")) {
			background = new java.awt.Color(245, 245, 215);
			foreground = new java.awt.Color(100, 70, 20);
			border = new java.awt.Color(235, 210, 155);
		}
		else if (color.equals("red")) {
			background = new java.awt.Color(235, 210, 210);
			foreground = new java.awt.Color(115, 35, 35);
			border = new java.awt.Color(205, 135, 135);
		}
		else {
			background = new java.awt.Color(225, 230, 235);
			foreground = new java.awt.Color(45, 65, 105);
			border = new java.awt.Color(170, 180, 200);
		}
		
		javax.swing.JLabel upperHalf = new javax.swing.JLabel();
		upperHalf.setText(firstLine);
		upperHalf.setBackground(background);
        upperHalf.setForeground(foreground);
        upperHalf.setBorder(javax.swing.BorderFactory.createCompoundBorder(
        		BorderFactory.createMatteBorder(2, 2, 0, 2, border),
        		javax.swing.BorderFactory.createEmptyBorder(7, 10, 0, 10)));
    	upperHalf.setFont(new java.awt.Font("Georgia", 0, 18));
        upperHalf.setPreferredSize(new java.awt.Dimension(140, 20));
        upperHalf.setOpaque(true);

    	javax.swing.JLabel lowerHalf = new javax.swing.JLabel();
    	lowerHalf.setText(secondLine);
        lowerHalf.setBackground(background);
    	lowerHalf.setForeground(foreground);
    	lowerHalf.setBorder(javax.swing.BorderFactory.createCompoundBorder(
    			BorderFactory.createMatteBorder(0, 2, 2, 2, border),
    			javax.swing.BorderFactory.createEmptyBorder(0, 10, 7, 10)));
    	lowerHalf.setPreferredSize(new java.awt.Dimension(140, 20));
    	lowerHalf.setOpaque(true);

    	ArrayList<JLabel> label = new ArrayList<JLabel>();
    	label.add(upperHalf);
    	label.add(lowerHalf);
		return label;
	}
	
	public static JLabel createBorderlessLabel(String text, int i){
    	javax.swing.JLabel label = new javax.swing.JLabel();
        label.setText(text);
        label.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        label.setPreferredSize(new java.awt.Dimension(140, 20));
        label.setSize(new java.awt.Dimension(140, 20));
        label.setOpaque(true);
        label.setVisible(true);
        // Make it so that every other JLabel has a different background color than the previous
        Color background;
        if (i % 2 == 0) {
        	background = new java.awt.Color(220, 220, 220);
        }
        else {
        	background = new java.awt.Color(240, 240, 240);
        }
        label.setBackground(background);
        
        return label;
	}
	
}
