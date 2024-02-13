package grader.student;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.actor.Actor;
import logic.actor.GhostDoctor;
import logic.actor.Villager;
import logic.game.GameController;
import logic.game.GameIO;
import logic.ghost.GaGhost;
import logic.ghost.Ghost;
import logic.ghost.PooYaGhost;
import logic.ghost.PryGhost;
import logic.item.Item;
import logic.item.Leklai;
import utils.GameUtils;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameControllerTest {
    @Test
    void testPlayNotDestroyedGhost() {
        Actor actor = new Villager();
        
        Ghost g1 = new PooYaGhost(8);
        Ghost g2 = new GaGhost();
        Ghost g3 = new PryGhost();
        
        GameController.getInstance().getGhosts().clear();
        GameController.getInstance().getItems().clear();
        GameController.getInstance().addNewGhost(g1);
        GameController.getInstance().addNewGhost(g2);
        GameController.getInstance().addNewGhost(g3);
        
        GameController.getInstance().play(actor);
        
        assertEquals(g1, GameController.getInstance().getGhosts().get(0));
        assertEquals(3, GameController.getInstance().getGhosts().size());
    }
    
    @Test
    void testPlayDestroyedGhost() {
    	Actor actor = new GhostDoctor();
        
        Ghost g1 = new GaGhost();
        Ghost g2 = GameUtils.getRandomGhost(true);
        Ghost g3 = GameUtils.getRandomGhost(true);

        GameController.getInstance().getGhosts().clear();
        GameController.getInstance().addNewGhost(g1);
        GameController.getInstance().addNewGhost(g2);
        GameController.getInstance().addNewGhost(g3);
        actor.attack();
        assertTrue(GameController.getInstance().getGhosts().get(0).isDestroyed());
        GameController.getInstance().play(actor);
        assertEquals(3,GameController.getInstance().getGhosts().size());
    }
    
    @Test
    void testPlayWithItem() {
    	Actor actor = new Villager();
        Item item = new Leklai(); // level = 5
        
        GaGhost gaGhost = new GaGhost(); //low level = 1
        PryGhost pryGhost = new PryGhost(); //low level = 1
        PooYaGhost pooYaGhost = new PooYaGhost(5); //high level = 10

        GameController.getInstance().getGhosts().clear();
        GameController.getInstance().getItems().clear();
        GameController.getInstance().addNewItem(item);
        GameController.getInstance().addNewGhost(gaGhost );
        GameController.getInstance().addNewGhost(pryGhost);
        GameController.getInstance().addNewGhost(pooYaGhost);

        GameController.getInstance().play(actor);
        assertEquals(0,gaGhost.getHp());
        assertEquals(0,pryGhost.getHp());
        assertEquals(10,pooYaGhost.getHp());
    }
    @Test
    void testIsGameOver() {
        GameController.getInstance().getActors().clear();
        assertTrue(GameController.getInstance().isGameOver());

        GameController.getInstance().setHp(0);
        assertTrue(GameController.getInstance().isGameOver());

        GameController.getInstance().setHp(-2);
        assertTrue(GameController.getInstance().isGameOver());

        GameController.getInstance().getActors().add(new GhostDoctor());
        assertTrue(GameController.getInstance().isGameOver());

        GameController.getInstance().setHp(10);
        assertFalse(GameController.getInstance().isGameOver());
    }


}