package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import controller.ManageOrder;
import model.Customer;

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
public class NewOrderForm extends javax.swing.JFrame {

    /** Creates new form NewOrderForm */
    public NewOrderForm() {
        initComponents();
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
        backButton = new javax.swing.JButton();
        sendButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ny ordre");

        topPanel.setBackground(new java.awt.Color(120, 120, 120));
        topPanel.setPreferredSize(new java.awt.Dimension(800, 100));

        newOrderLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        newOrderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        newOrderLabel.setText("Ny ordre");

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(newOrderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addGap(252, 252, 252))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newOrderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        leftPanel.setBackground(new java.awt.Color(238, 238, 238));
        leftPanel.setPreferredSize(new java.awt.Dimension(400, 400));

        searchField.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        searchField.setText("S�k");
        searchField.setActionCommand("<Not Set>");
        searchField.setAlignmentX(0.0F);
        searchField.setAlignmentY(0.0F);
        searchField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(120, 120, 120), 2), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 10)));
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchFieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftPanelLayout.createSequentialGroup()
                //.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(350, Short.MAX_VALUE))
        );

        rightPanel.setBackground(new java.awt.Color(238, 233, 238));
        rightPanel.setPreferredSize(new java.awt.Dimension(400, 400));

        firstNameLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        firstNameLabel.setText("Fornavn");

        lastNameLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lastNameLabel.setText("Etternavn");

        addressLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        addressLabel.setText("Adresse");

        zipCodeLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        zipCodeLabel.setText("Postnummer");

        postalAddressLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        postalAddressLabel.setText("Poststed");

        phoneNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        phoneNumberLabel.setText("Telefon");

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addressLabel)
                    .addComponent(phoneNumberField, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                    .addComponent(lastNameLabel)
                    .addComponent(phoneNumberLabel)
                    .addComponent(firstNameLabel)
                    .addComponent(firstNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                    .addComponent(lastNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                    .addComponent(addressField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                    .addGroup(rightPanelLayout.createSequentialGroup()
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
                .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lastNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addressLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zipCodeLabel)
                    .addComponent(postalAddressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zipCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(postalAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(phoneNumberLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        bottomPanel.setBackground(new java.awt.Color(120, 120, 120));
        bottomPanel.setPreferredSize(new java.awt.Dimension(800, 100));

        backButton.setText("Tilbake");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        sendButton.setText("Neste");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 596, Short.MAX_VALUE)
                .addComponent(sendButton)
                .addContainerGap())
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(sendButton))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 394/*javax.swing.GroupLayout.DEFAULT_SIZE*/, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bottomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                //.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        ));
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bottomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           

        MainMenuForm form2 = new MainMenuForm();         
        this.setVisible(false);         
        form2.setVisible(true);     
        }                                          

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
    	String firstName = firstNameField.getText();
    	String lastName = lastNameField.getText();
    	String phone = phoneNumberField.getText();
    	String address = addressField.getText();
    	String zipCode = zipCodeField.getText();
    	String postalAddress = postalAddressField.getText();
        NewOrder2Form form2 = new NewOrder2Form(ManageOrder.addNewCustomer(firstName, 
        										lastName, phone, address, zipCode, postalAddress));         
        this.setVisible(false);         
        form2.setVisible(true);     
    }                                          

    private void searchFieldKeyTyped(java.awt.event.KeyEvent evt) {
    	this.updateLeftPanel(ManageOrder.getRelevantCustomers(this.searchField.getText()));
    }
    
    public void updateLeftPanel(ArrayList<Customer> customers) {
    	// Creates a JLabel array
    	ArrayList<javax.swing.JLabel> customerList = new ArrayList<javax.swing.JLabel>();
        
        // While there are more elements in the hashmap
        for (int i=0; i < customers.size(); i++) {
        	final Customer customer = customers.get(i); 
        	// Create a new JLabel
        	javax.swing.JLabel temp = new javax.swing.JLabel();
            // Set JLabel dimensions, text, border and so on
        	final String name = customers.get(i).getForename() + " " + customers.get(i).getLastname();
            temp.setText(name);
            temp.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
            temp.setOpaque(true);
            temp.setPreferredSize(new java.awt.Dimension(140, 20));
            temp.setSize(new java.awt.Dimension(140, 20));
            temp.setVisible(true);
        	// Make it so that every other JLabel has a different background color than the previous
            int bg;
    		if (i % 2 == 0){
            	bg = 200;
            }
            else {
            	bg = 220;
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
            i++;
    	}
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
            java.util.logging.Logger.getLogger(NewOrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewOrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewOrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewOrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

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
    private javax.swing.JButton backButton;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JPanel topPanel;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JLabel newOrderLabel;
    private javax.swing.JTextField phoneNumberField;
    private javax.swing.JLabel phoneNumberLabel;
    private javax.swing.JTextField postalAddressField;
    private javax.swing.JLabel postalAddressLabel;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton sendButton;
    private javax.swing.JTextField zipCodeField;
    private javax.swing.JLabel zipCodeLabel;
    // End of variables declaration
}
