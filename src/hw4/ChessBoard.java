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

import static hw4.ChessPiece.*;

import java.awt.Point;
import java.util.*;

/**
 * <p>
 * The board is the class that keeps track of pieces on the board, receives moves
 * to make, makes them, and notifies any observers of the move.
 * </p><p>
 * This board implementation uses several shortcuts for the assignment. If
 * there is no piece on a square, then that square is just null. There is
 * no NULL_PIECE.
 * </p>
 * 
 * @author gpollice
 * @version Oct 1, 2011
 */
public class ChessBoard implements Observable
{
	private final ChessPiece[][] board;
	private final Collection<Observer> observers;
	private MoveEvent lastMove = null;
	
	/**
	 * Constructor that initializes the board to the starting chess position.
	 */
	public ChessBoard()
	{
		board = new ChessPiece[][] {
			{ WR, WN, WB, WQ, WK, WB, WN, WR },
			{ WP, WP, WP, WP, WP, WP, WP, WP },
			{ null, null, null, null, null, null, null, null },
			{ null, null, null, null, null, null, null, null },
			{ null, null, null, null, null, null, null, null },
			{ null, null, null, null, null, null, null, null },
			{BP, BP, BP, BP, BP, BP, BP, BP },
			{BR, BN, BB, BQ, BK, BB, BN, BR }
		};
		observers = new HashSet<Observer>();
	}
	
	/**
	 * Return the piece at the specified location. The x-coordinate of
	 * the point is the row and the y-coordinate is the column. If the
	 * coordinates are invalid, an ArrayIndexOutOfBoundsException will be
	 * thrown.
	 * 
	 * @param pt the position of the requested piece
	 * @return the piece at the requested position (may be null)
	 * 
	 */
	public ChessPiece getPieceAt(Point pt)
	{
		return board[pt.x][pt.y];
	}
	
	/**
	 * <p>
	 * Make the move specified. There is no validation of the move
	 * with respect to the rles of chess.
	 * </p><p>
	 * Once the move is made, this method notifies all observers by
	 * sending a MoveEvent object to the observer as the <em>event</em>
	 * parameter.
	 * </p>
	 * 
	 * @param from the position containing the piece to move
	 * @param to the position where the piece moves to
	 * @throws HW4Exception for the following reasons:
	 * <ul>
	 * <li> No piece at the from position </li>
	 * <li> If either coordinate is invalid <li>
	 * </ul>
	 */
	public void move(Point from, Point to) throws HW4Exception
	{
		try {
			board[to.x][to.y] = board[from.x][from.y];
			board[from.x][from.y] = null;
		} catch (Exception e) {
			throw new HW4Exception("Error moving from " + from + " to " + to);
		}
		lastMove = new MoveEvent(board[to.x][to.y], from, to);
		notifyObservers();
	}
	
	/*
	 * @see hw4.Observable#addObserver(hw4.Observer)
	 */
	@Override
	public void addObserver(Observer observer)
	{
		observers.add(observer);
	}

	/*
	 * @see hw4.Observable#removeObserver(hw4.Observer)
	 */
	@Override
	public void removeObserver(Observer observer)
	{
		observers.remove(observer);
	}

	/*
	 * @see hw4.Observable#notifyObservers()
	 */
	@Override
	public void notifyObservers()
	{
		for (Observer o : observers) {
			o.update(this, lastMove);
		}
	}
}
