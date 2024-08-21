package com.example.escola.Service;

import com.example.escola.Dto.CadastrarAlunoDto;
import com.example.escola.Entity.Aluno;
import com.example.escola.Repository.AlunoRepository;
import com.example.escola.exception.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;

    }

    public Aluno cadastrarAluno(CadastrarAlunoDto cadastrarAlunoDto) throws BadRequestException {

        Optional<Aluno> alunoExistente = alunoRepository.findByCpf(cadastrarAlunoDto.getCpf());

        if (alunoExistente.isPresent()) {
            throw new BadRequestException(String.format("Já existe um aluno cadastrado com esse CPF"));
           } else{
            Aluno novoAluno = new Aluno();
            novoAluno.setNome(cadastrarAlunoDto.getNome());
            novoAluno.setCpf(cadastrarAlunoDto.getCpf());
            novoAluno.setIdade(cadastrarAlunoDto.getIdade());
            novoAluno.setMatricula(cadastrarAlunoDto.getMatricula());
            novoAluno.setNivelEnsino(cadastrarAlunoDto.getNivelEnsino());
            novoAluno.setPeriodo(cadastrarAlunoDto.getPeriodo());

            Aluno alunoCriado = alunoRepository.save(novoAluno);

            return alunoCriado;
        }
    }

}


