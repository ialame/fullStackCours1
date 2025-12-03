package com.bibliotheque.livresapi.repository;

import com.bibliotheque.livresapi.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface LivreRepository extends JpaRepository<Livre, Long> {

    // Trouver tous les livres d'un auteur
    List<Livre> findByAuteur(String auteur);

    // Trouver un livre par son ISBN
    Optional<Livre> findByIsbn(String isbn);

    // Trouver tous les livres disponibles
    List<Livre> findByDisponibleTrue();

    // Trouver les livres dont le titre contient un mot-cle
    List<Livre> findByTitreContainingIgnoreCase(String titre);

    // Trouver les livres d'un auteur qui sont disponibles
    List<Livre> findByAuteurAndDisponibleTrue(String auteur);
}
