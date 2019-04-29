package calculations;

import java.util.List;
import java.util.Locale;

import data.*;

public class DistanceOfDelivery{
	public double calc(List <Customer> kunden, int iCustomer1Index, int iCustomer2Index) {
		/*
		 * Da ich bisher noch nie mit Längen- und Breitengrade gearbeitet habe,
		 * habe ich mir den Code auf der Seite https://www.geodatasource.com/developers/java
		 * zur Hilfe genommen und für meine Bedürfnisse angepasst.
		 */
		double dist=-1;
		try {
		double theta = kunden.get(iCustomer1Index).getLongitude() - kunden.get(iCustomer2Index).getLongitude();
		dist = Math.sin(Math.toRadians(kunden.get(iCustomer1Index).getLatitude())) * Math.sin(Math.toRadians(kunden.get(iCustomer2Index).getLatitude())) + Math.cos(Math.toRadians(kunden.get(iCustomer1Index).getLatitude())) * Math.cos(Math.toRadians(kunden.get(iCustomer2Index).getLatitude())) * Math.cos(Math.toRadians(theta));
		dist = Math.acos(dist);
		dist = Math.toDegrees(dist);
		dist = dist * 60 * 1.1515;
		
		dist = dist * 1.609344;//Kilometer
		String sDouble = String.format(Locale.ENGLISH, "%.3f",dist);
		dist = Double.parseDouble(sDouble);
		return dist;
		}catch(Exception e) {
			System.out.println("Überprüfen Sie die Übergabeparameter bei Ihrerem Aufruf von calc Ihres DistanceOfDelivery-Objektes!");
			return dist;
		}
		
	}
}