package com.exact.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.conexion.MyBatisUtil;
import com.exact.bean.ReporteRecepcionBean;
import com.exact.bean.ReporteRecojoBean;
import com.exact.inteface.mapper.*;

public class ReporteRecepcionDAO implements ReporteRecepcionMapper {

	public List<ReporteRecepcionBean> GetReporteRecepcion(Date date,int iProveedor) throws Exception {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		ReporteRecepcionMapper recojo = session.getMapper(ReporteRecepcionMapper.class);
		List<ReporteRecepcionBean> lRecojoBean = recojo.GetReporteRecepcion(date,iProveedor);
		session.close();
		return lRecojoBean;
	}

}
