package controller;

import config.TemplateEngineUtil;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Properties;

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

        HttpSession httpSession = req.getSession(true);;
        httpSession.setAttribute("name", name);
        httpSession.setAttribute("phone", phone);
        httpSession.setAttribute("email", email);
        httpSession.setAttribute("message", message);

        // todo: kldjön egy üzit megadott emailre a kapott szöveggel

        String msg = String.format("Sender: %s%n Email: %s%n Phone: %s%n Message: %s%n", name, email, phone, message);
        String from = "evi.kadar@gmail.com";
        String pw = "uasvximldvzouyai";
        String to = "pcsorsz@gmail.com";
        String subject = "Új üzenetet kaptál a szellemszikrák weboldalon <3";

        send(from, pw, to, subject, msg);

        resp.sendRedirect("/");
    }

    public void send(final String from, final String password, String to, String sub, String msg){
        //Get properties object
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        //get Session
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from,password);
                    }
                });
        //compose message
        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject(sub);
            message.setText(msg);
            //send message
            Transport.send(message);
            System.out.println("message sent successfully");
        } catch (MessagingException e) {throw new RuntimeException(e);}

    }




}
