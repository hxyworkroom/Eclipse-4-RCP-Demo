package integrationtest;

//import org.eclipse.jface.action.IToolBarManager;
import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.part.ViewPart;

/**
 * ~~六~~ 注意contacts类中的createPartControl方法，视图中的表格、按钮之类的控件部分代码都是在该方法中创建的，
 * 现在我们在该方法中创建一个List，用来浏览我们提供的对象信息。注意Eclipse RCP是建立在jface基础上的，
 * 后者在swt的基础上对一些常用控件，例如表格、列表，树等做了封装，采用Viewer来提供视图， content provider和input
 * model来提供模型,label provider来提供标签。因此要想创建列表并显示列表内容，
 * 必须同时创建上述几个对象，同时，为了填充数据模型，我们同时也创建了示例性质的Person对象以及相关辅助代码，
 * 如果在正式的环境中，这些model可以从数据库获得，在这里我们仅做示范性使用
 */
public class contacts extends ViewPart implements ISelectionProvider {
	//这是一种传统的事件传递模式，一般来说，只要视图中的UI控件实现了ISelectionProvider接口，
	//即具备提供选择事件的能力，就可以使用这个模式将自身发生的选择事件提供给其他实现了ISelectionListener的UI控件
	public static final String ID ="IntegrationTest.contacts";
	private ISelection selection;
	private ListViewer viewer;//这是一个视图控件
	//Jface中所有的Viewer对象都实现了 ISelectionProvider接口，
	//那么当我们点击navigation视图list列表中的人员名单时，
	//ListViewer列表就可以向其他 能够监听该选择事件的对象提供该选择事件，
	//如果我们在事件中包含一些字符串信息，那么其他对象得到这个信息之后，就可以进行相应显示了
	
	
	
	ArrayList myListeners = new ArrayList();

	public contacts() {
		super();
		// TODO Auto-generated constructor stub
		
	}

	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		viewer = new ListViewer(parent, SWT.BORDER);//添加一个显示list，用于父类控制子类
		
		viewer.setContentProvider(new PersonContentProvider());//为视图提供内容
		
		viewer.setLabelProvider(new PersonLabelProvider());
		viewer.setInput(new PersonModel());
		 
		initializeToolBar();
		viewer.addSelectionChangedListener(new ISelectionChangedListener(){
			public void selectionChanged(SelectionChangedEvent event) {
			ISelection selection2 = event.getSelection();
			setSelection(selection2);
			}
		}); 
		
		this.getSite().setSelectionProvider(this);
		createActions();
		initializeMenu();
		
	}

	public void setFocus() {
		// TODO Auto-generated method stub

	}

	private void initializeToolBar() {
		IToolBarManager toolBarManager = getViewSite().getActionBars().getToolBarManager();
		
	}
	
	public void createActions(){
		
	}
	
	public void initializeMenu(){
		
	}

	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		// TODO Auto-generated method stub
		//将视图中具体的Viewer上想要发生的事件，注册到这个Provider上
		if(!myListeners.contains(listener))
			myListeners.add(listener);
	}

	public ISelection getSelection() {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeSelectionChangedListener(
			ISelectionChangedListener listener) {
		// TODO Auto-generated method stub
		 myListeners.remove(listener);
		
	}

	public void setSelection(ISelection selection) {
		this.selection = selection;
		SelectionChangedEvent event2 = new SelectionChangedEvent(viewer, selection);
		for (Iterator i = myListeners.iterator(); i.hasNext();) {
			ISelectionChangedListener object = (ISelectionChangedListener) i.next();
			object.selectionChanged(event2);
		}    
	}
}
