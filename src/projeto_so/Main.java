package projeto_so;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Posicao inicial cabecote: ");
		int posicao = scanner.nextInt();
		
		System.out.println("Tamanho da fila: ");
		int tamanhoFila = scanner.nextInt();
		
		System.out.println("Fila de espera");
		Integer auxiliarFila = 0;
		
		int[] filaEspera = new int[tamanhoFila];
		List<Integer> filaEsperaList = new ArrayList<Integer>();
		
		for (int i = 0; i < tamanhoFila; i++) {
			auxiliarFila = scanner.nextInt();
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
	}

}
