package inheritance;

public class Kazino {

	private Kladionicar[] nizKladionicara;
	
	public Kazino(Kladionicar[] nizKladionicara) {
		this.nizKladionicara = nizKladionicara;
	}
	
	public String najprofitnijaIgra() {
		int ajnc = 0;
		int poker = 0;
		int rulet = 0;
		
		for(Kladionicar k : nizKladionicara) {
			if(k.getStanjeNaRacunu() < 0) {
				if(k.getImeIgre().equals("ajnc")) {
					ajnc++;
				} else if(k.getImeIgre().equals("poker")) {
					poker++;
				} else {
					rulet++;
				}
			}
		}
		
		if(ajnc >= poker && ajnc >= rulet) {
			return "ajnc";
		}
		if(poker >= ajnc && poker >= rulet) {
			return "poker";
		}
		
		return "rulet";
		
	}
	
	@Override
	public String toString() {
		String rez = "";
		for(int i = 0; i < nizKladionicara.length; i++) {
			rez += nizKladionicara[i].toString() + "\n";
		}
		return rez;
	}

	public static void main(String[] args) {

		Kladionicar niz[] = {
			new Kladionicar("Pera", "adasd", 15000),
			new Kladionicar("Mika", "ajnc", 17000),
			new Kladionicar("Zika", "rulet", -1500),
			new Kladionicar("Bora", "ajnc", -11000),
			new Kladionicar("Dora", "rulet", 5000),
			new Kladionicar("Zora", "ajnc", -3000),
			new Kladionicar("Lara", "adasd", 22000),
			new Kladionicar("Mara", "adasd", 7000),
		};
		
		Kazino kazino = new Kazino(niz);
		
		System.out.println(kazino);
		
		System.out.println("Najprofitnija igra trenutno je " + kazino.najprofitnijaIgra() + ".");
		
	}
	
	

}
