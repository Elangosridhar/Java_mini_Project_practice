package com.currencyconverter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;

public class CurrencyConverterApp {
    private JFrame frame;
    private JTextField amountField;
    private JComboBox<String> fromCurrencyBox;
    private JComboBox<String> toCurrencyBox;
    private JLabel resultLabel;
    private CurrencyConverter converter;

    public CurrencyConverterApp() {
        converter = new CurrencyConverter();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Currency Converter");
        frame.setBounds(100, 100, 400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblAmount = new JLabel("Amount:");
        lblAmount.setBounds(50, 50, 80, 25);
        frame.getContentPane().add(lblAmount);

        amountField = new JTextField();
        amountField.setBounds(150, 50, 150, 25);
        frame.getContentPane().add(amountField);
        amountField.setColumns(10);

        JLabel lblFromCurrency = new JLabel("From:");
        lblFromCurrency.setBounds(50, 90, 80, 25);
        frame.getContentPane().add(lblFromCurrency);

        fromCurrencyBox = new JComboBox<>(new String[]{"USD", "EUR", "GBP", "INR"});
        fromCurrencyBox.setBounds(150, 90, 150, 25);
        frame.getContentPane().add(fromCurrencyBox);

        JLabel lblToCurrency = new JLabel("To:");
        lblToCurrency.setBounds(50, 130, 80, 25);
        frame.getContentPane().add(lblToCurrency);

        toCurrencyBox = new JComboBox<>(new String[]{"USD", "EUR", "GBP", "INR"});
        toCurrencyBox.setBounds(150, 130, 150, 25);
        frame.getContentPane().add(toCurrencyBox);

        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(150, 170, 150, 25);
        frame.getContentPane().add(convertButton);

        resultLabel = new JLabel("");
        resultLabel.setBounds(50, 210, 250, 25);
        frame.getContentPane().add(resultLabel);

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    String fromCurrency = (String) fromCurrencyBox.getSelectedItem();
                    String toCurrency = (String) toCurrencyBox.getSelectedItem();
                    double result = converter.convert(fromCurrency, toCurrency, amount);
                    resultLabel.setText(String.format("%.2f %s", result, toCurrency));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid amount", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CurrencyConverterApp window = new CurrencyConverterApp();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
