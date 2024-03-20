package com.javarush.lesson12;

import com.javarush.lesson12.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

 @WebServlet(urlPatterns = "/")

public class Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view");
        requestDispatcher.include(req, resp);
    }

     @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String login = req.getParameter("login")==null
                 ?""
                 :req.getParameter("login");

         String password = req.getParameter("password")==null
                 ?""
                 :req.getParameter("password");
         User user = new User(login, password);
         req.setAttribute("user", user);
         RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view");
         requestDispatcher.include(req, resp);
     }


 }
