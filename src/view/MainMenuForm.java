package view;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;

import model.Properties;

/**
 * This class is used to display the Main Menu of the program.
 */
@SuppressWarnings("serial")
public class MainMenuForm extends javax.swing.JFrame {

	/** Creates new form MainMenuForm */
	public MainMenuForm() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * Most components that are displayed in the program are initialized here.
	 * That means that settings, such as color, font and so on, are set here.
	 */
	private void initComponents() {

		topPanel = new javax.swing.JPanel();
		headerLabel = new javax.swing.JLabel();
		mainPanel = new javax.swing.JPanel();
		adminButton = new javax.swing.JLabel();
		historyButton = new javax.swing.JLabel();
		editButton = new javax.swing.JLabel();
		newOrderButton = new javax.swing.JLabel();
		deliveryButton = new javax.swing.JLabel();
		kitchenButton = new javax.swing.JLabel();
		pickupButton = new javax.swing.JLabel();
		quitButton = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		Properties.getProperties();
		setTitle("Hovedmeny - " + Properties.getName());
		setBackground(new java.awt.Color(253, 253, 253));
		setPreferredSize(new java.awt.Dimension(800, 600));

		topPanel.setBackground(new java.awt.Color(220, 220, 220));
		topPanel.setPreferredSize(new java.awt.Dimension(800, 100));
		topPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,
				Color.darkGray));

		headerLabel.setFont(new java.awt.Font("Georgia", 0, 36));
		headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		headerLabel.setText("Hovedmeny");

		javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(
				topPanel);
		topPanel.setLayout(topPanelLayout);
		topPanelLayout.setHorizontalGroup(topPanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				topPanelLayout.createSequentialGroup().addContainerGap()
						.addComponent(headerLabel,
								javax.swing.GroupLayout.DEFAULT_SIZE, 760,
								Short.MAX_VALUE).addContainerGap()));
		topPanelLayout.setVerticalGroup(topPanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				topPanelLayout.createSequentialGroup().addGap(9, 9, 9)
						.addComponent(headerLabel,
								javax.swing.GroupLayout.PREFERRED_SIZE, 39,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		mainPanel.setBackground(new java.awt.Color(253, 253, 253));
		mainPanel.setPreferredSize(new java.awt.Dimension(800, 540));

		adminButton = Button.createButton("Administrer", "blue", "gear");
		adminButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				adminButtonMouseClicked(evt);
			}
		});

		historyButton = Button.createButton("Historikk", "blue", "document");
		historyButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				historyButtonMouseClicked(evt);
			}
		});

		editButton = Button.createButton("Endre ordre", "blue", "warning");
		editButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				editButtonMouseClicked(evt);
			}
		});

		newOrderButton = Button.createButton("Ny ordre", "blue", "buy");
		newOrderButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				newOrderButtonMouseClicked(evt);
			}
		});

		deliveryButton = Button.createButton("Utkjøring", "blue", "home");
		deliveryButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				deliveryButtonMouseClicked(evt);
			}
		});

		kitchenButton = Button.createButton("Kjøkken", "blue", "piggybank");
		kitchenButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				kitchenButtonMouseClicked(evt);
			}
		});

		pickupButton = Button.createButton("Hent", "blue", "bag");
		pickupButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				pickupButtonButtonMouseClicked(evt);
			}
		});
		quitButton = Button.createButton("Avslutt", "red", "block");
		quitButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				quitButtonMouseClicked(evt);
			}
		});

		javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(
				mainPanel);
		mainPanel.setLayout(mainPanelLayout);
		mainPanelLayout
				.setHorizontalGroup(mainPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								mainPanelLayout
										.createSequentialGroup()
										.addContainerGap(217, Short.MAX_VALUE)
										.addGroup(
												mainPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																kitchenButton,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																175,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																newOrderButton,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																175,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																pickupButton,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																175,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												mainPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																deliveryButton,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																175,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																editButton,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																175,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																historyButton,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																175,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(215, 215, 215))
						.addGroup(
								mainPanelLayout
										.createSequentialGroup()
										.addGap(312, 312, 312)
										.addGroup(
												mainPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																adminButton,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																175,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																quitButton,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																175,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(313, Short.MAX_VALUE)));
		mainPanelLayout
				.setVerticalGroup(mainPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								mainPanelLayout
										.createSequentialGroup()
										.addGap(59, 59, 59)
										.addGroup(
												mainPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																mainPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				editButton,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				50,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				deliveryButton,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				50,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				historyButton,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				50,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																mainPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				newOrderButton,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				50,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				kitchenButton,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				50,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				pickupButton,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				50,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												adminButton,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(100, 100, 100)
										.addComponent(
												quitButton,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(215, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																topPanel,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																mainPanel,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addComponent(topPanel,
						javax.swing.GroupLayout.PREFERRED_SIZE, 60,
						javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(
						mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		pack();
	}

	/**
	 * Opens the newOrderForm if the event is triggered
	 * 
	 * @param evt
	 *            MouseEvent
	 */
	private void newOrderButtonMouseClicked(java.awt.event.MouseEvent evt) {
		NewOrderForm1 form = new NewOrderForm1();
		form.setVisible(true);
		this.setVisible(false);
	}

	/**
	 * Opens the editForm if the event is triggered
	 * 
	 * @param evt
	 *            MouseEvent
	 */
	private void editButtonMouseClicked(java.awt.event.MouseEvent evt) {
		EditForm1 form = new EditForm1();
		form.setVisible(true);
		this.setVisible(false);
	}

	/**
	 * Opens the kitchenForm if the event is triggered
	 * 
	 * @param evt
	 *            MouseEvent
	 */
	private void kitchenButtonMouseClicked(java.awt.event.MouseEvent evt) {
		Kitchenform1 form = new Kitchenform1();
		form.setVisible(true);
		this.setVisible(false);
	}

	/**
	 * Opens the deliveryForm if the event is triggered
	 * 
	 * @param evt
	 *            MouseEvent
	 */
	private void deliveryButtonMouseClicked(java.awt.event.MouseEvent evt) {
		DeliveryForm1 form = new DeliveryForm1();
		form.setVisible(true);
		this.setVisible(false);
	}

	/**
	 * Opens the pickupForm if the event is triggered
	 * 
	 * @param evt
	 *            MouseEvent
	 */
	private void pickupButtonButtonMouseClicked(MouseEvent evt) {
		PickupForm1 form = new PickupForm1();
		form.setVisible(true);
		this.setVisible(false);
	}

	/**
	 * Opens the historyForm if the event is triggered
	 * 
	 * @param evt
	 *            MouseEvent
	 */
	private void historyButtonMouseClicked(java.awt.event.MouseEvent evt) {
		HistoryForm1 form = new HistoryForm1();
		form.setVisible(true);
		this.setVisible(false);
	}

	/**
	 * Opens the updateForm if the event is triggered
	 * 
	 * @param evt
	 *            MouseEvent
	 */
	private void adminButtonMouseClicked(java.awt.event.MouseEvent evt) {
		AdminForm form = new AdminForm();
		form.setVisible(true);
		this.setVisible(false);
	}

	/**
	 * Exits the program if the event is triggered
	 * 
	 * @param evt
	 *            MouseEvent
	 */
	private void quitButtonMouseClicked(java.awt.event.MouseEvent evt) {
		System.exit(0);
	}

	// Variables declaration
	private javax.swing.JLabel adminButton;
	private javax.swing.JLabel deliveryButton;
	private javax.swing.JLabel editButton;
	private javax.swing.JLabel headerLabel;
	private javax.swing.JLabel historyButton;
	private javax.swing.JLabel kitchenButton;
	private javax.swing.JPanel mainPanel;
	private javax.swing.JLabel newOrderButton;
	private javax.swing.JLabel pickupButton;
	private javax.swing.JLabel quitButton;
	private javax.swing.JPanel topPanel;
	// End of variables declaration
}
