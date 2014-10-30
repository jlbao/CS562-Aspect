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

import java.util.*;

/**
 * The BoardObserver observes a chess board. When an instance of this
 * class is notified of a move, it forwards that MoveEvent to all objects
 * observing it.
 * 
 * @author gpollice
 * @version Oct 1, 2011
 */
public class BoardObserver implements Observable, Observer
{
	private final Collection<Observer> observers;
	private MoveEvent lastMove = null;
	
	/**
	 * The constructor for this class is given a ChessBoard object to 
	 * observe.
	 * 
	 * @param observed the board to observe
	 */
	public BoardObserver(ChessBoard observed)
	{
		observers = new HashSet<Observer>();
		observed.addObserver(this);
	}
	
	/*
	 * @see hw4.Observer#update(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void update(Object subject, Object event)
	{
		lastMove = (MoveEvent)event;
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
