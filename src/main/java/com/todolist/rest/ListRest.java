package com.todolist.rest;

import com.todolist.dao.Listdao;
import com.todolist.dao.Userdao;
import com.todolist.model.List;
import com.todolist.model.User;
import javassist.NotFoundException;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class ListRest
{
    @Autowired
    private Listdao listDao;
    @Autowired
    private Userdao userdao;

    @PostMapping("/savelist/{userID}")
    public void /*ResponseEntity<List>*/ save(@PathVariable("userID") Integer userId, @RequestBody List list)
    {
        Optional<User> newUser=this.userdao.findById(userId);
        //List newList=new List();
        //newList.setName(name);
        //newList.setUser(newUser.get());
        list.setUser(newUser.get());
        //this.listDao.save(newList);
        this.listDao.save(list);
    }

    @DeleteMapping("deleteall/{folderID}")
    public void deleteEverything(@PathVariable("folderID") Integer folderId)
    {
        this.listDao.delete(this.listDao.findById(folderId).get());
    }
}
