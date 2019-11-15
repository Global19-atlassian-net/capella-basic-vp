/*******************************************************************************
 * Copyright (c) 2006, 2019 Thales Global Services
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 * 
 *   Contributors:
 *      Thales - initial API and implementation
 ******************************************************************************/
package org.polarsys.capella.vp.price.helpers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.cs.Part;
import org.polarsys.capella.core.data.pa.PhysicalComponent;
import org.polarsys.capella.vp.price.price.PartPrice;
import org.polarsys.capella.vp.price.price.Price;
import org.polarsys.capella.vp.price.price.impl.PriceFactoryImpl;
import org.polarsys.kitalpha.emde.model.ElementExtension;

public class PriceCreationToolHelper {
	
	public boolean createPrice(EObject eObject, int cls){
		return createPriceObject(eObject, cls);
	}
	
	private boolean createPriceObject(EObject eObject, int cls){

		EObject correctPart = eObject;

		if (eObject instanceof PhysicalComponent){
			if (PriceHelper.isPhysicalSystem(eObject)){
				correctPart = ((PhysicalComponent)eObject).getAbstractTypedElements().get(0);
			}
		}

		for (EObject iEO : correctPart.eContents()) {		
			if (iEO instanceof PartPrice ){
				return false;
			}
		}
		
		Price newPriceObject = null;
		
		if (cls == 2){
			newPriceObject = PriceFactoryImpl.eINSTANCE.createPartPrice();
		}
		
		if (newPriceObject != null){
			newPriceObject.setMaxValue(0);
			newPriceObject.setMinValue(0);
			newPriceObject.setValue(0);
			((CapellaElement)newPriceObject).setId(EcoreUtil.generateUUID());
			
			if (eObject instanceof PhysicalComponent){
				PhysicalComponent pc = (PhysicalComponent)eObject;
				if (PriceHelper.isPhysicalSystem(pc)){
					eObject = (Part)pc.getAbstractTypedElements().get(0);
				}else{
					return false;
				}
			}
			
			if (eObject instanceof Part){
				Part part = (Part) eObject;
				if (part.getAbstractType() instanceof Component && ((Component)part.getAbstractType()).isActor())
					return false;
				
				part.getOwnedExtensions().add((ElementExtension)newPriceObject);
				return true;
			}
			
		}else{
			return false;
		}
		return false;
	}

}
