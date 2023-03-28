package br.com.onebox.app.exception;

/**
 * Representa fluxo de exceção para Categoria
 *
 * @author LIS
 * @version 0.1
 */
public class CategoriaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CategoriaException(String msg) {
		super(msg);
	}

	public CategoriaException(Long id, String msg) {
		super("id: " + id + ", " + msg);
	}

}
