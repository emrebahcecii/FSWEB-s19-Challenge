package com.example.FSWEB_s19_challenge.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "like", schema = "fsweb")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "mood")
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 100)
    private String mood;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "tweet_id")
    private Tweet tweet;

    @Override
    public boolean equals(Object obj){
        if(obj == this)
            return true;

        if(obj == null || obj.getClass() != getClass())
            return false;

        Like like = (Like) obj;

        return Objects.equals(like.getId(), id);
    }
    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
