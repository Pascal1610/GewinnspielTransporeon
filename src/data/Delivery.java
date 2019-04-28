package data;

public class Delivery{
	int deliveryId;
	int loadingCustomerId;
	int unloadingCustomerId;
	double[] loadingCoordinates = new double[2];
	double[] unloadingCoordinates = new double[2];
	double distance;
	
	public void setDeliveryId(int Id) {
		this.deliveryId=Id;
	}
	
	public int getDeliveryId() {
		return this.deliveryId;
	}
	
	public void setLoadingCustomerId(int Id) {
		this.loadingCustomerId=Id;
	}
	
	public int getLoadingCustomerId() {
		return this.loadingCustomerId;
	}
	
	public void setUnloadingCustomerId(int Id) {
		this.unloadingCustomerId=Id;
	}
	
	public int getUnloadingCustomerId() {
		return this.unloadingCustomerId;
	}
	
	public void setLoadingCoordinates(double fromLatitude, double fromLongitude) {
		this.loadingCoordinates[0] = fromLatitude;
		this.loadingCoordinates[1] = fromLongitude;
	}
	
	public void setUnloadingCoordinates(double toLatitude, double toLongitude) {
		this.unloadingCoordinates[0] = toLatitude;
		this.unloadingCoordinates[1] = toLongitude;
	}
	
	public double[] getLoadingCoordinates() {
		return this.loadingCoordinates;
	}
	
	public double[] getUnloadingCoordinates() {
		return this.unloadingCoordinates;
	}
	
	
}