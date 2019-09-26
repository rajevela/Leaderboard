package com.raas.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LeaderBoard {
	
	
	TreeMap<Integer , HashMap<String , List<Integer>>> highLB = new TreeMap<Integer , HashMap<String , List<Integer>>>(new HigerScoreComparator());
	public static Integer sum(List<Integer> playerScore){
		Integer sum =0;
		for(Integer n:playerScore){
			sum+=n;
		}
			
	      return sum;
	}
	
	public void printLeaderBoard(TreeMap<Integer , HashMap<String , List<Integer>>> highLB){
		int i=0;
		for (Map.Entry<Integer , HashMap<String , List<Integer>>> entry: highLB.entrySet()){
			i++;
			System.out.println(i+"............."+entry.getValue());			
		}
		
	}
	
	public void calculateLeaderBoard(List<Player> lstOfPlayer){
		HashMap<String , List<Integer>> leaderBoard=null;
		for(Player plyr : lstOfPlayer){
				String playerName =plyr.getPlayerName();
				List<Integer> playerScore = plyr.getScoreList();
                Collections.sort(playerScore);
                int maxLoop = playerScore.size()>4 ? 4:playerScore.size();
                List<Integer> higerScore = new ArrayList<Integer>();
             
                for(int i=1;i<=maxLoop;i++){
                	higerScore.add(playerScore.get(playerScore.size()-i));
                }
                //System.out.println(sum(higerScore));
                Integer sumvalue = sum(higerScore);
                if(!highLB.containsKey(sumvalue)){
                 leaderBoard = new HashMap<String, List<Integer>>();
                }
				leaderBoard.put(playerName, higerScore);				
				highLB.put(sumvalue, leaderBoard);
		}
		System.out.println(highLB);
		printLeaderBoard(highLB);
	}

	public static void main(String[] args) {
		
		LeaderBoard lb = new LeaderBoard();
		// TODO Auto-generated method stub
		List<Player> allPlayer = new ArrayList<Player>();
		Player a = new Player("A");
		List<Integer> aScore = new ArrayList<Integer>();
		aScore.add(10);
		aScore.add(90);
		aScore.add(17);
		aScore.add(50);
		aScore.add(16);
		aScore.add(0);
		a.setScoreList(aScore);
		
		Player b = new Player("B");
		List<Integer> bScore = new ArrayList<Integer>();
		bScore.add(10);
		bScore.add(90);
		bScore.add(17);
		bScore.add(50);
		bScore.add(156);
		bScore.add(50);
		bScore.add(16);
		bScore.add(16);
		bScore.add(0);
		b.setScoreList(bScore);
		
		Player c = new Player("C");
		List<Integer> cScore = new ArrayList<Integer>();
		cScore.add(10);
		cScore.add(80);
		cScore.add(17);
		cScore.add(30);
		cScore.add(16);
		cScore.add(20);
		c.setScoreList(cScore);
		
		Player d = new Player("D");
		List<Integer> dScore = new ArrayList<Integer>();
		dScore.add(6);
		dScore.add(90);
		dScore.add(174);
		dScore.add(50);
		dScore.add(16);
		dScore.add(0);
		d.setScoreList(dScore);
		
		Player e = new Player("E");
		List<Integer> eScore = new ArrayList<Integer>();
		eScore.add(6);
		eScore.add(80);
		eScore.add(170);
		eScore.add(60);
		eScore.add(20);
		eScore.add(0);
		e.setScoreList(eScore);
		
		allPlayer.add(a);
		allPlayer.add(b);
		allPlayer.add(c);
		allPlayer.add(d);
		allPlayer.add(e);
		lb.calculateLeaderBoard(allPlayer);

	}

}
