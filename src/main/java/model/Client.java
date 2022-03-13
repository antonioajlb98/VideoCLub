package model;

import java.io.Serializable;

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
	private String Time;
	private String Address;
	private Integer Age;

	public Client() {
		this.ID = -1;
		this.Name = "";
		this.Phone = "";
		this.Time = "";
		this.Address = "";
		this.Age = -1;
	}

	public Client(Integer ID, String Name, String Phone, String Time, String Address, Integer Age) {
		this.ID = ID;
		this.Name = Name;
		this.Phone = Phone;
		this.Time = Time;
		this.Address = Address;
		this.Age = Age;
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

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
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
		return "Client [ID=" + ID + ", Name=" + Name + ", Phone=" + Phone + ", Time=" + Time + "]";
	}
}
