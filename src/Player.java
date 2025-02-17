
public class Player {

	private int playerNumber;
	private String playerColor;
	private String playerType;
	
	public Player (int number, String color, String type) {
		playerNumber = number;
		playerColor = color;
		playerType = type;
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
	
}
