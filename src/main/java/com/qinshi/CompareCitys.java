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
public class CompareCitys {
	public static void main(String[] args) throws JSONException {
		List<String> list1 = JsonToMap.getStrings();// 4000

		List<String> list2 = LoadCityJsJson2.getCityCodeAndName();// 2000

		List<String> diffrent4 = getDiffrent4(list1, list2);
		for (int i = 0; i < diffrent4.size(); i++) {
			System.out.println(diffrent4.get(i));
		}
		System.out.println(diffrent4.size());
	}

	public static List<String> getDiffrent4(List<String> list1, List<String> list2) {
		Map<String, Integer> map = new HashMap<String, Integer>(list1.size());
		// Map<String, Integer> map = new HashMap<String, Integer>(list1.size() +
		// list2.size());
		List<String> diff = new ArrayList<String>();
		List<String> maxList = list1;
		List<String> minList = list2;
		// 也可以删除一下代码做成list1比list2多出多少数据
		// if (list2.size() > list1.size()) {
		// maxList = list2;
		// minList = list1;
		// }

		for (String string : maxList) {
			map.put(string, 1);
		}

		for (String string : minList) {
			Integer cc = map.get(string);
			if (cc != null) {
				map.put(string, ++cc);
				continue;
			}
			map.put(string, 1);
		}

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				diff.add(entry.getKey());
			}
		}
		return diff;
	}
}
