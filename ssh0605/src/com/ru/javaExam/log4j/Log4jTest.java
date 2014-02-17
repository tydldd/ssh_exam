package com.ru.javaExam.log4j;

import com.ru.javaExam.util.EnumPath;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Description:
 * User: NanChengRu
 * Date: 13-11-11
 * Time: 下午2:37
 * JDK: 1.6
 * version: 1.0
 */
public class Log4jTest {

    private static Logger log = Logger.getLogger(Log4jTest.class);

    /**
     *       加载log4j配置文件*
     */
    static{
        PropertyConfigurator.configure(EnumPath.LOG4J.getPath());
    }

}
