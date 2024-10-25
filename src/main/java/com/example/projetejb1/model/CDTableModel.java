package com.example.projetejb1.model;


import com.example.projetejb1.entities.CD;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class CDTableModel extends AbstractTableModel {
    private List<CD> cdList;

    public CDTableModel() {
        cdList = new ArrayList<>();
    }

    public void addCD(CD cd) {
        cdList.add(cd);
        fireTableDataChanged();
    }

    public void updateCD(int index, CD cd) {
        cdList.set(index, cd);
        fireTableDataChanged();
    }

    public void deleteCD(int index) {
        cdList.remove(index);
        fireTableDataChanged();
    }

    public CD getCD(int index) {
        return cdList.get(index);
    }

    @Override
    public int getRowCount() {
        return cdList.size();
    }

    @Override
    public int getColumnCount() {
        return 2; // Titre et Artiste
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CD cd = cdList.get(rowIndex);
        return columnIndex == 0 ? cd.getTitre() : cd.getArtiste();
    }

    @Override
    public String getColumnName(int column) {
        return column == 0 ? "Titre" : "Artiste";
    }
}

