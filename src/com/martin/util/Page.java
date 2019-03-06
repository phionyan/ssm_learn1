package com.martin.util;

public class Page {
	
	protected int start = 0;
	protected int count = 5;//一页放五条数据
	protected int last = 0;
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		//设置最小页码为0
		if(start>=0)
			this.start = start;
		else
			this.start=0;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getLast() {
		return last;
	}
	public void setLast(int last) {
		this.last = last;
	}
	
	public void caculateLast(int total) {
		// 假设总数是50，是能够被5整除的，那么最后一页的开始就是45
        if (0 == total % count)
            last = total - count;
        // 假设总数是51，不能够被5整除的，那么最后一页的开始就是50
        else
            last = total - total % count;   
	}
	
	@Override
	public String toString() {
		return "start:"+start+"   count:"+count;
	}
	
}
