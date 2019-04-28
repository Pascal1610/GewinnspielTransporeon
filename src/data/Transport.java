package data;
import java.util.*;

public class Transport{
	int transportId;
	List <Integer[]> deliveryOrder = new ArrayList<Integer[]>();
	int iNumDelivery;
	
	public void setINumDelivery(int iNumDelivery) {
		this.iNumDelivery = iNumDelivery;
	}
	public int getINumDelivery() {
		return this.iNumDelivery;
	}
	
	public void setTransportId(int Id) {
		this.transportId=Id;
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