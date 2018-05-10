package com.parasoft.integrationtest;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * ~~五~~
 *给透视图一个扩展名称，相当于生成创建一个容器
 *这里主要是声明出来，并不进行什么处理 
 *Perspective主要负责RCP窗口的布局安排，透视图类必须实现IPerspectiveFactory 接口，
 *并在createInitial Layout(IPageLayout)方法添加实际的布局代码。
 */
/**
Perspective与视图、编辑器之间的关系类似于书包和书、笔的关系。
书包里面可以放各种书和笔，书包 是Perspective，而书和笔则类似于视图和编辑器。 
Perspective叫做透视图，RCP应用程序是通过透视图对窗口内容进行安排和布局，
应用程序都有一个默认的透视图，每个工作台窗口则可以包含一个或多个透视图，同时用户可向透视图中添加其他UI界面元素。
默认透视图被设置为固定的， 不能移动，而且没有标题栏。
 */
public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		
		layout.addView("IntegrationTest.contacts",IPageLayout.LEFT,0.3f,layout.getEditorArea());
		
		layout.addView("IntegrationTest.FirstView", IPageLayout.RIGHT, 0.7f,layout.getEditorArea());
//		0.3f-0.7f是把屏幕按百分比进行了分配处理的，目的在于处理view的布局以及大小情况
//		layout.addStandaloneView("IntegrationTest.contacts",false,IPageLayout.TOP,1.0f,layout.getEditorArea());
		//上面这个没研究出来是干什么的
//		layout.setFixed(true);//这个是固定住
		layout.setEditorAreaVisible(false);//这个就是去掉默认的透视图
	}
	
}



















