package com.MovieSiteProject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "actor")
@Getter
@Setter
public class Actor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private Integer actorId;

    @Column(name = "name")
    private String actorName;

    @Column(name = "surname")
    private String actorSurname;

    @Column(name = "birthday")
    private Date actorBirthDay;

    @Column(name = "bio",
            columnDefinition = "TEXT")
    private String actorBio;

    @Column(name = "poster")
    private String actorPoster;

    @ManyToMany(mappedBy = "actors")
    @JsonIgnore
    private List<Movie> movies = new ArrayList<>();

    public Actor() {
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o==null || !(o instanceof Actor))
            return false;
        Actor actor = (Actor)o;

        if(actorId == actor.getActorId()) return true;
        if(actorId == null) return false;

        return actorId.equals(actor.getActorId());
    }

    @Override
    public int hashCode() {
        if(actorId != null){
            return actorId.hashCode();
        } else{
            return super.hashCode();
        }
    }


}
