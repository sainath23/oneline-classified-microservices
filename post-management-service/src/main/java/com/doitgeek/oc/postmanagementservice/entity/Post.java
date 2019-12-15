package com.doitgeek.oc.postmanagementservice.entity;

import com.doitgeek.oc.postmanagementservice.util.StringMapConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "post")
public class Post implements Serializable {
    private static final long serialVersionUID = 4509618308202149471L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_account_id")
    private Long userAccountId;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "post_title")
    private String postTitle;

    @Column(name = "post_detail")
    private String postDetail;

    @Column(name = "is_active")
    private Character isActive;

    @Column(name = "is_seller")
    private Character isSeller;

    @Column(name = "is_individual")
    private Character isIndividual;

    @Column(name = "expected_price")
    private BigDecimal expectedPrice;

    @Column(name = "is_price_negotiable")
    private Character isPriceNegotiable;

    @Column(name = "last_renewed_on")
    private Date lastRenewedOn;

    @Column(name = "location")
    @Convert(converter = StringMapConverter.class)
    private Map<String, String> location;

    @JsonIgnore
    @OneToOne(mappedBy = "post")
    private PostAttribute postAttribute;

    @JsonIgnore
    @OneToMany(mappedBy = "post")
    private Set<PostImage> postImages;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostDetail() {
        return postDetail;
    }

    public void setPostDetail(String postDetail) {
        this.postDetail = postDetail;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    public Character getIsSeller() {
        return isSeller;
    }

    public void setIsSeller(Character isSeller) {
        this.isSeller = isSeller;
    }

    public Character getIsIndividual() {
        return isIndividual;
    }

    public void setIsIndividual(Character isIndividual) {
        this.isIndividual = isIndividual;
    }

    public BigDecimal getExpectedPrice() {
        return expectedPrice;
    }

    public void setExpectedPrice(BigDecimal expectedPrice) {
        this.expectedPrice = expectedPrice;
    }

    public Character getIsPriceNegotiable() {
        return isPriceNegotiable;
    }

    public void setIsPriceNegotiable(Character isPriceNegotiable) {
        this.isPriceNegotiable = isPriceNegotiable;
    }

    public Date getLastRenewedOn() {
        return lastRenewedOn;
    }

    public void setLastRenewedOn(Date lastRenewedOn) {
        this.lastRenewedOn = lastRenewedOn;
    }

    public Map<String, String> getLocation() {
        return location;
    }

    public void setLocation(Map<String, String> location) {
        this.location = location;
    }
}
