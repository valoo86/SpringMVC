/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvctest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mvctest.entity.Utilisateur;
import org.springframework.stereotype.Service;

/**
 *
 * @author ETY
 */
@Service
public class UtilisateurService {
    
    private final List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
    
    public Iterable list() {
        
        //return Arrays.asList(new String[]{"rocky", "rambo", "xena"});
//        utilisateurs.add(new Utilisateur(1L, "rocky"));
//        utilisateurs.add(new Utilisateur(2L, "rambo"));
//        utilisateurs.add(new Utilisateur(3L, "xena"));
        
        return utilisateurs;
    }
    
    public void ajouter(Utilisateur utilisateur){
        utilisateurs.add(utilisateur);
    }
    
    public Utilisateur rechercher(long id){
        Utilisateur utilisateur = null;
        for (Utilisateur utilisateurTmp : utilisateurs) {
            if(utilisateurTmp.getId() == id){
                utilisateur = utilisateurTmp;
            }
        }
        return utilisateur;
    }
    
    public void modifier(Utilisateur u){
        Utilisateur utilisateur = null;
        for (Utilisateur utilisateurTmp : utilisateurs) {
            if(utilisateurTmp.getId() == u.getId().longValue()){
                utilisateur = utilisateurTmp;
            }
        }
        
        utilisateurs.remove(utilisateur);
        utilisateurs.add(u);
    }
    
    public void supprimer(long id) {
        Utilisateur utilisateur = rechercher(id);
        utilisateurs.remove(utilisateur);
    }
}
