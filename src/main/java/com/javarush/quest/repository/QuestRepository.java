package com.javarush.quest.repository;

import com.javarush.quest.entity.Answer;
import com.javarush.quest.entity.Quest;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class QuestRepository {
    AnswerRepository answerRepository = new AnswerRepository();
    private List<Quest> questList = Arrays.asList(
            new Quest(1L,"Компьютер корабля прервал рейс, обнаружив исходящий с этой планеты постоянно повторяющийся " +
                    "радиосигнал неизвестного, предположительно просьбу о помощи.",Arrays.asList(
                      answerRepository.getAnswerById(11L),answerRepository.getAnswerById(12L))),
            new Quest(21L,"Ваша команда вернулась с экспедиции, но один из них поражён неизвестным биологическим организмом," +
                    " офицер безопасности, отказывается пустить группу на борт.",Arrays.asList(
                      answerRepository.getAnswerById(211L),answerRepository.getAnswerById(212L))),
            new Quest(211L,"Во время суточного карантина у пораженного члена экипажа начинаются конвульсии, из его тела " +
                    "выбиралось и быстро скрылось в глубине маленькое существо.",Arrays.asList(
                            answerRepository.getAnswerById(2111L))),
            new Quest(22L,"Бортовой компьютер частично расшифровал загадочный сигнал, и выяснил, что это не просьба о помощи, " +
                    "а предупреждение об опасности.",Arrays.asList(
                            answerRepository.getAnswerById(221L))),
            new Quest(3L,"После успешного старта в  сторону Земли, экипаж готовится вновь лечь в криокамеры, но " +
                    "во время обеда у пораженного члена экипажа начинаются конвульсии, и из его тела выбиралось и быстро " +
                    "скрылось в глубине отсеков существо размером с кошку.",Arrays.asList(
                            answerRepository.getAnswerById(31L),answerRepository.getAnswerById(32L))),
            new Quest(4L,"В результате обнаруживается, что существо выросло в совершенный организм " +
                    "и убило трёх отделившихся членов экипажа.",Arrays.asList(
                            answerRepository.getAnswerById(41L),answerRepository.getAnswerById(42L))),
            new Quest(221L,"ПОЗДРАВЛЯЕМ!",Arrays.asList(
                    answerRepository.getAnswerById(2210L))),
            new Quest(2111L,"ПОЗДРАВЛЯЕМ!",Arrays.asList(
                    answerRepository.getAnswerById(21110L))),
            new Quest(32L,"ПОЗДРАВЛЯЕМ!",Arrays.asList(
                    answerRepository.getAnswerById(320L))),
            new Quest(41L,"ВЫ УВОЛЕНЫ!",Arrays.asList(
                    answerRepository.getAnswerById(410L))),
            new Quest(42L,"ПОЗДРАВЛЯЕМ!",Arrays.asList(
                    answerRepository.getAnswerById(420L)))

    );
    public Quest getQuestById(Long id){
        Quest rQuest=null;
        for(Quest quest:questList){
            if(quest.getId().equals(id)){
                rQuest=quest;
            }
        }
        return rQuest;
    }
}
