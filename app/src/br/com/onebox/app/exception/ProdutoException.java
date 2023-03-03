package br.com.onebox.app.exception;

public class ProdutoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ProdutoException(String msg) {
		super(msg);
	}
	
	public ProdutoException(Long id, String msg) {
			super("id: " + id + ", " + msg);
	}

}
