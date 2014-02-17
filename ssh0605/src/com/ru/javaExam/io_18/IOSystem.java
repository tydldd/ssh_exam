package com.ru.javaExam.io_18;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class IOSystem {

	@Test
	public void test() {
		String filePath="D:\\";
		String[] fileItem;
		//�õ�һ���ļ������ļ��б�
		File files=new File(filePath);
		fileItem=files.list(new NameFileter("D.*.java"));
		for(String s:fileItem){
			System.out.println("�ļ���"+s);
		}
	}
}
