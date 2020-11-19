package aplication;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sd = new SimpleDateFormat("dd.MM.yyyy");
		System.out.print("Room number :  ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd.MM.yyyy) :  ");
		Date checkIn = sd.parse(sc.next());
		System.out.print("Check-out date (dd.MM.yyyy) :  ");
		Date checkOut = sd.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date ");
			
		}
		else {
			Reservation reser = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reser);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd.MM.yyyy) :  ");
		    checkIn = sd.parse(sc.next());
		    System.out.print("Check-out date (dd.MM.yyyy) :  ");
			checkOut = sd.parse(sc.next());
			
			Date now = new Date();
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.print("Error in reservation: Reservation dates for update must be future dates ");
				
			}
			else if(!checkOut.after(checkIn)) {
				System.out.print("Error in reservation: Check-out date must be after check-in date ");
				
			}
			else {
			reser.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reser);
			
			}
		}
		
		
		
		sc.close();
	}

}
