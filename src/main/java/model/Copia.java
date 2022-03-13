package model;

import java.util.Random;

import enums.Category;

public class Copia extends Product{
	
	
	public Copia(String name, Float price, String description, Integer id, Integer num_cop, Category category,
			Integer id_copia) {
		super(name, price, description, id, num_cop, category);
		this.id_copia = id_copia;
	}


	private static final long serialVersionUID = 1L;
	private Integer id_copia;
	
	public Integer getId_copia() {
		return id_copia;
	}

	public void setId_copia(Integer id_copia) {
		this.id_copia = id_copia;
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
