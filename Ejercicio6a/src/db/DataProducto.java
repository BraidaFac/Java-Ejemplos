package db;
import entities.*;
import io.Menu;
import io.Menu2;

import java.sql.*;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class DataProducto {
		
		public LinkedList<Product> getAll(){
			
			Statement stmt=null;
			ResultSet rs=null;
			LinkedList<Product> productos= new LinkedList<>();
			
			try {
				stmt= DataBase.getInstancia().getConn().createStatement();
				rs= stmt.executeQuery("select id, nombre, price ,disabledOn from product");
				//intencionalmente no se recupera la password
				if(rs!=null) {
					while(rs.next()) {
						Product p=new Product();
						p.setId(rs.getInt("id"));
						p.setName(rs.getString("nombre"));
						p.setPrice(rs.getDouble("price"));
						p.setDate(rs.getDate("disabledOn"));
						productos.add(p);
					}
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			} finally {
				try {
					if(rs!=null) {rs.close();}
					if(stmt!=null) {stmt.close();}
					DataBase.getInstancia().releaseConn();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			
			return productos;
		}
		
		public Product getByID(Integer id) {
			Product p=null;
			PreparedStatement stmt=null;
			ResultSet rs=null;
			try {
				stmt=DataBase.getInstancia().getConn().prepareStatement
						("select id, nombre,price,stock, disabledOn from product where id=?"
						);
				stmt.setInt(1, id);
				rs=stmt.executeQuery();
				if(rs!=null && rs.next()) {
					p=new Product();
					p.setId(rs.getInt("id"));
					p.setName(rs.getString("nombre"));
					p.setPrice(rs.getDouble("price"));
					p.setDate(rs.getDate("disabledOn"));
			
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs!=null) {rs.close();}
					if(stmt!=null) {stmt.close();}
					DataBase.getInstancia().releaseConn();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			return p;
		}
		
		public void delete(Integer id) {
			PreparedStatement stmt= null;
		try {
			stmt=DataBase.getInstancia().getConn().prepareStatement("delete from product where id=?");
			stmt.setInt(1,id);
			stmt.executeUpdate();
				
	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt!=null) {stmt.close();}
				DataBase.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			
			}
		public Product add(Product p) {
			PreparedStatement stmt= null;
			ResultSet keyResultSet=null;
			try {
				stmt=DataBase.getInstancia().getConn().
						prepareStatement(
								"insert into product(nombre,descripcion,price,stock,shippingincluded,disabledOn) values(?,?,?,?,?,CURDATE())",
								PreparedStatement.RETURN_GENERATED_KEYS
								);
				stmt.setString(1, p.getName());
				stmt.setDouble(3, p.getPrice());
				stmt.setString(2, p.getDescripcion());
				stmt.setInt(4, p.getStock());
				stmt.setBoolean(5, p.isShippingIncluded());
				stmt.executeUpdate();
				
				keyResultSet=stmt.getGeneratedKeys();
	            if(keyResultSet!=null && keyResultSet.next()){
	                p.setId(keyResultSet.getInt(1)); //Preguntar porque no se puede usar el id
	              
	            }

				
			}  catch (SQLException e) {
	            e.printStackTrace();
			} finally {
	            try {
	                if(keyResultSet!=null)keyResultSet.close();
	                if(stmt!=null)stmt.close();
	                DataBase.getInstancia().releaseConn();
	            } catch (SQLException e) {
	            	e.printStackTrace();
	            }
			}
			return p;
	    }
	
		public Product actualizar(Product p) {
			PreparedStatement stmt= null;	

			try {
	
				stmt=DataBase.getInstancia().getConn().
						prepareStatement(
								"update product set nombre=?,descripcion=?,price=?,stock=?,shippingincluded=?,disabledOn=CURDATE() where id=?"
								
								);
				stmt.setInt(6, p.getId());
				stmt.setString(1, p.getName());
				stmt.setString(2, p.getDescripcion());
				stmt.setDouble(3, p.getPrice());
				stmt.setInt(4, p.getStock());
				stmt.setBoolean(5, p.isShippingIncluded());
				stmt.executeUpdate();
				 
				
				
	           
				
			}  catch (SQLException e) {
	            e.printStackTrace();
			} finally {
	            try {
	            	
	                if(stmt!=null)stmt.close();
	                DataBase.getInstancia().releaseConn();
	            } catch (SQLException e) {
	            	
	            	e.printStackTrace();
	            	
	            }
			}
			return p;
		}
		
		
		}
			

