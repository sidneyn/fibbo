package com.fibbo.selecaofibbo.domain.enums;

public enum Perfil {
	
	ADMIN(0, "ROLE_ADMIN"), CLIENTE(1, "ROLE_CLIENTE");

	private Integer codigo;
	private String descricao;
	
	private Perfil(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static Perfil toEnum(Integer codigo)	{
		
		if (codigo == null) {
			return null;
		}
		
		for (Perfil x: Perfil.values()) {
			if (codigo.equals(x.getCodigo())) {
				return x;
			}			
		}
		throw new IllegalArgumentException("Perfil Inválido");
		
		
		
	}
	

}
