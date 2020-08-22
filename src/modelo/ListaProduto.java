package modelo;

public class ListaProduto {

	private NoProduto lista;
	private int tamanho;

	public ListaProduto() {
		this.lista = null;
		this.tamanho = 0;
	}

	public ListaProduto(Produto vetor[]) {
		for (int i = 0; i < vetor.length; i++) {
			this.adiciona(vetor[i]);
		}
	}

	// metodo para buscar o produto de menor preco
	public Produto menorPreco() {

		if (this.tamanho == 0)
			throw new IllegalArgumentException("404: Lista vazia :(");

		Produto menor = this.lista.getInfo();

		if (this.tamanho == 1)
			return menor;

		NoProduto p = this.lista;
		p = p.getProx();

		while (p != null) {
			if (menor.getPreco() > p.getInfo().getPreco()) {
				menor = p.getInfo();
			}
			p = p.getProx();
		}

		return menor;
	}

	// insere valor no fim da lista
	// retorna true (sucesso) ou false
	public boolean adiciona(Produto valor) {

		if (this.lista == null) {
			// lista vazia
			this.lista = new NoProduto(valor);
			this.tamanho++;
			return true;
		} else {
			// procura pelo fim da lista
			NoProduto atual = this.lista;
			while (atual.getProx() != null)
				atual = atual.getProx();
			// insere o no no fim da lista
			atual.setProx(new NoProduto(valor));
			this.tamanho++;
			return true;
		}
	}

	public String toString() {

		NoProduto p = this.lista;
		StringBuilder s = new StringBuilder();

		s.append("[");

		for (int i = 0; i < (this.tamanho - 1); i++) {
			s.append(p.getInfo() + ", ");
			p = p.getProx();
		}

		if (this.tamanho > 0) {
			s.append(p.getInfo());
		}

		s.append("]");

		return s.toString();
	}

}
