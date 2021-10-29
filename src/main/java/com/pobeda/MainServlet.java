package com.pobeda;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/")
public class MainServlet extends HttpServlet {





    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        final User user = new User(1,"Alex", 33);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("user_json.json"), user);
        User user1 = mapper.readValue(new File("user_json.json"), User.class);

        PrintWriter printWriter = resp.getWriter();
        final String json = new ObjectMapper().writeValueAsString(user1);
        printWriter.write(json);
        printWriter.close();

    }
}
