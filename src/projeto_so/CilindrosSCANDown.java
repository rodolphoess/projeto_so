package projeto_so;

import java.util.ArrayList;
import java.util.List;

public class CilindrosSCANDown implements CalculoCilindros {
	DadosHardDrive hd = null;
	
	public CilindrosSCANDown(DadosHardDrive hd) {
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

		List<Integer> filaEsperaCima = setoresMenores(filaEspera, cilindroAtual);
		List<Integer> filaEsperaBaixo = setoresMaiores(filaEspera, cilindroAtual);
		
		int tamanhoInicialFilaBaixo = filaEsperaBaixo.size();
		for (int i = 0; i <= tamanhoInicialFilaBaixo; i++ ) {
			if (i == 0)
				filaEsperaOrdenada[i] = cilindroAtual;
			
			for (int j = 0; j < filaEsperaBaixo.size(); j++) {
				if (j == 0) {
					menorDiferenca = Math.abs(cilindroAtual - filaEsperaBaixo.get(j));
					numeroComAMenorDiferenca = filaEsperaBaixo.get(j);
					posicaoLista = j;
				} else
					diferenca = Math.abs(cilindroAtual - filaEsperaBaixo.get(j));

				if (j > 0 && menorDiferenca > diferenca) {
					menorDiferenca = diferenca;
					numeroComAMenorDiferenca = filaEsperaBaixo.get(j);
					posicaoLista = j;
				}
			}
			
			if (i > 0) {
				filaEsperaOrdenada[i] = numeroComAMenorDiferenca;
				
				if (filaEsperaBaixo.size() != 0)
					filaEsperaBaixo.remove(posicaoLista);
			}
		}
		
		int tamanhoInicialFilaCima = filaEsperaCima.size();
		for (int j = tamanhoInicialFilaBaixo + 1; j <= tamanhoInicialFilaCima + tamanhoInicialFilaBaixo; j++) {
			for (int i = 0; i < filaEsperaCima.size(); i++) {

				if (i == 0) {
					menorDiferenca = Math.abs(cilindroAtual - filaEsperaCima.get(i));
					numeroComAMenorDiferenca = filaEsperaCima.get(i);
					posicaoLista = i;
				} else
					diferenca = Math.abs(cilindroAtual - filaEsperaCima.get(i));

				if (i > 0 && menorDiferenca > diferenca) {
					menorDiferenca = diferenca;
					numeroComAMenorDiferenca = filaEsperaCima.get(i);
					posicaoLista = i;
				}
			}
			
			if (j > 0) {
				filaEsperaOrdenada[j] = numeroComAMenorDiferenca;

				if (filaEsperaCima.size() != 0)
					filaEsperaCima.remove(posicaoLista);
			}
		}
		
		hd.setFilaEspera(filaEsperaOrdenada);

		imprimeFila();
	}

	private List<Integer> setoresMaiores(List<Integer> filaEspera, int cilindroAtual) {
		List<Integer> filaEsperaCima = new ArrayList<Integer>();

		for (int i = 0; i < filaEspera.size(); i++) {
			if (filaEspera.get(i) > cilindroAtual)
				filaEsperaCima.add(filaEspera.get(i));
		}

		return filaEsperaCima;
	}

	private List<Integer> setoresMenores(List<Integer> filaEspera, int cilindroAtual) {
		List<Integer> filaEsperaBaixo = new ArrayList<Integer>();

		for (int i = 0; i < filaEspera.size(); i++) {
			if (filaEspera.get(i) < cilindroAtual)
				filaEsperaBaixo.add(filaEspera.get(i));
		}

		return filaEsperaBaixo;
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
		System.out.println("\nSCAN DESCE");
	}
	
}
