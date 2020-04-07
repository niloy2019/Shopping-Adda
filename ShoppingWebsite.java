package project;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

//Created a Customer Class to Store the Details of customer 
class Customer{

	private String Item;
	private double cost;
	private int quantity;

	
	public Customer(String item, double cost, int quantity) {
		Item = item;
		this.cost = cost;
		this.quantity = quantity;
	}

	public String getItem() {
		return Item;
	}


	public void setItem(String item) {
		Item = item;
	}


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}

//Main Class of this Project
public class ShoppingWebsite {

	static ArrayList<Customer> ar=new ArrayList<Customer>();
	static Scanner scan = new Scanner(System.in);
	static DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
	static String dateString = dateFormat.format(new Date()).toString();
	static LocalDate d=LocalDate.now();

	public static void main(String[] args) {
		Scanner scan1 = new Scanner(System.in);
		System.out.print("\n\t *********************************************************     WELCOME TO SHOPPINGADDA     **********************************************************");
		System.out.print("\n\n\t "+d.getDayOfWeek()+","+java.time.LocalDate.now()+"\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t     "+dateString);  
		System.out.print("\n\t ****************************************************************************************************************************************************");
		System.out.print("\n\t                                                          Buy One , Get One Absolutely FREE !!!");
		System.out.print("\n\t Enter Your Name : ");
		String s=scan1.nextLine();
		System.out.print("\n\t Enter Your Phone number(10digit) : ");
		long n=0l;
		String a="";
		do{
			if(scan.hasNextLong()){
				 n=scan.nextLong();
				 a=Long.toString(n);
			}else {
				scan.next();
				scan.nextLine();
			}
			
			if(a.length()==10) {
				break;
			}else {
				System.out.print("\n\t Invalid number!!");
				System.out.print("\n\n\t Re-Enter Your Phone number(10digit) : ");
			}
		}while(true);
		System.out.println("\n\t Welcome "+s+" to Our Shopping Website ! Make your Shopping Experience Better with Us .");
		System.out.println("\n\n\n");
		home();
		scan1.close();
	}

	public static void home() {
		
		System.out.print("\n\t **************************************************************  WELCOME TO HOME PAGE  **************************************************************\n" + 
				                "\n\t CATEGORIES\n" + 
		                		"\t 1. Cloths\n" + 
		                		"\t 2. Electronics\n" + 
		                		"\t 3. HomeApplication\n" + 
								"\t 4. Books\n" + 
								"\t 5. Healths\n" + 
								"\t 6. FootWears\n" + 
								"\t 7. View Cart\n" + 
								"\t 8. Exit\n" + 
								"\n\t select choice : ");
		
		int choice = ShoppingWebsite.input(8);
		
		switch (choice) {
	
		case 1:
			Cloths.cloths();
			break;
			
		case 2:
			Electronics.electronics();
			break;
		
		case 3:
			HomeApplication.homeApplication();
			break;
		
		case 4:
			Books.books();
			break;
	
		case 5:
			Health.health();
			break;
	
		case 6:
			Footwears.footwears();
			break;
		
		case 7:
			cart();
			break;
		
		case 8:
			bill();
			break;

		default:
			break;
		}
		
		scan.close();
	}
	
//	Method the Measure the Quantity
	static void quantity(Customer c,int count){
		
		System.out.print("\tEnter the Quantity : "); 
		int q=scan.nextInt();
		System.out.print("\tAre you sure want to add 2 items to cart (Y/N) : ");
		if(scan.next().equalsIgnoreCase("Y")) {
			c.setQuantity(q);
			ShoppingWebsite.home();
		}else {
			ar.remove(c);
			ShoppingWebsite.home();
		}
	}
	
	public static void  cart() {
		
		System.out.println("\n\n\t **************************************** Your Cart ****************************************\n");
		System.out.print("\t "+d.getDayOfWeek()+","+java.time.LocalDate.now()+"\t\t\t\t\t\t\t\t   "+dateString);
		System.out.print("\n\t __________________________________________________________________________________________\n\n");
		if(ar.size()==0) {
			System.out.println("\n\t                             YOUR CART IS EMPTY !! ");
			System.out.print("\n\t __________________________________________________________________________________________\n");
		}else {
			
				int i=0;
				System.out.format("\t   %-20s%-20s%-20s%-20s%-20s","SI.No","Item"," Cost Rs","Qty","Total" );
				System.out.print("\n\t __________________________________________________________________________________________");
				for (Customer customer : ar) {
					
					System.out.format("\n\n\t   %-20s%-20s%-20s%-20s%-20s",++i,customer.getItem(),customer.getCost(),customer.getQuantity(),(customer.getCost()*customer.getQuantity()) );
				}
				
				System.out.print("\n\t __________________________________________________________________________________________");
				System.out.print("\n\n\t Do you want to remove from Cart? (Y/N)   :  ");
				if(scan.next().equalsIgnoreCase("y")) {
					
					System.out.print("\n\t Enter the SI.No of item to be removed : ");
					int p=scan.nextInt();
					System.out.print("\n\t Enter the No of Quantity to be Removed : ");
					int q=scan.nextInt();
					
					if(q>=ar.get(p-1).getQuantity()) {
						ar.remove(p-1);
					}else {
						int m=ar.get(p-1).getQuantity()-q;
						ar.get(p-1).setQuantity(m);
					}
					System.out.println("\n\t Item Removed Successfully...\n");
				}
			}
		      home();
		       
		}
	
	
	public static void bill() {
		System.out.print(   "\n\t 1.Bill"
			            	+ "\n\t 2.Home"
						    + "\n\t 3.Exit "
						    + "\n\t Select choice : ");
		int choice = scan.nextInt();
		
		switch (choice) {
		
			case 1:
				finalBill();
				break;
				
			case 2:
				home();
				break;
			
			case 3:
				System.exit(0);
				break;
	
			default:
				break;
				
		}
		
	}
	
	
	public static void finalBill() {
		int i=0;
		double total=0;
		System.out.print("\n\n\t *********************************    ShoppingAdda Bill   *********************************");
		System.out.print("\n\t "+d.getDayOfWeek()+","+java.time.LocalDate.now()+"\t\t\t\t\t\t\t\t   "+dateString);  
		System.out.print("\n\t __________________________________________________________________________________________\n\n");
		if(ar.size()==0) {
			System.out.println("\n\t                             YOUR CART IS EMPTY !!! ");
			System.out.print("\n\t                       BUY SOMETHING TO GENERATE THE BILL !!! ");
			System.out.print("\n\t __________________________________________________________________________________________\n\n");
			home();
		}else {
			
			System.out.print("\n\t __________________________________________________________________________________________");
//		System.out.print("\t __________________________________________________________________________________________\n\n");
			System.out.format("\n\n\t   %-20s%-20s%-20s%-20s%-20s","SI.No","Item"," Cost Rs","Qty","Total" );
			System.out.print("\n\t __________________________________________________________________________________________");
			for (Customer customer : ar) {
				
				System.out.format("\n\n\t   %-20s%-20s%-20s%-20s%-20s",++i,customer.getItem(),customer.getCost(),customer.getQuantity(),(customer.getCost()*customer.getQuantity()) );
				total=total+(customer.getCost()*(customer.getQuantity()));
			}
			System.out.print("\n\t __________________________________________________________________________________________");
			System.out.print("\n\n\t Sub Total       :\t\t\t\t\t\t\t\t   "+total);
			System.out.print("\n\t __________________________________________________________________________________________");
			System.out.print("\n\n\t CGST 	    @9%  :\t\t\t\t\t\t\t\t   "+(float)(total*0.09));
			System.out.print("\n\n\t SGST 	    @9%  :\t\t\t\t\t\t\t\t   "+(float)(total*0.09));
			System.out.print("\n\n\t Total  GST@18%  :\t\t\t\t\t\t\t\t   "+(float)(total*0.18));
			total=total+(total*0.09)+(total*0.09)+(total*0.18);
			System.out.print("\n\t __________________________________________________________________________________________");
			System.out.print("\n\n\t Grand Total     :\t\t\t\t\t\t\t\t   "+total+" Rs");
			System.out.print("\n\t __________________________________________________________________________________________");
			System.out.print("\n\n\t                    Thank you for visiting *SHOPPINGADDA*                                   ");
			System.out.print("\n\t                              Have a Nice Day !                                    ");
			System.out.print("\n\t                                Visit again....                                      ");
			System.out.print("\n\t __________________________________________________________________________________________");
		}
		
	}
	
	
	
	static int input(int b) {
		int choice=0;
		int count=0;
	    
		do{
			if(count>0) {
				System.out.print("\n\t Re-type Your Choice  : ");
			}

			if(scan.hasNextInt()) {
				choice=scan.nextInt();
			}else {
				scan.next();
				scan.nextLine();
			}
			count++;
			
	    }while(choice>b||choice<1);
		
		return choice;
				
	}

}



class Cloths{
	static Scanner scan = new Scanner(System.in);
	public static void cloths() {
		System.out.print("\n\t **********************************************************************************************************\n" + 
						   "\t CLOTHS      \n" + 
						   "\t 1. Men's    \n" + 
						   "\t 2. Women's  \n" + 
						   "\t 3. Kid's    \n" + 
						   "\t 4. Home page\n" + 
						   "\t 5. Exit     \n" + 
						   "\n\t select choice : " );
		int choiceCloths = ShoppingWebsite.input(5);
		
		switch (choiceCloths) {
		case 1:
			Cloths.mens();
			break;

		case 2:
			Cloths.womens();
			break;
		
		case 3:
			Cloths.kids();
			break;
		
		case 4:
			ShoppingWebsite.home();
			break;
		
		case 5:
			ShoppingWebsite.home();
			break;

		default:
			break;
		}
	}
	
	public static void mens(){
		System.out.print("\n\t *********************************************************************************\n"+
						   "\t MEN'S             \n" + 
				           "\t 1. Tshirts        \n" +  
				           "\t 2. Shirts         \n" + 
				           "\t 3. Pants          \n" + 
				           "\t 4. Shorts         \n" + 
				           "\t 5. Previous page  \n" + 
				           "\t 6. Home Page      \n" + 
				           "\t 7. Exit           \n" + 
						   "\n\t Select choice : ");
		int mens = ShoppingWebsite.input(7);
		
		switch (mens) {
		
			case 1:
				Clothes.tShirts();
				break;
				
			case 2:
				Clothes.shirts();
				break;
			
			case 3:
				Clothes.Pants();
				break;
			
			case 4:
				Clothes.shorts();;
				break;
	
			case 5:
				Cloths.cloths();
				break;
			
			case 6:
				ShoppingWebsite.home();;
				break;
				
			case 7:
				cloths();
				break;
	
			default:
				System.out.println("Invalid Input !!!");
				break;
		}
	}
	
	public static void womens(){
		System.out.print("\n\t *********************************************************************************\n"+
						   "\t WOMEN'S             \n" + 
						   "\t 1. Sarees          \n" +  
						   "\t 2. Kurtas & Kurtis \n" +  
				           "\t 3. Tshirts         \n" +  
				           "\t 4. Shirts          \n" + 
				           "\t 5. Previous page   \n" + 
				           "\t 6. Home Page       \n" + 
				           "\t 7. Exit            \n" + 
						   "\n\t Select choice : ");
		int mens = ShoppingWebsite.input(7);
		
		switch (mens) {
		
			case 1:
				Clothes.sarees();
				break;
				
			case 2:
				Clothes.kurti();
				break;
			
			case 3:
				Clothes.tShirts();
				break;
			
			case 4:
				Clothes.shirts();
				break;
	
			case 5:
				Cloths.cloths();
				break;
				
			case 6:
				ShoppingWebsite.home();
				break;
				
			case 7:
				cloths();
				break;	
	
			default:
				break;
		}
	}
	
	public static void kids(){
		System.out.print("\n\t *********************************************************************************\n"+
						   "\t KID'S             \n" + 
				           "\t 1. Tshirts        \n" +  
				           "\t 2. Shirts         \n" + 
				           "\t 3. Pants          \n" + 
				           "\t 4. Shorts         \n" + 
				           "\t 5. Previous page  \n" + 
				           "\t 6. Home Page      \n" + 
				           "\t 7. Exit           \n" + 
						   "\n\t Select choice : ");
		int mens = ShoppingWebsite.input(7);
		
		switch (mens) {
		
			case 1:
				Clothes.tShirts();
				break;
				
			case 2:
				Clothes.shirts();
				break;
			
			case 3:
				Clothes.Pants();
				break;
			
			case 4:
				Clothes.shorts();;
				break;
	
			case 5:
				Cloths.cloths();
				break;
			
			case 6:
				ShoppingWebsite.home();;
				break;
				
			case 7:
				cloths();
				break;
	
			default:
				System.out.println("Invalid Input !!!");
				break;
		}
	}
	
}


class Clothes{
	static Customer c;
	static int count=0;
	static Scanner scan = new Scanner(System.in);
	public static void tShirts() {
		System.out.print("\n\t .....................................................\r\n" + 
						   "\n\tT SHIRTS                          \n" + 
						   "\t1. Puma \t\t\t\t Rate : Rs 900            \n" + 
						   "\t2. U.S.polo \t\t\t\t Rate : Rs 850        \n" + 
						   "\t3. PeterEnglend \t\t\t Rate : Rs 840      \n" + 
						   "\t4. Adidas \t\t\t\t Rate : Rs 860          \n" + 
						   "\t5. Lacoste \t\t\t\t Rate : Rs 950         \n" + 
						   "\t6. Gucci \t\t\t\t Rate : Rs 908           \n" + 
						   "\t7. Previouspage                        \n" + 
						   "\t8. Home Page                           \n" + 
						   "\t9. Exit                                \n" + 
						   "\n\tSelect choice : ");
		int tShirts =  ShoppingWebsite.input(9);
		switch (tShirts){
			case 1:
				c=new Customer("Puma",900,0);
				count++;
				break;
				
			case 2:
				c=new Customer("U.S.polo",850,0);
				count++;
				break;
			
			case 3:
				c=new Customer("PeterEngland",840,0);
				count++;
				break;

			case 4:
				c=new Customer("Adidas",860,0);
				count++;
				break;
			
			case 5:
				c=new Customer("Lacoste",950,0);
				count++;
				break;
			
			case 6:
				c=new Customer("Gucci",908,0);
				count++;
				break;
			
			case 7:
				Cloths.mens();
				break;
			
			case 8:
				ShoppingWebsite.home();
				break;
			
			case 9:
				ShoppingWebsite.cart();
				break;
	
			default:
				break;
		}
		
		if(count!=0){
			ShoppingWebsite.ar.add(c);
			ShoppingWebsite.quantity(c,count);
			count=0;
		}
	}
	
	
	public static void Pants() {
		System.out.print("\n\t .....................................................\r\n" + 
						   "\n\tT SHIRTS                          \n" + 
						   "\t1. AD & AV                       Rate : Rs 1500  \n" + 
						   "\t2. AAKRITHI                      Rate : Rs 2000  \n" + 
						   "\t3. Van Heusen                    Rate : Rs 2500  \n" + 
						   "\t4. Indian Terrain                Rate : Rs 4000  \n" + 
						   "\t5. Raymond                       Rate : Rs 1150  \n" + 
						   "\t6. Levi's                        Rate : Rs 1650  \n" + 
						   "\t7. Previouspage                                  \n" + 
						   "\t8. Home Page                                     \n" + 
						   "\t9. Exit                                          \n" + 
						   "\n\tSelect choice : ");
		int tShirts = ShoppingWebsite.input(9);
		switch (tShirts){
			case 1:
				c=new Customer("AD & AV ",1500,0);
				count++;
				break;
				
			case 2:
				c=new Customer("AAKRITHI ",2000,0);
				count++;
				break;
			
			case 3:
				c=new Customer("Van Heusen",2500,0);
				count++;
				break;

			case 4:
				c=new Customer("Indian Terrain",4000,0);
				count++;
				break;
			
			case 5:
				c=new Customer("Raymond",1150,0);
				count++;
				break;
			
			case 6:
				c=new Customer("Levi's",1650,0);
				count++;
				break;
			
			case 7:
				Cloths.mens();
				break;
			
			case 8:
				ShoppingWebsite.home();
				break;
			
			case 9:
				ShoppingWebsite.cart();
				break;
	
			default:
				break;
		}
		
		if(count!=0){
			ShoppingWebsite.ar.add(c);
			ShoppingWebsite.quantity(c,count);
			count=0;
		}
	}
	
	public static void shirts() {
		System.out.print("\n\t .....................................................\r\n" + 
						   "\n\tT SHIRTS                                       \n" + 
						   "\t1. U.S. Polo Assn        Rate : Rs 1500  \n" + 
						   "\t2. Peter England University      Rate : Rs 950   \n" + 
						   "\t3. Highlander                    Rate : Rs 1000  \n" + 
						   "\t4. FINIVO FASHION                Rate : Rs 2000  \n" + 
						   "\t5. DEELMO                        Rate : Rs 650   \n" + 
						   "\t6. ShopyBucke                    Rate : Rs 800   \n" + 
						   "\t7. Previouspage                                  \n" + 
						   "\t8. Home Page                                     \n" + 
						   "\t9. Exit                                          \n" + 
						   "\n\tSelect choice : ");
		int tShirts = ShoppingWebsite.input(9);
		switch (tShirts){
			case 1:
				c=new Customer("Louis Philippe Sport",1500,0);
				count++;
				break;
				
			case 2:
				c=new Customer("Peter England University",950,0);
				count++;
				break;
			
			case 3:
				c=new Customer("Highlander",1000,0);
				count++;
				break;

			case 4:
				c=new Customer("FINIVO FASHION",2000,0);
				count++;
				break;
			
			case 5:
				c=new Customer("DEELMO",650,0);
				count++;
				break;
			
			case 6:
				c=new Customer("ShopyBucke",800,0);
				count++;
				break;
			
			case 7:
				Cloths.mens();
				break;
			
			case 8:
				ShoppingWebsite.home();
				break;
			
			case 9:
				ShoppingWebsite.cart();
				break;
	
			default:
				break;
		}
		
		if(count!=0){
			ShoppingWebsite.ar.add(c);
			ShoppingWebsite.quantity(c,count);
			count=0;
		}
	}
	public static void shorts() {
		System.out.print("\n\t .....................................................\r\n" + 
						   "\n\tT SHIRTS                                           \n" + 
						   "\t1. U.S. Polo Assn                    Rate : Rs 489   \n" + 
						   "\t2. People                            Rate : Rs 824   \n" + 
						   "\t3. Jack & Jones                      Rate : Rs 2999  \n" + 
						   "\t4. McDavid                           Rate : Rs 799   \n" + 
						   "\t5. Tommy Hilfiger                    Rate : Rs 1190  \n" + 
						   "\t6. Puma                              Rate : Rs 800   \n" + 
						   "\t7. Previouspage                                      \n" + 
						   "\t8. Home Page                                         \n" + 
						   "\t9. Exit                                              \n" + 
						   "\n\tSelect choice : ");
		int tShirts =ShoppingWebsite.input(9);
		switch (tShirts){
			case 1:
				c=new Customer("U.S. Polo Assn ",489,0);
				count++;
				break;
				
			case 2:
				c=new Customer("People",824,0);
				count++;
				break;
			
			case 3:
				c=new Customer("Jack & Jones",2999,0);
				count++;
				break;

			case 4:
				c=new Customer("McDavid ",799,0);
				count++;
				break;
			
			case 5:
				c=new Customer("Tommy Hilfiger",1190,0);
				count++;
				break;
			
			case 6:
				c=new Customer("Puma",800,0);
				count++;
				break;
			
			case 7:
				Cloths.mens();
				break;
			
			case 8:
				ShoppingWebsite.home();
				break;
			
			case 9:
				ShoppingWebsite.cart();
				break;
	
			default:
				break;
		}
		
		if(count!=0){
			ShoppingWebsite.ar.add(c);
			ShoppingWebsite.quantity(c,count);
			count=0;
		}
	}
	
	public static void sarees() {
		System.out.print("\n\t .....................................................\r\n" + 
						   "\n\tSarees                          \n" + 
						   "\t1. Manohari                          Rate : Rs 3999  \n" + 
						   "\t2. M.S.Retail                        Rate : Rs 7145  \n" + 
						   "\t3. INDIAN BEAUTIFUL                  Rate : Rs 1000  \n" + 
						   "\t4. Keya Seth Exclusive               Rate : Rs 10000 \n" + 
						   "\t5. Banarasi Silk Works               Rate : Rs 5159  \n" + 
						   "\t6. HerClozet                         Rate : Rs 5800  \n" + 
						   "\t7. Previouspage                                      \n" + 
						   "\t8. Home Page                                         \n" + 
						   "\t9. Exit                                              \n" + 
						   "\n\tSelect choice : ");
		int tShirts = ShoppingWebsite.input(9);
		switch (tShirts){
			case 1:
				c=new Customer("Manohari",3999,0);
				count++;
				break;
				
			case 2:
				c=new Customer("M.S.Retail",7145,0);
				count++;
				break;
			
			case 3:
				c=new Customer("INDIAN BEAUTIFUL",1000,0);
				count++;
				break;

			case 4:
				c=new Customer("Keya Seth Exclusive",10000,0);
				count++;
				break;
			
			case 5:
				c=new Customer("Banarasi Silk Works",5159,0);
				count++;
				break;
			
			case 6:
				c=new Customer("HerClozet",5800,0);
				count++;
				break;
			
			case 7:
				Cloths.mens();
				break;
			
			case 8:
				ShoppingWebsite.home();
				break;
			
			case 9:
				ShoppingWebsite.cart();
				break;
	
			default:
				break;
		}
		
		if(count!=0){
			ShoppingWebsite.ar.add(c);
			ShoppingWebsite.quantity(c,count);
			count=0;
		}
	}
	
	
	public static void kurti() {
		System.out.print("\n\t .....................................................\r\n" + 
						   "\n\tSarees                          \n" + 
						   "\t1. Biba                               Rate : Rs 2879  \n" + 
						   "\t2. MELANGE By Lifestyle               Rate : Rs 3000  \n" + 
						   "\t3. Ada                                Rate : Rs 3411  \n" + 
						   "\t4. All About You                      Rate : Rs 3699  \n" + 
						   "\t5. Tuk Tuks The Store                 Rate : Rs 2512  \n" + 
						   "\t6. W                                  Rate : Rs 2519  \n" + 
						   "\t7. Previouspage                                       \n" + 
						   "\t8. Home Page                                          \n" + 
						   "\t9. Exit                                               \n" + 
						   "\n\tSelect choice : ");
		int tShirts = ShoppingWebsite.input(9);
		switch (tShirts){
			case 1:
				c=new Customer("Biba",2879,0);
				count++;
				break;
				
			case 2:
				c=new Customer("MELANGE By Lifestyle",3000,0);
				count++;
				break;
			
			case 3:
				c=new Customer("Ada",1000,0);
				count++;
				break;

			case 4:
				c=new Customer("All About You ",3699,0);
				count++;
				break;
			
			case 5:
				c=new Customer("Tuk Tuks The Store",2512,0);
				count++;
				break;
			
			case 6:
				c=new Customer("w",2519,0);
				count++;
				break;
			
			case 7:
				Cloths.mens();
				break;
			
			case 8:
				ShoppingWebsite.home();
				break;
			
			case 9:
				ShoppingWebsite.cart();
				break;
	
			default:
				break;
		}
		
		if(count!=0){
			ShoppingWebsite.ar.add(c);
			ShoppingWebsite.quantity(c,count);
			count=0;
		}
	}
}

class Electronics{
	
	static Customer c;
	static int count=0;
	static Scanner scan = new Scanner(System.in);
	
	public static void electronics() {
		System.out.print("\n\t **********************************************************************************************************");
		System.out.print("\n\t Electronics     \n" + 
			            	"\t 1. Mobile's         \n" + 
		            		"\t 2. Laptop's       \n" + 
			            	"\t 3. Washing machine  \n" + 
			            	"\t 4. Telivision         \n" + 
		             		"\t 5. Camera's         \n" + 
				            "\t 6. Previous Page    \n" + 
	             			"\t 7. Home Page        \n" + 
				            "\n\t select choice:");
		
		int choice = ShoppingWebsite.input(7);
	
		switch (choice) {
		
			case 1:
				mobile();
				break;
		
			case 2:
				laptop();
				break;
	
			case 3:
				washingMachine();
				break;
		
			case 4:
				television();
				break;
			
			case 5:
				cameras();
				break;
			
			case 6:
				ShoppingWebsite.home();
				break;
			
			case 7:
				ShoppingWebsite.home();
				break;
				
			default:
				break;
		}
	}
	
	
	public static void mobile() {
		System.out.print("\n\t .....................................................\r\n" + 
						   "\n\tMobiles                          \n" + 
						   "\t1. MI Note 4                Rate : Rs 12,999/-            \n" + 
						   "\t2. Honor 9 X                Rate : Rs 12,999/-        \n" + 
						   "\t3. realme k20               Rate : Rs 19,999/-     \n" + 
						   "\t4. Apple iPhone X           Rate : Rs 83,199/-          \n" + 
						   "\t5. Samsung S9 Plus          Rate : Rs 27,999/-         \n" + 
						   "\t6. Poco F1                  Rate : Rs 14,999/-           \n" + 
						   "\t7. Previouspage                        \n" + 
						   "\t8. Home Page                           \n" + 
						   "\t9. Exit                                \n" + 
						   "\n\tSelect choice : ");

		int mobile = ShoppingWebsite.input(9);
		switch (mobile){
			case 1:
				c=new Customer("MI Note 4 ",12999,0);
				count++;
				break;
				
			case 2:
				c=new Customer("Honor 9 X",12999,0);
				count++;
				break;
			
			case 3:
				c=new Customer("realme k20",19999,0);
				count++;
				break;

			case 4:
				c=new Customer("Apple iPhone X",83199,0);
				count++;
				break;
			
			case 5:
				c=new Customer("Samsung S9 Plus",27999,0);
				count++;
				break;
			
			case 6:
				c=new Customer("Poco F1",14999,0);
				count++;
				break;
			
			case 7:
				Cloths.mens();
				break;
			
			case 8:
				ShoppingWebsite.home();
				break;
			
			case 9:
				ShoppingWebsite.cart();
				break;
	
			default:
				break;
		}
		
		if(count!=0){
			ShoppingWebsite.ar.add(c);
			ShoppingWebsite.quantity(c,count);
			count=0;
		}
	}
	
	

	public static void laptop() {
		System.out.print("\n\t .....................................................\r\n" + 
				"\n\tMobiles                          \n" + 
				"\t1. Lenovo Core i7 8th Gen                        Rate : Rs 54,999/-             \n" + 
				"\t2. Apple MacBook Air Core i5 8th Gen             Rate : Rs 1,07,990/-           \n" + 
				"\t3. HP Omen Core i7 9th Gen                       Rate : Rs 81,990/-             \n" + 
				"\t4. Acer Predator Helios 300 Core i7 9th Gen      Rate : Rs 1,09,990/-           \n" + 
				"\t5. Microsoft Surface Laptop 2 Core i5 8th Gen    Rate : Rs 76,490/-             \n" + 
				"\t6. Apple MacBook Air Core i5 8th Gen             Rate : Rs 1,14,990/-           \n" + 
				"\t7. Previouspage                        \n" + 
				"\t8. Home Page                           \n" + 
				"\t9. Exit                                \n" + 
				"\n\tSelect choice : ");
		
		int mobile = ShoppingWebsite.input(9);
		switch (mobile){
		case 1:
			c=new Customer("Lenovo Core i7",54999,0);
			count++;
			break;
			
		case 2:
			c=new Customer("Apple MacBook Air",107990,0);
			count++;
			break;
			
		case 3:
			c=new Customer("HP Omen Core i7 ",81990,0);
			count++;
			break;
			
		case 4:
			c=new Customer("Acer Predator Helios",109990,0);
			count++;
			break;
			
		case 5:
			c=new Customer("Microsoft Surface Laptop",76490,0);
			count++;
			break;
			
		case 6:
			c=new Customer("pple MacBook Air Core i5",114990,0);
			count++;
			break;
			
		case 7:
			Cloths.mens();
			break;
			
		case 8:
			ShoppingWebsite.home();
			break;
			
		case 9:
			ShoppingWebsite.cart();
			break;
			
		default:
			break;
		}
		
		if(count!=0){
			ShoppingWebsite.ar.add(c);
			ShoppingWebsite.quantity(c,count);
			count=0;
		}
	}
	
	public static void television() {
		System.out.print("\n\t .....................................................\r\n" + 
				"\n\tTelevision                          \n" + 
				"\t1. LG All-in-One 126cm (50 inch)                        Rate : Rs 44,999/-            \n" + 
				"\t2. iFFALCON by TCL 123.13cm (49 inch)                   Rate : Rs 23,999/-            \n" + 
				"\t3. Mi LED Smart TV 4A PRO 80 cm                         Rate : Rs 11,999/-            \n" + 
				"\t4. Samsung Series 4 80cm (32 inch)                      Rate : Rs 13,999/-            \n" + 
				"\t5. Thomson R9 60cm (24 inch)     					   Rate : Rs 7,499/-             \n" + 
				"\t6. Vu Premium Android 126cm (50 inch)          		   Rate : Rs 31,999/-            \n" + 
				"\t7. Previouspage                        \n" + 
				"\t8. Home Page                           \n" + 
				"\t9. Exit                                \n" + 
				"\n\tSelect choice : ");
		
		int mobile = ShoppingWebsite.input(9);
		switch (mobile){
		case 1:
			c=new Customer("G All-in-One 126cm (50 inch)",44999,0);
			count++;
			break;
			
		case 2:
			c=new Customer("iFFALCON by TCL 123.13cm (49 inch)",23999,0);
			count++;
			break;
			
		case 3:
			c=new Customer("Mi LED Smart TV 4A PRO 80 cm",11999,0);
			count++;
			break;
			
		case 4:
			c=new Customer("Samsung Series 4 80cm (32 inch)",13999,0);
			count++;
			break;
			
		case 5:
			c=new Customer("Thomson R9 60cm (24 inch)",7499,0);
			count++;
			break;
			
		case 6:
			c=new Customer("Vu Premium Android 126cm (50 inch)",31999,0);
			count++;
			break;
			
		case 7:
			Cloths.mens();
			break;
			
		case 8:
			ShoppingWebsite.home();
			break;
			
		case 9:
			ShoppingWebsite.cart();
			break;
			
		default:
			break;
		}
		
		if(count!=0){
			ShoppingWebsite.ar.add(c);
			ShoppingWebsite.quantity(c,count);
			count=0;
		}
	}
	
	public static void  washingMachine() {
		System.out.print("\n\t .....................................................\r\n" + 
				"\n\t Washing Machine                          \n" + 
				"\t1. Onida 6.2 kg Fully Automatic                         Rate : Rs 10,899/-            \n" + 
				"\t2. MarQ by Flipkart 6 kg                                Rate : Rs  6,499/-            \n" + 
				"\t3. IFB 6 kg 2D Wash Fully Automatic                     Rate : Rs 19,999/-            \n" + 
				"\t4. Samsung 6.2 kg                                       Rate : Rs 13,500/-            \n" + 
				"\t5. Whirlpool 7.2 kg Semi Automatic     			       Rate : Rs 9,499/-             \n" + 
				"\t6. Bosch 6.5 kg Fully Automatic          		       Rate : Rs 14,999/-            \n" + 
				"\t7. Previouspage                        \n" + 
				"\t8. Home Page                           \n" + 
				"\t9. Exit                                \n" + 
				"\n\tSelect choice : ");
		
		int m = ShoppingWebsite.input(9);
		switch (m){
		case 1:
			c=new Customer("Onida 6.2 kg Fully Automatic",10899,0);
			count++;
			break;
			
		case 2:
			c=new Customer("MarQ by Flipkart 6 kg",6499,0);
			count++;
			break;
			
		case 3:
			c=new Customer("IFB 6 kg 2D Wash Fully Automatic",19999,0);
			count++;
			break;
			
		case 4:
			c=new Customer("Samsung 6.2 kg",13500,0);
			count++;
			break;
			
		case 5:
			c=new Customer("Whirlpool 7.2 kg Semi Automatic",9499,0);
			count++;
			break;
			
		case 6:
			c=new Customer("Bosch 6.5 kg Fully Automatic",14999,0);
			count++;
			break;
			
		case 7:
			Cloths.mens();
			break;
			
		case 8:
			ShoppingWebsite.home();
			break;
			
		case 9:
			ShoppingWebsite.cart();
			break;
			
		default:
			break;
		}
		
		if(count!=0){
			ShoppingWebsite.ar.add(c);
			ShoppingWebsite.quantity(c,count);
			count=0;
		}
	}
	
	
	public static void  cameras() {
		System.out.print("\n\t .....................................................\r\n" + 
				"\n\t Camera                          \n" + 
				"\t1. Nikon D3500 DSLR                         			   Rate : Rs 28,999/-            \n" + 
				"\t2. Canon EOS 200D II DSLR                               Rate : Rs 47,999/-            \n" + 
				"\t3. Sony Alpha ILCE-6000Y/b in5                          Rate : Rs 50,999/-            \n" + 
				"\t4. Fujifilm X Series X-T100                             Rate : Rs 31,999/-            \n" + 
				"\t5. Olympus OM-D E-M1    			                       Rate : Rs 1,47,999/-             \n" + 
				"\t6. Panasonic DMC-G85HGW-K           		               Rate : Rs 70,990/-            \n" + 
				"\t7. Previouspage                        \n" + 
				"\t8. Home Page                           \n" + 
				"\t9. Exit                                \n" + 
				"\n\tSelect choice : ");
		
		int m = ShoppingWebsite.input(9);
		switch (m){
		case 1:
			c=new Customer("Nikon D3500 DSLR",28999,0);
			count++;
			break;
			
		case 2:
			c=new Customer("Canon EOS 200D II DSLR",47999,0);
			count++;
			break;
			
		case 3:
			c=new Customer("Sony Alpha ILCE-6000Y/b in5",50999,0);
			count++;
			break;
			
		case 4:
			c=new Customer("Fujifilm X Series X-T100",31999,0);
			count++;
			break;
			
		case 5:
			c=new Customer("Olympus OM-D E-M1",147999,0);
			count++;
			break;
			
		case 6:
			c=new Customer("Panasonic DMC-G85HGW-K",70999,0);
			count++;
			break;
			
		case 7:
			Cloths.mens();
			break;
			
		case 8:
			ShoppingWebsite.home();
			break;
			
		case 9:
			ShoppingWebsite.cart();
			break;
			
		default:
			break;
		}
		
		if(count!=0){
			ShoppingWebsite.ar.add(c);
			ShoppingWebsite.quantity(c,count);
			count=0;
		}
	}
	
}



class HomeApplication{
	static Customer c;
	static int count=0;
	static Scanner scan = new Scanner(System.in);
	
	public static void homeApplication() {
		System.out.println("\n\t Electronics     \n" + 
			            	"\t 1. Kitchen Storage & Containers         \n" + 
		            		"\t 2. Gardening Store      \n" + 
			            	"\t 3. Home Automation  \n" + 
			            	"\t 4. Home Furnishing        \n" + 
				            "\t 5. Previous Page    \n" + 
	             			"\t 6. Home Page        \n" + 
	             			"\t 7. Exit        \n" + 
				            "\t select choice:");
		
		int choice =ShoppingWebsite.input(7);
	
		switch (choice) {
		
			case 1:
				kitchen();
				break;
		
			case 2:
				garden();
				break;
	
			case 3:
				homeAutomation();
				break;
		
			case 4:
				homeFurnishing();
				break;
			
			case 5:
				ShoppingWebsite.home();
				break;
			
			case 6:
				ShoppingWebsite.home();
				break;
			
			case 7:
				ShoppingWebsite.bill();
				break;
				
			default:
				break;
		}
	}
	
	public static void  kitchen() {
		System.out.print("\n\t .....................................................\r\n" + 
				"\n\t Kitchen Storage & Containers                          \n" + 
				"\t1. Ebee Plastic Kitchen Trolley                         	Rate : Rs 636/-            \n" + 
				"\t2. Ketsaal Multi-purpose Vegetables                      Rate : Rs 159/-            \n" + 
				"\t3. All Time Sleek - 850 ml                               Rate : Rs 850/-            \n" + 
				"\t4. ALEXA - 200 ml                                        Rate : Rs 499/-            \n" + 
				"\t5. Flipkart SmartBuy 900ml Sharp Chopper                 Rate : Rs 429/-             \n" + 
				"\t6. MASTERCOOK 18 PC PET           		                Rate : Rs 549/-            \n" + 
				"\t7. Previouspage                        \n" + 
				"\t8. Home Page                           \n" + 
				"\t9. Exit                                \n" + 
				"\n\tSelect choice : ");
		
		int m = ShoppingWebsite.input(9);
		switch (m){
		case 1:
			c=new Customer("Ebee Plastic Kitchen Trolley",636,0);
			count++;
			break;
			
		case 2:
			c=new Customer("Ketsaal Multi-purpose Vegetables",159,0);
			count++;
			break;
			
		case 3:
			c=new Customer("All Time Sleek - 850 ml",850,0);
			count++;
			break;
			
		case 4:
			c=new Customer("ALEXA - 200 ml",499,0);
			count++;
			break;
			
		case 5:
			c=new Customer("Flipkart SmartBuy 900ml Sharp Chopper",429,0);
			count++;
			break;
			
		case 6:
			c=new Customer("MASTERCOOK 18 PC PET",549,0);
			count++;
			break;
			
		case 7:
			homeApplication();
			break;
			
		case 8:
			ShoppingWebsite.home();
			break;
			
		case 9:
			ShoppingWebsite.bill();
			break;
			
		default:
			break;
		}
		
		if(count!=0){
			ShoppingWebsite.ar.add(c);
			ShoppingWebsite.quantity(c,count);
			count=0;
		}
	}
	
	public static void  homeFurnishing() {
		System.out.print("\n\t .....................................................\r\n" + 
				"\n\t Living Room Furniture                          \n" + 
				"\t1. Fabric Office Arm Chair                         	Rate : Rs 3397/-            \n" + 
				"\t2. Wood Coffee Table                                 Rate : Rs 3490/-            \n" + 
				"\t3. Wood Shoe Rack                                    Rate : Rs 4090/-            \n" + 
				"\t4. Semi-Open Book Shelf                              Rate : Rs 6290/-            \n" + 
				"\t5. Wood, Metal Sofa Bed                              Rate : Rs 17390/-             \n" + 
				"\t6. Flipkart Perfect Homes Webster                    Rate : Rs 12990/-            \n" + 
				"\t7. Previouspage                        \n" + 
				"\t8. Home Page                           \n" + 
				"\t9. Exit                                \n" + 
				"\n\tSelect choice : ");
		
		int m = ShoppingWebsite.input(9);
		switch (m){
		case 1:
			c=new Customer("Fabric Office Arm Chair",3397,0);
			count++;
			break;
			
		case 2:
			c=new Customer("Wood Coffee Table",3490,0);
			count++;
			break;
			
		case 3:
			c=new Customer("Wood Shoe Rack",4090,0);
			count++;
			break;
			
		case 4:
			c=new Customer("Semi-Open Book Shelf",6290,0);
			count++;
			break;
			
		case 5:
			c=new Customer("Wood, Metal Sofa Bed ",17390,0);
			count++;
			break;
			
		case 6:
			c=new Customer("Flipkart Perfect Homes Webster",12990,0);
			count++;
			break;
			
		case 7:
			homeApplication();
			break;
			
		case 8:
			ShoppingWebsite.home();
			break;
			
		case 9:
			ShoppingWebsite.bill();
			break;
			
		default:
			break;
		}
		
		if(count!=0){
			ShoppingWebsite.ar.add(c);
			ShoppingWebsite.quantity(c,count);
			count=0;
		}
	}
	
	public static void  homeAutomation() {
		System.out.print("\n\t .....................................................\r\n" + 
				"\n\t Home Automation                          \n" + 
				"\t1. Video Door Phone                           	Rate : Rs 6989/-            \n" + 
				"\t2. Smart wifi Lighting                           Rate : Rs 699/-            \n" + 
				"\t3. Smart Switch                                 Rate : Rs 1490/-            \n" + 
				"\t4. Google Home Mini                              Rate : Rs 3999/-            \n" + 
				"\t5. MI Smart Security Camera                      Rate : Rs 2,699/-             \n" + 
				"\t6. Syska MWP-002 Smart Plug                      Rate : Rs 1099/-            \n" + 
				"\t7. Previouspage                        \n" + 
				"\t8. Home Page                           \n" + 
				"\t9. Exit                                \n" + 
				"\n\tSelect choice : ");
		
		int m = ShoppingWebsite.input(9);
		switch (m){
		case 1:
			c=new Customer("Video Door Phone",6989,0);
			count++;
			break;
			
		case 2:
			c=new Customer("Smart wifi Lighting",699,0);
			count++;
			break;
			
		case 3:
			c=new Customer("Smart Switch",1490,0);
			count++;
			break;
			
		case 4:
			c=new Customer("Google Home Mini",3999,0);
			count++;
			break;
			
		case 5:
			c=new Customer("MI Smart Security Camera",2699,0);
			count++;
			break;
			
		case 6:
			c=new Customer("Syska MWP-002 Smart Plug",1099,0);
			count++;
			break;
			
		case 7:
			homeApplication();
			break;
			
		case 8:
			ShoppingWebsite.home();
			break;
			
		case 9:
			ShoppingWebsite.bill();
			break;
			
		default:
			break;
		}
		
		if(count!=0){
			ShoppingWebsite.ar.add(c);
			ShoppingWebsite.quantity(c,count);
			count=0;
		}
	}
	public static void  garden() {
		System.out.print("\n\t .....................................................\r\n" + 
				"\n\t Gardening Store                           \n" + 
				"\t1. AGAMI Green 2 Layer                         	             Rate : Rs 299/-            \n" + 
				"\t2. Ferns n Petals Bonsai Ficus                                Rate : Rs 899/-            \n" + 
				"\t3. Rare Champagne Palm                                        Rate : Rs 339/-            \n" + 
				"\t4. VS GLOBAL IMPORTED ROSE 9 DIFFERENT COLOURS (90 Seeds)     Rate : Rs 99/-            \n" + 
				"\t5. ROSEMERC Japanese Sakura Bonsai Plant Seeds                Rate : Rs 99/-             \n" + 
				"\t6. VS GLOBAL beautifull blUe lotus seeds                      Rate : Rs 105/-            \n" + 
				"\t7. Previouspage                        \n" + 
				"\t8. Home Page                           \n" + 
				"\t9. Exit                                \n" + 
				"\n\tSelect choice : ");
		
		int m = ShoppingWebsite.input(9);
		switch (m){
		case 1:
			c=new Customer("AGAMI Green 2 Layer",299,0);
			count++;
			break;
			
		case 2:
			c=new Customer("Ferns n Petals Bonsai Ficus",899,0);
			count++;
			break;
			
		case 3:
			c=new Customer("Rare Champagne Palm",339,0);
			count++;
			break;
			
		case 4:
			c=new Customer("VS GLOBAL IMPORTED ROSE",99,0);
			count++;
			break;
			
		case 5:
			c=new Customer("ROSEMERC Japanese Sakura ",99,0);
			count++;
			break;
			
		case 6:
			c=new Customer("VS GLOBAL beautifull blUe lotus",105,0);
			count++;
			break;
			
		case 7:
			homeApplication();
			break;
			
		case 8:
			ShoppingWebsite.home();
			break;
			
		case 9:
			ShoppingWebsite.bill();
			break;
			
		default:
			break;
		}
		
		if(count!=0){
			ShoppingWebsite.ar.add(c);
			ShoppingWebsite.quantity(c,count);
			count=0;
		}
	}
}

class Books{
	static Customer c;
	static int count=0;
	static Scanner scan = new Scanner(System.in);
	
	public static void books() {
		System.out.println("\n\t Books     \n" + 
				"\t 1. Higher Education And Professional Books         \n" + 
				"\t 2. History And Archaeology Books      \n" + 
				"\t 3. Lifestyle, Hobby And Sport Books  \n" + 
				"\t 4. Biographies, Memoirs And General Non Ficton Books       \n" + 
				"\t 5. Previous Page    \n" + 
				"\t 6. Home Page        \n" + 
				"\t 7. Exit        \n" + 
				"\t select choice:");
		
		int choice =ShoppingWebsite.input(7);
		
		switch (choice) {
		
		case 1:
			education();
			break;
			
		case 2:
			history();
			break;
			
		case 3:
			lifestyle();
			break;
			
		case 4:
			garden();
			break;
			
		case 5:
			ShoppingWebsite.home();
			break;
			
		case 6:
			ShoppingWebsite.home();
			break;
			
		case 7:
			ShoppingWebsite.bill();
			break;
			
		default:
			break;
		}
	}
	
	public static void  education() {
		System.out.print("\n\t .....................................................\r\n" + 
				"\n\t Higher Education And Professional Books                          \n" + 
				"\t1. Aradhya's Object Oriented Programming with C++              	             Rate : Rs 425/-            \n" + 
				"\t2. A Brief History Of Time    (English, Paperback, Hawking Stephen)           Rate : Rs 240/-            \n" + 
				"\t3. PREVENTION of Cyber Crimes (ENGLISH, Paperback, IIBF)                      Rate : Rs 208/-            \n" + 
				"\t4. The Rebel                  (English, Paperback, ADELMAN SUSAN)             Rate : Rs 373/-            \n" + 
				"\t5. Target 3 Billion           (English, Paperback, Abdul Kalam A. P. J.)      Rate : Rs 214/-             \n" + 
				"\t6. Relativity                 (English, Paperback,Albert Einstein)            Rate : Rs 199/-            \n" + 
				"\t7. Previouspage                        \n" + 
				"\t8. Home Page                           \n" + 
				"\t9. Exit                                \n" + 
				"\n\tSelect choice : ");
		
		int m = ShoppingWebsite.input(9);
		switch (m){
		case 1:
			c=new Customer("Aradhya's Oops with c++",425,0);
			count++;
			break;
			
		case 2:
			c=new Customer("A Brief History Of Time",240,0);
			count++;
			break;
			
		case 3:
			c=new Customer("PREVENTION of Cyber Crimes",208,0);
			count++;
			break;
			
		case 4:
			c=new Customer("The Rebel",373,0);
			count++;
			break;
			
		case 5:
			c=new Customer("Target 3 Billion",214,0);
			count++;
			break;
			
		case 6:
			c=new Customer("Relativity",199,0);
			count++;
			break;
			
		case 7:
			books();
			break;
			
		case 8:
			ShoppingWebsite.home();
			break;
			
		case 9:
			ShoppingWebsite.bill();
			break;
			
		default:
			break;
		}
		
		if(count!=0){
			ShoppingWebsite.ar.add(c);
			ShoppingWebsite.quantity(c,count);
			count=0;
		}
	}
	
	public static void  history() {
		System.out.print("\n\t .....................................................\r\n" + 
				"\n\t History And Archaeology Books                          \n" + 
				"\t1. The Bhagavad Gita - Symphony of the Spirit       	Rate : Rs 295/-            \n" + 
				"\t2. The Republic                                      Rate : Rs 199/-            \n" + 
				"\t3. A New Look at Modern Indian History               Rate : Rs 399/-            \n" + 
				"\t4. 112 Meditations for Self Realization              Rate : Rs 295/-            \n" + 
				"\t5. India Wins Freedom                                Rate : Rs 328/-             \n" + 
				"\t6. Mein Kampf                                        Rate : Rs 250/-            \n" + 
				"\t7. Previouspage                        \n" + 
				"\t8. Home Page                           \n" + 
				"\t9. Exit                                \n" + 
				"\n\tSelect choice : ");
		
		int m = ShoppingWebsite.input(9);
		switch (m){
		case 1:
			c=new Customer("The Bhagavad Gita",295,0);
			count++;
			break;
			
		case 2:
			c=new Customer("The Republic",199,0);
			count++;
			break;
			
		case 3:
			c=new Customer("A New Look at Modern Indian History",399,0);
			count++;
			break;
			
		case 4:
			c=new Customer("112 Meditations for Self Realization",295,0);
			count++;
			break;
			
		case 5:
			c=new Customer("India Wins Freedom ",328,0);
			count++;
			break;
			
		case 6:
			c=new Customer("Mein Kampf",250,0);
			count++;
			break;
			
		case 7:
			books();
			break;
			
		case 8:
			ShoppingWebsite.home();
			break;
			
		case 9:
			ShoppingWebsite.bill();
			break;
			
		default:
			break;
		}
		
		if(count!=0){
			ShoppingWebsite.ar.add(c);
			ShoppingWebsite.quantity(c,count);
			count=0;
		}
	}
	
	public static void  lifestyle() {
		System.out.print("\n\t .....................................................\r\n" + 
				"\n\t Lifestyle, Hobby And Sport Books                          \n" + 
				"\t1. My Journey with Vadapav                      	Rate : Rs 204/-            \n" + 
				"\t2. Mrs Funnybones                                Rate : Rs 188/-            \n" + 
				"\t3. A Man Called Ove                              Rate : Rs 245/-            \n" + 
				"\t4. A Taste of Well-Being                         Rate : Rs 187/-            \n" + 
				"\t5. Yoga for Everyone                             Rate : Rs 362/-             \n" + 
				"\t6. Puzzles to Puzzle You                         Rate : Rs 125/-            \n" + 
				"\t7. Previouspage                        \n" + 
				"\t8. Home Page                           \n" + 
				"\t9. Exit                                \n" + 
				"\n\tSelect choice : ");
		
		int m =ShoppingWebsite.input(9);
		switch (m){
		case 1:
			c=new Customer("My Journey with Vadapav",204,0);
			count++;
			break;
			
		case 2:
			c=new Customer("Mrs Funnybones",188,0);
			count++;
			break;
			
		case 3:
			c=new Customer("A Man Called Ove",245,0);
			count++;
			break;
			
		case 4:
			c=new Customer("A Taste of Well-Being",187,0);
			count++;
			break;
			
		case 5:
			c=new Customer("Yoga for Everyone",362,0);
			count++;
			break;
			
		case 6:
			c=new Customer("Puzzles to Puzzle You",125,0);
			count++;
			break;
			
		case 7:
			books();
			break;
			
		case 8:
			ShoppingWebsite.home();
			break;
			
		case 9:
			ShoppingWebsite.bill();
			break;
			
		default:
			break;
		}
		
		if(count!=0){
			ShoppingWebsite.ar.add(c);
			ShoppingWebsite.quantity(c,count);
			count=0;
		}
	}
	
	public static void  garden() {
		System.out.print("\n\t .....................................................\r\n" + 
				"\n\t Biographies, Memoirs And General Non Ficton Books                           \n" + 
				"\t1. 12 years a slave : - A True Story                          Rate : Rs 150/-            \n" + 
				"\t2. Wings of Fire                                              Rate : Rs 230/-            \n" + 
				"\t3. Why I am an Atheist and Other Works                        Rate : Rs 114/-            \n" + 
				"\t4. You are the Best Wife                                      Rate : Rs 105/-            \n" + 
				"\t5. The Story of My Life                                       Rate : Rs 195/-             \n" + 
				"\t6. Don't Lose Your Mind, Lose Your Weight                     Rate : Rs 156/-            \n" + 
				"\t7. Previouspage                        \n" + 
				"\t8. Home Page                           \n" + 
				"\t9. Exit                                \n" + 
				"\n\tSelect choice : ");
		
		int m = ShoppingWebsite.input(9);
		switch (m){
		case 1:
			c=new Customer("12 years a slave : - A True Story",150,0);
			count++;
			break;
			
		case 2:
			c=new Customer("Wings of Fire  ",230,0);
			count++;
			break;
			
		case 3:
			c=new Customer("Why I am an Atheist and Other Works",114,0);
			count++;
			break;
			
		case 4:
			c=new Customer("You are the Best Wife",105,0);
			count++;
			break;
			
		case 5:
			c=new Customer("The Story of My Life ",195,0);
			count++;
			break;
			
		case 6:
			c=new Customer("Don't Lose Your Mind, Lose Your Weight",156,0);
			count++;
			break;
			
		case 7:
			books();
			break;
			
		case 8:
			ShoppingWebsite.home();
			break;
			
		case 9:
			ShoppingWebsite.bill();
			break;
			
		default:
			break;
		}
		
		if(count!=0){
			ShoppingWebsite.ar.add(c);
			ShoppingWebsite.quantity(c,count);
			count=0;
		}
	}
}


class Health{
	static Customer c;
	static int count=0;
	static Scanner scan = new Scanner(System.in);
	
	public static void health() {
		System.out.println("\n\t Books     \n" + 
				"\t 1. Vitamin & Supplements         \n" + 
				"\t 2. Protein Supplements      \n" + 
				"\t 3. Chyawanprash  \n" + 
				"\t 4. Health And Energy Drinks       \n" + 
				"\t 5. Previous Page    \n" + 
				"\t 6. Home Page        \n" + 
				"\t 7. Exit        \n" + 
				"\t select choice:");
		
		int choice = ShoppingWebsite.input(7);
		
		switch (choice) {
		
		case 1:
			vitamin();
			break;
			
		case 2:
			protein();
			break;
			
		case 3:
			chyawanprash();
			break;
			
		case 4:
			energyDrinks();
			break;
			
		case 5:
			ShoppingWebsite.home();
			break;
			
		case 6:
			ShoppingWebsite.home();
			break;
			
		case 7:
			ShoppingWebsite.bill();
			break;
			
		default:
			break;
		}
	}
	
	public static void  vitamin() {
		System.out.print("\n\t .....................................................\r\n" + 
				"\n\t Vitamin & Supplements                        \n" + 
				"\t1. Himalaya Gokshura  (60 No)          Rate : Rs 116/-            \n" + 
				"\t2. WOW Life Science Omega-3            Rate : Rs 764/-            \n" + 
				"\t3. Dabur Shilajit Gold  (10 No)        Rate : Rs 215/-            \n" + 
				"\t4. NATURYZ Fish Oil 1400Mg             Rate : Rs 589/-            \n" + 
				"\t5. The Body Avenue L Glutathione       Rate : Rs 719/-             \n" + 
				"\t6. Himalaya Ashvagandha  (60 No)       Rate : Rs 118/-            \n" + 
				"\t7. Previouspage                        \n" + 
				"\t8. Home Page                           \n" + 
				"\t9. Exit                                \n" + 
				"\n\tSelect choice : ");
		
		int m = ShoppingWebsite.input(9);
		switch (m){
		case 1:
			c=new Customer("Himalaya Gokshura  (60 No)",116,0);
			count++;
			break;
			
		case 2:
			c=new Customer("WOW Life Science Omega-3",764,0);
			count++;
			break;
			
		case 3:
			c=new Customer("Dabur Shilajit Gold  (10 No)",215,0);
			count++;
			break;
			
		case 4:
			c=new Customer("NATURYZ Fish Oil 1400Mg",589,0);
			count++;
			break;
			
		case 5:
			c=new Customer("The Body Avenue L Glutathione",719,0);
			count++;
			break;
			
		case 6:
			c=new Customer("Himalaya Ashvagandha  (60 No)",118,0);
			count++;
			break;
			
		case 7:
			health();
			break;
			
		case 8:
			ShoppingWebsite.home();
			break;
			
		case 9:
			ShoppingWebsite.bill();
			break;
			
		default:
			break;
		}
		
		if(count!=0){
			ShoppingWebsite.ar.add(c);
			ShoppingWebsite.quantity(c,count);
			count=0;
		}
	}
	
	public static void  protein() {
		System.out.print("\n\t .....................................................\r\n" + 
				"\n\t Protein Supplements                          \n" + 
				"\t1. Advance MuscleMass Mass gainer       	      Rate : Rs 899/-            \n" + 
				"\t2. MuscleBlaze Super Gaine                     Rate : Rs 779/-            \n" + 
				"\t3. Endura Mass Weight Gainers                  Rate : Rs 464/-            \n" + 
				"\t4. Maxgars Whey Protein                        Rate : Rs 3490/-            \n" + 
				"\t5. Muscletech Performance Series               Rate : Rs 2035/-             \n" + 
				"\t6. BSN Syntha - 6 Protein Blends               Rate : Rs 3662/-            \n" + 
				"\t7. Previouspage                        \n" + 
				"\t8. Home Page                           \n" + 
				"\t9. Exit                                \n" + 
				"\n\tSelect choice : ");
		
		int m = ShoppingWebsite.input(9);
		switch (m){
		case 1:
			c=new Customer("Advance MuscleMass Mass gainer",899,0);
			count++;
			break;
			
		case 2:
			c=new Customer("MuscleBlaze Super Gaine",779,0);
			count++;
			break;
			
		case 3:
			c=new Customer("Endura Mass Weight Gainers",464,0);
			count++;
			break;
			
		case 4:
			c=new Customer("Maxgars Whey Protein",3490,0);
			count++;
			break;
			
		case 5:
			c=new Customer("Muscletech Performance Series",2035,0);
			count++;
			break;
			
		case 6:
			c=new Customer("BSN Syntha - 6 Protein Blends",3662,0);
			count++;
			break;
			
		case 7:
			health();
			break;
			
		case 8:
			ShoppingWebsite.home();
			break;
			
		case 9:
			ShoppingWebsite.bill();
			break;
			
		default:
			break;
		}
		
		if(count!=0){
			ShoppingWebsite.ar.add(c);
			ShoppingWebsite.quantity(c,count);
			count=0;
		}
	}
	
	public static void  chyawanprash() {
		System.out.print("\n\t .....................................................\r\n" + 
				"\n\t Chyawanprash                          \n" + 
				"\t1. Dabur Chyawanprash  (250 g)                  	Rate : Rs  95/-            \n" + 
				"\t2. Patanjali Chyawanprash  (1 kg)                Rate : Rs 190/-            \n" + 
				"\t3. Organic India Chyawanprash  (500 g)           Rate : Rs 297/-            \n" + 
				"\t4. Zandu Kesari Jivan  (450 g)                   Rate : Rs 387/-            \n" + 
				"\t5. Zandu (Sugar Free) Chyavanprashad             Rate : Rs 370/-             \n" + 
				"\t6. Goldprash Chyawanprash  (1 kg)                Rate : Rs 600/-            \n" + 
				"\t7. Previouspage                        \n" + 
				"\t8. Home Page                           \n" + 
				"\t9. Exit                                \n" + 
				"\n\tSelect choice : ");
		
		int m = ShoppingWebsite.input(9);
		switch (m){
		case 1:
			c=new Customer("Dabur Chyawanprash  (250 g)",95,0);
			count++;
			break;
			
		case 2:
			c=new Customer("Patanjali Chyawanprash  (1 kg)",190,0);
			count++;
			break;
			
		case 3:
			c=new Customer("Organic India Chyawanprash  (500 g)",297,0);
			count++;
			break;
			
		case 4:
			c=new Customer("Zandu Kesari Jivan  (450 g)",387,0);
			count++;
			break;
			
		case 5:
			c=new Customer("Zandu (Sugar Free) Chyavanprashad",370,0);
			count++;
			break;
			
		case 6:
			c=new Customer("Goldprash Chyawanprash  (1 kg)",600,0);
			count++;
			break;
			
		case 7:
			health();
			break;
			
		case 8:
			ShoppingWebsite.home();
			break;
			
		case 9:
			ShoppingWebsite.bill();
			break;
			
		default:
			break;
		}
		
		if(count!=0){
			ShoppingWebsite.ar.add(c);
			ShoppingWebsite.quantity(c,count);
			count=0;
		}
	}
	
	
	public static void  energyDrinks() {
		System.out.print("\n\t .....................................................\r\n" + 
				"\n\t Health And Energy Drinks                           \n" + 
				"\t1. Cadbury Bournvita Health Nutrition Drink                   Rate : Rs 193/-            \n" + 
				"\t2. Cadbury Bournvita Inner Strength Nutrition Drink           Rate : Rs 579/-            \n" + 
				"\t3. Protinex Nutrition Drink                                   Rate : Rs 532/-            \n" + 
				"\t4. PediaSure Vanilla Delight Refill Pack Nutrition Drink      Rate : Rs 469/-            \n" + 
				"\t5. Healthkart Natural Drink Apple Cider Vinegar               Rate : Rs 149/-             \n" + 
				"\t6. Enfagrow A Plus Nutrition Drink                            Rate : Rs 562/-            \n" + 
				"\t7. Previouspage                        \n" + 
				"\t8. Home Page                           \n" + 
				"\t9. Exit                                \n" + 
				"\n\tSelect choice : ");
		
		int m = ShoppingWebsite.input(9);
		switch (m){
		case 1:
			c=new Customer("Cadbury Bournvita Health Nutrition Drink",193,0);
			count++;
			break;
			
		case 2:
			c=new Customer("Cadbury Bournvita Inner Strength Nutrition Drink",579,0);
			count++;
			break;
			
		case 3:
			c=new Customer("Protinex Nutrition Drink",532,0);
			count++;
			break;
			
		case 4:
			c=new Customer("PediaSure Vanilla Delight Refill Pack Nutrition Drink",469,0);
			count++;
			break;
			
		case 5:
			c=new Customer("Healthkart Natural Drink Apple Cider Vinegar",149,0);
			count++;
			break;
			
		case 6:
			c=new Customer("Enfagrow A Plus Nutrition Drink",562,0);
			count++;
			break;
			
		case 7:
			health();
			break;
			
		case 8:
			ShoppingWebsite.home();
			break;
			
		case 9:
			ShoppingWebsite.bill();
			break;
			
		default:
			break;
		}
		
		if(count!=0){
			ShoppingWebsite.ar.add(c);
			ShoppingWebsite.quantity(c,count);
			count=0;
		}
	}
}


class Footwears{
	static Customer c;
	static int count=0;
	static Scanner scan = new Scanner(System.in);
	
	public static void footwears() {
		System.out.println( 
				"\t 1. Casual Shoes        \n" + 
				"\t 2. Sports Shoes      \n" + 
				"\t 3. Formal Shoes  \n" + 
				"\t 4. Sandals and Slippers       \n" + 
				"\t 5. Previous Page    \n" + 
				"\t 6. Home Page        \n" + 
				"\t 7. Exit        \n" + 
				"\t select choice:");
		
		int choice = ShoppingWebsite.input(7);
		
		switch (choice) {
		
		case 1:
			casualShoes();
			break;
			
		case 2:
			SportsShoes();
			break;
			
		case 3:
			formalShoes();
			break;
			
		case 4:
			sandelsAndSlippers();
			break;
			
		case 5:
			ShoppingWebsite.home();
			break;
			
		case 6:
			ShoppingWebsite.home();
			break;
			
		case 7:
			ShoppingWebsite.bill();
			break;
			
		default:
			break;
		}
	}
	
	public static void  casualShoes() {
		System.out.print("\n\t .....................................................\r\n" + 
				"\n\t Casual Shoes                          \n" + 
				"\t1. Partywear Sneakers Shoes             	             Rate : Rs 395/-            \n" + 
				"\t2. Young I Casuals, Canvas, Partywear Sneakers        Rate : Rs 473/-            \n" + 
				"\t3. Sports,Running,Walking Running Shoe                Rate : Rs 474/-            \n" + 
				"\t4. Synthetic Leather Casual  Wedding Sneakers         Rate : Rs 449/-            \n" + 
				"\t5. SOCKS Casuals                                      Rate : Rs 499/-             \n" + 
				"\t6. Redox Casuals (Green)                              Rate : Rs 499/-            \n" + 
				"\t7. Previouspage                        \n" + 
				"\t8. Home Page                           \n" + 
				"\t9. Exit                                \n" + 
				"\n\tSelect choice : ");
		
		int m = ShoppingWebsite.input(9);
		switch (m){
		case 1:
			c=new Customer("Partywear Sneakers Shoes",395,0);
			count++;
			break;
			
		case 2:
			c=new Customer("Young I Casuals, Canvas, Partywear Sneakers",473,0);
			count++;
			break;
			
		case 3:
			c=new Customer("Sports,Running,Walking Running Shoe",474,0);
			count++;
			break;
			
		case 4:
			c=new Customer("Synthetic Leather Casual  Wedding Sneakers",449,0);
			count++;
			break;
			
		case 5:
			c=new Customer("SOCKS Casuals ",499,0);
			count++;
			break;
			
		case 6:
			c=new Customer("Redox Casuals (Green)",199,0);
			count++;
			break;
			
		case 7:
			footwears();
			break;
			
		case 8:
			ShoppingWebsite.home();
			break;
			
		case 9:
			ShoppingWebsite.bill();
			break;
			
		default:
			break;
		}
		
		if(count!=0){
			ShoppingWebsite.ar.add(c);
			ShoppingWebsite.quantity(c,count);
			count=0;
		}
	}
	
	public static void  SportsShoes() {
		System.out.print("\n\t .....................................................\r\n" + 
				"\n\t Sports Shoes                          \n" + 
				"\t1. Sender                            	Rate : Rs 440/-            \n" + 
				"\t2. MILESWALKER                           Rate : Rs 399/-            \n" + 
				"\t3. Asian                                 Rate : Rs 399/-            \n" + 
				"\t4. HARMEET                               Rate : Rs 473/-            \n" + 
				"\t5. Beerock                               Rate : Rs 459/-             \n" + 
				"\t6. Layasa                                Rate : Rs 399/-            \n" + 
				"\t7. Previouspage                        \n" + 
				"\t8. Home Page                           \n" + 
				"\t9. Exit                                \n" + 
				"\n\tSelect choice : ");
		
		int m = ShoppingWebsite.input(9);
		switch (m){
		case 1:
			c=new Customer("Layasa",440,0);
			count++;
			break;
			
		case 2:
			c=new Customer("MILESWALKER",399,0);
			count++;
			break;
			
		case 3:
			c=new Customer("Asian",399,0);
			count++;
			break;
			
		case 4:
			c=new Customer("HARMEET",473,0);
			count++;
			break;
			
		case 5:
			c=new Customer("Beerock",459,0);
			count++;
			break;
			
		case 6:
			c=new Customer("Layasa",399,0);
			count++;
			break;
			
		case 7:
			footwears();
			break;
			
		case 8:
			ShoppingWebsite.home();
			break;
			
		case 9:
			ShoppingWebsite.bill();
			break;
			
		default:
			break;
		}
		
		if(count!=0){
			ShoppingWebsite.ar.add(c);
			ShoppingWebsite.quantity(c,count);
			count=0;
		}
	}
	
	public static void  formalShoes() {
		System.out.print("\n\t .....................................................\r\n" + 
				"\n\t Formal Shoes                          \n" + 
				"\t1. RED LIONS  Party Wear                      	   Rate : Rs 399/-            \n" + 
				"\t2. Aadi Lace Up                                     Rate : Rs 474/-            \n" + 
				"\t3. Synthetic Leather Office Black Formal Shoes      Rate : Rs 398/-            \n" + 
				"\t4. Zixer Formal Slip                                Rate : Rs 399/-            \n" + 
				"\t5. Kimochi Officewar                                Rate : Rs 499/-             \n" + 
				"\t6. Shoe Rock Vision (SRV)                           Rate : Rs 379/-            \n" + 
				"\t7. Previouspage                        \n" + 
				"\t8. Home Page                           \n" + 
				"\t9. Exit                                \n" + 
				"\n\tSelect choice : ");
		
		int m = ShoppingWebsite.input(9);
		switch (m){
		case 1:
			c=new Customer("My Journey with Vadapav",204,0);
			count++;
			break;
			
		case 2:
			c=new Customer("Mrs Funnybones",188,0);
			count++;
			break;
			
		case 3:
			c=new Customer("A Man Called Ove",245,0);
			count++;
			break;
			
		case 4:
			c=new Customer("A Taste of Well-Being",187,0);
			count++;
			break;
			
		case 5:
			c=new Customer("Yoga for Everyone",362,0);
			count++;
			break;
			
		case 6:
			c=new Customer("Puzzles to Puzzle You",125,0);
			count++;
			break;
			
		case 7:
			footwears();
			break;
			
		case 8:
			ShoppingWebsite.home();
			break;
			
		case 9:
			ShoppingWebsite.bill();
			break;
			
		default:
			break;
		}
		
		if(count!=0){
			ShoppingWebsite.ar.add(c);
			ShoppingWebsite.quantity(c,count);
			count=0;
		}
	}
	
	public static void  sandelsAndSlippers() {
		System.out.print("\n\t .....................................................\r\n" + 
				"\n\t Sandals & Slippers                           \n" + 
				"\t1. Brown Casual Sandal                                        Rate : Rs 426/-            \n" + 
				"\t2. Sparx Blue Sports Sandal                                   Rate : Rs 588/-            \n" + 
				"\t3. Combo Pack Of 2 Pairs Of Slides Flip Flops Slippers        Rate : Rs 349/-            \n" + 
				"\t4. Double Soft Grass Rubber Healthy Slippers                  Rate : Rs 155/-            \n" + 
				"\t5. Tryfeet  Flip Flops                                        Rate : Rs 299/-             \n" + 
				"\t6. Extra Soft Slippers                                        Rate : Rs 299/-            \n" + 
				"\t7. Previouspage                        \n" + 
				"\t8. Home Page                           \n" + 
				"\t9. Exit                                \n" + 
				"\n\tSelect choice : ");
		
		int m =ShoppingWebsite.input(9);
		switch (m){
		case 1:
			c=new Customer("12 years a slave : - A True Story",150,0);
			count++;
			break;
			
		case 2:
			c=new Customer("Wings of Fire  ",230,0);
			count++;
			break;
			
		case 3:
			c=new Customer("Why I am an Atheist and Other Works",114,0);
			count++;
			break;
			
		case 4:
			c=new Customer("You are the Best Wife",105,0);
			count++;
			break;
			
		case 5:
			c=new Customer("The Story of My Life ",195,0);
			count++;
			break;
			
		case 6:
			c=new Customer("Don't Lose Your Mind, Lose Your Weight",156,0);
			count++;
			break;
			
		case 7:
			footwears();
			break;
			
		case 8:
			ShoppingWebsite.home();
			break;
			
		case 9:
			ShoppingWebsite.bill();
			break;
			
		default:
			break;
		}
		
		if(count!=0){
			ShoppingWebsite.ar.add(c);
			ShoppingWebsite.quantity(c,count);
			count=0;
		}
	}
}
