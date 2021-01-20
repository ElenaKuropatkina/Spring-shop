package com.elenakuropatkina.controllers.represent;

import com.elenakuropatkina.controllers.represents.PictureRepresent;
import com.elenakuropatkina.models.Brand;
import com.elenakuropatkina.models.Category;
import com.elenakuropatkina.models.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProductRepresent implements Serializable {

    private Long id;

    private String title;

    private BigDecimal price;

    private Category category;

    private Brand brand;

    private List<PictureRepresent> pictures;

    private MultipartFile[] newPictures;

    public ProductRepresent() {
    }

    public ProductRepresent(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.category = product.getCategory();
        this.brand = product.getBrand();
        this.pictures = product.getPictures().stream()
                .map(PictureRepresent::new)
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<PictureRepresent> getPictures() {
        return pictures;
    }

    public void setPictures(List<PictureRepresent> pictures) {
        this.pictures = pictures;
    }

    public MultipartFile[] getNewPictures() {
        return newPictures;
    }

    public void setNewPictures(MultipartFile[] newPictures) {
        this.newPictures = newPictures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRepresent that = (ProductRepresent) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

//public class ProductRepresent implements Serializable {
//
//    private Long id;
//
//    private String title;
//
//    private BigDecimal price;
//
//    private Category category;
//
//    private Brand brand;
//
//    private List<PictureRepresent> pictures;
//
//    private MultipartFile[] newPictures;
//
//
//    public ProductRepresent() {
//    }
//
//    public ProductRepresent(Product product) {
//        this.id = product.getId();
//        this.title = product.getTitle();
//        this.price = product.getPrice();
//        this.category = product.getCategory();
//        this.brand = product.getBrand();
//        this.pictures = product.getPictures().stream()
//                .map(PictureRepresent::new)
//                .collect(Collectors.toList());
//
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public BigDecimal getPrice() {
//        return price;
//    }
//
//    public void setPrice(BigDecimal price) {
//        this.price = price;
//    }
//
//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }
//
//    public Brand getBrand() {
//        return brand;
//    }
//
//    public void setBrand(Brand brand) {
//        this.brand = brand;
//    }
//
//    public List<PictureRepresent> getPictures() {
//        return pictures;
//    }
//
//    public void setPictures(List<PictureRepresent> pictures) {
//        this.pictures = pictures;
//    }
//
//    public MultipartFile[] getNewPictures() {
//        return newPictures;
//    }
//
//    public void setNewPictures(MultipartFile[] newPictures) {
//        this.newPictures = newPictures;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ProductRepresent that = (ProductRepresent) o;
//        return Objects.equals(id, that.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
//}
