package br.edu.ifce.soefit.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class FichaTreinoDTO {

    @NotBlank(message = "O nome do treino é obrigatório (ex: Treino A)")
    private String nomeTreino;

    @NotNull(message = "O ID do usuário é obrigatório")
    private Long usuarioId;

    public String getNomeTreino() { return nomeTreino; }
    public void setNomeTreino(String nomeTreino) { this.nomeTreino = nomeTreino; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
}