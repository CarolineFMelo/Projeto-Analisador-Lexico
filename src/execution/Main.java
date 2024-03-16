package execution;
import java.io.IOException;

import lexer.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Lexer lex = new Lexer();
		Token tok = new Token(0);
		
		while(tok.tag != 278) {
			tok = lex.scan();
			if((tok.tag != 13) && (tok.tag != 47)) {
				System.out.println(tok.toString() + analysisResult(tok.tag) + " " + tok.tag);
			}
		}
	}
	
	public static String analysisResult(int tag) {
		String result = "";
		
		if((tag >= 276) && (tag <= 287)) {
			result = ": palavra reservada";
		}
		else if(tag == 264) {
			result = ": identificador";
		}
		else if(tag == 270) {
			result = ": numero";
		}
		else if(tag == 297) {
			result = ": operador de atribuicao";
		}
		else if(tag == 288) {
			result = ": operador aritmetico soma";
		}
		else if(tag == 289) {
			result = ": operador aritmetico subtracao";
		}
		else if(tag == 290) {
			result = ": operador aritmetico multiplicacao";
		}
		else if(tag == 291) {
			result = ": operador aritmetico divisao";
		}
		else if(tag == 292) {
			result = ": operador relacional maior";
		}
		else if(tag == 293) {
			result = ": operador relacional menor";
		}
		else if(tag == 294) {
			result = ": operador logico conjuncao";
		}
		else if(tag == 295) {
			result = ": operador logico disjuncao";
		}
		else if(tag == 296) {
			result = ": operador logico negacao";
		}
		else if(tag == 297) {
			result = ": operador de atribuicao";
		}
		else if(tag == 298) {
			result = ": simbolo abre parenteses";
		}
		else if(tag == 299) {
			result = ": simbolo fecha parenteses";
		}
		else if(tag == 300) {
			result = ": operador palavra reservada";
		}
		else if(tag == 301) {
			result = ": operador palavra reservada";
		}
		else if(tag == 302) {
			result = ": constante logica de verdade";
		}
		else if(tag == 303) {
			result = ": constante logica de falsidade";
		}
		else if(tag == 304) {
			result = "operador relacional igual";
		}
		return result;
	}
	
}
