package org.afdemp.trainermvc.services;

import java.util.List;
import org.afdemp.trainermvc.entities.Trainer;

public interface ITrainer {

    public List<Trainer> findAll();

    public boolean save(Trainer trainer);

    public boolean update(Trainer trainer);

    public boolean delete(long id);

    public Trainer findById(long id);
}
