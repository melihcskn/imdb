package com.MovieSiteProject.services.concretes;

import com.MovieSiteProject.dataAccess.ActorRepository;
import com.MovieSiteProject.entities.concretes.Actor;
import com.MovieSiteProject.entities.dtos.ActorDTO;
import com.MovieSiteProject.entities.mapper.Mappers;
import com.MovieSiteProject.services.abstracts.ActorService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class ActorManager implements ActorService {
    private ActorRepository actorRepository;
    Mappers mappers;

    @Autowired
    public ActorManager(ActorRepository actorRepository){
        this.actorRepository = actorRepository;
        mappers = new Mappers();
    }

    @Override
    public ActorDTO getByActorId(int actorId) {
        Actor actor = actorRepository.getByActorId(actorId);
        return mappers.convertActorToDTO(actor);
    }

    @Override
    public List<ActorDTO> getAll() {
        List<Actor> actors = actorRepository.findAll();
        return mappers.convertActorToDTO(actors);
    }

    @Override
    public List<ActorDTO> getByActorNameStartingWith(String actorName) {
        List<Actor> actors = actorRepository.getByActorNameStartingWith(actorName);
        return mappers.convertActorToDTO(actors);
    }

    @Override
    public List<ActorDTO> getActorByNameContains(String actorName) {
        List<Actor> actors = actorRepository.getActorByNameContains(actorName);
        return mappers.convertActorToDTO(actors);
    }
}
