package com.parasoft.integrationtest;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;


/**
 * ~~三~~
 * 在应用程序中，每一个窗口都有一个 WorkbenchWindowAdvisor ，它的作用是也是告诉窗口如何渲染.
 * 在 Window advisors根据窗口的生命周期定义了多个切入点函数，如preWindowOpen()窗口打开前 ，
 * postWindowCreate()创建窗口后等，可以在不同的方法创建窗口的内容，了解窗口的生命周期是很有必要的，
 * 可以让你规划后，在何时才能创建相应的对象，有效的避免窗口中的组件还没有被创建，就已经在使用了
 */
/**
WorkbenchWindowAdvisor。窗口级别。每一个窗口都有一个WorkbenchWindow-Advisor 实例。 WorkbenchWindowAdvisor
负责具体窗口生命周期的管理，例如状态栏、工具栏、菜单、窗口标题、窗口大小和各种控件等等，也可以处理窗口的各种
事件例程
 */

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

    public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        super(configurer);
    }
    
    //添加菜单栏
    public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
        return new ApplicationActionBarAdvisor(configurer);
    }

    public void preWindowOpen() {//窗口打开前，对窗口进行设置
        IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
//        configurer.setInitialSize(new Point(800, 800));
        configurer.setShowCoolBar(false);
//        configurer.setShowCoolBar(true);//这句代码会多出一行，在菜单栏下面
        
//        configurer.setShowStatusLine(false);
//        configurer.setShowStatusLine(true);//没有看出明显的变化
//        configurer.setShellStyle(SWT.MIN | SWT.CLOSE);//只显示缩小关闭的按钮
        configurer.setTitle("IntegrationTest"); //设置窗口title
        

        
    }
//这个方法是设置窗口居中出现的
	@Override
	public void postWindowOpen() {
		// TODO Auto-generated method stub
		super.postWindowOpen();
		Shell shell = getWindowConfigurer().getWindow().getShell();
		Rectangle screenSize = Display.getDefault().getClientArea();
		Rectangle frameSize = shell.getBounds();
		shell.setLocation((screenSize.width - frameSize.width) / 2,(
		screenSize.height - frameSize.height) / 2);
	}
}
/*
这个类的另外一个功能，就是把创建菜单和工具栏的任务交给了ApplicationActionBarAdvisor类
*/