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
		for (int i = 0; i < hd.getTamanhoFilaEspera() - 1; i++) {
			System.out.print(", " + filaEspera[i]);
		}
	}

	@Override
	public void calculaNumeroCilindrosPercorridos() {
		int cilindroAtual = hd.getPosicaoCabecote();
		int[] filaEspera = hd.getFilaEspera();

		int numeroCilindros = 0;

		for (int i = 0; i < hd.getTamanhoFilaEspera() - 1; i++) {

			numeroCilindros += Math.abs(cilindroAtual - filaEspera[i]);

			cilindroAtual = filaEspera[i];
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
