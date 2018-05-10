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
 * ~~��~~ ע��contacts���е�createPartControl��������ͼ�еı�񡢰�ť֮��Ŀؼ����ִ��붼���ڸ÷����д����ģ�
 * ���������ڸ÷����д���һ��List��������������ṩ�Ķ�����Ϣ��ע��Eclipse RCP�ǽ�����jface�����ϵģ�
 * ������swt�Ļ����϶�һЩ���ÿؼ����������б��������˷�װ������Viewer���ṩ��ͼ�� content provider��input
 * model���ṩģ��,label provider���ṩ��ǩ�����Ҫ�봴���б���ʾ�б����ݣ�
 * ����ͬʱ����������������ͬʱ��Ϊ���������ģ�ͣ�����ͬʱҲ������ʾ�����ʵ�Person�����Լ���ظ������룬
 * �������ʽ�Ļ����У���Щmodel���Դ����ݿ��ã����������ǽ���ʾ����ʹ��
 */
public class contacts extends ViewPart implements ISelectionProvider {
	//����һ�ִ�ͳ���¼�����ģʽ��һ����˵��ֻҪ��ͼ�е�UI�ؼ�ʵ����ISelectionProvider�ӿڣ�
	//���߱��ṩѡ���¼����������Ϳ���ʹ�����ģʽ����������ѡ���¼��ṩ������ʵ����ISelectionListener��UI�ؼ�
	public static final String ID ="IntegrationTest.contacts";
	private ISelection selection;
	private ListViewer viewer;//����һ����ͼ�ؼ�
	//Jface�����е�Viewer����ʵ���� ISelectionProvider�ӿڣ�
	//��ô�����ǵ��navigation��ͼlist�б��е���Ա����ʱ��
	//ListViewer�б�Ϳ��������� �ܹ�������ѡ���¼��Ķ����ṩ��ѡ���¼���
	//����������¼��а���һЩ�ַ�����Ϣ����ô��������õ������Ϣ֮�󣬾Ϳ��Խ�����Ӧ��ʾ��
	
	
	
	ArrayList myListeners = new ArrayList();

	public contacts() {
		super();
		// TODO Auto-generated constructor stub
		
	}

	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		viewer = new ListViewer(parent, SWT.BORDER);//���һ����ʾlist�����ڸ����������
		
		viewer.setContentProvider(new PersonContentProvider());//Ϊ��ͼ�ṩ����
		
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
		//����ͼ�о����Viewer����Ҫ�������¼���ע�ᵽ���Provider��
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
