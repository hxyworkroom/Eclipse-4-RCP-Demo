package integrationtest;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
/**
������Ǳ�ǩ�ṩ
��������ͼ����ʾ���ı���ǩ
 */
public class PersonLabelProvider implements ILabelProvider {

	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
		System.out.println("~~~~����һ�±�ǩ~~~~~"+listener.toString());
		//�����������Ӽ�����
		//���ڳ�ʼ����ʱ���Զ�����
		
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	public boolean isLabelProperty(Object element, String property) {//�����ָ��ǩ����
		// TODO Auto-generated method stub
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
		
	}

	public Image getImage(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getText(Object element) {
		// TODO Auto-generated method stub
		return ((Person)element).getName()+"~~~"+((Person)element).getSex();//������Ƿ��ص��б��ǩ���ַ�
	}

}
