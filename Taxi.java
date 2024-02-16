package taxisystem;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import taxisystem.Driver.g;
import taxisystem.Taxi.bc;
import taxisystem.Taxi.cm;
import taxisystem.Taxi.op;
import taxisystem.Taxi.pa;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
public class Taxi extends Driver {
	Scanner sc= new Scanner(System.in);
	public enum op{
		cash,online,both
	}
	public enum pa{
		no,yes
	}
	public enum bc{
		low,medium,high
	}
	public enum cm{
		Fiat,Renault,Mercedes
	}

	bc baggage_capacity;
    op online_payment;
    cm car_model; 
	pa pet_allowence;
	String cp;
	double kilometer ;
	double kilometerfactor  ;
	int bill;
	String toGo;
    final int id;
	User user = new User();
	
	
	public Taxi(int id,String name, double rate, int age, g gender,String cp) {
		super(name, rate, age, gender);
			baggage_capacity= bc.low;
			pet_allowence=pa.no;
			online_payment=op.cash;
			car_model=cm.Fiat;
			this.cp=cp;
			kilometer=0;
			toGo=null;
			this.id=id;
			
	}
	
	public Taxi(int id,String name, double rate, int age, g gender, bc baggage_capacity, op online_payment, cm car_model,
			pa pet_allowence,String cp) {
		super(name, rate, age, gender);
		this.baggage_capacity = baggage_capacity;
		this.online_payment = online_payment;
		this.car_model = car_model;
		this.pet_allowence = pet_allowence;
		this.cp=cp;
		kilometer=0;
		toGo=null;
		this.id=id;
	}

	public  void TaxiCallingService(Taxi tx,Taxis txs) { 
		Scanner sc=new Scanner(System.in);String loc ; int select; TreeMap<Double,String> treeMap = new TreeMap<>()
		;String star="************************************************";
		
		txs.addTaxisToStops(tx);
		System.out.println("TİP : CAR MODEL OF TAXİS WİLL AFFECT YOUR BİLL !!! ");
		System.out.println("TİP : TYPE YOUR LOCATİON AS İT HAS SHOWN !!!\n");
		System.out.println(" \t \t \t \t \t \tWELCOME TO  TAXİ CALLİNG SERVİCE");
		while(true) {
		System.out.println(star+star+star);
		System.out.println("\nPlease type your location in console to find appropriate taxi nearby. \n"
				+ "\nThe locations you can use our app  : Kadıköy -- Üsküdar -- Beşiktaş -- Söğütlüçeşme -- Taksim -- Eminönü -- Kartal -- Levent ");  

		System.out.println("\nPress q to close the app...");
		
		
		loc= sc.next();
		if(loc.equals("q")) {
			System.out.println("\nThanks for choosing our apps.");
			System.out.println("\nYour all cost in today is "+user.totalcost + " ₺");
			break;
		}
		else {
			user.current=loc;
		System.out.println(star+star+star);
		System.out.println("Taxi number in your location is " + showTaxisİnTaxiStops(loc));
		System.out.println(star+star+star);
		System.out.println("Rates of taxis in your location as followed");
		addİtemsToTreeMap(treeMap, returnTaxisİnTheStops(loc));
		showRatesOfTaxis(treeMap);
		treeMap.clear();
		System.out.println(star+star+star);
		printTaxisİnTheStop(returnTaxisİnTheStops(loc));
		System.out.println("\nPlease enter the İD NUMBER of taxi which you want to select");
		select=sc.nextInt();
		if(!(returnTaxi(returnTaxisİnTheStops(loc),select)==null)) 
			TaxiCallingService(returnTaxi(returnTaxisİnTheStops(loc),select));	
		
		else  
			System.out.println("You entered unknown number please try again");
		}
		}
	}
	
	public Taxi returnTaxi(LinkedList<Taxi> taxilist , int idd) {
		for(Taxi t : taxilist ) {
			if(idd==t.id) {
				return t;
			}
		}
		return null;
		
	}
	   
	
	
	
	
	
	public void TaxiCallingService(Taxi t) {
		
		t.addTaxiToTaxiStops(t);
		System.out.println(" \t \t \t \t \t \tWELCOME TO  TAXİ  " + t.id);
		System.out.println("Where do you want to go?  \n \nOptions: Kadıköy -- Üsküdar -- Beşiktaş -- Söğütlüçeşme -- Taksim -- Eminönü -- Kartal -- Levent "); 
		System.out.println("\nYour current location " + user.current + " bill is " + t.bill );
		t.toGo= sc.next();
		t.KilometerCalculator();
		t.BillCalculator(t);
		t.clearLastPosition(t);
		user.current=t.toGo;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		};
		user.totalcost=user.totalcost+t.bill;
		System.out.println("\nYour current location " + user.current + " bill is " + t.bill + " ₺"+ " and "+" total cost is " + user.totalcost + " ₺" );
	//	t.changeLocationOfTaxi(t);
		KilometerClear(t);
		
		t.bill=0;
		
	}
	
	
	
	public void clearLastPosition(Taxi t) {
		
		 if(t.cp.equals("Üsküdar")) {
				üsküdartaxi.remove(t);}
			else if(t.cp.equals("Kadıköy")) {
				kadıköytaxi.remove(t);}
			else if(t.cp.equals("Taksim")) {
				taksimtaxi.remove(t);
			}else if(t.cp.equals("Levent")) {
				leventtaxi.remove(t);
			}else if(t.cp.equals("Söğütlüçeşme")) {
				söğütlüçeşmetaxi.remove(t);
			}else if(t.cp.equals("Beşiktaş")) {
				beşiktaştaxi.remove(t);
			}else if(t.cp.equals("Kartal")) {
				kartaltaxi.remove(t);
			}else if(t.cp.equals("Eminönü")) {
				eminönütaxi.remove(t);}
		
		}
	
	
	
	/*public void changeLocationOfTaxi(Taxi t) {	//This can be used as a alternative system which 
	                                                  * permit taxis to change their locations via users selections.
		
				
	 	KilometerClear(t);
		
		 if(t.cp.equals("Üsküdar")) {
			üsküdartaxi.add(t);}
		else if(t.cp.equals("Kadıköy")) {
			kadıköytaxi.add(t);}
		else if(t.cp.equals("Taksim")) {
			taksimtaxi.add(t);
		}else if(t.cp.equals("Levent")) {
			leventtaxi.add(t);
		}else if(t.cp.equals("Söğütlüçeşme")) {
			söğütlüçeşmetaxi.add(t);
		}else if(t.cp.equals("Beşiktaş")) {
			beşiktaştaxi.add(t);
		}else if(t.cp.equals("Kartal")) {
			kartaltaxi.add(t);
		}else if(t.cp.equals("Eminönü")) {
			eminönütaxi.add(t);}   
			
}
  
	*/
	public void KilometerClear(Taxi t) // it clears toGo,kilometer and change current position
	{  
		kilometer=0;
		
		t.toGo=null;
			
	}

	
	 public  void KilometerCalculator() { //it gives real kilometer value between places  
		 
		 
		 
			switch(cp) {
			case "Beşiktaş" : 
				switch(toGo) {
				case "Taksim" :
					kilometer=7.7; break;
				case "Eminönü" :
					kilometer=15.4; break;
				case "Levent" :	
					kilometer=3; break;
				case "Üsküdar" :
					kilometer=9.2;break;
				case "Kadıköy" :
					kilometer=15;break;
				case "Söğütlüçeşme" :
					kilometer=21.2;break;
				case "Kartal":
					kilometer=34.2;break;
				default :
					 System.out.println("There is a something wrong. Please check again");
				}break;
				
			case "Taksim" : 	
				switch(toGo) {
				case "Beşiktaş" :
					kilometer=7.7;break;
				case "Eminönü" :
					kilometer=5.5;break;
				case "Levent" :	
					kilometer=7.9;break;
				case "Üsküdar" :
					kilometer=10.3;break;
				case "Kadıköy" :
					kilometer=16.1;break;
				case "Söğütlüçeşme" :	
					kilometer=16;break;
				case "Kartal":
					kilometer=35.3;break;
				default :
					 System.out.println("There is a something wrong. Please check again");
				}break;
			
			case "Eminönü" : 
				switch(toGo) {
				case "Taksim" :
					kilometer=5.5;break;
				case "Beşiktaş" :
					kilometer=15.4;break;
				case "Levent" :	
					kilometer=14.5;break;
				case "Üsküdar" :
					kilometer=14;break;
				case "Kadıköy" :
					kilometer=15.8;break;
				case "Söğütlüçeşme" :	
					kilometer=30.1;break;
				case "Kartal":
					kilometer=32.2;break;
				default :
					 System.out.println("There is a something wrong. Please check again");
				}break;
				
			case "Levent" : 
				switch(toGo) {
				case "Taksim" :
					kilometer=7.9;break;
				case "Eminönü" :
					kilometer=14.5;break;
				case "Beşiktaş" :	
					kilometer=3;break;
				case "Üsküdar" :
					kilometer=17.9;break;
				case "Kadıköy" :
					kilometer=14.2;break;
				case "Söğütlüçeşme" :	
					kilometer=12.6;break;
				case "Kartal":
					kilometer=33.4;break;
				default :
					 System.out.println("There is a something wrong. Please check again");
				}break;
			
			case "Üsküdar" : 
				switch(toGo) {
				case "Taksim" :
					kilometer=10.3;break;
				case "Eminönü" :
					kilometer=14;break;
				case "Levent" :	
					kilometer=17.9;break;
				case "Beşiktaş":
					kilometer=9.2;break;
				case "Kadıköy" :
					kilometer=7.7;break;
				case "Söğütlüçeşme" :
					kilometer=7.7;break;
				case "Kartal" :	
					kilometer=27.2;break;
				default :
					 System.out.println("There is a something wrong. Please check again");
				}break;
				
			case "Söğütlüçeşme" : 	
				switch(toGo) {
				case "Beşiktaş" :
					kilometer=21.2;break;
				case "Eminönü" :
					kilometer=30.1;break;
				case "Levent" :	
					kilometer=12.6;break;
				case "Taksim":
					kilometer=16;break;
				case "Kadıköy" :
					kilometer=3;break;
				case "Üsküdar" :
					kilometer=7.7;break;
				case "Kartal" :	
					kilometer=23;break;
				default :
					 System.out.println("There is a something wrong. Please check again");
				}break;
			
			case "Kartal" : 
				switch(toGo) {
				case "Taksim" :
					kilometer=35.3;break;
				case "Beşiktaş" :
					kilometer=34.2;break;
				case "Levent" :	
					kilometer=33.4;break;
				case "Eminönü":
					kilometer=32.2;break;
				case "Kadıköy" :
					kilometer=24;break;
				case "Üsküdar" :
					kilometer=27.2;break;
				case "Söğütlüçeşme" :	
					kilometer=23;break;
				default :
					 System.out.println("There is a something wrong. Please check again");
				}break;
				
			case "Kadıköy" : 
				switch(toGo) {
				case "Taksim" :
					kilometer=16.1;break;
				case "Eminönü" :
					kilometer=15.8;break;
				case "Beşiktaş" :	
					kilometer=15;break;
				case "Levent":
					kilometer=14.2;break;
				case "Üsküdar" :
					kilometer=7.7;break;
				case "Söğütlüçeşme" :
					kilometer=3;break;
				case "Kartal" :	
					kilometer=24 ;break;
				default :
					 System.out.println("There is a something wrong. Please check again");
				}break;
			default :
				 System.out.println("There is a something wrong. Please check again");
				
				}
			
				

	 }
	public double  BillCalculator(Taxi aa) //it calculates bill based on vehicles model opening taxi cost 13₺
	{
	
		switch(aa.car_model) {
		
		case Fiat: kilometerfactor=8;
		bill=(int) (kilometerfactor*kilometer);break;
		case Renault: kilometerfactor=10;
		bill= (int)(kilometerfactor*kilometer);break;
		case Mercedes: kilometerfactor=15;
			bill= (int)(kilometerfactor*kilometer);break;
		}
		if(!(bill==0)) {
			bill=bill+13; // opening fee of taxi
		}
		return bill;
		}
			
	
		

			LinkedList<Taxi> üsküdartaxi = new LinkedList<>();
			LinkedList<Taxi> beşiktaştaxi = new LinkedList<>();
			LinkedList<Taxi> söğütlüçeşmetaxi = new LinkedList<>();
			LinkedList<Taxi> kartaltaxi = new LinkedList<>();
			LinkedList<Taxi> kadıköytaxi = new LinkedList<>();
			LinkedList<Taxi> eminönütaxi = new LinkedList<>();
			LinkedList<Taxi> leventtaxi = new LinkedList<>();
			LinkedList<Taxi> taksimtaxi = new LinkedList<>();
			
			public void addTaxiToTaxiStops(Taxi t){
				 if(t.cp.equals("Üsküdar")) {
						üsküdartaxi.add(t);}
					else if(t.cp.equals("Kadıköy")) {
						kadıköytaxi.add(t);}
					else if(t.cp.equals("Taksim")) {
						taksimtaxi.add(t);
					}else if(t.cp.equals("Levent")) {
						leventtaxi.add(t);
					}else if(t.cp.equals("Söğütlüçeşme")) {
						söğütlüçeşmetaxi.add(t);
					}else if(t.cp.equals("Beşiktaş")) {
						beşiktaştaxi.add(t);
					}else if(t.cp.equals("Kartal")) {
						kartaltaxi.add(t);
					}else if(t.cp.equals("Eminönü")) {
						eminönütaxi.add(t);}
				
				
			}
			
			public int showTaxisİnTaxiStops(String loc){
				    if(loc.equals("Üsküdar")) {
					    return	üsküdartaxi.size();}
					else if(loc.equals("Kadıköy")) {
						return	kadıköytaxi.size();}
					else if(loc.equals("Taksim")) {
						return	taksimtaxi.size();
					}else if(loc.equals("Levent")) {
						return	leventtaxi.size();
					}else if(loc.equals("Söğütlüçeşme")) {
						return	söğütlüçeşmetaxi.size();
					}else if(loc.equals("Beşiktaş")) {
					    return	beşiktaştaxi.size();
					}else if(loc.equals("Kartal")) {
					    return	kartaltaxi.size();
					}else if(loc.equals("Eminönü")) {
					   return	eminönütaxi.size();}
				
				    	return 99999;
			}
			
			
			public LinkedList<Taxi> returnTaxisİnTheStops(String loc) {
				
				 if(loc.equals("Üsküdar")) {
					    return	üsküdartaxi;}
					else if(loc.equals("Kadıköy")) {
						return	kadıköytaxi;}
					else if(loc.equals("Taksim")) {
						return	taksimtaxi;
					}else if(loc.equals("Levent")) {
						return	leventtaxi;
					}else if(loc.equals("Söğütlüçeşme")) {
						return	söğütlüçeşmetaxi;
					}else if(loc.equals("Beşiktaş")) {
					    return	beşiktaştaxi;
					}else if(loc.equals("Kartal")) {
					    return	kartaltaxi;
					}else if(loc.equals("Eminönü")) {
					   return	eminönütaxi;}
				
				return null;
				
			}
			
			
			
			public void addİtemsToTreeMap(TreeMap<Double,String> treemap,LinkedList<Taxi> linkedlist) {
				double rate; String name;
					for(Taxi t: linkedlist) {
					rate= t.rate;
					name=t.name;
					treemap.put(rate, name);
					}
			}
			
			
			
			public void showRatesOfTaxis(TreeMap<Double,String> treemap) {
				
				Set set = treemap.entrySet();
				Iterator iterator = set.iterator();
				
				while(iterator.hasNext()) {
					Map.Entry item = (Map.Entry) iterator.next();
		            System.out.println(item.getKey() + " = " + item.getValue());
				}
				
				
			}
			
			
			public void printTaxisİnTheStop(LinkedList<Taxi> linkedlist) {
				String star="************************************************";
				for(Taxi t: linkedlist) {
					
					System.out.println(t.toString());
					System.out.println(star+star+star);
				}
				
			}
		
			@Override
			public String toString() {
				return "*TAXİ* İd: " + id + "|| Name: " + name + "|| Gender: " + gender + "|| Age: " + age + "|| Car Model: " + car_model + "|| Baggage Capacity "
						+ baggage_capacity +"|| Payment Method: "+ online_payment  + "|| Pet Allowence: " + pet_allowence   ;
			}

			
			
			
			
		
			
	
			
	
	
	
	
	
	
	
	
	
	
	
	
}
