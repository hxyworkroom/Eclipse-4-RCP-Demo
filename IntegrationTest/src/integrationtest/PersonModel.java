package integrationtest;

import java.util.ArrayList;
/**
这个类就是我们构建的标签模型
将这个模型封装成一个对象
具体表现是一个list形式
 */
public class PersonModel {
	private ArrayList<Person> list = new ArrayList<Person>();
	
	public interface Listener{
		public void add(Person p);
		public void remove(Person p);
	}
	
	private Listener listener;
	
	public PersonModel(){
		//向list里面填入几个初始化数据
		Person p1 = new Person();
		p1.setName("病人1");
		p1.setSex("男");
		list.add(p1);

		Person p2 = new Person();
		p2.setName("病人2");
		p2.setSex("女");
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
