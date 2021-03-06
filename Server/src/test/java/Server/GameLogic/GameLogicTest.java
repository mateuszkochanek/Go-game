package Server.GameLogic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Server.Game.GameLogic;

public class GameLogicTest {
    
    @Test
    public void chainBreathTest() {
        GameLogic gameLogic = new GameLogic(19);
        
        assertTrue(gameLogic.move(1, 0, 1));
        assertTrue(gameLogic.move(0, 1, 1));
        assertTrue(gameLogic.move(0, 0, 1));
        
        assertTrue(gameLogic.move(0, 18, 1));
        assertTrue(gameLogic.move(0, 16, 1));
        assertTrue(gameLogic.move(1, 17, 1));
        assertTrue(gameLogic.move(0, 17, 1));
        
        assertTrue(gameLogic.move(5, 5, 1));
        assertTrue(gameLogic.move(4, 4, 1));
        assertTrue(gameLogic.move(3, 5, 1));
        assertTrue(gameLogic.move(4, 6, 1));
        assertTrue(gameLogic.move(4, 5, 1));
    }
    
    @Test
    public void captureTest() {
        int[][] points;
        GameLogic gameLogic = new GameLogic(19);
        
        //capture one stone
        assertTrue(gameLogic.move(0, 0, 2));
        assertTrue(gameLogic.move(1, 0, 1));
        assertTrue(gameLogic.move(0, 1, 1));
        assertEquals(gameLogic.checkPlayer(0, 0), 2);
        points = gameLogic.removeDeathStones(1, 0);
        assertEquals(points.length, 1);
        assertEquals(gameLogic.checkPlayer(0, 0), 0);
        assertEquals(gameLogic.checkPlayer(1, 0), 1);
        assertEquals(gameLogic.checkPlayer(0, 1), 1);
        
        
        
        //capture two stones
        assertTrue(gameLogic.move(1, 17, 2));
        assertTrue(gameLogic.move(2, 17, 2));
        
        assertTrue(gameLogic.move(1, 18, 1));
        assertTrue(gameLogic.move(2, 18, 1));
        assertTrue(gameLogic.move(3, 17, 1));
        assertTrue(gameLogic.move(2, 16, 1));
        assertTrue(gameLogic.move(1, 16, 1));
        assertTrue(gameLogic.move(0, 17, 1));
        
        assertEquals(gameLogic.checkPlayer(1, 17), 2);
        assertEquals(gameLogic.checkPlayer(2, 17), 2);
        points = gameLogic.removeDeathStones(1, 18);
        assertEquals(points.length, 2);
        assertEquals(gameLogic.checkPlayer(1, 17), 0);
        assertEquals(gameLogic.checkPlayer(2, 17), 0);
        
        //capture four stones
        assertTrue(gameLogic.move(2, 2, 2));
        assertTrue(gameLogic.move(2, 3, 2));
        assertTrue(gameLogic.move(1, 3, 2));
        assertTrue(gameLogic.move(1, 4, 2));
        
        assertTrue(gameLogic.move(2, 1, 1));
        assertTrue(gameLogic.move(1, 2, 1));
        assertTrue(gameLogic.move(0, 3, 1));
        assertTrue(gameLogic.move(0, 4, 1));
        assertTrue(gameLogic.move(1, 5, 1));
        assertTrue(gameLogic.move(2, 4, 1));
        assertTrue(gameLogic.move(3, 3, 1));
        assertTrue(gameLogic.move(3, 2, 1));
        
        points = gameLogic.removeDeathStones(2, 1);
        assertEquals(points.length, 4);
        assertEquals(gameLogic.checkPlayer(2, 2), 0);
        assertEquals(gameLogic.checkPlayer(2, 3), 0);
        assertEquals(gameLogic.checkPlayer(1, 3), 0);
        assertEquals(gameLogic.checkPlayer(1, 4), 0);
        assertEquals(gameLogic.checkPlayer(2, 1), 1);
    }
    
    @Test
    public void noBreatheTest() {
        GameLogic gameLogic = new GameLogic(19);
        
        //one stone
        assertTrue(gameLogic.move(1, 0, 1));
        assertTrue(gameLogic.move(0, 1, 1));
        assertFalse(gameLogic.move(0, 0, 2));
        
        //three stones
        assertTrue(gameLogic.move(1, 18, 1));
        assertTrue(gameLogic.move(2, 18, 1));
        assertTrue(gameLogic.move(3, 17, 1));
        assertTrue(gameLogic.move(3, 16, 1));
        assertTrue(gameLogic.move(2, 15, 1));
        assertTrue(gameLogic.move(1, 16, 1));
        assertTrue(gameLogic.move(0, 17, 1));
        
        assertTrue(gameLogic.move(1, 17, 2));
        assertTrue(gameLogic.move(2, 16, 2));
        assertFalse(gameLogic.move(2, 17, 2));
    }
    
    @Test
    public void koTest() {
        int [][] points;
        GameLogic gameLogic = new GameLogic(19);
        
        //put stone there after one turn, ko is still on board
        assertTrue(gameLogic.move(1, 0, 1));
        assertTrue(gameLogic.move(0, 1, 1));
        assertTrue(gameLogic.move(1, 2, 1));
        assertTrue(gameLogic.move(2, 1, 1));
        assertTrue(gameLogic.move(0, 2, 2));
        assertTrue(gameLogic.move(1, 3, 2));
        assertTrue(gameLogic.move(2, 2, 2));
        
        assertTrue(gameLogic.move(1, 1, 2));
        points = gameLogic.removeDeathStones(1, 1);
        assertEquals(points.length, 1);
        assertEquals(gameLogic.checkPlayer(1, 2), 0);
        assertFalse(gameLogic.move(1, 2, 1));
        assertTrue(gameLogic.move(18, 2, 1));
        points = gameLogic.removeDeathStones(18, 2);
        assertEquals(points.length, 0);
        assertTrue(gameLogic.move(1, 2, 1));
        assertFalse(gameLogic.move(1, 1, 2));
        
        //put stone there after one turn, end ko
        assertTrue(gameLogic.move(10, 10, 1));
        assertTrue(gameLogic.move(10, 11, 1));
        assertTrue(gameLogic.move(11, 12, 1));
        assertTrue(gameLogic.move(12, 11, 1));
        assertTrue(gameLogic.move(10, 12, 2));
        assertTrue(gameLogic.move(11, 13, 2));
        assertTrue(gameLogic.move(12, 12, 2));
        
        assertTrue(gameLogic.move(11, 11, 2));
        points = gameLogic.removeDeathStones(11, 11);
        assertEquals(points.length, 1);
        assertEquals(gameLogic.checkPlayer(11, 12), 0);
        assertFalse(gameLogic.move(11, 12, 1));
        assertTrue(gameLogic.move(17, 17, 1));
        points = gameLogic.removeDeathStones(17, 17);
        assertEquals(points.length, 0);
        assertTrue(gameLogic.move(11, 12, 2));
    }  
}
