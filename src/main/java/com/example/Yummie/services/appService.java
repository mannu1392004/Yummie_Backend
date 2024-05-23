package com.example.Yummie.services;

import com.example.Yummie.entity.User;
import com.example.Yummie.entity.goodsDetails;
import com.example.Yummie.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class appService {
    @Autowired
    private Repository repository;




    public void AddGoods(goodsDetails goods) {
        repository.save(goods);
    }

    public List<goodsDetails> getAlllist() {
        return repository.findAll();
    }




}
