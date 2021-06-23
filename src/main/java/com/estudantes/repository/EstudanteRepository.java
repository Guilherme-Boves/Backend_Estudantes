package com.estudantes.repository;

import com.estudantes.entities.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
        
}
