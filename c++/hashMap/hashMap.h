#pragma once 

template<typename k,typename v>
class hashNode
{
public:
	hashNode(const k _key,const v _value)
		:m_key(_key)
		, m_value(_value)
		, next(NULL){}
	k getKey()
	{
		return m_key;
	}
	v getValue()
	{
		return m_value;
	}
	hashNode* getNext()
	{
		return m_next;
	}
	void setValue(v _value)
	{
		m_value = _value;
	}
	void setNext(hashNode* _next)
	{
		m_next = _next;
	}

private:
	k m_key;
	v m_value;
	hashNode* m_next;
};


template <typename k,size_t tableSize>
struct keyHash
{
	unsigned long operator(k _key){
		return (unsigned long)(k) % tableSize;
	}
};

template <typename k,typename v,size_t tableSize,typename F = keyHash<k,tableSize>>
class hashMap
{
public:
	hashMap : m_table(), m_hashFunc(){}
	~hashMap()
	{
		for (size_t i = 0; i < tabelSize;++i)
		{
			hashNode<k, v>* node = m_table[i];
			while (node!=nullptr)
			{
				hashNode<k, v>* pre = node;
				node = node->getNext();
				delete pre;
			}
			m_table[i] = nullptr;
		}
	}
	bool get(k _key,v& _value)
	{
		unsigned long hashKeyValue = keyHash(_key);
		hashNode<k, v>* node = hashMap[hashKeyValue];
		while (node!=nullptr)
		{
			if (node->getKey() == _key)
			{
				_value = node->getValue();
				return true;
			}
			node = node->getNext();

		}
		return false;
	}
	void put(k _key,v _value)
	{
		unsigned long hashKeyValue = keyHash(_key);
		hashNode<k, v>* pre = nullptr;
		hashNode<k, v>* node = m_table[hashKeyValue];
		while (node!=nullptr&& node->getKey()!=_key)
		{
			pre = node;
			node = node->getNext();
		}
		if (node != nullptr)
		{
			node = new hashNode<k, v>(_key, _value);
			if (pre == nullptr) m_table[hashKeyValue] = node;
			else pre->setNext(node);
		}
		else
			node->setValue(_value);
	}
	void remove(k _key)
	{
		unsigned long hashKeyValue = keyHash(_key);
		hashNode<k, v>* pre = nullptr;
		hashNode<k, v>* node = m_table[hashKeyValue];
		while (node != nullptr)
		{
			pre = node;
			node = node->getNext();
		}
		if (node == nullptr)return;
		else
		{
			if (pre == nullptr)
			{
				m_table[hashKeyValue] = node->getNext();
			}
			else
			{
				pre->setNext(node->getNext());
			}
			delete node;
		}
	}
private:
	hashNode<k, v>* m_table[tabelSize];
	F m_hashFunc;
};