package model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import enums.Category;

@XmlRootElement(name = "Producto")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	private String Name;
	private Float price;
	private String description;
	@XmlAttribute(name = "identificador")
	private Integer id;
	private Integer num_cop;
	private Category category;
	
	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getNum_cop() {
		return num_cop;
	}

	public void setNum_cop(Integer num_cop) {
		this.num_cop = num_cop;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public Float getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	public Integer getID() {
		return id;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setID(Integer id) {
		this.id = id;
	}

	

	public Product(String name, Float price, String description, Integer id, Integer num_cop, Category category) {
		Name = name;
		this.price = price;
		this.description = description;
		this.id = id;
		this.num_cop = num_cop;
		this.category = category;
	}
	

	@Override
	public String toString() {
		return "[Nombre Del Producto=" + Name + "Precio=" + price + " Description=" + description + " ID=" + id + " Categoria=" + category + " Nº Copias=" + num_cop+"]"+"\n"
	            + "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
	}

	public Product() {
		super();
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}