package mirea.mosit.serversfy.service;

import mirea.mosit.serversfy.entity.Observed;
import mirea.mosit.serversfy.repository.ObservedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObservedService {

    @Autowired
    private final ObservedRepository observedRepository;

    public ObservedService(ObservedRepository observedRepository) {
        this.observedRepository = observedRepository;
    }

    public void createObserved(Observed observed){
        observedRepository.save(observed);
    }

    public List<Observed> allObserved(){
        return observedRepository.allObserveds();
    }

    public List<Observed> getDataObserved(String login) {return observedRepository.getDataObserved(login);}
}
