package ru.volnenko.enterprise.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;



@WebServlet(name = Catalog.NAME, urlPatterns = {"/Catalog"})
public class Catalog extends HttpServlet {

    public static final String NAME = "Catalog";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("123", new Date());
        req.getSession().getAttribute("123");

        try (PrintWriter writer = resp.getWriter()){
            writer.println("<html><head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta name=\"viewport\"\n" +
                    "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                    "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                    "    <title>I AM Catalog SERVLET!</title>\n" +
                    "    <link rel=\"stylesheet\" href=\"style.css\">\n" +
                    "</head>\n<body>" +
                    "<body>" +
                    " <ul>" +
                    "<li><a href=\"/example/Cart\">Cart</a></li>" +
                    " <li><a href=\"/example/Catalog\">Catalog</a></li>" +
                    " <li><a href=\"/example/Main\">Main</a></li>" +
                    " <li><a href=\"/example/Order\">Order</a></li>" +
                    " <li><a href=\"/example/Product\">Product</a></li>" +
                    " </ul>" +
                    "</body>" +
                    "</html>");
        }
    }

}