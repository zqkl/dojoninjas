package jacob.dojoninjas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jacob.dojoninjas.models.Ninja;
import jacob.dojoninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
    
    @Autowired NinjaRepository ninjaRepository;

    public void createNinja(Ninja ninja){
        ninjaRepository.save(ninja);
    }



}
