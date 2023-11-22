package com.youcode.youQuizV2.Service.ImplService;

import com.youcode.youQuizV2.Service.TrainerService;
import com.youcode.youQuizV2.dto.TrainerDto;
import com.youcode.youQuizV2.entities.Trainer;
import com.youcode.youQuizV2.repositories.TrainerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class TrainerServiceImpl implements TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Trainer create(TrainerDto trainerDto){
        Trainer trainer = new Trainer();
        trainer.setFirstName(trainerDto.getFirstName());
        trainer.setLastName(trainerDto.getLastName());
        trainer.setBirthDate(trainerDto.getBirthDate());
        trainer.setAddress(trainerDto.getAddress());
        trainer.setSpeciality(trainerDto.getSpeciality());
        return trainerRepository.save(trainer);
    }

    @Override
    public List<Trainer> getAll(){
        return trainerRepository.findAll();
    }


    @Override
    public TrainerDto getOne(Long id){
        Optional<Trainer> trainer = trainerRepository.findById(id);
        return trainer.map(trainer1 -> modelMapper.map(trainer1, TrainerDto.class)).orElse(null);
    }

    @Override
    public Trainer update(Long id, TrainerDto trainerDto){
        Trainer trainer = trainerRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Trainer Not Found !"));
        trainer.setFirstName(trainerDto.getFirstName());
        trainer.setLastName(trainerDto.getLastName());
        trainer.setBirthDate(trainerDto.getBirthDate());
        trainer.setAddress(trainerDto.getAddress());
        trainer.setSpeciality(trainerDto.getSpeciality());
        return trainerRepository.save(trainer);
    }

    @Override
    public void delete(Long id){
        trainerRepository.deleteById(id);
    }
}