/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.afdemp.trainermvc.dao;

import java.util.List;
import org.afdemp.trainermvc.entities.Trainer;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Walter
 */
@Repository("trainerDao")
public class trainerDaoImpl extends AbstractDao<Long, Trainer> implements ITrainerDao {

    @Override
    public List<Trainer> findAll() {
        Criteria criteria = createEntityCriteria();
        return (List<Trainer>) criteria.list();
    }

    @Override
    public boolean save(Trainer trainer) {
        boolean notSaved = persist(trainer);
        if (notSaved) {
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Trainer trainer) {
        Trainer db_trainer = findById(trainer.getId());
        if(db_trainer != null) {
            db_trainer.setFirstName(trainer.getFirstName());
            db_trainer.setLastName(trainer.getLastName());
            db_trainer.setSubject(trainer.getSubject());
            return save(db_trainer);
        } else
            return false;
    }

    @Override
    public boolean delete(long id) {
        Trainer tr = getByKey(id);
        if(tr != null) {
            delete(tr);
            if(getByKey(id) == null) 
                return true;
        }
        return false;
    }

    @Override
    public Trainer findById(long id) {
        Trainer tr = getByKey(id);
        if (tr != null){
            return tr;
        }
        return null;
    }

}
