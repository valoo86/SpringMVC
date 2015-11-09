/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvctest.controller;

import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import mvctest.entity.Utilisateur;
import mvctest.service.PaysService;
import mvctest.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 *
 * @author ETY
 */
@Controller
//@RequestMapping(value="/utils") //si on veut ajouter /utils dans toutes les routes de UtilisateurController
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private PaysService paysService;

    public String loginPOST(HttpSession session, @ModelAttribute("util") Utilisateur u) {
        return "/login";
    }
    
    //@RequestMapping(value = "/list")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {

//        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
//        localeResolver.setLocale(request, response, StringUtils.parseLocaleString("fr"));

        model.addAttribute("users", utilisateurService.list());

        return "user/user_list"; //La vue à afficher (la jsp, pas besoin de mettre le .jsp car automatique fais grâce au fichier dispatcher-servlet.jsp)
    }

    @RequestMapping(value = "/ajouter", method = RequestMethod.GET)
    public String ajouterGET(Model model) {
        model.addAttribute("util", new Utilisateur());
        model.addAttribute("listePays", paysService.lister());
        return "user/user_ajouter"; //La vue à afficher (la jsp, pas besoin de mettre le .jsp car automatique fais grâce au fichier dispatcher-servlet.jsp)
    }

    @RequestMapping(value = "/ajouter", method = RequestMethod.POST)
    public String ajouterPOST(Model model, @Valid @ModelAttribute("util") Utilisateur u, BindingResult result) {

        if(result.hasErrors()){
//            return "redirect:/ajouter";
            model.addAttribute("listePays", paysService.lister());
            return "user/user_ajouter";
        }
        
        utilisateurService.ajouter(u);

        //return ""; //La vue à afficher (la jsp, pas besoin de mettre le .jsp car automatique fais grâce au fichier dispatcher-servlet.jsp)
        return "redirect:/list";
    }

    @RequestMapping(value = "/modifier/{id}", method = RequestMethod.GET)
    public String modifier(Model model, @PathVariable("id") long id) {

        Utilisateur utilisateur = utilisateurService.rechercher(id);
        model.addAttribute("util", utilisateur);
        model.addAttribute("listePays", paysService.lister());

        return "user/user_modifier";
    }

    @RequestMapping(value = "/modifier/{id}", method = RequestMethod.POST)
    public String modifier(@ModelAttribute("util") Utilisateur u) {

        utilisateurService.modifier(u);

        //return "user/user_modifier";
        return "redirect:/list";
    }

    @RequestMapping(value = "/supprimer/{id}", method = RequestMethod.GET)
    public String supprimer(@ModelAttribute("id") long id) {
        utilisateurService.supprimer(id);

        //return "forward:/list";
        return "redirect:/list";
    }
}
