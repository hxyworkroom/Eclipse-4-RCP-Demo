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

	// ��Ӳ˵�����
	// ������Ǿ������ӵ���¼�
	public   void  run()  {
      //  make sure action is not disposed 
		if  (workbenchWindow  !=   null )  {
//            // ��������ӹ��� 
//				FirstDialog dg  =   new  FirstDialog(workbenchWindow.getShell());
//				dg.open();
			System.out.println("~~����һ��~~");
		     }
	}
	
	public void dispose() {
		// TODO Auto-generated method stub
		//System.out.println("~~~~~~~~~~~~~~~~~~~~~~~hello_world~~~~~~~~~~~~~~~~~~~~~~~");
	}
	// �������������¼�������д���¼�����ApplicationActionBarAdvisor�н��е���action1.dispose();
	// �������ʹ�ã��ǳ�ʼ�����߹رյ�ȫ��ʹ�ã�������before(),after()�¼�
	// ����dispose�����������Ӿ���ʵ�֣������䷽��������init�������ǰ��¼�

}
