package com.prueba;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ABasicos {

	public static void main(String[] args) {
		
		Random random = new Random();
		List<Integer> numeros = random
				.ints(0, 1000)
				.limit(20)
				.boxed()
				.collect(Collectors.toList());

		IntSummaryStatistics res = numeros.stream()
				.collect(Collectors.summarizingInt(Integer::intValue));
		System.out.println("Algunos datos sobre los n�meros procesados");
		System.out.println("M�ximo: " + res.getMax());
		System.out.println("M�nimo: " + res.getMin());
		System.out.println("Media: " + res.getAverage());
		System.out.println("Suma: " + res.getSum());
		System.out.println("N�mero de elementos: " + res.getCount());

	}

}
