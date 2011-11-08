package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import controller.ChefController;

import model.Product;

/*
 * NewOrderForm.java
 *
 * Created on 26.sep.2011, 10:50:18
 */
/**
 *
 * @author Morten Vaale Noddeland
 */
@SuppressWarnings("serial")
public class Kitchenform2 extends javax.swing.JFrame {

    /** Creates new form NewOrderForm */
    public Kitchenform2() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is


     */
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        headerLabel = new javax.swing.JLabel();
        middlePanel = new javax.swing.JPanel();
        quantityPanel = new javax.swing.JPanel();
        quantityHeaderLabel = new javax.swing.JLabel();
        productPanel = new javax.swing.JPanel();
        productHeaderLabel = new javax.swing.JLabel();
        commentPanel = new javax.swing.JPanel();
        commentHeaderLabel = new javax.swing.JLabel();
        commentLabel = new javax.swing.JLabel();
        bottomPanel = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        startFinishButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kj¿kken");
        setName("KitchenForm2");
        setResizable(false);

        topPanel.setBackground(new java.awt.Color(150, 150, 150));
        topPanel.setPreferredSize(new java.awt.Dimension(800, 100));

        headerLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLabel.setText("Kj¿kken - detaljer");

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                .addContainerGap())
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(headerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        //------------------------------------------------------------
        middlePanel.setPreferredSize(new java.awt.Dimension(400, 400));
        ArrayList<HashMap<Product, Integer>> orders = ChefController.getFreshOrders();
        //TODO Get the hashmap with data in a different way
        HashMap<Product, Integer> products = orders.get(0);
        
        //TODO Fix bug that displays the products in random order
        setQuantityPanel(products);
        setProductPanel(products);
        setCommentPanel();
        
        javax.swing.GroupLayout middlePanelLayout = new javax.swing.GroupLayout(middlePanel);
        middlePanel.setLayout(middlePanelLayout);
        middlePanelLayout.setHorizontalGroup(
            middlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(middlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(middlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(middlePanelLayout.createSequentialGroup()
                    	.addComponent(quantityPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    	.addComponent(productPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(commentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        middlePanelLayout.setVerticalGroup(
            middlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(middlePanelLayout.createSequentialGroup()
                .addGroup(middlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(productPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(quantityPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(commentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        //------------------------------------------------------------
        bottomPanel.setBackground(new java.awt.Color(150, 150, 150));
        bottomPanel.setPreferredSize(new java.awt.Dimension(800, 100));
        bottomPanel.setRequestFocusEnabled(false);

        backButton.setText("Tilbake");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        startFinishButton.setText("Start");
        startFinishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startFinishButtonActionPerformed(evt);
            }
        });
        
        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 601, Short.MAX_VALUE)
                .addComponent(startFinishButton)
                .addContainerGap())
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(startFinishButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    	.addComponent(middlePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                    	.addComponent(bottomPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        ));
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(middlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }
    
    private void setQuantityPanel(HashMap<Product, Integer> products){
        quantityPanel.setBackground(new java.awt.Color(238, 238, 238));

        quantityHeaderLabel.setBackground(new java.awt.Color(150, 150, 150));
        quantityHeaderLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 15));
        quantityHeaderLabel.setText("Antall:");
        quantityHeaderLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 4, 2, 2));
        quantityHeaderLabel.setOpaque(true);
        
        ArrayList <javax.swing.JLabel> productLabels = new ArrayList <javax.swing.JLabel>();
		Iterator<Integer> it = products.values().iterator();
		int i = 0;
		while (it.hasNext()){
			// Create a JLabel and define dimensions and other variables
			javax.swing.JLabel temp = new javax.swing.JLabel();
			temp.setText("" + it.next());
	        temp.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 10, 4, 2));
	        temp.setOpaque(true);
	        //temp.setPreferredSize(new java.awt.Dimension(140, 20));
	        //temp.setSize(new java.awt.Dimension(140, 20));
	        temp.setVisible(true);
			// Set JLabel background color
	        int bg;
			if (i % 2 == 0) { bg = 200; }
	        else 			{ bg = 220; }
	        temp.setBackground(new java.awt.Color(bg, bg, bg));
	        // Set what should happen when the label is clicked
	        i++;
	        // Add JLabel to the arrayList of orders
	        productLabels.add(temp);
		}
		
        javax.swing.GroupLayout quantityPanelLayout = new javax.swing.GroupLayout(quantityPanel);
        quantityPanel.setLayout(quantityPanelLayout);
        
        javax.swing.GroupLayout.ParallelGroup tempHorizontalGroup = quantityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);        
        tempHorizontalGroup.addComponent(quantityHeaderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
        for (i = 0; i < productLabels.size(); i++){
        	tempHorizontalGroup.addComponent(productLabels.get(i), javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE);
        }
        
        javax.swing.GroupLayout.SequentialGroup tempVerticalGroup = quantityPanelLayout.createSequentialGroup();
        tempVerticalGroup.addComponent(quantityHeaderLabel);
        for (i = 0; i < productLabels.size(); i++){
        	tempVerticalGroup.addComponent(productLabels.get(i));
        }
        tempVerticalGroup.addContainerGap(236, Short.MAX_VALUE);
        
        quantityPanelLayout.setHorizontalGroup(tempHorizontalGroup);
        quantityPanelLayout.setVerticalGroup(
            quantityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tempVerticalGroup)
        );
    }
    
    private void setProductPanel(HashMap<Product, Integer> products){
    	productPanel.setBackground(new java.awt.Color(238, 238, 238));

        productHeaderLabel.setBackground(new java.awt.Color(150, 150, 150));
        productHeaderLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 15));
        productHeaderLabel.setText("Produkt:");
        productHeaderLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 4, 2, 2));
        productHeaderLabel.setOpaque(true);
        
        ArrayList <javax.swing.JLabel> productLabels = new ArrayList <javax.swing.JLabel>();
		int i = 0;
        for (Object o : products.keySet()) {
        	String productName = "";
			if (o instanceof Product){
		        productName = ((Product) o).getName();
			}
			System.out.println(productName);
			// Create a JLabel and define dimensions and other variables
			javax.swing.JLabel temp = new javax.swing.JLabel();
			temp.setText(productName);
	        temp.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 10, 4, 2));
	        temp.setOpaque(true);
	        //temp.setPreferredSize(new java.awt.Dimension(140, 20));
	        //temp.setSize(new java.awt.Dimension(140, 20));
	        temp.setVisible(true);
			// Set JLabel background color
	        int bg;
			if (i % 2 == 0) { bg = 200; }
	        else 			{ bg = 220; }
	        temp.setBackground(new java.awt.Color(bg, bg, bg));
	        // Set what should happen when the label is clicked
	        i++;
	        // Add JLabel to the arrayList of orders
	        productLabels.add(temp);
		}
        
        javax.swing.GroupLayout productPanelLayout = new javax.swing.GroupLayout(productPanel);
        productPanel.setLayout(productPanelLayout);
        
        javax.swing.GroupLayout.ParallelGroup tempHorizontalGroup = productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);        
        tempHorizontalGroup.addComponent(productHeaderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE);
        for (i = 0; i < productLabels.size(); i++){
        	tempHorizontalGroup.addComponent(productLabels.get(i), javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE);
        }
        
        javax.swing.GroupLayout.SequentialGroup tempVerticalGroup = productPanelLayout.createSequentialGroup();
        tempVerticalGroup.addComponent(productHeaderLabel);
        for (i = 0; i < productLabels.size(); i++){
        	tempVerticalGroup.addComponent(productLabels.get(i));
        }
        tempVerticalGroup.addContainerGap(236, Short.MAX_VALUE);
        
        
        productPanelLayout.setHorizontalGroup(tempHorizontalGroup);
        productPanelLayout.setVerticalGroup(
            productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tempVerticalGroup)
        );

    }

    private void setCommentPanel() {
    	
    	
    	commentPanel.setBackground(new java.awt.Color(200, 200, 200));

        commentHeaderLabel.setBackground(new java.awt.Color(150, 150, 150));
        commentHeaderLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 15));
        commentHeaderLabel.setText("Kommentar:");
        commentHeaderLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 4, 2, 2));
        commentHeaderLabel.setOpaque(true);

        commentLabel.setText("jLabel8");

        javax.swing.GroupLayout commentPanelLayout = new javax.swing.GroupLayout(commentPanel);
        commentPanel.setLayout(commentPanelLayout);
        commentPanelLayout.setHorizontalGroup(
            commentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(commentHeaderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
            .addGroup(commentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(commentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                .addContainerGap())
        );
        commentPanelLayout.setVerticalGroup(
            commentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commentPanelLayout.createSequentialGroup()
                .addComponent(commentHeaderLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(commentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }
    
    private void startFinishButtonActionPerformed(java.awt.event.ActionEvent evt) {
        //TODO Let the controller handle this?
    	MainMenuForm form = new MainMenuForm();
    	form.setVisible(true);
        this.setVisible(false);
    }
    
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        //TODO Let the controller handle this?
    	Kitchenform1 form = new Kitchenform1();
    	form.setVisible(true);
        this.setVisible(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(Kitchenform2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kitchenform2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kitchenform2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kitchenform2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Kitchenform2().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify
    private javax.swing.JButton backButton;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JLabel commentHeaderLabel;
    private javax.swing.JLabel commentLabel;
    private javax.swing.JPanel commentPanel;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JButton startFinishButton;
    private javax.swing.JPanel middlePanel;
    private javax.swing.JLabel productHeaderLabel;
    private javax.swing.JPanel productPanel;
    private javax.swing.JLabel quantityHeaderLabel;
    private javax.swing.JPanel quantityPanel;
    private javax.swing.JPanel topPanel;
    // End of variables declaration
}
