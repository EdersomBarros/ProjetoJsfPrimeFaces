package br.com.project.acessos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public enum Permissao {

	ADMIN("ADMIN", "Administrador"), USER("USER", "Usuário Padrão"),
	CADASTRO_ACESSAR("CADASTRO_ACESSAR", "Cadastro - Acessar"),
	FINANCEIRO_ACESSAR("FINANCEIRO_ACESSAR", "Financeiro - Acessar"),
	MENSAGEM_ACESSAR("MENSAGEM_ACESSAR", "Mensagem Recebida - Acessar"),

	BAIRRO_ACESSAR("BAIRRO_ACESSAR", "Bairro - Acessar"), BAIRRO_NOVO("BAIRRO_NOVO", "Bairro - Novo"),
	BAIRRO_EDITAR("BAIRRO_EDITAR", "Bairro - Editar"), BAIRRO_EXCLUIR("BAIRRO_EXCLUIR", "Bairro - Excluir"),

	BAIXA_ACESSAR("BAIXA_ACESSAR", "Baixa de t�tulo - Acessar"), BAIXA_NOVO("BAIXA_NOVO", "Baixa de t�tulo - Novo"),
	BAIXA_EDITAR("BAIXA_EDITAR", "Baixa de t�tulo - Editar"),
	BAIXA_EXCLUIR("BAIXA_EXCLUIR", "Baixa de t�tulo - Excluir");

	private String valor = "";
	private String descricao = "";

	private Permissao() {

	}

	private Permissao(String name, String descricao) {
		this.valor = name;
		this.descricao = descricao;

	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getValor() {
		return valor;
	}
	
	@Override
	public String toString() {
		
		return getValor();
	}
	
	
	public static List<Permissao> getPermissao(){
		
		List<Permissao> permissoes = new ArrayList<Permissao>();
		
		for (Permissao permissao : Permissao.values()) {
			permissoes.add(permissao);
			
		}
		Collections.sort(permissoes, new Comparator<Permissao>() {

			@Override
			public int compare(Permissao o1, Permissao o2) {
				return new Integer(o1.ordinal()).compareTo(new Integer(o2.ordinal()));
			}
			
		});
		return permissoes;
	}

}
