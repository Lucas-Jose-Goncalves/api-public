package br.com.ilab.ilab.utils;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class Util {
	
	//esse recurso é um código para atualizar os objetos sem que haja necessidade de enviar todo o corpo do objeto.
	//colocamos apenas o que queremos editar no json e enviamos a requisição
	
	public static void copyNonNullProperties(Object source, Object target) {
		BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
	}
	
	public static String[] getNullPropertyNames(Object source) {
		final BeanWrapper src = new BeanWrapperImpl(source);
		
		PropertyDescriptor[] pds = src.getPropertyDescriptors();
		
		Set<String> emptyNames = new HashSet<>();
		
		for(PropertyDescriptor pd: pds) {
			Object srcValue = src.getPropertyValue(pd.getName());
			if(srcValue == null) {
				emptyNames.add(pd.getName());			
			}
		}
		
		String[] result = new String[emptyNames.size()];
		return emptyNames.toArray(result);
	}

}
