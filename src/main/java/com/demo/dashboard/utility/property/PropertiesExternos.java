package com.demo.dashboard.utility.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertiesExternos {
	/************************
	 * BD INSIDETESTDB *
	 ************************/

	@Value("${spring.datasource.url}")
	public String url_insidetest;

	@Value("${spring.datasource.username}")
	public String username_insidetest;

	@Value("${spring.datasource.password}")
	public String pass_insidetest;


	/************************
	 * IDT E IDF *
	 ************************/

	@Value("${dashboard.principal.idf1.codigo}")
	public String dashboard_principal_Idf1_Codigo;
	@Value("${dashboard.principal.idf1.mensaje}")
	public String dashboard_principal_Idf1_Mensaje;

	@Value("${dashboard.principal.idf2.codigo}")
	public String dashboard_principal_Idf2_Codigo;
	@Value("${dashboard.principal.idf2.mensaje}")
	public String dashboard_principal_Idf2_Mensaje;

	@Value("${dashboard.principal.idf3.codigo}")
	public String dashboard_principal_Idf3_Codigo;
	@Value("${dashboard.principal.idf3.mensaje}")
	public String dashboard_principal_Idf3_Mensaje;



	@Value("${dashboard.principal.idt1.codigo}")
	public String dashboard_principal_Idt1_Codigo;
	@Value("${dashboard.principal.idt1.mensaje}")
	public String dashboard_principal_Idt1_Mensaje;

	@Value("${dashboard.principal.idt2.codigo}")
	public String dashboard_principal_Idt2_Codigo;
	@Value("${dashboard.principal.idt2.mensaje}")
	public String dashboard_principal_Idt2_Mensaje;

	@Value("${dashboard.principal.idt3.codigo}")
	public String dashboard_principal_Idt3_Codigo;
	@Value("${dashboard.principal.idt3.mensaje}")
	public String dashboard_principal_Idt3_Mensaje;



			



}