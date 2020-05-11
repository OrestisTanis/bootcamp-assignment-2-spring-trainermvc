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

    String updateSuccessMsg = "updated successfully.";
    String updateFailMsg = "There was a problem while trying to update the requested trainer. Please try again.";
    String deleteSuccessMsg = "deleted successfully.";
    String deleteFailMsg = "There was a problem while trying to delete the requested trainer. Please try again.";
    String registerSuccessMsg = "created successfully.";
    String registerFailMsg = "There was a problem while trying to register the requested trainer. Please try again.";

    @Autowired
    ITrainer trainerService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String getAllTrainers(ModelMap view) {
        List<Trainer> trainers = trainerService.findAll();
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

        if (trainerService.save(trainer)) {
            view.addAttribute("msg", getRegisterSuccessMsg(trainer));
        } else {
            view.addAttribute("msg", getRegisterFailMsg());
        }
        return "result";
    }

    @RequestMapping(value = {"/edit/{id}",}, method = RequestMethod.GET)
    public String editTrainer(ModelMap view, @PathVariable long id) {
        Trainer trainer = trainerService.findById(id);
        view.addAttribute("trainer", trainer);
        return "edittrainer";
    }

    @RequestMapping(value = {"/edit/{id}"}, method = RequestMethod.POST)
    public String updateTrainer(@Valid Trainer trainer, BindingResult result,
            ModelMap view) {
        if (result.hasErrors()) {
            return "edittrainer";
        }

        if (trainerService.update(trainer)) {
            view.addAttribute("msg", getUpdateSuccessMsg(trainer));
        } else {
            view.addAttribute("msg", getUpdateFailMsg());
        }
        return "result";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteTrainer(ModelMap view, @PathVariable long id) {
        if (trainerService.delete(id)) {
            view.addAttribute("msg", getDeleteSuccessMsg());
        } else {
            view.addAttribute("msg", getDeleteFailMsg());
        }
        return ("result");
    }

    public String getUpdateSuccessMsg(Trainer tr) {
        return String.format("Trainer %s%s %s", tr.getFirstName(), tr.getLastName(), updateSuccessMsg);
    }

    public String getUpdateFailMsg() {
        return updateFailMsg;
    }

    public String getDeleteSuccessMsg() {
        return String.format("Trainer %s", deleteSuccessMsg);
    }

    public String getDeleteFailMsg() {
        return deleteFailMsg;
    }

    public String getRegisterSuccessMsg(Trainer tr) {
        return String.format("Trainer %s%s %s", tr.getFirstName(), tr.getLastName(), registerSuccessMsg);
    }

    public String getRegisterFailMsg() {
        return registerFailMsg;
    }
}
