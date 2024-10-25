package com.example.projetejb1.service;

import com.example.projetejb1.entities.CD;
import com.example.projetejb1.entities.Emprunt;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


import java.util.Date;
import java.util.List;

@Stateless
public class CDService {
    @PersistenceContext
    private EntityManager em;

    public List<CD> listerCDDisponibles() {
        return em.createQuery("SELECT c FROM CD c WHERE c.disponible = TRUE", CD.class).getResultList();
    }

    public void emprunterCD(Long cdId, String user) {
        CD cd = em.find(CD.class, cdId);
        if (cd != null && cd.isDisponible()) {
            cd.setDisponible(false);
            em.merge(cd);

            Emprunt emprunt = new Emprunt(cd, user);
            em.persist(emprunt);
        }
    }

    public List<Emprunt> listerEmprunts(String user) {
        return em.createQuery("SELECT e FROM Emprunt e WHERE e.user = :user", Emprunt.class)
                .setParameter("user", user)
                .getResultList();
    }

    public void retournerCD(Long empruntId) {
        Emprunt emprunt = em.find(Emprunt.class, empruntId);
        if (emprunt != null && emprunt.getDateRetour() == null) {
            emprunt.setDateRetour(new Date());
            em.merge(emprunt);

            CD cd = emprunt.getCd();
            cd.setDisponible(true);
            em.merge(cd);
        }
    }

}

