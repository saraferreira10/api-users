package br.com.edrsr.local.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.edrsr.local.users.model.DepartmentModel;
import br.com.edrsr.local.users.service.DepartmentService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(name = "id") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(departmentService.findById(id));
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid DepartmentModel departmentModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.save(departmentModel));
    }

    @PutMapping
    public ResponseEntity<Object> updateByid(@RequestBody @Valid DepartmentModel updatedDepartment) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(departmentService.updateById(updatedDepartment));
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long id) {
        try {
            departmentService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("department deleted!");
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}