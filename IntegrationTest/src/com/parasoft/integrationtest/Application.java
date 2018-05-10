package com.parasoft.integrationtest;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

/**
 * ~~һ~~
 *Application�����þ���Ӧ�ó�����Ʒ(product)����ڣ�
 *����Javaϵͳ�У��ඨ���main()��������һ��. ��Runtime������ʱ��
 *Ӧ�ó���ʼ���У�Ӧ�ó����˳���ʱ��Eclipse�ر�.
 *
 *
 *��start�����У����ȴ�����Display����
 *Ȼ��ʹ��ƽ̨��UI�߳�PlatformUI�����˳������У�
 *������������ͨ������display�����Լ��½���ApplicationWorkbenchAdvisor���������е�.
 */
public class Application implements IApplication {
	
	/* (non-Javadoc)
	 * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.IApplicationContext)
	 */
	public Object start(IApplicationContext context) throws Exception {
		Display display = PlatformUI.createDisplay();
		//��SWT��
		//ÿ��SWTӦ��Ҫ��������һ��Display ��һ������shell����������shell�Ĺ��캯����Display��ΪĬ�ϲ���
		//Display��Ҫ����ʱ��ѭ�������塢��ɫ��UI�̺߳������߳�֮���ͨ��
		try {
			int returnCode = PlatformUI.createAndRunWorkbench(display, new ApplicationWorkbenchAdvisor());
			//�������Ҫ����������eclipse workbench
			//��ں����������û�����Ĺ���������ApplicationWorkbenchAdvisor��
			if (returnCode == PlatformUI.RETURN_RESTART)
				return IApplication.EXIT_RESTART;
			else
				return IApplication.EXIT_OK;
		} finally {
			display.dispose();
		}
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.equinox.app.IApplication#stop()
	 * ������ǳ���رյ�ʱ��ִ�е�
	 */
	public void stop() {
		if (!PlatformUI.isWorkbenchRunning())//�����Ƿ��ڹ�����
			return;
		final IWorkbench workbench = PlatformUI.getWorkbench();
		//Workbench�ǹ���̨��ͨ�׵�˵���Ǵ����û������UIԪ�ء�����̨���и��ִ��ڡ�ͼ�ꡢ��ť�Ϳؼ��� 
		//�û������ڹ���̨�������ֲ�������ù���̨����ķ���
		//wb.restart()���ر�Ӧ�ó�����������������
		//wb.close()�������ر�Ӧ�ó��򣬵�ͬ��ActionFactory.QUIT_ACTION
		final Display display = workbench.getDisplay();
		display.syncExec(new Runnable() {
			public void run() {
				if (!display.isDisposed())//���display�������ˣ���ô����͹ر�
					workbench.close();
			}
		});
	}
}
