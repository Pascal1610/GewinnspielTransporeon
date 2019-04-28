package data;
import java.util.*;

public class Customer{
	int id;
	String name;
	String street;
	String city;
	String country;
	double latitude;
	double longitude;
	int iNumTransporte;
	List <Integer[]> transportOrder = new ArrayList<Integer[]>();

	public void setCustomerId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return this.id;
	}
	
	public void setINumTransporte(int iNumTransporte) {
		this.iNumTransporte = iNumTransporte;
	}

	public int getINumTransporte() {
		return this.iNumTransporte;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	
	public String getAddress() {
		return this.street+"\n"+this.city+"\n"+this.country;
	}
	
	public String getAddressOneLine() {
		return this.street+", "+this.city+", "+this.country;
	}
	
	public void setAddress(String street, String city, String country) {
		this.street=street;
		this.city=city;
		this.country=country;
	}
	
	public void addTransportOrder() {
		this.transportOrder.add(new Integer[2]);
	}
	
	public List <Integer[]> getTransportOrder(){
		return this.transportOrder;
	}
	
	public void setLatitude(double latitude) {
		this.latitude=latitude;
	}
	
	public double getLatitude() {
		return this.latitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude=longitude;
	}
	
	public double getLongitude() {
		return this.longitude;
	}
	
	public int getTransportIdByDeliveryId(int iDeliveryId) {
	
		this.iNumTransporte=this.transportOrder.size(); //sicherheitshalber aktualisieren
		for(int i=0; i<this.iNumTransporte;i++) {
			if(this.transportOrder.get(i)[1]== iDeliveryId) {
			return transportOrder.get(i)[0];
				
			}

		}
		return -1;
	}
	
}