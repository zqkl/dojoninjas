package jacob.dojoninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import jacob.dojoninjas.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {
    List<Ninja> findAll();
}
