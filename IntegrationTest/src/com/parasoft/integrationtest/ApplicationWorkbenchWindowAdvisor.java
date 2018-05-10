package com.parasoft.integrationtest;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;


/**
 * ~~��~~
 * ��Ӧ�ó����У�ÿһ�����ڶ���һ�� WorkbenchWindowAdvisor ������������Ҳ�Ǹ��ߴ��������Ⱦ.
 * �� Window advisors���ݴ��ڵ��������ڶ����˶������㺯������preWindowOpen()���ڴ�ǰ ��
 * postWindowCreate()�������ں�ȣ������ڲ�ͬ�ķ����������ڵ����ݣ��˽ⴰ�ڵ����������Ǻ��б�Ҫ�ģ�
 * ��������滮���ں�ʱ���ܴ�����Ӧ�Ķ�����Ч�ı��ⴰ���е������û�б����������Ѿ���ʹ����
 */
/**
WorkbenchWindowAdvisor�����ڼ���ÿһ�����ڶ���һ��WorkbenchWindow-Advisor ʵ���� WorkbenchWindowAdvisor
������崰���������ڵĹ�������״̬�������������˵������ڱ��⡢���ڴ�С�͸��ֿؼ��ȵȣ�Ҳ���Դ����ڵĸ���
�¼�����
 */

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

    public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        super(configurer);
    }
    
    //��Ӳ˵���
    public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
        return new ApplicationActionBarAdvisor(configurer);
    }

    public void preWindowOpen() {//���ڴ�ǰ���Դ��ڽ�������
        IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
//        configurer.setInitialSize(new Point(800, 800));
        configurer.setShowCoolBar(false);
//        configurer.setShowCoolBar(true);//���������һ�У��ڲ˵�������
        
//        configurer.setShowStatusLine(false);
//        configurer.setShowStatusLine(true);//û�п������Եı仯
//        configurer.setShellStyle(SWT.MIN | SWT.CLOSE);//ֻ��ʾ��С�رյİ�ť
        configurer.setTitle("IntegrationTest"); //���ô���title
        

        
    }
//������������ô��ھ��г��ֵ�
	@Override
	public void postWindowOpen() {
		// TODO Auto-generated method stub
		super.postWindowOpen();
		Shell shell = getWindowConfigurer().getWindow().getShell();
		Rectangle screenSize = Display.getDefault().getClientArea();
		Rectangle frameSize = shell.getBounds();
		shell.setLocation((screenSize.width - frameSize.width) / 2,(
		screenSize.height - frameSize.height) / 2);
	}
}
/*
����������һ�����ܣ����ǰѴ����˵��͹����������񽻸���ApplicationActionBarAdvisor��
*/