package com.example.escola.Service;

import com.example.escola.Dto.CadastrarAlunoDto;
import com.example.escola.Entity.Aluno;
import com.example.escola.Repository.AlunoRepository;
import com.example.escola.exception.BadRequestException;
import com.example.escola.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;

    }

    public Aluno cadastrarAluno(CadastrarAlunoDto cadastrarAlunoDto) throws BadRequestException {

        Optional<Aluno> cpfExistente = alunoRepository.findByCpf(cadastrarAlunoDto.getCpf());
        Optional<Aluno> matriculaExistente = alunoRepository.findByMatricula(cadastrarAlunoDto.getMatricula());

        if (cpfExistente.isPresent()) {
            throw new BadRequestException(String.format("Já existe um aluno cadastrado com esse CPF"));
        }
        if (matriculaExistente.isPresent()) {
            throw new BadRequestException(String.format("Já existe um aluno cadastrado com essa Matricula"));
        }

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

    public Optional<Aluno> buscarAlunoPorMatricula(String matricula) {
        Optional<Aluno> aluno = alunoRepository.findByMatricula(matricula);

        if (aluno.isEmpty()) {
            throw new NotFoundException("Aluno não encontrado");
        }
        return aluno;
    }

    public Optional<Aluno> buscarAlunoPorId(UUID id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);

        if (aluno.isEmpty()) {
            throw new NotFoundException("Aluno não encontrado");
        }
        return aluno;
    }

    public Optional<Aluno> buscarAlunoPorNome(String nomeAluno) {
        return Optional.ofNullable(alunoRepository.findByNome(nomeAluno).orElseThrow(
                () -> new NotFoundException("Não encontrado aluno com esse nome")));
    }


}




