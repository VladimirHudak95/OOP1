package inheritance;

public class Kladionicar {

	private String ime;
	private String imeIgre;
	private int stanjeNaRacunu;
	
	public Kladionicar() {
	}
	
	public Kladionicar(String ime, String imeIgre, int stanjeNaRacunu) {
		this.ime = ime;
		if(isValidGame(imeIgre)) {
			this.imeIgre = imeIgre;
		} else {
			this.imeIgre = "poker";
		}
		this.stanjeNaRacunu = stanjeNaRacunu;
	}
	
	public String getIme() {
		return ime;
	}
	
	public String getImeIgre() {
		return imeIgre;
	}
	
	public int getStanjeNaRacunu() {
		return stanjeNaRacunu;
	}
	
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public void setImeIgre(String imeIgre) {
		if(isValidGame(imeIgre)) {
			this.imeIgre = imeIgre;
		} else {
			this.imeIgre = "poker";
		}
	}
	
	public void setStanjeNaRacunu(int stanjeNaRacunu) {
		this.stanjeNaRacunu = stanjeNaRacunu;
	}
	
	private boolean isValidGame(String imeIgre) {
		if(imeIgre.equals("poker") || imeIgre.equals("ajnc") || imeIgre.equals("rulet")){
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return ime + " igra " + imeIgre + " i ima " + stanjeNaRacunu + " na racunu.";
	}
	
}
