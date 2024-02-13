package logic.game;

import java.util.ArrayList;

import logic.actor.Actor;
import logic.actor.Villager;
import logic.ghost.Ghost;
import logic.item.Item;
import utils.GameUtils;

public class GameController {

	private int hp;
	private int score;
	private static GameController instance;
	private ArrayList <Actor> actors;
	private ArrayList <Ghost> ghosts;
	private ArrayList <Item> items;


	public GameController() {

		this.actors = new ArrayList <Actor> ();
		this.ghosts = new ArrayList <Ghost> ();
		this.items = new ArrayList <Item> ();

		initGame();

	}

	public static GameController getInstance() {
		if(instance == null)
			instance = new GameController();
		return instance;
	}

	public void play(Actor selectedActor) {
		for(Item item:items){
			item.effect();
		}
		Ghost currentGhost = getGhosts().get(0);
		currentGhost.attack();
		selectedActor.attack();
		int cnt = 0;
		for(int i =0;i<getGhosts().size();i++){
			if(getGhosts().get(i).isDestroyed()){
				cnt++;
				setScore(getScore()+getGhosts().get(i).getLevel());
				ghosts.remove(i);
			}
		}
		for(int i =0;i<cnt;i++){
			ghosts.add(GameUtils.getRandomGhost(true));
		}
	}
	public void updateGameController() {
		GameIO.showGameState();
		GameIO.showCurrentGhost(ghosts);
		Actor selectedActor = GameIO.selectActor(this.actors);
		GameIO.showItemList(this.items);
		play(selectedActor);
	}

	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getScore() {
		return score;
	}
	public ArrayList<Ghost> getGhosts() {
		return ghosts;
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	public ArrayList<Actor> getActors() { return actors; }
	public void setScore(int score) {
		this.score = score;
	}
	public void addNewActor(Actor actor) {
		this.actors.add(actor);
	}
	public void addNewItem(Item item) {
		this.items.add(item);
	}
	public void addNewGhost(Ghost ghost) {
		this.ghosts.add(ghost);
	}

	private void initGame(){
		setHp(10);
		setScore(10);
		actors.add(new Villager());
		for(int i = 0;i<10;i++){
			ghosts.add(GameUtils.getRandomGhost(true));
		}
	}
	public boolean isGameOver(){
		return(actors.isEmpty()||getHp()<=0);
	}

}