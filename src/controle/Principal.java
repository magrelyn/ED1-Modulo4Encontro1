package controle;

import modelo.Lista;
import modelo.ListaProduto;
import modelo.Produto;

public class Principal {

	public static void main(String[] args) {

		// Testando metodo da atividade 1

		Lista lista1 = new Lista();

		int vet1[] = { 13, 12, 3, 4, 9, 13 };

		lista1.addArray(vet1);

		System.out.println(lista1.toString());

		// Testando metodo da atividade 1 [como construtor]

		int vet2[] = { 3, 2, 3, 4, 9 };

		Lista lista2 = new Lista(vet2);

		System.out.println(lista2.toString());
		
		// Testando metodo da atividade 2
		
		int vet3[] = { 5, 6, 1, 5 };

		Lista lista3 = new Lista(vet3);
		
		int vet4[] = new int[4];
		
		vet4 = lista3.toArray();
		
		for (int i = 0; i < vet4.length; i++) {
			System.out.print(vet4[i] + ", ");
		}
		
		// Testando metodo da atividade 3
		
		Lista lista4 = new Lista();

		int vet5[] = { 13, 12, 53, 64, 39, 62 };

		lista4.addArray(vet5);

		System.out.println(lista4);

		boolean resp = lista4.removeNPrimeiros(4);

		if(resp)
			System.out.println(lista4);
		else
			System.out.println("Nao e possivel remover esses elementos");
		
		// Testando metodo da atividade 4
		
		Lista lista5 = new Lista();
		Lista lista6 = new Lista();

		int vet6[] = { 13, 12, 53, 64, 39, 62 };
		
		lista5.addArray(vet6);
		
		lista6 = lista5.getPairs();
		
		System.out.println(lista6.toString());
		
		// Testando metodo da atividade 5
		
		Lista lista7 = new Lista();
		
		int vet7[] = { 1, 2, 3, 4, 5 };
		
		lista7.addArray(vet7);
		
		System.out.println("Media = " + lista7.media());
		
		// Testando metodo da atividade 6
		
		Lista lista8 = new Lista();
		
		int vet8[] = { 6, 1, 6 };
		
		lista8.addArray(vet8);
		
		System.out.println(lista8.isOrdered());
		
		// Testando metodo da atividade 7
		
		Lista lista9 = new Lista();
		Lista lista10 = new Lista();
		
		int vet9[] = { 2, 4, 3, 4 };
		int vet10[] = { 2, 4, 3, 4 };
		
		lista9.addArray(vet9);
		lista10.addArray(vet10);
		
		if(lista9.isEquals(lista10))
			System.out.println("Iguais");
		else System.out.println("Diferentes");
		
		// Testando metodo da atividade 8
		
		// Testando metodo da atividade 9
		
		Lista lista11 = new Lista();
		
		int vet11[] = { 4, 3, 5, 11, 5 };
		
		lista11.addArray(vet11);
		
		lista11.eliminaX(5);

		System.out.println(lista11);
		
		// Testando metodo da atividade 10
		
		Produto p1 = new Produto(01, "Sola", 1000.50, 1);
		Produto p2 = new Produto(02, "Mola", 1.50, 202);
		Produto p3 = new Produto(03, "Cola", 4.50, 24);
		Produto p4 = new Produto(04, "Gola", 0.90, 7);
		Produto p5 = new Produto(05, "Bola", 8.50, 5);

		Produto vetProd[] = {p1, p2, p3, p4, p5};
		
		ListaProduto listaP = new ListaProduto(vetProd);
		
		System.out.println(listaP.menorPreco());
		
	}

}
