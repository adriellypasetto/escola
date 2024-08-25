package com.example.escola.Repository;

import com.example.escola.Entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, UUID> {
    Optional<Aluno> findByCpf(String cpf);

    Aluno findByMatricula(String matricula);
}

