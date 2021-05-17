package com.codingame.game;
import java.util.ArrayList;
import java.util.List;

import com.codingame.gameengine.core.AbstractPlayer.TimeoutException;
import com.codingame.gameengine.core.AbstractReferee;
import com.codingame.gameengine.core.MultiplayerGameManager;
import com.codingame.gameengine.module.entities.GraphicEntityModule;
import com.google.inject.Inject;

public class Referee extends AbstractReferee {
    @Inject private MultiplayerGameManager<Player> gameManager;
    @Inject private GraphicEntityModule graphicEntityModule;

    @Override
    public void init() {
        ArrayList<Player> playerList= initPlayers();
        for (Player p : gameManager.getActivePlayers())
        {
            p.sendInputLine(String.valueOf(p.player.getAttack()));
        }

    }


    @Override
    public void gameTurn(int turn) {
        for (Player player : gameManager.getActivePlayers()) {
            player.sendInputLine("input");
            player.execute();
        }

        for (Player player : gameManager.getActivePlayers()) {
            try {
                List<String> outputs = player.getOutputs();
                // Check validity of the player output and compute the new game state
                gameManager.endGame();
            } catch (TimeoutException e) {
                player.deactivate(String.format("$%d timeout!", player.getIndex()));
            }
        }        
    }
    public ArrayList<Player> initPlayers()
    {
        ArrayList<Player> pList=new ArrayList<>();
        Player player1=new Player();
        player1.player=new PlayerClass(100,400);
        Player player2=new Player();
        player2.player=new PlayerClass(400,400);
        Player player3=new Player();
        player3.player=new PlayerClass(100,100);
        Player player4=new Player();
        player4.player=new PlayerClass(400,100);
        pList.add(player1);
        pList.add(player2);
        pList.add(player3);
        pList.add(player4);
        return pList;
    }

}
