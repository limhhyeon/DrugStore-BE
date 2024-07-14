package com.github.drug_store_be.repository.like;

import com.github.drug_store_be.repository.product.Product;
import com.github.drug_store_be.repository.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


import java.util.Optional;

@Repository
public interface LikesRepository extends JpaRepository<Likes,Integer> {
    List<Likes> findByUser(User user);
    void deleteByUserAndProduct(User user, Product product);
    Boolean existsByUserAndProduct(User user,Product product);


}
