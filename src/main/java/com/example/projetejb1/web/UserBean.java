package com.example.projetejb1.web;




import com.example.projetejb1.entities.CD;
import com.example.projetejb1.entities.Emprunt;
import com.example.projetejb1.service.CDService;
import jakarta.annotation.ManagedBean;
import jakarta.faces.view.ViewScoped;

import java.util.List;

@ManagedBean
@ViewScoped
public class UserBean {

    @Inject
    private CDService cdService;

    private Emprunt newEmprunt = new Emprunt();
    private List<Emprunt> userEmprunts;

    public void emprunterCD(CD cd) {
        cdService.emprunterCD(cd, newEmprunt);
        newEmprunt = new Emprunt(); // Reset after borrowing
        loadUserEmprunts();
    }

    public List<Emprunt> getUserEmprunts() {
        if (userEmprunts == null) {
            loadUserEmprunts();
        }
        return userEmprunts;
    }

    private void loadUserEmprunts() {
        userEmprunts = cdService.getUserEmprunts(); // Assuming this method is defined
    }

    public Emprunt getNewEmprunt() {
        return newEmprunt;
    }

    public void setNewEmprunt(Emprunt newEmprunt) {
        this.newEmprunt = newEmprunt;
    }
}

