package mealPlan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class Mealplan extends JFrame {
	DecimalFormat df = new DecimalFormat("#.##"); // implements DecimalFormat.
	private double Ashokan;
	private double Awosting;
	private double Minnewaska;
	private double Mohonk;
	private double Shawangunk;
	private double carteBlanche;
	private double theTwelve;
	private double theSeven;
	private JPanel suitePanel;
	private JPanel mealPanel;
	private JLabel label;
	private JPanel selectedTotalPanel;
	private JTextField selectedTotal;
	private String suitePrice;
	private String mealPrice;
	private String finalTotal;
	private double totalSuitePrice;
	private double totalMealPrice;
	private JComboBox<Object> suiteComboBox;
	private JComboBox<Object> mealComboBox;

	/**
	 * Main method.
	 */
	public Mealplan() {
		setTitle("New Paltz Plans");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		suitePrices();
		mealPrices();
		buildSuitePanel();
		buildMealPanel();
		buildTotalSelected();
		suiteComboBox.setSelectedIndex(0);
		mealComboBox.setSelectedIndex(0);
		add(suitePanel, BorderLayout.WEST);
		add(mealPanel, BorderLayout.EAST);
		add(selectedTotalPanel, BorderLayout.SOUTH);
		setSize(1000, 1000);
		pack();
		setVisible(true);
	}

	/**
	 * Prices for housing.
	 */
	private void suitePrices() {
		Ashokan = 3688;
		Awosting = 4346;
		Minnewaska = 3688;
		Mohonk = 3316;
		Shawangunk = 3898;

	}

	/**
	 * Prices for meal plans.
	 */
	private void mealPrices() {
		carteBlanche = 1813;
		theTwelve = 1659;
		theSeven = 1512;
	}

	/**
	 * Builds suitePanel.
	 */
	private void buildSuitePanel() {
		String[] suite = {

				"Ashokan $" + (df.format(Ashokan)),
				"Awosting $" + (df.format(Awosting)),
				"Minnewaska $" + (df.format(Minnewaska)),
				"Mohonk $" + (df.format(Mohonk)),
				"Shawangunk $" + (df.format(Shawangunk)),
				};

		suitePanel = new JPanel();
		suiteComboBox = new JComboBox<Object>(suite);
		suiteComboBox.addActionListener(new ComboBoxListener());
		suitePanel.add(suiteComboBox);
	}

	/**
	 * Builds mealPanel.
	 */
	private void buildMealPanel() {
		String[] meal = { 
				"Carte Blanche Plan $" + (df.format(carteBlanche)),
				"The Twelve Plan $" + (df.format(theTwelve)),
				"The Seven Plan $ " + (df.format(theSeven)) };

		mealPanel = new JPanel();
		mealComboBox = new JComboBox<Object>(meal);
		mealComboBox.addActionListener(new ComboBoxListener());
		mealPanel.add(mealComboBox);
	}

	/**
	 * Builds selectedTotalPanel.
	 */
	private void buildTotalSelected() {
		selectedTotalPanel = new JPanel();
		label = new JLabel("Total price: ");
		selectedTotal = new JTextField(6);
		selectedTotal.setEditable(false);
		selectedTotalPanel.add(label);
		selectedTotalPanel.add(selectedTotal);

	}

	/**
	 * Implements selection of suiteComboBox and mealComboBox. Implements
	 * selctedTotal and adds the selected Price of suiteComboBox and
	 * mealComboBox together.
	 *
	 */
	private class ComboBoxListener implements ActionListener {
		public void actionPerformed(ActionEvent E) {

			String selection = (String) suiteComboBox.getSelectedItem();
			String selection2 = (String) mealComboBox.getSelectedItem();
			if (selection.equals(suiteComboBox.getSelectedItem())
					&& selection2.equals(mealComboBox.getSelectedItem())) {
				suitePrice = ((String) suiteComboBox.getSelectedItem())
						.replaceAll("[^\\d.]", "");
				// Removes all characters from String except for the numbers.
				mealPrice = ((String) mealComboBox.getSelectedItem())
						.replaceAll("[^\\d.]", "");
				totalSuitePrice = Double.parseDouble(suitePrice);
				// Parses remaining numbers into doubles to be used for
				// addition.
				totalMealPrice = Double.parseDouble(mealPrice);
				finalTotal = Double.toString(totalSuitePrice + totalMealPrice);
				// Adds totalSuitePrice and totalMealPrice together.
				selectedTotal.setText("$" + finalTotal);

			}
		}

	}

	/**
	 * Main method.
	 */
	public static void main(String[] args) {
		Mealplan plan = new Mealplan();

	}
}