public class Club {
    private int id;
    private String name;
    private Player[] players;
    
    // add your code here
    private int playerCount;    

	// you are not allowed to write any other constructor
    public Club() {
        this.players = new Player[11];
        playerCount = 0;

    }

	public double getSalary() {
        double total = 0;
        for (int i = 0; i < playerCount; i++) {
            total += players[i].getSalary();
        }
        return total;
    }
	
	// add your code here
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Player getMaxSalaryPlayer()
    {
        double temp=0;        
        //Player target_player;
        int index=0;
        for (int i = 0; i < playerCount; i++) {
            if(players[i].getSalary() >= temp)
            {
                index=i;
                temp = players[i].getSalary();
            }
        }
        return players[index];
        
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    void addPlayer(Player new_Player)
    {
        players[playerCount] = new_Player;
        playerCount++;
    }
    
   

}