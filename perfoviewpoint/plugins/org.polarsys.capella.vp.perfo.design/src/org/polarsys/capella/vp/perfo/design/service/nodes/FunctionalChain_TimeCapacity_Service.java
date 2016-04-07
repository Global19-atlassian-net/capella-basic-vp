/*******************************************************************************
 * Copyright (c) 2006, 2016 Thales Global Services
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 * 
 *   Contributors:
 *      Thales - initial API and implementation
 ******************************************************************************/
package org.polarsys.capella.vp.perfo.design.service.nodes;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.vp.perfo.perfo.TimeCapacity;
import org.polarsys.capella.vp.perfo.services.PerformanceServices;

/**
 * <!-- begin-user-doc -->
 * This class is an implementation of the DoReMi JavaExtension '<em><b>[org.polarsys.capella.vp.perfo.design.service.nodes.FunctionalChain_TimeCapacity_Service]</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */

public class FunctionalChain_TimeCapacity_Service {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 **/
	private static PerformanceServices performanceService = new PerformanceServices();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eObject : the current semantic object
	 * @param view : the current view
	 * @param container : the semantic container of the current object
	 * @generated NOT
	 */
	public boolean performanceSaturated(EObject eObject, EObject view, EObject container) {
		int checkPerformance = performanceService.checkPerformance(eObject, container);
		int value = ((TimeCapacity) eObject).getValue();
		return value != 0 && value == checkPerformance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eObject : the current semantic object
	 * @param view : the current view
	 * @param container : the semantic container of the current object
	 * @generated NOT
	 */
	public boolean performanceOverhead(EObject eObject, EObject view, EObject container) {
		int value = ((TimeCapacity) eObject).getValue();
		int checkPerformance = performanceService.checkPerformance(eObject, container);
		return value != 0 && value < checkPerformance;
	}

}