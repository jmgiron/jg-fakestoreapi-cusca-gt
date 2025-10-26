
package com.jg.fakestoreapi.controller;

import com.jg.fakestoreapi.entity.Client;
import com.jg.fakestoreapi.repository.ClientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientRepository repo;

    public ClientController(ClientRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Client> list() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> get(@PathVariable Long id) {
        Optional<Client> c = repo.findById(id);
        return c.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Client> create(@Validated @RequestBody Client client) {
        Client saved = repo.save(client);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @Validated @RequestBody Client client) {
        return repo.findById(id).map(existing -> {
            existing.setName(client.getName());
            existing.setEmail(client.getEmail());
            existing.setAddress(client.getAddress());
            repo.save(existing);
            return ResponseEntity.ok(existing);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
