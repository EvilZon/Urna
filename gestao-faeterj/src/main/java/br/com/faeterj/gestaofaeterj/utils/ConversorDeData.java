package br.com.faeterj.gestaofaeterj.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConversorDeData {

	//"28/10/2022 às 10:00hs"
	
	/*
	 * dd => Dia do mes
	 * DD => Dia do ano
	 * MM =>> Mês
	 * mm =>> Minuto
	 * YYYY => Ano formato 2022
	 * YY => Ano formato 22
	 * HH => Hora formato 24hs (0 a 23) pm
	 * hh => formato 12hs (0 a 12:00) am
	 * ss => segundos
	 *  
	 * */
	
	public static String converterDateParaDataEHoraISO(Date data) {
		SimpleDateFormat formatador = new SimpleDateFormat("YYYY-MM-dd");
		return formatador.format(data) + "T" + converterDateParaHora(data);
	}
	
	public static String converterDateParaDataEHora(Date data) {
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
		return formatador.format(data);
	}
	
	public static String converterDateParaData(Date data) {
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/YYYY");
		return formatador.format(data);
	}
	
	public static String converterDateParaHora(Date data) {
		SimpleDateFormat formatador = new SimpleDateFormat("HH:mm:ss");
		return formatador.format(data);
	}
	
}
