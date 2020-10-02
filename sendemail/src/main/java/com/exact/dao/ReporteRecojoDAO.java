package com.exact.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.conexion.MyBatisUtil;
import com.exact.bean.ReporteRecojoBean;
import com.exact.inteface.mapper.*;

public class ReporteRecojoDAO implements ReporteRecojoMapper {

	public List<ReporteRecojoBean> GetReporte() throws Exception {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		ReporteRecojoMapper recojo = session.getMapper(ReporteRecojoMapper.class);
		List<ReporteRecojoBean> lRecojoBean = recojo.GetReporte();
		session.close();
		return lRecojoBean;
	}

}
