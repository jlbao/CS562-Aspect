/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package aspects;

import hw4.*;

/**
 * More sample aspects
 * 
 * @version Oct 16, 2014
 */
public aspect TraceAspect2 {
	private int callDepth;
	private final String indent = "  ";

	// Anything in the ChessBoard class
	pointcut traced() : within(hw4.ChessBoard);
	// Anything only method calls within the ChessBoard class
	pointcut traced1() : 
		call(* *(..)) && within(hw4.ChessBoard);
	// Any calls within the ChessBoard.move() method
	pointcut traced2() :
		call(* *(..)) && withincode(* Chessboard.move(..));
	

	before() : traced2() 
	{
		print("Start", thisJoinPoint);
		callDepth++;
	}

	after() : traced()
	{
		callDepth--;
		print("Finish", thisJoinPoint);
	}

	private void print(String prefix, Object message) 
	{
		for (int i = 0; i < callDepth; i++) {
			System.out.print(indent);
		}
		System.out.println(prefix + ": " + message);
	}
}
