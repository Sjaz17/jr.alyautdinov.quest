package com.javarush.quest.controller;

import com.javarush.quest.entity.Quest;
import com.javarush.quest.service.QuestService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "ControllerServlet",value = "/controller-servlet")
public class ControllerServlet extends HttpServlet {
    private Integer chosen;
    private Object questCounter;
    private int stage;
    private Object successCounter;
    private Object name;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestService questService =new QuestService();
        HttpSession session = request.getSession();
        //Имя игрока
        name = session.getAttribute("name");
        String playerName =request.getParameter("name");
        playerName=questService.getName(playerName,name);
        session.setAttribute("name",playerName);
        //Выдача квеста
        chosen = Integer.valueOf(request.getParameter("chosen"));
        Quest quest =questService.getQuest(chosen);
        session.setAttribute("quest",quest);
        // Информация о стадии квеста
        stage = questService.getStage(chosen);
        session.setAttribute("stage",stage);
        // Количество прохождений
        questCounter = session.getAttribute("questCounter");
        questCounter =questService.getCounter(chosen,questCounter);
        session.setAttribute("questCounter",questCounter);
        //Счетчик успешных прохождений квеста
        successCounter= session.getAttribute("successCounter");
        successCounter= questService.getSuccess(chosen,successCounter);
        session.setAttribute("successCounter",successCounter);
        //передача данных на quest.jsp
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/quest.jsp");
        requestDispatcher.forward(request, response);
    }
}
