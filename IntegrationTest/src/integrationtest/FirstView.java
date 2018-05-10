package integrationtest;


import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;
/**
在EclipseRCP应用程序中，用户主要通过视图（ View）和编辑器（ Editor）来与程序交互。视图是可以浮动的工作窗口，
负责显示数据在某个层面的状态信息
视图扩展自ViewPart抽象类。通常在createPartControl()方法中编写代码，以便构建视图 的界面元素。
 */
public class FirstView extends ViewPart implements ISelectionListener{
	private Table table;
	private Text text_1;
	private Text text;
	public static final String ID = "IntegrationTest.FirstView"; //$NON-NLS-1$
	
	private String[][] contents = {{"张三", "男",},{"李四", "女"}}; 
	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		//这个就是在视窗版块中添加组件
		Composite container = new Composite(parent, SWT.NONE);
		final Label label = new Label(container, SWT.NONE);
		label.setText("姓名：");
		label.setBounds(56, 41,38,30);//x,y,w,h
		
		text = new Text(container, SWT.BORDER);//这个就是文本输入框
		text.setBounds(98, 38,100,30);
//		text.setText("hello");
		
		final Label label_1 = new Label(container, SWT.NONE);
		label_1.setText("性别：");
		label_1.setBounds(232, 41,38,30);
		
		text_1 = new Text(container, SWT.BORDER);
		text_1.setBounds(272, 38,100,30);
//		text_1.setText("男/女");
		
		final TableViewer tableViewer = new TableViewer(container, SWT.BORDER);
		
        Group group = new Group(container, SWT.NONE);  
        group.setText("表");  
        group.setBounds(48,95,390,175); //这是给表格加一个外边框

		//tableViewer.setInput(new Object());
		table = tableViewer.getTable();
		table.setBounds(56,120, 374, 143);
//		table.setItemCount(3);
//        table.setHeaderVisible(true);  
        table.setLinesVisible(true); 
        
         
        TableColumn tableColumn = new TableColumn(table, SWT.NONE);  
        tableColumn.setWidth(110);  
        tableColumn.setText("名字"); //这是给表格设置字段名称 

        {  
            TableColumn tableColumn1 = new TableColumn(table, SWT.NONE);  
            tableColumn1.setWidth(110);  
            tableColumn1.setText("性别"); //两个不一样的书写方式   
        }  
        
        for (String[] content:contents) {  
            TableItem item = new TableItem(table, SWT.NONE);  
            item.setText(content);  
        }  
		//这个循环就是往表格中插入数据

		
		createActions();
		initializeToolBar();
		initializeMenu();		
		this.getSite().getPage().addSelectionListener(this);
	
	}
	private void createActions() {
		// Create the actions
	}

	private void initializeToolBar() {
		IToolBarManager toolbarManager = getViewSite().getActionBars().getToolBarManager();
	}

	private void initializeMenu() {
	    IMenuManager menuManager = getViewSite().getActionBars().getMenuManager();
	}
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		  IStructuredSelection structuredSelection = (IStructuredSelection)selection;
		  //获取元素
		  Object obj = structuredSelection.getFirstElement();
		  
		  Person tempPerson = (Person)obj;
		  
		  if(tempPerson != null)
		  text.setText(tempPerson.getName());
		  text_1.setText(tempPerson.getSex());
		  //这就是监听到点击list中的数据的时候
		  //在第二个视窗中进行添加数据
		
	}
}























