package integrationtest;

import integrationtest.PersonModel.Listener;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.Viewer;

public class PersonContentProvider implements IStructuredContentProvider,Listener{
	PersonModel input;
	ListViewer viewer;
	
	public Object[] getElements(Object inputElement) {
	
		return input.elements().toArray();
		}

	public void dispose() {//�������ͼ�ر�
		
		if(input != null){
			input.setListener(null);
		}
		input = null;
	}
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		
		viewer = (ListViewer)viewer;
		input = (PersonModel)newInput;
		//������������Ӧ���ǹ�����ͼ�е���ʾҪ���õ�
//		viewer.setInput(newInput);
//		input.setListener(this);
	}

	public void add(Person p) {
		
		viewer.add(p);
	}

	public void remove(Person p) {
		
		viewer.remove(p);
	}
	
	public String getText(Object element){//û�����������Ķ�   �������Ϊ�ı������ṩ
		return "ok!";
//		return ((Person)element).getName()+((Person)element).getSex();
	}
	
	
}
