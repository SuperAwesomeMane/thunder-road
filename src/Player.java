
public class Player {

	private int playerNumber;
	private String playerColor;
	private String playerType;
	private int health;
	
	public Player (int number, String color, String type, int h) {
		playerNumber = number;
		playerColor = color;
		playerType = type;
		health = h;
	}
	
	//player number
	public int getPlayerNumber() {
		return playerNumber;
	}
	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}
	
	//player color
	public String getPlayerColor() {
		return playerColor;
	}
	public void setPlayerColor(String playerColor) {
		this.playerColor = playerColor;
	}
	
	//player type
	public String getPlayerType() {
		return playerType;
	}
	public void setPlayerType(String playerType) {
		this.playerType = playerType;
	}
	
	//player health - later switch to vehicle type
	int getPlayerHealth() {
		return health;
	}
	public void setPlayerHealth(int h) {
		this.health = h;
	}
	
}
