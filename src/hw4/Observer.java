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
 * The Observer interface identifies the single message that any observer must
 * respond to.
 * 
 * @author gpollice
 * @version Sep 28, 2011
 */
public interface Observer
{
	/**
	 * Whenever a an observable subject changes it notifies its observers by
	 * calling the update message.
	 * 
	 * @param subject the observable object
	 * @param event informationa about the event that occurred
	 */
	void update(Object subject, Object event);
}
