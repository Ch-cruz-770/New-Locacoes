package br.com.Locacoes.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "Cliente")
 public class Cliente {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @Column(nullable = false)
    private String nome;

   @Column(nullable = false)
    private String email;

   @Column(nullable = false)
   private String telefone;

   @Column(nullable = false)
   private String cpf;

   @Column(nullable = false, updatable = false)
   private LocalDateTime dataCriacao;

   @PrePersist
    public void prePersist(){
       this.dataCriacao= LocalDateTime.now();
   }
}
