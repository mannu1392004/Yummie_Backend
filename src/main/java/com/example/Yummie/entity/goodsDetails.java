package com.example.Yummie.entity;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "goodsDetails")
public class goodsDetails {
    private String name;
    private String type;
    private String price;
    private String shoapName;
    private String preprationTime;
    private String imageLink;
    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public goodsDetails setId(Long id) {
        this.id = id;
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getShoapName() {
        return shoapName;
    }

    public void setShoapName(String shoapName) {
        this.shoapName = shoapName;
    }

    public String getPreprationTime() {
        return preprationTime;
    }

    public void setPreprationTime(String preprationTime) {
        this.preprationTime = preprationTime;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}
