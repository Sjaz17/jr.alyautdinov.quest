package com.javarush.quest.repository;

import com.javarush.quest.entity.Quest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuestRepositoryTest {

    @Test
    void getQuestById() {
        QuestRepository questRepository = new QuestRepository();
        AnswerRepository answerRepository = new AnswerRepository();
        Quest quest =new Quest(42L,"ПОЗДРАВЛЯЕМ!", Arrays.asList(answerRepository.getAnswerById(420L)));
        assertEquals(quest,questRepository.getQuestById(42L));
        assertNull(questRepository.getQuestById(0L));
    }
}