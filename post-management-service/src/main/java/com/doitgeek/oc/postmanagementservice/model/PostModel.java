package com.doitgeek.oc.postmanagementservice.model;

import com.doitgeek.oc.postmanagementservice.annotation.Flag;
import com.doitgeek.oc.postmanagementservice.constant.AppConstant;
import com.doitgeek.oc.postmanagementservice.constant.MessageConstant;
import com.doitgeek.oc.postmanagementservice.entity.Post;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public class PostModel {

    @NotNull
    private Long userAccountId;

    @NotNull
    private Long categoryId;

    @NotBlank(message = MessageConstant.POST_TITLE_REQUIRED)
    @Size(max = 50, message = MessageConstant.POST_TITLE_VALID)
    private String postTitle;

    @NotBlank(message = MessageConstant.POST_DETAIL_REQUIRED)
    @Size(max = 2000, message = MessageConstant.POST_DETAIL_VALID)
    private String postDetail;

    @NotNull
    @Flag
    private Character isSeller;

    @NotNull
    @Flag
    private Character isIndividual;

    @NotNull
    private BigDecimal expectedPrice;

    @NotNull
    @Flag
    private Character isPriceNegotiable;

    @NotNull(message = MessageConstant.LOCATION_REQUIRED)
    private Map<String, String> location;

    @NotNull
    private Map<String, String> postAttributes;

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

    public Map<String, String> getLocation() {
        return location;
    }

    public void setLocation(Map<String, String> location) {
        this.location = location;
    }

    public Map<String, String> getPostAttributes() {
        return postAttributes;
    }

    public void setPostAttributes(Map<String, String> postAttributes) {
        this.postAttributes = postAttributes;
    }

    public Post getPost() {
        Post post = new Post();
        post.setUserAccountId(userAccountId);
        post.setCategoryId(categoryId);
        post.setCreateDate(new Date());
        post.setPostTitle(postTitle);
        post.setPostDetail(postDetail);
        post.setIsActive(AppConstant.YES);
        post.setIsSeller(isSeller);
        post.setIsIndividual(isIndividual);
        post.setExpectedPrice(expectedPrice);
        post.setIsPriceNegotiable(isPriceNegotiable);
        post.setLastRenewedOn(new Date());
        post.setLocation(location);
        return post;
    }
}
