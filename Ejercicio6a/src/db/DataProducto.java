package db;
import entities.*;
import java.sql.*;
import java.util.LinkedList;

import com.mysql.cj.MysqlType;

import java.time.*;



public class DataProducto {
//		private void DataTimeFormatter() {
//			// TODO Auto-generated method stub
//
//		} Pasa de un tipo fecha a base de dato; AVERIGUAR
		public LinkedList<Product> getAll(){
			
			Statement stmt=null;
			ResultSet rs=null;
			LinkedList<Product> productos= new LinkedList<>();
			
			try {
				stmt= DataBase.getInstancia().getConn().createStatement();
				rs= stmt.executeQuery("select * from product");
				//intencionalmente no se recupera la password
				
					while(rs.next()&rs!=null) {
						Product p=new Product();
						p.setId(rs.getInt("id"));
						p.setName(rs.getString("nombre"));
						p.setPrice(rs.getDouble("price"));
//						si traemos de la DB un registro que tenga null el campo disabledOn
						// va a tirar la excepcion NullPointerExcepcion ya que disabledOn esta null 
						//y le mandamos a null el metodo .tolocalDataTime..
//						p.setDisabledOn(rs.getTimestamp("disabledOn").toLocalDateTime());
//						p.setDisabledDate(rs.getDate("disabledDate").toLocalDate());
//						p.setDisabledTime(rs.getTime("disabledTime").toLocalTime());
						// una solucion es::
//						Timestamp t= rs.getTimestamp("disabledOn");
//						LocalDateTime dt= null;
////						p.setDisabledOn(t==null?null:t.toLocalDateTime());//operador ternario resultado = (condicion)?valor1:valor2;
//						if(t!=null) {
//							dt=t.toLocalDateTime();
//						}
//						p.setDisabledOn(dt);
						//LA SOLUCION MAS ADECUADA ES:::
						p.setDisabledOn(rs.getObject("disabledOn", LocalDateTime.class));// es una sobrecarga del metodo getObject, que le pasaas el nombre de la columna y a la clase que tiene que castear el objeto.
						p.setDisabledDate(rs.getObject("disabledDate", LocalDate.class));
						p.setDisabledTime(rs.getObject("disabledTime", LocalTime.class));
						p.setDisabledOnZoned(rs.getObject("disabledOnZoneDataTime", ZonedDateTime.class));
						productos.add(p);
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
		
		public Product getByID(Product prod) {
			
			PreparedStatement stmt=null;
			ResultSet rs=null;
			try {
				Product p=null;
				stmt=DataBase.getInstancia().getConn().prepareStatement
						("select * from product where id=?"
						);
				stmt.setInt(1, prod.getId());
				rs=stmt.executeQuery();
				if(rs!=null && rs.next()) {
					//MAPEAR
					p=new Product();
					p.setId(rs.getInt("id"));
					p.setName(rs.getString("nombre"));
					p.setPrice(rs.getDouble("price"));
//					p.setDisabledOn(rs.getTimestamp("disabledOn").toLocalDateTime());
//					p.setDisabledDate(rs.getDate("disabledDate").toLocalDate());
//					p.setDisabledTime(rs.getTime("disabledTime").toLocalTime());
					p.setDisabledOn(rs.getObject("disabledOn",LocalDateTime.class));//esto no es un casteo sino un parseo. hay diferencia
					p.setDisabledDate(rs.getObject("disabledDate", LocalDate.class));
					p.setDisabledTime(rs.getObject("disabledTime", LocalTime.class));
					p.setDisabledOnZoned(rs.getObject("disabledOnZoneDataTime", ZonedDateTime.class));
				}
				return p;
			
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}finally {
				try {
					if(rs!=null) {rs.close();}
					if(stmt!=null) {stmt.close();}
					DataBase.getInstancia().releaseConn();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		public void delete(Product p) {
			PreparedStatement stmt= null;
		try {
			stmt=DataBase.getInstancia().getConn().prepareStatement("delete from product where id=?");
			stmt.setInt(1,p.getId());
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
								"insert into product(nombre,descripcion,price,stock,shippingincluded,disabledOn,disabledDate, disabledTime,disabledOnZoneDataTime) values(?,?,?,?,?,?,?,?,?)",
								PreparedStatement.RETURN_GENERATED_KEYS
								);
				stmt.setString(1, p.getName());
				stmt.setDouble(3, p.getPrice());
				stmt.setString(2, p.getDescripcion());
				stmt.setInt(4, p.getStock());
				stmt.setBoolean(5, p.isShippingIncluded());
				stmt.setObject(6, p.getDisabledOn());
				stmt.setObject(7, p.getDisabledDate());
				stmt.setObject(8 , p.getDisabledTime());
				stmt.setObject(9, p.getDisabledOnZoned());
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
								"update product "
								+ "set nombre=?,descripcion=?,price=?,stock=?,shippingincluded=?,disabledOn, disabledDate, disabledTime,disabledOnZoneDataTime "
								+ "where id=?"
								
								);
				stmt.setInt(6, p.getId());
				stmt.setString(1, p.getName());
				stmt.setString(2, p.getDescripcion());
				stmt.setDouble(3, p.getPrice());
				stmt.setInt(4, p.getStock());
				stmt.setBoolean(5, p.isShippingIncluded());
				//se puede especificar el tipo de dato si no funciona
//				stmt.setObject(6, p.getDisabledOn(),MysqlType.DATETIME);
				stmt.setObject(6, p.getDisabledOn());
				stmt.setObject(7, p.getDisabledDate());
				stmt.setObject(8, p.getDisabledTime());
				stmt.setObject(9, p.getDisabledOnZoned());
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
			

