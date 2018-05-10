package com.parasoft.integrationtest;

import org.eclipse.ui.IWorkbenchPreferenceConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
/**
 * @author parasoftCD
 * ~~��~~
 * ��ApplicationWorkbenchAdvisor�У���Ϊ���Ǵ�����ApplicationWorkbenchWindowAdvisor���󣬱��ʲôҲû����
 * Eclipse��Ӿ����MVCģʽ����ƣ�����Advisor����൱��Model���൱����ͼ�������ṩ�ߣ�
 * �����Ͱ�view��model�����ˡ�����������һ���� WorkbenchAdvisor ���߹���̨������ʾ����ʾʲô����Ϣ��
 * ��RCPӦ�ó����У��ܶ�ط�������ģ��ģʽ������UI�����WorkbenchAdvisor���������£�
 * ��ʼ��Ĭ����ͼ�ʹ���Application��window advisor
 */
/**
WorkbenchAdvisor�� Ӧ�ó��򼶱�Eclipse3.0��ʼ�����ȫ���ࡣ ÿһ��Ӧ�ó���ֻ��һ�� Workbench�� WorkbenchAdvisor
����ù���̨�������ڵĹ��� ���������� �رչ�����WorkbenchAdvisorҲ����� Workbench���쳣���� ��������Workbench
�ṩһЩ��Ҫ�������������ָ����Workbench�ĳ�ʼ͸��ͼ
 */
public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

	private static final String PERSPECTIVE_ID = "IntegrationTest.perspective"; //$NON-NLS-1$

    public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        return new ApplicationWorkbenchWindowAdvisor(configurer);//*
    }

	public String getInitialWindowPerspectiveId() {
		return PERSPECTIVE_ID;//*
	}
	
	//�̶�����λ��   �ϴδ�����ر�   �´ξʹ������
	public void initialize(IWorkbenchConfigurer configurer){
//		configurer.setSaveAndRestore(true);//��������ü�ס�ϴιر�ǰ��λ���Լ�����״̬
		super.initialize(configurer);
		configurer.setSaveAndRestore(false);
		PlatformUI.getPreferenceStore().setValue(IWorkbenchPreferenceConstants.SHOW_TRADITIONAL_STYLE_TABS,false);
		//��������ִ���ʵ������ͼ�߿��ɻ���
	}
}
