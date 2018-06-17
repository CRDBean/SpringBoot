package com.example.demo.MBG;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.FoodSystemApplication;
@RunWith(SpringJUnit4ClassRunner.class)  
@SpringBootTest(classes=FoodSystemApplication.class)//制定SpinrgBoot的启动类 
/**
 * MyBatis的逆向工程，不要轻易运行，否则会覆盖原来的代码
 * @author 柴火
 *
 */
public class MainGenerator {
	//成功
	
	public static void main(String[] args) throws Exception {
		   List<String> warnings = new ArrayList<String>();
		   boolean overwrite = true;
		   File configFile = new File("GeneratorXML.xml");
		   ConfigurationParser cp = new ConfigurationParser(warnings);
		   Configuration config = cp.parseConfiguration(configFile);
		   DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		   MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		   myBatisGenerator.generate(null);
		   System.out.println("123123");
	}

}
