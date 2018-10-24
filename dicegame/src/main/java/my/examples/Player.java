package my.examples;

public class Player {
    private String name;
    private Dice dice;

    public Player() {
        System.out.println("플레이어생성자호출");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Player.setName()");
        this.name = name;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        System.out.println("Player.setDice()");
        this.dice = dice;
    }

    public void play() {
        System.out.println(name+"은주사위를던져"+dice.getNumber()+"가나왔습니다.");
    }
}
