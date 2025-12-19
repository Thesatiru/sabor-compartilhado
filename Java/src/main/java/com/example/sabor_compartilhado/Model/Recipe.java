package com.example.sabor_compartilhado.Model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

/**
 * Esta classe representa a entidade Recipe (Receita) no nosso sistema.
 * É o M (Model) do MVC e define a estrutura da tabela no banco de dados.
 */
// @Entity: Anotação do JPA que informa ao Hibernate (ORM) que esta classe deve ser mapeada para uma tabela no Banco de Dados.
// O nome da tabela será 'recipe' (por padrão, o nome da classe em minúsculo).
// É necessário que o banco de dados 'sbc_db' já exista no MySQL.
@Entity

// @Data: Anotação do Lombok que gera automaticamente:
// - Getters e Setters para todos os campos.
// - Construtor padrão (sem argumentos).
// - Métodos toString(), equals() e hashCode().
@Data
public class Recipe {
    
    // -------------------------------------------------------------------------------------------------------------
    // ATRIBUTOS BÁSICOS (MAPEADOS DIRETAMENTE PARA COLUNAS DA TABELA)
    // -------------------------------------------------------------------------------------------------------------

    // @Id: Define que este campo é a Chave Primária (Primary Key - PK) da tabela 'recipe'.
    @Id
    // @GeneratedValue: Indica que o valor deste campo será gerado automaticamente.
    // strategy = GenerationType.IDENTITY: Especifica que a geração do valor será delegada ao Banco de Dados,
    // usando o recurso de auto-incremento nativo do MySQL (AUTO_INCREMENT).
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Convenção em Java é usar 'id' minúsculo.

    private String resume;
    private String name;
    private String description;
    private Integer timePreparationMinutes; // Coluna 'time_preparation_minutes' no banco.
    private String urlImage;  // Coluna 'url_image' no banco. Armazena o link da imagem.

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime publicationDate; // Coluna 'publication_date' no banco (tipo DATETIME).

    // -------------------------------------------------------------------------------------------------------------
    // RELACIONAMENTO (CHAVE ESTRANGEIRA - FOREIGN KEY)
    // -------------------------------------------------------------------------------------------------------------

    // @ManyToOne: Define um relacionamento N:1 (Muitas Receitas para Uma Culinária).
    // Exemplo: Várias receitas (Recipe) podem pertencer a uma única culinária (Cuisine).
    @ManyToOne
    
    // @JoinColumn: Especifica a coluna que será usada como Chave Estrangeira (FK) na tabela 'recipe'.
    // name="cuisine_id": Define o nome da coluna FK que será criada na tabela 'recipe' no MySQL.
    // nullable = false: Exige que toda receita TENHA obrigatoriamente uma Culinária associada.
    // O JPA usará o ID da Entidade 'Cuisine' (cuisine.id) como valor para esta coluna FK.
    @JoinColumn(name="cuisine_id", nullable = false)
    private Cuisine cuisine;
}