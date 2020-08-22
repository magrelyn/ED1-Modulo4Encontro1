package modelo;

public class Lista {

	private NoLista lista;
	private int tamanho;

	public Lista() {
		this.lista = null;
		this.tamanho = 0;
	}

	// metodo que cria uma lista encadeada a partir de um vetor [construtor]
	public Lista(int vetor[]) {
		for (int i = 0; i < vetor.length; i++) {
			this.adiciona(vetor[i]);
		}
	}

	// metodo que cria uma lista encadeada a partir de um vetor
	public void addArray(int vetor[]) {
		for (int i = 0; i < vetor.length; i++) {
			this.adiciona(vetor[i]);
		}
	}

	// metodo que copia a lista encadeada para um vetor
	public int[] toArray() {

		int vetor[] = new int[this.tamanho];

		for (int i = 0; i < this.tamanho; i++) {
			vetor[i] = this.lista.getInfo();
			this.lista = this.lista.getProx();
		}

		return vetor;
	}

	// metodo que remove os n primeiros elementos da lista
	// O metodo retorna se a operação foi possivel ou nao
	public boolean removeNPrimeiros(int n) {
		if (!(n > 0 && n <= this.tamanho)) {
			return false;
		} else {
			for (int i = 0; i < n; i++) {
				this.removeDoInicio();
			}
			return true;
		}
	}

	// metodo que retorna uma nova lista contendo apenas os numeros pares da lista
	public Lista getPairs() {

		Lista novaLista = new Lista();

		for (NoLista p = this.lista; p != null; p = p.getProx())
			if (p.getInfo() % 2 == 0)
				novaLista.adiciona(p.getInfo());

		return novaLista;
	}

	// metodo que retorna a media dos numeros da lista
	public double media() {
		double media = 0;
		for (NoLista p = this.lista; p != null; p = p.getProx())
			media += p.getInfo();

		return ((double) media / this.tamanho);
	}

	// metodo que verifica se uma lista esta ordenada ou nao (ordem crescente ou
	// decrescente)
	public boolean isOrdered() {

		if(this.tamanho() == 1)
			return true;
		
		int ant = this.lista.getInfo();

		NoLista p = this.lista;
		p = p.getProx();

		if (ant < p.getInfo()) {
			while (p != null)
				if (ant <= p.getInfo()) {
					ant = p.getInfo();
					p = p.getProx();
				} else {
					return false;
				}
		} else {
			while (p != null)
				if (ant >= p.getInfo()) {
					ant = p.getInfo();
					p = p.getProx();
				} else {
					return false;
				}
		}

		return true;
	}

	// metodo que verifica se a lista dada e igual a esta (mesmo conteudo)
	public boolean isEquals(Lista l) {

		if (this.tamanho() != l.tamanho()) {
			return false;
		} else {
			for (NoLista p = this.lista, o = l.lista; p != null && o != null; p = p.getProx(), o = o.getProx())
				if (p.getInfo() != o.getInfo())
					return false;
		}

		return true;
	}

	// metodo que inverte a ordem das celulas de uma lista encadeada
	public void inverte() {
		
	}

	// metodo para eliminar todos as ocorrencias de um elemento X da lista
	public void eliminaX(int x) {
		for (NoLista p = this.lista; p != null; p = p.getProx())
			if (p.getInfo() == x)
				this.remove(this.buscaElemento(x));
	}

	// adiciona inicio
	private void adicionaInicio(int valor) {
		if (this.lista == null) {
			// lista vazia
			this.lista = new NoLista(valor);
			this.tamanho++;
		} else {
			// cria-se um novo no e atualiza o
			// NoLista do inicio
			NoLista novoNo = new NoLista(valor);
			novoNo.setProx(this.lista);
			this.lista = novoNo;
			this.tamanho++;
		}
	}

	// insere valor no fim da lista
	// retorna true (sucesso) ou false
	public boolean adiciona(int valor) {

		if (this.lista == null) {
			// lista vazia
			this.lista = new NoLista(valor);
			this.tamanho++;
			return true;
		} else {
			// procura pelo fim da lista
			NoLista atual = this.lista;
			while (atual.getProx() != null)
				atual = atual.getProx();
			// insere o no no fim da lista
			atual.setProx(new NoLista(valor));
			this.tamanho++;
			return true;
		}

	}

	// verifica se a posicao existe
	private boolean posicaoEstaOcupada(int posicao) {
		return posicao >= 0 && posicao < this.tamanho;
	}

	// pega o NoLista da posicao informada
	private NoLista getNoLista(int posicao) {
		if (!this.posicaoEstaOcupada(posicao)) {
			throw new IllegalArgumentException("404: Posicao not existe :(");
		}

		NoLista atual = this.lista;
		for (int i = 0; i < posicao; i++) {
			atual = atual.getProx();
		}
		return atual;
	}

	// adiciona elemento na posicao
	// retorna true (sucesso) ou false
	public boolean adiciona(int posicao, int elemento) {

		if (!this.posicaoEstaOcupada(posicao)) {
			return false;
		}

		if (posicao == 0) { // No comeco
			this.adicionaInicio(elemento);
			return true;
		} else if (posicao == this.tamanho) { // No fim
			this.adiciona(elemento);
			return true;
		} else { // No meio
			NoLista anterior = this.getNoLista(posicao - 1);
			NoLista nova = new NoLista();
			nova.setInfo(elemento);
			nova.setProx(anterior.getProx());
			anterior.setProx(nova);
			this.tamanho++;
			return true;
		}
	}

	// Retorna o String que esta na posicao
	public int busca(int posicao) {
		if (!this.posicaoEstaOcupada(posicao)) {
			throw new IllegalArgumentException("404: Posicao not existe :(");
		} else {
			NoLista no = getNoLista(posicao);
			return no.getInfo();
		}
	}

	// busca pelo elemento no vetor
	// retorna a posicao do elemento no vetor
	// return -1 se nao encontrou o elemento
	public int buscaElemento(int elemento) {
		int i = 0;

		for (NoLista p = this.lista; p != null; p = p.getProx()) {
			if (p.getInfo() == elemento) {
				return i;
			}
			i++;
		}
		return -1;
	}

	private int getTamanho() {
		return tamanho;
	}

	// retorna o tamanho (quantidade de elementos)
	public int tamanho() {
		return this.getTamanho();
	}

	// remove o elemento que esta no inicio da lista
	private void removeDoInicio() {

		this.lista = this.lista.getProx();
		this.tamanho--;

	}

	// remove o elemento que esta no fim da lista
	public void removeDoFim() {
		NoLista ultimo = this.getNoLista(this.tamanho - 1);
		ultimo.setProx(null);
		this.tamanho--;
	}

	// remove o elemento que esta da posicao
	public void remove(int posicao) {
		if (!this.posicaoEstaOcupada(posicao)) {
			throw new IllegalArgumentException("404: Posicao not existe :(");
		}

		if (posicao == 0) { // no inicio
			this.removeDoInicio();
		} else if (posicao == this.tamanho - 1) { // no fim
			this.removeDoFim();
		} else {
			NoLista anterior = this.getNoLista(posicao - 1);
			NoLista atual = anterior.getProx();
			NoLista proxima = atual.getProx();

			anterior.setProx(proxima);
			// proxima.setAnterior(anterior);

			this.tamanho--;
		}

	}

	public String toString() {

		NoLista p = this.lista;
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

	public void show() {

		for (int i = 0; i < (this.tamanho - 1); i++) {
			System.out.println(this.lista.toString());
		}

	}

}
