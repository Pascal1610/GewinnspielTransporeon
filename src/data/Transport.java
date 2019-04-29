package data;
import java.util.*;

public class Transport{
	int transportId;
	List <Integer[]> deliveryOrder = new ArrayList<Integer[]>();
	int iNumDelivery;
	
	public void setINumDelivery(int iNumDelivery) {
		try {
		this.iNumDelivery = iNumDelivery;
		}catch(Exception e) {
			System.out.println("Überprüfen Sie die Übergabeparameter bei Ihrerem Aufruf von setINumDelivery Ihres Transport-Objektes!");
		}
	}
	public int getINumDelivery() {
		return this.iNumDelivery;
	}
	
	public void setTransportId(int Id) {
		try {
		this.transportId=Id;
		}catch(Exception e) {
			System.out.println("Überprüfen Sie die Übergabeparameter bei Ihrerem Aufruf von setTransportId Ihres Transport-Objektes!");
		}
	}
	
	public int getTransportId() {
		return this.transportId;
	}
	
	public void addDelivery() {
		this.deliveryOrder.add(new Integer[1]);
	}
	
	public List <Integer[]> getDeliveryOrder(){
		return this.deliveryOrder;
	}

	
}