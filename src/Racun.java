import java.util.Scanner;
import java.util.ArrayList;

public class Racun {

	private String ime;
	private   int broj;
	private double stanje;

	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public  int getBroj() {
		return broj;
	}
	public void setBroj(int broj) {
		this.broj = broj;
		
	}
	public double getStanje() {
		return stanje;
	}
	public void setStanje(double stanje) {
		this.stanje = stanje;
	}
	
	
	public static Racun kreirajRacun(ArrayList<Racun>racuni, Scanner unos){
		
	
		
		Racun racun = new Racun();
		System.out.println("Unesite vaše ime: ");
		racun.setIme(unos.next());
		System.out.println("Unesite broj raèuna: ");
		racun.setBroj(unos.nextInt());
		
		while(provjeraBroj(racuni, racun.broj) || racun.broj<0)
		{
			System.out.println("Neispravan broj raèuna. Molimo vas unesite ponovo: ");
			racun.setBroj(unos.nextInt());
		}
		System.out.println("Unesite iznos koji uplaæujete na svoj raèun: ");
		racun.stanje=unos.nextDouble();
		
		while(racun.stanje<0){
			System.out.println("Iznos je negativan!\nUnesite iznos koji uplaæujete na svoj raèun: ");
			racun.stanje=unos.nextDouble();
		}
		
		return racun;
	}
	public static boolean provjeraBroj(ArrayList<Racun>lista, int broj){
		for(Racun r : lista){
			if(r.getBroj()==broj){
				return true;
			}
		}
		
		return false;
	}
	
	public static void stanjeRacuna(ArrayList<Racun>racuni, Scanner unos){
		int broj;
		System.out.println("Unesite vaš broj raèuna: ");
		broj=unos.nextInt();
		boolean provjera = true;
		Racun source = new Racun();
		while(provjera)
		{
			for(int i = 0; i<racuni.size();i++)
			{
				if(broj==racuni.get(i).getBroj())
				{
					source=racuni.get(i);
					provjera = false;
					break;
					
				}
			}
			if(provjera){
				System.out.println("Unijeli ste neispravan broj raèuna!\nMolimo vas unesite ponovo: ");
				broj=unos.nextInt();
				
			}
		}
		
		System.out.println("=======================================\nStanje racuna\n=======================================");
		System.out.println("Ime: "+source.ime+"\nStanje racuna: "+source.getStanje()+" KM");
		}	
	}

