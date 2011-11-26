package no.ntnu.stud.it1901.group8.model;

import java.awt.Desktop;
import java.awt.print.PrinterException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import java.io.*;

import no.ntnu.stud.it1901.group8.controller.ManageOrder;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


/**
 * A class for making and printing a receipt.
 * 
 */
public class Receipt {

	/**
	 *Opens the .pdf file
	 * 
	 * @throws IOException
	 */
	public static void openReceipt() throws IOException {
		Desktop desktop = null;
		if (Desktop.isDesktopSupported()) {
			desktop = Desktop.getDesktop();
		}
		desktop.open(new File("Receipt.pdf"));
	}

	/**
	 * Uses PrintPff to print out the file.
	 * 
	 * @throws IOException
	 * @throws PrinterException
	 */
	public static void printFile() throws IOException, PrinterException {
		PrintPdf.PrintFile("Receipt.pdf");
	}

	/**
	 * Creates and writes to a .pdf file
	 * 
	 * @param order
	 * @throws DocumentException
	 * @throws FileNotFoundException
	 */
	public static void makeReceipe(Order order) throws FileNotFoundException,
			DocumentException {

		DecimalFormat twoDecimals = new DecimalFormat("0.00");
		Document document = new Document(PageSize.A4, 36, 72, 108, 180);
		PdfWriter.getInstance(document, new FileOutputStream("Receipt.pdf"));
		ArrayList<Product> products = order.getProductsInOrder();
		Customer customer = order.getCustomer();

		document.open();

		Chunk header = new Chunk(Properties.getName() + "\n\n");
		Font headerFont = new Font();
		headerFont.setSize(28);
		header.setFont(headerFont);
		String gap = "               ";
		Paragraph paragraph = new Paragraph(gap);
		paragraph.add(header);

		document.add(paragraph);
		document.add(new Paragraph(gap + "Tlf:             "
				+ Properties.getPhone()));
		document.add(new Paragraph(gap + "Addresse:  "
				+ Properties.getAddress()));
		document.add(new Paragraph(gap + gap + "   " + Properties.getZipCode()
				+ " " + Properties.getPostalAddress() + "\n\n"));
		document.add(new Paragraph(gap + "Dato: " + showTime("dd.MM.yyyy")
				+ "\n" + gap + " Tid:   " + showTime("HH:mm" + "\n\n")));

		PdfPTable table = new PdfPTable(5);
		table.addCell("Vare:");
		table.addCell("Pris vare:");
		table.addCell("Herav MVA");
		table.addCell("Antall:");
		table.addCell("Sum");

		for (int i = 0; i < products.size(); i++) {
			Product product = products.get(i);
			int quantity = product.getQuantity();
			double productPrice = product.getPrice();
			double bottomLine = (double) quantity * product.getPrice();
			table.addCell(product.getName());
			table.addCell(twoDecimals.format(productPrice));
			table.addCell(twoDecimals.format(product.getTax()));
			int value = product.getQuantity();
			table.addCell(Integer.toString(value));
			table.addCell(twoDecimals.format(bottomLine));
		}

		table.addCell("Total sum");
		table.addCell("");
		table.addCell(twoDecimals.format(ManageOrder
				.getTotalTaxesInOrder(order)));
		table.addCell("");
		table.addCell(twoDecimals.format(ManageOrder.getTotalPrice(order)));

		document.add(table);
		document.add(new Paragraph("\n\n" + gap + "Kundeinformasjon:\n\n"));
		document.add(new Paragraph(gap + "Navn:       "
				+ customer.getForename() + " " + customer.getLastname() + "\n "
				+ gap + "Telefon:   " + customer.getPhone() + "\n " + gap
				+ "Adresse:  " + customer.getAddress() + "\n   " + gap
				+ "              " + customer.getzipCode() + "  "
				+ customer.getPostalAddress()));

		document.close();

	}

	/**
	 * Finds the time and date and returns it as a String.
	 * 
	 * @param dateFormat
	 * @return time
	 */
	private static String showTime(String dateFormat) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(cal.getTime());
	}

}