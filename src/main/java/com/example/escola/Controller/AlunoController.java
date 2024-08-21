package com.example.escola.Controller;

import com.example.escola.Dto.CadastrarAlunoDto;
import com.example.escola.Entity.Aluno;
import com.example.escola.Service.AlunoService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}


