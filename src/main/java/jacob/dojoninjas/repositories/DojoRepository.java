package jacob.dojoninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import jacob.dojoninjas.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long> {
    List<Dojo> findAll();
}
