package modelo;

public class NoLista {

	private int info;
	private NoLista prox;

	public NoLista() {
	}

	public NoLista(int valor) {
		this.setInfo(valor);
		this.setProx(null);
	}

	public int getInfo() {
		return info;
	}

	public void setInfo(int info) {
		this.info = info;
	}

	public NoLista getProx() {
		return prox;
	}

	public void setProx(NoLista prox) {
		this.prox = prox;
	}

	@Override
	public String toString() {
		return "NoLista [info=" + info + ", prox=" + prox + "]";
	}	

}
