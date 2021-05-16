package mirea.mosit.serversfy.service;

import mirea.mosit.serversfy.entity.Action;
import mirea.mosit.serversfy.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionService {
    @Autowired
    private final ActionRepository actionRepository;

    public ActionService(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    public void createObserved(Action action){
        actionRepository.save(action);
    }

    public List<Action> allObserved(){
        return actionRepository.allActions();
    }
}
