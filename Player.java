package com.raas.collection;

import java.util.List;

public class Player {
	
	private String playerName;
	private List<Integer> scoreList;
	
	Player(String playerName){
		this.playerName=playerName;
	}
	
	
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public List<Integer> getScoreList() {
		return scoreList;
	}
	public void setScoreList(List<Integer> scoreList) {
		this.scoreList = scoreList;
	}
	

}
