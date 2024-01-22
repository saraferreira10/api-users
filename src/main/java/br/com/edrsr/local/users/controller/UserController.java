package br.com.edrsr.local.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edrsr.local.users.model.UserModel;
import br.com.edrsr.local.users.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(name = "id") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid UserModel userModel) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
        } catch (DataIntegrityViolationException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("department not found");
        }
    }

    @PutMapping
    public ResponseEntity<Object> updateByid(@RequestBody @Valid UserModel updatedUser) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.updateById(updatedUser));
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (DataIntegrityViolationException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("department not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long id) {
        try {
            userService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("user deleted!");
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

}
