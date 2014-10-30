/*******************************************************************************
 * This file is used in CS4233, Object-oriented Analysis and Design
 *
 * Copyright (c) 2011 Worcester Polytechnic Institute.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Author:
 *    gpollice
 *******************************************************************************/
package hw4;

import static org.junit.Assert.*;
import java.awt.Point;
import org.junit.*;

/**
 * Master tests for HW4.
 * 
 * @author gpollice
 * @version Oct 8, 2011
 */
public class HW4MasterTest
{
	private ChessBoard board = null;
	private TestObserver observer = null;
	private BoardObserver boardObserver = null;
	private final Point P11 = new Point(1, 2);
	private final Point P21 = new Point(2, 1);
	
	@Before
	public void setup()
	{
		board = new ChessBoard();
		observer = new TestObserver();
		boardObserver = new BoardObserver(board);
	}
	
	@Test
	public void testChessBoardAsObservable() throws HW4Exception
	{
		observer.observe(board);
		board.move(P11, P21);
		assertEquals(board, observer.getLastSubject());
		MoveEvent e = (MoveEvent)(observer.getLastEvent());
		assertEquals(ChessPiece.WP, e.getPiece());
		assertEquals(P11, e.getFrom());
		assertEquals(P21, e.getTo());
	}

	@Test 
	public void testChessBoardWithTwoObservers() throws HW4Exception
	{
		TestObserver o2 = new TestObserver();
		observer.observe(board);
		o2.observe(board);
		board.move(P11, P21);
		MoveEvent e = (MoveEvent)(observer.getLastEvent());
		MoveEvent e1 = (MoveEvent)(o2.getLastEvent());
		assertEquals(e, e1);
	}
	
	@Test
	public void testChessBoardRemovingObservers() throws HW4Exception
	{
		TestObserver o2 = new TestObserver();
		observer.observe(board);
		o2.observe(board);
		board.move(P11, P21);
		board.removeObserver(observer);
		board.move(P21, P11);
		MoveEvent e = (MoveEvent)(observer.getLastEvent());
		assertEquals(ChessPiece.WP, e.getPiece());
		assertEquals(P11, e.getFrom());
		assertEquals(P21, e.getTo());
		MoveEvent e1 = (MoveEvent)(o2.getLastEvent());
		assertEquals(ChessPiece.WP, e1.getPiece());
		assertEquals(P21, e1.getFrom());
		assertEquals(P11, e1.getTo());
	}
	
	@Test
	public void testRemoveThenAddObserver() throws HW4Exception
	{
		observer.observe(board);
		for (int i = 0; i < 10; i++) {
			board.move(P11, P21);
			board.removeObserver(observer);
			board.move(P21, P11);
			board.addObserver(observer);
		}
		assertEquals(10, observer.getUpdateCount());
	}
	
	@Test
	public void testAddObserverMultipleTimes() throws HW4Exception
	{
		observer.observe(board);
		observer.observe(board);
		board.addObserver(observer);
		for (int i = 0; i < 10; i++) {
			board.move(P11, P21);
			board.removeObserver(observer);
			board.move(P21, P11);
			board.addObserver(observer);
		}
		assertEquals(10, observer.getUpdateCount());
	}
	
	@Test
	public void testRemoveObserverMoreThanOneTime() throws HW4Exception
	{
		board.addObserver(observer);
		board.move(P11, P21);
		board.removeObserver(observer);
		for (int i = 0; i < 10; i++) {
			board.move(P11, P21);
			board.removeObserver(observer);
			board.move(P21, P11);
		}
		assertEquals(1, observer.getUpdateCount());
	}
	
	@Test
	public void testBoardObserver() throws HW4Exception
	{
		boardObserver.addObserver(observer);
		board.move(P11, P21);
		assertEquals(boardObserver, observer.getLastSubject());
		MoveEvent e = (MoveEvent)(observer.getLastEvent());
		assertEquals(ChessPiece.WP, e.getPiece());
		assertEquals(P11, e.getFrom());
		assertEquals(P21, e.getTo());
	}
	
	@Test
	public void testMultipleBoardObserversObservedByOneTestObserver() throws HW4Exception
	{
		BoardObserver bo1 = new BoardObserver(board);
		bo1.addObserver(observer);
		boardObserver.addObserver(observer);
		board.move(P11, P21);
		assertEquals(2, observer.getUpdateCount());
	}
	
	@Test
	public void testBoardObserverIsSubjectOfUpdate() throws HW4Exception
	{
		boardObserver.addObserver(observer);
		board.move(P11, P21);
		assertEquals(boardObserver, observer.getLastSubject());
	}
	
	@Test
	public void testBoardObserverObservingMultipleBoards() throws HW4Exception
	{
		ChessBoard board1 = new ChessBoard();
		board1.addObserver(boardObserver);
		observer.observe(boardObserver);
		board.move(P11, P21);
		MoveEvent e = (MoveEvent)(observer.getLastEvent());
		assertEquals(ChessPiece.WP, e.getPiece());
		assertEquals(P11, e.getFrom());
		assertEquals(P21, e.getTo());
		assertEquals(boardObserver, observer.getLastSubject());
		board1.move(P11, P21);
		e = (MoveEvent)(observer.getLastEvent());
		assertEquals(ChessPiece.WP, e.getPiece());
		assertEquals(P11, e.getFrom());
		assertEquals(P21, e.getTo());
		assertEquals(boardObserver, observer.getLastSubject());
	}
	
	@Test
	public void testBoardObserverAddingAndRemovingBoardsObserved() throws HW4Exception
	{
		ChessBoard board1 = new ChessBoard();
		board1.addObserver(boardObserver);
		boardObserver.addObserver(observer);
		ChessBoard currentBoard = board;
		for (int i = 0; i < 10; i++) {
			currentBoard.move(P11, P11);
			currentBoard.removeObserver(boardObserver);
			currentBoard.move(P21, P11);
			currentBoard.addObserver(boardObserver);
			currentBoard = currentBoard == board ? board1 : board;
		}
		assertEquals(10, observer.getUpdateCount());
	}
	
	@Test
	public void testBoardObserverObservingItself() throws HW4Exception
	{
		TestBoardObserver tbo = new TestBoardObserver(board);
		tbo.addObserver(tbo);
		board.move(P11, P21);
	}
	
	@Test
	public void testObservingBoardObserverObservingItself() throws HW4Exception
	{
		TestBoardObserver tbo = new TestBoardObserver(board);
		tbo.addObserver(tbo);
		observer.observe(tbo);
		board.move(P11, P21);
		assertEquals(100, observer.getUpdateCount());
	}
}
