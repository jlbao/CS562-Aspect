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
 * The Observable interface describes the messages that an observable object
 * must implement. This interface is used in conjunction with the Observer.
 * 
 * @author gpollice
 * @version Sep 28, 2011
 */
public interface Observable
{
	/**
	 * Add an observer to the collection of observers that observe this
	 * observable object. If the observer is already observing this 
	 * observable object, then no action is taken.
	 * 
	 * @param observer the observer to add
	 */
	void addObserver(Observer observer);
	
	
	/**
	 * Removes an observer from the set of objects observing this observable object.
	 * If the observer is not one of the observers on this object, then no 
	 * action is taken.
	 * 
	 * @param observer the observer to remove
	 */
	void removeObserver(Observer observer);
	
	
	/**
	 * Send an update message to all observers. The event object that is an
	 * argument to the update should let the observer know what the
	 * change to this observable object is (i.e., what event you are reporting
	 * to the observers).
	 */
	void notifyObservers();
}
