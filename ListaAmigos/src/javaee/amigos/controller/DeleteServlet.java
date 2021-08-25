package javaee.amigos.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaee.amigos.dao.DAOFactory;
import javaee.amigos.model.Amigo;

//@WebServlet("/DeleteServlet")


@WebServlet(name = "DeleteServlet", urlPatterns = {"/DeleteServlet"})


public class DeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	// Recogemos el valor pasado desde el formulario.
    	String nombre = request.getParameter("nombre");
    	// Debieramos de buscar el registro en la persistencia. Como no hay creamos un registro ficticio con el nombre recibido
        
    	Amigo friend = new Amigo();
    	
    	//AmigoDAO friendDao = new AmigoDAO();
    	DAOFactory friendDao = new DAOFactory();
    	
//        String action = request.getParameter("action"); 	
    	
	      friend.setNombre(nombre);    	
	      friendDao.eliminar(friend);  
      
        ServletConfig config = getServletConfig();        
//        ServletContext context = config.getServletContext();        
        
        if (friend != null && !friend.getNombre().equals("")) {
        
//      if (action.equalsIgnoreCase("borrar")) {
            request.setAttribute("friendDao", friendDao);
            request.setAttribute("message", "ha sido borrado con éxito.");
        	request.getRequestDispatcher("successForm.jsp").forward(request, response);            
//            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(context.getInitParameter("successForm"));
           // dispatcher.forward(request, response);
        } else {
           // RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(context.getInitParameter("errorForm"));
         //   dispatcher.forward(request, response);
        	request.getRequestDispatcher("errorForm.html").forward(request, response);        	
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	processRequest(request, response);
    }
}
