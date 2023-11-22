package com.youcode.youQuizV2.Service;

import com.youcode.youQuizV2.dto.TrainerDto;
import com.youcode.youQuizV2.entities.Trainer;

import java.util.List;

public interface TrainerService {
    Trainer create(TrainerDto trainerDto);
    List<Trainer> getAll();
    TrainerDto getOne(Long id);
    Trainer update(Long id, TrainerDto trainerDto);
    void delete(Long id);
}
