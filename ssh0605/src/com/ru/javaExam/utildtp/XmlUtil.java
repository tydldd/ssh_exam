/*
package com.ru.javaExam.utildtp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.topwalk.dtpser.netconfig.bean.CommonBean;
import com.topwalk.dtpser.netconfig.bean.NetConfigBean;


public class XmlUtil {
	*/
/**
	 * 如果文件不存在则创建xml文档
	 * 
	 * @param filepath
	 *            文件路径
	 *//*

	public static int createXMLFile(String filepath, NetConfigBean bean) {
		Document document = DocumentHelper.createDocument();
		File file = new File(filepath);// 根据路径创建一个file对象
		// 如果文件不存在
		if (!file.exists()) {
			Element root = document.addElement("netConfig");
			Element type = root.addElement(bean.getType());
			Element eth = type.addElement(bean.getCardName());
			Element ip = eth.addElement(bean.getCardName() + "ip0");
			Element netMask = eth.addElement(bean.getCardName() + "netMask0");
			ip.setText(bean.getIp());
			netMask.setText(bean.getNetMask());
			save(document, filepath);
		} else {
			int size = 0;
			SAXReader sr = new SAXReader();
			try {
				// 根据路径得到xml文档
				document = sr.read(new File(filepath));
				// 获取根节点
				Element root = document.getRootElement();
				// 根据类型获取是uas节点还是tas节点
				Element type = root.element(bean.getType());
				// 判断类型节点是否存在
				if (type != null) {
					// 取类型节点下网卡节点
					Element eth = type.element(bean.getCardName());
					// 如果存在网卡节点
					if (eth != null) {
						List list = eth.elements();
						// 如果网卡节点存在子节点
						if (list.size() > 0) {
							// 该值除于2为该网卡下的总节点数
							size = list.size();
						}
						Element ethNode = (Element) document
								.selectSingleNode("/netConfig/"
										+ bean.getType() + "/"
										+ bean.getCardName());
						// 如果单个网卡下的IP和掩码数量不超过10个
						if (!(size / 2 >= 10)) {
							List list1 = ethNode.elements();
							for (int i = 0; i < list.size(); i += 2) {
								Element tmp = (Element) list.get(i);
								if (tmp.getText().equals(bean.getIp())) {
									System.out.println("存在相同的IP地址");
									return 2;
								}
							}
							Element ipNode = ethNode.addElement(ethNode
									.getName()
									+ "ip" + (size / 2));
							Element maskNode = ethNode.addElement(eth.getName()
									+ "netMask" + (size / 2));
							ipNode.setText(bean.getIp());
							maskNode.setText(bean.getNetMask());
							save(document, filepath);
						}else{
							System.out.println("单个网卡下的节点组数超过了10组.");
							return 1;
						}
					}else{
						//如果网卡节点不存在
						Element typeNode = (Element)document.selectSingleNode("/netConfig/"+bean.getType());
						Element ethtmp = typeNode.addElement(bean.getCardName());
						Element iptmp = ethtmp.addElement(bean.getCardName()+"ip0");
						Element masktmp = ethtmp.addElement(bean.getCardName()+"netMask0");
						iptmp.setText(bean.getIp());
						masktmp.setText(bean.getNetMask());
						save(document,filepath);
					}
				}else{
					//如果类型节点(tas,uas)不存在,则创建相关节点
					Element typetmp = root.addElement(bean.getType());
					Element ethtemp = typetmp.addElement(bean.getCardName());
					Element iptemp = ethtemp.addElement(bean.getCardName()+"ip0");
					Element masktemp = ethtemp.addElement(bean.getCardName()+"netMask0");
					iptemp.setText(bean.getIp());
					masktemp.setText(bean.getNetMask());
					save(document,filepath);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	*/
/**
	 * 保存xml文件
	 * 
	 * @param doc
	 * @param path
	 *//*

	private static void save(Document doc, String path) {
		XMLWriter xmlWriter = null;
		OutputFormat format = null;
		try {
			format = OutputFormat.createPrettyPrint();
			format.setEncoding("UTF-8");
			xmlWriter = new XMLWriter(new FileOutputStream(path), format);
			xmlWriter.write(doc);

			xmlWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("保存 xml 文件异常.");
		}
	}
	*/
/**
	 * 根据文件路径,以及网卡来查询相关节点下值
	 * @param filepath 文件路径
	 * @param eth 网卡节点名称
	 * @return
	 * @throws Exception
	 *//*

	public static List<NetConfigBean> findNetUasList(String eth, String filepath) throws Exception {
		Document doc = DocumentHelper.createDocument();
		//根据路径得到文件
		File file = new File(filepath);
		if(!file.exists()){
			return null;
		}
		List<NetConfigBean> list = new ArrayList<NetConfigBean>();
		SAXReader sr = new SAXReader();
		doc = sr.read(file);
		//获取指定节点
		Element ethNode = (Element)doc.selectSingleNode("/netConfig/uas/"+eth);
		if(ethNode != null){
			List childList = ethNode.elements();
			for(int i = 0; i < childList.size(); i ++){
				NetConfigBean bean = new NetConfigBean();
				Element e = (Element)childList.get(i);
				if(e.getName().substring(0, 9).equals(eth+"ip")){
					bean.setIpNodeName(e.getName());
					bean.setIp(e.getText());
				}else{
					bean.setNetMaskNodeName(e.getName());
					bean.setNetMask(e.getText());
				}
				list.add(bean);
			}
		}else{
			return null;
		}
		for(NetConfigBean n : list){
			System.out.println(n.getIp()+"\t"+n.getNetMask());
		}
		return list;
	}
	*/
/**
	 * 根据文件路径,以及网卡来查询相关节点下值
	 * @param filepath 文件路径
	 * @param eth 网卡节点名称
	 * @return
	 * @throws Exception
	 *//*

	public static List<NetConfigBean> findNetTasList(String eth, String filepath) throws Exception {
		Document doc = DocumentHelper.createDocument();
		//根据路径得到文件
		File file = new File(filepath);
		if(!file.exists()){
			return null;
		}
		List<NetConfigBean> list = new ArrayList<NetConfigBean>();
		SAXReader sr = new SAXReader();
		doc = sr.read(file);
		//获取指定节点
		Element ethNode = (Element)doc.selectSingleNode("/netConfig/tas/"+eth);
		if(ethNode != null){
			List childList = ethNode.elements();
			for(int i = 0; i < childList.size(); i ++){
				NetConfigBean bean = new NetConfigBean();
				Element e = (Element)childList.get(i);
				if(e.getName().substring(0, 9).equals(eth+"ip")){
					bean.setIpNodeName(e.getName());
					bean.setIp(e.getText());
				}else{
					bean.setNetMaskNodeName(e.getName());
					bean.setNetMask(e.getText());
				}
				list.add(bean);
			}
		}else{
			return null;
		}
		for(NetConfigBean n : list){
			System.out.println(n.getIp()+"\t"+n.getNetMask());
		}
		return list;
	}
	*/
/**
	 * 查询通用配置节点信息
	 * @param filePath 文件路径
	 * @return
	 *//*

	public static CommonBean findCommonList(String filepath){
		Document doc = DocumentHelper.createDocument();
		File f = new File(filepath);
		if(!f.exists()){
			return null;
		}
		CommonBean cb = new CommonBean();
		String gateway = "";
		String primaryDNS = "";
		String aidDNS = "";
		String timeServer = "";
		try {
			SAXReader sr = new SAXReader();
			doc = sr.read(f);
			Element e = (Element)doc.selectSingleNode("/common/commonConfig");
			if(e != null){
				List list = e.elements();
				for(int i = 0; i < list.size(); i ++){
					Element childNode = (Element)list.get(i);
					if(childNode.getName().equals("gateWay")){
						gateway = childNode.getText();
					}else if(childNode.getName().equals("primaryDNS")){
						primaryDNS = childNode.getText();
					}else if(childNode.getName().equals("aidDNS")){
						aidDNS = childNode.getText();
					}else if(childNode.getName().equals("timeServer")){
						timeServer = childNode.getText();
					}
					cb.setDefaultGateWay(gateway);
					cb.setPrimaryDNS(primaryDNS);
					cb.setAidDNS(aidDNS);
					cb.setTimeServer(timeServer);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cb;
	}
	*/
/**
	 * 添加/修改共用配置的方法,如果文件存在则修改,否则创建文件并添加数据
	 * @param filePath 文件路径
	 * @param bean 实体类对象
	 * @throws Exception
	 *//*

	public static void saveOrUpdate(String filepath, CommonBean bean) throws Exception{
		Document doc = DocumentHelper.createDocument();
		File file = new File(filepath);
		if(!file.exists()){
			Element root = doc.addElement("common");
			Element commonNode = root.addElement("commonConfig");
			Element gateway = commonNode.addElement("gateWay");
			Element dns = commonNode.addElement("primaryDNS");
			Element adns = commonNode.addElement("aidDNS");
			Element tserver = commonNode.addElement("timeServer");
			gateway.setText(bean.getDefaultGateWay());
			dns.setText(bean.getPrimaryDNS());
			adns.setText(bean.getAidDNS());
			tserver.setText(bean.getTimeServer());
			save(doc, filepath);
		}else{
			SAXReader sr = new SAXReader();
			doc = sr.read(file);
			Element gateway = (Element)doc.selectSingleNode("/common/commonConfig/gateWay");
			Element dns = (Element)doc.selectSingleNode("/common/commonConfig/primaryDNS");
			Element adns = (Element)doc.selectSingleNode("/common/commonConfig/aidDNS");
			Element ts = (Element)doc.selectSingleNode("/common/commonConfig/timeServer");
			gateway.setText(bean.getDefaultGateWay());
			dns.setText(bean.getPrimaryDNS());
			adns.setText(bean.getAidDNS());
			ts.setText(bean.getTimeServer());
			save(doc, filepath);
		}
	}
	*/
/**
	 * 删除节点
	 * @param filePath 文件路径
	 * @param bean 类实体对象
	 * @throws Exception
	 *//*

	public static void deleteNode(String filepath,NetConfigBean bean ) throws Exception{
		File file = new File(filepath);
		if(file.exists()){
			SAXReader sr = new SAXReader();
			Document doc = sr.read(file);
			Element tempNode = (Element)doc.selectSingleNode("/netConfig/"+bean.getType()+"/"+bean.getCardName());
			if(tempNode != null){
				List list = tempNode.elements();
				if(list != null && list.size() > 0){
					for(int i = 0; i < list.size(); i ++){
						Element e = (Element)list.get(i);
						if(e.getName().equals(bean.getIpNodeName()) || e.getName().equals(bean.getNetMaskNodeName())){
							e.detach();
						}
					}
				}
				save(doc, filepath);
				//重新生成被删除节点的父节点下的所有子节点,放置再次添加重名导致解析失败
				refreshXML(filepath, bean, doc);
			}else{
				throw new Exception("指定的节点不存在");
			}
		}
	}
	*/
/**
	 * 根据文件路径,实体类对象和document对象重新读取指定节点下的所有子节点
	 * 将节点删除后重新创建,避免动态产生的节点名重复,导致解析错误
	 * @param filepath 文件路径
	 * @param bean 实体类对象
	 * @param doc document对象
	 * @throws Exception
	 *//*

	private static void refreshXML(String filepath,NetConfigBean bean,Document doc) throws Exception{
		File file = new File(filepath);
		int nodeSize = 0;
		if(file.exists()){
			int ipflag = 0;
			int maskflag = 0;
			Element node = (Element)doc.selectSingleNode("/netConfig/"+bean.getType()+"/"+bean.getCardName());
			if(node != null){
				List list = node.elements();
				if(list != null && list.size() > 0){
					nodeSize = list.size();
					for(int i = 0; i < nodeSize; i ++){
						Element tempNode = (Element)list.get(i);
						if(tempNode.getName().substring(0,9).equals(bean.getCardName()+"ip")){
							String ipVal = tempNode.getText();
							tempNode.detach();
							Element ipNode = node.addElement(bean.getCardName()+"ip"+ipflag);
							ipNode.setText(ipVal);
							ipflag++;
						}else{
							String maskVal = tempNode.getText();
							tempNode.detach();
							Element ipNode = node.addElement(bean.getCardName()+"netMask"+maskflag);
							ipNode.setText(maskVal);
							maskflag++;
						}
					}
				}
				save(doc, filepath);
			}else{
				throw new Exception("指定的节点不存在");
			}
		}
	}
	*/
/**
	 * 修改xml文件节点
	 * @param filePath 文件路径
	 * @param bean 实体类对象
	 *//*

	public static void modifyXML(String filepath,NetConfigBean bean) {
		Document doc = DocumentHelper.createDocument();
		File file = new File(filepath);
		SAXReader sr = new SAXReader();
		try {
			doc = sr.read(file);
			Element tempNode = (Element)doc.selectSingleNode("/netConfig/"+bean.getType()+"/"+bean.getCardName());
			if(tempNode != null){
				List list = tempNode.elements();
				if(list != null && list.size() > 0){
					for(int i = 0; i < list.size(); i ++){
						Element e = (Element)list.get(i);
						if(e.getName().equals(bean.getIpNodeName())){
							e.setText(bean.getIp());
						}else if(e.getName().equals(bean.getNetMaskNodeName())){
							e.setText(bean.getNetMask());
						}
					}
					save(doc, filepath);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception{
//		String filepath = "d:\\netConfig.xml";
//		NetConfigBean bean = new NetConfigBean();
//		bean.setType("uas");
//		bean.setCardName("uaseth0");
//		bean.setIp("192.168.7.152");
//		bean.setNetMask("255.255.240.0");
//		new XmlUtil1().createXMLFile(filepath, bean);
		//new XmlUtil().findNetUasList("uaseth0", "d:\\netConfig.xml");
//		CommonBean cb = new XmlUtil().findCommonList("e:\\dtp\\conf\\sys\\commonConfig.xml");
//		System.out.println(cb.getDefaultGateWay());
//		System.out.println(cb.getAidDNS());
//		System.out.println(cb.getPrimaryDNS());
//		System.out.println(cb.getTimeServer());
//		NetConfigBean n = new NetConfigBean();
//		n.setType("uas");
//		n.setCardName("uaseth0");
//		n.setIpNodeName("uaseth0ip1");
//		n.setNetMaskNodeName("uaseth0netMask1");
//		n.setIp("1.1.1.1");
//		n.setNetMask("2.2.2.2");
//		new XmlUtil().modifyXML("d:\\netConfig.xml", n);
	}
}
*/
