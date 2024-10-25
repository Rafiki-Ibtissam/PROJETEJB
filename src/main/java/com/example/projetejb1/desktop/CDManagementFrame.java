package com.example.projetejb1.desktop;


import com.example.projetejb1.model.CDTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CDManagementFrame extends JFrame {
    private JTable cdTable;
    private CDTableModel cdTableModel;

    public CDManagementFrame() {
        setTitle("Gestion des CD");
        setSize(600, 400);
        setLocationRelativeTo(null);

        cdTableModel = new CDTableModel();
        cdTable = new JTable(cdTableModel);
        JScrollPane scrollPane = new JScrollPane(cdTable);

        JButton addButton = new JButton("Ajouter CD");
        JButton updateButton = new JButton("Modifier CD");
        JButton deleteButton = new JButton("Supprimer CD");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddCDDialog(CDManagementFrame.this, cdTableModel).setVisible(true);
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = cdTable.getSelectedRow();
                if (selectedRow != -1) {
                    new UpdateCDDialog(CDManagementFrame.this, cdTableModel, selectedRow).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(CDManagementFrame.this, "Sélectionnez un CD à modifier");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = cdTable.getSelectedRow();
                if (selectedRow != -1) {
                    cdTableModel.deleteCD(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(CDManagementFrame.this, "Sélectionnez un CD à supprimer");
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}

