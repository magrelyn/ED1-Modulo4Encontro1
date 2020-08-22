package modelo;

public class NoProduto {

	private Produto info;
	private NoProduto prox;

	public NoProduto() {
	}

	public NoProduto(Produto valor) {
		this.setInfo(valor);
		this.setProx(null);
	}

	public Produto getInfo() {
		return info;
	}

	public void setInfo(Produto info) {
		this.info = info;
	}

	public NoProduto getProx() {
		return prox;
	}

	public void setProx(NoProduto prox) {
		this.prox = prox;
	}

	@Override
	public String toString() {
		return "NoLista [info=" + info + ", prox=" + prox + "]";
	}

}
