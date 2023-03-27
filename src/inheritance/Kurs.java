package inheritance;

public class Kurs {
	
	private String jezik;
	private String nivo;
	private int brPolaznika;
	
	public Kurs() {
	}
	
	public Kurs(String jezik, String nivo, int brPolaznika) {
		this.jezik = jezik;
		
		if(isValidNivo(nivo)) {
			this.nivo = nivo;
		} else {
			this.nivo = "osnovni";
		}
		
		if(brPolaznika <= 0) {
			this.brPolaznika = 0;
		} else {
			this.brPolaznika = brPolaznika;
		}
	}
	
	public String getJezik() {
		return jezik;
	}
	
	public String getNivo() {
		return nivo;
	}
	
	public int getBrPolaznika() {
		return brPolaznika;
	}
	
	public void setJezik(String jezik) {
		this.jezik = jezik;
	}
	
	public void setNivo(String nivo) {
		if(isValidNivo(nivo)) {
			this.nivo = nivo;
		} else {
			this.nivo = "osnovni";
		}
	}
	
	public void setBrPolaznika(int brPolaznika) {
		if(brPolaznika <= 0) {
			this.brPolaznika = 0;
		} else {
			this.brPolaznika = brPolaznika;
		}
	}
	
	private boolean isValidNivo(String nivo) {
		return nivo.equals("osnovni") || nivo.equals("srednji") || nivo.equals("napredni");
	}
	
	@Override
	public String toString() {
		return jezik + " nivo " + nivo + " ima " + brPolaznika + " polaznika.";
	}
}