package com.todolist.rest;

import com.todolist.dao.ListItemdao;
import com.todolist.dao.Listdao;
import com.todolist.dao.Userdao;
import com.todolist.model.List;
import com.todolist.model.ListItem;
import com.todolist.model.User;
import javassist.NotFoundException;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class ListItemRest
{
    @Autowired
    private Userdao userdao;
    @Autowired
    private Listdao listDao;
    @Autowired
    private ListItemdao listItemdao;

    @PostMapping("/newitem/{folderID}")
    @JsonIgnore
    public ListItem addItem(@PathVariable("folderID") Integer folderId,@RequestBody ListItem listItem)
    {
        Optional<User> user= this.userdao.findById(1);
        System.out.println(user.toString());
        Optional<List> list= this.listDao.findById(folderId);
        listItem.setList(list.get());
        listItem.setDone(false);
        listItem.setUser(user.get());
        return this.listItemdao.save(listItem);
    }

    @PutMapping("/edititem/{itemID}")
    @JsonIgnore
    public ListItem editItemName(@PathVariable("itemID") Integer itemId, @RequestBody ListItem listItem) throws NotFoundException
    {
        return this.listItemdao.findById(itemId).map(listM ->
        {
            listM.setContent(listItem.getContent());
            return this.listItemdao.save(listM);
        }).orElseThrow(() -> new NotFoundException("Item list not found with id "+itemId));
    }

    @PutMapping("/doneitem/{itemID}")
    @JsonIgnore
    public ListItem doneItem(@PathVariable("itemID") Integer itemId) throws NotFoundException {

        return this.listItemdao.findById(itemId).map(listM ->
        {
            System.out.println(listM.getDone());
            listM.setDone(!listM.getDone());
            System.out.println(listM.getDone());
            return this.listItemdao.save(listM);
        }).orElseThrow(() -> new NotFoundException("Item list not found with id "+itemId));
    }
}
