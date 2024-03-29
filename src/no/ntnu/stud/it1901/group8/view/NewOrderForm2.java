package no.ntnu.stud.it1901.group8.view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;

import no.ntnu.stud.it1901.group8.controller.ManageOrder;
import no.ntnu.stud.it1901.group8.controller.Validate;
import no.ntnu.stud.it1901.group8.model.Customer;
import no.ntnu.stud.it1901.group8.model.DeliveryFee;
import no.ntnu.stud.it1901.group8.model.Order;
import no.ntnu.stud.it1901.group8.model.Product;


/**
 * This class is used to display the NewOrder2 part of the program.
 */
@SuppressWarnings("serial")
public class NewOrderForm2 extends javax.swing.JFrame {

	private Order order;
	private Customer customer;
	private boolean existingOrder;

	/**
	 * Creates new form of NewOrder2Form. This should be used when starting a
	 * new order. It adds the customer to the database.
	 * 
	 * @param c
	 *            Customer
	 */
	public NewOrderForm2(Customer c) {
		ManageOrder.addCustomerToDatabase(c);
		this.customer = c;
		this.order = new Order(c);
		this.existingOrder = false;
		initComponents();
		this.updateRightPanel();
		this.updateLeftPanel(ManageOrder.getRelevantProducts(""));
	}

	/**
	 * Creates a new NewOrderForm2. This constructor takes in a customer and an
	 * order, and should be used when editing an already existing order.
	 * 
	 * @param c
	 * @param o
	 */
	public NewOrderForm2(Customer c, Order o) {
		ManageOrder.addCustomerToDatabase(c);
		this.customer = c;
		this.order = o;
		this.existingOrder = true;
		initComponents();
		this.updateRightPanel();
		this.updateLeftPanel(ManageOrder.getRelevantProducts(""));
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * Most components that is displayed in the program are initialized here.
	 * That means that settings, such as color, font type and so on, are set
	 * here.
	 */
	private void initComponents() {

		topPanel = new javax.swing.JPanel();
		headerLabel = new javax.swing.JLabel();
		leftPanel = new javax.swing.JPanel();
		searchField = new javax.swing.JTextField();
		leftScrollPane = new javax.swing.JScrollPane();
		innerLeftPanel = new javax.swing.JPanel();
		rightPanel = new javax.swing.JPanel();
		rightScrollPane = new javax.swing.JScrollPane();
		innerRightPanel = new javax.swing.JPanel();
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
		setResizable(false);

		topPanel.setBackground(new java.awt.Color(220, 220, 220));
		topPanel.setPreferredSize(new java.awt.Dimension(780, 100));
		topPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,
				Color.darkGray));

		headerLabel.setFont(new java.awt.Font("Georgia", 0, 36));
		headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		headerLabel.setText("Ny ordre - produkter");

		javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(
				topPanel);
		topPanel.setLayout(topPanelLayout);
		topPanelLayout.setHorizontalGroup(topPanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				topPanelLayout.createSequentialGroup().addContainerGap()
						.addComponent(headerLabel,
								javax.swing.GroupLayout.PREFERRED_SIZE, 760,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		topPanelLayout.setVerticalGroup(topPanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				topPanelLayout.createSequentialGroup().addGap(9, 9, 9)
						.addComponent(headerLabel).addContainerGap(
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		leftPanel.setBackground(new java.awt.Color(253, 253, 253));
		leftPanel.setPreferredSize(new java.awt.Dimension(400, 370));

		searchField.setFont(new java.awt.Font("Lucida Grande", 0, 18));
		searchField.setText("Søk");
		searchField.setActionCommand("<Not Set>");
		searchField.setAlignmentX(0.0F);
		searchField.setAlignmentY(0.0F);
		searchField.setBorder(javax.swing.BorderFactory.createCompoundBorder(
				javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0,
						Color.darkGray), javax.swing.BorderFactory
						.createEmptyBorder(10, 10, 10, 10)));
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

		leftScrollPane.setBorder(null);
		leftScrollPane
				.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		leftScrollPane
				.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		innerLeftPanel.setBackground(new java.awt.Color(253, 253, 253));

		leftScrollPane.setViewportView(innerLeftPanel);

		javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(
				leftPanel);
		leftPanel.setLayout(leftPanelLayout);
		leftPanelLayout.setHorizontalGroup(leftPanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 400,
				javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(
				leftScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400,
				Short.MAX_VALUE));
		leftPanelLayout.setVerticalGroup(leftPanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				leftPanelLayout.createSequentialGroup().addComponent(
						searchField, javax.swing.GroupLayout.PREFERRED_SIZE,
						50, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(leftScrollPane,
								javax.swing.GroupLayout.DEFAULT_SIZE, 312,
								Short.MAX_VALUE)));

		rightPanel.setBackground(new java.awt.Color(253, 253, 253));
		rightPanel.setPreferredSize(new java.awt.Dimension(400, 370));
		rightPanel.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 0,
				Color.darkGray));

		innerRightPanel.setBackground(new java.awt.Color(253, 253, 253));

		rightScrollPane.setBorder(null);
		rightScrollPane
				.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		rightScrollPane
				.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		rightScrollPane.setViewportView(innerRightPanel);

		javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(
				rightPanel);
		rightPanel.setLayout(rightPanelLayout);
		rightPanelLayout.setHorizontalGroup(rightPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(rightScrollPane,
						javax.swing.GroupLayout.DEFAULT_SIZE, 400,
						Short.MAX_VALUE));
		rightPanelLayout.setVerticalGroup(rightPanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				rightScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 370,
				Short.MAX_VALUE));

		bottomPanel.setBackground(new java.awt.Color(220, 220, 220));
		bottomPanel.setPreferredSize(new java.awt.Dimension(800, 100));
		bottomPanel.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0,
				Color.darkGray));

		priceLabel.setFont(new java.awt.Font("Georgia", 0, 30));
		priceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		priceLabel.setText("");

		backButton = Button.createButton("Tilbake", "red", "leftred");
		backButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				backButtonMouseClicked(evt);
			}
		});

		finishButton = Button.createButton("Fullfør", "green", "buy");
		finishButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				finishButtonMouseClicked(evt);
			}
		});

		if (order.getDelivery()) {
			takeawayButton = Button.createButton("Kjøres", "blue", "tick");
		} else {
			takeawayButton = Button.createButton("Kjøres", "blue", "delete");
		}
		takeawayButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				takeawayButtonMouseClicked(evt);
			}
		});

		if (order.getAllergy()) {
			allergyButton = Button.createButton("Allergi", "blue", "tick");
		} else {
			allergyButton = Button.createButton("Allergi", "blue", "delete");
		}
		allergyButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				allergyButtonMouseClicked(evt);
			}
		});

		javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(
				bottomPanel);
		bottomPanel.setLayout(bottomPanelLayout);
		bottomPanelLayout
				.setHorizontalGroup(bottomPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								bottomPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												backButton,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												130,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(28, 28, 28)
										.addComponent(
												takeawayButton,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												130,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												priceLabel,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												168,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												allergyButton,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												130,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(28, 28, 28)
										.addComponent(
												finishButton,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												130,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		bottomPanelLayout
				.setVerticalGroup(bottomPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								bottomPanelLayout
										.createSequentialGroup()
										.addGap(10, 10, 10)
										.addGroup(
												bottomPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																bottomPanelLayout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				backButton,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				50,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				priceLabel)
																		.addComponent(
																				takeawayButton,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				50,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				allergyButton,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				50,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addComponent(
																finishButton,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																50,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		commentPane.setBackground(new java.awt.Color(253, 253, 253));
		commentPane.setPreferredSize(new java.awt.Dimension(800, 80));
		commentPane.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0,
				Color.darkGray));

		commentScrollPane.setBorder(null);

		commentArea.setColumns(20);
		commentArea.setLineWrap(true);
		commentArea.setRows(3);
		if (existingOrder)
			commentArea.setText(order.getComment());
		else
			commentArea.setText("");
		commentArea.setBorder(javax.swing.BorderFactory.createEmptyBorder(10,
				10, 10, 10));
		commentScrollPane.setViewportView(commentArea);
		commentArea.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				commentFieldMouseClicked(evt);
			}
		});

		javax.swing.GroupLayout commentPaneLayout = new javax.swing.GroupLayout(
				commentPane);
		commentPane.setLayout(commentPaneLayout);
		commentPaneLayout.setHorizontalGroup(commentPaneLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(commentScrollPane,
						javax.swing.GroupLayout.PREFERRED_SIZE, 800,
						javax.swing.GroupLayout.PREFERRED_SIZE));
		commentPaneLayout.setVerticalGroup(commentPaneLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(commentScrollPane,
						javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.PREFERRED_SIZE, 80,
						javax.swing.GroupLayout.PREFERRED_SIZE));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								layout
										.createSequentialGroup()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																commentPane,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																bottomPanel,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				false)
																		.addComponent(
																				topPanel,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				800,
																				Short.MAX_VALUE)
																		.addGroup(
																				layout
																						.createSequentialGroup()
																						.addComponent(
																								leftPanel,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								rightPanel,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))))));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addComponent(
												topPanel,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												60,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																rightPanel,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																leftPanel,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(
												commentPane,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(
												bottomPanel,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												70,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		pack();
	}

	/**
	 * Takes in a hashmap with product names and prices, packs them in a
	 * clickable JLabel, and shows them on screen
	 * 
	 * @param products
	 */
	public void updateLeftPanel(ArrayList<Product> products) {
		ArrayList<JLabel> productLabels = createProductLabels(products);

		javax.swing.GroupLayout innerLeftPanelLayout = new javax.swing.GroupLayout(
				innerLeftPanel);
		innerLeftPanel.removeAll();
		innerLeftPanel.setLayout(innerLeftPanelLayout);

		setInnerLeftPanelLayout(innerLeftPanelLayout, productLabels);

		pack();
		searchField.grabFocus();
		searchField.setText(searchField.getText());
	}

	private ArrayList<JLabel> createProductLabels(ArrayList<Product> products) {
		ArrayList<javax.swing.JLabel> productLabels = new ArrayList<javax.swing.JLabel>();
		for (int i = 0; i < products.size(); i++) {
			javax.swing.JLabel label = new javax.swing.JLabel();
			final Product product = products.get(i);
			String text = product.getName() + " " + product.formatPrice();

			label = Labels.createBorderlessLabel(text, i);
			label.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent evt) {
					productLabelMouseClicked(evt, product);
				}
			});
			// Add the JLabel to the array of JLabels
			productLabels.add(label);
		}
		return productLabels;
	}

	/**
	 * Takes a list in of JLabels containing products and , and displays them in
	 * the innerLeftPanelLayout.
	 * 
	 * @param innerLeftPanelLayout
	 * @param productLabels
	 */
	private void setInnerLeftPanelLayout(GroupLayout innerLeftPanelLayout,
			ArrayList<JLabel> productLabels) {
		// Set the horizontal axis
		javax.swing.GroupLayout.ParallelGroup horizontalTempGroup = innerLeftPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
		for (int i = 0; i < productLabels.size(); i++) {
			horizontalTempGroup.addComponent(productLabels.get(i),
					org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 360,
					Short.MAX_VALUE);
		}

		innerLeftPanelLayout.setHorizontalGroup(innerLeftPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						innerLeftPanelLayout.createSequentialGroup().addGroup(
								horizontalTempGroup)));

		// Set the vertical axis
		javax.swing.GroupLayout.SequentialGroup verticalTempGroup = innerLeftPanelLayout
				.createSequentialGroup();
		for (int i = 0; i < productLabels.size(); i++) {
			verticalTempGroup.addComponent(productLabels.get(i),
					org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 46,
					org.jdesktop.layout.GroupLayout.PREFERRED_SIZE);
		}

		innerLeftPanelLayout.setVerticalGroup(innerLeftPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(verticalTempGroup));
	}

	/**
	 * Updates the right panel, including creating the product labels, sets the
	 * inner right panel layout and sets the total price.
	 */
	public void updateRightPanel() {
		this.rightPanel.setBackground(Color.WHITE);

		ArrayList<javax.swing.JLabel> productsInOrderLabels = createProductsInOrderLabels();

		javax.swing.GroupLayout innerRightPanelLayout = new javax.swing.GroupLayout(
				innerRightPanel);
		innerRightPanel.removeAll();
		innerRightPanel.setLayout(innerRightPanelLayout);

		setInnerRightPanelLayout(innerRightPanelLayout, productsInOrderLabels);

		priceLabel.setText(ManageOrder.formatPrice(ManageOrder
				.getTotalPrice(order)));
	}

	/**
	 * This method is used to create a list of product JLabels. It takes an
	 * ArrayList of Product objects, extract the product name and price. Finally
	 * it returns an ArrayList of JLabels with the help from the statis class
	 * Labels.
	 * 
	 * @return ArrayList of product JLabels
	 */
	private ArrayList<JLabel> createProductsInOrderLabels() {
		ArrayList<javax.swing.JLabel> productsInOrderLabels = new ArrayList<javax.swing.JLabel>();
		ArrayList<Product> productsInOrder = ManageOrder
				.getProductsInOrder(order);
		priceLabel.setText(ManageOrder.formatPrice(ManageOrder
				.getTotalPrice(order)));

		int i = 0;
		for (Product p : productsInOrder) {
			final Product product = p;
			String text = product.getQuantity()
					+ " stk "
					+ product.getName()
					+ " "
					+ ManageOrder.formatPrice(product.getPrice()
							* product.getQuantity());

			javax.swing.JLabel label = Labels.createBorderlessLabel(text, i);
			label.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent evt) {
					orderLabelMouseClicked(evt, product);
				}
			});
			productsInOrderLabels.add(label);
			i++;
		}
		return productsInOrderLabels;
	}

	/**
	 * Displays the products on the screen in the innerRightPanel.
	 * 
	 * @param innerRightPanelLayout
	 * @param productsInOrderLabels
	 */
	private void setInnerRightPanelLayout(GroupLayout innerRightPanelLayout,
			ArrayList<JLabel> productsInOrderLabels) {
		// Set the horizontal axis
		javax.swing.GroupLayout.ParallelGroup tempHorizontalGroup = innerRightPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
		tempHorizontalGroup.addGap(0, 400, Short.MAX_VALUE);
		for (int i = 0; i < productsInOrderLabels.size(); i++) {
			tempHorizontalGroup.addComponent(productsInOrderLabels.get(i),
					org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 360,
					Short.MAX_VALUE);
		}

		// Set the vertical axis
		javax.swing.GroupLayout.SequentialGroup tempVerticalGroup = innerRightPanelLayout
				.createSequentialGroup();
		for (int i = 0; i < productsInOrderLabels.size(); i++) {
			tempVerticalGroup.addComponent(productsInOrderLabels.get(i),
					org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 46,
					org.jdesktop.layout.GroupLayout.PREFERRED_SIZE);
		}

		// Puts the groups created earlier into the right place in the
		// rightPanelLayout
		innerRightPanelLayout.setHorizontalGroup(tempHorizontalGroup);
		innerRightPanelLayout.setVerticalGroup(tempVerticalGroup);
	}

	boolean searchFieldChanged;

	/**
	 * Updates the left panel if when a key is typed in the search field.
	 * 
	 * @param evt
	 *            MouseEvent
	 */
	private void searchFieldKeyTyped(java.awt.event.KeyEvent evt) {
		String letter = this.searchField.getText();
		if ((!this.searchFieldChanged) && (letter.length() == 4)) {
			this.searchField.setText("" + letter.charAt(3));
			this.searchFieldChanged = true;
		} else {
			this.searchFieldChanged = true;
			this.searchField.setText(letter);
		}
		this.updateLeftPanel(ManageOrder.getRelevantProducts(this.searchField
				.getText()));
	}

	/**
	 * Removes the text from searchField and updates the product list when event
	 * is triggered
	 * 
	 * @param evt
	 *            MouseEvent
	 */
	private void searchFieldMouseClicked(java.awt.event.MouseEvent evt) {
		this.searchFieldChanged = true;
		this.searchField.setText("");
		this.updateLeftPanel(ManageOrder.getRelevantProducts(this.searchField
				.getText()));
	}

	private void commentFieldMouseClicked(java.awt.event.MouseEvent evt) {
	}

	/**
	 * Takes the user back to NewOrderForm1
	 * 
	 * @param evt
	 *            MouseEvent
	 */
	private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {
		NewOrderForm1 form = new NewOrderForm1(customer, order);
		form.setVisible(true);
		this.setVisible(false);
	}

	/**
	 * Submits the order to the database. If there's something missing, the
	 * place that has to be changed will be marked in red. If everything is OK,
	 * the user will be taken to the Main Menu
	 * 
	 * @param evt
	 *            MouseEvent
	 */
	private void finishButtonMouseClicked(java.awt.event.MouseEvent evt) {
		Color color = new Color(235, 210, 210);
		order.setStatus("Bestilt");
		boolean legalOrder = true;

		if (!Validate.isStringLegal(this.commentArea.getText())) {
			this.commentArea.setBackground(color);
			legalOrder = false;
		} else if (order.getAllergy() && this.commentArea.getText().equals("")) {
			this.commentArea.setBackground(color);
			legalOrder = false;
		} else {
			this.commentArea.setBackground(Color.WHITE);
		}
		if (ManageOrder.getProductsInOrder(order).size() < 1
				&& (ManageOrder.getProductsInOrder(order).get(0) instanceof DeliveryFee)) {
			this.rightPanel.setBackground(color);
			legalOrder = false;
		}
		if (ManageOrder.getProductsInOrder(order).size() == 1
				&& (ManageOrder.getProductsInOrder(order).get(0) instanceof DeliveryFee)) {
			this.rightPanel.setBackground(color);
			legalOrder = false;
		}
		if (legalOrder && existingOrder) {
			order.setComment(this.commentArea.getText());
			ManageOrder.updateExistingOrderInDatabase(order);
			MainMenuForm form = new MainMenuForm();
			form.setVisible(true);
			this.setVisible(false);
		} else if (legalOrder) {
			order.setComment(this.commentArea.getText());
			ManageOrder.submitOrderToDatabase(order);
			MainMenuForm form = new MainMenuForm();
			form.setVisible(true);
			this.setVisible(false);
		}
	}

	/**
	 * Adds the product to order when the event is triggered
	 * 
	 * @param evt
	 *            MouseEvent
	 * @param product
	 *            Product object
	 */
	private void productLabelMouseClicked(java.awt.event.MouseEvent evt,
			Product product) {
		ManageOrder.addOneMoreProductToOrder(order, product);
		this.updateRightPanel();
	}

	/**
	 * Removes the product from order. If the product is delivery, the
	 * takwawayButton status is changes as well. Calls the method
	 * updateRightPanel to make sure that the changes are displayed on screen.
	 * 
	 * @param evt
	 *            MouseEvent
	 * @param product
	 *            Product object
	 */
	private void orderLabelMouseClicked(java.awt.event.MouseEvent evt,
			Product product) {
		ManageOrder.removeOneProductFromOrder(order, product);
		if (product instanceof DeliveryFee) {
			order.setDelivery(false);
			Button.changeIcon(takeawayButton, "delete");
		}
		this.updateRightPanel();
	}

	/**
	 * Changes the status of the takeaway toggle button. When the event is
	 * triggered the icon and status is changed
	 * 
	 * @param evt
	 *            MouseEvent
	 */
	private void takeawayButtonMouseClicked(java.awt.event.MouseEvent evt) {
		if (order.getDelivery()) {
			Button.changeIcon(takeawayButton, "delete");
			ManageOrder.setDelivery(order, false);
			this.updateRightPanel();
		} else {
			Button.changeIcon(takeawayButton, "tick");
			ManageOrder.setDelivery(order, true);
			this.updateRightPanel();
		}
	}

	/**
	 * Changes the status of the allergy toggle button. When the event is
	 * triggered the icon and status is changed
	 * 
	 * @param evt
	 *            MouseEvent
	 */
	private void allergyButtonMouseClicked(java.awt.event.MouseEvent evt) {
		if (!order.getAllergy()) {
			Button.changeIcon(allergyButton, "tick");
			ManageOrder.setAllergy(order, true);
		} else {
			Button.changeIcon(allergyButton, "delete");
			ManageOrder.setAllergy(order, false);
		}
	}

	// Variables declaration
	private javax.swing.JLabel allergyButton;
	private javax.swing.JLabel backButton;
	private javax.swing.JPanel bottomPanel;
	private javax.swing.JTextArea commentArea;
	private javax.swing.JPanel commentPane;
	private javax.swing.JScrollPane commentScrollPane;
	private javax.swing.JLabel finishButton;
	private javax.swing.JLabel headerLabel;
	private javax.swing.JPanel leftPanel;
	private javax.swing.JScrollPane leftScrollPane;
	private javax.swing.JPanel innerLeftPanel;
	private javax.swing.JLabel priceLabel;
	private javax.swing.JPanel rightPanel;
	private javax.swing.JScrollPane rightScrollPane;
	private javax.swing.JPanel innerRightPanel;
	private javax.swing.JTextField searchField;
	private javax.swing.JLabel takeawayButton;
	private javax.swing.JPanel topPanel;
	// End of variables declaration
}