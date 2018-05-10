package com.parasoft.integrationtest;

import org.eclipse.ui.IWorkbenchPreferenceConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
/**
 * @author parasoftCD
 * ~~二~~
 * 在ApplicationWorkbenchAdvisor中，向导为我们创建了ApplicationWorkbenchWindowAdvisor对象，别的什么也没做。
 * Eclipse遵从经典的MVC模式来设计，其中Advisor类就相当于Model，相当于视图的内容提供者，
 * 这样就把view和model解耦了。像它的名字一样， WorkbenchAdvisor 告诉工作台怎样显示，显示什么等信息。
 * 在RCP应用程序中，很多地方用这种模板模式来构建UI组件。WorkbenchAdvisor做了两件事：
 * 初始化默认视图和创建Application的window advisor
 */
/**
WorkbenchAdvisor。 应用程序级别，Eclipse3.0开始引入的全新类。 每一个应用程序只有一个 Workbench， WorkbenchAdvisor
负责该工作台生命周期的管理， 例如启动、 关闭工作。WorkbenchAdvisor也负责该 Workbench的异常处理， 并负责向Workbench
提供一些重要参数，例如可以指定该Workbench的初始透视图
 */
public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

	private static final String PERSPECTIVE_ID = "IntegrationTest.perspective"; //$NON-NLS-1$

    public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        return new ApplicationWorkbenchWindowAdvisor(configurer);//*
    }

	public String getInitialWindowPerspectiveId() {
		return PERSPECTIVE_ID;//*
	}
	
	//固定窗口位置   上次从哪里关闭   下次就从哪里打开
	public void initialize(IWorkbenchConfigurer configurer){
//		configurer.setSaveAndRestore(true);//这个是设置记住上次关闭前的位置以及窗体状态
		super.initialize(configurer);
		configurer.setSaveAndRestore(false);
		PlatformUI.getPreferenceStore().setValue(IWorkbenchPreferenceConstants.SHOW_TRADITIONAL_STYLE_TABS,false);
		//上面的三局代码实现了视图边框变成弧线
	}
}
