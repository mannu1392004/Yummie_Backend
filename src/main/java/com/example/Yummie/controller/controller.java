package com.example.Yummie.controller;

import com.example.Yummie.entity.User;
import com.example.Yummie.entity.goodsDetails;
import com.example.Yummie.services.UserService;
import com.example.Yummie.services.appService;
import com.example.Yummie.util.JwtUtil;
import io.jsonwebtoken.JwtException;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("yummier")
public class controller {

    @Autowired
    private appService service;

    private UserService userService;

    private JwtUtil jwtUtil;

    public controller(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    private static final Logger logger = LoggerFactory.getLogger(controller.class);


    // adding items
    @PostMapping("/{token}/Add")
    public ResponseEntity<?> add(@RequestBody goodsDetails item, @PathVariable String token) {
        try {
            String username = jwtUtil.extractUsername(token);
            boolean verify = jwtUtil.validateToken(token, username);
            if (verify) {
                service.AddGoods(item);
                return ResponseEntity.ok("Added");
            } else {
                return ResponseEntity.ok("Something Went Wrong");
            }
        } catch (JwtException e) {
            logger.warn("JWT exception: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Token");
        } catch (Exception e) {
            logger.error("Unexpected error", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }
    }


    // getting all goods
    @GetMapping("/{token}/Goods")
    public ResponseEntity<?> getall(@PathVariable String token) {

        try {


            String username = jwtUtil.extractUsername(token);
            boolean verify = jwtUtil.validateToken(token, username);

            if (verify) {
                return ResponseEntity.ok(service.getAlllist());
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something Went Wrong");
            }
        } catch (JwtException e) {
            logger.warn("JWT exception: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Token");
        } catch (Exception e) {
            logger.error("Unexpected error", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");

        }
    }


    // post  Liked Goods
    @PostMapping("/{token}/AddTOLIKES")
    public ResponseEntity<?> addLiked(@PathVariable String token, @RequestBody ObjectId id) {
        try {
            String username = jwtUtil.extractUsername(token);
            boolean valid = jwtUtil.validateToken(token, username);
            if (valid) {
                User user = userService.FindByID(id).get();
                user.getFavourite().add(id);
                return ResponseEntity.ok("Goods Added");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something Went wrong");
            }
        } catch (JwtException e) {
            logger.warn("JWT exception: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Token");
        } catch (Exception e) {
            logger.error("Unexpected error", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");

        }

    }

    //post history
    @PostMapping("/{token}/AddHISTORY")
    public ResponseEntity<?> addHistory(@PathVariable String token, @RequestBody ObjectId id) {
        try {
            String username = jwtUtil.extractUsername(token);
            boolean valid = jwtUtil.validateToken(token, username);
            if (valid) {
                User user = userService.FindByID(id).get();
                user.getHistory().add(id);
                return ResponseEntity.ok("Goods Added");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something Went wrong");
            }
        } catch (JwtException e) {
            logger.warn("JWT exception: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Token");
        } catch (Exception e) {
            logger.error("Unexpected error", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");

        }

    }

    // Add Review
    @PostMapping("/{token}/Add Review")
    public ResponseEntity<?> AddReview(@PathVariable String token, @RequestBody String Review) {
        try {
            String userName = jwtUtil.extractUsername(token);
            boolean isValid = jwtUtil.validateToken(token, userName);
            if (isValid) {


                return ResponseEntity.ok("Added Successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went Wrong");
            }

        } catch (JwtException e) {
            logger.warn("JWT exception: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Token");
        } catch (Exception e) {
            logger.error("Unexpected error", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");

        }


    }


}
