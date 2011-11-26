package no.ntnu.stud.it1901.group8.view;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

import no.ntnu.stud.it1901.group8.controller.ChefController;
import no.ntnu.stud.it1901.group8.controller.ManageOrder;
import no.ntnu.stud.it1901.group8.model.DeliveryFee;
import no.ntnu.stud.it1901.group8.model.Order;
import no.ntnu.stud.it1901.group8.model.Product;


/**
 * A class for displaying the Kitchenform2.
 * 
 */
@SuppressWarnings("serial")
public class Kitchenform2 extends javax.swing.JFrame {

	private Order order;

	/**
	 * Creates new form KitchenForm2 and shows the order that is given to the
	 * user.
	 * 
	 */
	public Kitchenform2(Order order) {
		this.order = order;
		initComponents();
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
		middlePanel = new javax.swing.JPanel();
		productsHeadersPanel = new javax.swing.JPanel();
		quantityHeaderLabel = new javax.swing.JLabel();
		productHeaderLabel = new javax.swing.JLabel();
		descriptionHeaderLabel = new javax.swing.JLabel();
		ProductsScrollPane = new javax.swing.JScrollPane();
		productsPanel = new javax.swing.JPanel();
		quantityPanel = new javax.swing.JPanel();
		productPanel = new javax.swing.JPanel();
		descriptionPanel = new javax.swing.JPanel();
		commentPanel = new javax.swing.JPanel();
		commentHeaderLabel = new javax.swing.JLabel();
		commentScrollPane = new javax.swing.JScrollPane();
		commentTextPane = new javax.swing.JTextPane();
		bottomPanel = new javax.swing.JPanel();
		backButton = new javax.swing.JLabel();
		startFinishButton = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Kjøkken - detaljer");
		setBounds(new java.awt.Rectangle(0, 0, 0, 0));
		setName("kitchen2Frame");
		setResizable(false);

		topPanel.setBackground(new java.awt.Color(220, 220, 220));
		topPanel.setPreferredSize(new java.awt.Dimension(780, 100));
		topPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,
				Color.darkGray));

		headerLabel.setFont(new java.awt.Font("Georgia", 0, 36));
		headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		headerLabel.setText("Kjøkken - detaljer");

		javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(
				topPanel);
		topPanel.setLayout(topPanelLayout);
		topPanelLayout.setHorizontalGroup(topPanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				topPanelLayout.createSequentialGroup().addContainerGap()
						.addComponent(headerLabel,
								javax.swing.GroupLayout.DEFAULT_SIZE, 800,
								Short.MAX_VALUE).addContainerGap()));
		topPanelLayout.setVerticalGroup(topPanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				topPanelLayout.createSequentialGroup().addGap(9, 9, 9)
						.addComponent(headerLabel).addContainerGap(
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		middlePanel.setBackground(new java.awt.Color(253, 253, 253));
		middlePanel.setPreferredSize(new java.awt.Dimension(800, 470));

		quantityHeaderLabel.setBackground(new java.awt.Color(240, 240, 240));
		quantityHeaderLabel.setFont(new java.awt.Font("Georgia", 0, 18));
		quantityHeaderLabel.setText("Antall");
		quantityHeaderLabel.setBorder(javax.swing.BorderFactory
				.createEmptyBorder(5, 10, 5, 5));
		quantityHeaderLabel.setOpaque(true);
		quantityHeaderLabel.setPreferredSize(new java.awt.Dimension(800, 40));

		productHeaderLabel.setBackground(new java.awt.Color(240, 240, 240));
		productHeaderLabel.setFont(new java.awt.Font("Georgia", 0, 18));
		productHeaderLabel.setText("Produkt");
		productHeaderLabel.setBorder(javax.swing.BorderFactory
				.createEmptyBorder(5, 10, 5, 5));
		productHeaderLabel.setOpaque(true);
		productHeaderLabel.setPreferredSize(new java.awt.Dimension(800, 40));

		descriptionHeaderLabel.setBackground(new java.awt.Color(240, 240, 240));
		descriptionHeaderLabel.setFont(new java.awt.Font("Georgia", 0, 18));
		descriptionHeaderLabel.setText("Beskrivelse");
		descriptionHeaderLabel.setBorder(javax.swing.BorderFactory
				.createEmptyBorder(5, 10, 5, 5));
		descriptionHeaderLabel.setOpaque(true);
		descriptionHeaderLabel
				.setPreferredSize(new java.awt.Dimension(800, 40));

		javax.swing.GroupLayout productsHeadersPanelLayout = new javax.swing.GroupLayout(
				productsHeadersPanel);
		productsHeadersPanel.setLayout(productsHeadersPanelLayout);
		productsHeadersPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2,
				0, Color.darkGray));

		productsHeadersPanelLayout
				.setHorizontalGroup(productsHeadersPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								productsHeadersPanelLayout
										.createSequentialGroup()
										.addComponent(
												quantityHeaderLabel,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												80,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(
												productHeaderLabel,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												300,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(
												descriptionHeaderLabel,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												444, Short.MAX_VALUE)));
		productsHeadersPanelLayout
				.setVerticalGroup(productsHeadersPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								productsHeadersPanelLayout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(
												quantityHeaderLabel,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(
												productHeaderLabel,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(
												descriptionHeaderLabel,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)));

		ProductsScrollPane.setBorder(null);
		ProductsScrollPane
				.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		ProductsScrollPane
				.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		ProductsScrollPane.setPreferredSize(new java.awt.Dimension(800, 240));

		productsPanel.setBackground(new java.awt.Color(253, 253, 253));

		quantityPanel.setBackground(new java.awt.Color(253, 253, 253));
		quantityPanel.setPreferredSize(new java.awt.Dimension(80, 302));

		productPanel.setBackground(new java.awt.Color(253, 253, 253));
		productPanel.setPreferredSize(new java.awt.Dimension(300, 302));

		descriptionPanel.setBackground(new java.awt.Color(253, 253, 253));

		// Fetch all products
		displayProducts();

		javax.swing.GroupLayout productsPanelLayout = new javax.swing.GroupLayout(
				productsPanel);
		productsPanel.setLayout(productsPanelLayout);
		productsPanelLayout.setHorizontalGroup(productsPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						productsPanelLayout.createSequentialGroup()
								.addComponent(quantityPanel,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(productPanel,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(descriptionPanel,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));
		productsPanelLayout.setVerticalGroup(productsPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(quantityPanel,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(productPanel,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(descriptionPanel,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		ProductsScrollPane.setViewportView(productsPanel);

		commentPanel.setBackground(new java.awt.Color(253, 253, 253));

		commentHeaderLabel.setBackground(new java.awt.Color(240, 240, 240));
		commentHeaderLabel.setFont(new java.awt.Font("Georgia", 0, 18));
		commentHeaderLabel.setText("Kommentar");
		commentHeaderLabel.setBorder(javax.swing.BorderFactory
				.createCompoundBorder(BorderFactory.createMatteBorder(2, 0, 2,
						0, Color.darkGray), javax.swing.BorderFactory
						.createEmptyBorder(5, 10, 5, 5)));
		commentHeaderLabel.setOpaque(true);
		commentHeaderLabel.setPreferredSize(new java.awt.Dimension(800, 40));

		commentScrollPane.setBorder(null);

		commentTextPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(
				10, 10, 10, 10));
		commentTextPane.setEditable(false);
		commentScrollPane.setViewportView(commentTextPane);

		javax.swing.GroupLayout commentPanelLayout = new javax.swing.GroupLayout(
				commentPanel);
		commentPanel.setLayout(commentPanelLayout);
		commentPanelLayout.setHorizontalGroup(commentPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(commentHeaderLabel,
						javax.swing.GroupLayout.DEFAULT_SIZE, 840,
						Short.MAX_VALUE).addComponent(commentScrollPane,
						javax.swing.GroupLayout.DEFAULT_SIZE, 840,
						Short.MAX_VALUE));
		commentPanelLayout.setVerticalGroup(commentPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						commentPanelLayout.createSequentialGroup()
								.addComponent(commentHeaderLabel,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(commentScrollPane,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										64, Short.MAX_VALUE)));

		javax.swing.GroupLayout middlePanelLayout = new javax.swing.GroupLayout(
				middlePanel);
		middlePanel.setLayout(middlePanelLayout);
		middlePanelLayout.setHorizontalGroup(middlePanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(productsHeadersPanel,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(commentPanel,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(ProductsScrollPane,
						javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE, 840,
						Short.MAX_VALUE));
		middlePanelLayout
				.setVerticalGroup(middlePanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								middlePanelLayout
										.createSequentialGroup()
										.addComponent(
												productsHeadersPanel,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(
												ProductsScrollPane,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												302, Short.MAX_VALUE)
										.addComponent(
												commentPanel,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)));

		bottomPanel.setBackground(new java.awt.Color(220, 220, 220));
		bottomPanel.setPreferredSize(new java.awt.Dimension(800, 100));
		bottomPanel.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0,
				Color.darkGray));

		backButton = Button.createButton("Tilbake", "red", "leftred");
		backButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				backButtonMouseClicked(evt);
			}
		});

		if (order.getStatus().equals("Bestilt")) {
			startFinishButton = Button.createButton("Start", "yellow", "label");
		} else {
			startFinishButton = Button.createButton("Ferdig", "green", "buy");
		}
		startFinishButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				startFinishButtonMouseClicked(evt);
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
												140,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												520, Short.MAX_VALUE)
										.addComponent(
												startFinishButton,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												140,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));
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
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																backButton,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																50,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																startFinishButton,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																50,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

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
														.addGroup(
																layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				false)
																		.addComponent(
																				middlePanel,
																				javax.swing.GroupLayout.Alignment.LEADING,
																				0,
																				840,
																				Short.MAX_VALUE)
																		.addComponent(
																				topPanel,
																				javax.swing.GroupLayout.Alignment.LEADING,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				840,
																				Short.MAX_VALUE))
														.addComponent(
																bottomPanel,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																840,
																Short.MAX_VALUE))));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addComponent(topPanel,
						javax.swing.GroupLayout.PREFERRED_SIZE, 60,
						javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(
						middlePanel, javax.swing.GroupLayout.PREFERRED_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(
						bottomPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
						70, javax.swing.GroupLayout.PREFERRED_SIZE)));

		pack();
	}

	/**
	 * Displays the products and comment.
	 */
	private void displayProducts() {
		// Create labels for all products
		ArrayList<ArrayList<JLabel>> labels = createProductLabels();

		setQuantityPanelLayout(labels.get(0));
		setProductPanelLayout(labels.get(1));
		setDescriptionPanelLayout(labels.get(2));

		// Set comment
		if (order.getComment() != null && !order.getComment().equals(""))
			commentTextPane.setText(order.getComment());

	}

	/**
	 * Creates an ArraList with JLabels containing a product.
	 * 
	 * @return ArrayList with JLabels
	 */
	private ArrayList<ArrayList<JLabel>> createProductLabels() {
		ArrayList<Product> productsInOrder = ManageOrder
				.getProductsInOrder(order);

		ArrayList<javax.swing.JLabel> quantityLabels = new ArrayList<javax.swing.JLabel>();
		ArrayList<javax.swing.JLabel> productLabels = new ArrayList<javax.swing.JLabel>();
		ArrayList<javax.swing.JLabel> descriptionLabels = new ArrayList<javax.swing.JLabel>();

		int i = 0;
		for (Product product : productsInOrder) {
			if (product instanceof DeliveryFee) {
				continue;
			}
			// Create quantityLabels
			String quantityText = "" + product.getQuantity();
			javax.swing.JLabel quantityLabel = Labels.createBorderlessLabel(
					quantityText, i);
			quantityLabels.add(quantityLabel);

			// Create productLabels
			String productText = "" + product.getName();
			javax.swing.JLabel productLabel = Labels.createBorderlessLabel(
					productText, i);
			productLabels.add(productLabel);

			// Create descriptionLabels
			String descriptionText;
			if (product.getComment() != null
					&& !product.getComment().equals(""))
				descriptionText = "" + product.getComment();
			else
				descriptionText = " ";

			javax.swing.JLabel descriptionLabel = Labels.createBorderlessLabel(
					descriptionText, i);
			descriptionLabels.add(descriptionLabel);

			i++;
		}
		ArrayList<ArrayList<javax.swing.JLabel>> labels = new ArrayList<ArrayList<javax.swing.JLabel>>();
		labels.add(quantityLabels);
		labels.add(productLabels);
		labels.add(descriptionLabels);
		return labels;

	}

	/**
	 * Sets the quantity panel layout to the quantity labels given.
	 * 
	 * @param quantityLabels
	 */
	private void setQuantityPanelLayout(ArrayList<JLabel> quantityLabels) {
		javax.swing.GroupLayout quantityPanelLayout = new javax.swing.GroupLayout(
				quantityPanel);
		quantityPanel.setLayout(quantityPanelLayout);

		javax.swing.GroupLayout.ParallelGroup tempHorizontalGroup = quantityPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
		for (int i = 0; i < quantityLabels.size(); i++) {
			tempHorizontalGroup.addComponent(quantityLabels.get(i),
					javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE);
		}

		javax.swing.GroupLayout.SequentialGroup tempVerticalGroup = quantityPanelLayout
				.createSequentialGroup();
		for (int i = 0; i < quantityLabels.size(); i++) {
			tempVerticalGroup.addComponent(quantityLabels.get(i));
		}

		quantityPanelLayout.setHorizontalGroup(tempHorizontalGroup);
		quantityPanelLayout.setVerticalGroup(quantityPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(tempVerticalGroup));
	}

	/**
	 * Sets the product panel layout to the product labels given.
	 * 
	 * @param productLabels
	 */
	private void setProductPanelLayout(ArrayList<JLabel> productLabels) {
		javax.swing.GroupLayout productPanelLayout = new javax.swing.GroupLayout(
				productPanel);
		productPanel.setLayout(productPanelLayout);

		javax.swing.GroupLayout.ParallelGroup tempHorizontalGroup = productPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
		for (int i = 0; i < productLabels.size(); i++) {
			tempHorizontalGroup.addComponent(productLabels.get(i),
					javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE);
		}

		javax.swing.GroupLayout.SequentialGroup tempVerticalGroup = productPanelLayout
				.createSequentialGroup();
		for (int i = 0; i < productLabels.size(); i++) {
			tempVerticalGroup.addComponent(productLabels.get(i));
		}

		productPanelLayout.setHorizontalGroup(tempHorizontalGroup);
		productPanelLayout.setVerticalGroup(productPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(tempVerticalGroup));
	}

	/**
	 * Sets the description panel layout to the product labels given.
	 * 
	 * @param productLabels
	 */
	private void setDescriptionPanelLayout(ArrayList<JLabel> productLabels) {
		javax.swing.GroupLayout descriptionPanelLayout = new javax.swing.GroupLayout(
				descriptionPanel);
		descriptionPanel.setLayout(descriptionPanelLayout);

		javax.swing.GroupLayout.ParallelGroup tempHorizontalGroup = descriptionPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
		for (int i = 0; i < productLabels.size(); i++) {
			tempHorizontalGroup.addComponent(productLabels.get(i),
					javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE);
		}

		javax.swing.GroupLayout.SequentialGroup tempVerticalGroup = descriptionPanelLayout
				.createSequentialGroup();
		for (int i = 0; i < productLabels.size(); i++) {
			tempVerticalGroup.addComponent(productLabels.get(i));
		}

		descriptionPanelLayout.setHorizontalGroup(tempHorizontalGroup);
		descriptionPanelLayout.setVerticalGroup(descriptionPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(tempVerticalGroup));

	}

	/**
	 * Sets the Kitchenform1 visible, and closes this form.
	 * 
	 * @param evt
	 */
	private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {
		Kitchenform1 form = new Kitchenform1();
		form.setVisible(true);
		this.setVisible(false);
	}

	/**
	 * Changes the status of the order. If the order is not started, it will be
	 * marked as started and the icon will change. If the order is already
	 * started, it will be marked as finished, and this form will close and
	 * Kitchenform1 will be visible.
	 * 
	 * @param evt
	 */
	private void startFinishButtonMouseClicked(java.awt.event.MouseEvent evt) {
		if (order.getStatus().equals("Bestilt")) {
			ChefController.startOrder(order);
			startFinishButton.setText("Ferdig");
			Button.changeIcon(startFinishButton, "buy");
			Button.changeColor(startFinishButton, "green");
		} else {
			ChefController.setFinishedOrder(order);
			Kitchenform1 form = new Kitchenform1();
			form.setVisible(true);
			this.setVisible(false);
		}
	}

	// Variables declaration
	private javax.swing.JScrollPane ProductsScrollPane;
	private javax.swing.JLabel backButton;
	private javax.swing.JPanel bottomPanel;
	private javax.swing.JLabel commentHeaderLabel;
	private javax.swing.JPanel commentPanel;
	private javax.swing.JScrollPane commentScrollPane;
	private javax.swing.JTextPane commentTextPane;
	private javax.swing.JLabel descriptionHeaderLabel;
	private javax.swing.JPanel descriptionPanel;
	private javax.swing.JLabel headerLabel;
	private javax.swing.JPanel middlePanel;
	private javax.swing.JLabel productHeaderLabel;
	private javax.swing.JPanel productPanel;
	private javax.swing.JPanel productsHeadersPanel;
	private javax.swing.JPanel productsPanel;
	private javax.swing.JLabel quantityHeaderLabel;
	private javax.swing.JPanel quantityPanel;
	private javax.swing.JLabel startFinishButton;
	private javax.swing.JPanel topPanel;
	// End of variables declaration
}
