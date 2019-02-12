package com.rails;

public class DocFooter {
	private static DocFooter doc = new DocFooter();
	public static int a;
	public static int b = 0;

	private DocFooter() {
		a++;
		b++;
		System.out.println(b);
	}

	public static DocFooter getInstence() {
		return doc;

	}

	public static void main(String[] args) {
		DocFooter docFooter = DocFooter.getInstence();
		System.out.println(DocFooter.a);
		System.out.println(DocFooter.b);
		System.out.println(docFooter);
	}
}
