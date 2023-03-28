package br.com.onebox.app.domain;

public class GeradorDeId {
    
	private static GeradorDeId gerador = new GeradorDeId();
    private Long id = 1L;

    public static Long nextId(){
        return gerador.id++;
    }
    
}
