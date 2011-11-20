package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import model.Customer;
import model.DeliveryFee;
import model.Order;
import model.Product;
import controller.ManageOrder;
import controller.Validate;

//no.ntnu.course

/*
* NewOrder2Form.java
*
* Created on 29.sep.2011, 12:24:07
*/
/**
*
* @author Morten Vaale Noddeland
*/
@SuppressWarnings("serial")
public class NewOrder2Form extends javax.swing.JFrame {

private Order order;
private Customer customer;
    /** Creates new form NewOrder2Form */
    public NewOrder2Form(Customer c) {
        ManageOrder.addCustomerToDatabase(c);
        this.customer = c;
        this.order = new Order(c);
        initComponents();
        this.updateRightPanel();
        this.updateLeftPanel(ManageOrder.getRelevantProducts(""));
    }
    
    public NewOrder2Form(Customer c, Order o) {
        ManageOrder.addCustomerToDatabase(c);
        this.customer = c;
        this.order = o;
        initComponents();
        this.updateRightPanel();
        this.updateLeftPanel(ManageOrder.getRelevantProducts(""));
    }
    
    
    /** This method is called from within the constructor to
* initialize the form.
*/
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        headerLabel = new javax.swing.JLabel();
        leftPanel = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        rightPanel = new javax.swing.JPanel();
        bottomPanel = new javax.swing.JPanel();
        priceLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JLabel();
        finishButton = new javax.swing.JLabel();
        takeawayButton = new javax.swing.JLabel();
        allergyButton = new javax.swing.JLabel();
        commentPane = new javax.swing.JPanel();
        commentScrollPane = new javax.swing.JScrollPane();
        commentArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ny ordre - produkter");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setName("newOrderFrame");
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        topPanel.setBackground(new java.awt.Color(220, 220, 220));
        topPanel.setPreferredSize(new java.awt.Dimension(780, 100));
        topPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.darkGray));

        headerLabel.setFont(new java.awt.Font("Georgia", 0, 36)); // NOI18N
        headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLabel.setText("Ny ordre - produkter");

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(headerLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        leftPanel.setBackground(new java.awt.Color(253, 253, 253));
        leftPanel.setPreferredSize(new java.awt.Dimension(400, 370));

        searchField.setFont(new java.awt.Font("Lucida Grande", 0, 18));
        searchField.setText("Søk");
        searchField.setActionCommand("<Not Set>");
        searchField.setAlignmentX(0.0F);
        searchField.setAlignmentY(0.0F);
        searchField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, Color.darkGray), javax.swing.BorderFactory.createEmptyBorder(10,10,10,10)));
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyTyped(evt);
            }
        });
        searchField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchFieldMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(320, Short.MAX_VALUE))
        );

        rightPanel.setBackground(new java.awt.Color(253, 253, 253));
        rightPanel.setPreferredSize(new java.awt.Dimension(400, 370));
        rightPanel.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 0, Color.darkGray));


        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        bottomPanel.setBackground(new java.awt.Color(220, 220, 220));
        bottomPanel.setPreferredSize(new java.awt.Dimension(800, 100));
        bottomPanel.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.darkGray));


        priceLabel.setFont(new java.awt.Font("Georgia", 0, 30));
        priceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        priceLabel.setText("");

        backButton.setBackground(new java.awt.Color(235, 207, 207));
        backButton.setFont(new java.awt.Font("Georgia", 0, 18));
        backButton.setForeground(new java.awt.Color(113, 36, 36));
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/leftred_32.png"))); // NOI18N
        backButton.setText(" Tilbake");
        backButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(203, 135, 135), 2), javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        backButton.setOpaque(true);
        backButton.setPreferredSize(new java.awt.Dimension(140, 20));
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
        });

        finishButton.setBackground(new java.awt.Color(230, 240, 200));
        finishButton.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        finishButton.setForeground(new java.awt.Color(64, 80, 25));
        finishButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/buy_32.png"))); // NOI18N
        finishButton.setText(" Fullfør");
        finishButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(180, 190, 130), 2), javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        finishButton.setOpaque(true);
        finishButton.setPreferredSize(new java.awt.Dimension(140, 20));
        finishButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                finishButtonMouseClicked(evt);
            }
        });

        if (order.getDelivery()){
        	takeawayButton.setIcon(new ImageIcon("src/icons/tick_32.png"));
        }
        else {
        	takeawayButton.setIcon(new ImageIcon("src/icons/delete_32.png"));
        }
        takeawayButton.setBackground(new java.awt.Color(225, 230, 235));
        takeawayButton.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        takeawayButton.setForeground(new java.awt.Color(44, 65, 105));
        takeawayButton.setText(" Kjøres");
        takeawayButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(170, 180, 200), 2), javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        takeawayButton.setOpaque(true);
        takeawayButton.setPreferredSize(new java.awt.Dimension(140, 20));
        takeawayButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                takeawayButtonMouseClicked(evt);
            }
        });

        if (order.getAllergy()){
        	allergyButton.setIcon(new ImageIcon("src/icons/tick_32.png"));
        }
        else {
        	allergyButton.setIcon(new ImageIcon("src/icons/delete_32.png"));
        }
        allergyButton.setBackground(new java.awt.Color(225, 230, 235));
        allergyButton.setForeground(new java.awt.Color(44, 65, 105));
        allergyButton.setText(" Allergi");
        allergyButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(170, 180, 200), 2), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        allergyButton.setFont(new Font("Georgia", 0, 18));
        allergyButton.setOpaque(true);
        allergyButton.setPreferredSize(new Dimension(140, 20));
        allergyButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                allergyButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(takeawayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(allergyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(finishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(priceLabel)
                        .addComponent(takeawayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(allergyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(finishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        commentPane.setBackground(new java.awt.Color(253, 253, 253));
        commentPane.setPreferredSize(new java.awt.Dimension(800, 80));
        commentPane.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.darkGray));

        commentScrollPane.setBorder(null);
        
        commentArea.setColumns(20);
        commentArea.setLineWrap(true);
        commentArea.setRows(3);
        commentArea.setText("");
        commentArea.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        commentScrollPane.setViewportView(commentArea);
        commentArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                commentFieldMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout commentPaneLayout = new javax.swing.GroupLayout(commentPane);
        commentPane.setLayout(commentPaneLayout);
        commentPaneLayout.setHorizontalGroup(
            commentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(commentScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        commentPaneLayout.setVerticalGroup(
            commentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(commentScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(commentPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bottomPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                 .addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(commentPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(bottomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }
/**
* Takes in a hashmap with product names and prices, packs them in
* a clickable JLabel, and shows them on screen
* @param products
*/
    public void updateLeftPanel(ArrayList<Product> products) {
     // Creates a JLabel array
     ArrayList<javax.swing.JLabel> productList = new ArrayList<javax.swing.JLabel>();
     for (int i=0; i<products.size(); i++){
         // Create a new JLabel
         javax.swing.JLabel temp = new javax.swing.JLabel();
            // Set JLabel dimensions, text, border and so on
         final Product product = products.get(i);
            temp.setText(product.getName() + " " + product.formatPrice());
            temp.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
            temp.setOpaque(true);
            temp.setPreferredSize(new java.awt.Dimension(140, 20));
            temp.setSize(new java.awt.Dimension(140, 20));
            temp.setVisible(true);
         // Make it so that every other JLabel has a different background color than the previous
            int bg;
     if (i % 2 == 0){
             bg = 220;
            }
            else {
             bg = 240;
            }
     temp.setBackground(new java.awt.Color(bg, bg, bg));
     // What method to call if the JLabel is clicked
            temp.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    productLabelMouseClicked(evt, product);
                }
            });
            // Add the JLabel to the array of JLabels
            productList.add(temp);
     }
        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.removeAll();
        leftPanel.setLayout(leftPanelLayout);
        
        javax.swing.GroupLayout.ParallelGroup tempGroup = leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
        tempGroup.addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE);
        for(int i = 0; i < productList.size(); i++) {
         tempGroup.addComponent(productList.get(i), org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE);
        }
        tempGroup.addGroup(leftPanelLayout.createSequentialGroup()
            .addGap(79, 79, 79)
        );
        
        leftPanelLayout.setHorizontalGroup(
leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(leftPanelLayout.createSequentialGroup()
.addGroup(tempGroup)
.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
)
        );
        
        javax.swing.GroupLayout.SequentialGroup verticalTempGroup = leftPanelLayout.createSequentialGroup();
verticalTempGroup.addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE);
for(int i = 0; i < productList.size(); i++) {
verticalTempGroup.addComponent(productList.get(i), org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 46, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE);
}
verticalTempGroup.addGap(86, 86, 86);
verticalTempGroup.addContainerGap(235, Short.MAX_VALUE);
      
leftPanelLayout.setVerticalGroup(
leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(verticalTempGroup)
);
pack();
searchField.grabFocus();
searchField.setText(searchField.getText());
    }
    
    public void updateRightPanel() {
        // Set JLabel dimensions, text, border and so on
     this.rightPanel.setBackground(Color.WHITE);
     ArrayList<javax.swing.JLabel> orderList = new ArrayList<javax.swing.JLabel>();
        ArrayList<Product> productsInOrder = ManageOrder.getProductsInOrder(order);
        priceLabel.setText(ManageOrder.formatPrice(ManageOrder.getTotalPrice(order)));
        int counter = 0;
        for (Product p : productsInOrder) {
         // Create a new JLabel
         javax.swing.JLabel temp = new javax.swing.JLabel();

     final Product product = p;
     temp.setText(product.getQuantity() + " stk " + product.getName() + " " +
     ManageOrder.formatPrice(product.getPrice()*product.getQuantity()));
     temp.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
     temp.setOpaque(true);
     temp.setPreferredSize(new java.awt.Dimension(140, 20));
     temp.setSize(new java.awt.Dimension(140, 20));
     int bg;
     if (counter % 2 == 0){
     bg = 220;
     }
     else {
     bg = 240;
     }
     temp.setBackground(new java.awt.Color(bg, bg, bg));
     temp.setVisible(true);
    
     // What method to call if the JLabel is clicked
     temp.addMouseListener(new java.awt.event.MouseAdapter() {
     public void mouseClicked(java.awt.event.MouseEvent evt) {
     orderLabelMouseClicked(evt, product);
     }
     });
     orderList.add(temp);
     counter++;
        }
        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.removeAll();
        rightPanel.setLayout(rightPanelLayout);
        
        // Creates the Horizontal Parallel Group containing all the JLabels
        javax.swing.GroupLayout.ParallelGroup tempHorizontalGroup = rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
        tempHorizontalGroup.addGap(0, 400, Short.MAX_VALUE);
        for(int i = 0; i < orderList.size(); i++) {
         tempHorizontalGroup.addComponent(orderList.get(i), org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE);
        }
        // Creates the Vertical Parallel Group containing all the JLabels
        javax.swing.GroupLayout.SequentialGroup tempVerticalGroup = rightPanelLayout.createSequentialGroup();
        //tempVerticalGroup.addGap(0, 387, Short.MAX_VALUE);
        for(int i = 0; i < orderList.size(); i++) {
         tempVerticalGroup.addComponent(orderList.get(i), org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 46, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE);
        }
        
        // Puts the groups created earlier into the right place in the rightPanelLayout
        rightPanelLayout.setHorizontalGroup(tempHorizontalGroup);
        rightPanelLayout.setVerticalGroup(tempVerticalGroup);
    }
    
    boolean searchFieldChanged;
    private void searchFieldKeyTyped(java.awt.event.KeyEvent evt) {
     if (!this.searchFieldChanged) {
    	 this.searchField.setText("" + (this.searchField.getText()).charAt(3));
    	 this.searchFieldChanged = true;
     }
        this.updateLeftPanel(ManageOrder.getRelevantProducts(this.searchField.getText()));
    }
    
    private void searchFieldMouseClicked(java.awt.event.MouseEvent evt){
    	this.searchFieldChanged = true;
    	this.searchField.setText("");
    	this.updateLeftPanel(ManageOrder.getRelevantProducts(this.searchField.getText()));
    }
    
    private void commentFieldMouseClicked(java.awt.event.MouseEvent evt){
     this.commentArea.setText("");
    }

    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {
     NewOrderForm form = new NewOrderForm(customer, order);
        form.setVisible(true);
        this.setVisible(false);
    }

    private void finishButtonMouseClicked(java.awt.event.MouseEvent evt) {
	    Color color = new Color(235, 210, 210);
	    order.setStatus("Bestilt");
	    boolean legalOrder = true;
	    
	    if (!Validate.isStringLegal(this.commentArea.getText())){
	    	this.commentArea.setBackground(color);
	    	legalOrder = false;
	     	}
	    else if (order.getAllergy() && this.commentArea.getText().equals("")){
	    	this.commentArea.setBackground(color);
	    	legalOrder = false;
	    }
	    else{
	    	this.commentArea.setBackground(Color.WHITE);
	    }
	    if (ManageOrder.getProductsInOrder(order).size()<1 && (ManageOrder.getProductsInOrder(order).get(0) instanceof DeliveryFee)){
	    	this.rightPanel.setBackground(color);
	    	legalOrder = false;
	    }
	    if (ManageOrder.getProductsInOrder(order).size()==1 && (ManageOrder.getProductsInOrder(order).get(0) instanceof DeliveryFee)){
	    	this.rightPanel.setBackground(color);
	    	legalOrder = false;
	    }
	    
	    if (legalOrder){
		    order.setComment(this.commentArea.getText());
			ManageOrder.submitOrderToDatabase(order);
			MainMenuForm form = new MainMenuForm();
			form.setVisible(true);
			this.setVisible(false);
	     }
    }

    private void productLabelMouseClicked(java.awt.event.MouseEvent evt, Product product) {
     ManageOrder.addOneMoreProductToOrder(order, product);
     this.updateRightPanel();
    }
    
    private void orderLabelMouseClicked(java.awt.event.MouseEvent evt, Product product) {
     ManageOrder.removeOneProductFromOrder(order, product);
     this.updateRightPanel();
   this.updateRightPanel();
    }
    
    private void takeawayButtonMouseClicked(java.awt.event.MouseEvent evt) {
     if (order.getDelivery()){
     takeawayButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete_32.png")));
     ManageOrder.setDelivery(order, false);
     this.updateRightPanel();
     }
     else{
     takeawayButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/tick_32.png")));
     ManageOrder.setDelivery(order, true);
     this.updateRightPanel();
     }
    }

    private void allergyButtonMouseClicked(java.awt.event.MouseEvent evt) {
     if (!order.getAllergy()){
     allergyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/tick_32.png")));
     ManageOrder.setAllergy(order, true);
     }
     else{
     allergyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete_32.png")));
     ManageOrder.setAllergy(order, false);
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
            java.util.logging.Logger.getLogger(NewOrder2Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewOrder2Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewOrder2Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewOrder2Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new NewOrder2Form(new Customer("Test", "testet", "676758598", "gate", "7878", "Oslo")).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify
    private javax.swing.JLabel allergyButton;
    private javax.swing.JLabel backButton;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JTextArea commentArea;
    private javax.swing.JPanel commentPane;
    private javax.swing.JScrollPane commentScrollPane;
    private javax.swing.JLabel finishButton;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel takeawayButton;
    private javax.swing.JPanel topPanel;
    // End of variables declaration
}