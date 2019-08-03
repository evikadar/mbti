package controller;

import config.TemplateEngineUtil;
import model.BlogPost;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import service.BlogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/blog"})
public class BlogController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        List<BlogPost> everyPost = BlogService.findEveryPost();
        context.setVariable("posts", everyPost);
        engine.process("blog.html", context, resp.getWriter());

    }

}
