package br.usjt.hellospringboot.model;

public class Calculadora {
	public double calculaMedia (double...minmax) {
		double m = 0;
		for (Double d : minmax) {
			m += d;
		}
		return m / minmax.length;
	}
}
