package com.example.FSWEB_s19_challenge.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tweet", schema = "fsweb")
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(max = 300)
    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tweet")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tweet")
    private List<Like> likes = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tweet")
    private List<Retweet> retweets = new ArrayList<>();

    //comment ekleme
    public void addComment(Comment comment){
        if(comment.getUser().equals(this) && !comments.contains(comment))
            comments.add(comment);
    }

    public void removeComment(Comment comment){
        comments.remove(comment);
    }

    public List<Comment> getComment(){
        return Collections.unmodifiableList(this.comments);
    }

    //like ekleme
    public void addLike(Like like){
        if(like.getUser().equals(this) && !likes.contains(like))
            likes.add(like);
    }
    public void removeLike(Like like){
        likes.remove(like);
    }
    public List<Like> getLike(){
        return Collections.unmodifiableList(this.likes);
    }

    //retweet ekleme
    public void addRetweet(Retweet retweet){
        if(retweet.getUser().equals(this) && !retweets.contains(retweet))
            retweets.add(retweet);
    }
    public void removeRetweet(Retweet retweet){
        retweets.remove(retweet);
    }
    public List<Retweet> getRetweet(){
        return Collections.unmodifiableList(this.retweets);
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this)
            return true;

        if(obj == null || obj.getClass() != getClass())
            return false;

        Tweet tweet = (Tweet) obj;

        return Objects.equals(tweet.getId(), id);
    }
    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
