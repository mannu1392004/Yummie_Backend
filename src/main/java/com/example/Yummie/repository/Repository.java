package com.example.Yummie.repository;

import com.example.Yummie.entity.User;
import com.example.Yummie.entity.goodsDetails;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface Repository extends MongoRepository<
        goodsDetails, Long
        > {
}
