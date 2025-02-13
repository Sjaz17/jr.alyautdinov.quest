package com.javarush.quest.service;

import com.javarush.quest.entity.Answer;
import com.javarush.quest.entity.Quest;
import com.javarush.quest.repository.AnswerRepository;
import com.javarush.quest.repository.QuestRepository;

public class QuestService {
    QuestRepository questRepository = new QuestRepository();
    AnswerRepository answerRepository = new AnswerRepository();

    public String getName(String playerName,Object name){
        if(name!=null){
            playerName= (String) name;
        }
        return playerName;
    }
    public Quest getQuest(Long chosen){
        Quest quest = questRepository.getQuestById(chosen);
        return quest;
    }
    public int getStage(Long chosen){
        if(questRepository.getQuestById(chosen).getText().equals("ПОЗДРАВЛЯЕМ!")||questRepository.getQuestById(chosen).getText().equals("ВЫ УВОЛЕНЫ!")){
            return 0;
        }else {
            return 1;
        }
    }
    public int getCounter(Long chosen,Object questCounter){
        int counter=0;
        if(questCounter!=null){
            counter = (int) questCounter;
            if (chosen.equals(1L)) {
                counter++;
            }
        }else {
            counter=1;
        }
        return counter;
    }
    public int getSuccess(Long chosen,Object successCounter){
        int success=0;
        if(successCounter!=null) {
            success= (int) successCounter;
            if (questRepository.getQuestById(chosen).getText().equals("ПОЗДРАВЛЯЕМ!")) {
                success++;
            }
        }
        return success;
    }
}
