import java.util.Scanner;
import java.lang.Exception;
import java.io.*;
import java.io.Serializable;
 class Account implements Serializable{
  	String name = new String(" ");
	int accno;
	long balance;
		Scanner s = new Scanner(System.in);
	public void create(){
		System.out.print("\t \t Enter User name :");
		 name = s.next();
		System.out.print("\t \t Enter Account Number :");
		accno = s.nextInt();
		System.out.print("\t \t Enter Balance :");
		balance= s.nextLong();
		try{
	FileWriter  fout = new FileWriter("BankData",true);
	BufferedWriter ob = new BufferedWriter(fout);
	ob.write(String.valueOf(accno));
	ob.newLine();
	ob.write(name);
	ob.newLine();
	String b =String.valueOf(balance);
	ob.write(b);
	ob.newLine();
	pressAnyKeyToContinue();
	ob.close();
	}
	catch(IOException ex){
			System.out.println("Error writing to file ");
		}
			
			}
	private void pressAnyKeyToContinue(){
		System.out.println("Press Enter key to continue...");
		try{
			System.in.read();
		}
 		catch(Exception e){
			System.out.println("Press 'Enter' key to continue!");
		}
	}
	void deposite()
	{
		int bal=0;
		String tacc = new String("");
		String tname = new String("");
		System.out.print("\t \t Enter Account no. :");
		accno = s.nextInt();
		System.out.print("\t \t Enter amount to deposite :");
		balance= s.nextLong();
		String line = null;
		String acc=String.valueOf(accno);
		try{
		FileReader  fin = new FileReader("BankData");
		BufferedReader ob = new BufferedReader(fin);
		FileWriter  fout = new FileWriter("temp");
	    BufferedWriter ob1 = new BufferedWriter(fout);
		String b =String.valueOf(balance);
		while((line = ob.readLine())!=null)
		{
		if(line.equals(acc)){
		tacc=line;
		line = ob.readLine();
		tname=line;
		line = ob.readLine();
		bal=Integer.parseInt(line);
		bal+=balance;
	    }
		else
		{
			ob1.write(line);
			ob1.newLine();
		}
	}      ob1.write(tacc);
			ob1.newLine();
			ob1.write(tname);
			ob1.newLine();
			ob1.write(String.valueOf(bal));
			ob1.newLine();
	
		ob.close();
		fin.close();
		ob1.close();
		fout.close();
		}
		catch(FileNotFoundException ex){
				System.out.println("\t Unable to open file '" );
			}
			catch(IOException ex){
				System.out.println("\t Error reading file '" );
			}
			try{
		FileReader  fin = new FileReader("temp");
		BufferedReader ob = new BufferedReader(fin);
		FileWriter  fout = new FileWriter("BankData");
	    BufferedWriter ob1 = new BufferedWriter(fout);
		String b =String.valueOf(balance);
		while((line = ob.readLine())!=null)
		{
		ob1.write(line);
		ob1.newLine();
	}  	
		ob.close();
		fin.close();
		ob1.close();
		fout.close();
		}
		catch(FileNotFoundException ex){
				System.out.print("Unable to open file '" );
			}
			catch(IOException ex){
				System.out.print("Error reading file '" );
			}
		
		}
		
	void show(){	
	String line = null;
	try{
	FileReader  fin = new FileReader("BankData");
	BufferedReader ob = new BufferedReader(fin);
	Object temp;
	while((line = ob.readLine())!=null)
	{
	System.out.print("\t \t Account no. :");
	System.out.println(line);
	line = ob.readLine();
	System.out.print("\t \t Name.       :");	
	System.out.println(line);
	line = ob.readLine();
	System.out.print("\t \t Balance     :");	
	System.out.println(line);
	System.out.println("\t \t -------------------");
	}
	ob.close();
		fin.close();}
	catch(FileNotFoundException ex){
			System.out.println("Unable to open file '" );
		}
		catch(IOException ex){
			System.out.println("Error reading file '" );
		}
		pressAnyKeyToContinue();
	}	
	void search()
	{System.out.print("\t \t Enter Account no. :");
	accno = s.nextInt();
	String line = null;
	String acc=String.valueOf(accno);
	try{
	FileReader  fin = new FileReader("BankData");
	BufferedReader ob = new BufferedReader(fin);
	Object temp;
	while((line = ob.readLine())!=null)
	{if(line.equals(acc)){
		System.out.print("\t \t Account no. :");
		System.out.println(line);
		line = ob.readLine();
		System.out.print("\t \t Name.       :");	
		System.out.println(line);
		line = ob.readLine();
		System.out.print("\t \t Balance     :");	
		System.out.println(line);
		}
	
	
	}
	
	ob.close();
		fin.close();}
	catch(FileNotFoundException ex){
			System.out.println("Unable to open file '" );
		}
		catch(IOException ex){
			System.out.println("Error reading file '" );
		}
                    
	}		
	
	void withdraw()
	{
		int bal=0;
		String tacc = new String("");
		String tname = new String("");
		System.out.print("\t \t Enter Account no. :");
		accno = s.nextInt();
		System.out.print("\t \t Enter amount to withdraw :");
		balance= s.nextLong();
		String line = null;
		String acc=String.valueOf(accno);
		try{
		FileReader  fin = new FileReader("BankData");
		BufferedReader ob = new BufferedReader(fin);
		FileWriter  fout = new FileWriter("temp");
	    BufferedWriter ob1 = new BufferedWriter(fout);
		String b =String.valueOf(balance);
		while((line = ob.readLine())!=null)
		{
		if(line.equals(acc)){
			tacc=line;
			line = ob.readLine();
			tname=line;
			line = ob.readLine();
			bal=Integer.parseInt(line);
			if(bal<balance){
			System.out.println("\t \t Insufficient Balance");
			}
			else
			bal-=balance;
	        }
		else
		{
			ob1.write(line);
			ob1.newLine();
		}
	}      ob1.write(tacc);
			ob1.newLine();
			ob1.write(tname);
			ob1.newLine();
			ob1.write(String.valueOf(bal));
			ob1.newLine();
	
		ob.close();
		fin.close();
		ob1.close();
		fout.close();
		}
		catch(FileNotFoundException ex){
				System.out.println("Unable to open file '" );
			}
			catch(IOException ex){
				System.out.println("Error reading file '" );
			}
			try{
		FileReader  fin = new FileReader("temp");
		BufferedReader ob = new BufferedReader(fin);
		FileWriter  fout = new FileWriter("BankData");
	    BufferedWriter ob1 = new BufferedWriter(fout);
		String b =String.valueOf(balance);
		while((line = ob.readLine())!=null)
		{
		ob1.write(line);
		ob1.newLine();
	}  	
		ob.close();
		fin.close();
		ob1.close();
		fout.close();
		}
		catch(FileNotFoundException ex){
				System.out.println("Unable to open file '" );
			}
			catch(IOException ex){
				System.out.println("Error reading file '" );
			}
		
		}
}
class BankSystem implements Serializable{
        public static void main(String[]agr)throws Exception{
			String exit = new String("no");
 while(true){
   System.out.println("\n \t \t ----------Online Banking Managemant----------\n");
   System.out.println("\t---------------------------------------------");
	System.out.println("\t \t 1->Creat New Account\n \t \t 2->Deposit Money \n \t \t 3->Withdraw Money\n \t \t 4->Show All Acounts\n \t \t 5->Search Account\n \t \t 6->Exit");
   System.out.println("\t---------------------------------------------");
	Scanner s = new Scanner(System.in);
	System.out.print("\t \t Enter your Choice :");
	int m=s. nextInt();
	BankSystem bk = new BankSystem();
	Account a = new Account();
	int ac;
	long b;
	switch(m){
	case 1:		
	a.create();
	break;
	case 2:a.deposite();
	break;
	case 3:a.withdraw();
		break;
	case 4:a.show();
		break;
	case 5:a.search();
		break;
	case 6:System.exit(0);
     }
		}	 
        }	

}