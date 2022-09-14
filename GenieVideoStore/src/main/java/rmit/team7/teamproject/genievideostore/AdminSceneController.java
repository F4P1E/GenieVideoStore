package rmit.team7.teamproject.genievideostore;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.util.HashMap;

public class AdminSceneController {
    private HashMap<String, Pane> screenMap = new HashMap<>();
    private Scene main;

    public HashMap<String, Pane> getScreenMap() {
        return screenMap;
    }

    public Scene getMain() {
        return main;
    }

    protected void addScreen(String name, Pane pane){
        screenMap.put(name, pane);
    }

    protected void removeScreen(String name){
        screenMap.remove(name);
    }

    protected void activate(String name){
        main.setRoot( screenMap.get(name) );
    }
}
