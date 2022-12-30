package com.example.apibootframework.restapidevepoment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Component
@Repository
public interface EmployeeRepository extends JpaRepository<Employees,Integer> {
}
