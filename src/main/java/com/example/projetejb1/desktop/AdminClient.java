package com.example.projetejb1.desktop;


import javax.swing.*;

public class AdminClient {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CDManagementFrame frame = new CDManagementFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

