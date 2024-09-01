package com.example.escola.Controller;

import com.example.escola.Dto.CadastrarAlunoDto;
import com.example.escola.Entity.Aluno;
import com.example.escola.Service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoService alunoService;

    @Autowired
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Aluno> cadastroAluno(@RequestBody CadastrarAlunoDto cadastrarAlunoDto) {

            Aluno alunoCadastrado = alunoService.cadastrarAluno(cadastrarAlunoDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(alunoCadastrado);
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<Aluno> buscarAlunoMatricula(@PathVariable String matricula) {
        Aluno aluno = alunoService.buscarAlunoPorMatricula(matricula).get();
        return ResponseEntity.ok(aluno);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Aluno> buscarAlunoId(@PathVariable UUID id){
        Aluno aluno = alunoService.buscarAlunoPorId(id).get();
        return ResponseEntity.ok(aluno);
    }
}


