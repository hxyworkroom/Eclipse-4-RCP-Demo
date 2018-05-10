package com.parasoft.integrationtest;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * ~~��~~
 *��͸��ͼһ����չ���ƣ��൱�����ɴ���һ������
 *������Ҫ��������������������ʲô���� 
 *Perspective��Ҫ����RCP���ڵĲ��ְ��ţ�͸��ͼ�����ʵ��IPerspectiveFactory �ӿڣ�
 *����createInitial Layout(IPageLayout)�������ʵ�ʵĲ��ִ��롣
 */
/**
Perspective����ͼ���༭��֮��Ĺ�ϵ������������顢�ʵĹ�ϵ��
���������ԷŸ�����ͱʣ���� ��Perspective������ͱ�����������ͼ�ͱ༭���� 
Perspective����͸��ͼ��RCPӦ�ó�����ͨ��͸��ͼ�Դ������ݽ��а��źͲ��֣�
Ӧ�ó�����һ��Ĭ�ϵ�͸��ͼ��ÿ������̨��������԰���һ������͸��ͼ��ͬʱ�û�����͸��ͼ���������UI����Ԫ�ء�
Ĭ��͸��ͼ������Ϊ�̶��ģ� �����ƶ�������û�б�������
 */
public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		
		layout.addView("IntegrationTest.contacts",IPageLayout.LEFT,0.3f,layout.getEditorArea());
		
		layout.addView("IntegrationTest.FirstView", IPageLayout.RIGHT, 0.7f,layout.getEditorArea());
//		0.3f-0.7f�ǰ���Ļ���ٷֱȽ����˷��䴦��ģ�Ŀ�����ڴ���view�Ĳ����Լ���С���
//		layout.addStandaloneView("IntegrationTest.contacts",false,IPageLayout.TOP,1.0f,layout.getEditorArea());
		//�������û�о������Ǹ�ʲô��
//		layout.setFixed(true);//����ǹ̶�ס
		layout.setEditorAreaVisible(false);//�������ȥ��Ĭ�ϵ�͸��ͼ
	}
	
}



















