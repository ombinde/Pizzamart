package view;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
//no.ntnu.course
import javax.swing.JLabel;

import com.itextpdf.text.DocumentException;

import controller.ManageOrder;

import model.Order;
import model.Product;
import model.Receipt;

/*
 * PickupForm2.java
 *
 * Created on 29.sep.2011, 12:24:07
 */
/**
 *
 * @author Morten Vaale Noddeland
 */
@SuppressWarnings("serial")
public class PickupForm2 extends javax.swing.JFrame {

	private Order order;
    /** Creates new form PickupForm2 */
    public PickupForm2(Order order) {
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
        nameTelephoneHeaderLabel = new javax.swing.JLabel();
        nameHeaderLabel = new javax.swing.JLabel();
        nameContentLabel = new javax.swing.JLabel();
        telephoneHeaderLabel = new javax.swing.JLabel();
        telephoneContentLabel = new javax.swing.JLabel();
        commentHeaderLabel = new javax.swing.JLabel();
        commentScrollPane = new javax.swing.JScrollPane();
        commentTextPane = new javax.swing.JTextPane();
        leftPanel = new javax.swing.JPanel();
        productsHeadersPanel = new javax.swing.JPanel();
        quantityHeaderLabel = new javax.swing.JLabel();
        productHeaderLabel = new javax.swing.JLabel();
        ProductsScrollPane = new javax.swing.JScrollPane();
        productsPanel = new javax.swing.JPanel();
        quantityPanel = new javax.swing.JPanel();
        productPanel = new javax.swing.JPanel();
        bottomPanel = new javax.swing.JPanel();
        backButton = new javax.swing.JLabel();
        finishButton = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        receiptButton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hent - detaljer");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setName("newOrderFrame");

        topPanel.setBackground(new java.awt.Color(220, 220, 220));
        topPanel.setPreferredSize(new java.awt.Dimension(780, 100));
        topPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.darkGray));

        headerLabel.setFont(new java.awt.Font("Georgia", 0, 36));
        headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLabel.setText("Hent - detaljer");

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

        nameTelephoneHeaderLabel.setBackground(new java.awt.Color(240, 240, 240));
        nameTelephoneHeaderLabel.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        nameTelephoneHeaderLabel.setText("Navn og telefon");
        nameTelephoneHeaderLabel.setBorder(javax.swing.BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.darkGray), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 5)));
        nameTelephoneHeaderLabel.setOpaque(true);
        nameTelephoneHeaderLabel.setPreferredSize(new java.awt.Dimension(800, 40));

        nameHeaderLabel.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        nameHeaderLabel.setText("Navn:");

        nameContentLabel.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N

        telephoneHeaderLabel.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        telephoneHeaderLabel.setText("Telefon:");

        telephoneContentLabel.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N

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

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nameTelephoneHeaderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameHeaderLabel)
                    .addComponent(telephoneHeaderLabel))
                .addGap(24, 24, 24)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(telephoneContentLabel)
                    .addComponent(nameContentLabel))
                .addContainerGap(108, Short.MAX_VALUE))
            .addComponent(commentHeaderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
            .addComponent(commentScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addComponent(nameTelephoneHeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameContentLabel)
                    .addComponent(nameHeaderLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telephoneHeaderLabel)
                    .addComponent(telephoneContentLabel))
                .addGap(18, 18, 18)
                .addComponent(commentHeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(commentScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE))
        );

        quantityHeaderLabel.setBackground(new java.awt.Color(240, 240, 240));
        quantityHeaderLabel.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        quantityHeaderLabel.setText("Antall");
        quantityHeaderLabel.setBorder(javax.swing.BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.darkGray), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 5)));
        quantityHeaderLabel.setOpaque(true);
        quantityHeaderLabel.setPreferredSize(new java.awt.Dimension(800, 40));

        productHeaderLabel.setBackground(new java.awt.Color(240, 240, 240));
        productHeaderLabel.setFont(new java.awt.Font("Georgia", 0, 18));
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

        quantityPanel.setBackground(new java.awt.Color(253, 253, 253));
        quantityPanel.setPreferredSize(new java.awt.Dimension(80, 302));

        productPanel.setBackground(new java.awt.Color(253, 253, 253));
        productPanel.setPreferredSize(new java.awt.Dimension(300, 302));

        displayOrder();
        
        javax.swing.GroupLayout productsPanelLayout = new javax.swing.GroupLayout(productsPanel);
        productsPanel.setLayout(productsPanelLayout);
        productsPanelLayout.setHorizontalGroup(
            productsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productsPanelLayout.createSequentialGroup()
                .addComponent(quantityPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(productPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(385, Short.MAX_VALUE))
        );
        productsPanelLayout.setVerticalGroup(
            productsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, productsPanelLayout.createSequentialGroup()
                .addGroup(productsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(quantityPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                    .addComponent(productPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE))
                .addContainerGap())
        );

        ProductsScrollPane.setViewportView(productsPanel);

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(productsHeadersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ProductsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addComponent(productsHeadersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(ProductsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE))
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
        backButton.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        backButton.setForeground(new java.awt.Color(115, 35, 35));
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/leftred_32.png"))); // NOI18N
        backButton.setText("Tilbake");
        backButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(205, 135, 135), 2), javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        backButton.setIconTextGap(10);
        backButton.setOpaque(true);
        backButton.setPreferredSize(new java.awt.Dimension(140, 50));
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
        });

        finishButton.setBackground(new java.awt.Color(230, 240, 200));
        finishButton.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        finishButton.setForeground(new java.awt.Color(64, 80, 25));
        finishButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/buy_32.png"))); // NOI18N
        finishButton.setText("Fullfør");
        finishButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(180, 190, 130), 2), javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        finishButton.setIconTextGap(10);
        finishButton.setOpaque(true);
        finishButton.setPreferredSize(new java.awt.Dimension(140, 20));
        finishButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                finishButtonMouseClicked(evt);
            }
        });

        priceLabel.setFont(new java.awt.Font("Georgia", 0, 30)); // NOI18N
        priceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        receiptButton.setBackground(new java.awt.Color(225, 230, 235));
        receiptButton.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        receiptButton.setForeground(new java.awt.Color(45, 65, 105));
        receiptButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/document_32.png"))); // NOI18N
        receiptButton.setText("Kvittering");
        receiptButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(170, 180, 200), 2), javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        receiptButton.setIconTextGap(10);
        receiptButton.setOpaque(true);
        receiptButton.setPreferredSize(new java.awt.Dimension(140, 20));
        receiptButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                receiptButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(priceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(receiptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(finishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(finishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceLabel)
                    .addComponent(receiptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            )
        );

        pack();
    }

    
    private void displayOrder() {
    	ArrayList<ArrayList<JLabel>> labels = createProductLabels();

    	defineQuantityPanel(labels.get(0));
    	defineProductPanel(labels.get(1));
    	
    	commentTextPane.setText(order.getComment());
    	nameContentLabel.setText(order.getCustomer().getName());
        telephoneContentLabel.setText(order.getCustomer().getPhone());
    	priceLabel.setText(ManageOrder.formatPrice(ManageOrder.getTotalPrice(order)));
    }
	private ArrayList<ArrayList<JLabel>> createProductLabels() {
        ArrayList <javax.swing.JLabel> quantityLabels = new ArrayList <javax.swing.JLabel>();
        ArrayList <javax.swing.JLabel> productLabels = new ArrayList <javax.swing.JLabel>();
        
        ArrayList<Product> productsInOrder = order.getProductsInOrder();

        for (int i = 0; i < productsInOrder.size(); i++) {
        	// Create quantityLabels
	    	javax.swing.JLabel quantityLabel = new javax.swing.JLabel();
	    	quantityLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    	quantityLabel.setOpaque(true);
	    	quantityLabel.setVisible(true);
	    	int bg;
			if (i % 2 == 0) { bg = 220; }
	        else 			{ bg = 240; }
			quantityLabel.setBackground(new java.awt.Color(bg, bg, bg));
			//quantityLabel.setFont(new java.awt.Font("Georgia", 0, 14));
	        quantityLabel.setText(""+productsInOrder.get(i).getQuantity());
	        quantityLabels.add(quantityLabel);
	        
	        // Create productLabels
	    	javax.swing.JLabel productLabel = new javax.swing.JLabel();
	    	productLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    	productLabel.setOpaque(true);
	    	productLabel.setVisible(true);
			productLabel.setBackground(new java.awt.Color(bg, bg, bg));
			//productLabel.setFont(new java.awt.Font("Georgia", 0, 14));
			productLabel.setText(productsInOrder.get(i).getName());
	        productLabels.add(productLabel);
	    }
	    ArrayList<ArrayList <javax.swing.JLabel>> labels = new ArrayList<ArrayList <javax.swing.JLabel>>();
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
        	tempHorizontalGroup.addComponent(productLabels.get(i), javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE);
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

	private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {                                        
		PickupForm1 form = new PickupForm1();         
        form.setVisible(true);
        this.setVisible(false);
    }                                       

    private void finishButtonMouseClicked(java.awt.event.MouseEvent evt) {  
    	ManageOrder.setStatusToPickedUp(order);
    	PickupForm1 form = new PickupForm1();         
        form.setVisible(true);
        this.setVisible(false);
    }

    private void receiptButtonMouseClicked(java.awt.event.MouseEvent evt) {
        try {
			Receipt.makeReceipe(order);
			Receipt.openReceipt();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
            java.util.logging.Logger.getLogger(PickupForm2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PickupForm2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PickupForm2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PickupForm2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                //new PickupForm2().setVisible(true);  
            }
        });
    }
    // Variables declaration - do not modify
    private javax.swing.JScrollPane ProductsScrollPane;
    private javax.swing.JLabel backButton;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JLabel commentHeaderLabel;
    private javax.swing.JScrollPane commentScrollPane;
    private javax.swing.JTextPane commentTextPane;
    private javax.swing.JLabel finishButton;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel middlePanel;
    private javax.swing.JLabel nameContentLabel;
    private javax.swing.JLabel nameHeaderLabel;
    private javax.swing.JLabel nameTelephoneHeaderLabel;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel productHeaderLabel;
    private javax.swing.JPanel productPanel;
    private javax.swing.JPanel productsHeadersPanel;
    private javax.swing.JPanel productsPanel;
    private javax.swing.JLabel quantityHeaderLabel;
    private javax.swing.JPanel quantityPanel;
    private javax.swing.JLabel receiptButton;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JLabel telephoneContentLabel;
    private javax.swing.JLabel telephoneHeaderLabel;
    private javax.swing.JPanel topPanel;
    // End of variables declaration
}
