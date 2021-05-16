package mirea.mosit.serversfy.service;

import mirea.mosit.serversfy.entity.Rele;
import mirea.mosit.serversfy.repository.ReleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReleService {

    @Autowired
    private final ReleRepository releRepository;

    public ReleService(ReleRepository releRepository) {
        this.releRepository = releRepository;
    }

    public void createRele(Rele rele){
        releRepository.save(rele);
    }

    public List<Rele> allRele(){
        return releRepository.allRele();
    }
}
