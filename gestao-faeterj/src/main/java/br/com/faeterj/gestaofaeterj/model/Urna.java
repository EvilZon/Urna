package br.com.faeterj.gestaofaeterj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Scanner;

@Entity
public class Urna {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Integer quantidadeVotos;
	
	private String voto;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("=======URNA=======");
    System.out.println(" (10) Candidato A");
    System.out.println(" (20) Candidato B");
    System.out.println(" (30) Candidato C");
    System.out.println(" (00) Voto Nulo");
    System.out.println(" (-1) Sair");
    System.out.println("=======URNA=======");

    int voto = sc.nextInt();
    int votosA = 0;
    int votosB = 0;
    int votosC = 0;
    int votosN = 0;
    int vtotal = 0;
    int maior = 0;
    String vencedor="";

    while(voto>=0){
      if(voto==10){
        votosA++;
        System.out.println("O seu voto foi computado para o Candidato A");
      }else if(voto==20){
        votosB++;
        System.out.println("O seu voto foi computado para o Candidato B");
      }else if(voto==30){
        votosC++;
        System.out.println("O seu voto foi computado para o Candidato C");
      }else if(voto==0){
        votosN++;
        System.out.println("Você votou Nulo");
      }else{
        System.out.println("Voto inválido, vote novamente:");
        voto = sc.nextInt();
      }
      if(voto==10 || voto==20 || voto==30 || voto==0){
        vtotal++;
      }
      if(votosA>maior){
          maior = votosA;
          vencedor = "Candidato A";
      }if(votosB>maior){
          maior = votosB;
          vencedor = "Candidato B";
      }if(votosC>maior){
          maior = votosC;
          vencedor = "Candidato C";
      }
      
      System.out.println("Vote novamente ou digite -1 para sair");
      voto = sc.nextInt();
  }
      System.out.println("==============================RESULTADO==============================");
      System.out.println("Total de Votos: "+vtotal);
      double prcCandidatoA = (100*votosA)/vtotal;
      System.out.println("Candidato A obteve "+votosA+" votos equivalente a "+prcCandidatoA+"% dos votos");
      double prcCandidatoB = (100*votosB)/vtotal;
      System.out.println("Candidato B obteve "+votosB+" votos equivalente a "+prcCandidatoB+"% dos votos");
      double prcCandidatoC = (100*votosC)/vtotal;
      System.out.println("Candidato C obteve "+votosC+" votos equivalente a "+prcCandidatoC+"% dos votos");
      double prcNulos = (100*votosN)/vtotal;
      System.out.println("Obtivemos "+votosN+" votos nulos, o equivalente a "+prcNulos+"% dos votos");
      System.out.println("Vencedor: "+vencedor);
      System.out.println("==============================RESULTADO==============================");
  sc.close();
}
}