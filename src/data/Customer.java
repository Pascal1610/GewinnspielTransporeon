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
		try {
		this.id = id;
		}catch(Exception e) {
			System.out.println("Überprüfen Sie die Übergabeparameter bei Ihrerem Aufruf von setCustomerId Ihres Customer-Objektes!");
		}
	}

	public int getCustomerId() {
		return this.id;
	}
	
	public void setINumTransporte(int iNumTransporte) {
		try {
		this.iNumTransporte = iNumTransporte;
		}catch(Exception e) {
			System.out.println("Überprüfen Sie die Übergabeparameter bei Ihrerem Aufruf von setINumTransporte Ihres Customer-Objektes!");
		}
	}

	public int getINumTransporte() {
		return this.iNumTransporte;
	}
	
	public void setName(String name) {
		try {
		this.name = name;
		}catch(Exception e) {
			System.out.println("Überprüfen Sie die Übergabeparameter bei Ihrerem Aufruf von setName Ihres Customer-Objektes!");
		}
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
		try {
		this.street=street;
		this.city=city;
		this.country=country;
		}catch(Exception e) {
			System.out.println("Überprüfen Sie die Übergabeparameter bei Ihrerem Aufruf von setAddress Ihres Customer-Objektes!");
		}
	}
	
	public void addTransportOrder() {
		this.transportOrder.add(new Integer[2]);
	}
	
	public List <Integer[]> getTransportOrder(){
		return this.transportOrder;
	}
	
	public void setLatitude(double latitude) {
		try {
		this.latitude=latitude;
		}catch(Exception e) {
			System.out.println("Überprüfen Sie die Übergabeparameter bei Ihrerem Aufruf von setLatitude Ihres Customer-Objektes!");
		}
	}
	
	public double getLatitude() {
		return this.latitude;
	}
	
	public void setLongitude(double longitude) {
		try {
		this.longitude=longitude;
		}catch(Exception e) {
			System.out.println("Überprüfen Sie die Übergabeparameter bei Ihrerem Aufruf von setLongitude Ihres Customer-Objektes!");
		}
	}
	
	public double getLongitude() {
		return this.longitude;
	}
	
	public int getTransportIdByDeliveryId(int iDeliveryId) {
		try {
	
		this.iNumTransporte=this.transportOrder.size(); //sicherheitshalber aktualisieren
		for(int i=0; i<this.iNumTransporte;i++) {
			if(this.transportOrder.get(i)[1]== iDeliveryId) {
			return transportOrder.get(i)[0];
				
			}

		}
		}catch(Exception e) {
			System.out.println("Überprüfen Sie die Übergabeparameter bei Ihrerem Aufruf von getTransportIdByDeliveryId Ihres Customer-Objektes!");
			return -1;
		}
		return -1;
		
		
	}
	
}