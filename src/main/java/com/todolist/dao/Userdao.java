package com.todolist.dao;

import com.todolist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface Userdao extends JpaRepository<User, Integer>
{
}
