package projeto_so;

import java.util.ArrayList;
import java.util.List;

public class DadosHardDrive {
	private int posicaoCabecote;
	private int[] filaEspera;
	private int tamanhoFilaEspera = 0;
	private List<Integer> filaEsperaList = null;
	
	public DadosHardDrive(int tamanhoFilaEspera, int posicaoCabecote) {
		this.tamanhoFilaEspera = tamanhoFilaEspera + 1;
		this.posicaoCabecote = posicaoCabecote;
		
		filaEspera = new int[tamanhoFilaEspera + 1];
		filaEsperaList = new ArrayList<Integer>();
	}

	public int getPosicaoCabecote() {
		return posicaoCabecote;
	}

	public List<Integer> getFilaEsperaList() {
		return filaEsperaList;
	}

	public void setFilaEsperaList(List<Integer> filaEsperaList) {
		this.filaEsperaList = filaEsperaList;
	}

	public void setPosicaoCabecote(int posicaoCabecote) {
		this.posicaoCabecote = posicaoCabecote;
	}

	public int[] getFilaEspera() {
		return filaEspera;
	}

	public void setFilaEspera(int[] filaEspera) {
		this.filaEspera = filaEspera;
	}

	public int getTamanhoFilaEspera() {
		return tamanhoFilaEspera;
	}

	public void setTamanhoFilaEspera(int tamanhoFilaEspera) {
		this.tamanhoFilaEspera = tamanhoFilaEspera;
	}

	
}
