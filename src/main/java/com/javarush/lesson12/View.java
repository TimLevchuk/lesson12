package com.javarush.lesson12;

import com.javarush.lesson12.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(urlPatterns = "/view")
public class View extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String html = getHtml(req);
        resp.getWriter().println(html);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/");

    }

    private String getHtml (HttpServletRequest req){
        Object oUser = req.getAttribute("user");
        User user = new User("","");
        if(oUser != null){
            user = (User) oUser;
        }

        return """
                    <!DOCTYPE html>
                    <html lang="en">
                    <head>
                        <meta charset="UTF-8">
                        <title>Hello Servlet</title>
                    </head>
                    <body>
                     <form method="POST">
                        <p><input type="text" value="%s" name="login">
                        <p><input type="password" value="%s" name="password">
                        <p><input type="submit" name="OK">
                     </form>
                    </body>
                    </html>
                    """.formatted(user.getLogin(), user.getPassword());
    }

}
