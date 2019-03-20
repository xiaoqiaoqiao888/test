package com.mianshi;

/**
 * 编译期和运行期不一样，
 * 
 * @author qiaodongjie
 * @date 2019年3月19日 上午9:06:52
 *
 */
public class StringAND {
	public static void main(String[] args) {
		String a = "hello";
		// 下面这一行代码创建了一个对象
		String b = new String("hello");
		System.out.println(a + b);
		// "hello"这个字符串，在创建对象之前，就在常量池中已经存在了：
		// (1）那么第一行代码String a = "hello";就是在常量池中创建了值为"hello"的对象，我们讨论的是第二行代码。
		// (2）在第二行代码String b = new
		// String("hello");是在堆里面创建了一个对象，引用b指向这个对象，而常量池中有值为"hello"这个对象，然后引用b指向的对象（new
		// String("hello")）的成员变量char数组value[]指向常量池值为"hello"这个对象就行了，它就创建了一个对象new
		// String("hello")。

		// 下面这一行代码创建了两个对象
		String b1 = new String("hello");
		String a1 = "hello";
		System.out.println(a1 + b1);
		// "hello"这个字符串，创建对象之前，在常量池中不存在：
		// (1）第一行代码String b = new
		// String("hello");是在堆里面创建了一个对象，引用b指向这个对象，然后发现常量池没有值为hello的对象，于是进行创建，然后将这个String对象成员变量char数组value[]，指向值为"hello"这个对象，这里一行代码就创建了两个对象。
		// (2）然后第二行代码String a = "hello";直接将引用指向常量池中，值为"hello"的对象就行了。
	}
}
