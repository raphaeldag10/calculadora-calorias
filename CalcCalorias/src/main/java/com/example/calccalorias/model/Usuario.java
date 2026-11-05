package com.example.calccalorias.model;

import jakarta.persistence.*;
import lombok.*;

@Getter // Cria os getters dos atributos
@Setter // Cria os setters dos atributos
@AllArgsConstructor // Cria um construtor com todos os argumentos
@NoArgsConstructor // Cria um construtor vazio
@EqualsAndHashCode // É utilizado para comparar objetos do mesmo tipo
@Entity // Serve para indicar que a classe representa uma tabela em um banco de dados relacional
@Table(name = "tbl_usuarios") // Serve para indicar o nome da tabela no banco de dados


public class Usuario {

    @Id // Está falando que usuarioId é chave primária (pois está acima do atributo usuarioId
    @GeneratedValue( // Está falando qual será a estratégia de sequência
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_USUARIOS"
    )
    @SequenceGenerator(
            name = "SEQ_USUARIOS",
            sequenceName = "SEQ_USUARIOS",
            allocationSize = 1
            )
    @Column(name = "usuario_id")
    private Long usuarioId;

    private String nome;
    private String email;
    private String senha;
}


    /* @NoArgsConstructor substitui a construtor vazio
     public Usuario(){
     }

     @AllArgsConstructor substitui o construtor com todos os argumentos
        public Usuario(Long usuarioId, String nome, String email, String senha) {
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    @Setter e @Getter substitui todos os getters e setters dos atributos

    public Long getUsuarioId(){
        return usuarioId;
    }

    public void Long setUsuarioId(Long usuarioId){
        this.usuarioId = usuarioId;
    }
   public String getNome() {
    return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

     */
