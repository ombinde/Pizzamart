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
	 *pner Receipe.pdf filen. 
	 */
	public static void openReceipt(){
		Desktop desktop = null;
		if(Desktop.isDesktopSupported()){
			desktop = Desktop.getDesktop();
		}
		
		try {
			desktop.open(new File("Receipt.pdf"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void printFile() throws IOException, PrinterException{
		PrintPdf.PrintFile("Receipt.pdf");
	}
	
	/**
	 * lager en .pdf-fil
	 * @throws DocumentException 
	 * @throws FileNotFoundException 
	 */
	public static void makeReceipe(Order order) throws FileNotFoundException, DocumentException{
        
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader bin = new BufferedReader(in);
        DecimalFormat toDesimaler = new DecimalFormat("0.00");
		double totalSum = 0;
        Document document = new Document(PageSize.A4, 36, 72, 108, 180);
        PdfWriter.getInstance(document,new FileOutputStream("Receipt.pdf"));
        ArrayList<Product> products = order.getProductsInOrder();
        Customer customer = order.getCustomer();
        
        document.open();
        
        Chunk chunk = new Chunk(Properties.getName());
        chunk.setUnderline(0.2f, -2f);
        Font font = new Font();
        font.setSize(32);
        chunk.setFont(font);
        Paragraph paragraph = new Paragraph("                                                      ");
        paragraph.add(chunk);
        document.add(paragraph);
        
        document.add(new Paragraph("\n                                              Navn: " + customer.getForename() + " " + customer.getLastname() + "  Tlf: " + 
				customer.getPhone() + "\n                                              Adresse: " + customer.getAddress() + ", " + customer.getzipCode() + " " + customer.getPostalAddress()));
        document.add(new Paragraph("\n________________________________________________________________________\n\n"));
		PdfPTable table=new PdfPTable(4);
		table.addCell("Vare:");
		table.addCell("Pris vare ink MVA:");
		table.addCell("Antall:");
		table.addCell("Sum");
		
		for(int i = 0; i < products.size(); i++) {
			Product product = products.get(i);
			int quat = product.getQuantity();
			double varePris = product.getPrice()*1.14;
			double sumLinje = (double)quat * product.getPrice()*1.14;
			totalSum += sumLinje;
			table.addCell(product.getName());
			table.addCell(toDesimaler.format(varePris));
			double value = product.getQuantity();
			String mid = Double.toString(value);
			table.addCell(mid);
			table.addCell(toDesimaler.format(sumLinje));
		}
		
//		table.addCell("Utkj¿ring");
//		table.addCell("");
//		table.addCell("");
//		table.addCell(Double.toString(utkjoring));
		
		table.addCell("TotalSum");
		table.addCell("");
		table.addCell("");
		table.addCell(toDesimaler.format(totalSum));
		
		document.add(table);
		document.add(new Paragraph("\n\nDato: " + showTime("dd.MM.yyyy") + "             Tid: " + showTime("HH:mm")));

        document.close();
		 
	}
	
	/**
	 * Finner tid og dato, og returnerer denne som en streng.
	 * @param dateFormat
	 * @return
	 */
	private static String showTime(String dateFormat){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(cal.getTime());
	}

}