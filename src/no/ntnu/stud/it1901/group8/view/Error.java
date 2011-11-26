package no.ntnu.stud.it1901.group8.view;

import javax.swing.JOptionPane;

/**
 * Class for showing error messages to the user.
 * 
 */
public class Error {

	/**
	 * Shows an error message as a JOptionPane, and closes the program.
	 * 
	 * @param message
	 */
	public static void showErrorMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
		System.exit(0);
	}

	/**
	 * Shows a message as a JOptionPane to the user.
	 * 
	 * @param message
	 */
	public static void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	/**
	 * Shows a JOption to the user with the information "Error: Databasefeil".
	 * The program exits.
	 */
	public static void databaseError() {
		JOptionPane.showMessageDialog(null, "Error: Databasefeil");
		System.exit(0);
	}

}
