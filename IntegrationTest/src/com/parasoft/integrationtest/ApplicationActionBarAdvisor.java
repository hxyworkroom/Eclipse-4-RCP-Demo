package com.parasoft.integrationtest;


import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;

import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

import com.parasoft.integrationtest.actions.Action1;
import com.parasoft.integrationtest.actions.Action2;

/**
 * ~~��~~
 * ActionBarAdvisors �����˴�����Ҫ��actions������������ν����ָ�ľ��ǲ˵���͹������
 * ��Eclipse�Ŀ���ģʽ�У����û������ϵͳ�����Ķ��������Զ���ΪAction����Ҳʵ����MVC�����ģʽ��
 * �������������������UI�Ŀؼ���ֱ�����Action Listener�Ļ����������Ͷ�������ͻ������һ��
 * �Ժ�ά�������ͱȽ��鷳��������Ҫ�����κε��û���������������Ҫ�ڸ����е�MakeActions������ʵ������
 */

/**
ActionBarAdvisor�����ڼ���ÿһ�����ڶ���һ�� ActionBarAdvisorʵ���� 
ActionBarAdvisor��������� �Ĳ˵�����״̬��������������ۺ���
*/
public class ApplicationActionBarAdvisor extends ActionBarAdvisor {
	
	 private IWorkbenchAction action1;
	 private IWorkbenchAction action2;
	 
	 private IWorkbenchAction helpopen;
	 
	 
	 
	 //�����������������������������������������������������������������������������ָ��ߡ���������������������������������������������������������������������������


    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
    }

    protected void makeActions(IWorkbenchWindow window) {//����������н�����¼������ʵ����
        action1  =   new  Action1(window);
        action1.setText( "�½��ļ�" );
        action1.setId( "com.parasoft.integration.action1" );
        register(action1);

        action2  =   new  Action2(window);
        action2.setText( "����demo" );
        action2.setId( "com.parasoft.integration.action2" );
        register(action2);
        
        helpopen = ActionFactory.HELP_CONTENTS.create(window);
        register(helpopen);

    }

    protected void fillMenuBar(IMenuManager menuBar) {
    	MenuManager newMenu  =   new  MenuManager( "�ļ�" , "com.parasoft.integration.firstmenu" );
    	menuBar.add(newMenu);
    	newMenu.add(action1);
//    	newMenu.add(action2);   
    	newMenu.add(helpopen);   
    	
    	//�����������������������������������������������������������������������������ָ��ߡ���������������������������������������������������������������������������
    	MenuManager eidterMenu  =   new  MenuManager( "�༭" , "com.parasoft.integration.editermenu" );
    	eidterMenu.add(action2);
    	menuBar.add(eidterMenu);
    }
    
    
    
}
/*
����������صķ����У����������Լ��Ĳ˵��͹�����
���Ǵ�����һ����������Ҫ�Ķ���
���ڴ����ж�λ����
*/