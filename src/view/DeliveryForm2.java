package view;

import java.awt.Color;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.BorderFactory;
//no.ntnu.course
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.JLabel;

import model.GoogleMaps;
import model.Order;
import model.Product;
import controller.ChefController;
import controller.DeliveryController;

/*
 * DeliveryForm2.java
 *
 * Created on 29.sep.2011, 12:24:07
 */
    /**
 *
 * @author Morten Vaale Noddeland
 */
@SuppressWarnings("serial")
public class DeliveryForm2 extends javax.swing.JFrame {

	private Order order;
    /** Creates new form DeliveryForm2 */
    public DeliveryForm2(Order order) {
        this.order = order;
    	initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     */
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        headerLabel = new javax.swing.JLabel();
        middlePanel = new javax.swing.JPanel();
        rightPanel = new javax.swing.JPanel();
        nameAddressHeaderLabel = new javax.swing.JLabel();
        nameHeaderLabel = new javax.swing.JLabel();
        nameContentLabel = new javax.swing.JLabel();
        addressHeaderLabel = new javax.swing.JLabel();
        addressContentLabel = new javax.swing.JLabel();
        zipCodeContentLabel = new javax.swing.JLabel();
        telephoneHeaderLabel = new javax.swing.JLabel();
        telephoneContentLabel = new javax.swing.JLabel();
        mapHeaderLabel = new javax.swing.JLabel();
        mapPanel = new javax.swing.JPanel();
        leftPanel = new javax.swing.JPanel();
        productsHeadersPanel = new javax.swing.JPanel();
        quantityHeaderLabel = new javax.swing.JLabel();
        productHeaderLabel = new javax.swing.JLabel();
        ProductsScrollPane = new javax.swing.JScrollPane();
        productsPanel = new javax.swing.JPanel();
        quantityPanel = new javax.swing.JPanel();
        productPanel = new javax.swing.JPanel();
        commentPanel = new javax.swing.JPanel();
        commentHeaderLabel = new javax.swing.JLabel();
        commentScrollPane = new javax.swing.JScrollPane();
        commentTextPane = new javax.swing.JTextPane();
        bottomPanel = new javax.swing.JPanel();
        backButton = new javax.swing.JLabel();
        startFinishButton = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kjøkken - oversikt");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setName("newOrderFrame");
        //setPreferredSize(new java.awt.Dimension(800, 620));

        topPanel.setBackground(new java.awt.Color(220, 220, 220));
        topPanel.setPreferredSize(new java.awt.Dimension(780, 100));
        topPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.darkGray));


        headerLabel.setFont(new java.awt.Font("Georgia", 0, 36));
        headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLabel.setText("Utkjøring - detaljer");

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                .addContainerGap())
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(headerLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        middlePanel.setBackground(new java.awt.Color(253, 253, 253));
        middlePanel.setPreferredSize(new java.awt.Dimension(800, 470));

        rightPanel.setBackground(new java.awt.Color(253, 253, 253));

        nameAddressHeaderLabel.setBackground(new java.awt.Color(240, 240, 240));
        nameAddressHeaderLabel.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        nameAddressHeaderLabel.setText("Navn og adresse");
        nameAddressHeaderLabel.setBorder(javax.swing.BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.darkGray), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 5)));
        nameAddressHeaderLabel.setOpaque(true);
        nameAddressHeaderLabel.setPreferredSize(new java.awt.Dimension(800, 40));

        nameHeaderLabel.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        nameHeaderLabel.setText("Navn:");

        addressHeaderLabel.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        addressHeaderLabel.setText("Adresse:");
        
        telephoneHeaderLabel.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        telephoneHeaderLabel.setText("Telefon:");
        
        nameContentLabel.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        addressContentLabel.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        zipCodeContentLabel.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        telephoneContentLabel.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N

        mapHeaderLabel.setBackground(new java.awt.Color(240, 240, 240));
        mapHeaderLabel.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        mapHeaderLabel.setText("Kart");
        mapHeaderLabel.setBorder(javax.swing.BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.darkGray), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 5)));
        mapHeaderLabel.setOpaque(true);
        mapHeaderLabel.setPreferredSize(new java.awt.Dimension(800, 40));

        mapPanel.setBackground(new java.awt.Color(240, 240, 240));
        mapPanel.setPreferredSize(new java.awt.Dimension(329, 329));

        javax.swing.GroupLayout mapPanelLayout = new javax.swing.GroupLayout(mapPanel);
        mapPanel.setLayout(mapPanelLayout);
        mapPanelLayout.setHorizontalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 329, Short.MAX_VALUE)
        );
        mapPanelLayout.setVerticalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nameAddressHeaderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameHeaderLabel)
                    .addComponent(addressHeaderLabel)
                    .addComponent(telephoneHeaderLabel))
                .addGap(23, 23, 23)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(telephoneContentLabel)
                    .addComponent(zipCodeContentLabel)
                    .addComponent(addressContentLabel)
                    .addComponent(nameContentLabel))
                .addContainerGap(108, Short.MAX_VALUE))
            .addComponent(mapHeaderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mapPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addComponent(nameAddressHeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameContentLabel)
                    .addComponent(nameHeaderLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressContentLabel)
                    .addComponent(addressHeaderLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(zipCodeContentLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telephoneContentLabel)
                    .addComponent(telephoneHeaderLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mapHeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mapPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addContainerGap())
        );
        
        quantityHeaderLabel.setBackground(new java.awt.Color(240, 240, 240));
        quantityHeaderLabel.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        quantityHeaderLabel.setText("Antall");
        quantityHeaderLabel.setBorder(javax.swing.BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.darkGray), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 5)));
        quantityHeaderLabel.setOpaque(true);
        quantityHeaderLabel.setPreferredSize(new java.awt.Dimension(800, 40));

        productHeaderLabel.setBackground(new java.awt.Color(240, 240, 240));
        productHeaderLabel.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        productHeaderLabel.setText("Produkt");
        productHeaderLabel.setBorder(javax.swing.BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.darkGray), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 5)));
        productHeaderLabel.setOpaque(true);
        productHeaderLabel.setPreferredSize(new java.awt.Dimension(800, 40));

        javax.swing.GroupLayout productsHeadersPanelLayout = new javax.swing.GroupLayout(productsHeadersPanel);
        productsHeadersPanel.setLayout(productsHeadersPanelLayout);
        productsHeadersPanelLayout.setHorizontalGroup(
            productsHeadersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productsHeadersPanelLayout.createSequentialGroup()
                .addComponent(quantityHeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(productHeaderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
        );
        productsHeadersPanelLayout.setVerticalGroup(
            productsHeadersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productsHeadersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(quantityHeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(productHeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ProductsScrollPane.setBorder(null);
        ProductsScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ProductsScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        ProductsScrollPane.setPreferredSize(new java.awt.Dimension(800, 240));
        ProductsScrollPane.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.darkGray));


        productsPanel.setBackground(new java.awt.Color(253, 253, 253));
        productsPanel.setPreferredSize(new java.awt.Dimension(795, 250));

        quantityPanel.setBackground(new java.awt.Color(253, 253, 253));
        quantityPanel.setPreferredSize(new java.awt.Dimension(80, 302));

        
        productPanel.setBackground(new java.awt.Color(253, 253, 253));
        productPanel.setPreferredSize(new java.awt.Dimension(300, 302));

        // Fetch all information that's relevant and display it
        displayOrder();


        javax.swing.GroupLayout productsPanelLayout = new javax.swing.GroupLayout(productsPanel);
        productsPanel.setLayout(productsPanelLayout);
        productsPanelLayout.setHorizontalGroup(
            productsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productsPanelLayout.createSequentialGroup()
                .addComponent(quantityPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(productPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                )
        );
        productsPanelLayout.setVerticalGroup(
            productsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productsPanelLayout.createSequentialGroup()
                .addGroup(productsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(quantityPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                    .addComponent(productPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        ProductsScrollPane.setViewportView(productsPanel);

        commentPanel.setBackground(new java.awt.Color(253, 253, 253));
        commentPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.darkGray));


        commentHeaderLabel.setBackground(new java.awt.Color(240, 240, 240));
        commentHeaderLabel.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        commentHeaderLabel.setText("Kommentar");
        commentHeaderLabel.setBorder(javax.swing.BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.darkGray), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 5)));
        commentHeaderLabel.setOpaque(true);
        commentHeaderLabel.setPreferredSize(new java.awt.Dimension(800, 40));

        commentScrollPane.setBorder(null);

        commentTextPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        commentTextPane.setEditable(false);
        commentScrollPane.setViewportView(commentTextPane);

        javax.swing.GroupLayout commentPanelLayout = new javax.swing.GroupLayout(commentPanel);
        commentPanel.setLayout(commentPanelLayout);
        commentPanelLayout.setHorizontalGroup(
            commentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(commentScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
            .addComponent(commentHeaderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
        );
        commentPanelLayout.setVerticalGroup(
            commentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commentPanelLayout.createSequentialGroup()
                .addComponent(commentHeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(commentScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(productsHeadersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ProductsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
            .addComponent(commentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addComponent(productsHeadersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(ProductsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addComponent(commentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout middlePanelLayout = new javax.swing.GroupLayout(middlePanel);
        middlePanel.setLayout(middlePanelLayout);
        middlePanelLayout.setHorizontalGroup(
            middlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(middlePanelLayout.createSequentialGroup()
                .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        middlePanelLayout.setVerticalGroup(
            middlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rightPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bottomPanel.setBackground(new java.awt.Color(220, 220, 220));
        bottomPanel.setPreferredSize(new java.awt.Dimension(800, 100));
        bottomPanel.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.darkGray));


        backButton.setBackground(new java.awt.Color(235, 210, 210));
        backButton.setFont(new java.awt.Font("Georgia", 0, 18));
        backButton.setForeground(new java.awt.Color(115, 35, 35));
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/leftred_32.png"))); // NOI18N
        backButton.setText(" Tilbake");
        backButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(205, 135, 135), 2), javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        backButton.setOpaque(true);
        backButton.setPreferredSize(new java.awt.Dimension(140, 50));
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
        });

        startFinishButton.setBackground(new java.awt.Color(245, 245, 215));
        startFinishButton.setFont(new java.awt.Font("Georgia", 0, 18));
        startFinishButton.setForeground(new java.awt.Color(100, 70, 20));
        startFinishButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/label_32.png"))); // NOI18N
        startFinishButton.setText(" Start");
        startFinishButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(235, 210, 155), 2), javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        startFinishButton.setOpaque(true);
        startFinishButton.setPreferredSize(new java.awt.Dimension(140, 20));
        startFinishButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateButtonMouseClicked(evt);
            }
        });

        priceLabel.setFont(new java.awt.Font("Georgia", 0, 30)); // NOI18N
        priceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(priceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startFinishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startFinishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(bottomPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(topPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                    .addComponent(middlePanel, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        ));
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(middlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(bottomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
        ));

        pack();
    }

    private void displayOrder() {
    	ArrayList<ArrayList<JLabel>> labels = createProductLabels();
    	
    	defineQuantityPanel(labels.get(0));
    	defineProductPanel(labels.get(1));
    	
    	commentTextPane.setText("Jeg kan endres dynamisk i displayOrder-metoden");
    	nameContentLabel.setText("Morten Vaale Noddeland");
        addressContentLabel.setText("Arne Bergsgårdsvei 5-11");
        zipCodeContentLabel.setText("7033 TRONDHEIM");
        telephoneContentLabel.setText("91833835");
        priceLabel.setText("399.00,-");
        
        //displayMap("Arne Bergsgårdsvei 5-11");
    	
    }

	private ArrayList<ArrayList<JLabel>> createProductLabels() {
    	//TODO Get the hashmap with data in a different way
    	ArrayList<Product> productsInOrder = order.getProductsInOrder();
        HashMap<Product, Integer> products = orders.get(0);
		Set set = products.entrySet();
        Iterator it = set.iterator();

        
        ArrayList <javax.swing.JLabel> quantityLabels = new ArrayList <javax.swing.JLabel>();
        ArrayList <javax.swing.JLabel> productLabels = new ArrayList <javax.swing.JLabel>();

        int i = 0;
        while (it.hasNext()){
        	Map.Entry me = (Map.Entry)it.next();
        	// Create quantityLabels
        	javax.swing.JLabel quantityLabel = new javax.swing.JLabel();
        	quantityLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        	quantityLabel.setOpaque(true);
        	quantityLabel.setVisible(true);
        	int bg;
			if (i % 2 == 0) { bg = 200; }
	        else 			{ bg = 220; }
			i++;
			quantityLabel.setBackground(new java.awt.Color(bg, bg, bg));
			//quantityLabel.setFont(new java.awt.Font("Georgia", 0, 14));
	        quantityLabel.setText("" + me.getValue());
	        quantityLabels.add(quantityLabel);
	        
	        // Create productLabels
        	javax.swing.JLabel productLabel = new javax.swing.JLabel();
        	productLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        	productLabel.setOpaque(true);
        	productLabel.setVisible(true);
			productLabel.setBackground(new java.awt.Color(bg, bg, bg));
			//productLabel.setFont(new java.awt.Font("Georgia", 0, 14));
			productLabel.setText("" + me.getKey());
	        productLabels.add(productLabel);
			
        }
        ArrayList<ArrayList <javax.swing.JLabel>> labels= new ArrayList<ArrayList <javax.swing.JLabel>>();
        labels.add(quantityLabels);
        labels.add(productLabels);
        return labels;
	}

	private void defineQuantityPanel(ArrayList<JLabel> quantityLabels) {
		javax.swing.GroupLayout quantityPanelLayout = new javax.swing.GroupLayout(quantityPanel);
        quantityPanel.setLayout(quantityPanelLayout);
        
        javax.swing.GroupLayout.ParallelGroup tempHorizontalGroup = quantityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);        
        for (int i = 0; i < quantityLabels.size(); i++){
        	tempHorizontalGroup.addComponent(quantityLabels.get(i), javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE);
        }
        
        javax.swing.GroupLayout.SequentialGroup tempVerticalGroup = quantityPanelLayout.createSequentialGroup();
        for (int i = 0; i < quantityLabels.size(); i++){
        	tempVerticalGroup.addComponent(quantityLabels.get(i));
        }
        
        quantityPanelLayout.setHorizontalGroup(tempHorizontalGroup);
        quantityPanelLayout.setVerticalGroup(
            quantityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tempVerticalGroup)
        );
	}
    
    private void defineProductPanel(ArrayList<JLabel> productLabels) {
    	javax.swing.GroupLayout productPanelLayout = new javax.swing.GroupLayout(productPanel);
        productPanel.setLayout(productPanelLayout);
        
        javax.swing.GroupLayout.ParallelGroup tempHorizontalGroup = productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);        
        for (int i = 0; i < productLabels.size(); i++){
        	tempHorizontalGroup.addComponent(productLabels.get(i), javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE);
        }
        
        javax.swing.GroupLayout.SequentialGroup tempVerticalGroup = productPanelLayout.createSequentialGroup();
        for (int i = 0; i < productLabels.size(); i++){
        	tempVerticalGroup.addComponent(productLabels.get(i));
        }
        
        productPanelLayout.setHorizontalGroup(tempHorizontalGroup);
        productPanelLayout.setVerticalGroup(
            productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tempVerticalGroup)
        );
	}

	private void displayMap(String address){
    	JLabel map;
		try {
			map = GoogleMaps.map(address);
	    	
			javax.swing.GroupLayout mapPanelLayout = new javax.swing.GroupLayout(mapPanel);
	        mapPanel.removeAll();
	        mapPanel.setLayout(mapPanelLayout);
	        mapPanelLayout.setHorizontalGroup(
	            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(map, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
	        );
	        mapPanelLayout.setVerticalGroup(
	            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(map, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
	        );
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {                                        
    	DeliveryForm1 form = new DeliveryForm1();
    	form.setVisible(true);
    	this.setVisible(false);
    }                                       

    private void UpdateButtonMouseClicked(java.awt.event.MouseEvent evt) {                                          
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DeliveryForm2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeliveryForm2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeliveryForm2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeliveryForm2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new DeliveryForm2().setVisible(true);  
            }
        });
    }
    // Variables declaration - do not modify
    private javax.swing.JScrollPane ProductsScrollPane;
    private javax.swing.JLabel addressContentLabel;
    private javax.swing.JLabel addressHeaderLabel;
    private javax.swing.JLabel backButton;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JLabel commentHeaderLabel;
    private javax.swing.JPanel commentPanel;
    private javax.swing.JScrollPane commentScrollPane;
    private javax.swing.JTextPane commentTextPane;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JLabel mapHeaderLabel;
    private javax.swing.JPanel mapPanel;
    private javax.swing.JPanel middlePanel;
    private javax.swing.JLabel nameAddressHeaderLabel;
    private javax.swing.JLabel nameContentLabel;
    private javax.swing.JLabel nameHeaderLabel;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel productHeaderLabel;
    private javax.swing.JPanel productPanel;
    private javax.swing.JPanel productsHeadersPanel;
    private javax.swing.JPanel productsPanel;
    private javax.swing.JLabel quantityHeaderLabel;
    private javax.swing.JPanel quantityPanel;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JLabel startFinishButton;
    private javax.swing.JLabel telephoneContentLabel;
    private javax.swing.JLabel telephoneHeaderLabel;
    private javax.swing.JPanel topPanel;
    private javax.swing.JLabel zipCodeContentLabel;
    // End of variables declaration
}
