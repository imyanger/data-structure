package list;

public class Array<T> implements IList<T>{
	
	// 存放array数据
	private T[] data;

	// 长度
	private int size;
	
	// 无参构造
	public Array(){}

	// 有长度的初始化
	public Array(int capacity){
		this.data = (T[]) new Object[capacity];
		this.size = capacity;
	}

	@Override
	public void add(T data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(int index, T data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}
}
