package com.example.Yummie.entity;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Document(collection = "users")
public class User implements UserDetails {

    @Id
    private ObjectId id;

    @Field(name = "first_name")
    private String firstName;

    @Field(name = "last_name")
    private String lastName;

    @Field(name = "username")
    private String username;

    @Field(name = "password")
    private String password;

    @Field(name = "role")
    private Role role;

    @Field(name = "favourite")
    private ArrayList<ObjectId> favourite;

    @Field(name = "Cart")
    private ArrayList<ObjectId> Cart;

    @Field(name = "History")
    private ArrayList<ObjectId> History;



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }




    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ArrayList<ObjectId> getFavourite() {
        return favourite;
    }

    public void setFavourite(ArrayList<ObjectId> favourite) {
        this.favourite = favourite;
    }

    public ArrayList<ObjectId> getCart() {
        return Cart;
    }

    public void setCart(ArrayList<ObjectId> cart) {
        Cart = cart;
    }

    public ArrayList<ObjectId> getHistory() {
        return History;
    }

    public void setHistory(ArrayList<ObjectId> history) {
        History = history;
    }
}