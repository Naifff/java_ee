package ru.volnenko.enterprise.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


@WebServlet(name = TemplateServlet.NAME, urlPatterns = {"/TemplateServlet"})
public class TemplateServlet extends HttpServlet {

    public static final String NAME = "MegaServlet";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("123", new Date());
        req.getSession().getAttribute("123");

        try (PrintWriter writer = resp.getWriter()){
            writer.println("<html><h1>I AM temp SERVLET!</h1>" +
                    "</html>");
        }
    }

}
