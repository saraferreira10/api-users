package br.com.edrsr.local.users.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edrsr.local.users.model.DepartmentModel;
import br.com.edrsr.local.users.repository.DepartmentRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<DepartmentModel> findAll() {
        return departmentRepository.findAll();

    }

    public DepartmentModel findById(Long id) {
        return departmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("department not found"));
    }

    public DepartmentModel save(@Valid DepartmentModel departmentModel) {
        return departmentRepository.save(departmentModel);
    }

    public DepartmentModel updateById(@Valid DepartmentModel updatedDepartment) {
        if (!departmentRepository.existsById(updatedDepartment.getId())) {
            throw new EntityNotFoundException("department not found");
        }

        DepartmentModel departmentModel = departmentRepository.findById(updatedDepartment.getId()).get();
        BeanUtils.copyProperties(updatedDepartment, departmentModel);

        return departmentRepository.save(departmentModel);
    }

    public void deleteById(Long id) {
        if (!departmentRepository.existsById(id)) {
            throw new EntityNotFoundException("department not found");
        }

        departmentRepository.deleteById(id);
    }
}