package actions;


import characters.Character;
public class BasicDefenseComponent implements ActionComponent {

    @Override
    public void perform(Character self, Character target) {
        System.out.println(self.getName() + " adopta una postura defensiva.");
        self.setReflecting(true); // Activamos reflejo para este turno
    }

    @Override
    public String getName() {
        return "Defensa";
    }

    @Override
    public String getDescription() {
        return getName();
    }



}
