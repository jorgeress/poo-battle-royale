package actions;


import characters.Character;

public class PowerfulAttackDecorator implements ActionComponent {
	 private final ActionComponent actionComponent;

	    public PowerfulAttackDecorator(ActionComponent wrapped) {
	    	super();
	        this.actionComponent = wrapped;
	    }

	    
	    public void perform(Character attacker, Character target) {
	     
	    	actionComponent.perform(attacker, target);

	    }


		public String getName() {
			return "potente";
		}


		public String getDescription() {
			return actionComponent.getDescription() + getName();
		}
}