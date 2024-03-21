package lexer;
import java.lang.reflect.Field;

public class Tag {
	
	public final static int AND = 256, BASIC = 257, BREAK = 258, DO = 259, 
			ELSE = 260, EQ = 261, FALSE = 262, GE = 263, T_IDENTIF = 264, IF = 265, 
			INDEX = 266, LE = 267, MINUS = 268, NE = 269, T_NUMERO = 270, OR = 271, 
			REAL = 272, TEMP = 273, TRUE = 274, WHILE = 275, 
			
			T_PROGRAMA = 276, T_INICIO = 277, T_FIM = 278, T_LEIA = 279,
			T_ESCREVA = 280, T_SE = 281, T_ENTAO = 282, T_SENAO = 283, T_FIMSE = 284, T_ENQTO = 285, 
			T_FACA = 286, T_FIMENQTO = 287, T_MAIS = 288, T_MENOS = 289, T_VEZES = 290, 
			T_DIV = 291, T_MAIOR = 292, T_MENOR = 293, T_E = 294, T_OU = 295, T_NAO = 296, 
			T_ATRIB = 297, T_ABRE = 298, T_FECHA = 299, T_INTEIRO = 300,
			T_LOGICO = 301, T_V = 302, T_F = 303, T_IGUAL = 304;
	
	
	public void getNameTag(Object obj, int value, Token word) throws IllegalAccessException {
		Field[] fields = Tag.class.getDeclaredFields();
		
		for(Field field : fields) {
		    field.setAccessible(true);
		    Object fieldValue = field.get(obj);
		    
		    if(fieldValue instanceof Integer && (int) fieldValue == value) {
		    	System.out.println(word + ": " + field.getName() + " " + fieldValue);
		    }
	    }
	}
			
}
