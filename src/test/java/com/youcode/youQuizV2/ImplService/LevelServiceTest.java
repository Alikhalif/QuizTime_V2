package com.youcode.youQuizV2.ImplService;

import com.youcode.youQuizV2.Exception.EntityNotFoundException;
import com.youcode.youQuizV2.Service.ImplService.LevelServiceImpl;
import com.youcode.youQuizV2.dto.LevelDto;
import com.youcode.youQuizV2.entities.Level;
import com.youcode.youQuizV2.repositories.LevelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LevelServiceTest {

    @Mock
    private LevelRepository levelRepository;
    @Mock
    private ModelMapper modelMapper;
    @InjectMocks
    private LevelServiceImpl levelService;

    private LevelDto levelDto;
    private Level level;

    @BeforeEach
    public void setUp(){
        levelDto = new LevelDto();
        levelDto.setId(1L);
        levelDto.setDescription("description");
        levelDto.setMaxScore(2.0);
        levelDto.setMinScore(1.0);

        level = new Level();
        level.setId(1L);
        level.setDescription("description");
        level.setMaxScore(2.0);
        level.setMinScore(1.0);
    }

    @Test
    public void createTest(){
        when(levelService.create(levelDto)).thenReturn(levelDto);
        LevelDto tmp = levelService.create(levelDto);
        assertSame(tmp, levelDto);
    }


    //@Test
    public void findAllTest(){
        List<LevelDto> list = new ArrayList<>();
        list.add(levelDto);
        when(levelService.getAll()).thenReturn(list);
        List<LevelDto> tmp = levelService.getAll();
        assertSame(tmp.size(), list.size());
    }

    //@Test
    public void testDeleteLevel() {
        when(levelRepository.existsById(1L)).thenReturn(true);
        //levelService.delete(1L);
        verify(levelRepository).deleteById(1L);
    }

    //@Test
    public void testGetOneLevel() throws EntityNotFoundException {
        when(levelService.getOne(1L)).thenReturn(levelDto);
        LevelDto tmp = levelService.getOne(1L);
        assertSame(tmp, levelDto);
    }

    @Test
    public void updateTest(){
        Long id = 1L;



        //verify(levelRepository).save(level);
    }
}
