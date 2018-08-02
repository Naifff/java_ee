package ru.geekbrains.enterprise.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = Error404Handler.NAME, urlPatterns = {"/Error404Handler"})
public class Error404Handler extends HttpServlet {
    public static final String NAME = "Error404Handler";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("123", new Date());
        req.getSession().getAttribute("123");

        try ( PrintWriter out = resp . getWriter ()) {
            out . println ( "<!DOCTYPE html>" );
            out . println ( "<html>" );
            out . println ( "<head>" );
            out . println ( "<title>Ошибка!</title>" );
            out . println ( "</head>" );
            out . println ( "<body>" );
            out . println ( "<h1>Ошибка 404. Страница не найдена!</h1>" );
            out . println ( "</body>" );
            out . println ( "</html>" );
        }
    }

}
