package fr.eseo.criticalPfe.servlets.masterisation.personnage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eseo.criticalPfe.java.bo.attribut.SortBOImpl;
import fr.eseo.criticalPfe.java.model.attributs.Sort;
import fr.eseo.criticalPfe.java.model.entite.Personnage;

/**
 * Servlet implementation class ApprendreSort
 */
@WebServlet("/ApprendreSort")
public class ApprendreSort extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApprendreSort() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ApprendreSort Servlet");
		
		SortBOImpl sortBO = new SortBOImpl();
		Personnage personnage = (Personnage) request.getSession().getAttribute("personnageCourant");
		
		String[] res = request.getParameterValues("sortSelectionnes");
		try { 
		for (int i = 0; i < res.length; ++i){ 
			Sort sort = new Sort();
			sort.setNom(res[i]);
			sort = sortBO.trouverSort(sort);
			
			sortBO.ajouterSort(sort, personnage);
			System.out.println(res[i]); 

		} 
		} catch (Exception e1) { 
		//e1.printStackTrace(); 
		}

        request.getRequestDispatcher("/AfficherFichePersonnage?id="+personnage.getId()).forward(request, response);
	}

}
