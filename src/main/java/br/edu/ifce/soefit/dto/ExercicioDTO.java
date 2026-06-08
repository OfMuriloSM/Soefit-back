package br.edu.ifce.soefit.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ExercicioDTO {

    @NotBlank(message = "O nome do exercício é obrigatório")
    private String nome;

    @NotNull(message = "Defina a quantidade de séries")
    @Min(value = 1, message = "Deve ter pelo menos 1 série")
    private Integer series;

    @NotNull(message = "Defina as repetições")
    @Min(value = 1, message = "Deve ter pelo menos 1 repetição")
    private Integer repeticoes;

    private Double cargaKg;

    @NotNull(message = "O ID da ficha de treino é obrigatório")
    private Long fichaId;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Integer getSeries() { return series; }
    public void setSeries(Integer series) { this.series = series; }

    public Integer getRepeticoes() { return repeticoes; }
    public void setRepeticoes(Integer repeticoes) { this.repeticoes = repeticoes; }

    public Double getCargaKg() { return cargaKg; }
    public void setCargaKg(Double cargaKg) { this.cargaKg = cargaKg; }

    public Long getFichaId() { return fichaId; }
    public void setFichaId(Long fichaId) { this.fichaId = fichaId; }
}