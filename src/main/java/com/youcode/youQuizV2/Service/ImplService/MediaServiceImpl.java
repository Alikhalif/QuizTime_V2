package com.youcode.youQuizV2.Service.ImplService;

import com.youcode.youQuizV2.Service.MediaService;
import com.youcode.youQuizV2.dto.MediaDto;
import com.youcode.youQuizV2.entities.Media;
import com.youcode.youQuizV2.entities.Question;
import com.youcode.youQuizV2.repositories.MediaRepository;
import com.youcode.youQuizV2.repositories.QuestionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class MediaServiceImpl implements MediaService {
    @Autowired
    private MediaRepository mediaRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MediaDto create(MediaDto mediaDto){
        Media media = modelMapper.map(mediaDto, Media.class);


        if(mediaDto.getQuestion_id() != null){
            Question question = questionRepository.findById(mediaDto.getQuestion_id())
                    .orElseThrow(()-> new EntityNotFoundException("Question not found"));
            media.setQuestion(question);
        }

        media = mediaRepository.save(media);
        return modelMapper.map(media, MediaDto.class);
    }

    @Override
    public void delete(Integer id){
        Media media = mediaRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Question not found with id "+id));
        mediaRepository.delete(media);
    }

    @Override
    public MediaDto getOne(Integer id){
        Media media = mediaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Media not found with id "+id));
        return modelMapper.map(media, MediaDto.class);
    }

    @Override
    public MediaDto getByQuestion(Long question_id){
        Question question = modelMapper.map(questionRepository.findById(question_id), Question.class);
        Media media = mediaRepository.findByQuestion(question);
        return modelMapper.map(media, MediaDto.class);
    }
}
