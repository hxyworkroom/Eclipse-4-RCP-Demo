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
 * ~~四~~
 * ActionBarAdvisors 创建了窗口需要的actions（动作），所谓动作指的就是菜单项和工具栏项。
 * 在Eclipse的开发模式中，将用户点击后系统所作的动作都可以定义为Action，这也实现了MVC的设计模式。
 * 如果不这样做，而是在UI的控件上直接添加Action Listener的话，界面代码和动作代码就会混杂在一起，
 * 以后维护起来就比较麻烦。因此如果要新增任何的用户交互动作，都需要在该类中的MakeActions方法中实例化。
 */

/**
ActionBarAdvisor。窗口级别。每一个窗口都有一个 ActionBarAdvisor实例。 
ActionBarAdvisor负责管理窗口 的菜单栏、状态栏、工具栏的外观和行
*/
public class ApplicationActionBarAdvisor extends ActionBarAdvisor {
	
	 private IWorkbenchAction action1;
	 private IWorkbenchAction action2;
	 
	 private IWorkbenchAction helpopen;
	 
	 
	 
	 //——————————————————————————————————————分割线——————————————————————————————————————


    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
    }

    protected void makeActions(IWorkbenchWindow window) {//在这个方法中将点击事件项进行实例化
        action1  =   new  Action1(window);
        action1.setText( "新建文件" );
        action1.setId( "com.parasoft.integration.action1" );
        register(action1);

        action2  =   new  Action2(window);
        action2.setText( "弹窗demo" );
        action2.setId( "com.parasoft.integration.action2" );
        register(action2);
        
        helpopen = ActionFactory.HELP_CONTENTS.create(window);
        register(helpopen);

    }

    protected void fillMenuBar(IMenuManager menuBar) {
    	MenuManager newMenu  =   new  MenuManager( "文件" , "com.parasoft.integration.firstmenu" );
    	menuBar.add(newMenu);
    	newMenu.add(action1);
//    	newMenu.add(action2);   
    	newMenu.add(helpopen);   
    	
    	//——————————————————————————————————————分割线——————————————————————————————————————
    	MenuManager eidterMenu  =   new  MenuManager( "编辑" , "com.parasoft.integration.editermenu" );
    	eidterMenu.add(action2);
    	menuBar.add(eidterMenu);
    }
    
    
    
}
/*
在这个类重载的方法中，创建我们自己的菜单和工具条
就是创建了一个窗口所需要的动作
并在窗口中定位他们
*/