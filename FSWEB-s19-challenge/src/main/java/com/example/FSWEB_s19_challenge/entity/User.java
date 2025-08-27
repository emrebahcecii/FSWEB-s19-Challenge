package com.example.FSWEB_s19_challenge.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users", schema = "fsweb")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_name")
    @NotEmpty
    @NotBlank
    @NotNull
    @Size(max = 100)
    private String userName;

    @NotNull
    @Size(max = 100)
    @Column(name = "email")
    @Email
    private String email;

    @NotNull
    @Size(max = 100)
    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Tweet> tweets = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Like> likes = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Retweet> retweets = new ArrayList<>();

    //tweet ekleme
    public void addTweet(Tweet tweet){
        if(tweet.getUser().equals(this) && !tweets.contains(tweet))
            tweets.add(tweet);
    }
    public void removeTweet(Tweet tweet){
        tweets.remove(tweet);
    }

    public List<Tweet> getTweets(){
        return Collections.unmodifiableList(this.tweets);
    }

    //yorum ekleme
    public void addComment(Comment comment){
        if(comment.getUser().equals(this) && !comments.contains(comment)){
            comments.add(comment);
        }
    }
    public void removeComment(Comment comment){
        comments.remove(comment);
    }

    public List<Comment> getComments(){
        return Collections.unmodifiableList(this.comments);
    }

    //like ekleme
    public void addLike(Like like){
        if(like.getUser().equals(this) && !likes.contains(like)){
            likes.add(like);
        }
    }
    public void removeLike(Like like){
        likes.remove(like);
    }

    public List<Like> getLike(){
        return Collections.unmodifiableList(this.likes);
    }

    //retweet ekleme
    public void addRetweet(Retweet retweet){
        if(retweet.getUser().equals(this) && !retweets.contains(retweet)){
            retweets.add(retweet);
        }
    }
    public void removeRetweet(Retweet retweet){
        retweets.remove(retweet);
    }

    public List<Retweet> getRetweet(){
        return Collections.unmodifiableList(this.retweets);
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (obj == null || obj.getClass() != getClass())
            return false;

        User user = (User) obj;

        return Objects.equals(user.getId(), id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
