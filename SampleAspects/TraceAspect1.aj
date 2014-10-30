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
 * Description
 * @version Oct 16, 2014
 */
public aspect TraceAspect1 {
	private int callDepth;
	private final String indent = "  ";
	
	// Anything not in this aspect
	pointcut traced() : !within(TraceAspect1);
	
	// Just within the test 
	pointcut traced1() : 
		withincode(* hw4.ChessBoardTest.testInitialConfiguration(..));
	
	pointcut traced2() :
		withincode(* hw4.ChessBoard.getPieceAt(..))
		&& cflowbelow(execution(* hw4.ChessBoardTest.testInitialConfiguration(..)));
	
	pointcut setter() : set(* ChessBoard.board);
	
//	before() : setter() 
//	{
//		print ("Setting", thisJoinPoint);
//		callDepth++;
//	}
	
	after() : traced2()
	{
		callDepth--;
		print("Exiting", thisJoinPoint);
	}
	
	private void print(String prefix, Object message)
	{
		for (int i = 0; i < callDepth; i++) {
			System.out.print(indent);
		}
		System.out.println(prefix + ": " + message);
	}
}
