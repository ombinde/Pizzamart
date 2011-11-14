package Class;

import java.awt.Desktop;
import java.awt.PrintJob;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import java.io.*;
//import java.awt.*;
import java.io.*;
import java.util.zip.*;

import javax.print.Doc;
import javax.print.DocPrintJob;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Receipt {
	
	File fil = new File("Receipt.txt");
	
	public static void main(String[] args){
		Receipt kvitering = new Receipt();
		Product produckt1 = new Product("pizza", 100.00);
		Product product2 = new Product("Pepperoni", 200.00);
		HashMap<Product, Integer> productsInOrder = new HashMap<Product, Integer>();
		productsInOrder.put(produckt1, 1);
		productsInOrder.put(product2, 1);
		
		Customer customer = new Customer("david","Storjord","40842728","elgseter gate 33", "7030");
		 
		try {
			kvitering.makeReceipe(productsInOrder, customer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		try {
			kvitering.printFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PrinterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		kvitering.openReceipt();
		
	}
	
	
	
	
	/**
	 *똯ner Receipe.doc filen. 
	 */
	public void openReceipt(){
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
	
	public void printFile() throws IOException, PrinterException{
		PrintPdf.PrintFile("Receipt.pdf");
	}
	
	/**
	 * lager en .pdf fi
	 * @throws DocumentException 
	 * @throws FileNotFoundException 
	 */
	private void makeReceipe(HashMap productsInOrder, Customer customer) throws FileNotFoundException, DocumentException{
        
        InputStreamReader in= new InputStreamReader(System.in);
        BufferedReader bin= new BufferedReader(in);
        String text = "";
        DecimalFormat toDesimaler = new DecimalFormat("0.00");
		double totalSum = 0;
		double utkj퓊ing = 0;
		Set set = productsInOrder.entrySet();
		Iterator i = set.iterator();
        Document document = new Document(PageSize.A4, 36, 72, 108, 180);
        PdfWriter.getInstance(document,new FileOutputStream("Receipt.pdf"));
        
        document.open();
        
        Chunk chunk = new Chunk(" Napoli ");
        chunk.setUnderline(0.2f, -2f);
        Font font = new Font();
        font.setSize(32);
        chunk.setFont(font);
        Paragraph paragraph = new Paragraph("                                                      ");
        paragraph.add(chunk);
        document.add(paragraph);
        
        document.add(new Paragraph("\n                                              Navn: " + customer.getForename() + " " + customer.getLastname() + "  Tlf: " + 
				customer.getPhone() + "\n                                              Adresse: " + customer.getAdress() + ", " + customer.getPostcode() + " "));
        document.add(new Paragraph("\n________________________________________________________________________\n\n"));
//		document.add(new Paragraph("                Vare:                       Pris for vare ink MVA:               Antall:            Sum:"));
		PdfPTable table=new PdfPTable(4);
		table.addCell("Vare:");
		table.addCell("Pris vare ink MVA:");
		table.addCell("Antall:");
		table.addCell("Sum");
		int vareNavnLengde = 0;
		
		while (i.hasNext()) {
			Map.Entry me = (Map.Entry)i.next();
			Product product = (Product) me.getKey();
			int middlertidig = (Integer) me.getValue();
			double varePris = product.getPrice()*1.14;
			double sumLinje = (double)middlertidig * product.getPrice()*1.14;
			totalSum += sumLinje;
			table.addCell(product.getName());
			table.addCell(toDesimaler.format(varePris));
			int value = (Integer) me.getValue();
			String mid = Integer.toString(value);
			table.addCell(mid);
			table.addCell(toDesimaler.format(sumLinje));
		}
		
		if(totalSum < 700)
			utkj퓊ing = 70;
		
		totalSum += utkj퓊ing;
		
		table.addCell("Utkj퓊ing");
		table.addCell("");
		table.addCell("");
		table.addCell(Double.toString(utkj퓊ing));
		
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
	private String showTime(String dateFormat){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(cal.getTime());
	}

}
