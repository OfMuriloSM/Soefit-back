package br.edu.ifce.soefit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do exercício é obrigatório")
    private String nome;

    @NotNull(message = "Defina a quantidade de séries")
    @Min(value = 1, message = "Deve ter pelo menos 1 série")
    private Integer series;

    @NotNull(message = "Defina as repetições")
    @Min(value = 1, message = "Deve ter pelo menos 1 repetição")
    private Integer repeticoes;

    private Double cargaKg;

    @ManyToOne
    @JoinColumn(name = "ficha_id", nullable = false)
    @JsonIgnore
    private FichaTreino fichaTreino;

    public Exercicio() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Integer getSeries() { return series; }
    public void setSeries(Integer series) { this.series = series; }

    public Integer getRepeticoes() { return repeticoes; }
    public void setRepeticoes(Integer repeticoes) { this.repeticoes = repeticoes; }

    public Double getCargaKg() { return cargaKg; }
    public void setCargaKg(Double cargaKg) { this.cargaKg = cargaKg; }

    public FichaTreino getFichaTreino() { return fichaTreino; }
    public void setFichaTreino(FichaTreino fichaTreino) { this.fichaTreino = fichaTreino; }
}