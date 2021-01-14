package com.todolist.model;

import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "item_list")
@Getter
@Setter
public class ListItem
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item_list")
    private int id;

    @Column(name = "content")
    private String content;

    @Column(name = "done")
    private Boolean done;

    @ManyToOne
    @JoinColumn(name = "id_user",nullable = false)
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_list",nullable = false)
    @JsonIgnore
    private List list;
}
