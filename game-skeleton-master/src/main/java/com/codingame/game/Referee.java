package com.codingame.game;
import java.util.ArrayList;
import java.util.List;

import com.codingame.gameengine.core.AbstractPlayer.TimeoutException;
import com.codingame.gameengine.core.AbstractReferee;
import com.codingame.gameengine.core.MultiplayerGameManager;
import com.codingame.gameengine.module.entities.GraphicEntityModule;
import com.codingame.gameengine.module.entities.Sprite;
import com.google.inject.Inject;
import com.sun.org.apache.bcel.internal.generic.RETURN;

public class Referee extends AbstractReferee {
    @Inject private MultiplayerGameManager<Player> gameManager;
    @Inject private GraphicEntityModule graphicEntityModule;
    ArrayList<Player> playerList;

    
    private Sprite playerSprites[];
    private Sprite resourceSprites[];
    private Sprite planetSprites[];
    

    private int xOffPlayer = 35;
    private int yOffPlayer = 30;
    private int xOffPlanet = 64;
    private int yOffPlanet = 64;

    @Override
    public void init() {
    	playerList = new ArrayList<Player>();
        playerList = initPlayers();
        for (Player player : playerList) {
        	System.out.println(player.pl.getPlayerX());
        }
        playerSprites = new Sprite[4];
        resourceSprites = new Sprite[5];
        planetSprites = new Sprite[5];
        
        draw();
         
        
        
    }
    
    public void draw() {
    	

    	graphicEntityModule.createSprite()
        .setImage(Constants.backgroundSpritePng)
        .setAnchor(0)
        .setBaseWidth(1920)
        .setBaseHeight(1080);
    	

    	int x[] = {1000, 1000, 1500, 500, 500};
    	int y[] = {200, 800, 500, 500, 800};
    	for (int i = 0; i<5 ; i++) {
    		planetSprites[i] = graphicEntityModule.createSprite()
    				.setImage(Constants.planetSpritesPng[i])
    				.setX(x[i])
    				.setY(y[i]);
    		resourceSprites[i] = graphicEntityModule.createSprite()
    				.setImage(Constants.resourceSpritesPng[i])
    				.setX(x[i]+xOffPlayer)
    				.setY(y[i]+yOffPlayer);
    		i+=1;
    	}
    	
    	int i = 0;
    	for (Player player : playerList) {
    		playerSprites[i] = graphicEntityModule.createSprite()
    				.setImage(Constants.playerSpritesPng[i])
    				.setX(player.pl.getPlayerX()+xOffPlayer)
    				.setY(player.pl.getPlayerY()+yOffPlayer);
    		i+=1;
    	}
    	
    }


    @Override
    public void gameTurn(int turn) {
        for (Player player : gameManager.getActivePlayers()) {
            player.sendInputLine(String.valueOf(player.pl.wood));
            player.sendInputLine(String.valueOf(player.pl.stone));
            player.sendInputLine(String.valueOf(player.pl.cherries));
            player.sendInputLine(String.valueOf(player.pl.copper));
            player.execute();
        }

        for (Player player : gameManager.getActivePlayers()) {
            try {
                List<String> outputs = player.getOutputs();
                // Check validity of the player output and compute the new game state
                String output=checkOutput(outputs,player,0);

                if (output!=null)
                {
                    Action action;
                    action=createAction(output,player);
                    executeAction(action);
                }
            } catch (TimeoutException e) {
                player.deactivate(String.format("$%d timeout!", player.getIndex()));
            }
        }        
    }
    public ArrayList<Player> initPlayers()
    {
        ArrayList<Player> pList=new ArrayList<Player>();
        Player player1=new Player();
        player1.pl=new PlayerClass(100,400);
        Player player2=new Player();
        player2.pl=new PlayerClass(400,400);
        Player player3=new Player();
        player3.pl=new PlayerClass(100,100);
        Player player4=new Player();
        player4.pl=new PlayerClass(400,100);
        pList.add(player1);
        pList.add(player2);
        pList.add(player3);
        pList.add(player4);
        return pList;
    }

    public String checkOutput(List<String> outputs,Player player, int phase)
    {
        if (outputs.size()!=1)
        {
            player.deactivate("You passed wrong lines of output");
        }
        else
        {
            String output=outputs.get(0);
            if (phase==0)
            {
                if (output.matches("CRAFT (PICKAXE|HATCHET)"))
                {
                    return output;
                }
                if (output.matches("MOVE [0-4]"))
                {
                    return output;
                }
                if (output.matches("HARVEST"))
                {
                    return output;
                }
            }
            if (phase==1)
            {
                //TODO
            }
        }
        player.deactivate("You gave wrong output");
        return null;
    }

    public Action createAction(String output, Player player) {
        Action action;
        String[] type = output.split(" ");
        if (type.length > 1) {
            if (type[0] == "CRAFT") {
                action = new Action(type[1], Constants.ACTIONTYPE.CRAFT, player);
            } else if (type[0] == "MOVE") {
                action = new Action(type[1], Constants.ACTIONTYPE.MOVE, player);
            } else {
                action = new Action(Constants.ACTIONTYPE.HARVEST, player);
            }
            return action;
        }
        else
        {
            action=new Action(Constants.ACTIONTYPE.HARVEST,player);
        }
        return action;
    }
    public void executeAction(Action action)
    {
        if (action.type== Constants.ACTIONTYPE.CRAFT)
        {
            if (action.itemtype== Constants.ITEMTYPE.PICKAXE)
            {
                action.player.pl.addItem(new Pickaxe());
            }
            else if (action.itemtype== Constants.ITEMTYPE.HATCHET)
            {
                //action.player.pl.addItem(new Hatchet());
            }
        }
        else if (action.type== Constants.ACTIONTYPE.MOVE)
        {
            if (action.destination==0)//Craft
            {
                action.player.pl.access=0;
            }
            else if (action.destination==1)
            {
                action.player.pl.access=1;
            }
            else if (action.destination==2)
            {
                action.player.pl.access=2;
            }
            else if (action.destination==3)
            {
                action.player.pl.access=3;
            }
            else if (action.destination==4)
            {
                action.player.pl.access=4;
            }
        }
        else if (action.type== Constants.ACTIONTYPE.HARVEST)
        {
            if (action.player.pl.access==0)
            {
                action.player.deactivate("wrong output");
            }

            switch (action.player.pl.access)
            {
                case 1: {
                    action.player.pl.wood += action.player.pl.woodHarvest;
                    break;
                }
                case 2:
                {
                    action.player.pl.stone+=action.player.pl.stoneHarvest;
                    break;
                }
                case 3:
                {
                    action.player.pl.copper+=action.player.pl.copperHarvest;
                    break;
                }
                case 4:
                {
                    action.player.pl.cherries+=action.player.pl.cherriesHarvest;
                    break;
                }
            }
        }
    }
}
