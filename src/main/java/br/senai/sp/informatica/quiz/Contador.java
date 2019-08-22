package br.senai.sp.informatica.quiz;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contador")
@SuppressWarnings("serial")
public class Contador extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String idade=req.getParameter("idade");
		
		if(idade==null) {
			resp.sendRedirect("paginaDeErro.html");
		}else {
			int voto= Integer.parseInt(WebUtilities.getCookieValue(req, idade, "0"))+1;
			LongLivedCookie cookie = new LongLivedCookie(idade,String.valueOf(voto));
			resp.addCookie(cookie);
			resp.sendRedirect("paginaDeSucesso.html");
		}
	}
}
