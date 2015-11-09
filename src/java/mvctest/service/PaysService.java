/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvctest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import mvctest.entity.Pays;
import org.springframework.stereotype.Service;

/**
 *
 * @author ETY
 */
@Service
public class PaysService {

    private Collection<Pays> listePays = new ArrayList<Pays>();

    public Iterable lister() {
        //return listePays;
        return Arrays.asList(new Pays[]{
            new Pays(1L, "FRANCE"),
            new Pays(2L, "USA"),
            new Pays(3L, "BELGIQUE")
        });
    }

    public void ajouter(Pays pays) {
        listePays.add(pays);
    }

    public Pays rechercher(long id){
        Pays pays = null;
        for (Pays paysTmp : listePays) {
            if(paysTmp.getId() == id){
                pays = paysTmp;
            }
        }
        return pays;
    }
    
    public void modifier(Pays p){
        Pays pays = null;
        for (Pays paysTmp : listePays) {
            if(paysTmp.getId() == p.getId().longValue()){
                pays = paysTmp;
            }
        }
        
        listePays.remove(pays);
        listePays.add(p);
    }
}
