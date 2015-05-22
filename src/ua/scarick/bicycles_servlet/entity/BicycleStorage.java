package ua.scarick.bicycles_servlet.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the bicycle_storage database table.
 * 
 */
@Entity
@Table(name="bicycle_storage")
@NamedQuery(name="BicycleStorage.findAll", query="SELECT b FROM BicycleStorage b")
public class BicycleStorage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int amount;

	private String gender;

	@Temporal(TemporalType.DATE)
	@Column(name="last_check")
	private Date lastCheck;

	private String manufacturer;

	private String model;

	public BicycleStorage() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getLastCheck() {
		return this.lastCheck;
	}

	public void setLastCheck(Date lastCheck) {
		this.lastCheck = lastCheck;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "BicycleStorage [id=" + id + ", amount=" + amount + ", gender="
				+ gender + ", lastCheck=" + lastCheck + ", manufacturer="
				+ manufacturer + ", model=" + model + "]";
	}
	
	

}