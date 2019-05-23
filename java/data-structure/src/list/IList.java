package list;

public interface IList<T> {
	
	/**
	 * @describe 添加元素（最末）
	 * @author Yanger
	 * @param data 添加的数据
	 */
	void add(T data);
	
	/**
	 * @describe 添加元素到指定位置
	 * @author Yanger
	 * @param index 添加的位置（索引）
	 * @param data 添加的数据
	 */
	void add(int index, T data);
	
	/**
	 * @describe 删除指定索引的数据
	 * @author Yanger
	 * @param index 删除数据的索引
	 */
	void remove(int index);
	
	/**
	 * @describe 删除所有数据
	 * @author Yanger
	 */
	void removeAll();
	
	/**
	 * @describe 或者指定位置的数据
	 * @author Yanger
	 * @param index 索引
	 */
	T get(int index);
	
}
