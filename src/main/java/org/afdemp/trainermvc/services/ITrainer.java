/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.afdemp.trainermvc.services;

import java.util.List;
import org.afdemp.trainermvc.entities.Trainer;

/**
 *
 * @author Walter
 */
public interface ITrainer {
    public List<Trainer> findAll();
    
    public boolean save(Trainer trainer);
    
    public boolean update(Trainer trainer);
    
    public boolean edit(long id);
    
    public boolean delete(long id);
    
    public Trainer findById(long id);
}
