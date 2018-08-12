import java.util.Scanner;
import java.util.ArrayList;
public class Transakcija extends Racun {

	private static  int sourceNo;
	private  static int targetNo;
	private  static double iznos;
	static boolean provjera = true;
	

	
	static Racun source = new Racun();
	static Racun target = new Racun();
	
	public static void transakcija(ArrayList<Racun>racuni, Scanner unos){
		
		System.out.println("Unesite vaš broj raèuna: ");
		sourceNo=unos.nextInt();
		
		while(provjera)
		{
			for(int i=0; i<racuni.size();i++)
			{
				if(sourceNo==racuni.get(i).getBroj())
				{
					source=racuni.get(i);
					provjera=false;
					break;
					
				}
			}
			if(provjera){
				System.out.println("Unijeli ste nepostojeæi broj raèuna!\nMolimo vas unesite ponovo: ");
				sourceNo=unos.nextInt();
			}
		}
		
		provjera = true;
	System.out.println("Unesite broj raèuna na koji prebacujete novac: ");
	targetNo=unos.nextInt();
	
	while(provjera){
		for(int i = 0; i<racuni.size();i++)
		{
			if(targetNo==racuni.get(i).getBroj())
			{
				target=racuni.get(i);
				provjera=false;
				break;
				
			}
		}
		if(provjera){
			System.out.println("Unijeli ste nepostojeæi broj raèuna!\nMolimo vas unesite ponovo: ");
			targetNo=unos.nextInt();
		}
	}
		
	System.out.println("Unesite iznos novca koji prebacujete: ");
	iznos=unos.nextDouble();
	
	if(iznos < 0 || iznos > source.getStanje()){
		System.out.println("Transkacija onemoguæena. Unesite drugi iznos: ");
		iznos=unos.nextDouble();
	}
	source.setStanje(source.getStanje()-iznos);
	target.setStanje(target.getStanje()+iznos);
	}
	
		
}
