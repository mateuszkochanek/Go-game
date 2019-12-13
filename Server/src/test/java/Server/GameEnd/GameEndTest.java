package Server.GameEnd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Server.Game.GameEnd;
import Server.Game.GameLogic;

public class GameEndTest {

    @Test
    public void countPointshTest() {
        int[][] board = new int[19][19];
        
        GameLogic gameLogic  = new GameLogic(board);
        GameEnd gameEnd = new GameEnd(board);
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

        assertEquals(gameEnd.countPoints(1), 5);
        assertEquals(gameEnd.countPoints(2), 6);
    }
}
