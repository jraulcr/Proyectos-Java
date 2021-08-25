package javaee.amigos.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaee.amigos.dao.DAOFactory;
import javaee.amigos.model.Amigo;

//@WebServlet ("/CreateServlet")

@WebServlet(name = "CreateServlet", urlPatterns = {"/CreateServlet"})

public class CreateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String nombre = request.getParameter("nombre");	
    	String direccion = request.getParameter("direccion");
    	String telefono = request.getParameter("telefono");
		int edad = Integer.parseInt(request.getParameter("edad"));
		int nivelAmistad = Integer.parseInt(request.getParameter("nivelAmistad"));
    	String comentarios = request.getParameter("comentarios");

//        Amigo friend = generateAmigoFromRequest(request);
//        ServletConfig config = getServletConfig();
//        ServletContext context = config.getServletContext();
        
        
    	Amigo friend = new Amigo();
    	
    	DAOFactory friendDao = new DAOFactory();
//        String action = request.getParameter("action"); 	
    	
	      friend.setNombre(nombre); 
	      friend.setDireccion(direccion);  
	      friend.setTelefono(telefono);  
	      friend.setEdad(edad);  
	      friend.setNivelAmistad(nivelAmistad);  
	      friend.setComentarios(comentarios);  
	      
	      friendDao.registrar(friend);  
      
//        ServletConfig config = getServletConfig();        
//        ServletContext context = config.getServletContext();      
 
	     // action.equalsIgnoreCase("registrar")
        if (friend != null && !friend.getNombre().equals("")) {
            request.setAttribute("friendDao", friendDao);
            request.setAttribute("message", "ha sido creado con éxito");
            
            request.getRequestDispatcher("successForm.jsp").forward(request, response);  
        	
        	
        	
//            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(context.getInitParameter("successForm"));
//            dispatcher.forward(request, response);
        } else {
        	
        	request.getRequestDispatcher("errorForm.html").forward(request, response); 
        	
//            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(context.getInitParameter("errorForm"));
//            dispatcher.forward(request, response);
        }
    }

	/**
	 * Recogemos los datos del amigo del formulario y los incluimos en un objeto de tipo Amigo.
	 * @param request
	 * @return
	 * @throws NumberFormatException
	 */
    Amigo generateAmigoFromRequest(HttpServletRequest request) throws NumberFormatException {
        Amigo amigo = new Amigo();
        String nombre = request.getParameter("nombre");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String comentarios = request.getParameter("comentarios");
        String edadString = request.getParameter("edad").trim();
        String nivelAmistadString = request.getParameter("nivelAmistad");

        if (!validarTelefono(telefono)) {
            return null;
        }
        int edad = Integer.parseInt(edadString);
        int nivelAmistad = Integer.parseInt(nivelAmistadString);
        amigo.setNombre(nombre);
        amigo.setTelefono(telefono);
        amigo.setDireccion(direccion);
        amigo.setComentarios(comentarios);
        amigo.setEdad(edad);
        amigo.setNivelAmistad(nivelAmistad);
        return amigo;
    }

    /**
     * Realizamos las validaciones pertinentes
     * @param telefono
     * @return
     */
    private boolean validarTelefono(String telefono) {
        boolean isGoodLength = checkLength(telefono, 9, 15);
        return telefono.matches("([0-9  +])*") && isGoodLength;
    }
    
    /**
     * Realizamos las validaciones pertinentes
     * @param data
     * @param minAceptable
     * @param maxAceptable
     * @return
     */
    private boolean checkLength(String data, int minAceptable, int maxAceptable) {
        int length = data.length();
        boolean isGoodLength = length >= minAceptable && length <= maxAceptable;
        return isGoodLength;
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
