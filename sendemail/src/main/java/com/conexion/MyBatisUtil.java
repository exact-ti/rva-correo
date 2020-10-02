package com.conexion;

import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	protected static SqlSessionFactory FACTORY = null;

	static {
		try {
			InputStream reader = Resources.getResourceAsStream("mybatis-config.xml");
			FACTORY = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error : " + e);
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return FACTORY;
	}
}
