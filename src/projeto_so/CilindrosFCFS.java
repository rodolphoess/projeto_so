package projeto_so;

public class CilindrosFCFS implements CalculoCilindros {
	DadosHardDrive hd = null;
	
	public CilindrosFCFS(DadosHardDrive hd) {
		this.hd = hd;
	}

	@Override
	public void ordenaFila() {
		imprimeFila();
	}

	@Override
	public void imprimeFila() {
		int[] filaEspera = hd.getFilaEspera();
		
		System.out.print("\tOrdem: " + hd.getPosicaoCabecote());
		for (int i = 0; i < hd.getTamanhoFilaEspera(); i++) {
			System.out.print(", " + filaEspera[i]);
		}
	}

	@Override
	public void calculaNumeroCilindrosPercorridos() {
		int cilindroAtual = hd.getPosicaoCabecote();
		int [] filaEspera = hd.getFilaEspera();
		
		int numeroCilindros = 0;
		
		for (int i = 0; i < hd.getTamanhoFilaEspera() - 1; i++) {
			
			if (cilindroAtual > filaEspera[i + 1])
				numeroCilindros += cilindroAtual - filaEspera[i + 1];
			else
				numeroCilindros += filaEspera[i + 1] - cilindroAtual;
			
			cilindroAtual = filaEspera[i + 1];
		}
		
		imprimeNumeroCilindrosPercorridos(numeroCilindros);
	}

	@Override
	public void imprimeNumeroCilindrosPercorridos(int numeroCilindros) {
		System.out.print("\n\tCilindros: " + numeroCilindros);
		
	}

	@Override
	public void imprimeCabecalho() {
		System.out.println("FCFS");
	}
	
}
