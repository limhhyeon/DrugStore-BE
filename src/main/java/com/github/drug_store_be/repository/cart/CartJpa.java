package com.github.drug_store_be.repository.cart;

import com.github.drug_store_be.repository.option.Options;
import com.github.drug_store_be.repository.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartJpa extends JpaRepository<Cart,Integer> {
    List<Cart> findAllByUser(User user);

    List<Cart> findByUserAndOptions(User user, Options options);

    @Query("SELECT c FROM Cart c WHERE c.user.userId = :userId")
    List<Cart> findAllByUser_UserId(int userId);

    @Query("SELECT c FROM Cart c WHERE c.cartId = ?1 AND c.user.userId = ?2")
    Optional<Cart> findByIdAndUserId(Integer cartId, Integer userId);

}
