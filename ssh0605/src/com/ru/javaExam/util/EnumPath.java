package com.ru.javaExam.util;

import org.apache.poi.util.SystemOutLogger;

/**
 * Description:
 * User: NanChengRu
 * Date: 13-11-11
 * Time: 下午2:12
 * JDK: 1.6
 * version: 1.0
 */
public enum EnumPath {
    LOG4J("G:/intelliJ-workspace/ssh0605/ssh0605/WebRoot/WEB-INF/log4j.properties");

    private String path;

    /**
     *        构造函数*
     * @param path
     */
    private EnumPath(String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public static void main(String[] args){
        String path = EnumPath.LOG4J.getPath();
        System.out.println(path);
    }
}
