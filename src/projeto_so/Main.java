package projeto_so;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Posicao inicial cabecote: ");
		int posicao = scanner.nextInt();
//		System.out.println(posicao);
		
		System.out.println("Tamanho da fila: ");
		int tamanhoFila = scanner.nextInt();
//		System.out.println(tamanhoFila);
		
		System.out.println("Fila de espera");
		int auxiliarFila = 0;
		
		int[] filaEspera = new int[tamanhoFila];
		
		for (int i = 0; i < tamanhoFila; i++) {
			auxiliarFila = scanner.nextInt();
			filaEspera[i] = auxiliarFila;
		}
		
		DadosHardDrive hd = new DadosHardDrive(tamanhoFila, posicao);
		hd.setFilaEspera(filaEspera);
		
		CalculoCilindros cilindrosFCFS = new CilindrosFCFS(hd);
		cilindrosFCFS.imprimeCabecalho();
		cilindrosFCFS.ordenaFila();
		cilindrosFCFS.calculaNumeroCilindrosPercorridos();
	}

}
