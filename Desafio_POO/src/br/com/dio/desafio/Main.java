package br.com.dio.desafio;

import java.time.LocalDate;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

public class Main {
	public static void main(String[] args) {
		
		Curso curso1 = new Curso();
		curso1.setTitulo("Curso de Java");
		curso1.setDescricao("Descrição curso de Java");
		curso1.setCargaHoraria(8);
		
		Curso curso2 = new Curso();
		curso2.setTitulo("Curso de JS");
		curso2.setDescricao("Descrção curso JS");
		curso2.setCargaHoraria(4);
		
		Mentoria mentoria = new Mentoria();
		mentoria.setTitulo("mentoria do Java");
		mentoria.setDescricao("Descrição mentoria Java");
		mentoria.setData(LocalDate.now());
		
		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome("Bootcamp Java Developer");
		bootcamp.setDescricao("Descrição Bootcamp Java Developer");
		bootcamp.getConteudos().add(curso1);
		bootcamp.getConteudos().add(curso2);
		bootcamp.getConteudos().add(mentoria);
		
		Dev devCamila = new Dev();
		devCamila.setNome("Camila");
		devCamila.inscreverBootcamp(bootcamp);
		System.out.println("Conteúdos inscritos Camila: " + devCamila.getConteudosInscritos());
		devCamila.proredir();
		System.out.println("Conteúdos inscritos Camila: " + devCamila.getConteudosInscritos());
		System.out.println("Conteúdos Concluídos Camila " + devCamila.getConteudosConcluodos());
		System.out.println("XP: " + devCamila.calcularTotalXp());
		
		Dev devJoao = new Dev();
		devJoao.setNome("Joao");
		devJoao.inscreverBootcamp(bootcamp);
		System.out.println("Conteúdos inscritos João: " + devJoao.getConteudosInscritos());
		devJoao.proredir();
		System.out.println("Conteúdos inscritos João: " + devJoao.getConteudosInscritos());
		System.out.println("Conteúdos Concluídos João: " + devJoao.getConteudosConcluodos());
		System.out.println("XP: " + devJoao.calcularTotalXp());
	}
}
