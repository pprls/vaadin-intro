package main.service.repository;

import main.model.Actor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface ActorRepository  extends CrudRepository<Actor, UUID> {

    Actor findById(UUID id);

    Actor findByUsername(String name);

}
