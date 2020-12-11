package br.inatel.cdg.annotation.reading;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

//Nessa classe você deverá implementar a sua solução
//Adicionalmente você também deverá criar
//a anotação NumberToSum como parte da solução

public class AnnotationReader<T> {
	
	Class<?> clazz;
	public int sum = 0;	

	public AnnotationReader(Class<?> clazz) {
		this.clazz = clazz; 
	}

	public void readAnnotations() {
		for (Field field : clazz.getDeclaredFields()) {
			if(field.isAnnotationPresent(NumberToSum.class)) {
				this.sum += field.getAnnotation(NumberToSum.class).value();
			}			
		}
		
		for (Method method : clazz.getDeclaredMethods()) {
			if(method.isAnnotationPresent(NumberToSum.class)) {
				this.sum += method.getAnnotation(NumberToSum.class).value();
			}
		}
	}
	
	public int getTotalSum() {
		return this.sum;
	}

}