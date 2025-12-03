package com.bibliotheque.livresapi.controller;

import com.bibliotheque.livresapi.model.Livre;
import com.bibliotheque.livresapi.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livres")
public class LivreController {

    @Autowired
    private LivreRepository livreRepository;

    // GET /api/livres - Recuperer tous les livres
    @GetMapping
    public List<Livre> getAllLivres() {
        return livreRepository.findAll();
    }

    // GET /api/livres/{id} - Recuperer un livre par ID
    @GetMapping("/{id}")
    public ResponseEntity<Livre> getLivreById(@PathVariable Long id) {
        return livreRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/livres - Creer un nouveau livre
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Livre createLivre(@RequestBody Livre livre) {
        return livreRepository.save(livre);
    }

    // PUT /api/livres/{id} - Modifier un livre existant
    @PutMapping("/{id}")
    public ResponseEntity<Livre> updateLivre(
            @PathVariable Long id,
            @RequestBody Livre livreDetails) {

        return livreRepository.findById(id)
                .map(livre -> {
                    livre.setTitre(livreDetails.getTitre());
                    livre.setAuteur(livreDetails.getAuteur());
                    livre.setIsbn(livreDetails.getIsbn());
                    livre.setAnneePublication(livreDetails.getAnneePublication());
                    livre.setDisponible(livreDetails.isDisponible());
                    return ResponseEntity.ok(livreRepository.save(livre));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/livres/{id} - Supprimer un livre
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivre(@PathVariable Long id) {
        if (livreRepository.existsById(id)) {
            livreRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
