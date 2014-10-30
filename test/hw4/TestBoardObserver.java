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

/**
 *
 * @author gpollice
 * @version Oct 8, 2011
 */
public class TestBoardObserver extends BoardObserver
{
	private int selfMessageCount = 0;
	public TestBoardObserver(ChessBoard observed)
	{
		super(observed);
	}

	public void update(Object subject, Object event)
	{
		if (subject == this) {
			selfMessageCount++;
		}
		if (selfMessageCount < 100) {
			super.update(subject, event);
		}
	}
}
