package taxisystem;

import taxisystem.Driver.g;
import java.util.Scanner;

import taxisystem.Driver.g;
import taxisystem.Taxi.bc;
import taxisystem.Taxi.cm;
import taxisystem.Taxi.op;
import taxisystem.Taxi.pa;
import taxisystem.Taxi;
public class Main {
	
	
public static void main(String[] args) {
		
		
		  
Taxi tx = new Taxi(0, null, 0, 0, null, null); // İT CREATES EMPTY TAXİ TO START PROGRAM
Taxis txs = new Taxis();  //     İT CREATES ALL TAXİS AROUND İSTANBUL
tx.TaxiCallingService(tx,txs); //TAXİ CALLİNG SYSTEM CONTAİNS ALL PROGRAM WHİCH PLACED İN TAXİ CLASS.
	
		
	     }
}
