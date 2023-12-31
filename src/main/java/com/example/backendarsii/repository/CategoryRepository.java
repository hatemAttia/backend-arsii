package com.example.backendarsii.repository;

import com.example.backendarsii.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    boolean existsByName(String Name);

}
