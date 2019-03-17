package org.xworkz.hibernateController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.xworkz.hibernate.dao.MovieReviewDAO;
import org.xworkz.hibernate.dto.MovieReviewDTO;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/SimpleServlet")
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SimpleServlet() {
        super();
    }


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Come..................");
		System.out.println("Recommanding is "+Boolean.parseBoolean(request.getParameter("recommanding")));
		System.out.println("Data "+request.getParameter("recommanding"));
		String movieName = request.getParameter("movie name");
		String language = request.getParameter("language");
		long budget = Long.parseLong(request.getParameter("budget"));
		int rating = Integer.parseInt(request.getParameter("rating"));
		boolean recommanding = Boolean.parseBoolean(request.getParameter("recommanding"));
		
		MovieReviewDTO dto = new MovieReviewDTO();
		dto.setName(movieName);
		dto.setLanguage(language);
		dto.setBudget(budget);
		dto.setRating(rating);
		dto.setRecommanding(recommanding);
		
		System.out.println("Controller DTO is "+dto);
		MovieReviewDAO dao = new MovieReviewDAO();
		boolean res= dao.save(dto);
		if(res) {
			PrintWriter pw = response.getWriter();
			pw.print("<html><body>" + "<center>"
	                + "Details Added Successfully to db" + "</center>" + "</body></html>");
		}else {
			PrintWriter pw = response.getWriter();
			pw.print("<html><body>" + "<center>"
	                + "Details is not Added Successfully" + "</center>"
	                + "</body></html>");
		}
	}

    

}
