package portfolio.gui;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import portfolio.model.Company;

public class AddCompanyForm extends JFrame {
    private JTextField nameField, investField, sharesField, returnField, sectorField;
    private JButton saveButton;
    private List<Company> companyList;
    private Dashboard dashboardRef;

    public AddCompanyForm(List<Company> companyList, Dashboard dashboardRef) {
        this.companyList = companyList;
        this.dashboardRef = dashboardRef;

        setTitle("Add New Investment");
        setSize(350, 300);
        setLayout(null);

        JLabel nameLabel = new JLabel("Company Name:");
        nameLabel.setBounds(20, 20, 120, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 20, 150, 25);
        add(nameField);

        JLabel investLabel = new JLabel("Investment ($):");
        investLabel.setBounds(20, 60, 120, 25);
        add(investLabel);

        investField = new JTextField();
        investField.setBounds(150, 60, 150, 25);
        add(investField);

        JLabel sharesLabel = new JLabel("Shares Owned:");
        sharesLabel.setBounds(20, 100, 120, 25);
        add(sharesLabel);

        sharesField = new JTextField();
        sharesField.setBounds(150, 100, 150, 25);
        add(sharesField);

        JLabel returnLabel = new JLabel("Return (%):");
        returnLabel.setBounds(20, 140, 120, 25);
        add(returnLabel);

        returnField = new JTextField();
        returnField.setBounds(150, 140, 150, 25);
        add(returnField);

        JLabel sectorLabel = new JLabel("Sector:");
        sectorLabel.setBounds(20, 180, 120, 25);
        add(sectorLabel);

        sectorField = new JTextField();
        sectorField.setBounds(150, 180, 150, 25);
        add(sectorField);

        saveButton = new JButton("Save");
        saveButton.setBounds(120, 220, 100, 30);
        add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = nameField.getText();
                    double investment = Double.parseDouble(investField.getText());
                    int shares = Integer.parseInt(sharesField.getText());
                    double ret = Double.parseDouble(returnField.getText());
                    String sector = sectorField.getText();

                    if (!name.isEmpty() && !sector.isEmpty()) {
                        Company company = new Company(name, investment, shares, ret, sector);
                        companyList.add(company);
                        dashboardRef.refreshCompanyList();
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Please fill all fields.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Enter valid numbers for investment, shares, and return.");
                }
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
