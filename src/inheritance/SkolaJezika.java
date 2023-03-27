package inheritance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SkolaJezika {

	private Kurs[] kursevi;
	
	public void ucitavanjeIzFajla() throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new FileReader("resources/kursevi.txt"));
		int brKurseva = Integer.parseInt(in.readLine());
		kursevi = new Kurs[brKurseva];
		
		for(int i = 0; i < kursevi.length; i++) {
			String[] tokens = in.readLine().split(",");
			String jezik = tokens[0].trim();
			String nivo = tokens[1].trim();
			int brPolaznika = Integer.parseInt(tokens[2].trim());
			
			kursevi[i] = new Kurs(jezik, nivo, brPolaznika);
		}
		
		in.close();
	}
	
	public void stampajKurseve() {
		for(Kurs k : kursevi) {
			System.out.println(k);
		}
	}
	
	public String najnaprednijiJezik() {
		String jezikMax = "";
		int maxPolaznika = 0;
		
		for(Kurs k : kursevi) {
			if(k.getNivo().equals("napredni")) {
				if(k.getBrPolaznika() > maxPolaznika) {
					maxPolaznika = k.getBrPolaznika();
					jezikMax = k.getJezik();
				}
			}
		}
		return jezikMax;
	}
	
	public void unaprediGrupu(String jezik, String nivo) {
		if(!(nivo.equals("osnovni") || nivo.equals("srednji"))) {
			return;
		}
		for(Kurs k : kursevi) {
			if(k.getJezik().equals(jezik) && k.getNivo().equals(nivo)) {
				if(nivo.equals("osnovni")) {
					k.setNivo("srednji");
				} else {
					k.setNivo("napredni");
				}
				for(Kurs j : kursevi) {
					
					if(k != j && k.getJezik().equals(j.getJezik()) && k.getNivo().equals(j.getNivo())) {
						System.out.println("Vec postoji unapredjen kurs! Potrebno je spojiti grupe!");
						break;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {

		SkolaJezika nizKurseva = new SkolaJezika();
		try {
			nizKurseva.ucitavanjeIzFajla();
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
		nizKurseva.stampajKurseve();
		System.out.println();
		System.out.println("Jezik sa najvise polaznika na naprednom nivou je " + nizKurseva.najnaprednijiJezik());
		System.out.println();
		nizKurseva.unaprediGrupu("engleski", "osnovni");
		System.out.println();
		nizKurseva.stampajKurseve();
	}

}
