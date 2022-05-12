package entities;

import java.sql.Date;

public class Product {
	private int id;
	private String name;
	private String descripcion;
	private double price;
	private int stock;
	private boolean shippingIncluded;
	private Date disabledOn;
	
	
	//GETTERS AND SETTER
	public Date getDate() {
		return disabledOn;
	}
	public void setDate(Date disabledOn) {
		this.disabledOn=disabledOn;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public boolean isShippingIncluded() {
		return shippingIncluded;
	}
	public void setShippingIncluded(boolean shippingIncluded) {
		this.shippingIncluded = shippingIncluded;
	}
	
	//CONSTRUCTOR
//	public Product() {
//		
//	};
//	public Product( String name, String descripcion, double price, int stock, boolean shippingIncluded) {
//		super();
//		this.name = name;
//		this.descripcion = descripcion;
//		this.price = price;
//		this.stock = stock;
//		this.shippingIncluded = shippingIncluded;
//	}
	
	
	
	
@Override
	public String	toString() {
	return "\n Producto:: [id:: " + id+ " Nombre:: "+ name+ " Precio:: $"+price+" Fecha:: "+ disabledOn+"]";
}
public String	toString2() {
	return "\n Producto:: [id:: " + id+ " Nombre:: "+ name+" descripcion:: "+descripcion +" precio:: $"+price+" stock:: "+ stock+" Incluye envio:: "+ shippingIncluded+"Fecha carga"+ disabledOn+"]";
}
	
	

}
  