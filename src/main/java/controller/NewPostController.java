package controller;

import config.TemplateEngineUtil;
import model.BlogPost;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(urlPatterns = {"/newpost"})
public class NewPostController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        engine.process("newpost.html", context, resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String photo = req.getParameter("photo");
        String text = req.getParameter("text");

        System.out.printf("Data is got is %s, %s, %s%n", title, photo, text);

        BlogPost post = new BlogPost("Pogány Csörsz", title, LocalDate.now(), text, photo);


        resp.sendRedirect("/blog");
    }


}
