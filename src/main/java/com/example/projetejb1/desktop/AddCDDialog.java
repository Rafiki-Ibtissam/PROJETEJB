package com.example.projetejb1.desktop;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCDDialog extends JDialog {
    private JTextField titleField;
    private JTextField artistField;
    private CDTableModel cdTableModel;

    public AddCDDialog(Frame owner, CDTableModel cdTableModel) {
        super(owner, "Ajouter un CD", true);
        this.cdTableModel = cdTableModel;

        setLayout(new GridLayout(3, 2));
        add(new JLabel("Titre:"));
        titleField = new JTextField();
        add(titleField);
        add(new JLabel("Artiste:"));
        artistField = new JTextField();
        add(artistField);

        JButton addButton = new JButton("Ajouter");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String artist = artistField.getText();
                cdTableModel.addCD(new CD(title, artist));
                dispose();
            }
        });
        add(addButton);

        setSize(300, 150);
        setLocationRelativeTo(owner);
    }
}
