package com.youcode.youQuizV2.Service;

import com.youcode.youQuizV2.dto.MediaDto;

public interface MediaService {
    MediaDto create(MediaDto mediaDto);
    void delete(Integer id);
    MediaDto getOne(Integer id);
    MediaDto getByQuestion(Long question_id);
}
