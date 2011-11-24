package model;

import java.awt.Desktop;
import java.awt.print.PrinterException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import java.io.*;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

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
	 * creates and writes to a .pdf file
	 * 
	 * @param Order
	 * @throws DocumentException
	 * @throws FileNotFoundException
	 */
	public static void makeReceipe(Order order) throws FileNotFoundException,
			DocumentException {

		DecimalFormat toDesimaler = new DecimalFormat("0.00");
		double totalSum = 0;
		Document document = new Document(PageSize.A4, 36, 72, 108, 180);
		PdfWriter.getInstance(document, new FileOutputStream("Receipt.pdf"));
		ArrayList<Product> products = order.getProductsInOrder();
		Customer customer = order.getCustomer();

		document.open();

		Chunk chunk = new Chunk(Properties.getName());
		chunk.setUnderline(0.2f, -2f);
		Font font = new Font();
		font.setSize(28);
		chunk.setFont(font);
		Paragraph paragraph = new Paragraph("               ");
		paragraph.add(chunk);

		document.add(paragraph);
		document.add(new Paragraph("               Tlf: "
				+ Properties.getPhone() + "   Addresse: "
				+ Properties.getAddress() + " " + Properties.getZipCode() + " "
				+ Properties.getPostalAddress()));
		document.add(new Paragraph("               Dato: "
				+ showTime("dd.MM.yyyy") + "             Tid: "
				+ showTime("HH:mm" + "\n\n")));

		PdfPTable table = new PdfPTable(4);
		table.addCell("Vare:");
		table.addCell("Pris vare ink MVA:");
		table.addCell("Antall:");
		table.addCell("Sum");

		for (int i = 0; i < products.size(); i++) {
			Product product = products.get(i);
			int quat = product.getQuantity();
			double varePris = product.getPrice();
			double sumLinje = (double) quat * product.getPrice();
			totalSum += sumLinje;
			table.addCell(product.getName());
			table.addCell(toDesimaler.format(varePris));
			int value = product.getQuantity();
			String mid = Integer.toString(value);
			table.addCell(mid);
			table.addCell(toDesimaler.format(sumLinje));
		}

		table.addCell("Total sum");
		table.addCell("");
		table.addCell("");
		table.addCell(toDesimaler.format(totalSum));

		document.add(table);
		document.add(new Paragraph("\n               Kundeinformasjon:"));
		document.add(new Paragraph("              Navn:       "
				+ customer.getForename() + " " + customer.getLastname()
				+ "\n               Telefon:   " + customer.getPhone()
				+ "\n               Adresse:  " + customer.getAddress()
				+ "\n                               " + customer.getzipCode()
				+ " " + customer.getPostalAddress()));

		document.close();

	}

	/**
	 * Finner tid og dato, og returnerer denne som en streng.
	 * 
	 * @param dateFormat
	 * @return
	 */
	private static String showTime(String dateFormat) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(cal.getTime());
	}

}