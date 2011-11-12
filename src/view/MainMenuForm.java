package view;

import java.awt.Color;

import javax.swing.BorderFactory;

/*
 * MainMenuForm.java
 *
 * Created on 26.sep.2011, 10:27:24
 */
/**
 *
 * @author Morten Vaale Noddeland
 */

// TODO Replace "direct links" with controller
// TODO Connect the rest of the pages
// TODO Fix exit button
// TODO Make it so that MainMenuForm preferably the Main class request internet access, so that the prompt doesn't show up

@SuppressWarnings("serial")
public class MainMenuForm extends javax.swing.JFrame {

    /** Creates new form MainMenuForm */
    public MainMenuForm() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     */
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        headerLabel = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        adminButton = new javax.swing.JLabel();
        historyButton = new javax.swing.JLabel();
        editButton = new javax.swing.JLabel();
        newOrderButton = new javax.swing.JLabel();
        driverButton = new javax.swing.JLabel();
        kitchenButton = new javax.swing.JLabel();
        quitButton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hovedmeny - Max Harrys Pizza");
        setBackground(new java.awt.Color(253, 253, 253));
        setPreferredSize(new java.awt.Dimension(800, 600));

        topPanel.setBackground(new java.awt.Color(220, 220, 220));
        topPanel.setPreferredSize(new java.awt.Dimension(800, 100));
        topPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.darkGray));

        headerLabel.setFont(new java.awt.Font("Georgia", 0, 36));
        headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLabel.setText("Hovedmeny");

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
                .addGap(9, 9, 9)
                .addComponent(headerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.setBackground(new java.awt.Color(253, 253, 253));
        mainPanel.setPreferredSize(new java.awt.Dimension(800, 540));

        adminButton.setBackground(new java.awt.Color(229, 226, 235));
        adminButton.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        adminButton.setForeground(new java.awt.Color(45, 65, 105));
        adminButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/gear_32.png"))); // NOI18N
        adminButton.setText("  Administrer");
        adminButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(168, 182, 199), 2), javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        adminButton.setOpaque(true);
        adminButton.setPreferredSize(new java.awt.Dimension(175, 20));
        adminButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminButtonMouseClicked(evt);
            }
        });

        historyButton.setBackground(new java.awt.Color(229, 226, 235));
        historyButton.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        historyButton.setForeground(new java.awt.Color(45, 65, 105));
        historyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/document_32.png"))); // NOI18N
        historyButton.setText("  Historikk");
        historyButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(168, 182, 199), 2), javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        historyButton.setOpaque(true);
        historyButton.setPreferredSize(new java.awt.Dimension(175, 20));
        historyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                historyButtonMouseClicked(evt);
            }
        });

        editButton.setBackground(new java.awt.Color(229, 226, 235));
        editButton.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        editButton.setForeground(new java.awt.Color(45, 65, 105));
        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/warning_32.png"))); // NOI18N
        editButton.setText("  Endre ordre");
        editButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(168, 182, 199), 2), javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        editButton.setOpaque(true);
        editButton.setPreferredSize(new java.awt.Dimension(150, 20));
        editButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editButtonMouseClicked(evt);
            }
        });

        newOrderButton.setBackground(new java.awt.Color(229, 226, 235));
        newOrderButton.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        newOrderButton.setForeground(new java.awt.Color(45, 65, 105));
        newOrderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/buy_32.png"))); // NOI18N
        newOrderButton.setText("  Ny ordre");
        newOrderButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(168, 182, 199), 2), javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        newOrderButton.setOpaque(true);
        newOrderButton.setPreferredSize(new java.awt.Dimension(150, 20));
        newOrderButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newOrderButtonMouseClicked(evt);
            }
        });

        driverButton.setBackground(new java.awt.Color(229, 226, 235));
        driverButton.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        driverButton.setForeground(new java.awt.Color(45, 65, 105));
        driverButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home_32.png"))); // NOI18N
        driverButton.setText("  Utkjøring");
        driverButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(168, 182, 199), 2), javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        driverButton.setOpaque(true);
        driverButton.setPreferredSize(new java.awt.Dimension(150, 20));
        driverButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                driverButtonMouseClicked(evt);
            }
        });

        kitchenButton.setBackground(new java.awt.Color(229, 226, 235));
        kitchenButton.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        kitchenButton.setForeground(new java.awt.Color(45, 65, 105));
        kitchenButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/piggybank_32.png"))); // NOI18N
        kitchenButton.setText("  Kjøkken");
        kitchenButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(168, 182, 199), 2), javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        kitchenButton.setOpaque(true);
        kitchenButton.setPreferredSize(new java.awt.Dimension(150, 20));
        kitchenButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kitchenButtonMouseClicked(evt);
            }
        });

        quitButton.setBackground(new java.awt.Color(235, 207, 207));
        quitButton.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        quitButton.setForeground(new java.awt.Color(113, 36, 36));
        quitButton.setIcon(new javax.swing.ImageIcon("/Users/morten/Downloads/Icon Packs/Basic_set_Png/block_32.png")); // NOI18N
        quitButton.setText("  Avslutt");
        quitButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(203, 135, 135), 2), javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        quitButton.setOpaque(true);
        quitButton.setPreferredSize(new java.awt.Dimension(140, 20));
        quitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quitButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(217, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kitchenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(historyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(driverButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adminButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(215, 215, 215))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(312, 312, 312)
                .addComponent(quitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(313, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(driverButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(adminButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(newOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(kitchenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(historyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addComponent(quitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(215, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void newOrderButtonMouseClicked(java.awt.event.MouseEvent evt) {
        NewOrderForm form = new NewOrderForm();         
        form.setVisible(true);
        this.setVisible(false);         
    }

    private void editButtonMouseClicked(java.awt.event.MouseEvent evt) {
    	EditForm form = new EditForm();         
        form.setVisible(true);
        this.setVisible(false); 
    }

    private void kitchenButtonMouseClicked(java.awt.event.MouseEvent evt) {
    	Kitchenform1 form = new Kitchenform1();         
        form.setVisible(true);
        this.setVisible(false);
    }

    private void driverButtonMouseClicked(java.awt.event.MouseEvent evt) {
    	// TODO
    }

    private void historyButtonMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void adminButtonMouseClicked(java.awt.event.MouseEvent evt) {
    	AdminForm form = new AdminForm();         
        form.setVisible(true);
        this.setVisible(false); 
    }

    private void quitButtonMouseClicked(java.awt.event.MouseEvent evt) {
    	System.exit(0);
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
            java.util.logging.Logger.getLogger(MainMenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainMenuForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify
    private javax.swing.JLabel adminButton;
    private javax.swing.JLabel driverButton;
    private javax.swing.JLabel editButton;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JLabel historyButton;
    private javax.swing.JLabel kitchenButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel newOrderButton;
    private javax.swing.JLabel quitButton;
    private javax.swing.JPanel topPanel;
    // End of variables declaration
}
