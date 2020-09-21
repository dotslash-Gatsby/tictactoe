import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.junit.*;
import org.junit.Test;

public class TicTacToeTest {

    @Test
    public void testPrintBoard() {
        TicTacToe ttt = new TicTacToe(System.in);
        char[][] testBoard = { { '-', '-', '-' }, { '-', '-', '-' }, { '-', '-', '-' } };

        assertArrayEquals(testBoard, ttt.newPrintBoard());
    }

    @Test
    public void testPlacePiece() throws UnsupportedEncodingException {

        String input = "1 1\n 2 1";
        InputStream targetStream = new ByteArrayInputStream(input.getBytes());
        TicTacToe ttt = new TicTacToe(targetStream);
        ttt.newPrintBoard();
        

        char[][] testBoard = {
            {'-','-','-'},
            {'-','X','-'},
            {'-','-','-'}          
        };

        var board = ttt.placePiece(0);

        assertArrayEquals(testBoard,board);

    }

    @Test
    public void testWinDiagnol(){
        
     
        char[][] testBoard = {
            {'X','-','-'},
            {'-','X','-'},
            {'-','-','X'}
        };
        TicTacToe ttt = new TicTacToe(System.in, testBoard);

        
        assertEquals(true,ttt.checkWin('X'));
    }


    @Test
    public void testWinDiagnolTwo(){
        
     
        char[][] testBoard = {
            {'-','-','X'},
            {'-','X','-'},
            {'X','-','-'}
        };
        TicTacToe ttt = new TicTacToe(System.in, testBoard);

        
        assertEquals(true,ttt.checkWin('X'));
    }

    @Test
    public void testWinColumnOne(){
        
     
        char[][] testBoard = {
            {'X','-','-'},
            {'X','-','-'},
            {'X','-','-'}
        };
        TicTacToe ttt = new TicTacToe(System.in, testBoard);

        
        assertEquals(true,ttt.checkWin('X'));
    }

    @Test
    public void testWinColumnTwo(){
        
     
        char[][] testBoard = {
            {'-','X','-'},
            {'-','X','-'},
            {'-','X','-'}
        };
        TicTacToe ttt = new TicTacToe(System.in, testBoard);

        
        assertEquals(true,ttt.checkWin('X'));
    }

    @Test
    public void testWinColumnThree(){
        
     
        char[][] testBoard = {
            {'-','-','X'},
            {'-','-','X'},
            {'-','-','X'}
        };
        TicTacToe ttt = new TicTacToe(System.in, testBoard);

        
        assertEquals(true,ttt.checkWin('X'));
    }

    @Test
    public void testWinRowOne(){
        
     
        char[][] testBoard = {
            {'X','X','X'},
            {'-','-','-'},
            {'-','-','-'}
        };
        TicTacToe ttt = new TicTacToe(System.in, testBoard);

        
        assertEquals(true,ttt.checkWin('X'));
    }

    @Test
    public void testWinRowTwo(){
        
     
        char[][] testBoard = {
            {'-','-','-'},
            {'X','X','X'},
            {'-','-','-'}
        };
        TicTacToe ttt = new TicTacToe(System.in, testBoard);

        
        assertEquals(true,ttt.checkWin('X'));
    }

    @Test
    public void testWinRowThree(){
        
     
        char[][] testBoard = {
            {'-','-','-'},
            {'-','-','-'},
            {'X','X','X'}
        };
        TicTacToe ttt = new TicTacToe(System.in, testBoard);

        
        assertEquals(true,ttt.checkWin('X'));
    }

    @Test
    public void testTie(){
        
     
        char[][] testBoard = {
            {'O','X','X'},
            {'X','O','O'},
            {'X','O','X'}
        };
        TicTacToe ttt = new TicTacToe(System.in, testBoard);

        
        assertEquals(true,ttt.checkTie());
    }
}