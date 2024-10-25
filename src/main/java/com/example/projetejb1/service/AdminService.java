package com.example.projetejb1.service;

import com.example.projetejb1.entities.CD;
import jakarta.ejb.Stateful;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateful
public class AdminService {
    @PersistenceContext
    private EntityManager em;

    public void ajouterCD(String titre, String artiste) {
        CD cd = new CD(titre, artiste);
        em.persist(cd);
    }

    public void supprimerCD(Long cdId) {
        CD cd = em.find(CD.class, cdId);
        if (cd != null) {
            em.remove(cd);
        }
    }

    public List<CD> listerTousLesCD() {
        return em.createQuery("SELECT c FROM CD c", CD.class).getResultList();
    }
}

