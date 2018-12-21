package com.sdenvi.gof24.algorithm;

import java.util.LinkedList;
import java.util.List;

public class WordTrieMain {

	public static void main(String[] args) {
		test2();
	}

	public static void test1() {
		WordTrie trie = new WordTrie();

		trie.addWord("ibiyzbi");

		System.out.println("----------------------------------------");
		List<String> words = trie.searchWord("bi");
		for (String s : words) {
			System.out.println(s);
		}
	}

	public static void test2() {
		WordTrie trie = new WordTrie();
		String str = "字典树，又称前缀树或 trie 树，是一种有序树，用于保存关联数组，其中的键通常是字符串。与二叉查找树不同，键不是直接保存在节点中，而是由节点在树中的位置决定。";
		LinkedList<String> linkedList = trie.pregSplit(str);
		for (String string : linkedList) {
			trie.addWord(string);
		}

		List<String> words = trie.searchWord("中的");
		for (String s : words) {
			System.out.println(s);
		}
	}

	public static void test() {
		WordTrie trie = new WordTrie();
		trie.addWord("abi");
		trie.addWord("ai");
		trie.addWord("aqi");
		trie.addWord("biiiyou");
		trie.addWord("dqdi");
		trie.addWord("ji");
		trie.addWord("li");
		trie.addWord("liqing");
		trie.addWord("liqq");
		trie.addWord("liqqq");
		trie.addWord("qi");
		trie.addWord("qibi");
		trie.addWord("i");
		trie.addWord("ibiyzbi");
		List<String> list = trie.prefixSearchWord("li");
		for (String s : list) {
			System.out.println(s);
		}
		System.out.println("----------------------------------------");
		List<String> li = trie.searchWord("i");
		for (String s : li) {
			System.out.println(s);
		}
		System.out.println("----------------------------------------");
		List<String> words = trie.searchWord("bi");
		for (String s : words) {
			System.out.println(s);
		}

		System.out.println("----------------------------------------");
		List<String> lst = trie.searchWord("q");
		for (String s : lst) {
			System.out.println(s);
		}

	}
}