package portfolio.gui;

import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import portfolio.model.Company;
import portfolio.util.FileHandler;

public class Dashboard extends JFrame {
    private List<Company> companyList = new ArrayList<>();
    private JTable companyTable;
    private DefaultTableModel tableModel;

    public Dashboard(String username) {
        setTitle("Investment Dashboard - " + username);
        setSize(800, 450);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        companyList = FileHandler.loadCompanies();

        JLabel welcomeLabel = new JLabel("Welcome, " + username);
        welcomeLabel.setBounds(20, 10, 400, 25);
        add(welcomeLabel);

        JButton addButton = new JButton("Add Investment");
        addButton.setBounds(20, 40, 150, 25);
        add(addButton);

        JButton saveButton = new JButton("Save Portfolio");
        saveButton.setBounds(180, 40, 150, 25);
        add(saveButton);

        JButton deleteButton = new JButton("Delete Entry");
        deleteButton.setBounds(340, 40, 150, 25);
        add(deleteButton);

        tableModel = new DefaultTableModel(
            new String[]{"Company", "Investment ($)", "Shares", "Return (%)", "Sector"}, 0
        );
        companyTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(companyTable);
        scrollPane.setBounds(20, 80, 740, 300);
        add(scrollPane);

        refreshCompanyList();

        addButton.addActionListener(e -> new AddCompanyForm(companyList, this));

        saveButton.addActionListener(e -> {
            FileHandler.saveCompanies(companyList);
            JOptionPane.showMessageDialog(null, "Saved successfully.");
        });

        deleteButton.addActionListener(e -> {
            int selectedRow = companyTable.getSelectedRow();
            if (selectedRow >= 0) {
                companyList.remove(selectedRow);
                refreshCompanyList();
            } else {
                JOptionPane.showMessageDialog(null, "Select a company to delete.");
            }
        });

        setVisible(true);
    }

    public void refreshCompanyList() {
        tableModel.setRowCount(0);
        for (Company c : companyList) {
            tableModel.addRow(new Object[]{
                c.getName(),
                c.getInvestmentAmount(),
                c.getSharesOwned(),
                c.getReturnPercent(),
                c.getSector()
            });
        }
    }
}
