package com.marcelo.main;

import java.io.IOException;
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

	public static void main(String[] args) throws IOException {
		SpringApplication.run(DesafioTargetFaturamentoApplication.class, args);
		
        String json = new String(Files.readAllBytes(Paths.get("dados.json")));

        Gson gson = new Gson();
        
        Type list = new TypeToken<List<Faturamento>>() {}.getType();
        List<Faturamento> faturamentos = gson.fromJson(json, list);
        
        List<Faturamento> cleanFaturamento = faturamentos.stream().filter(f -> f.getValor() > 0).toList();
        
        System.out.println(cleanFaturamento);

        Faturamento minFaturamento = Collections.min(cleanFaturamento, Comparator.comparing(Faturamento::getValor));
        System.out.println(minFaturamento);
	}
 
}
