package com.MovieSiteProject.dataAccess;

import com.MovieSiteProject.entities.concretes.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor,Integer> {

    Actor getByActorId(int actorId);
    List<Actor> getByActorNameStartingWith(String actorName);
    @Query(value ="SELECT a FROM Actor a WHERE CONCAT(a.actorName,' ',a.actorSurname) LIKE %:searchParam%")
    List<Actor> getActorByNameContains(@Param("searchParam") String actorName);
}
