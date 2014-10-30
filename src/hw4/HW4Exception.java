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
 * The exception class used for HW4-A11.
 * 
 * @author gpollice
 * @version Oct 1, 2011
 */
public class HW4Exception extends Exception
{
	/**
	 * The only constructor for this exception.
	 * 
	 * @param msg message associated with the exception
	 */
	public HW4Exception(String msg)
	{
		super(msg);
	}
}
