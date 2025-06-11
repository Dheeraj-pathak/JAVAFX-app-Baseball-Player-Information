package Ishaan;

public class Player {
    private int playerID;
    private String firstName;
    private String lastName;
    private double battingAverage;

    public Player(int playerID, String firstName, String lastName, double battingAverage) {
        this.playerID = playerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.battingAverage = battingAverage;
    }

    public int getPlayerID() { return playerID; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public double getBattingAverage() { return battingAverage; }
}
