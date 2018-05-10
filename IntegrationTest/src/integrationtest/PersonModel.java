package integrationtest;

import java.util.ArrayList;
/**
�����������ǹ����ı�ǩģ��
�����ģ�ͷ�װ��һ������
���������һ��list��ʽ
 */
public class PersonModel {
	private ArrayList<Person> list = new ArrayList<Person>();
	
	public interface Listener{
		public void add(Person p);
		public void remove(Person p);
	}
	
	private Listener listener;
	
	public PersonModel(){
		//��list�������뼸����ʼ������
		Person p1 = new Person();
		p1.setName("����1");
		p1.setSex("��");
		list.add(p1);

		Person p2 = new Person();
		p2.setName("����2");
		p2.setSex("Ů");
		list.add(p2); 
	}
	
	public void setListener(Listener listener){
		this.listener = listener;
	}
	
	public void add(Person p){
		list.add(p);
		if(listener != null){
			listener.add(p);
		}
	}
	
	public void remove(Person p){
		list.remove(p);
		if(listener != null){
			listener.remove(p);
		}
	}
	
	public ArrayList elements(){
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
