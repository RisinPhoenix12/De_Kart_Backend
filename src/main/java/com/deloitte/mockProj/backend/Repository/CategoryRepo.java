package com.deloitte.mockProj.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.mockProj.backend.entity.Categories;

@Repository
public interface CategoryRepo extends JpaRepository<Categories, String> {

}
