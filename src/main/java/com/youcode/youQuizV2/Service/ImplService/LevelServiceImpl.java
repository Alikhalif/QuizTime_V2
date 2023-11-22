package com.youcode.youQuizV2.Service.ImplService;

import com.youcode.youQuizV2.Exception.EntityNotFoundException;
import com.youcode.youQuizV2.Service.LevelService;
import com.youcode.youQuizV2.dto.LevelDto;
import com.youcode.youQuizV2.entities.Level;
import com.youcode.youQuizV2.repositories.LevelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class LevelServiceImpl implements LevelService {

    @Autowired
    private LevelRepository levelRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public LevelDto create(LevelDto levelDto){
        Level level = modelMapper.map(levelDto, Level.class);
        level = levelRepository.save(level);
        return modelMapper.map(level, LevelDto.class);
    }

    @Override
    public List<LevelDto> getAll(){
        return Arrays.asList(modelMapper.map(levelRepository.findAll(), LevelDto[].class));
    }

    @Override
    public LevelDto getOne(Long id) throws EntityNotFoundException {
        Level level = levelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found level with id : "+id));
        return modelMapper.map(level, LevelDto.class);
    }

    @Override
    public void delete(Long id) throws EntityNotFoundException {
        Level level = levelRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Question not found with id "+id));
        levelRepository.delete(level);
    }

    @Override
    public LevelDto update(Long id, LevelDto levelDto) {
        Level level = modelMapper.map(levelDto, Level.class);
        level.setId(id);
        Level updatedLevel = levelRepository.save(level);
        return modelMapper.map(updatedLevel, LevelDto.class);
    }
}
