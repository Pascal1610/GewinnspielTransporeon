package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyFileReader{
	/*
	 * Prüft ob der Kunde bereits existiert oder nicht. Vgl. anhand von Name und Adresse
	 * Gleichzeitig wird ggf. ein Index festgelegt.
	 */
	public boolean checkIfCustomerExists(List <Customer> kunden,  List <Customer> tmpKunden, int iCustomerIndex) {
		try {
		boolean check=false;
		
		for(int i=0; i<kunden.size();i++) {

			if(kunden.get(i).getLatitude()==tmpKunden.get(0).getLatitude() && kunden.get(i).getLongitude()==tmpKunden.get(0).getLongitude()) {
				//Alternativer Vergleich in der If-Bedingung
				//kunden.get(i).getName() == tmpKunden.get(0).getName() && kunden.get(i).getAddress()==tmpKunden.get(0).getAddress()
				check=true;
				//iCustomerIndex=kunden.get(i).getCustomerId()-1; 
				break;
			}
		}
		
		return check;
		}catch(Exception e) {
			System.out.println("Überprüfen Sie die Übergabeparameter bei Ihrerem Aufruf von checkIfCustomerExists Ihres MyFileReader-Objektes!");
			return false;
		}
		
	}
	
	public boolean checkIfTransportExists(List <Transport> transporte, int iTransportId) {
		try {
		boolean check=false;
		for(int i=0; i<transporte.size();i++) {
			if(transporte.get(i).getTransportId() == iTransportId) {
				check=true;
				break;
			}
		}
		return check;
		}catch(Exception e) {
			System.out.println("Überprüfen Sie die Übergabeparameter bei Ihrerem Aufruf von checkIfTransportExists Ihres MyFileReader-Objektes!");
			return false;
		}
	}	
	
	public boolean checkIfDeliveryExists(List <Delivery> lieferungen, int iDeliveryId) {
		try {
		boolean check=false;
		for(int i=0; i<lieferungen.size();i++) {
			if(lieferungen.get(i).getDeliveryId()== iDeliveryId) {
				check=true;
				break;
			}
		}
		
		return check;
		}catch(Exception e) {
			System.out.println("Überprüfen Sie die Übergabeparameter bei Ihrerem Aufruf von checkIfDeliveryExists Ihres MyFileReader-Objektes!");
			return false;
		}
	}
	
	
	public void readIn (List <Customer> kunden, List <Transport> transporte, List <Delivery> lieferungen ) {
		try {
		//Logik zum einlesen
		//temporäre Listen zum arbeiten als eine Art Puffer.
		BufferedReader read = null;
		List <Customer> tmpKunden = new ArrayList<Customer>(); //erhält einzelne Kunden
		List <String> tmpList = new ArrayList<String>(); //erhält den Inhalt einer Zeile in Form einer Liste
		List <String> tmpAddress = new ArrayList<String>(); //erhält die Adresse in Form einer Liste
		List <Transport> tmpTransport = new ArrayList<Transport>(); //enthält einzelne Transporte
		List <Delivery> tmpDelivery = new ArrayList<Delivery>(); //enthält einzelne Lieferungen
	
		String sNameOfFile="testdata.csv"; //Hier kann der Dateiname geändert werden
		//Die Datei muss sich im src Ordner befinden, damit diese gefunden werden kann!
		
		
		int iNumCustomer = kunden.size(); //Anzahl der vorhandenen Kunden
		int iCustomer1Index=0; //Index für Kunde1 (v.l.n.r. aus der testdata.csv der erste Kunde)
		int iCustomer2Index=0; //Index für Kunde2 (v.l.n.r. aus der testdata.csv der zweite Kunde)
		int iTransportIndex=0; //Index für Transporte
		//int iDeliveryIndex=0; //Index für Lieferungen
		
		try {
			//Der Filepath und die Datei wird festgelegt

			int tmpZaehler=0;
			String tmpLine;
			String path = new File("src").getAbsolutePath();
			path += "\\"+sNameOfFile;
			read = new BufferedReader (new FileReader ( new File(path)));
			
			//die äußere Schleife geht Zeile für Zeile durch die testdata.csv
			while((tmpLine = read.readLine()) != null) {
				
				if(tmpZaehler == 0) {
					tmpZaehler++;
					
					/*
					 * Hier hätte noch eine Logik zum erkennen des 
					 * Inhalts in den Spalten (anhand Zeile 0) implementiert werden können
					 * z. B. indem man die Zeile 0 Transport, Lieferung, Von, Latitude usw.
					 * in eine Liste speichert und dann die Indizies unten ermittel indem man
					 * in der Liste nach Schlüsselwörtern/Objekten wie Transport, Lieferung usw. sucht
					 * in der Art: liste.indexOf("Transport");
					 */
					
				}else {
					
					//Zuerst erstelle ich aus der jeweiligen Zeile eine Liste.
					tmpList.addAll(Arrays.asList(tmpLine.split(";")));
					
					/*
					 * Anschließend prüfe ich, ob die Kunden die in dieser Zeile genannt werden bereits
					 * hinterlegt sind und lege diese bei Bedarf an. Gleichzeitig ermittle ich auch
					 * den passenden Index
					*/
					
					tmpKunden.add(new Customer());
					tmpAddress.addAll(Arrays.asList(tmpList.get(2).split(",")));
					tmpKunden.get(0).setName(tmpAddress.get(0));
					tmpKunden.get(0).setAddress(tmpAddress.get(1), tmpAddress.get(2), tmpAddress.get(3));
					tmpKunden.get(0).setLatitude(Double.parseDouble(tmpList.get(3)));
					tmpKunden.get(0).setLongitude(Double.parseDouble(tmpList.get(4)));
					tmpAddress.clear();
					
					if (!checkIfCustomerExists(kunden, tmpKunden,iCustomer1Index)) {
						iCustomer1Index=iNumCustomer; //legt ggf. Index fest
						
						kunden.add(tmpKunden.get(0));
						kunden.get(iCustomer1Index).setCustomerId(iCustomer1Index+1);
					
						iNumCustomer=kunden.size();
					}else {
						for(int i=0; i<kunden.size();i++) {

							if(kunden.get(i).getLatitude()==tmpKunden.get(0).getLatitude() && kunden.get(i).getLongitude()==tmpKunden.get(0).getLongitude()) {
								//Alternativer Vergleich in der If-Bedingung
								//kunden.get(i).getName() == tmpKunden.get(0).getName() && kunden.get(i).getAddress()==tmpKunden.get(0).getAddress()
								iCustomer1Index=kunden.get(i).getCustomerId()-1; //legt ggf. Index fest
								break;
							}
						}
					}
					
					tmpKunden.clear();
					tmpKunden.add(new Customer());
					
					tmpAddress.addAll(Arrays.asList(tmpList.get(5).split(",")));
					tmpKunden.get(0).setName(tmpAddress.get(0));
					tmpKunden.get(0).setAddress(tmpAddress.get(1), tmpAddress.get(2), tmpAddress.get(3));
					tmpKunden.get(0).setLatitude(Double.parseDouble(tmpList.get(6)));
					tmpKunden.get(0).setLongitude(Double.parseDouble(tmpList.get(7)));
					tmpAddress.clear();
					
					if (!checkIfCustomerExists(kunden, tmpKunden,iCustomer2Index)) {
						iCustomer2Index=iNumCustomer; //legt ggf. Index fest
						
						kunden.add(tmpKunden.get(0));
						kunden.get(iCustomer2Index).setCustomerId(iCustomer2Index+1);

						iNumCustomer=kunden.size();
					}else {
						for(int i=0; i<kunden.size();i++) {

							if(kunden.get(i).getLatitude()==tmpKunden.get(0).getLatitude() && kunden.get(i).getLongitude()==tmpKunden.get(0).getLongitude()) {
								//Alternativer Vergleich in der If-Bedingung
								//kunden.get(i).getName() == tmpKunden.get(0).getName() && kunden.get(i).getAddress()==tmpKunden.get(0).getAddress()
								iCustomer2Index=kunden.get(i).getCustomerId()-1; //legt ggf. Index fest
								break;
							}
						}
					}
					tmpKunden.clear();
					
					/*
					 * Nun wird geprüft ob der Transport und die Lieferung bereits vorhanden ist und
					 * bei Bedarf werden diese angelegt. Wenn der Transport schon existiert, muss er nicht erneut angelegt werden
					 */
					int iTransportId = Integer.parseInt(tmpList.get(0));
					iTransportIndex = iTransportId-1;
					int iDeliveryId = Integer.parseInt(tmpList.get(1));
					//iDeliveryIndex = iDeliveryId-1;
					
					
					if(!checkIfTransportExists(transporte, iTransportId)) {
						tmpTransport.add(new Transport());
						tmpTransport.get(0).setTransportId(iTransportId);
						transporte.add(tmpTransport.get(0));
					}
					tmpTransport.clear();
							
					if(!checkIfDeliveryExists(lieferungen, iDeliveryId)) {
						tmpDelivery.add(new Delivery());
						tmpDelivery.get(0).setDeliveryId(iDeliveryId);
						tmpDelivery.get(0).setLoadingCoordinates(Double.parseDouble(tmpList.get(3)), Double.parseDouble(tmpList.get(4)));
						tmpDelivery.get(0).setLoadingCustomerId(kunden.get(iCustomer1Index).getCustomerId());
						tmpDelivery.get(0).setUnloadingCoordinates(Double.parseDouble(tmpList.get(6)), Double.parseDouble(tmpList.get(7)));
						tmpDelivery.get(0).setUnloadingCustomerId(kunden.get(iCustomer2Index).getCustomerId());
						
						lieferungen.add(tmpDelivery.get(0));
					}
					tmpDelivery.clear();
					
					
					//Hinzufügen von Transporten/Lieferungen bei Customer1 und Customer2
					//Abfangen, falls vorhanden?
					
					
					kunden.get(iCustomer1Index).addTransportOrder();
					kunden.get(iCustomer1Index).setINumTransporte(kunden.get(iCustomer1Index).transportOrder.size());
					kunden.get(iCustomer1Index).transportOrder.get(kunden.get(iCustomer1Index).getINumTransporte()-1)[0]=iTransportId;
					kunden.get(iCustomer1Index).transportOrder.get(kunden.get(iCustomer1Index).getINumTransporte()-1)[1]=iDeliveryId;
					
					kunden.get(iCustomer2Index).addTransportOrder();
					kunden.get(iCustomer2Index).setINumTransporte(kunden.get(iCustomer2Index).transportOrder.size());
					kunden.get(iCustomer2Index).transportOrder.get(kunden.get(iCustomer2Index).getINumTransporte()-1)[0]=iTransportId;
					kunden.get(iCustomer2Index).transportOrder.get(kunden.get(iCustomer2Index).getINumTransporte()-1)[1]=iDeliveryId;
					
					transporte.get(iTransportIndex).addDelivery();
					transporte.get(iTransportIndex).setINumDelivery(transporte.get(iTransportIndex).deliveryOrder.size());
					transporte.get(iTransportIndex).deliveryOrder.get(transporte.get(iTransportIndex).getINumDelivery()-1)[0]=iDeliveryId;
					
					tmpList.clear();
					//...Ende
							
				}
				//tmpList.clear();
			}
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				read.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		}catch(Exception e) {
			System.out.println("Überprüfen Sie die Übergabeparameter bei Ihrerem Aufruf von readIn Ihres MyFileReader-Objektes!");
			
		}
	
	}
}