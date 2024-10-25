package com.example.projetejb1.desktop;

import com.example.projetejb1.model.CDTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateCDDialog extends JDialog {
    private JTextField titleField;
    private JTextField artistField;
    private CDTableModel cdTableModel;
    private int selectedRow;

    public UpdateCDDialog(Frame owner, CDTableModel cdTableModel, int selectedRow) {
        super(owner, "Modifier un CD", true);
        this.cdTableModel = cdTableModel;
        this.selectedRow = selectedRow;

        CD selectedCD = cdTableModel.getCD(selectedRow);

        setLayout(new GridLayout(3, 2));
        add(new JLabel("Titre:"));
        titleField = new JTextField(selectedCD.getTitre());
        add(titleField);
        add(new JLabel("Artiste:"));
        artistField = new JTextField(selectedCD.getArtiste());
        add(artistField);

        JButton updateButton = new JButton("Modifier");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedCD.setTitre(titleField.getText());
                selectedCD.setArtiste(artistField.getText());
                cdTableModel.updateCD(selectedRow, selectedCD);
                dispose();
            }
        });
        add(updateButton);

        setSize(300, 150);
        setLocationRelativeTo(owner);
    }
}
