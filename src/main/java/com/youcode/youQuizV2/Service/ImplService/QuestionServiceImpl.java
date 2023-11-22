package com.youcode.youQuizV2.Service.ImplService;

import com.youcode.youQuizV2.Service.QuestionService;
import com.youcode.youQuizV2.dto.QuestionDto;
import com.youcode.youQuizV2.entities.Level;
import com.youcode.youQuizV2.entities.Question;
import com.youcode.youQuizV2.entities.Subject;
import com.youcode.youQuizV2.repositories.LevelRepository;
import com.youcode.youQuizV2.repositories.QuestionRepository;
import com.youcode.youQuizV2.repositories.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private LevelRepository levelRepository;

    @Autowired
    private SubjectRepository subjectRepository;


    @Override
    public QuestionDto create(QuestionDto questionDto){
        Question question = modelMapper.map(questionDto, Question.class);

        if(questionDto.getLevelId() != null){
            Level level = levelRepository.findById(questionDto.getLevelId())
                    .orElseThrow(() -> new EntityNotFoundException("Level not found"));
            question.setLevel(level);
        }

        if(questionDto.getSubjectId() != null){
            Subject subject = subjectRepository.findById(questionDto.getSubjectId())
                    .orElseThrow(()-> new EntityNotFoundException("Subject not found"));
            question.setSubject(subject);
        }

        question = questionRepository.save(question);
        return modelMapper.map(question, QuestionDto.class);
    }


    @Override
    public void delete(Long id){
        Question question = questionRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Question not found with id "+id));
        questionRepository.delete(question);
    }

    @Override
    public QuestionDto getOne(Long id){
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Question not found with id "+id));
        return modelMapper.map(question, QuestionDto.class);
    }

    @Override
    public List<QuestionDto> getAll(){
        return Arrays.asList(modelMapper.map(questionRepository.findAll(), QuestionDto[].class));
    }

    @Override
    public QuestionDto update(Long id, QuestionDto questionDto){
        Question questionUpdated = questionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Question not found with id "+id));

        if(questionDto.getQuestionText().isEmpty() == false){
            questionUpdated.setQuestionText(questionDto.getQuestionText());
        }
        questionUpdated.setType(questionDto.getType());
        questionUpdated.setTotalScore(questionDto.getTotalScore());

        if(questionDto.getLevelId() != null){
            Level level = levelRepository.findById(questionDto.getLevelId())
                    .orElseThrow(() -> new EntityNotFoundException("Level not found"));
            questionUpdated.setLevel(level);
        }

        if (questionDto.getSubjectId() != null){
            Subject subject = subjectRepository.findById(questionDto.getSubjectId())
                    .orElseThrow(() -> new EntityNotFoundException("Subject not found"));
            questionUpdated.setSubject(subject);
        }

        questionUpdated = questionRepository.save(questionUpdated);
        return modelMapper.map(questionUpdated, QuestionDto.class);
    }
}
