package calculations;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import calculations.DistanceOfDelivery;
import data.Customer;
import data.Delivery;

public class DistanceOfOptimalRoute{
	
	public Double [] schieben (Double [] ArrayOfDeliveryID) {
		//
		Double puffer=ArrayOfDeliveryID[6];
		ArrayOfDeliveryID[6]=ArrayOfDeliveryID[5];
		ArrayOfDeliveryID[5]=puffer;
		
		return ArrayOfDeliveryID;
	}
	
	public Double[] tauschen (Double[] ArrayOfDeliveryID, int index, int add) {
		//
		double puffer  = ArrayOfDeliveryID[index];
		int tmpIndex=0;
		for(int i=0;i<ArrayOfDeliveryID.length;i++) {
			if(ArrayOfDeliveryID[i]==ArrayOfDeliveryID[index] + add) {
				tmpIndex=i;
			}
		}
		ArrayOfDeliveryID[index]=ArrayOfDeliveryID[tmpIndex];
		ArrayOfDeliveryID[tmpIndex]=puffer;
		
		return ArrayOfDeliveryID;
	}
	
	
	public List <Double> calc(List <Customer> kunden, List <Delivery> lieferungen) {
		List <Double> optimalRoute = new ArrayList<Double>(); 
		List <Double> tmpOptimalRoute = new ArrayList<Double>(); 
		DistanceOfDelivery myCalc = new DistanceOfDelivery();
		
		//Zuerst müssen alle möglichen Verbindungen der Lieferungen berechnet werden.
		//Verbindungen von einer Entladestelle zur nächsten Beladestelle.
		//Aus allen Möglichkeiten muss die beste herausgesucht werden

		
		Double [] ArrayOfDeliveryID = new Double[] {1.0,2.0,3.0,4.0,5.0,6.0,7.0};	
		/*
		 * Rechnung (einmal durchführen), um einen Vergleichswert zu haben
		 * optimalRoute.add... (Reihenfolge: 1,2,3,4,5,6,7,erg)
		 * Ich lieferungAZuB enthält die Annahme, 
		 * dass die Lieferverbindung von einer Beladestelle zu einer Entladestelle fix sind.
		 * Daher bleiben diese unverändert im weiteren Verlauf.
		 * 
		 * Das Augenmerk liegt bei den Verbindungen von eine Entladestelle zur nächsten Beladestelle.
		 */
		double lieferungAZuB= myCalc.calc(kunden, lieferungen.get(0).getLoadingCustomerId()-1, lieferungen.get(0).getUnloadingCustomerId()-1)+
				myCalc.calc(kunden, lieferungen.get(1).getLoadingCustomerId()-1, lieferungen.get(1).getUnloadingCustomerId()-1)+
				myCalc.calc(kunden, lieferungen.get(2).getLoadingCustomerId()-1, lieferungen.get(2).getUnloadingCustomerId()-1)+
				myCalc.calc(kunden, lieferungen.get(3).getLoadingCustomerId()-1, lieferungen.get(3).getUnloadingCustomerId()-1)+
				myCalc.calc(kunden, lieferungen.get(4).getLoadingCustomerId()-1, lieferungen.get(4).getUnloadingCustomerId()-1)+
				myCalc.calc(kunden, lieferungen.get(5).getLoadingCustomerId()-1, lieferungen.get(5).getUnloadingCustomerId()-1)+
				myCalc.calc(kunden, lieferungen.get(6).getLoadingCustomerId()-1, lieferungen.get(6).getUnloadingCustomerId()-1);
		
		double entladestelleZuLadestelle = myCalc.calc(kunden, lieferungen.get(0).getUnloadingCustomerId()-1, lieferungen.get(1).getLoadingCustomerId()-1)+
				myCalc.calc(kunden, lieferungen.get(1).getUnloadingCustomerId()-1, lieferungen.get(2).getLoadingCustomerId()-1)+
				myCalc.calc(kunden, lieferungen.get(2).getUnloadingCustomerId()-1, lieferungen.get(3).getLoadingCustomerId()-1)+
				myCalc.calc(kunden, lieferungen.get(3).getUnloadingCustomerId()-1, lieferungen.get(4).getLoadingCustomerId()-1)+
				myCalc.calc(kunden, lieferungen.get(4).getUnloadingCustomerId()-1, lieferungen.get(5).getLoadingCustomerId()-1)+
				myCalc.calc(kunden, lieferungen.get(5).getUnloadingCustomerId()-1, lieferungen.get(6).getLoadingCustomerId()-1);
		
		double erg1 = lieferungAZuB + entladestelleZuLadestelle;
		double erg2 =erg1;
		optimalRoute.addAll(Arrays.asList(new Double[]{1.0,2.0,3.0,4.0,5.0,6.0,7.0,erg1}));
		
		System.out.println("Reihenfolge (Beginn, wie in testdata.csv): ");
		for(int i=0;i<optimalRoute.size()-1;i++) {
			if(i<optimalRoute.get(optimalRoute.size()-1)){
				System.out.print("L"+optimalRoute.get(i).intValue()+" ");
			}
		}
		System.out.println("");
		for(int i=1;i<optimalRoute.size();i++) {
			if(i<optimalRoute.size()-1){
				System.out.println("Von L"+optimalRoute.get(i-1).intValue()+" zu L"+optimalRoute.get(i).intValue());
			}else {
				System.out.println("Gesamtstrecke: "+optimalRoute.get(i)+" km");
			}
		}		
		
		
		/*
		 * Ich weiß, dass meine Lösung wahrscheinlich sehr "suboptimal" gelöst ist,
		 * aber das Problem des Handlungsreisenden ist generell "unschön".
		 * 
		 */
		
		for(int a=0; a<7;a++) {
			/*
			 * Tauschen Wert an index 0 mit Wert entsprechend 0 +a+1
			 */
			if(a>0) {
				ArrayOfDeliveryID = tauschen(ArrayOfDeliveryID, 0, a+1);
			}
			
			for(int b=0; b<6;b++) {
				/*
				 * Tauschen Wert an index 1 mit Wert entsprechend 1 +b+1
				 */
				if(b>0) {
					ArrayOfDeliveryID = tauschen(ArrayOfDeliveryID, 1, b+1);
				}
				
				for(int c=0; c<5;c++) {
					/*
					 * Tauschen Wert an index 2 mit Wert entsprechend 2 +c+1
					 */
					if(c>0) {
						ArrayOfDeliveryID = tauschen(ArrayOfDeliveryID, 2, c+1);
					}
					
					for(int d=0; d<4;d++) {
						/*
						 * Tauschen Wert an index 3 mit Wert entsprechend 3 +d+1
						 */
						if(d>0) {
							ArrayOfDeliveryID = tauschen(ArrayOfDeliveryID, 3, d+1);
						}
						
						for(int e=0; e<3;e++) {
							/*
							 * Tauschen Wert an index 4 mit Wert entsprechend 4 +e+1
							 */
							if(e>0) {
								ArrayOfDeliveryID = tauschen(ArrayOfDeliveryID, 4, e+1);
							}
							
							
							for(int f=0;f<2;f++) {
								/*
								 * Rechnung
								 */
								
								entladestelleZuLadestelle = myCalc.calc(kunden, lieferungen.get(ArrayOfDeliveryID[0].intValue()-1).getUnloadingCustomerId()-1, lieferungen.get(ArrayOfDeliveryID[1].intValue()-1).getLoadingCustomerId()-1)+
										myCalc.calc(kunden, lieferungen.get(ArrayOfDeliveryID[1].intValue()-1).getUnloadingCustomerId()-1, lieferungen.get(ArrayOfDeliveryID[2].intValue()-1).getLoadingCustomerId()-1)+
										myCalc.calc(kunden, lieferungen.get(ArrayOfDeliveryID[2].intValue()-1).getUnloadingCustomerId()-1, lieferungen.get(ArrayOfDeliveryID[3].intValue()-1).getLoadingCustomerId()-1)+
										myCalc.calc(kunden, lieferungen.get(ArrayOfDeliveryID[3].intValue()-1).getUnloadingCustomerId()-1, lieferungen.get(ArrayOfDeliveryID[4].intValue()-1).getLoadingCustomerId()-1)+
										myCalc.calc(kunden, lieferungen.get(ArrayOfDeliveryID[4].intValue()-1).getUnloadingCustomerId()-1, lieferungen.get(ArrayOfDeliveryID[5].intValue()-1).getLoadingCustomerId()-1)+
										myCalc.calc(kunden, lieferungen.get(ArrayOfDeliveryID[5].intValue()-1).getUnloadingCustomerId()-1, lieferungen.get(ArrayOfDeliveryID[6].intValue()-1).getLoadingCustomerId()-1);
								erg2 = lieferungAZuB + entladestelleZuLadestelle;
								
								tmpOptimalRoute.addAll(Arrays.asList(ArrayOfDeliveryID));
								tmpOptimalRoute.add(erg2);
								
								if(tmpOptimalRoute.get(tmpOptimalRoute.size()-1) < optimalRoute.get(optimalRoute.size()-1)) {
									optimalRoute.clear(); //leeren
									optimalRoute.addAll(tmpOptimalRoute); //Damit beide Listen die gleiche Größe haben
									Collections.copy(optimalRoute,tmpOptimalRoute); //kopie von Liste2 in Liste1
								}
								tmpOptimalRoute.clear(); //leeren
								/*
								 * Schieben +1 (letzten zwei werte)
								 */
								ArrayOfDeliveryID = schieben(ArrayOfDeliveryID);
							}

							
						}

					}

				}

			}

		}
		
		erg2= optimalRoute.get(optimalRoute.size()-1); //Da erg2 sonst den Wert des letzten Durchlaufs hat
		System.out.println("");
		System.out.println("Reihenfolge (optimal, 7! Wege wurden berechnet & verglichen): ");
		for(int i=0;i<optimalRoute.size()-1;i++) {
			if(i<optimalRoute.get(optimalRoute.size()-1)){
				System.out.print("L"+optimalRoute.get(i).intValue()+" ");
			}
		}
		System.out.println("");
		for(int i=1;i<optimalRoute.size();i++) {
			if(i<optimalRoute.size()-1){
				System.out.println("Von L"+optimalRoute.get(i-1).intValue()+" zu L"+optimalRoute.get(i).intValue());
			}else {
				System.out.println("Gesamtstrecke: "+optimalRoute.get(i)+" km");
			}
		}
		
		System.out.println("\nDifferenz / Ersparnis: "+ erg1 + " km - "+ erg2 + " km = "+(erg1-erg2)+" km");
		System.out.println("");

		
		return optimalRoute;
		
	}
	
}