package com.exact.sendemail;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.exact.bean.ReporteRecepcionBean;
import com.exact.bean.UsuarioCorreoBean;

public class JavaMailRecepcion {

	public static void main(String[] args) {

		//final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		
		final String URL_LINK = "https://www.exact.com.pe/rvaws/#/";
		final String URL_TEXTO = "https://www.exact.com.pe/rvaws/#/";
		final String EMAIL_CONTACTO = "SERVUTDAGLIMA@bcp.com.pe";
		
		// String remitente = "";
		String htmlRecepcionCliente = "";
		String htmlRecojoCliente = "";
		String htmlRecojoClienteProvincia = "";

		UsuarioCorreoBean usuarioAdmin = Metodos.GetAdministrador();
		List<UsuarioCorreoBean> lClientes = Metodos.GetCorreosClientes();
		ReporteRecepcionBean lReportes = Metodos.ObtenerObjetoReporteRecepcionLima();
		//ReporteRecepcionBean ReporteProvincia = Metodos.ObtenerObjetoReporteRecepcionProvincia();
		htmlRecepcionCliente = Metodos.obtenerEstructuraRecepcionCliente(lReportes);
		htmlRecojoCliente = Metodos.obtenerEstructuraHtmlRecojoCliente(lReportes);
		//htmlRecojoClienteProvincia = Metodos.obtenerEstructuraHtmlRecojoClienteProvincia(ReporteProvincia);

		// El servidor host
		String host = "smtp.gmail.com";

		// Obtener las propiedades del sistema
		Properties propiedades = System.getProperties();

		// Configuramos el servidor de correo
		/*
		propiedades.put("mail.smtp.host", host);
		propiedades.put("mail.smtp.socketFactory.class", SSL_FACTORY);
		propiedades.put("mail.smtp.socketFactory.fallback", "false");
		propiedades.put("mail.smtp.port", "465");
		propiedades.put("mail.smtp.socketFactory.port", "465");
		propiedades.put("mail.smtp.auth", "true");
		propiedades.put("mail.debug", "true");
		propiedades.put("mail.store.protocol", "pop3");
		propiedades.put("mail.transport.protocol", "smtp");
		*/
		
		propiedades.put("mail.smtp.host", host);
		propiedades.put("mail.smtp.port", "587");
		propiedades.put("mail.smtp.auth", "true");
		propiedades.put("mail.smtp.starttls.enable", "true"); //TLS
		propiedades.put("mail.smtp.ssl.trust", host);

		final String clave = usuarioAdmin.getsClave();
		final String remitente = usuarioAdmin.getCorreo();
		final String alias = usuarioAdmin.getAlias();

		// Obtenemos la session por defecto
		Session session = Session.getInstance(propiedades, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(remitente, clave);
			}
		});

		try {

			for (UsuarioCorreoBean usuarioCorreoBean : lClientes) {

				if (lReportes == null)
					return;
				String cc = usuarioCorreoBean.getCorreoCC();
				
				Message mensaje = new MimeMessage(session);
				mensaje.setFrom(new InternetAddress(alias));
				mensaje.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(usuarioCorreoBean.getCorreo(), false));
				if (cc != null && !cc.isEmpty()) {
					mensaje.setRecipients(Message.RecipientType.CC,
							InternetAddress.parse(usuarioCorreoBean.getCorreoCC(), false));
				}				
				mensaje.setSubject("Reporte de recojo y recepción de valijas - BCP");
				mensaje.setContent(
						htmlRecojoCliente + htmlRecepcionCliente + "</br>"
								+ "<p style='font-size=15px'>Para mayor información visitanos en <a href=\'" + URL_LINK + "\'>" + URL_TEXTO + "</a></p>"
								+"</br>"
								+"--"
								+"</br>"
								+Metodos.ObtenerFirma(EMAIL_CONTACTO),
						"text/html");
				mensaje.setSentDate(new Date());
				Transport.send(mensaje);
				System.out.println("Mensaje enviado");

			}

		} catch (Exception e) {
			try {
				FileWriter fw = new FileWriter(new File("archivo.txt"));
				fw.write(e.getMessage());
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return;
		}

	}
}
