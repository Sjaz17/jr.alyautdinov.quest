package com.javarush.quest.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestServiceTest {

    public static QuestService questService;
    @BeforeAll
    public static void init(){
        questService = new QuestService();
    }

    @Test
    void getName() {
        assertEquals("А",questService.getName("А",null));
        assertEquals("Б",questService.getName("А","Б"));
    }
    @Test
    void getQuest(){
        assertEquals(questService.getQuest(1),questService.getQuest(1));
    }

    @Test
    void getStage() {
        assertEquals(0,questService.getStage(42));
        assertEquals(0,questService.getStage(41));
        assertEquals(1,questService.getStage(1));
    }


    @Test
    void getCounter() {
        assertEquals(1,questService.getCounter(1,null));
        assertEquals(1,questService.getCounter(1,0));
        assertEquals(2,questService.getCounter(4,2));
    }

    @Test
    void getSuccess() {
        assertEquals(0,questService.getSuccess(221,null));
        assertEquals(1,questService.getSuccess(221,0));
        assertEquals(0,questService.getSuccess(41,0));
    }
    @AfterAll
    static void deInit() {
        questService = null;
    }
}