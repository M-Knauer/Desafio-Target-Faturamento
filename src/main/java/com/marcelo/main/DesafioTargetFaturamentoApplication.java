package com.marcelo.main;

import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.marcelo.main.entities.Faturamento;

@SpringBootApplication
public class DesafioTargetFaturamentoApplication  {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DesafioTargetFaturamentoApplication.class, args);
		
		List<Faturamento> faturamentos = getListJsonFaturamento();
        
        List<Faturamento> cleanFaturamento = faturamentos.stream().filter(f -> f.getValor() > 0).toList();
        
        System.out.println("Menor faturamento:");
        Faturamento minFaturamento = Collections.min(cleanFaturamento, Comparator.comparing(Faturamento::getValor));
        System.out.println(minFaturamento);
        
        System.out.println("Maior faturamento:");
        Faturamento maxFaturamento = Collections.max(cleanFaturamento, Comparator.comparing(Faturamento::getValor));
        System.out.println(maxFaturamento);
        
        Double avgValor = cleanFaturamento.stream().mapToDouble(Faturamento::getValor).average().orElse(0);
        
        System.out.println("Dias em que o faturamento foi maior do que a média:");
        cleanFaturamento.stream().filter(f -> f.getValor() > avgValor)
        		.forEach(d -> System.out.println(d.getDia()));
	}
	
	private static List<Faturamento> getListJsonFaturamento() throws Exception {
        
		String json = new String(Files.readAllBytes(Paths.get("dados.json")));

        Gson gson = new Gson();
        
        Type list = new TypeToken<List<Faturamento>>() {}.getType();
        return gson.fromJson(json, list);
        
	}
 
}
