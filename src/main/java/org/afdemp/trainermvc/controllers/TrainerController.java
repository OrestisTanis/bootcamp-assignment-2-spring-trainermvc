/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.afdemp.trainermvc.controllers;

import java.util.List;
import javax.validation.Valid;
import org.afdemp.trainermvc.entities.Trainer;
import org.afdemp.trainermvc.services.ITrainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class TrainerController {

    @Autowired
    ITrainer trainerService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String getAllTrainers(ModelMap view) {
        // Get trainers from service
        List<Trainer> trainers = trainerService.findAll();
        // Send them to the view
        view.addAttribute("trainers", trainers);
        return "alltrainers";
    }

    @RequestMapping(value = {"/new",}, method = RequestMethod.GET)
    public String newTrainer(ModelMap view) {
        // Create trainer obj and send it to view
        Trainer trainer = new Trainer();
        view.addAttribute("trainer", trainer);
        return "newtrainer";
    }

    @RequestMapping(value = {"/new",}, method = RequestMethod.POST)
    public String saveTrainer(@Valid Trainer trainer, BindingResult result, ModelMap view) {
        if (result.hasErrors()) {
            return "newtrainer";
        }
        String st = "Trainer " + trainer.getFirstName() + " " + trainer.getLastName();
        String success = st + " registered successfully.";
        String failure = "There was a problem when trying to register " + st + ". Please try again.";

        if (trainerService.save(trainer)) {
            view.addAttribute("msg", success);
        } else {
            view.addAttribute("msg", failure);
        }
        return "result";
    }

    @RequestMapping(value = {"/edit/{id}",}, method = RequestMethod.GET)
    public String getAllTrainers(ModelMap view, @PathVariable int id) {
        // Get trainer from service
        Trainer trainer = trainerService.findById(id);
        view.addAttribute("trainer", trainer);
        return "edittrainer";
    }

    /*
	 * This method will be called on form submission, handling POST request for
	 * updating trainer in database. It also validates the user input
     */
    @RequestMapping(value = {"/edit/{id}"}, method = RequestMethod.POST)
    public String updateStudent(@Valid Trainer trainer, BindingResult result,
            ModelMap view) {
        if (result.hasErrors()) {
            return "edittrainer";
        }
        
        String success = "Trainer updated successfully.";
        String failure = "There was a problem when trying to update the requested trainer. Please try again.";

        if (trainerService.update(trainer)) {
            view.addAttribute("msg", success);
        } else {
            view.addAttribute("msg", failure);
        }
        return "result";
    }
    
    // delete for an existing student
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteStudent(ModelMap view, @PathVariable int id) {
        if(trainerService.delete(id)) {
            view.addAttribute("msg", new String("Trainer Deleted Successfully!"));
        } else {
            view.addAttribute("msg", new String("There was a problem when trying to delete the selected Trainer. Please try again."));
        }
        return("result");
    }
}
