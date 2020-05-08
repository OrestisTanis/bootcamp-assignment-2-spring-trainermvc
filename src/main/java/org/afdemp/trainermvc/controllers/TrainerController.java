/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.afdemp.trainermvc.controllers;

import java.util.List;
import org.afdemp.trainermvc.entities.Trainer;
import org.afdemp.trainermvc.services.ITrainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class TrainerController {
    
    @Autowired
    ITrainer trainerService;
    
    @Autowired
    MessageSource messageSource;
    
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String getAllTrainers(ModelMap view){
        // Get trainers from service
        List<Trainer> trainers = trainerService.findAll();
        // Send them as attribute to the view
        view.addAttribute("trainers", trainers);
        return "alltrainers";
    }
}
