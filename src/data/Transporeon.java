package data;
import java.util.ArrayList;
import java.util.List;

import calculations.*;

public class Transporeon{
	public static void main(String[] args) {
		List <Customer> kunden = new ArrayList<Customer>(); //Die Kunden
		List <Transport> transporte = new ArrayList<Transport>(); //Die Transporte
		List <Delivery> lieferungen = new ArrayList<Delivery>(); // Die Lieferungen
		MyFileReader myInput = new MyFileReader(); //MeinReader
		
		//Alternativ könnte man hier auch manuell Kunden erstellen
		myInput.readIn(kunden,transporte,lieferungen);
		
		System.out.println("Testlauf ob meine Klassenstruktur funktioniert");
		System.out.println("Transport; Lieferung; Von; Latitude; Longitude; Nach; Latitude; Longitude");
		for(int i=0; i<lieferungen.size();i++){
			
				System.out.print(kunden.get(lieferungen.get(i).getLoadingCustomerId()-1).getTransportIdByDeliveryId(lieferungen.get(i).getDeliveryId())+"; ");
				System.out.print(lieferungen.get(i).getDeliveryId() +"; ");
				
				System.out.print(kunden.get(lieferungen.get(i).getLoadingCustomerId()-1).getName() +", ");
				System.out.print(kunden.get(lieferungen.get(i).getLoadingCustomerId()-1).getAddressOneLine() +"; ");
				System.out.print(kunden.get(lieferungen.get(i).getLoadingCustomerId()-1).getLatitude() +"; ");
				System.out.print(kunden.get(lieferungen.get(i).getLoadingCustomerId()-1).getLongitude() +"; ");
				
				System.out.print(kunden.get(lieferungen.get(i).getUnloadingCustomerId()-1).getName() +", ");
				System.out.print(kunden.get(lieferungen.get(i).getUnloadingCustomerId()-1).getAddressOneLine() +"; ");
				System.out.print(kunden.get(lieferungen.get(i).getUnloadingCustomerId()-1).getLatitude() +"; ");
				System.out.print(kunden.get(lieferungen.get(i).getUnloadingCustomerId()-1).getLongitude() +"; ");
				System.out.println();
		}
		
		System.out.println("\n-----------------------------------------------------------------------");
		
		System.out.println("**Aufgabe1: Berechnungen der Distanz Distanz zwischen Beladestelle und Entladestelle einer Lieferung**\n");
		DistanceOfDelivery myCalc = new DistanceOfDelivery();
		
		System.out.println("Distanz in Kilometer (Luftlinie, auf 3 Nachkommastellen gerundet)");
		for(int i=0; i<lieferungen.size();i++){
			System.out.print("TransportID: "+kunden.get(lieferungen.get(i).getLoadingCustomerId()-1).getTransportIdByDeliveryId(lieferungen.get(i).getDeliveryId())+"; ");
			System.out.print("LieferungID: "+lieferungen.get(i).getDeliveryId() +"; ");
			
			/*
			 * Als Übergabeparameter für die Berechnung ist die Liste der Kunden 
			 * sowie ein Index für Beladestelle und ein *Index* für Entladestelle notwendig.
			 * Der einfachheitshalber habe ich einmal die Testdaten durchlaufen.
			 */
			
			double distanceOfDelivery = myCalc.calc(kunden, lieferungen.get(i).getLoadingCustomerId()-1,lieferungen.get(i).getUnloadingCustomerId()-1);
			
			System.out.print("Distanz: "+distanceOfDelivery + " km; ");
			System.out.print("(Kunde1ID: "+lieferungen.get(i).getLoadingCustomerId() + " Kunde1Index: "+(lieferungen.get(i).getLoadingCustomerId()-1)+"); ");
			System.out.print("(Kunde2ID: "+lieferungen.get(i).getUnloadingCustomerId() + " Kunde2Index: "+(lieferungen.get(i).getUnloadingCustomerId()-1)+")");
			System.out.println();
		}
		
		System.out.println("\n-----------------------------------------------------------------------");
		System.out.println("**Aufgabe2: Berechnungen der Distanz zwischen Ort der ersten Beladestell zu Ort der letzten Entladestelle eines Transportes**\n");
	
		DistanceOfAToZ myCalcAToZ = new DistanceOfAToZ();
		
		/*
		 * Diese Variable kann im Rahmen von Testzwecken verändert werden (eine andere TransportID wählen)
		 * Es ist bisher kein abfangen von Fehlern implementiert!
		 */
		int iTransportIDAufgabe2 = 3; //Die TransportID; von 1 bis 3 (gemäß der testdata.csv)
		/*
		 * 
		 */
		
		double [] distanceOfAToZ = myCalcAToZ.calc(lieferungen,transporte,iTransportIDAufgabe2);
		
		System.out.println("Transport ID: "+iTransportIDAufgabe2);
		System.out.println("Erste Beladestelle:");
		System.out.print(kunden.get((int)(distanceOfAToZ[0])-1).getName()+", ");
		System.out.println(kunden.get((int)(distanceOfAToZ[0])-1).getAddressOneLine());
		System.out.println("Letzte Entladestelle:");
		System.out.print(kunden.get((int)(distanceOfAToZ[1])-1).getName()+", ");
		System.out.println(kunden.get((int)(distanceOfAToZ[1])-1).getAddressOneLine());
		System.out.println("Die Distanz beträgt "+distanceOfAToZ[2]+" km. (Luftlinie, auf 3 Nachkommastellen gerundet)");
		
		System.out.println("\n-----------------------------------------------------------------------");
		
		System.out.println("**Aufgabe 3: Berechnungen der Gesamtdistanz aller Lieferungen eines Kunden**\n");
		System.out.println("Mögliche Kunden ID von 1 bis "+(kunden.size())+ "\nPro Lieferung gibt es zwei Kunden (Beladestelle und Entladestelle).\nKommt eine Adresse mehrfach vor,\ndann zählt diese nur als ein Kunde!");
		
		DistanceOfAllTransportsByOneCustomer myCalcATBOC = new DistanceOfAllTransportsByOneCustomer();
		
		/*
		 * Diese Variable kann im Rahmen von Testzwecken verändert werden (einen anderen Kunden auswählen)
		 * Es ist bisher kein abfangen von Fehlern implementiert!
		 */
		int iKunde=6; //Hier wird der Kunde ausgewählt! Kunden gibt es insgesamt 6 Stück in dem Beispiel
		/*
		 * 
		 */
		
		System.out.println("Kunde "+iKunde+ " ist ausgewählt.\n");
		double sum = myCalcATBOC.calc(kunden, iKunde, lieferungen);
		
		System.out.println("Kunde: "+kunden.get(iKunde-1).name +", "+ kunden.get(iKunde-1).getAddressOneLine());
		System.out.println("Verbindungen: ");
		for(int i=0; i<kunden.get(iKunde-1).transportOrder.size();i++) {
			int indexLieferung = kunden.get(iKunde-1).transportOrder.get(i)[1]-1;
			int indexKunde1 = lieferungen.get(indexLieferung).getLoadingCustomerId()-1;
			int indexKunde2 = lieferungen.get(indexLieferung).getUnloadingCustomerId()-1;
			System.out.println("Von: "+kunden.get(indexKunde1).name+", "+kunden.get(indexKunde1).getAddressOneLine());
			System.out.println("Zu: "+kunden.get(indexKunde2).name+", "+kunden.get(indexKunde2).getAddressOneLine());
			System.out.println("Einzelne Strecke: "+ myCalc.calc(kunden, indexKunde1,indexKunde2)+" km");
			System.out.println("");
		}
		System.out.println("Die Gesamt Distanz des Kunden beträgt: "+sum+" km");
		
		System.out.println("\n-----------------------------------------------------------------------");
		DistanceOfOptimalRoute myCalcOptimalRoute = new DistanceOfOptimalRoute();
		System.out.println("**Optimale Reihenfolge** (Bonus)");
		System.out.println("Hinweis: Die Bonusaufgabe funktioniert NUR mit der Anzahl 7 bei Lieferungen!\n");
		/*
		 * Hinweis: Die Bonusaufgabe funktioniert NUR mit der Anzahl 7 bei Lieferungen. 
		 * Wenn andere Testdaten eingelesen werden, mit mehr oder weniger Lieferungen, 
		 * dann muss die Bonusaufgabe auskommentiert werden!
		 */
		System.out.println("\nAnnahmen:\nDie Verbindungen einer Lieferung sind fix.\nDer Weg ist keine Rundreise (keine Angabe); Start- und Endpunkt sind unterschiedlich\nAlso Beladestelle zu Entladestelle.\nEs wird die Verbindung von einer Entladestelle zur nächsten Beladestelle optimiert.\nDie Summe der Kilometer setzt sich aus\n- der Summe der Lieferverbindungen (fix)\n- der Summe der Verbindungen zwischen den Lieferungen (zu optimieren)\nzusammen.\n");
		System.out.println("Zur Rechnung:");
		myCalcOptimalRoute.calc(kunden, lieferungen);
		
		System.out.println("\n-----------------------------------------------------------------------");
	}
}