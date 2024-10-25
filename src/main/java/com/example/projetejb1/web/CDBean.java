package com.example.projetejb1.web;

import com.example.projetejb1.entities.CD;
import com.example.projetejb1.entities.Emprunt;
import com.example.projetejb1.service.CDService;
import jakarta.annotation.ManagedBean;
import jakarta.ejb.EJB;

import java.util.List;

@ManagedBean
@RequestScoped
public class CDBean {
    @EJB
    private CDService cdService;

    private String user;
    private Long cdId;

    public List<CD> getCdDisponibles() {
        return cdService.listerCDDisponibles();
    }

    public void emprunterCD() {
        cdService.emprunterCD(cdId, user);
    }

    public List<Emprunt> getMesEmprunts() {
        return cdService.listerEmprunts(user);
    }

    public void retournerCD(Long empruntId) {
        cdService.retournerCD(empruntId);
    }

    public CDService getCdService() {
        return cdService;
    }

    public void setCdService(CDService cdService) {
        this.cdService = cdService;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Long getCdId() {
        return cdId;
    }

    public void setCdId(Long cdId) {
        this.cdId = cdId;
    }
}

