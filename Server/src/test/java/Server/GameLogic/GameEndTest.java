package Server.GameLogic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Server.Game.GameLogic;

public class GameEndTest {

    @Test
    public void countPointsTest() {
        GameLogic gameLogic  = new GameLogic(19);
        
        assertTrue(gameLogic.move(0, 2, 1));
        assertTrue(gameLogic.move(1, 1, 1));
        assertTrue(gameLogic.move(2, 1, 1));
        assertTrue(gameLogic.move(3, 0, 1));
        
        assertTrue(gameLogic.move(17, 0, 1));
        assertTrue(gameLogic.move(18, 1, 1));
        
        assertTrue(gameLogic.move(1, 18, 2));
        assertTrue(gameLogic.move(1, 17, 2));
        assertTrue(gameLogic.move(2, 16, 2));
        assertTrue(gameLogic.move(3, 16, 2));
        assertTrue(gameLogic.move(4, 16, 2));
        assertTrue(gameLogic.move(5, 17, 2));
        assertTrue(gameLogic.move(5, 18, 2));

        assertEquals(gameLogic.countPoints(1), 5);
        assertEquals(gameLogic.countPoints(2), 6);
    }
    
    @Test
    public void removeDeathGroupsTest() {
        GameLogic gameLogic  = new GameLogic(19);
        
        assertTrue(gameLogic.move(0, 0, 1));
        assertTrue(gameLogic.move(2, 0, 2));
        assertTrue(gameLogic.move(2, 1, 2));
        assertTrue(gameLogic.move(2, 2, 2));
        assertTrue(gameLogic.move(1, 2, 2));
        assertTrue(gameLogic.move(0, 2, 2));
        assertTrue(gameLogic.move(10, 10, 1));
        assertTrue(gameLogic.move(12, 10, 1));
        
        gameLogic.removeDeathStonesEndGame();
        assertEquals(gameLogic.checkPlayer(0, 0), 0);
        
       
        gameLogic  = new GameLogic(19);
        assertTrue(gameLogic.move(1, 0, 1));
        assertTrue(gameLogic.move(1, 1, 1));
        assertTrue(gameLogic.move(0, 1, 1));
        assertTrue(gameLogic.move(1, 2, 1));
        assertTrue(gameLogic.move(1, 3, 1));
        assertTrue(gameLogic.move(0, 3, 1));
        
        assertTrue(gameLogic.move(10, 3, 2));
        
        gameLogic.removeDeathStonesEndGame();
        assertEquals(gameLogic.checkPlayer(1, 3), 1);
        assertEquals(gameLogic.checkPlayer(10, 3), 0);
    }
}
