package view;
//no.ntnu.course

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import model.Order;

import controller.ManageOrder;

/**
 *
 * @author Morten Vaale Noddeland
 */
@SuppressWarnings("serial")
public class EditForm1 extends javax.swing.JFrame {

    /** Creates new form PickupForm1 */
    public EditForm1() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     */
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        headerLabel = new javax.swing.JLabel();
        middlePanel = new javax.swing.JPanel();
        middleScrollPane = new javax.swing.JScrollPane();
        innermiddlePanel = new javax.swing.JPanel();
        bottomPanel = new javax.swing.JPanel();
        backButton = new javax.swing.JLabel();
        updateButton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Endre ordre - oversikt");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setName("editFrame");
        setResizable(false);

        topPanel.setBackground(new java.awt.Color(220, 220, 220));
        topPanel.setPreferredSize(new java.awt.Dimension(780, 100));
        topPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.darkGray));

        headerLabel.setFont(new java.awt.Font("Georgia", 0, 36));
        headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLabel.setText("Endre ordre - oversikt");

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

        middlePanel.setBackground(new java.awt.Color(253, 253, 253));
        middlePanel.setPreferredSize(new java.awt.Dimension(400, 370));

        middleScrollPane.setBorder(null);
        middleScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        middleScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        middleScrollPane.setPreferredSize(new java.awt.Dimension(800, 470));

        innermiddlePanel.setBackground(new java.awt.Color(253, 253, 253));
        
        updateMiddlePanel();
        
        middleScrollPane.setViewportView(innermiddlePanel);

        javax.swing.GroupLayout middlePanelLayout = new javax.swing.GroupLayout(middlePanel);
        middlePanel.setLayout(middlePanelLayout);
        middlePanelLayout.setHorizontalGroup(
            middlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(middleScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        middlePanelLayout.setVerticalGroup(
            middlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(middleScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );

        bottomPanel.setBackground(new java.awt.Color(220, 220, 220));
        bottomPanel.setPreferredSize(new java.awt.Dimension(800, 100));
        bottomPanel.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.darkGray));

        backButton = Button.createButton("Tilbake", "red", "leftred");
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
        });
        
        updateButton = Button.createButton("Oppdater", "blue", "clock");
        updateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(505, 505, 505)
                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(middlePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(bottomPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(topPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(middlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                .addComponent(bottomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }

    
    private void updateMiddlePanel(){
    	ArrayList<javax.swing.JLabel> orders = createOrderLabels();
    	
    	defineInnermiddlePanelLayout(orders);
    }
    
    private ArrayList<JLabel> createOrderLabels(){
        ArrayList <javax.swing.JLabel> labels = new ArrayList <javax.swing.JLabel>();
        ArrayList<Order> finishedOrders = ManageOrder.getFinishedOrders();

        for (int i = 0; i < finishedOrders.size(); i++){
        	final Order order = finishedOrders.get(i);
        	
        	ArrayList<JLabel> label = Labels.createTwoLineLabel(order.getDateAndTime() + " " + order.getCustomer().getName(), "Status: " + order.getStatus(), "blue");
        	
        	label.get(0).addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    orderLabelMouseClicked(order);
                }
            });
            label.get(1).addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                	orderLabelMouseClicked(order);
                }
            });

        	labels.add(label.get(0));
        	labels.add(label.get(1));
        }
        return labels;
    }
    
    private void defineInnermiddlePanelLayout(ArrayList<JLabel> orders){
    	javax.swing.GroupLayout innermiddlePanelLayout = new javax.swing.GroupLayout(innermiddlePanel);
    	
    	innermiddlePanel.removeAll();
    	innermiddlePanel.setLayout(innermiddlePanelLayout);
    	
    	javax.swing.GroupLayout.ParallelGroup tempHorizontalGroup = innermiddlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
    	for (int i = 0; i < orders.size(); i++){
        	tempHorizontalGroup.addComponent(orders.get(i), javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE);
        }
        
        javax.swing.GroupLayout.SequentialGroup tempVerticalGroup = innermiddlePanelLayout.createSequentialGroup();
        tempVerticalGroup.addContainerGap();
        for (int i = 0; i < orders.size(); i++){
            tempVerticalGroup.addComponent(orders.get(i), javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE);
            if (i % 2 == 1) {
            	tempVerticalGroup.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
            }
        }
        
        innermiddlePanelLayout.setHorizontalGroup(
        		innermiddlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(innermiddlePanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(tempHorizontalGroup)
                    .addContainerGap())
        );
        
        innermiddlePanelLayout.setVerticalGroup(
            innermiddlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tempVerticalGroup)
        );
    }
    
    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {                                        
    	MainMenuForm form = new MainMenuForm();
    	form.setVisible(true);
    	this.setVisible(false);
    }                                       

    private void UpdateButtonMouseClicked(java.awt.event.MouseEvent evt) {                                          
    	updateMiddlePanel();
    }

    private void orderLabelMouseClicked(Order order) {                                                     
        EditForm2 form = new EditForm2(order);
        form.setVisible(true);
        this.setVisible(false);
    }                                                    


    // Variables declaration
    private javax.swing.JLabel backButton;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JPanel innermiddlePanel;
    private javax.swing.JPanel middlePanel;
    private javax.swing.JScrollPane middleScrollPane;
    private javax.swing.JPanel topPanel;
    private javax.swing.JLabel updateButton;
    // End of variables declaration
}
