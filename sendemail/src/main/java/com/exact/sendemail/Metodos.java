package com.exact.sendemail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;

import com.exact.bean.ReporteRecepcionBean;
import com.exact.bean.ReporteRecojoBean;
import com.exact.bean.UsuarioCorreoBean;
import com.exact.dao.ReporteRecepcionDAO;
import com.exact.dao.ReporteRecojoDAO;
import com.exact.dao.UsuarioCorreoDAO;

public class Metodos {

	private static List<UsuarioCorreoBean> lUsuarioCorreo = null;

	public static String ObtenerFirma(String email) {
		return "<p style='font-family: 'Arial';font-size: 8.5px'>Por favor, no respondas directamente a este correo electrónico. Este mensaje fue enviado desde una cuenta exclusiva de notificaciones que no admite respuestas.</p><p style='font-family: 'Arial';font-size: 8.5px'>Si tienes alguna consulta comunícate con el buzón <a href='mailto:"+email+"'>"+ email +"</a></p>";
	}

	private static String detalleHtmlRecojoTransportista(List<ReporteRecojoBean> lista) {
		String contenido = "<tr>";
		String fila = "";
		for (ReporteRecojoBean rec : lista) {
			fila += "<tr>"
					+ "<td style='border: 1px solid rgb(117,113,113);padding: 5px 5px;background-color: #fff;color:rgb(64,64,64)'>"
					+ rec.getCodigoAgencia() + "</td>"
					+ "<td style='border: 1px solid rgb(117,113,113);padding: 5px 5px;background-color: #fff;color:rgb(64,64,64)'>"
					+ rec.getAgencia() + "</td>"
					+ "<td style='border: 1px solid rgb(117,113,113);padding: 5px 5px;background-color: #fff;color:rgb(64,64,64)'>"
					+ rec.getArcoInferior() + "</td>"
					+ "<td style='border: 1px solid rgb(117,113,113);padding: 5px 5px;background-color: #fff;color:rgb(64,64,64)'>"
					+ rec.getArcoSuperior() + "</td>"
					// + "<td style='border: 1px solid rgb(117,113,113);padding:
					// 5px 5px;background-color:
					// #fff;color:rgb(64,64,64)'>"+rec.getProveedor()+"</td>"
					+ "<td style='border: 1px solid rgb(117,113,113);padding: 5px 5px;background-color: #fff;color:rgb(64,64,64)'>"
					+ rec.getEstado() + "</td>"
					+ "<td style='border: 1px solid rgb(117,113,113);padding: 5px 5px;background-color: #fff;color:"
					+ rec.getCodigoIndicador() + "' !important'>" + rec.getIndicador() + "</td></tr>";
			contenido += fila;
			fila = "";
		}
		return contenido;
	}

	public static String obtenerEstructuraRecojoTransportista(List<ReporteRecojoBean> lista) {
		return "<br>" + "<h1 style='text-align: center;color:rgb(64,64,64)'>Reporte de agencias visitadas</h1>" + "<br>"
				+ "<br>" + "<div class='contenedortabla'>"
				+ "<table style='width: 65%;max-width: 100%;margin-bottom: 20px;"
				+ "background-color: transparent;border-collapse: collapse;"
				+ "border-spacing: 0;display: table;border: 1px solid rgb(117,113,113);padding: 5px 5px; margin: 0px auto' border='1'>"
				+ "<tr>"
				+ "<th style='border: 1px solid rgb(117,113,113);padding: 5px 5px;background-color: rgb(43,108,167);color:#fff;font-weight: inherit'>Código de Agencia</th>"
				+ "<th style='border: 1px solid rgb(117,113,113);padding: 5px 5px;background-color: rgb(43,108,167);color:#fff;font-weight: inherit'>Agencia</th>"
				+ "<th style='border: 1px solid rgb(117,113,113);padding: 5px 5px;background-color: rgb(43,108,167);color:#fff;font-weight: inherit'>Arco Inferior</th>"
				+ "<th style='border: 1px solid rgb(117,113,113);padding: 5px 5px;background-color: rgb(43,108,167);color:#fff;font-weight: inherit'>Arco Superior</th>"
				+ "<th style='border: 1px solid rgb(117,113,113);padding: 5px 5px;background-color: rgb(43,108,167);color:#fff;font-weight: inherit'>Estado</th>"
				+ "<th style='border: 1px solid rgb(117,113,113);padding: 5px 5px;background-color: rgb(43,108,167);color:#fff;font-weight: inherit'>Indicador</th>"
				+ "</tr>" + detalleHtmlRecojoTransportista(lista) + "</table>" + "</div>";
	}

	public static String obtenerEstructuraRecepcionCliente(ReporteRecepcionBean rec) {
		return "<hr />" + "<br>" + "<h2>Indicador de recepción de valijas</h2>" + "<br />" + "<br />"
				+ "<table style = 'border: solid 0.5px; border-color: #BDBDBD; background-color: #FFF'>"
				+ "<tr class='Total'>" + "<td style = 'background-color: #FFF7AA; width: 10px'></td>"
				+ "<td style = 'background-color: #FFF7AA; width: 250px; padding: 5px; text-align: left'>Total Asignados</td>"
				+ "<td style = 'background-color: #FFF7AA; width: 100px; padding: 5px; text-align: center'> 100% </td>"
				+ "<td style = 'background-color: #FFF7AA; width: 100px; padding: 5px; text-align: center'>" + rec.getAsignados() + "</td>"
				+ "</tr>" + "<tr>" +"<td style='background-color: #FAFAFA; padding: 3px;text-align:center'><span style='background-color: #247EBA;width: 10px;height: 10px;border-radius: 50%'>&nbsp;&nbsp;&nbsp;&nbsp;</span></td>"
				
				+ "<td style = 'background-color: #FFF; width: 100px; padding: 3px'><span> </span> Recibidos</td>"
				+ "<td style = 'background-color: #FFF; width: 100px; padding: 3px; text-align: center'>"
				+ rec.EntregadosPorcentaje() + "</td>"
				+ "<td style = 'background-color: #FFF; width: 100px; padding: 3px; text-align: center'>"
				+ rec.getEntregados() + "</td>" + "</tr>" + "<tr>"
				+"<td style='background-color: #FAFAFA; padding: 3px;text-align:center'><span style='background-color: #FDB45C;width: 10px;height: 10px;border-radius: 50%'>&nbsp;&nbsp;&nbsp;&nbsp;</span></td>"
				+ "<td style = 'background-color: #FAFAFA; width: 100px; padding: 3px'><span class='badge SinMovimiento'> </span> En ruta</td>"
				+ "<td style = 'background-color: #FAFAFA; width: 100px; padding: 3px; text-align: center'>"
				+ rec.FaltantesPorcentaje() + "</td>"
				+ "<td style = 'background-color: #FAFAFA; width: 100px; padding: 3px; text-align: center'>"
				+ rec.getFaltantes() + "</td>" + "</tr>" + "<tr>"
				+"<td style='background-color: #FAFAFA; padding: 3px;text-align:center'><span style='background-color: #c1bebe;width: 10px;height: 10px;border-radius: 50%'>&nbsp;&nbsp;&nbsp;&nbsp;</span></td>"
				+ "<td style = 'background-color: #FFF; color: #585858; width: 100px; padding: 3px'><span> </span> Pendiente</td>"
				+ "<td style = 'background-color: #FFF; color: #585858; width: 100px; padding: 3px; text-align: center'>"
				+ rec.PendientesPorcentaje() + "</td>"
				+ "<td style = 'background-color: #FFF; color: #585858; width: 100px; padding: 3px; text-align: center'>"
				+ rec.getPendientes() + "</td>" + "</tr>" + "</table>" + "<br>" + "<table>" + "<tr>"
				+ "<th style = 'background-color: #257840; color: #FFF; padding: 3px; width: 250px; text-align: left'>Arco Horario</td>"
				+ "<th style = 'background-color: #257840; color: #FFF; padding: 3px; width: 100px; text-align: center'>Meta (%)</td>"
				+ "<th style = 'background-color: #257840; color: #FFF; padding: 3px; width: 100px; text-align: center'>Resultado (%)</td>"
				+ "<th style = 'background-color: #257840; color: #FFF; padding: 3px; width: 100px; text-align: center'>Cumple</td>"
				+ "</tr>" + ObtenerDetallehtmlRecepcionCliente(rec.getlDetalle(), rec.getAsignados()) + "</table>";

	}

	private static String ObtenerDetallehtmlRecepcionCliente(List<ReporteRecepcionBean> lista, int iAsignados) {
		String contenido = "";
		String fila = "";
		for (ReporteRecepcionBean rep : lista) {
			rep.setAsignados(iAsignados);
			fila = "<tr>" + "<td style = 'background-color: #FAFAFA; padding: 3px; text-align: left'>"
					+ rep.getsArcoHorario().replace(".0000000", "").replace(".0000000", "") + "</td>"
					+ "<td style = 'background-color: #FAFAFA; padding: 3px; text-align: center'>" + rep.sMetaPorcentaje() + "</td>"
					+ "<td style = 'background-color: #FAFAFA; padding: 3px; text-align: center'>" + rep.sResultadoPorcentaje() + "</td>"
					+ "<td style='background-color: #FAFAFA; padding: 3px;text-align:center'><span style='background-color: "+rep.getsIndicador()+";width: 10px;height: 10px;border-radius: 50%'>&nbsp;&nbsp;&nbsp;&nbsp;</span></td>"
					+ "</tr>";
			contenido += fila;
			fila = "";
		}
		return contenido;
	}

	public static String obtenerEstructuraHtmlRecojoCliente(ReporteRecepcionBean rec) {

		return "<h1>" + "Proveedor : " + rec.getProveedor().toUpperCase() + "</h1>" + "<hr />" + "<br>"
				+ "<h2>Indicador de agencias visitadas</h2>" + "<br />"
				+ "<table style = 'border: solid 0.5px; border-color: #BDBDBD; background-color: #FFF'>" + "<tr>"
				+ "<td style = 'background-color: #FFF7AA; padding: 3px; width: 250px' colspan = '2' >Total Asignados</td>"
				+ "<td style = 'background-color: #FFF7AA; padding: 3px; width: 100px'></td>"
				+ "<td style = 'background-color: #FFF7AA; padding: 3px; width: 100px; text-align: center'>"
				+ rec.getAsignados() + "</td>" + "</tr>" + "<tr>"
				+ "<td style='background-color: #FAFAFA; padding: 3px;text-align:center'><span style='background-color: #c1bebe;width: 10px;height: 10px;border-radius: 50%'>&nbsp;&nbsp;&nbsp;&nbsp;</span></td>"
				+ "<td style = 'background-color: #FAFAFA; padding: 3px'>Pendiente</td>"
				+ "<td style = 'background-color: #FAFAFA; padding: 3px; text-align: center'>"
				+ rec.PendientesPorcentaje() + "</td>"
				+ "<td style = 'background-color: #FAFAFA; padding: 3px; text-align: center'>" + rec.getPendientes()
				+ "</td>" + "</tr>" + "<tr>"
				+ "<td style = 'background-color: #FFF7AA; padding: 3px' colspan='2' >Visitados</td>"
				+ "<td style = 'background-color: #FFF7AA; padding: 3px; text-align: center'>"
				+ rec.VisitadosPorcentaje() + "</td>"
				+ "<td style = 'background-color: #FFF7AA; padding: 3px; text-align: center'>"
				+ (rec.getRecogidos() + rec.getSinmovimiento()) + "</td>" + "</tr>" + "<tr>"
				+ "<td style='background-color: #FAFAFA; padding: 3px;text-align:center'><span style='background-color: #247EBA;width: 10px;height: 10px;border-radius: 50%'>&nbsp;&nbsp;&nbsp;&nbsp;</span></td>"
				+ "<td style = 'background-color: #FAFAFA; padding: 3px'>Recogidos</td>"
				+ "<td style = 'background-color: #FAFAFA; padding: 3px; text-align: center'>"
				+ rec.getRecogidosPorcentaje() + "</td>"
				+ "<td style = 'background-color: #FAFAFA; padding: 3px; text-align: center'>" + rec.getRecogidos()
				+ "</td>" + " </tr>" + "<tr>"
				+ "<td style='background-color: #FAFAFA; padding: 3px;text-align:center'><span style='background-color: #FDB45C;width: 10px;height: 10px;border-radius: 50%'>&nbsp;&nbsp;&nbsp;&nbsp;</span></td>"
				+ "<td style = 'background-color: #FFFFFF; padding: 3px'>Sin Movimiento</td>"
				+ "<td style = 'background-color: #FFFFFF; padding: 3px; text-align: center'>"
				+ rec.SinMovimientoPorcentaje() + "</td>"
				+ "<td style = 'background-color: #FFFFFF; padding: 3px; text-align: center'>" + rec.getSinmovimiento()
				+ " </td>" + "</table>" + "<br>" + "<br>" +

		"<table style = 'border: solid 0.5px; border-color: #BDBDBD; background-color: #247EBA'>" + "<tr>"
				+ "<td style = 'background-color: #247EBA; padding: 5px; color: #FFF; text-align: left; width: 300px'>Visitados</td>"
				+ "   <td style = 'background-color: #247EBA; padding: 5px; color: #FFF; text-align: right; width: 100px'>"
				+ (rec.getRecogidos() + rec.getSinmovimiento()) + "</td>" + " </tr>" + " <tr>" + " <td colspan = '2'>"
				+ "    <table style = 'background-color: #FFF; width: 420px; text-align: center'>" + "<tr>"
				+ " <td style = 'border: solid 0.5px; border-color: #BDBDBD; padding: 5px'>A tiempo</td>"
				+ " <td style = 'border: solid 0.5px; border-color: #BDBDBD; padding: 5px'>Fuera de Tiempo</td>"
				+ "  </tr>" + " <tr>"
				+ "    <td style = 'background-color: #FFF7AA; border: solid 0.5px; border-color: #BDBDBD; padding: 5px'>"
				+ rec.RecogidosATiempoPorcentaje() + "(" + rec.getRecogidosatiempo() + ")</td>"
				+ "     <td style = 'background-color: #FFF7AA; border: solid 0.5px; border-color: #BDBDBD; padding: 5px'>"
				+ rec.RecogidosFueraRangoPorcentaje() + "(" + rec.getRecogidosfueraderango() + ")</td>" + "  </tr>"
				+ " </table>    " + "  </td>" + " </tr>" +

		" </table>" + "</br>";
	}
	
	public static String obtenerEstructuraHtmlRecojoClienteProvincia(ReporteRecepcionBean rec) {

		return "<h1>" + "Proveedor : " + rec.getProveedor().toUpperCase() + "</h1>" + "<hr />" + "<br>"
				+ "<h2>Indicador de agencias visitadas - Provincia</h2>" + "<br />"
				+ "<table style = 'border: solid 0.5px; border-color: #BDBDBD; background-color: #FFF'>" + "<tr>"
				+ "<td style = 'background-color: #FFF7AA; padding: 3px; width: 250px' colspan = '2' >Total Asignados</td>"
				+ "<td style = 'background-color: #FFF7AA; padding: 3px; width: 100px'></td>"
				+ "<td style = 'background-color: #FFF7AA; padding: 3px; width: 100px; text-align: center'>"
				+ rec.getAsignados() + "</td>" + "</tr>" + "<tr>"
				+ "<td style='background-color: #FAFAFA; padding: 3px;text-align:center'><span style='background-color: #c1bebe;width: 10px;height: 10px;border-radius: 50%'>&nbsp;&nbsp;&nbsp;&nbsp;</span></td>"
				+ "<td style = 'background-color: #FAFAFA; padding: 3px'>Pendiente</td>"
				+ "<td style = 'background-color: #FAFAFA; padding: 3px; text-align: center'>"
				+ rec.PendientesPorcentaje() + "</td>"
				+ "<td style = 'background-color: #FAFAFA; padding: 3px; text-align: center'>" + rec.getPendientes()
				+ "</td>" + "</tr>" + "<tr>"
				+ "<td style = 'background-color: #FFF7AA; padding: 3px' colspan='2' >Visitados</td>"
				+ "<td style = 'background-color: #FFF7AA; padding: 3px; text-align: center'>"
				+ rec.VisitadosPorcentaje() + "</td>"
				+ "<td style = 'background-color: #FFF7AA; padding: 3px; text-align: center'>"
				+ (rec.getRecogidos() + rec.getSinmovimiento()) + "</td>" + "</tr>" + "<tr>"
				+ "<td style='background-color: #FAFAFA; padding: 3px;text-align:center'><span style='background-color: #247EBA;width: 10px;height: 10px;border-radius: 50%'>&nbsp;&nbsp;&nbsp;&nbsp;</span></td>"
				+ "<td style = 'background-color: #FAFAFA; padding: 3px'>Recogidos</td>"
				+ "<td style = 'background-color: #FAFAFA; padding: 3px; text-align: center'>"
				+ rec.getRecogidosPorcentaje() + "</td>"
				+ "<td style = 'background-color: #FAFAFA; padding: 3px; text-align: center'>" + rec.getRecogidos()
				+ "</td>" + " </tr>" + "<tr>"
				+ "<td style='background-color: #FAFAFA; padding: 3px;text-align:center'><span style='background-color: #FDB45C;width: 10px;height: 10px;border-radius: 50%'>&nbsp;&nbsp;&nbsp;&nbsp;</span></td>"
				+ "<td style = 'background-color: #FFFFFF; padding: 3px'>Sin Movimiento</td>"
				+ "<td style = 'background-color: #FFFFFF; padding: 3px; text-align: center'>"
				+ rec.SinMovimientoPorcentaje() + "</td>"
				+ "<td style = 'background-color: #FFFFFF; padding: 3px; text-align: center'>" + rec.getSinmovimiento()
				+ " </td>" + "</table>" + "<br>" + "<br>" +

		"<table style = 'border: solid 0.5px; border-color: #BDBDBD; background-color: #247EBA'>" + "<tr>"
				+ "<td style = 'background-color: #247EBA; padding: 5px; color: #FFF; text-align: left; width: 300px'>Visitados</td>"
				+ "   <td style = 'background-color: #247EBA; padding: 5px; color: #FFF; text-align: right; width: 100px'>"
				+ (rec.getRecogidos() + rec.getSinmovimiento()) + "</td>" + " </tr>" + " <tr>" + " <td colspan = '2'>"
				+ "    <table style = 'background-color: #FFF; width: 420px; text-align: center'>" + "<tr>"
				+ " <td style = 'border: solid 0.5px; border-color: #BDBDBD; padding: 5px'>A tiempo</td>"
				+ " <td style = 'border: solid 0.5px; border-color: #BDBDBD; padding: 5px'>Fuera de Tiempo</td>"
				+ "  </tr>" + " <tr>"
				+ "    <td style = 'background-color: #FFF7AA; border: solid 0.5px; border-color: #BDBDBD; padding: 5px'>"
				+ rec.RecogidosATiempoPorcentaje() + "(" + rec.getRecogidosatiempo() + ")</td>"
				+ "     <td style = 'background-color: #FFF7AA; border: solid 0.5px; border-color: #BDBDBD; padding: 5px'>"
				+ rec.RecogidosFueraRangoPorcentaje() + "(" + rec.getRecogidosfueraderango() + ")</td>" + "  </tr>"
				+ " </table>    " + "  </td>" + " </tr>" +

		" </table>" + "</br>";
	}

	public static ReporteRecepcionBean ObtenerObjetoReporteRecepcionLima() {
		ReporteRecepcionDAO dao = new ReporteRecepcionDAO();
		List<ReporteRecepcionBean> lReport = null;
		ReporteRecepcionBean lReportes = null;
		try {
			lReportes = new ReporteRecepcionBean();
			List<ReporteRecepcionBean> deta = new ArrayList<ReporteRecepcionBean>();
			lReport = dao.GetReporteRecepcion(new Date(), 0);
			for (ReporteRecepcionBean reporteRecepcionBean : lReport) {
				//if ( reporteRecepcionBean.getIdProveedor()!= 0 && reporteRecepcionBean.getTipoAgencia() == 1) {
				if ( reporteRecepcionBean.getIdProveedor()!= 0) {
					lReportes.setIdProveedor(reporteRecepcionBean.getIdProveedor());
					lReportes.setProveedor(reporteRecepcionBean.getProveedor());
					lReportes.setAsignados(reporteRecepcionBean.getAsignados());
					lReportes.setRecogidos(reporteRecepcionBean.getRecogidos());
					lReportes.setSinmovimiento(reporteRecepcionBean.getSinmovimiento());
					lReportes.setPendientes(reporteRecepcionBean.getPendientes());
					lReportes.setRecogidosatiempo(reporteRecepcionBean.getRecogidosatiempo());
					lReportes.setRecogidosfueraderango(reporteRecepcionBean.getRecogidosfueraderango());
					lReportes.setEntregados(reporteRecepcionBean.getEntregados());
					lReportes.setFaltantes(reporteRecepcionBean.getFaltantes());
				} else {
					//if (reporteRecepcionBean.getTipoAgencia() == 1) {
						deta.add(reporteRecepcionBean);
					//}					
				}
					
			}
			lReportes.setlDetalle(deta);

		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			return null;
		}
		return lReportes;
	}
	
	public static ReporteRecepcionBean ObtenerObjetoReporteRecepcionProvincia() {
		ReporteRecepcionDAO dao = new ReporteRecepcionDAO();
		List<ReporteRecepcionBean> lReport = null;
		ReporteRecepcionBean lReportes = null;
		try {
			lReportes = new ReporteRecepcionBean();
			List<ReporteRecepcionBean> deta = new ArrayList<ReporteRecepcionBean>();
			lReport = dao.GetReporteRecepcion(new Date(), 0);
			for (ReporteRecepcionBean reporteRecepcionBean : lReport) {
				
				if ( reporteRecepcionBean.getIdProveedor()!= 0 && reporteRecepcionBean.getTipoAgencia() == 2) {
					lReportes.setIdProveedor(reporteRecepcionBean.getIdProveedor());
					lReportes.setProveedor(reporteRecepcionBean.getProveedor());
					lReportes.setAsignados(reporteRecepcionBean.getAsignados());
					lReportes.setRecogidos(reporteRecepcionBean.getRecogidos());
					lReportes.setSinmovimiento(reporteRecepcionBean.getSinmovimiento());
					lReportes.setPendientes(reporteRecepcionBean.getPendientes());
					lReportes.setRecogidosatiempo(reporteRecepcionBean.getRecogidosatiempo());
					lReportes.setRecogidosfueraderango(reporteRecepcionBean.getRecogidosfueraderango());
					lReportes.setEntregados(reporteRecepcionBean.getEntregados());
					lReportes.setFaltantes(reporteRecepcionBean.getFaltantes());
				} else {
					if (reporteRecepcionBean.getTipoAgencia() == 2) {
						deta.add(reporteRecepcionBean);
					}					
				}
					
			}
			lReportes.setlDetalle(deta);

		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			return null;
		}
		return lReportes;
	}

	public static List<ReporteRecojoBean> ObtenerReporteRecojo() {
		ReporteRecojoDAO dao = new ReporteRecojoDAO();
		try {
			return dao.GetReporte();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static List<ReporteRecojoBean> ObtenerReporteRecojoPorTransportista(List<ReporteRecojoBean> allReport,
			int idProveedor) {
		Predicate<ReporteRecojoBean> newlist = s -> s.getIdProveedor() == idProveedor;
		return (allReport.stream().filter(newlist)).collect(Collectors.toList());
	}

	private static void GetCorreosUsuarios() {
		UsuarioCorreoDAO dao = new UsuarioCorreoDAO();
		try {
			lUsuarioCorreo = dao.getCorreo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<UsuarioCorreoBean> GetCorreosTransportistas() {
		List<UsuarioCorreoBean> lUsuarioTrans = new ArrayList<UsuarioCorreoBean>();
		if (lUsuarioCorreo != null) {
			for (UsuarioCorreoBean usuarioCorreoBean : lUsuarioCorreo) {
				if (usuarioCorreoBean.getiGrupo() == 3) {
					lUsuarioTrans.add(usuarioCorreoBean);
				}
			}
			if (lUsuarioTrans.size() > 0)
				return lUsuarioTrans;
			else
				return null;
		} else {
			GetCorreosUsuarios();
			return GetCorreosTransportistas();
		}
	}

	public static List<UsuarioCorreoBean> GetCorreosClientes() {
		List<UsuarioCorreoBean> lUsuarioCliente = new ArrayList<UsuarioCorreoBean>();
		if (lUsuarioCorreo != null) {
			for (UsuarioCorreoBean usuarioCorreoBean : lUsuarioCorreo) {
				if (usuarioCorreoBean.getiGrupo() == 2) {
					lUsuarioCliente.add(usuarioCorreoBean);
				}
			}
			if (lUsuarioCliente.size() > 0)
				return lUsuarioCliente;
			else
				return null;
		} else {
			GetCorreosUsuarios();
			return GetCorreosClientes();
		}
	}

	public static UsuarioCorreoBean GetAdministrador() {
		if (lUsuarioCorreo != null) {
			for (UsuarioCorreoBean usuarioCorreoBean : lUsuarioCorreo) {
				if (usuarioCorreoBean.getiGrupo() == 4) {
					return usuarioCorreoBean;
				}
			}
		} else {
			GetCorreosUsuarios();
			return GetAdministrador();
		}
		return null;
	}

}
