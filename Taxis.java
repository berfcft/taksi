package taxisystem;


import taxisystem.Driver.g;
import taxisystem.Taxi.bc;
import taxisystem.Taxi.cm;
import taxisystem.Taxi.op;
import taxisystem.Taxi.pa;

public  class Taxis  {
	
	
	
	Taxi t1 = new Taxi(1,"Ali",3.2 , 30, g.male,bc.medium , op.online, cm.Mercedes, pa.yes,"Beşiktaş");
	Taxi t2 = new Taxi(2,"Veli",4 , 28, g.male,bc.high , op.both, cm.Fiat, pa.yes,"Beşiktaş");
	Taxi t3 = new Taxi(3,"Murat",4.5 , 25, g.male,bc.medium , op.both, cm.Renault, pa.yes,"Beşiktaş"); ;
    Taxi t4 = new Taxi(4,"Mehmet",3.9 , 32, g.male,bc.medium , op.both, cm.Mercedes, pa.yes,"Beşiktaş"); ;
    Taxi t5 = new Taxi(5,"Ayşe",4 , 27, g.female,bc.low , op.both, cm.Renault, pa.yes,"Kadıköy"); ;
    Taxi t6 = new Taxi(6,"Musa",4.4 ,26, g.male,bc.high , op.online, cm.Mercedes, pa.yes,"Kadıköy"); ;
    Taxi t7 = new Taxi(7,"Mustafa",4.6 ,49, g.male,bc.low , op.both, cm.Fiat, pa.yes,"Kadıköy"); ;
    Taxi t8 = new Taxi(8,"Elif",4.8 , 32, g.female,bc.low , op.online, cm.Mercedes, pa.yes,"Taksim"); ;
    Taxi t9 = new Taxi(9,"Ahmet",3.5 , 39, g.male,bc.high , op.both, cm.Renault, pa.no,"Taksim"); ;
    Taxi t10 = new Taxi(10,"Zeynep",3.9 , 24, g.female,bc.medium , op.both, cm.Mercedes, pa.yes,"Taksim"); ;
    Taxi t11 = new Taxi(11,"Aykut",3.7 ,22, g.male,bc.medium , op.both, cm.Mercedes, pa.yes,"Taksim"); ;
    Taxi t12 = new Taxi(12,"Baha",2.9 , 35, g.male,bc.high , op.both, cm.Fiat, pa.yes,"Eminönü"); ;
    Taxi t13 = new Taxi(13,"Batu",3.4 , 23, g.male,bc.high , op.cash, cm.Renault, pa.no,"Eminönü"); ;
    Taxi t14 = new Taxi(14,"Burak",4.8 ,28, g.male,bc.medium , op.online, cm.Fiat, pa.yes,"Üsküdar"); ;
    Taxi t15 = new Taxi(15,"Sibel",4.9 ,20, g.female,bc.low , op.online, cm.Mercedes, pa.yes,"Söğütlüçeşme"); ;
    Taxi t16 = new Taxi(16,"Bilal",3.8 , 36, g.male,bc.low , op.both, cm.Renault, pa.yes,"Söğütlüçeşme"); ;
    Taxi t17 = new Taxi(17,"Esved",3.6 , 38, g.male,bc.medium , op.online, cm.Fiat, pa.no,"Kartal"); ;
    Taxi t18 = new Taxi(18,"Enes",4.8 ,45, g.male,bc.high , op.both, cm.Fiat, pa.yes,"Kartal"); ;
    Taxi t19 = new Taxi(19,"Büşra",4.6 ,36, g.female,bc.high , op.both, cm.Renault, pa.yes,"Levent"); ;
    Taxi t20 = new Taxi(20,"Fatih",3.8 ,37, g.male,bc.high , op.cash, cm.Renault, pa.no,"Levent"); ;
	Taxi t21 = new Taxi(21,"Göktuğ",3.1 , 45, g.male,bc.low , op.cash, cm.Fiat, pa.yes,"Eminönü");
	Taxi t22 = new Taxi(22,"Cem",3.2 , 45, g.male,bc.low , op.cash, cm.Renault, pa.no,"Eminönü");
	
	
	public void addTaxisToStops(Taxi tx) {

		
		tx.beşiktaştaxi.add(t1);
		tx.beşiktaştaxi.add(t2);
		tx.beşiktaştaxi.add(t3);
		tx.beşiktaştaxi.add(t4);
		tx.kadıköytaxi.add(t5);
		tx.kadıköytaxi.add(t6);
		tx.kadıköytaxi.add(t7);
		tx.taksimtaxi.add(t8);
		tx.taksimtaxi.add(t9);
		tx.taksimtaxi.add(t10);
		tx.taksimtaxi.add(t11);
		tx.eminönütaxi.add(t12);
		tx.eminönütaxi.add(t13);
		tx.üsküdartaxi.add(t14);
		tx.söğütlüçeşmetaxi.add(t15);
		tx.söğütlüçeşmetaxi.add(t16);
		tx.kartaltaxi.add(t17);
		tx.kartaltaxi.add(t18);
		tx.leventtaxi.add(t19);
		tx.leventtaxi.add(t20);
		tx.eminönütaxi.add(t21);
		tx.eminönütaxi.add(t22);
	}

}
