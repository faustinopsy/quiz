package br.senai.sp.informatica.quiz;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;


@SuppressWarnings("serial")
@WebServlet("/listarRespostas")
public class listarrespostas extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException { 

String ate18 = WebUtilities.getCookieValue(req,"ate18", "0");
String ate26 = WebUtilities.getCookieValue(req,"ate26", "0");
String ate35 = WebUtilities.getCookieValue(req,"ate35", "0");
String ate99 = WebUtilities.getCookieValue(req,"ate99", "0");

resp.setCharacterEncoding("UTF-8");
ServletContext context = req.getServletContext();
TemplateEngine engine = Template.getEngine(context);
WebContext webContext = new WebContext(req, resp, context);

webContext.setVariable("ate18", ate18);
webContext.setVariable("ate26", ate26);
webContext.setVariable("ate35", ate35);
webContext.setVariable("ate99", ate99);
engine.process("apuracao", webContext,resp.getWriter());
	}
}
