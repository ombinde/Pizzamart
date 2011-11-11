package view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;

import model.Customer;

import controller.ManageOrder;
import controller.Validate;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewOrderForm.java
 *
 * Created on 26.sep.2011, 10:50:18
 */
/**
 *
 * @author Morten Vaale Noddeland
 */

// TODO Scrolling!
// TODO Search for lastnames
// TODO Display names ot startup
@SuppressWarnings("serial")
public class NewOrderForm extends javax.swing.JFrame {

    /** Creates new form NewOrderForm */
    public NewOrderForm() {
        initComponents();
        this.updateLeftPanel(ManageOrder.getRelevantCustomers(""));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     */
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        newOrderLabel = new javax.swing.JLabel();
        leftPanel = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        rightPanel = new javax.swing.JPanel();
        firstNameLabel = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        lastNameField = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        addressField = new javax.swing.JTextField();
        zipCodeLabel = new javax.swing.JLabel();
        zipCodeField = new javax.swing.JTextField();
        postalAddressField = new javax.swing.JTextField();
        postalAddressLabel = new javax.swing.JLabel();
        phoneNumberLabel = new javax.swing.JLabel();
        phoneNumberField = new javax.swing.JTextField();
        bottomPanel = new javax.swing.JPanel();
        backButton = new javax.swing.JLabel();
        nextButton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ny ordre");
        setPreferredSize(new java.awt.Dimension(800, 600));

        topPanel.setBackground(new java.awt.Color(220, 220, 220));
        topPanel.setPreferredSize(new java.awt.Dimension(800, 100));
        topPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.darkGray));


        newOrderLabel.setFont(new java.awt.Font("Georgia", 0, 36));
        newOrderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        newOrderLabel.setText("Ny ordre");

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(newOrderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addGap(254, 254, 254))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(newOrderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        leftPanel.setBackground(new java.awt.Color(253, 253, 253));
        leftPanel.setPreferredSize(new java.awt.Dimension(400, 400));

        searchField.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        searchField.setText("Søk");
        searchField.setActionCommand("<Not Set>");
        searchField.setAlignmentX(0.0F);
        searchField.setAlignmentY(0.0F);
        //searchField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 100, 100), 2), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 10)));
        searchField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, Color.darkGray), javax.swing.BorderFactory.createEmptyBorder(10,10,10,10)));
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
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
            .addGroup(leftPanelLayout.createSequentialGroup()
                //.addContainerGap()
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(420, Short.MAX_VALUE))
        );

        rightPanel.setBackground(new java.awt.Color(253, 253, 253));
        rightPanel.setPreferredSize(new java.awt.Dimension(400, 400));
        rightPanel.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 0, Color.darkGray));


        firstNameLabel.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        firstNameLabel.setText("Fornavn");

        firstNameField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 100, 100)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 5)));

        lastNameLabel.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        lastNameLabel.setText("Etternavn");

        lastNameField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 100, 100)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 5)));

        addressLabel.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        addressLabel.setText("Adresse");

        addressField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 100, 100)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 5)));

        zipCodeLabel.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        zipCodeLabel.setText("Postnummer");

        zipCodeField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 100, 100)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 5)));

        postalAddressField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 100, 100)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 5)));

        postalAddressLabel.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        postalAddressLabel.setText("Poststed");

        phoneNumberLabel.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        phoneNumberLabel.setText("Telefon");

        phoneNumberField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 100, 100)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 5)));

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(firstNameField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                    .addComponent(addressLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phoneNumberField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                    .addComponent(lastNameLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phoneNumberLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(firstNameLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lastNameField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                    .addComponent(addressField, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, rightPanelLayout.createSequentialGroup()
                        .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(zipCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(zipCodeLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(postalAddressLabel)
                            .addComponent(postalAddressField, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))))
                .addContainerGap())
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(firstNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addressLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zipCodeLabel)
                    .addComponent(postalAddressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zipCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(postalAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(phoneNumberLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        bottomPanel.setBackground(new java.awt.Color(220, 220, 220));
        bottomPanel.setPreferredSize(new java.awt.Dimension(800, 100));
        bottomPanel.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.darkGray));


        backButton.setBackground(new java.awt.Color(235, 207, 207));
        backButton.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        backButton.setForeground(new java.awt.Color(113, 36, 36));
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/leftred_32.png"))); // NOI18N
        backButton.setText(" Tilbake");
        backButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(203, 135, 135), 2), javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        backButton.setOpaque(true);
        backButton.setPreferredSize(new java.awt.Dimension(140, 20));
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // Conflict: ActionPerformed vs MouseClicked!
            	backButtonMouseClicked(evt);
            }
        });

        nextButton.setBackground(new java.awt.Color(230, 240, 200));
        nextButton.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        nextButton.setForeground(new java.awt.Color(64, 80, 25));
        nextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/right_32.png"))); // NOI18N
        nextButton.setText(" Neste");
        nextButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(180, 190, 130), 2), javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        nextButton.setOpaque(true);
        nextButton.setPreferredSize(new java.awt.Dimension(140, 20));
        nextButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 500, Short.MAX_VALUE)
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bottomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                		.addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }
    
    private void searchFieldMouseClicked(java.awt.event.MouseEvent evt){
    	this.searchField.setText("");
    	this.updateLeftPanel(ManageOrder.getRelevantCustomers(this.searchField.getText()));
    }

    private void searchFieldKeyTyped(java.awt.event.KeyEvent evt) { 
    	this.updateLeftPanel(ManageOrder.getRelevantCustomers(this.searchField.getText()));
    }                                    

    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {
    	MainMenuForm form = new MainMenuForm();         
    	form.setVisible(true);
        this.setVisible(false);         
    }

    private void nextButtonMouseClicked(java.awt.event.MouseEvent evt) {
    	String firstName = firstNameField.getText();
    	String lastName = lastNameField.getText();
    	String phone = phoneNumberField.getText();
    	String address = addressField.getText();
    	String zipCode = zipCodeField.getText();
    	String postalAddress = postalAddressField.getText();
    	boolean legalCustomer = true;
    	Color color = new Color(200, 30, 30);
    	if (!Validate.stringNonEmpty(firstName) || !Validate.stringLegal(firstName)){
    		this.firstNameField.setBackground(color);
    		legalCustomer = false;
    	}
    	if (!Validate.stringNonEmpty(lastName) || !Validate.stringLegal(lastName)){
    		this.lastNameField.setBackground(color);
    		legalCustomer = false;
    	}
    	if (!Validate.stringNonEmpty(phone) || !Validate.stringOnlyNumb(phone)){
    		this.phoneNumberField.setBackground(color);
    		legalCustomer = false;
    	}
    	if (!Validate.stringOnlyNumb(zipCode)){
    		this.zipCodeField.setBackground(color);
    		legalCustomer = false;
    	}
    	if (!Validate.stringLegal(address)){
    		this.addressField.setBackground(color);
    		legalCustomer = false;
    	}
    	if (!Validate.stringLegal(postalAddress)){
    		this.postalAddressField.setBackground(color);
    		legalCustomer = false;
    	}
    	
    	if (legalCustomer){
	        NewOrder2Form form = new NewOrder2Form(ManageOrder.addNewCustomer(firstName, 
	        										lastName, phone, address, zipCode, postalAddress));         
	        form.setVisible(true);
	        this.setVisible(false);    
    	}
    }
    
    public void updateLeftPanel(ArrayList<Customer> customers) {
    	// Creates a JLabel array
    	ArrayList<javax.swing.JLabel> customerList = new ArrayList<javax.swing.JLabel>();
        
        // While there are more elements in the hashmap
        for (int i=0; i < customers.size(); i++) {
        	// Create a new JLabel
        	javax.swing.JLabel temp = new javax.swing.JLabel();
            // Set JLabel dimensions, text, border and so on
        	final Customer customer = customers.get(i);
            temp.setText(customer.getForename() + " " + customer.getLastname());
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
                    customerLabelMouseClicked(evt, customer);
                }
            });
            // Add the JLabel to the array of JLabels
            customerList.add(temp);
    	}
        // Correct to add local variable of leftPanelLayout?
        GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.removeAll();
        leftPanel.setLayout(leftPanelLayout);
        
        javax.swing.GroupLayout.ParallelGroup tempGroup = leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
        tempGroup.addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE);
        for(int i = 0; i < customerList.size(); i++) {
        	tempGroup.addComponent(customerList.get(i), org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE);
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
		for(int i = 0; i < customerList.size(); i++) {
			verticalTempGroup.addComponent(customerList.get(i), org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 46, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE);
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
    
    private void customerLabelMouseClicked(java.awt.event.MouseEvent evt, Customer c) {   
    	this.updateRightPanel(c);
    }
    public void updateRightPanel(Customer c) {
        // Set JLabel dimensions, text, border and so on
    	firstNameField.setText(c.getForename());
    	lastNameField.setText(c.getLastname());
    	phoneNumberField.setText(c.getPhone());
    	addressField.setText(c.getAddress());
    	zipCodeField.setText(c.getzipCode());
    	postalAddressField.setText(c.getPostalAddress());
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
            java.util.logging.Logger.getLogger(NewOrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewOrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewOrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewOrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new NewOrderForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify
    private javax.swing.JTextField addressField;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel backButton;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JLabel newOrderLabel;
    private javax.swing.JLabel nextButton;
    private javax.swing.JTextField phoneNumberField;
    private javax.swing.JLabel phoneNumberLabel;
    private javax.swing.JTextField postalAddressField;
    private javax.swing.JLabel postalAddressLabel;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JTextField searchField;
    private javax.swing.JPanel topPanel;
    private javax.swing.JTextField zipCodeField;
    private javax.swing.JLabel zipCodeLabel;
    // End of variables declaration
}
