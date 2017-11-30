package fr.eseo.criticalPfe.servlets.masterisation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eseo.criticalPfe.java.bo.scenario.UniversBO;
import fr.eseo.criticalPfe.java.model.scenario.Univers;

/**
 * Servlet implementation class CreationUnivers
 */
@WebServlet("/AfficherUnivers")
public class AfficherUnivers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherUnivers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		UniversBO universBO = new UniversBO();
		int idUnivers;
		
		if(request.getParameter("idUnivers")!= null){
			idUnivers = Integer.parseInt(request.getParameter("idUnivers"));
		}else{
			idUnivers = (Integer)session.getAttribute("idUnivers");
		}
		Univers univers = universBO.getUnivers(idUnivers);
		if(univers!=null){
			session.setAttribute("univers", univers);
			response.sendRedirect("/Critical-PFE/site/Masterisation/modificationUnivers.jsp");
		}else{
			response.sendRedirect("/Critical-PFE/AffichageListeUnivers");
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
