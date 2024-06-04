package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
	
	private String nome;
	private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
	private Set<Conteudo> conteudosConcluodos = new LinkedHashSet<>();
	

	

	public void inscreverBootcamp(Bootcamp bootcamp) {
		this.conteudosInscritos.addAll(bootcamp.getConteudos());
		bootcamp.getDevsInscritos().add(this);
	}
	
	public void proredir() {
		Optional<Conteudo> conteudo = conteudosInscritos.stream().findFirst();
		if(conteudo.isPresent()) {
			this.conteudosConcluodos.add(conteudo.get());
			this.conteudosInscritos.remove(conteudo.get());
		}else {
			System.err.println("Você não está matriculado e nunhum Bootcamp!");
		}
	}
	
	public double calcularTotalXp() {
		return this.conteudosConcluodos.stream()
				.mapToDouble(Conteudo::calcularXp)
				.sum();				
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Conteudo> getConteudosInscritos() {
		return conteudosInscritos;
	}

	public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
		this.conteudosInscritos = conteudosInscritos;
	}

	public Set<Conteudo> getConteudosConcluodos() {
		return conteudosConcluodos;
	}

	public void setConteudosConcluodos(Set<Conteudo> conteudosConcluodos) {
		this.conteudosConcluodos = conteudosConcluodos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(conteudosConcluodos, conteudosInscritos, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dev other = (Dev) obj;
		return Objects.equals(conteudosConcluodos, other.conteudosConcluodos)
				&& Objects.equals(conteudosInscritos, other.conteudosInscritos) && Objects.equals(nome, other.nome);
	}
	
	
}
