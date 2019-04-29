package calculations;

import java.util.List;
import java.util.Locale;

import data.Delivery;
import data.Transport;

public class DistanceOfAToZ{
	public double[] calc(List <Delivery> lieferungen,List <Transport> transporte, int iTransportID) {
		
		double[] dErg = new double[3];
		try {
		int iLastIndex=transporte.get(iTransportID-1).getDeliveryOrder().size()-1;
		
		//Lat lieferungen.get(transporte.get(iTransportID-1).getDeliveryOrder().get(0)[0]-1).getLoadingCoordinates()[0]
		//Lon lieferungen.get(transporte.get(iTransportID-1).getDeliveryOrder().get(0)[0]-1).getLoadingCoordinates()[1]
		
		//Lat lieferungen.get(transporte.get(iTransportID-1).getDeliveryOrder().get(iLastIndex)[0]-1).getUnloadingCoordinates()[0]
		//Lon lieferungen.get(transporte.get(iTransportID-1).getDeliveryOrder().get(iLastIndex)[0]-1).getUnloadingCoordinates()[1]
		
		
		
	
		double theta = lieferungen.get(transporte.get(iTransportID-1).getDeliveryOrder().get(0)[0]-1).getLoadingCoordinates()[1] - lieferungen.get(transporte.get(iTransportID-1).getDeliveryOrder().get(iLastIndex)[0]-1).getUnloadingCoordinates()[1];
		double dist = Math.sin(Math.toRadians(lieferungen.get(transporte.get(iTransportID-1).getDeliveryOrder().get(0)[0]-1).getLoadingCoordinates()[0])) * Math.sin(Math.toRadians(lieferungen.get(transporte.get(iTransportID-1).getDeliveryOrder().get(iLastIndex)[0]-1).getUnloadingCoordinates()[0])) + Math.cos(Math.toRadians(lieferungen.get(transporte.get(iTransportID-1).getDeliveryOrder().get(0)[0]-1).getLoadingCoordinates()[0])) * Math.cos(Math.toRadians(lieferungen.get(transporte.get(iTransportID-1).getDeliveryOrder().get(iLastIndex)[0]-1).getUnloadingCoordinates()[0])) * Math.cos(Math.toRadians(theta));
		dist = Math.acos(dist);
		dist = Math.toDegrees(dist);
		dist = dist * 60 * 1.1515;
		
		dist = dist * 1.609344;//Kilometer
		String sDouble = String.format(Locale.ENGLISH, "%.3f",dist);
		dist = Double.parseDouble(sDouble);
		
		dErg[0]= (double)(lieferungen.get(transporte.get(iTransportID-1).getDeliveryOrder().get(0)[0]-1).getLoadingCustomerId());
		dErg[1]= (double)(lieferungen.get(transporte.get(iTransportID-1).getDeliveryOrder().get(iLastIndex)[0]-1).getUnloadingCustomerId());
		dErg[2]= dist;
		
		return dErg;
		
		}catch(Exception e) {
			System.out.println("Überprüfen Sie die Übergabeparameter bei Ihrerem Aufruf von calc Ihres DistanceOfAToZ-Objektes!");
			return dErg;
		}
		

			
		



		

		
	}
}