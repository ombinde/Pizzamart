package view;
import static javax.swing.GroupLayout.Alignment.BASELINE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Product;
import controller.ChefController;
/**
* @author David og ¯ivind
*/
public class Kitchenform1 extends javax.swing.JFrame {

    /** Creates new form Kitchenform1 */
    public Kitchenform1() {
        initComponents();
    }
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        bottomPanel = new javax.swing.JPanel();
        
        tittel = new javax.swing.JLabel();
        antalletOrdrer = new javax.swing.JLabel();
        
        numbOfOrders = new javax.swing.JLabel();
        delivery1Lable = new javax.swing.JLabel();
        delivery4Lable = new javax.swing.JLabel();
        delivery5Lable = new javax.swing.JLabel();

        backButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
		orderButton = null;
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        //top panel
        //pink: 255-20-147
        topPanel.setBackground(new java.awt.Color(255, 20, 147));
        
        tittel.setFont(new java.awt.Font("Tahoma", 0, 36));
        tittel.setText("Kj¿kken");
        //Spring Green: 0-255-127
        tittel.setBackground(new java.awt.Color(0, 255, 127));
        
        org.jdesktop.layout.GroupLayout topPanelLayout = new org.jdesktop.layout.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(topPanelLayout.createSequentialGroup()
                .add(314, 314, 314)
                .add(tittel)
                .addContainerGap(343, Short.MAX_VALUE))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(topPanelLayout.createSequentialGroup()
                .add(34, 34, 34)
                .add(tittel)
                .addContainerGap(42, Short.MAX_VALUE))
        );//end top panel
        // bottom panel    	
        //Dark Violet: 148-0-211
        bottomPanel.setBackground(new java.awt.Color(148, 0, 211));

        backButton.setText("Tilbake");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	backButtonActionPerformed(evt);
            }
        });

        antalletOrdrer.setFont(new java.awt.Font("Tahoma", 0, 24));
        antalletOrdrer.setText("Antall ordrer:");
        refreshButton.setText("Refresh");
        refreshButton.setFont(new java.awt.Font("Tahoma", 0, 24));
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fetchOrders(evt);
            }
        });

//        numbOfOrders.setFont(new java.awt.Font("Tahoma", 0, 24));
//        numbOfOrders.setText("4");
  
        org.jdesktop.layout.GroupLayout bottomPanelLayout = new org.jdesktop.layout.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(bottomPanelLayout.createSequentialGroup()
                .add(69, 69, 69)
                .add(backButton)
                .add(137, 137, 137)
                .add(refreshButton)
                //.add(antalletOrdrer)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                //.add(numbOfOrders)
                .addContainerGap(335, Short.MAX_VALUE))
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, bottomPanelLayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .add(bottomPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(backButton)
                    .add(refreshButton)

                   // .add(numbOfOrders)
                   // .add(antalletOrdrer)
                    )
                .add(32, 32, 32))
        );//end bottom panel

        
        //start middle panel, which is the main panel that both top-panel and bottom panel sits on top of..
        org.jdesktop.layout.GroupLayout middlePanel = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(middlePanel);
        middlePanel.setAutocreateGaps(true);
        middlePanel.setAutocreateContainerGaps(true);
        addOrdersToPanel();

        
        middlePanel.setHorizontalGroup(
            middlePanel.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(topPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(middlePanel.createSequentialGroup()
                .add(152, 152, 152)
                //.add(order1Lable)
                .add(76, 76, 76)
                .add(delivery1Lable)
                .add(135, 135, 135)
                )
            
            .add(bottomPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(middlePanel.createSequentialGroup()
                .add(152, 152, 152)
                .add(middlePanel.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(middlePanel.createSequentialGroup()
                        //.add(order4Lable)
                        .add(80, 80, 80)
                        .add(delivery4Lable))
                    .add(middlePanel.createSequentialGroup()
                        //.add(order5Lable)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(delivery5Lable)))
                .add(135, 135, 135)
                .add(middlePanel.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                )
                .add(189, 189, 189))
        );
        middlePanel.setVerticalGroup(
            middlePanel.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(middlePanel.createSequentialGroup()
                .add(topPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(72, 72, 72)
                .add(middlePanel.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(middlePanel.createSequentialGroup()
                        .add(5, 5, 5)
                     )
                    .add(middlePanel.createSequentialGroup()
                        .add(5, 5, 5)
                        .add(delivery1Lable))
                    )
                .add(18, 18, 18)
                
                .add(18, 18, 18)
                .add(middlePanel.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    //.add(order4Lable)
                    .add(delivery4Lable)
                    )
                .add(8, 8, 8)
                .add(middlePanel.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(middlePanel.createSequentialGroup()
                        .add(8, 8, 8)
                        .add(middlePanel.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                           // .add(order5Lable)
                            .add(delivery5Lable)))
                    .add(middlePanel.createSequentialGroup()
                        .add(10, 10, 10)
                        ))
                .add(64, 64, 64)
                .add(bottomPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// end middle panel           

    public void addOrdersToPanel(JPanel panel){
    	int antallOrdrer = 3;
    	for(int i=0; i<= antallOrdrer; i++){
    		orderButton = new JButton();
    		orderButton.setText(2 + " " + "Lazio");
    		panel.setHorizontalGroup(panel.createSequentialGroup()
    				.addCompnenent(orderButton)
    		);
            panel.setVerticalGroup(panel.createSequentialGroup()
    				.addCompnenent(orderButton)

            );
    	}
    }
    public static void fetchOrders(java.awt.event.ActionEvent evt){
    	//f¿rst henter vi alle nye ordre.
    	System.out.println("fetchOrders() got called!");
    	ArrayList<HashMap<Product,Integer>> freshOrders = ChefController.getFreshOrders();
    	for (int i = 0; i < freshOrders.size(); i++) {
    		orderButton = new javax.swing.JButton();
    		for (Object o : freshOrders.get(i).keySet()) {
    			if (o instanceof Product){
    			
    				String pname = ((Product) o).getName();
    				int antall = freshOrders.get(i).get(o); 
    	    		//addToMiddlePanel(orderButton.setText(antall + " " + pname));
    	    		orderButton.setText(antall + " " + pname);

    			}
    		}
    		
			
		}
    }
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        MainMenuForm form2 = new MainMenuForm();         
        this.setVisible(false);         
        form2.setVisible(true); 
    }
    	
 
    public static void main(String args[]) {
    	
    	//fetchOrders();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Kitchenform1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kitchenform1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kitchenform1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kitchenform1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kitchenform1().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JButton backButton;
    private javax.swing.JButton refreshButton;
    
    private javax.swing.JButton orderButton;

    private javax.swing.JLabel delivery1Lable;
    private javax.swing.JLabel delivery4Lable;
    private javax.swing.JLabel delivery5Lable;
    private javax.swing.JLabel tittel;
    private javax.swing.JLabel antalletOrdrer;
    private javax.swing.JLabel numbOfOrders;
   
    private javax.swing.JPanel topPanel;
    private javax.swing.JPanel bottomPanel;

    // End of variables declaration                   
}