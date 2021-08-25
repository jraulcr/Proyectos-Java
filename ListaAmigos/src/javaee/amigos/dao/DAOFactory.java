package javaee.amigos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaee.amigos.jdbc.AccesoBD;
import javaee.amigos.model.Amigo;



public class DAOFactory implements IAmigoDAO{


	 private Connection connection;
	 private boolean estadoOperacion;
	// private PreparedStatement statement;
	 
	 public DAOFactory() {
	    	connection = AccesoBD.getConectar();
	    }

   
   
	public void registrar(Amigo amigo) {
		
		try {
		
		String query ="insert into amigos (nombre, direccion, telefono, edad, nivelAmistad, comentarios) "
				+ "values ('"+amigo.getNombre()+"','"+amigo.getDireccion()+"','"+amigo.getTelefono()+"','"+amigo.getEdad()+"','"+amigo.getNivelAmistad()+"','"+amigo.getComentarios()+"')";
	
       Statement statement = connection.createStatement();
       statement.executeUpdate(query);

		} catch (SQLException e) {
			System.out.println("Error metodo registrar");
			e.printStackTrace();
		}
	
	}
	
	
	

	public List<Amigo> obtener(Amigo amigo) {

		String query="select * from amigos where amigos.nombre='"+amigo.getNombre()+"' ";
			
		ArrayList<Amigo> listaAmigo= new ArrayList<Amigo>();		
		
		try {
           Statement statement = connection.createStatement();
           statement.execute(query);
		} catch (SQLException e) {
			System.out.println("Error metodo Buscar");
			e.printStackTrace();
		}	
		
		
		
		return listaAmigo;
	}


	public void actualizar(Amigo amigo, String nombreAnterior) {
		PreparedStatement preparedStatement_update=null;
		try {
			connection.setAutoCommit(false);
			String query = "UPDATE amigos SET nombre=?, direccion=?, telefono=?, edad=?, nivelAmistad=?, comentarios=?  WHERE nombre=?";
			
	        //   Statement statement = connection.createStatement();
	                   
	           preparedStatement_update = connection.prepareStatement(query);
	           preparedStatement_update.setString(1,amigo.getNombre());
	           preparedStatement_update.setString(2,amigo.getDireccion());
	           preparedStatement_update.setString(3,amigo.getTelefono());
	           preparedStatement_update.setInt(4,amigo.getEdad());
	           preparedStatement_update.setInt(5,amigo.getNivelAmistad());
	           preparedStatement_update.setString(6,amigo.getComentarios());
	           
	         //  statement.executeUpdate(query);
	           
	           //statement.set;
	          
	      /*     statement.setDouble(3, amigo.getPrecio());
	           statement.setDate(4, amigo.getFechaActualizar());
	           statement.setInt(5, amigo.getId());*/
	         
	           estadoOperacion = preparedStatement_update.executeUpdate(query) > 0;
	           connection.commit();
	           preparedStatement_update.close();
	           connection.close();
	           
	           
		} catch (SQLException e) {
			System.out.println("Error metodo actualizar");
			e.printStackTrace();
		}
		
	/*	String query="update amigos set nombre='"+amigo.getNombre()+"', direccion='"+amigo.getDireccion()+"' , telefono='"+amigo.getTelefono()+"' , edad='"+amigo.getEdad()+"' , nivelAmistad='"+amigo.getNivelAmistad()+"' , comentarios='"+amigo.getComentarios()+"'" +" where nombre='"+nombreAnterior+"'";
		try {
           Statement statement = connection.createStatement();
           statement.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Error metodo actualizar");
			e.printStackTrace();
		}	*/	
	}

	public void eliminar(Amigo amigo) {				
		String query="delete from amigos where amigos.id='"+amigo.getId()+"' ";
		
		try {
           Statement statement = connection.createStatement();
           statement.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Error metodo borrar");
			e.printStackTrace();
		}		
	
	}

	
	
}
