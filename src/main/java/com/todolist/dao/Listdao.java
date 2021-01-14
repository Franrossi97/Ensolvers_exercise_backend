package com.todolist.dao;

import com.todolist.model.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface Listdao extends JpaRepository<List, Integer> {
}
