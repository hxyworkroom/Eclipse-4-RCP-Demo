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

	//添加功能
	public   void  run()  {
	
	if  (workbenchWindow  !=   null )  {
	// 在这里添加功能 
		FirstDialog dg  =   new  FirstDialog(workbenchWindow.getShell());
		dg.open();    
		} 
	} 
	
	
	
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
