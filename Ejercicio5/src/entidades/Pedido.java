package entidades;
import java.util.LinkedList;

import productos.*;

public class Pedido {
	Cliente cliente;

	Vendedor vendedor;
	LinkedList<Producto> ventas= new LinkedList<>();
	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	public void seleccionarCliente(Cliente cliente)
	{
		this.setCliente(cliente);
	}
	public void seleccionarVendedor(Vendedor vendedor)
	{
		this.setVendedor(vendedor);
	}
	
	public void agregarProductos(LinkedList<Producto> ventas)
	{
		this.ventas.addAll(ventas);
	}

}
