package com.mitocode.java8.java8mito;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class FechasConDateApi {
	
	//Verificar el tiempo 
	public void verificar (int version ) {
		if (version == 7) {
			Calendar fecha1= Calendar.getInstance();
			Calendar fecha2= Calendar.getInstance();
			fecha1.set(1994, 02, 14);
			System.out.println(fecha1.after(fecha2));
		}
		else if (version == 8) {
			LocalDate fecha1 = LocalDate.of(1994, 02, 14);
			LocalDate fecha2 = LocalDate.now();
			
			System.out.println(fecha1.isAfter(fecha2));
			System.out.println(fecha1.isBefore(fecha2));
			
			LocalTime tiempo1 = LocalTime.of(22,30,50);
			LocalTime tiempo2 = LocalTime.now();
			
			System.out.println(tiempo1.isAfter(tiempo2));
			System.out.println(tiempo1.isBefore(tiempo2));
			
			LocalDateTime fechatiempo1 = LocalDateTime.of(1994, 02, 14,22,30,50);
			LocalDateTime fechatiempo2 = LocalDateTime.now();
			
			System.out.println(fechatiempo1.isAfter(fechatiempo2));
			System.out.println(fechatiempo1.isBefore(fechatiempo2));
		}
	}

	//Medir el tiempo 
	public void medirTeimpo(int version) throws InterruptedException {
		if (version == 7) {
			long ini = System.currentTimeMillis();
			Thread.sleep(1000);
			long fin = System.currentTimeMillis();
			System.out.println(fin -ini);
		}
		else if (version == 8) {
			Instant ini = Instant.now();
			Thread.sleep(1000);
			Instant fin = Instant.now();
			System.out.println(Duration.between(ini, fin).toMillis());
		}
	}
	
	
	
	//Periodo entre fechas 
	public void periodoEntreFehcas(int version) {
		if (version == 7) {
			Calendar nacimiento = Calendar.getInstance();
			Calendar actual= Calendar.getInstance();
			
			nacimiento.set(1991,0,21);
			actual.set(2017,1,4);
			int anios = 0;
			
			while (nacimiento.before(actual)) {
				nacimiento.add(Calendar.YEAR,1);
				if (nacimiento.before(actual)) {
					anios++;
				}
			}
			System.out.println(anios);
		}
		else if (version == 8) {
			LocalDate nacimiento = LocalDate.of(1994, 2, 14);
			LocalDate actual = LocalDate.now();

			Period period = Period.between(nacimiento, actual);
			System.out.println("Han transcurrido " +period.getYears()+" años y "+ period.getMonths()+" meses y "+period.getDays()+
					" dias, desde "+ nacimiento + " hasta " +actual);
		}
	}
	//Convertir 
	public void convertir(int version) throws ParseException{
		if (version ==7) {
			String fecha ="21/01/1991";
			DateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
			Date fechaConvertida = formateador.parse(fecha);
			System.out.println(fechaConvertida);
			
			Date fechaActual = Calendar.getInstance().getTime();
			 formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
			String fechaCadena = formateador.format(fechaActual);
			System.out.println(fechaCadena);
		}
		else if (version ==8) {
			String fecha ="21/01/1991";
			DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate fechaLocal = LocalDate.parse(fecha,formateador);
			System.out.println(fechaLocal);
			// APLICAR EL FORMATO CORRESPONDIENTE 
			System.out.println(formateador.format(fechaLocal));
			//aPLICAR OTRO FORMATO 
			formateador = DateTimeFormatter.ofPattern("ddMMyyyy");
			System.out.println(formateador.format(fechaLocal));
		}
	}
	
	//main 
	public static void main(String[] args) {
		FechasConDateApi app = new FechasConDateApi();
		//app.medirTeimpo(8);
		//app.periodoEntreFehcas(8);
		try {
			app.convertir(8);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//final
}
