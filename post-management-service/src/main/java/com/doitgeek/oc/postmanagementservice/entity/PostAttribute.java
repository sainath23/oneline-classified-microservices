package com.doitgeek.oc.postmanagementservice.entity;

import com.doitgeek.oc.postmanagementservice.util.StringMapConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Map;

@Entity
@Table(name = "post_attribute")
public class PostAttribute implements Serializable {

    private static final long serialVersionUID = -9128052612946443259L;

    @Id
    @Column(name = "post_id")
    private Long postId;

    @Column(name = "post_attribute")
    @Convert(converter = StringMapConverter.class)
    private Map<String, String> postAttribute;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "post_id", insertable = false, updatable = false)
    @MapsId
    private Post post;

    public PostAttribute() {
    }

    public PostAttribute(Long postId, Map<String, String> postAttribute) {
        this.postId = postId;
        this.postAttribute = postAttribute;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Map<String, String> getPostAttribute() {
        return postAttribute;
    }

    public void setPostAttribute(Map<String, String> postAttribute) {
        this.postAttribute = postAttribute;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
