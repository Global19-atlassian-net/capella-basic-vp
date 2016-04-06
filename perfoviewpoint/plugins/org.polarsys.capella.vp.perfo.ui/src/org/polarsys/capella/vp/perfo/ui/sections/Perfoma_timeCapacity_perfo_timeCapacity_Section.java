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
package org.polarsys.capella.vp.perfo.ui.sections;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.ui.properties.fields.AbstractSemanticField;
import org.polarsys.capella.core.ui.properties.fields.TextValueGroup;
import org.polarsys.capella.core.ui.properties.sections.AbstractSection;
import org.polarsys.capella.vp.perfo.perfo.PerfoPackage;
import org.polarsys.capella.vp.perfo.perfo.TimeCapacity;
import org.polarsys.capella.vp.perfo.ui.fields.MeasurementUnitField_semanticKindGroup;
import org.polarsys.kitalpha.ad.services.manager.ViewpointManager;

/**
 * <!-- begin-user-doc -->
 * This class is an implementation of the section '<em><b>[Perfoma_timeCapacity_perfo_timeCapacity_Section]</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */

public class Perfoma_timeCapacity_perfo_timeCapacity_Section extends AbstractSection {

	/**
	* <!-- begin-model-doc -->
	* <!-- end-model-doc -->
	* <!-- begin-user-doc -->
	* <!-- end-user-doc -->
	* @generated
	*/
	private TextValueGroup ValueField;

	/**
	* <!-- begin-model-doc -->
	* <!-- end-model-doc -->
	* <!-- begin-user-doc -->
	* <!-- end-user-doc -->
	* @generated
	*/
	private MeasurementUnitField_semanticKindGroup MeasurementUnitField;

	/**
	* <!-- begin-model-doc -->
	* <!-- end-model-doc -->
		* <!-- begin-user-doc -->
	* <!-- end-user-doc -->
		* @generated
		*/
	private Group perfo_timeCapacity_AttributeGroup;

	/**
	* <!-- begin-user-doc -->
	* <!-- end-user-doc -->
	* @param eObject: current object
	* @generated NOT
	*/
	public boolean select(Object eObject) {
		EObject eObjectToTest = super.selection(eObject);

		if (eObjectToTest instanceof TimeCapacity)
			return true;
		else 
		{
			EObject children = getTimeCapacityObject(eObjectToTest);
			if (children != null)
				return true;
		}
		
		return false;
	}

	/**
	* <!-- begin-user-doc -->
	* <!-- end-user-doc -->
	* @param part
	* @param selection
	* @generated NOT
	*/
	public void setInput(IWorkbenchPart part, ISelection selection) {
		EObject newEObject = super.setInputSelection(part, selection);
		
		if (newEObject != null && !(newEObject instanceof TimeCapacity))
			newEObject = getTimeCapacityObject(newEObject);
		
		if (newEObject != null) {
			loadData((CapellaElement) newEObject);
		} else {
			return;
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param parent: An EObject. It is considered as the Parent of an EMDE extension (a Viewpoint element)
	 * @return 
	 */
	private EObject getTimeCapacityObject(EObject parent) {
		if (!isViewpointActive(parent))
			return null;

		if (parent == null || (parent != null && parent.eContents() == null))
			return null;

		EObject result = null;
		for (EObject iEObject : parent.eContents()) 
		{
			if (iEObject instanceof TimeCapacity) 
			{
				result = (result == null ? (TimeCapacity) iEObject : null);
				// This case is true when there is more then one extension of the same type. 
				if (result == null)
					break;
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return True is the AF viewpoint is active. False else. 
	 */
	private boolean isViewpointActive(EObject modelElement) {
		return ViewpointManager.getInstance(modelElement).isActive("org.polarsys.capella.vp.perfo");
	}

	/**
	* <!-- begin-user-doc -->
	* <!-- end-user-doc -->
	* @param parent:
	* @param aTabbedPropertySheetPage:
	* @generated
	*/
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);

		perfo_timeCapacity_AttributeGroup = getWidgetFactory().createGroup(_rootParentComposite,
				"Time Capacity Attributes");
		perfo_timeCapacity_AttributeGroup.setLayout(new GridLayout(1, false));
		GridData gdperfo_timeCapacity_AttributeGroup = new GridData(GridData.FILL_HORIZONTAL);
		gdperfo_timeCapacity_AttributeGroup.horizontalSpan = ((GridLayout) _rootParentComposite.getLayout()).numColumns;
		perfo_timeCapacity_AttributeGroup.setLayoutData(gdperfo_timeCapacity_AttributeGroup);

		ValueField = new TextValueGroup(perfo_timeCapacity_AttributeGroup, "Time Limit :", getWidgetFactory(), true);

		MeasurementUnitField = new MeasurementUnitField_semanticKindGroup(perfo_timeCapacity_AttributeGroup,
				getWidgetFactory());

	}

	/**
	* <!-- begin-user-doc -->
	* <!-- end-user-doc -->
	* @param capellaElement_p
	* @generated
	*/
	public void loadData(CapellaElement capellaElement_p) {
		super.loadData(capellaElement_p);

		ValueField.loadData(capellaElement_p, PerfoPackage.eINSTANCE.getPerformanceCriteria_Value());

		MeasurementUnitField.loadData(capellaElement_p, PerfoPackage.eINSTANCE.getUnityElement_MeasurementUnit());

	}

	/**
	* <!-- begin-user-doc -->
	* <!-- end-user-doc -->
	* @generated
	*/
	public List<AbstractSemanticField> getSemanticFields() {
		List<AbstractSemanticField> abstractSemanticFields = new ArrayList<AbstractSemanticField>();

		abstractSemanticFields.add(ValueField);

		abstractSemanticFields.add(MeasurementUnitField);

		return abstractSemanticFields;
	}
}
