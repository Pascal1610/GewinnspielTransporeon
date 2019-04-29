# GewinnspielTransporeon
Dies ist meine Abgabe für das Gewinnspiel.
Transporeon ist meine "Main Class", in der ich Objekte andere Klassen (z. B. Customer, Transport oder Delivery) erzeuge.
Jede Teilaufgabe (die Berechnungen, oder das einlesen der Testdaten) ist in einer weiteren Klasse unterteilt.

Meine (notwendigen) Annahmen:
- Eine Lieferung besteht aus zwei Kunden. (Beladestelle = Kunde1 & Entladestelle = Kunde2)
- Für die Bonusaufgabe:
  - Eine Lieferung ist eine fest Verbindung aus Beladestelle und Entladestelle, die nicht zu ändern/optimieren sind. Zu optimieren sind jeweils die Verbidungen von einer Entladestelle zur nächsten Beladestelle. z. B. von der Entladestelle (Lieferung1) zur Beladestelle (Lieferung2)
  - Es gibt keinen "Rundweg" => Start und Ziel können unterschiedlich sein (da keine Vorgabe)


Die Bonusaufgabe funtkioniert nur mit einer Anzahl an Lieferungen von 7 (so wie die Testdaten) ordnungsgemäß.

- Bei der ersten Berechnungsaufgabe geht meine Main Methode alle Lieferungen in einer For-Schleife durch.
- Bei Aufgabe 2 besteht die Möglichkeit die Variable "iTransportIDAufgabe2" anzupassen, um so den jeweils ausgewählten Transport zu ändern.
- Bei Aufgabe 3 besteht die Möglichkeit die Variable "iKunde" anzupassen, um so den jeweils ausgewählten Kunden zu ändern.

Die Testdaten Datei "testdata.csv" muss im Ordner \src abgelegt werden! (gleiche Ordnerstruktur wie geuploaded)

Genutzt Java Version: 11.0.1 64-bit

Zusätzlicher Inhalt:
- Eine Skizze, wie ich mir die Bonusaufgabe vorgestellt habe als .jpg
- Eine Konsolenausgabe in einer .txt, Auszug aus meiner IDE
