package hibernatedemo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.util.Date;

@Entity
@Table(name="studentAddress")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto Generation of values without doing it manually
	@Column(name="address_id")
	private int addressId;
	
	@Column(length = 50, name="Street")
	private String street;
	
	@Column(name="City", length = 30)
	private String city;
	
	@Column(name="Is_Open")
	private boolean isOpen;
	
	@Transient		// It will not add this column in table automatically
	private double x;
	
	@Column(name="Added_Date")
	@Temporal(TemporalType.DATE) // The date temporal will only get date rather than time in Table
	private Date addedDate;
	
	@Lob
	private byte[] image;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public boolean isOpen() {
		return isOpen;
	}
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public Address(int addressId, String street, String city, boolean isOpen, double x, Date addedDate, byte[] image) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.city = city;
		this.isOpen = isOpen;
		this.x = x;
		this.addedDate = addedDate;
		this.image = image;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.addressId+" : "+this.street+" : "+this.city+" : "+this.isOpen+" : "+this.x+" : "+ this.addedDate+" : ";
	}

}
