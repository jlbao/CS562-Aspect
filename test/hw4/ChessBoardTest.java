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

import static hw4.ChessPiece.WR;
import static org.junit.Assert.assertEquals;

import java.awt.Point;

import org.junit.*;

/**
 * Test cases for the ChessBoard.
 * 
 * @author gpollice
 * @version Oct 1, 2011
 */
public class ChessBoardTest
{
	private ChessBoard board;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		board = new ChessBoard();
	}

	@Test
	public void testInitialConfiguration()
	{
		assertEquals(WR, board.getPieceAt(new Point(0, 0)));
	}
	
	@Test(expected=HW4Exception.class)
	public void badCoordinate() throws HW4Exception
	{
		board.move(new Point(4, 5), new Point(4, 8));
	}
}
