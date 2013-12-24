package br.com.fiap.web.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="geral_controller")
@SessionScoped
public class GeralController {
	
	public String home(){
		return "index.xhtml?faces-redirect=true";
	}
	
}
