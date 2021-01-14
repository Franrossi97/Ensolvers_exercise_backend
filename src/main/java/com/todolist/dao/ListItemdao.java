package com.todolist.dao;

import com.todolist.model.ListItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("http://localhost:4200")
public interface ListItemdao extends JpaRepository<ListItem,Integer>
{
    Page<ListItem> findByListId(@RequestParam("id") Integer id, Pageable pageable);
}
