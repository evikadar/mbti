package controller;

import config.TemplateEngineUtil;
import model.CognitiveRoles;
import model.MBTIType;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(urlPatterns = {"/main"})
public class IndexController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        engine.process("index.html", context, resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String person1 = req.getParameter("person1");
        String person2 = req.getParameter("person2");
        HashMap<CognitiveRoles, String> functionStack1 = MBTIType.getFunctionStack(person1);
        HashMap<CognitiveRoles, String> functionStack2 = MBTIType.getFunctionStack(person2);

        int distance = MBTIType.calculateDistances(functionStack1, functionStack2);
        int matchPercentage = MBTIType.getPercentage(distance);

        String hero1 = functionStack1.get(CognitiveRoles.HERO);
        String parent1 = functionStack1.get(CognitiveRoles.PARENT);
        String child1 = functionStack1.get(CognitiveRoles.CHILD);
        String inferior1 = functionStack1.get(CognitiveRoles.INFERIOR);
        String nemesis1 = functionStack1.get(CognitiveRoles.NEMESIS);
        String criticalParent1 = functionStack1.get(CognitiveRoles.CRITICAL_PARENT);
        String trickster1 = functionStack1.get(CognitiveRoles.TRICKSTER);
        String demon1 = functionStack1.get(CognitiveRoles.DEMON);

        String hero2 = functionStack2.get(CognitiveRoles.HERO);
        String parent2 = functionStack2.get(CognitiveRoles.PARENT);
        String child2 = functionStack2.get(CognitiveRoles.CHILD);
        String inferior2 = functionStack2.get(CognitiveRoles.INFERIOR);
        String nemesis2 = functionStack2.get(CognitiveRoles.NEMESIS);
        String criticalParent2 = functionStack2.get(CognitiveRoles.CRITICAL_PARENT);
        String trickster2 = functionStack2.get(CognitiveRoles.TRICKSTER);
        String demon2 = functionStack2.get(CognitiveRoles.DEMON);

        HttpSession session = req.getSession(true);
        session.setAttribute("pairOfHero1", MBTIType.getItsPair(hero1));
        session.setAttribute("matchNr", matchPercentage);
        session.setAttribute("person1", person1);
        session.setAttribute("person2", person2);
        session.setAttribute("hero1", hero1);
        session.setAttribute("parent1", parent1);
        session.setAttribute("child1", child1);
        session.setAttribute("inferior1", inferior1);
        session.setAttribute("nemesis1", nemesis1);
        session.setAttribute("criticalParent1", criticalParent1);
        session.setAttribute("trickster1", trickster1);
        session.setAttribute("demon1", demon1);
        session.setAttribute("hero2", hero2);
        session.setAttribute("parent2", parent2);
        session.setAttribute("child2", child2);
        session.setAttribute("inferior2", inferior2);
        session.setAttribute("nemesis2", nemesis2);
        session.setAttribute("criticalParent2", criticalParent2);
        session.setAttribute("trickster2", trickster2);
        session.setAttribute("demon2", demon2);
        resp.sendRedirect("/main#projects");
    }
}
