package com.example.Yummie.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
public class Roles {
private int Id;
private String name;


}
