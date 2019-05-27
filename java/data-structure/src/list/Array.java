package list;

import java.util.ArrayList;

public class Array<T> implements IList<T> {

	// 空的实际数据长度
	private final int EMPTY_COUNT = 0;
	
	// 默认初始长度
	private final int DEFAULT_SIZE = 10;

	// 存放array数据
	private T[] datas;

	// 长度
	private int size;

	// 实际数据的个数
	private int count;

	// 无参构造
	public Array() {
		init();
	}

	// 有长度的初始化
	public Array(int capacity) {
		this.datas = (T[]) new Object[capacity];
		this.size = capacity;
		this.count = EMPTY_COUNT;
	}

	/**
	 * @describe 添加元素
	 * @author Yanger
	 * @param data
	 */
	@Override
	public void add(T data) {
		if (count == size) {
			reset();
		}
		datas[count] = data;
		count++;
	}

	/**
	 * @describe 在指定位置插入
	 * @author Yanger
	 * @param index
	 * @param data
	 */
	@Override
	public void add(int index, T data) {
		if(index < 0 || index > size -1){
			throw new RuntimeException("插入位置越界");
		}else if (count == size) {
			reset();
		}
		T[] newDatas = (T[]) new Object[size];
		count++;
		for (int i = 0; i < count; i++) {
			if(i < index){
				newDatas[i] = datas[i];
			}else if(i == index){
				newDatas[i] = data;
			}else {
				newDatas[i] = datas[i - 1];
			}
		}
		this.datas = newDatas;
	}

	/**
	 * @describe 删除指定位置的数据
	 * @author Yanger
	 * @param index
	 */
	@Override
	public void remove(int index) {
		if(index < 0 || index > size -1){
			throw new RuntimeException("插入位置越界");
		}
		T[] newDatas = (T[]) new Object[size];
		for (int i = 0; i < count; i++) {
			if(i < index){
				newDatas[i] = datas[i];
			}else if(i > index && i < count){
				newDatas[i - 1] = datas[i];
			}
		}
		count --;
		this.datas = newDatas;
	}

	/**
	 * @describe 删除全部
	 * @author Yanger
	 */
	@Override
	public void removeAll() {
		init();
	}

	/**
	 * @describe 获取指定位置的元素
	 * @author Yanger
	 * @param index
	 * @return
	 */
	@Override
	public T get(int index) {
		if(index < 0 || index > size -1){
			throw new RuntimeException("插入位置越界");
		}
		return datas[index];
	}
	
	/**
	 * @describe 修改指定位置元素
	 * @author Yanger
	 * @param index
	 * @param data
	 */
	public void set(int index, T data){
		if(index < 0 || index > size -1){
			throw new RuntimeException("插入位置越界");
		}
		datas[index] = data;
	}
	
	/**
	 * @describe 获取集合实际大小
	 * @author Yanger
	 * @return
	 */
	public int size(){
		return count;
	}

	/**
	 * @describe 初始化空集合
	 * @author Yanger
	 */
	private void init(){
		this.count = EMPTY_COUNT;
		this.size = DEFAULT_SIZE;
		this.datas = (T[]) new Object[DEFAULT_SIZE];
	}
	
	/**
	 * @describe 进行扩容
	 * @author Yanger
	 */
	private void reset() {
		size += size / 2;
		T[] newDatas = (T[]) new Object[size];
		for (int i = 0; i < datas.length; i++) {
			newDatas[i] = datas[i];
		}
		this.datas = newDatas;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("空间大小size：").append(size).append(",").append("实际长度count:").append(count).append("\r\n");
		for (int i = 0; i < count; i++) {
			T t = datas[i];
			sb.append("位置index：").append(i).append("，值：").append(t.toString()).append("\r\n");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Array<String> as = new Array<>(2);
		as.add("1");
		as.add("2");
		as.add("3");
		as.add("4");
		as.add("5");
		as.add("6");
		as.add("7");
		as.add("8");
		as.add("9");
		as.add("10");
		as.add("11");
		as.add("12");
		as.add(6,"6n");
		as.add(6,"6n6n");
		as.remove(2);
		//as.removeAll();
		System.out.println(as.toString());
		System.out.println("get:" + as.get(5));
		as.set(5, "55555555");
		System.out.println("get:" + as.get(5));
	}
}
