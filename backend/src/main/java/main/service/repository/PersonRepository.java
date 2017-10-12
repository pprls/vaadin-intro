package main.service.repository;

import main.model.PerformanceBond;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface PersonRepository extends CrudRepository<PerformanceBond, UUID> {

    PerformanceBond findById(UUID id);

    List<PerformanceBond> findByName(String name);

}
