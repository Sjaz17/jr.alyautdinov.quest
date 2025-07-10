package com.javarush.quest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarush.quest.entity.Quest;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestService {
    private Map<Integer,Quest> questions = new HashMap<>();

    public QuestService(){
        loadQuestions();
    }

    private void loadQuestions() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("questions.json");
            QuestionList questionList = mapper.readValue(inputStream, QuestionList.class);

            questionList.getQuestions().forEach(q -> questions.put(q.getId(), q));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String getName(String playerName,Object name){
        if(name!=null){
            playerName= (String) name;
        }
        return playerName;
    }
    public Quest getQuest(Integer chosen){

        return questions.get(chosen);
    }
    public int getStage(Integer chosen){
        if(questions.get(chosen).getText().equals("ПОЗДРАВЛЯЕМ!")||questions.get(chosen).getText().equals("ВЫ УВОЛЕНЫ!")){
            return 0;
        }else {
            return 1;
        }
    }
    public int getCounter(Integer chosen,Object questCounter){
        int counter=0;
        if(questCounter!=null){
            counter = (int) questCounter;
            if (chosen==1) {
                counter++;
            }
        }else {
            counter=1;
        }
        return counter;
    }
    public int getSuccess(Integer chosen,Object successCounter){
        int success=0;
        if(successCounter!=null) {
            success= (int) successCounter;
            if (questions.get(chosen).getText().equals("ПОЗДРАВЛЯЕМ!")) {
                success++;
            }
        }
        return success;
    }
    private static class QuestionList {
        private List<Quest> questions;

        public List<Quest> getQuestions() { return questions; }
    }
}
