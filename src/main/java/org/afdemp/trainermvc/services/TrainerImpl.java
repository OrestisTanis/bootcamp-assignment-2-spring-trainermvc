/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.afdemp.trainermvc.services;

import java.util.List;
import org.afdemp.trainermvc.dao.ITrainerDao;
import org.afdemp.trainermvc.entities.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Walter
 */

@Service("studentService")
@Transactional
public class TrainerImpl implements ITrainer {
    
    @Autowired
    ITrainerDao dao;

    @Override
    public List<Trainer> findAll() {
       return dao.findAll();
    }

    @Override
    public boolean save(Trainer trainer) {
        convertTrainerPropertiesToUpper(trainer);
        return dao.save(trainer);
    }

    @Override
    public boolean update(Trainer trainer) {
        convertTrainerPropertiesToUpper(trainer);
        //return dao.update(trainer); when finally calling save in trainerDaoImpl, abstractDao's persist method returns the opposite result than it is expected
        dao.update(trainer);
        return true;
    }

    @Override
    public boolean delete(long id) {
        return dao.delete(id);
    }

    @Override
    public Trainer findById(long id) {
        return dao.findById(id);
    }
    
    protected String convertTextToUpper(String text) {
        return text.toUpperCase();
    }
    
    protected void convertTrainerPropertiesToUpper(Trainer tr){
        tr.setFirstName(convertTextToUpper(tr.getFirstName()));
        tr.setLastName(convertTextToUpper(tr.getLastName()));
        tr.setSubject(convertTextToUpper(tr.getSubject()));
    }
}
