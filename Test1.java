package com.neusoft.test1;

import day0919.neusoft.demo09.Employee;

import java.io.*;
import java.util.*;
//题目1：合并集合数据（50分）
//com.neusoft.test1包下的data.txt中保存了某公司办公用品的采购记录
//每一行都是某项办公用品单次的采购记录，其格式：“办公用品:采购量”，可以确定这些记录的格式都是正确的。
//比如
//    日记本:60
//    中性笔:100
//其中某些办公用品可能采购了多次
//    中性笔:150
//    中性笔:200
//现在需要将这些采购记录整理合并，多次采购记录汇总求和，并按总采购量降序排序显示，请完成Test1类缺少的功能
//当前测试用例的结果预期为:[中性笔:570, 日记本:160, 5号电池:40, A4打印纸:30]
//编码过程中允许在com.neusoft.test1包中新建类，方法和文件
//可能用到的API： 字符串分隔方法，String的split方法
public class Test1 {

	public static void main(String[] args) {
		//读取文件中的数据
		List<String> orglist = readDataTxt();
		System.out.println(orglist);
		//处理数据合并
		Map<String,Integer> map =  new TreeMap<>();
		String[] s1;



		for(int i = 0; i < orglist.size(); i++){
			String d = orglist.get(i);
			 s1 =  d.split(":");


			 if(!map.containsKey(s1[0])){
				 map.put(s1[0], Integer.parseInt(s1[1]));
			 }else if(map.containsKey(s1[0])){
				 int v =  map.get(s1[0])+Integer.parseInt(s1[1]);
				 map.put(s1[0],v);

			 }


		}
		List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());




		Collections.reverse(list);
		String s11 =list.toString();

		String newStr = s11.replaceAll("=", ":");




		Set<Map.Entry<String, Integer>> es = map.entrySet();

		Set set = new TreeSet<>();
		for(Map.Entry<String, Integer> e : es){
			String key = e.getKey();
			Integer value = e.getValue();


		}

		List<String> resList = merageData(orglist);
		//显示结果
		System.out.println(newStr);
	}

	/**
	 * 将输入list的相同数据进行合并，并按合并后数据量的大小降序排序，返回合并后的结果
	 * @param orglist
	 * @return
	 */
	public static List<String> merageData(List<String> orglist){
		//实现这个方法
		List<String> resList = new ArrayList<String>();




		return resList;
	}

	/**
	 * 读取data.txt文件
	 * @return
	 */
	public static List<String> readDataTxt(){
		List<String> list = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new InputStreamReader(Test1.class.getResourceAsStream("data.txt")))){
			String line = br.readLine();
			while(line != null){
				list.add(line);
				line = br.readLine();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
