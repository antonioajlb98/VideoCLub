package model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Client")
@XmlAccessorType(XmlAccessType.FIELD)
public class Client implements Serializable{
	private static final long serialVersionUID = 1L;

	@XmlAttribute(name = "Identificacion", required = true)
	private Integer ID;

	@XmlAttribute(name = "Nombre")
	private String Name;
	private String Phone;
	private LocalDateTime time;
	private String Address;
	private Integer Age;

	public Client(Integer iD, String name, String phone, LocalDateTime time, String address, Integer age) {
		super();
		ID = iD;
		Name = name;
		Phone = phone;
		this.time = time;
		Address = address;
		Age = age;
	}
	

	public Client() {
	}


	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}
	

	public LocalDateTime getTime() {
		return time;
	}


	public void setTime(LocalDateTime time) {
		this.time = time;
	}


	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Integer getAge() {
		return Age;
	}

	public void setAge(Integer age) {
		Age = age;
	}

	@Override
	public boolean equals(Object obj) {
		boolean valid = false;
		if (obj != null) {
			if (this == obj) {
				valid = true;
			} else {
				if (this.getClass() == obj.getClass()) {
					Client tmp = (Client) obj;
					if (this.getClass().equals(tmp.getClass())) {
						valid = true;
					}
				}
			}
		}
		return valid;
	}

	@Override
	public String toString() {
		return "Cliente" +ID+ "\n-Nombre=" + Name + " Telefono=" + Phone + " Fecha del Registro=" + time;
	}
}
