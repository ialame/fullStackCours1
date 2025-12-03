package com.exemple.todoapi.repository;

import com.exemple.todoapi.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    // Spring Data JPA genere automatiquement l'implementation
    // de nombreuses methodes : findAll(), findById(), save(), delete()...

    // Methodes personnalisees (optionnel)
    List<Todo> findByFait(boolean fait);
    List<Todo> findByTitreContaining(String titre);
}
