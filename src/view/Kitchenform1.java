package view;

import java.util.ArrayList;
import java.util.HashMap;

import model.Product;

import controller.ChefController;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * KitchenForm1.java
 *
 * Created on 26.sep.2011, 10:50:18
 */
/**
 *
 * @author Morten Vaale Noddeland
 */
@SuppressWarnings("serial")
public class KitchenForm1 extends javax.swing.JFrame {

    /** Creates new form NewOrderForm */
    public KitchenForm1() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     */
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        middlePanel = new javax.swing.JPanel();
        bottomPanel = new javax.swing.JPanel();
        headerLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kj¿kken");
        setPreferredSize(new java.awt.Dimension(800, 600));

        topPanel.setBackground(new java.awt.Color(120, 120, 120));
        topPanel.setPreferredSize(new java.awt.Dimension(800, 100));

        headerLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLabel.setText("Ny ordre");

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(headerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addGap(252, 252, 252))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        middlePanel.setBackground(new java.awt.Color(238, 238, 238));
        middlePanel.setPreferredSize(new java.awt.Dimension(400, 400));

        
        // Displays all orders that should
        updateMiddlePanel();

        bottomPanel.setBackground(new java.awt.Color(120, 120, 120));
        bottomPanel.setPreferredSize(new java.awt.Dimension(800, 100));

        backButton.setText("Tilbake");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Oppdater");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 574, Short.MAX_VALUE)
                .addComponent(updateButton)
                .addContainerGap())
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bottomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(middlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(middlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bottomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }

    private void updateMiddlePanel(){
    	ArrayList<javax.swing.JLabel> orders = new ArrayList<javax.swing.JLabel>();
    	
    	// "DETTE BURDE EGENTLIG GJ¯RES AV FETCHORDERS"
    	ArrayList<HashMap<Product,Integer>> freshOrders = ChefController.getFreshOrders();
    	for (int i = 0; i < freshOrders.size(); i++) {
    		//orderButton = new javax.swing.JButton();
    		for (Object o : freshOrders.get(i).keySet()) {
    			if (o instanceof Product){
    				// Set JLabel text
    				System.out.println(o);
    		    	// Create a JLabel and define dimensions and other variables
    				javax.swing.JLabel temp = new javax.swing.JLabel();
    		        temp.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
    		        temp.setOpaque(true);
    		        temp.setPreferredSize(new java.awt.Dimension(140, 20));
    		        temp.setSize(new java.awt.Dimension(140, 20));
    		        temp.setVisible(true);
    		        // Set what should happen when the label is clicked
    		        temp.addMouseListener(new java.awt.event.MouseAdapter() {
    		            public void mouseClicked(java.awt.event.MouseEvent evt) {
    		                System.out.println("Order clicked");
    		            }
    		        });
    		        // Set text for the JLabel
    				String pname = ((Product) o).getName();
    				int antall = freshOrders.get(i).get(o);
    				temp.setText(pname + antall);
    				// Set JLabel background color
    		        int bg;
    				if (i % 2 == 0) { bg = 200; }
    		        else 			{ bg = 220; }
    		        temp.setBackground(new java.awt.Color(bg, bg, bg));
    		        orders.add(temp);
    			}
    		}
		}
    	System.out.println(orders.size());
    	// SLUTT P "DETTE BURDE EGENTLIG GJ¯RES AV FETCHORDERS"
    	
        javax.swing.GroupLayout middlePanelLayout = new javax.swing.GroupLayout(middlePanel);
        middlePanel.removeAll();
        middlePanel.setLayout(middlePanelLayout);
        
        // Create the horizontal group
        javax.swing.GroupLayout.ParallelGroup tempHorizontalGroup = middlePanelLayout.createParallelGroup();
        for (int i = 0; i < orders.size(); i++){
        	tempHorizontalGroup.addComponent(orders.get(i), javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE);
        }
        
        middlePanelLayout.setHorizontalGroup(
            middlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(middlePanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(tempHorizontalGroup)
                    .addContainerGap())
        );
        
        // Create the vertical group
        javax.swing.GroupLayout.SequentialGroup tempVerticalGroup = middlePanelLayout.createSequentialGroup();
        tempVerticalGroup.addContainerGap();
        for (int i = 0; i < orders.size(); i++){
        	tempVerticalGroup.addComponent(orders.get(i), javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE);
        }
        tempVerticalGroup.addContainerGap(330, Short.MAX_VALUE);
        
        middlePanelLayout.setVerticalGroup(
            middlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tempVerticalGroup)
        );
    }
    
    public static void fetchOrders(){
    	//f¿rst henter vi alle nye ordre.
    	//System.out.println("fetchOrders() got called!");
    	ArrayList<HashMap<Product,Integer>> freshOrders = ChefController.getFreshOrders();
    	for (int i = 0; i < freshOrders.size(); i++) {
    		//orderButton = new javax.swing.JButton();
    		for (Object o : freshOrders.get(i).keySet()) {
    			if (o instanceof Product){
    			
    				String pname = ((Product) o).getName();
    				int antall = freshOrders.get(i).get(o);
    				System.out.println(pname);
    				System.out.println(antall);
    	    		//addToMiddlePanel(orderButton.setText(antall + " " + pname));
    	    		//orderButton.setText(antall + " " + pname);
    			}
    		}
		}
    }
    
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        MainMenuForm form2 = new MainMenuForm();
        this.setVisible(false);
        form2.setVisible(true);
    }

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.updateMiddlePanel();
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
            java.util.logging.Logger.getLogger(KitchenForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KitchenForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KitchenForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KitchenForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new KitchenForm1().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify
    private javax.swing.JPanel topPanel;
    private javax.swing.JPanel middlePanel;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JButton backButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration
}
