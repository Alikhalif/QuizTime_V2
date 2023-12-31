package com.youcode.youQuizV2.Controller;

import com.youcode.youQuizV2.Service.TrainerService;
import com.youcode.youQuizV2.dto.TrainerDto;
import com.youcode.youQuizV2.entities.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/trainer")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    @PostMapping
    public Trainer createTrainer(@Valid @RequestBody TrainerDto trainerDto){
        return trainerService.create(trainerDto);
    }

    @GetMapping
    public List<Trainer> getAllTrainer(){
        return trainerService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainerDto> getTrainer(@PathVariable Long id){
        TrainerDto trainerDto = trainerService.getOne(id);
        if(trainerDto != null){
            return new ResponseEntity<>(trainerDto, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public Trainer updateTrainer(@PathVariable Long id, @Valid @RequestBody TrainerDto trainerDto){
        return trainerService.update(id, trainerDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTrainer(@PathVariable Long id){
        trainerService.delete(id);
    }


    @GetMapping("/find/{page}")
    public ResponseEntity<List<TrainerDto>> findTrainerByLimit(@PathVariable int page){
        List<TrainerDto> trainers = trainerService.findByLimit(page);
        return ResponseEntity.ok(trainers);
    }
}
