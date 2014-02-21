package br.com.fiap.web.utils;

import java.io.IOException;

import javax.faces.context.FacesContext;

public class Redirecionador {
	public void redirecionar(String url) {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect( url );
		} catch (IOException e) {
			System.out.println("Erro ao redirecionar:" + e.getMessage());
			e.printStackTrace();
		}
	}	
}
