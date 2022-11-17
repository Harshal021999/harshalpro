package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Category;

public interface Srepo extends JpaRepository<Category, Integer> {

}
