package com.parasoft.integrationtest.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

import com.parasoft.dialog.FirstDialog;

public class Action2 extends  Action  implements  IWorkbenchAction{
	private  IWorkbenchWindow workbenchWindow;
	  
	public  Action2(IWorkbenchWindow window)  {
		if  (window  ==   null )  {
			throw   new  IllegalArgumentException();
		} 
		this .workbenchWindow  =  window;
	}

	//��ӹ���
	public   void  run()  {
	
	if  (workbenchWindow  !=   null )  {
	// ��������ӹ��� 
		FirstDialog dg  =   new  FirstDialog(workbenchWindow.getShell());
		dg.open();    
		} 
	} 
	
	
	
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
