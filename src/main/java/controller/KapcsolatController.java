package controller;

import config.TemplateEngineUtil;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/kapcsolat"})
public class KapcsolatController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        engine.process("kapcsolat.html", context, resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String phone = req.getParameter("phone-number");
        String email = req.getParameter("email");
        String message = req.getParameter("message");

        System.out.printf("Data is got is %s, %s, %s, %s%n", name, phone, email, message);

        HttpSession session = req.getSession(true);;
        session.setAttribute("name", name);
        session.setAttribute("phone", phone);
        session.setAttribute("email", email);
        session.setAttribute("message", message);

        // todo: kldjön egy üzit megadott emailre a kapott szöveggel

        resp.sendRedirect("/");
    }
}
