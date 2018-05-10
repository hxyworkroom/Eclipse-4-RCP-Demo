package com.parasoft.integrationtest.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

public class Action1 extends Action implements IWorkbenchAction {
	private IWorkbenchWindow workbenchWindow;

	public Action1(IWorkbenchWindow window) {
		if (window == null) {
			throw new IllegalArgumentException();
		}
		this.workbenchWindow = window;
	}

	// 添加菜单功能
	// 这个就是具体的添加点击事件
	public   void  run()  {
      //  make sure action is not disposed 
		if  (workbenchWindow  !=   null )  {
//            // 在这里添加功能 
//				FirstDialog dg  =   new  FirstDialog(workbenchWindow.getShell());
//				dg.open();
			System.out.println("~~戳你一下~~");
		     }
	}
	
	public void dispose() {
		// TODO Auto-generated method stub
		//System.out.println("~~~~~~~~~~~~~~~~~~~~~~~hello_world~~~~~~~~~~~~~~~~~~~~~~~");
	}
	// 这个类似于添加事件监听，写好事件后，在ApplicationActionBarAdvisor中进行调用action1.dispose();
	// 但是这个使用，是初始化或者关闭的全局使用，类似于before(),after()事件
	// 但是dispose这个方法，添加具体实现，发现其方法类似于init，并不是绑定事件

}
