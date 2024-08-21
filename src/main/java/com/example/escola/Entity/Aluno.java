package com.example.escola.Entity;

import com.example.escola.Entity.Enum.NivelEnsino;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Table(name= "ALUNO")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Aluno {

    private UUID id;
    private String nome;
    private String cpf;
    private String matricula;
    private Integer idade;
    private String periodo;
    private NivelEnsino nivelEnsino; //maternal, pré escola, fundamental, medio


}
