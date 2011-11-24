package view;

import javax.swing.JOptionPane;

public class Error {

	public static void showErrorMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
		System.exit(0);
	}

	public static void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public static void databaseError() {
		JOptionPane.showMessageDialog(null, "Error: Databasefeil");
		System.exit(0);
	}

}
