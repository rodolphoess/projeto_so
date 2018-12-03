package projeto_so;

import java.util.ArrayList;
import java.util.List;

public class CilindrosSSTF implements CalculoCilindros {
	DadosHardDrive hd = null;

	public CilindrosSSTF(DadosHardDrive hd) {
		this.hd = hd;
	}

	@Override
	public void ordenaFila() {
		int menorDiferenca = 0, diferenca = 0, posicaoLista = 0;
		int numeroComAMenorDiferenca = 0;
		int cilindroAtual = hd.getPosicaoCabecote();
		List<Integer> filaEspera = new ArrayList<Integer>();
		int[] filaEsperaOrdenada = new int[hd.getTamanhoFilaEspera() + 1];
		
		for (int i = 0; i < hd.getFilaEsperaList().size(); i++) {
			filaEspera.add(hd.getFilaEsperaList().get(i));
		}

		for (int i = 0; i <= hd.getTamanhoFilaEspera(); i++) {
			if (i == 0)
				filaEsperaOrdenada[i] = cilindroAtual;

			for (int j = 0; j < filaEspera.size(); j++) {

				if (j == 0) {
					menorDiferenca = Math.abs(cilindroAtual - filaEspera.get(j));
					numeroComAMenorDiferenca = filaEspera.get(j);
					posicaoLista = j;
				} else
					diferenca = Math.abs(cilindroAtual - filaEspera.get(j));

				if (j > 0 && j < hd.getTamanhoFilaEspera() && menorDiferenca > diferenca) {
					menorDiferenca = diferenca;
					numeroComAMenorDiferenca = filaEspera.get(j);
					posicaoLista = j;
				}

				if (j == hd.getTamanhoFilaEspera())
					numeroComAMenorDiferenca = filaEspera.get(j);
			}

			if (i > 0) {
				filaEsperaOrdenada[i] = numeroComAMenorDiferenca;
				if (filaEspera.size() != 0)
					filaEspera.remove(posicaoLista);
			}
		}

		hd.setFilaEspera(filaEsperaOrdenada);

		imprimeFila();
	}

	@Override
	public void imprimeFila() {
		int[] filaEspera = hd.getFilaEspera();

		System.out.print("\tOrdem: ");
		for (int i = 0; i < hd.getTamanhoFilaEspera(); i++) {
			if (i == 0)
				System.out.print(filaEspera[i]);
			else
				System.out.print(", " + filaEspera[i]);
		}
	}

	@Override
	public void calculaNumeroCilindrosPercorridos() {
		int cilindroAtual = hd.getPosicaoCabecote();
		int[] filaEspera = hd.getFilaEspera();

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
		System.out.println("\nSSTF");
	}

}
