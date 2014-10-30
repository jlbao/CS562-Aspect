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
 * An observer for the tests.
 * 
 * @author gpollice
 * @version Oct 8, 2011
 */
public class TestObserver implements Observer
{
	private Object lastSubject = null;
	private Object lastEvent = null;
	private int updateCount = 0;
	
	public TestObserver()
	{
		// Intentionally left empty
	}
	
	@Override
	public void update(Object subject, Object event)
	{
		lastSubject = subject;
		lastEvent = event;
		updateCount++;
	}
	
	public void observe(Observable observable)
	{
		observable.addObserver(this);
	}

	/**
	 * @return the lastSubject
	 */
	public Object getLastSubject()
	{
		return lastSubject;
	}

	/**
	 * @return the lastEvent
	 */
	public Object getLastEvent()
	{
		return lastEvent;
	}

	/**
	 * @return the updateCount
	 */
	public int getUpdateCount()
	{
		return updateCount;
	}

}
