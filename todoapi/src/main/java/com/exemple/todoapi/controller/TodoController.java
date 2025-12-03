package com.exemple.todoapi.controller;

import com.exemple.todoapi.model.Todo;
import com.exemple.todoapi.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "http://localhost:5173") // Autoriser Vue.js
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    // GET /api/todos - Recuperer tous les todos
    @GetMapping
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    // GET /api/todos/{id} - Recuperer un todo par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        Optional<Todo> todo = todoRepository.findById(id);
        return todo.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/todos - Creer un nouveau todo
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo createTodo(@RequestBody Todo todo) {
        return todoRepository.save(todo);
    }

    // PUT /api/todos/{id} - Mettre a jour un todo
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(
            @PathVariable Long id,
            @RequestBody Todo todoDetails) {

        return todoRepository.findById(id)
                .map(todo -> {
                    todo.setTitre(todoDetails.getTitre());
                    todo.setDescription(todoDetails.getDescription());
                    todo.setFait(todoDetails.isFait());
                    return ResponseEntity.ok(todoRepository.save(todo));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/todos/{id} - Supprimer un todo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        if (todoRepository.existsById(id)) {
            todoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}
