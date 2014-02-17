/**
 * 文件名：affaf.java
 *
 * 版本信息：
 * 日期：2013年10月31日
 * Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.io;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：加密解密文件
 * 创建人：成如
 * 创建时间：2013年10月31日 下午5:09:02
 * 修改人：成如
 * 修改时间：2013年10月31日 下午5:09:02
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.OutputStream;  
import java.security.SecureRandom;  
import java.security.Security;  
import javax.crypto.Cipher;  
import javax.crypto.CipherInputStream;  
import javax.crypto.CipherOutputStream;  
import javax.crypto.KeyGenerator;  
import javax.crypto.SecretKey;  
import javax.crypto.SecretKeyFactory;  
import javax.crypto.spec.DESKeySpec;  
import javax.crypto.spec.SecretKeySpec;  
  
public class CipherExam {  
    private static String Algorithm = "DES"; // 定义 加密算法,可用AES(key为18位),DES（8位）,DESede,Blowfish  
  
    /*static {  
        Security.addProvider(new com.sun.crypto.provider.SunJCE());  
    }*/  
  
    // 生成密钥, 注意此步骤时间比较长  
    /*public static byte[] getKey() throws Exception {  
        KeyGenerator keygen = KeyGenerator.getInstance(Algorithm);  
        SecretKey deskey = keygen.generateKey();  
        return deskey.getEncoded();  
    }*/  
  
    /** 
     * 加密 
     *  
     * @param enfile 
     *            要加密的文件 
     * @param defile 
     *            加密后的文件 
     * @param key 
     *            密码
     * @throws Exception 
     */  
    public static void encode(String enfile, String defile, byte[] key)  
            throws Exception {  
        // 秘密（对称）密钥(SecretKey继承(key)) 
        // 根据给定的字节数组构造一个密钥。  
        SecretKey deskey = new SecretKeySpec(key, Algorithm);  
        // 生成一个实现指定转换的 Cipher 对象。Cipher对象实际完成加解密操作  
        Cipher c = Cipher.getInstance(Algorithm);  
        // 用密钥初始化此 cipher  
        c.init(Cipher.ENCRYPT_MODE, deskey);  
  
        byte[] buffer = new byte[1024];  
        FileInputStream in = new FileInputStream(enfile);  
        OutputStream out = new FileOutputStream(defile);  
           
        CipherInputStream cin = new CipherInputStream(in, c);  
        int i;  
        while ((i = cin.read(buffer)) != -1) {  
            out.write(buffer, 0, i);  
        }  
        out.close();  
        cin.close();  
    }  
  
    // 解密  
    public static void decode(String file, String defile, byte[] key)  
            throws Exception {  
  
        // DES算法要求有一个可信任的随机数源  
        SecureRandom sr = new SecureRandom();  
        // 创建一个 DESKeySpec 对象,指定一个 DES 密钥  
        DESKeySpec ks = new DESKeySpec(key);  
        // 生成指定秘密密钥算法的 SecretKeyFactory 对象。  
        SecretKeyFactory factroy = SecretKeyFactory.getInstance(Algorithm);  
        // 根据提供的密钥规范（密钥材料）生成 SecretKey 对象,利用密钥工厂把DESKeySpec转换成一个SecretKey对象  
        SecretKey sk = factroy.generateSecret(ks);  
        // 生成一个实现指定转换的 Cipher 对象。Cipher对象实际完成加解密操作  
        Cipher c = Cipher.getInstance(Algorithm);  
        // 用密钥和随机源初始化此 cipher  
        c.init(Cipher.DECRYPT_MODE, sk, sr);  
  
        byte[] buffer = new byte[1024];  
        FileInputStream in = new FileInputStream(file);  
        OutputStream out = new FileOutputStream(defile);  
        CipherOutputStream cout = new CipherOutputStream(out, c);  
        int i;  
        while ((i = in.read(buffer)) != -1) {  
            cout.write(buffer, 0, i);  
        }  
        cout.close();  
        in.close();  
    }  
  
    public static void main(String[] args) throws Exception {  
        byte[] key = "09823541".getBytes(); //字节数必须是8的整数倍   
        // 文件加密  
        encode("G:/test/Don`t Lie On Me.mp3", "G:/test/ru11.java", key);  
  
        // 文件解密  
        decode("G:/test/ru11.java", "G:/test/music123.mp3", key);  
    }  
}  