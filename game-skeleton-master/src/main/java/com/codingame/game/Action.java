package com.codingame.game;
import com.codingame.game.Constants.*;
public class Action {
    String string;
    ACTIONTYPE type;
    Player player;
    ITEMTYPE itemtype;
    int destination;
    public Action(String output,ACTIONTYPE type,Player player)//CRAFT or MOVE
    {
        this.type=type;
        this.player=player;
        this.string=output;

        if (type==ACTIONTYPE.CRAFT)
        {
            if (output=="PICKAXE")
            {
                itemtype=ITEMTYPE.PICKAXE;
            }
            else if (output=="HATCHET")
            {
                itemtype=ITEMTYPE.HATCHET;
            }
        }
        else if (type==ACTIONTYPE.MOVE)
        {
            destination=Integer.parseInt(output);
        }
    }

    public Action(ACTIONTYPE type,Player player)//HARVEST
    {
        this.type=type;
        this.player=player;
        this.string=null;
    }
}
