package com.javarush.quest;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.javarush.quest.entity.Answer;
import com.javarush.quest.entity.Quest;
import com.javarush.quest.repository.QuestRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.Builder;
import lombok.Data;

@WebServlet(name = "QuestServlet", value = "/quest-servlet")
public class QuestServlet extends HttpServlet {
    private Long chosen;
    private Quest quest;
    QuestRepository questRepository = new QuestRepository();


    public void init() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String  playerName=request.getParameter("name");
        if(playerName==null){
            playerName = (String) session.getAttribute("name");
        }
        session.setAttribute("name",playerName);
        chosen = Long.parseLong(request.getParameter("chosen").replace("L", ""));
        Integer gameCounter= (Integer) session.getAttribute("gameCounter");
        if(gameCounter==null){
            session.setAttribute("gameCounter",1);
            gameCounter=1;
        } else if (chosen.equals(1L)) {
            gameCounter++;
            session.setAttribute("gameCounter",gameCounter);
        }else {
            session.setAttribute("gameCounter",gameCounter);
        }
        quest = questRepository.getQuestById(chosen);
        Integer questSuccess= (Integer) session.getAttribute("success");
        if(questSuccess==null){
            session.setAttribute("success",0);
            questSuccess=0;
        } else if (quest.getText().equals("ПОЗДРАВЛЯЕМ!")) {
            questSuccess++;
            session.setAttribute("success",questSuccess);
        }else {
            session.setAttribute("success",questSuccess);
        }
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        if (quest.getText().equals("ПОЗДРАВЛЯЕМ!") || quest.getText().equals("ВЫ УВОЛЕНЫ!")) {
            writer.write("<html><head>");
            writer.write(" <title>Quest ended</title>");
            writer.write("  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\n" +
                    "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\" crossorigin=\"anonymous\"></script>" +
                    "<style>\n" +
                    "        body{\n" +
                    "            margin-left: 16px;\n" +
                    "        }\n" +
                    "    </style>"+"</head>");
            writer.write("<body>");
            writer.write("<h2>SPACEQUEST</h2>");
            if(quest.getText().equals("ПОЗДРАВЛЯЕМ!")) {
                writer.write("<p class=\"text-success fs-3\">" + quest.getText() + "<p>");
                writer.write("<p class=\"text-success fs-5\">"+quest.getAnswers().get(0).getText()+"<p>");
            }else {
                writer.write("<p class=\"text-danger fs-3\">" + quest.getText() + "<p>");
                writer.write("<p class=\"text-danger fs-5\">"+quest.getAnswers().get(0).getText()+"<p>");
            }
            writer.write("<form  action=\"quest-servlet\">\n" +
                    "            <button value=\"1L\" name=\"chosen\" type=\"submit\" class=\"btn btn-outline-success\">Пройти еще раз</button>\n" +
                    "        </form>");
            writer.write("<p class=\"lead\">");
            writer.write("Статистика игрока: "+playerName+"<br>");
            writer.write("Попытка: "+gameCounter+"<br>");
            writer.write("Успешных доставок: "+questSuccess);
            writer.write("</p>");
            writer.write("</body></html>");
        } else {
            writer.write("<html><head>");
            writer.write(" <title>Quest started</title>");
            writer.write("  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\n" +
                    "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\" crossorigin=\"anonymous\"></script>" +
                    "<style>\n" +
                    "        body{\n" +
                    "            margin-left: 16px;\n" +
                    "        }\n" +
                    "    </style>"+"</head>");
            writer.write("<body>");
            writer.write("<h2>SPACEQUEST</h2>");
            writer.write("<p class=\"lead\">" + quest.getText() + "</p>");
            writer.write("<div> <form action=\"quest-servlet\"method=\"get\"> " +
                    "<p class=\"lead\">Ваши приказания?</p>");
            for (Answer answer: quest.getAnswers()) {
                writer.write("<div class=\"form-check\">\n" +
                        "       <input class=\"form-check-input\" type=\"radio\" name=\"chosen\" id=\"this\" checked value=" + answer.getIdQuest() +">"+
                        "       <label class=\"form-check-label\" for=\"this\">" +"<p class=\"lead\">"+ answer.getText()+"</p>" + "</label>\n" +
                        "       </div>");
            }
            writer.write("<button id=\"submit\" type=\"submit\" class=\"btn btn-outline-secondary\">Подтвердить</button></form>");
            writer.write("</div>");
            writer.write("<p class=\"lead\">");
            writer.write("Статистика игрока: "+playerName+"<br>");
            writer.write("Попытка: "+gameCounter+"<br>");
            writer.write("Успешных доставок: "+questSuccess);
            writer.write("</p>");
            writer.write("</body></html>");
        }
    }

    public void destroy() {
    }
}