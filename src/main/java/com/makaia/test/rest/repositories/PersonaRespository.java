package com.makaia.test.rest.repositories;

import com.makaia.test.rest.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRespository extends JpaRepository<Persona, Long> {
}
