package com.exact.inteface.mapper;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.exact.bean.ReporteRecepcionBean;

public interface ReporteRecepcionMapper {

	List<ReporteRecepcionBean> GetReporteRecepcion(@Param("date") Date date, @Param("idProveedor") int idProveedor)
			throws Exception;
}
