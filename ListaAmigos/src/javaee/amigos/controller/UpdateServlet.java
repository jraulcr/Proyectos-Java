package javaee.amigos.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaee.amigos.dao.DAOFactory;
import javaee.amigos.model.Amigo;

//@WebServlet("/UpdateServlet")


@WebServlet(name = "UpdateServlet", urlPatterns = {"/UpdateServlet"})

public class UpdateServlet extends CreateServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Recoger datos del usuario a modificar.
		

		
		// Buscar registro en persistencia.

		// Recoger todos los datos nuevos a modificar
//		Amigo friend = super.generateAmigoFromRequest(request);
//		ServletConfig config = getServletConfig();
//		ServletContext context = config.getServletContext();
		
		
/*		String nombreAnterior = request.getParameter("nombreAnterior");		
    	String nombre = request.getParameter("nombre");	
    	String direccion = request.getParameter("direccion");
    	String telefono = request.getParameter("telefono");
		int edad = Integer.parseInt(request.getParameter("edad"));
		int nivelAmistad = Integer.parseInt(request.getParameter("nivelAmistad"));
    	String comentarios = request.getParameter("comentarios");*/

//        Amigo friend = generateAmigoFromRequest(request);
//        ServletConfig config = getServletConfig();
//        ServletContext context = config.getServletContext();
        
        
    	Amigo friend = new Amigo();
    	
    	//AmigoDAO friendDao = new AmigoDAO();
    	DAOFactory friendDao = new DAOFactory();
        String action = request.getParameter("action"); 	
    	
	 /*     friend.setNombre(nombre); 
	      friend.setDireccion(direccion);  
	      friend.setTelefono(telefono);  
	      friend.setEdad(edad);  
	      friend.setNivelAmistad(nivelAmistad);  
	      friend.setComentarios(comentarios);  */
	      
	   //   nombreAnterior=nombre;
	      
	      friendDao.actualizar(friend, action);  
		
	    //  friend = super.generateAmigoFromRequest(request);
 
        ServletConfig config = getServletConfig();        
        ServletContext context = config.getServletContext();      
 
        
        
        if (friend != null && !friend.getNombre().equals("")) {
            request.setAttribute("friendDao", friendDao);
            request.setAttribute("message", "ha sido creado con éxito");
            
            request.getRequestDispatcher("successForm.jsp").forward(request, response);  
        	 

//			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(context.getInitParameter("successForm"));
//			dispatcher.forward(request, response);
		} else {
        	request.getRequestDispatcher("errorForm.html").forward(request, response); 
        	
//          RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(context.getInitParameter("errorForm"));
//          dispatcher.forward(request, response);
      }
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
