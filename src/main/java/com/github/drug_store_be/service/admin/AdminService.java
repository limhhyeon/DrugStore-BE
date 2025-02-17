package com.github.drug_store_be.service.admin;

import com.github.drug_store_be.repository.category.Category;
import com.github.drug_store_be.repository.category.CategoryRepository;
import com.github.drug_store_be.repository.option.Options;
import com.github.drug_store_be.repository.option.OptionsRepository;
import com.github.drug_store_be.repository.product.Product;
import com.github.drug_store_be.repository.product.ProductRepository;
import com.github.drug_store_be.repository.productPhoto.ProductPhoto;
import com.github.drug_store_be.repository.productPhoto.ProductPhotoRepository;
import com.github.drug_store_be.repository.user.User;

import com.github.drug_store_be.repository.user.UserRepository;
import com.github.drug_store_be.repository.userDetails.CustomUserDetails;
import com.github.drug_store_be.service.exceptions.NotAuthorizedException;
import com.github.drug_store_be.service.exceptions.NotFoundException;
import com.github.drug_store_be.web.DTO.ResponseDto;
import com.github.drug_store_be.web.DTO.order.ProductRegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class AdminService {
    private final UserRepository userRepository;
    private final CategoryRepository CategoryRepository;
    private final ProductRepository productRepository;
    private final ProductPhotoRepository productPhotoRepository;
    private final OptionsRepository optionsRepository;
    @Caching(evict = {
            @CacheEvict(value = "productReview",allEntries = true),
            @CacheEvict(value = "productDetails",allEntries = true)
    })
    public ResponseDto registerProduct(CustomUserDetails customUserDetails, ProductRegisterDto productRegisterDto) {
        User user= userRepository.findById(customUserDetails.getUserId())
                .orElseThrow(()-> new NotFoundException("Cannot find user with ID:  "+ customUserDetails.getUserId()));
        List<String> role= user.getUserRole().stream().map(ur-> ur.getRole().getRoleName()).collect(Collectors.toList());
        if(role.stream().findFirst().get().equals("ROLE_ADMIN")){
            Category category= CategoryRepository.findById(productRegisterDto.getCategoryId())
                    .orElseThrow(()-> new NotFoundException("Cannot find category with ID:  "+ productRegisterDto.getCategoryId()));

            Integer caculatedFinalPrice= productRegisterDto.getPrice() * (100-productRegisterDto.getProductDiscount()) / 100;

            Integer totalStock= productRegisterDto.getOptionsList().stream().map(options -> options.getStock()).mapToInt(Integer::intValue).sum();

            Product product= Product.builder()
                    .category(category)
                    .productName(productRegisterDto.getProductName())
                    .brand(productRegisterDto.getBrand())
                    .price(productRegisterDto.getPrice())
                    .productDiscount(productRegisterDto.getProductDiscount())
                    .finalPrice(caculatedFinalPrice)
                    .best(productRegisterDto.getBest())
                    .productStatus(productRegisterDto.getProductStatus())
                    .createAt(LocalDate.now())
                    .originalStock(totalStock)
                    .productSales(0.0)
                    .reviewAvg(0.0)
                    .build();
            productRepository.save(product);

            List<ProductPhoto> productPhotoList= productRegisterDto.getProductPhotoList()
                    .stream()
                    .map((pp) -> ProductPhoto.builder()
                            .product(product)
                            .photoUrl(pp.getPhotoUrl())
                            .photoType(pp.isPhotoType())
                            .build())
                    .collect(Collectors.toList());
            productPhotoRepository.saveAll(productPhotoList);

            List<Options> optionsList= productRegisterDto.getOptionsList()
                    .stream()
                    .map((o) -> Options.builder()
                            .product(product)
                            .optionsName(o.getOptionsName())
                            .optionsPrice(o.getOptionsPrice())
                            .stock(o.getStock())
                            .build())
                    .toList();
            optionsRepository.saveAll(optionsList);

            //option추가할 때 상품 originalStock(0)바꾸기 기억하기!


            return new ResponseDto(HttpStatus.OK.value(), "상품 등록 성공");

        }else{
            throw new NotAuthorizedException("상품 등록 권한이 없습니다.");
        }
    }




}
