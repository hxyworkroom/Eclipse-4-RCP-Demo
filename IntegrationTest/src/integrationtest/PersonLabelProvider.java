package integrationtest;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
/**
这个类是标签提供
就是在视图中显示出文本标签
 */
public class PersonLabelProvider implements ILabelProvider {

	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
		System.out.println("~~~~点了一下标签~~~~~"+listener.toString());
		//这个方法是添加监听器
		//会在初始化的时候自动运行
		
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	public boolean isLabelProperty(Object element, String property) {//这个是指标签属性
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
		return ((Person)element).getName()+"~~~"+((Person)element).getSex();//这个就是返回到列表标签的字符
	}

}
