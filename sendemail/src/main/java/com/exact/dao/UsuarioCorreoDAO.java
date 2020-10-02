package com.exact.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.conexion.MyBatisUtil;
import com.exact.bean.UsuarioCorreoBean;
import com.exact.inteface.mapper.UsuarioCorreoMapper;

public class UsuarioCorreoDAO implements UsuarioCorreoMapper {

	public List<UsuarioCorreoBean> getCorreo() throws Exception {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		UsuarioCorreoMapper usuariocorreo = session.getMapper(UsuarioCorreoMapper.class);
		List<UsuarioCorreoBean> lUsuarioCorreo = usuariocorreo.getCorreo();
		return lUsuarioCorreo;
	}

}
