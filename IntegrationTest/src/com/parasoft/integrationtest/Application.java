package com.parasoft.integrationtest;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

/**
 * ~~一~~
 *Application的作用就是应用程序或产品(product)的入口，
 *它和Java系统中，类定义的main()方法作用一样. 当Runtime启动的时候，
 *应用程序开始运行，应用程序退出的时候，Eclipse关闭.
 *
 *
 *在start方法中，首先创建了Display对象，
 *然后使用平台的UI线程PlatformUI启动了程序运行，
 *而启动过程是通过传递display对象以及新建的ApplicationWorkbenchAdvisor对象来进行的.
 */
public class Application implements IApplication {
	
	/* (non-Javadoc)
	 * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.IApplicationContext)
	 */
	public Object start(IApplicationContext context) throws Exception {
		Display display = PlatformUI.createDisplay();
		//在SWT中
		//每个SWT应用要求至少有一个Display 和一个或多个shell对象。主窗口shell的构造函数把Display作为默认参数
		//Display主要负责时间循环、字体、颜色、UI线程和其他线程之间的通信
		try {
			int returnCode = PlatformUI.createAndRunWorkbench(display, new ApplicationWorkbenchAdvisor());
			//这个是主要方法，启动eclipse workbench
			//入口函数将创建用户界面的工作交给了ApplicationWorkbenchAdvisor类
			if (returnCode == PlatformUI.RETURN_RESTART)
				return IApplication.EXIT_RESTART;
			else
				return IApplication.EXIT_OK;
		} finally {
			display.dispose();
		}
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.equinox.app.IApplication#stop()
	 * 这个就是程序关闭的时候执行的
	 */
	public void stop() {
		if (!PlatformUI.isWorkbenchRunning())//程序是否还在工作中
			return;
		final IWorkbench workbench = PlatformUI.getWorkbench();
		//Workbench是工作台，通俗地说就是代表用户界面的UI元素。工作台上有各种窗口、图标、按钮和控件， 
		//用户可以在工作台上做各种操作。获得工作台对象的方法
		//wb.restart()，关闭应用程序并立即重新启动。
		//wb.close()，正常关闭应用程序，等同于ActionFactory.QUIT_ACTION
		final Display display = workbench.getDisplay();
		display.syncExec(new Runnable() {
			public void run() {
				if (!display.isDisposed())//如果display被销毁了，那么程序就关闭
					workbench.close();
			}
		});
	}
}
