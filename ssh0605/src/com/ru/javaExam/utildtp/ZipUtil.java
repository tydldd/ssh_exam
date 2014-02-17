package com.ru.javaExam.utildtp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;


public class ZipUtil {
	// 压缩
	public static void zip(String zipFileName, String inputFile)
			throws Exception {
		File f = new File(inputFile);
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
				zipFileName));
		zip(out, f, null);
		out.close();
	}

	public static void zip(String zipFileName, List<String> inputFile)
			throws Exception {
		Iterator<String> iterator = inputFile.iterator();
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
				zipFileName));
		for (; iterator.hasNext();) {
			File f = new File(iterator.next());
			zip(out, f, f.getName());
		}
		out.close();
	}

	private static void zip(ZipOutputStream out, File f, String base)
			throws Exception {
		if (f.isDirectory()) {
			File[] fc = f.listFiles();
			if (base != null)
				out.putNextEntry(new ZipEntry(base + "/"));
			base = (base == null ? "" : base + "/");
			for (int i = 0; i < fc.length; i++) {
				zip(out, fc[i], base + fc[i].getName());
			}
		} else {
			out.putNextEntry(new ZipEntry(base));
			if(f.exists()==false)
				f.createNewFile();			
			FileInputStream in = new FileInputStream(f);
			
			int b;
			while ((b = in.read()) != -1)
				out.write(b);
			in.close();
		}
	}

	// 解压
	public static void unzip(String zipFileName, String outputDirectory)
			throws Exception {
		ZipInputStream in = new ZipInputStream(new FileInputStream(zipFileName));
		ZipEntry z;
		while ((z = in.getNextEntry()) != null) {
			String name = z.getName();
			if (z.isDirectory()) {
				name = name.substring(0, name.length() - 1);
				File f = new File(outputDirectory + File.separator + name);
				f.mkdir();
			} else {
				File f = new File(outputDirectory + File.separator + name);
				f.createNewFile();
				FileOutputStream out = new FileOutputStream(f);
				int b;
				while ((b = in.read()) != -1)
					out.write(b);
				out.close();
			}
		}
		in.close();
	}

	public static void main(String[] args) {
		try {
			ZipUtil.zip("D:/reportDownload(6).rar", "D:/sqlback");
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
}
