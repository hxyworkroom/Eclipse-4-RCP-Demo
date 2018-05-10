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
��EclipseRCPӦ�ó����У��û���Ҫͨ����ͼ�� View���ͱ༭���� Editor��������򽻻�����ͼ�ǿ��Ը����Ĺ������ڣ�
������ʾ������ĳ�������״̬��Ϣ
��ͼ��չ��ViewPart�����ࡣͨ����createPartControl()�����б�д���룬�Ա㹹����ͼ �Ľ���Ԫ�ء�
 */
public class FirstView extends ViewPart implements ISelectionListener{
	private Table table;
	private Text text_1;
	private Text text;
	public static final String ID = "IntegrationTest.FirstView"; //$NON-NLS-1$
	
	private String[][] contents = {{"����", "��",},{"����", "Ů"}}; 
	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		//����������Ӵ������������
		Composite container = new Composite(parent, SWT.NONE);
		final Label label = new Label(container, SWT.NONE);
		label.setText("������");
		label.setBounds(56, 41,38,30);//x,y,w,h
		
		text = new Text(container, SWT.BORDER);//��������ı������
		text.setBounds(98, 38,100,30);
//		text.setText("hello");
		
		final Label label_1 = new Label(container, SWT.NONE);
		label_1.setText("�Ա�");
		label_1.setBounds(232, 41,38,30);
		
		text_1 = new Text(container, SWT.BORDER);
		text_1.setBounds(272, 38,100,30);
//		text_1.setText("��/Ů");
		
		final TableViewer tableViewer = new TableViewer(container, SWT.BORDER);
		
        Group group = new Group(container, SWT.NONE);  
        group.setText("��");  
        group.setBounds(48,95,390,175); //���Ǹ�����һ����߿�

		//tableViewer.setInput(new Object());
		table = tableViewer.getTable();
		table.setBounds(56,120, 374, 143);
//		table.setItemCount(3);
//        table.setHeaderVisible(true);  
        table.setLinesVisible(true); 
        
         
        TableColumn tableColumn = new TableColumn(table, SWT.NONE);  
        tableColumn.setWidth(110);  
        tableColumn.setText("����"); //���Ǹ���������ֶ����� 

        {  
            TableColumn tableColumn1 = new TableColumn(table, SWT.NONE);  
            tableColumn1.setWidth(110);  
            tableColumn1.setText("�Ա�"); //������һ������д��ʽ   
        }  
        
        for (String[] content:contents) {  
            TableItem item = new TableItem(table, SWT.NONE);  
            item.setText(content);  
        }  
		//���ѭ������������в�������

		
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
		  //��ȡԪ��
		  Object obj = structuredSelection.getFirstElement();
		  
		  Person tempPerson = (Person)obj;
		  
		  if(tempPerson != null)
		  text.setText(tempPerson.getName());
		  text_1.setText(tempPerson.getSex());
		  //����Ǽ��������list�е����ݵ�ʱ��
		  //�ڵڶ����Ӵ��н����������
		
	}
}























