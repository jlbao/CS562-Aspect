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

import java.awt.Point;

/**
 * The MoveEvent encapsulates information about a move on a chess board. When
 * a move is made, an instance of this class is sent to observers. This is a
 * simple data object.
 * 
 * @author gpollice
 * @version Oct 1, 2011
 */
public class MoveEvent
{
	private final ChessPiece piece;
	private final Point from;
	private final Point to;
	
	/**
	 * Constructor initializes the fields.
	 * 
	 * @param piece the piece tha made the move
	 * @param from the square it moved from
	 * @param to the square it moved to
	 */
	public MoveEvent(ChessPiece piece, Point from, Point to)
	{
		this.piece = piece;
		this.from = from;
		this.to = to;
	}

	/**
	 * @return the piece
	 */
	protected ChessPiece getPiece()
	{
		return piece;
	}

	/**
	 * @return the from
	 */
	protected Point getFrom()
	{
		return from;
	}

	/**
	 * @return the to
	 */
	protected Point getTo()
	{
		return to;
	}
	
	@Override
	public String toString()
	{
		return "Moving " + piece + " from [" + from + "] to [" + to + "]";
	}
}
