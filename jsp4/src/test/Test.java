package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		Map<String, String> m = new HashMap<String, String>();
		m.put("이름", "홍길동");
		m.put("나이", "33살");
		list.add(m);
		Map<String, String> m2 = new HashMap<String, String>();
		m2.put("이름", "김길동");
		m2.put("나이", "22살");
		list.add(m2);

		System.out.println(list.size());
		for (Map<String, String> m1 : list) {
			System.out.println(m1);
		}
	}
}
