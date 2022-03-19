package model;

import java.io.Serializable;
import java.util.Random;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import enums.Category;

@XmlRootElement(name = "Copia")
@XmlAccessorType(XmlAccessType.FIELD)
public class Copia extends Product implements Serializable{
	
	@XmlAttribute(name = "ID_Copia")
	private Integer id_copia;
	
	public Copia(String name, Float price, String description, Integer id, Integer num_cop, Category category,
			Integer id_copia) {
		super(name, price, description, id, num_cop, category);
		this.id_copia = id_copia;
	}
	
	public Copia() {
	}



	private static final long serialVersionUID = 1L;
	
	
	public Integer getId_copia() {
		return id_copia;
	}

	public void setId_copia(Integer id_copia) {
		this.id_copia = id_copia;
	}

	public String toString() {
		return "Copia del Producto= "+super.getName() +" ID copia= " + id_copia;
	}

	public Integer idGenerator(){
		int max = 200;
		int min= 1;
		Integer n=0;
		Random random = new Random();
		n=random.nextInt(max + min) + min;
		return n;
	}
}
