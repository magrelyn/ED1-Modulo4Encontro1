package modelo;

public class Produto {

	private int codigo;
	private String nomeProd;
	private double preco;
	private int qtdeEstoque;

	public Produto() {
	}

	public Produto(int codigo, String nomeProd, double preco, int qtdeEstoque) {
		this.setCodigo(codigo);
		this.setNomeProd(nomeProd);
		this.setPreco(preco);
		this.setQtdeEstoque(qtdeEstoque);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNomeProd() {
		return nomeProd;
	}

	public void setNomeProd(String nomeProd) {
		this.nomeProd = nomeProd;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQtdeEstoque() {
		return qtdeEstoque;
	}

	public void setQtdeEstoque(int qtdeEstoque) {
		this.qtdeEstoque = qtdeEstoque;
	}

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", nomeProd=" + nomeProd + ", preco=" + preco + ", qtdeEstoque="
				+ qtdeEstoque + "]";
	}

}
