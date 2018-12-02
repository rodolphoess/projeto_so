package projeto_so;

public class DadosHardDrive {
	private int posicaoCabecote;
	private int[] filaEspera;
	private int tamanhoFilaEspera = 0;
	
	public DadosHardDrive(int tamanhoFilaEspera, int posicaoCabecote) {
		this.tamanhoFilaEspera = tamanhoFilaEspera;
		this.posicaoCabecote = posicaoCabecote;
		
		filaEspera = new int[tamanhoFilaEspera];
	}

	public int getPosicaoCabecote() {
		return posicaoCabecote;
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
