package calculations;

import java.util.List;
import java.util.Locale;

import data.Customer;
import data.Delivery;

public class DistanceOfAllTransportsByOneCustomer{
	public double calc(List <Customer> kunden, int iCustomerID, List<Delivery> lieferungen) {
		//Zuerst die iDeliveryId´s des Kunden ermitteln.
		//Dann die Ausrechnen und addieren.
		double erg=0;
		try {
		List <Integer[]> listOfDeliveries = kunden.get(iCustomerID-1).getTransportOrder();
		
	
		for(int i=0; i<listOfDeliveries.size();i++) {
			
			//Lat lieferungen.get(listOfDeliveries.get(i)[1]).getLoadingCoordinates()[0]
			//Lon lieferungen.get(listOfDeliveries.get(i)[1]).getLoadingCoordinates()[1]	
			
			//Lat lieferungen.get(listOfDeliveries.get(i)[1]).getUnloadingCoordinates()[0]
			//Lon lieferungen.get(listOfDeliveries.get(i)[1]).getUnloadingCoordinates()[1]	
			
			double theta = lieferungen.get(listOfDeliveries.get(i)[1]-1).getLoadingCoordinates()[1] - lieferungen.get(listOfDeliveries.get(i)[1]-1).getUnloadingCoordinates()[1];
			double dist = Math.sin(Math.toRadians(lieferungen.get(listOfDeliveries.get(i)[1]-1).getLoadingCoordinates()[0])) * Math.sin(Math.toRadians(lieferungen.get(listOfDeliveries.get(i)[1]-1).getUnloadingCoordinates()[0])) + Math.cos(Math.toRadians(lieferungen.get(listOfDeliveries.get(i)[1]-1).getLoadingCoordinates()[0])) * Math.cos(Math.toRadians(lieferungen.get(listOfDeliveries.get(i)[1]-1).getUnloadingCoordinates()[0])) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			
			dist = dist * 1.609344;//Kilometer
			
			
			erg+=dist;
		}
		String sDouble = String.format(Locale.ENGLISH, "%.3f",erg);
		erg = Double.parseDouble(sDouble);

		return erg;
		}catch(Exception e) {
			System.out.println("Überprüfen Sie die Übergabeparameter bei Ihrerem Aufruf von calc Ihres DistanceOfAllTransportsByOneCustomer-Objektes!");
			erg=-1;
			return erg;
		}
		
	}
}