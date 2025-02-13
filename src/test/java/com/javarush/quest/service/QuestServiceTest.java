package com.javarush.quest.service;

import com.javarush.quest.entity.Answer;
import com.javarush.quest.repository.AnswerRepository;
import com.javarush.quest.repository.QuestRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuestServiceTest {

    public static QuestRepository questRepository;
    public static QuestService questService;
    @BeforeAll
    public static void init(){
        questRepository=new QuestRepository();
        questService = new QuestService();
    }

    @Test
    void getName() {
        assertEquals("А",questService.getName("А",null));
        assertEquals("Б",questService.getName("А","Б"));
    }
    @Test
    void getQuest(){
        assertEquals(questRepository.getQuestById(1L),questService.getQuest(1L));
    }

    @Test
    void getStage() {
        assertEquals(0,questService.getStage(42L));
        assertEquals(0,questService.getStage(41L));
        assertEquals(1,questService.getStage(1L));
    }


    @Test
    void getCounter() {
        assertEquals(1,questService.getCounter(1L,null));
        assertEquals(1,questService.getCounter(1L,0));
        assertEquals(2,questService.getCounter(41L,2));
    }

    @Test
    void getSuccess() {
        assertEquals(0,questService.getSuccess(221L,null));
        assertEquals(1,questService.getSuccess(221L,0));
        assertEquals(0,questService.getSuccess(41L,0));
    }
    @AfterAll
    static void deInit() {
        questService = null;
        questRepository = null;
    }
}