package com.example.escola.Dto;

import com.example.escola.Entity.Enum.NivelEnsino;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CadastrarAlunoDto {

    private String nome;
    private String cpf;
    private String matricula;
    private Integer idade;
    private String periodo;
    private NivelEnsino nivelEnsino;

}
