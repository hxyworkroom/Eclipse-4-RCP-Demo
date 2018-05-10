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

	public void dispose() {//这个是视图关闭
		
		if(input != null){
			input.setListener(null);
		}
		input = null;
	}
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		
		viewer = (ListViewer)viewer;
		input = (PersonModel)newInput;
		//上面两个作用应该是构建视图中的显示要素用的
//		viewer.setInput(newInput);
//		input.setListener(this);
	}

	public void add(Person p) {
		
		viewer.add(p);
	}

	public void remove(Person p) {
		
		viewer.remove(p);
	}
	
	public String getText(Object element){//没看出作用在哪儿   初步理解为文本内容提供
		return "ok!";
//		return ((Person)element).getName()+((Person)element).getSex();
	}
	
	
}
