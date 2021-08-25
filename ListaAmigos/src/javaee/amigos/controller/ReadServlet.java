package javaee.amigos.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaee.amigos.dao.DAOFactory;
import javaee.amigos.model.Amigo;

//@WebServlet("/ReadServlet")


@WebServlet(name = "ReadServlet", urlPatterns = {"/ReadServlet"})

public class ReadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        
        
        // Buscar el registro.
        // Como no tenemos simulamos uno
    //    Amigo friend = getAmigo(nombre);
        

    	Amigo friend = new Amigo();
    	
    	DAOFactory friendDao = new DAOFactory();
 //       String action = request.getParameter("action"); 	
    	
	      friend.setNombre(nombre);    	
	      friendDao.obtener(friend); 
	      

      
  //      ServletConfig config = getServletConfig();        
  //      ServletContext context = config.getServletContext();      
        

        
        if (friend != null && !friend.getNombre().equals("")) {
        	request.setAttribute("friend", friend);
        	
        	
        	request.getRequestDispatcher("successForm.jsp").forward(request, response);   
        	
        	
          //  RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(context.getInitParameter("displayForm"));
            
          //  dispatcher.forward(request, response);
        } else {
        	
        	request.getRequestDispatcher("errorForm.html").forward(request, response);               	
        	
//            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(context.getInitParameter("errorForm"));
//            
//            dispatcher.forward(request, response);
        }
    }

/*	private Amigo getAmigo(String nombre) {
		Amigo friend = new Amigo();
        friend.setNombre(nombre);
        friend.setDireccion("una direccion");
        friend.setComentarios("un comentario");
        friend.setTelefono("666777888");
        friend.setEdad(33);
        friend.setNivelAmistad(4);
		return friend;
	}*/
    
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
