package data;

public class Delivery{
	int deliveryId;
	int loadingCustomerId;
	int unloadingCustomerId;
	double[] loadingCoordinates = new double[2];
	double[] unloadingCoordinates = new double[2];
	double distance;
	
	public void setDeliveryId(int Id) {
		try {
		this.deliveryId=Id;
		}catch(Exception e) {
			System.out.println("Überprüfen Sie die Übergabeparameter bei Ihrerem Aufruf von setDeliveryId Ihres Delivery-Objektes!");
		}
	}
	
	public int getDeliveryId() {
		return this.deliveryId;
	}
	
	public void setLoadingCustomerId(int Id) {
		try {
		this.loadingCustomerId=Id;
		}catch(Exception e) {
			System.out.println("Überprüfen Sie die Übergabeparameter bei Ihrerem Aufruf von setLoadingCustomerId Ihres Delivery-Objektes!");
		}
	}
	
	public int getLoadingCustomerId() {
		return this.loadingCustomerId;
	}
	
	public void setUnloadingCustomerId(int Id) {
		try {
		this.unloadingCustomerId=Id;
		}catch(Exception e) {
			System.out.println("Überprüfen Sie die Übergabeparameter bei Ihrerem Aufruf von setUnloadingCustomerId Ihres Delivery-Objektes!");
		}
	}
	
	public int getUnloadingCustomerId() {
		return this.unloadingCustomerId;
	}
	
	public void setLoadingCoordinates(double fromLatitude, double fromLongitude) {
		try {
		this.loadingCoordinates[0] = fromLatitude;
		this.loadingCoordinates[1] = fromLongitude;
		}catch(Exception e) {
			System.out.println("Überprüfen Sie die Übergabeparameter bei Ihrerem Aufruf von setLoadingCoordinates Ihres Delivery-Objektes!");
		}
	}
	
	public void setUnloadingCoordinates(double toLatitude, double toLongitude) {
		try {
		this.unloadingCoordinates[0] = toLatitude;
		this.unloadingCoordinates[1] = toLongitude;
		}catch(Exception e) {
			System.out.println("Überprüfen Sie die Übergabeparameter bei Ihrerem Aufruf von setUnloadingCoordinates Ihres Delivery-Objektes!");
		}
	}
	
	public double[] getLoadingCoordinates() {
		return this.loadingCoordinates;
	}
	
	public double[] getUnloadingCoordinates() {
		return this.unloadingCoordinates;
	}
	
	
}