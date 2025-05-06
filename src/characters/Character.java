package characters;

import characterState.*;

public abstract class Character {

	public Integer health;
	public Integer strength;
	public Integer defense;
	public Integer stamina;
	public String name;
	public CharacterState currentState;
	public boolean reflecting = false;
	

	public void setReflecting(boolean value) {
	    this.reflecting = value;
	}

	public boolean isReflecting() {
	    return reflecting;
	}

	public Character(Integer health,Integer strength,Integer defense, String name,Integer stamina) {
	this.health = health;
	this.strength = strength;
	this.name = name;
	this.defense = defense;
	this.stamina = stamina;
	this.currentState = new CharacterHealthyState();
	}
	
	public void takeDamage(int daño) {
		this.health -= daño;
		if(this.health <= 0) {
			this.health = 0;
		}
	    System.out.println(name + " recibe " + daño + " de daño. Vida actual: " + health);
		if(this.health <= 0) {
			this.currentState = new CharacterDeadState();
		}
	}
	
	public Integer getHealth() {
		return health;
	}
	
	public Integer getStrength() {
		return strength;
	}
	public Integer getDefense() {
		return defense;
	}
	public String getName() {
		return name;
	}
	public CharacterState getState() {
		return currentState;
	}
	
	public void setHealth(Integer health) {
		this.health = health;
	}
	public void setStrength(Integer strength) {
		this.strength = strength;
	}
	public void setDefense(Integer defense) {
		this.defense = defense;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setState(CharacterState state) {
		this.currentState = state;
	}
	public void performTurn(Character target) {
	    updateStates();
	    currentState.handle(this, target);
	}
	 public boolean isAlive() {
	        return !(currentState instanceof CharacterDeadState);
	  }
	 
	public abstract void act(Character target);
	public void updateStates() {
	    if (this.health <= 0 && !(currentState instanceof CharacterDeadState)) {
	        this.currentState = new CharacterDeadState();
	    }
	}
	
}