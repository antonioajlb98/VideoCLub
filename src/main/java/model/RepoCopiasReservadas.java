package model;

import java.util.ArrayList;

public class RepoCopiasReservadas {
	ArrayList<Copia> RepoCopiasReservadas;
	
	private RepoCopiasReservadas() {
		RepoCopiasReservadas=new ArrayList<Copia>();
	}
	private static RepoCopiasReservadas RcR;
	
	public static RepoCopiasReservadas getInstance() {
		if (RcR == null) {
			RcR = new RepoCopiasReservadas();
		}
		return RcR;
	}

	public void addCopy(Copia c) {
		RepoCopiasReservadas.add(c);
	}
	public void removeCopy(Copia c) {
		RepoCopiasReservadas.remove(c);
	}
	public void getCopy(Copia c) {
		RepoCopiasReservadas.
	}
}
