package com.qinshi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;

/**
 * 两个List不管有多少个重复，只要重复的元素在两个List都能找到，则不应该包含在返回值里面，所以在做第二次循环时，
 * 这样判断：如果当前元素在map中找不到，则肯定需要添加到返回值中，如果能找到则value++，遍历完之后diff里面已
 * 经包含了只在list2里而没在list2里的元素，剩下的工作就是找到list1里有list2里没有的元素，遍历map取value为1的即可：
 * 
 * @author qiaodongjie
 * @date 2018年12月24日 下午2:54:58
 *
 */
public class CompareCitys2 {
	public static void main(String[] args) throws JSONException {
		List<String> list1 = JsonToMap.getStrings();// 4000
		// 'EWH':{'station':'定远','city':'滁州','geo':'32.261271,118.339406','cityCode':'0808','proviceCode':'34','proviceName':'安徽','burCode':'H'}
		List<String> list2 = LoadCityJsJson2.getCityCodeAndName();// 2000
		List<String> list = getAddaListThanbList(list2, list1);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			Map<String, String> map = new HashMap<String, String>();
			map.put(list.get(i), "");
		}

		// 验证总数是否一致 4537
		/*
		 * List<String> listsss = new ArrayList<>(); listsss.addAll(list2);
		 * listsss.addAll(list1); List<String> collect =
		 * listsss.stream().distinct().collect(Collectors.toList());
		 * System.out.println(collect.size());
		 */

	}

	/**
	 * 计算列表aList相对于bList的增加的情况，兼容任何类型元素的列表数据结构
	 * 
	 * @param aList
	 *            本列表
	 * @param bList
	 *            对照列表
	 * @return 返回增加的元素组成的列表
	 */
	public static <E> List<E> getAddaListThanbList(List<E> aList, List<E> bList) {
		List<E> addList = new ArrayList<E>();
		for (int i = 0; i < aList.size(); i++) {
			if (!myListContains(bList, aList.get(i))) {
				addList.add(aList.get(i));
			}
		}
		return addList;
	}

	private static <E> boolean myListContains(List<E> sourceList, E element) {
		if (sourceList == null || element == null) {
			return false;
		}
		if (sourceList.isEmpty()) {
			return false;
		}
		for (E tip : sourceList) {
			if (element.equals(tip)) {
				return true;
			}
		}
		return false;
	}
}
