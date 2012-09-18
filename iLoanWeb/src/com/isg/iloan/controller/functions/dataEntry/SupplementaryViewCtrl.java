package com.isg.iloan.controller.functions.dataEntry;

/**
 * 
 */


import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.impl.InputElement;

import com.isg.iloan.validation.InputElementValidator;

/**
 * @author sheena.catacutan
 *
 */
@SuppressWarnings("rawtypes")
public class SupplementaryViewCtrl extends GenericForwardComposer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7923899381024830008L;
	private Textbox others_txtbox;
	private Checkbox othrs_chkbox;
	private Grid supplementaryGrid;

	/**
	 *
	 *
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		others_txtbox.setDisabled(true);
		
		InputElementValidator.addOnBlurEventToInput(comp, comp, "#sd");
		bindValidationOnClick(supplementaryGrid);
	}
	
	private List getInputElements(Component comp, ArrayList<InputElement> arrayList) {
		if (comp instanceof InputElement) {
			arrayList.add((InputElement) comp);
		}
		if (null != comp) {
			List<Component> list = comp.getChildren();
			for (Component child : list) {
				getInputElements(child, arrayList);
			}
		}
		return arrayList;
	}
	private void validateForm(List<InputElement> elements){
		boolean hasInvalid = false;
		for(InputElement e: elements){
			if(!e.isValid()){
				hasInvalid = true;
				break;
			}
		}
		if(!hasInvalid){
			Clients.evalJavaScript("validatedState('#sd',true)");
		}
	}
	
	@SuppressWarnings("unchecked")
	private void bindValidationOnClick(Component comp){
		Component parent = comp.getParent();
		if(parent instanceof Tabbox){
			for(Component c: parent.getChildren()){
				if(c instanceof Tabs){		
					for(Component t :c.getChildren()){
						if("supplementaryDetail".equals(t.getId())){
							t.addEventListener(Events.ON_CLICK, new EventListener(){
								public void onEvent(Event event){
									validateForm(getInputElements(supplementaryGrid, new ArrayList<InputElement>()));
								}
							});
							break;
						}
					}
				}
			}
			return;
		}
		bindValidationOnClick(parent.getParent());
	}
	public void onClick$othrs_chkbox(){
		if(othrs_chkbox.isChecked()){
			others_txtbox.setDisabled(false);
		}else{
			others_txtbox.setDisabled(true);
		}
	}

}
