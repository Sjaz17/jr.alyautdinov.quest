package com.javarush.quest.repository;

import com.javarush.quest.entity.Answer;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class AnswerRepositoryTest {

    @Test
    void getAnswerById() {
        AnswerRepository answerRepository = new AnswerRepository();
        Answer answer = new Answer(12L,"Подождать расшифровку сигнала",22L);
        assertEquals(answer,answerRepository.getAnswerById(12L));
        assertNull(answerRepository.getAnswerById(0L));
    }
}