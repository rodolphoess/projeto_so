package projeto_so;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Informe o nome de arquivo texto, por exemplo, c:\\teste.txt: ");
		String nome = scanner.nextLine();

		int tamanhoFila = 0, posicao = 0;
		int[] filaEspera = null;
		List<Integer> filaEsperaList = new ArrayList<Integer>();
		try {
			FileReader arq = new FileReader(nome);
			BufferedReader lerArq = new BufferedReader(arq);

			String linha = lerArq.readLine();
			posicao = Integer.parseInt(linha);

			linha = lerArq.readLine();
			tamanhoFila = Integer.parseInt(linha);

			linha = lerArq.readLine();
			String[] linhaSplit = linha.split(" ");
			filaEspera = new int[tamanhoFila];
			for (int i = 0; i < linhaSplit.length; i++) {
				Integer auxiliarFila = Integer.parseInt(linhaSplit[i]);

				if (auxiliarFila > 199) {
					System.err.println("Foi informado um setor maior do que 199.");
					return;
				}
				
				filaEspera[i] = auxiliarFila;
				filaEsperaList.add(auxiliarFila);
			}

			DadosHardDrive hd = new DadosHardDrive(tamanhoFila, posicao);
			hd.setFilaEspera(filaEspera);
			hd.setFilaEsperaList(filaEsperaList);

			CalculoCilindros cilindrosFCFS = new CilindrosFCFS(hd);
			cilindrosFCFS.imprimeCabecalho();
			cilindrosFCFS.ordenaFila();
			cilindrosFCFS.calculaNumeroCilindrosPercorridos();

			CalculoCilindros cilindrosSSTF = new CilindrosSSTF(hd);
			cilindrosSSTF.imprimeCabecalho();
			cilindrosSSTF.ordenaFila();
			cilindrosSSTF.calculaNumeroCilindrosPercorridos();
			
			CalculoCilindros cilindrosSCANUp = new CilindrosSCANUp(hd);
			cilindrosSCANUp.imprimeCabecalho();
			cilindrosSCANUp.ordenaFila();
			cilindrosSCANUp.calculaNumeroCilindrosPercorridos();

			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}

		System.out.println();
	}

}
