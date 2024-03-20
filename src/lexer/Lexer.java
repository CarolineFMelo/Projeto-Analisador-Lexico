package lexer;

import java.io.IOException;
import java.util.Hashtable;
import symbols.*;

public class Lexer {

	public static int line = 1;
	char peek = ' ';
	char oldPeek = ' ';
	Hashtable<String, Word> words = new Hashtable<String, Word>();
	
	void reserve(Word w) {
		words.put(w.lexeme, w);
	}
	
	public Lexer() {
		reserve(new Word("if", Tag.IF));
		reserve(new Word("else", Tag.ELSE));
		reserve(new Word("while", Tag.WHILE));
		reserve(new Word("do", Tag.DO));
		reserve(new Word("break", Tag.BREAK));
		reserve(Word.True);
		reserve(Word.False);
		reserve(Type.Int);
		reserve(Type.Char);
		reserve(Type.Bool);
		reserve(Type.Float);
		
		reserve(new Word("programa", Tag.T_PROGRAMA));
		reserve(new Word("inicio", Tag.T_INICIO));
		reserve(new Word("fimprograma", Tag.T_FIM));
		reserve(new Word("leia", Tag.T_LEIA));
		reserve(new Word("escreva", Tag.T_ESCREVA));
		reserve(new Word("se", Tag.T_SE));
		reserve(new Word("entao", Tag.T_ENTAO));
		reserve(new Word("senao", Tag.T_SENAO));
		reserve(new Word("fimse", Tag.T_FIMSE));
		reserve(new Word("enquanto", Tag.T_ENQTO));
		reserve(new Word("faca", Tag.T_FACA));
		reserve(new Word("fimenquanto", Tag.T_FIMENQTO));
		reserve(new Word("div", Tag.T_DIV));
		reserve(new Word("e", Tag.T_E));
		reserve(new Word("ou", Tag.T_OU));
		reserve(new Word("nao", Tag.T_NAO));
		reserve(new Word("inteiro", Tag.T_INTEIRO));
		reserve(new Word("logico", Tag.T_LOGICO));
		reserve(new Word("V", Tag.T_V));
		reserve(new Word("F", Tag.T_F));
	}
	
	void readch() throws IOException {
		peek = (char)System.in.read();
		oldPeek = peek;
	}
	
	boolean readch(char c) throws IOException {
		readch();
		
		if(peek != c) {
			return false;
		}
		peek = ' ';
		return true;
	}
	
	boolean readchAgain(char c) throws IOException {
		peek = (char)System.in.read();
		
		if(oldPeek != c) {
			return false;
		}
		oldPeek = ' ';
		return true;
	}
	
	public Token scan() throws IOException {
		for(; ; readch()) {
			if(peek == ' ' || peek == '\t') {
				continue;
			}
			else if(peek == '\n') {
				line = line + 1;
			}
			else {
				break;
			}
		}
		
		switch(peek) {
		case '&':
			if(readch('&')) {
				return Word.and;
			}
			else {
				return new Token('&');
			}
		case '|':
			if(readch('|')) {
				return Word.or;
			}
			else {
				return new Token('|');
			}
		case '=':
			if(readch(' ')) {
				return Word.igual;
			}
			else {
				return new Token('=');
			}
		case '!':
			if(readch('=')) {
				return Word.ne;
			}
			else {
				return new Token('!');
			}
		case '<':
			if(readch('=')) {
				return Word.le;
			}
			else if(readchAgain('-')) {
				return Word.recebe;
			}
			else {
				return Word.menorque;
			}
		case '>':
			if(readch('=')) {
				return Word.ge;
			}
			else {
				return Word.maiorque;
			}
		case '+':
			if(readch(' ')) {
				return Word.mais;
			}
		case '-':
			if(readch(' ')) {
				return Word.menos;
			}
		case '*':
			if(readch(' ')) {
				return Word.multiplicacao;
			}
		case '(':
			String body = "\\s*";
			readch();
			if(Character.toString(peek).matches(body)) {
				return Word.abreparenteses;
			}
			else {
				return new Token('(');
			}
		case ')':
			body = "\\s*";
			readch();
			if(Character.toString(peek).matches(body)) {
				return Word.fechaparenteses;
			}
			else {
				return new Token(')');
			}
		case '/':
			if(readch('/')) { 
				while(peek != '\n') {
					readch();
				}
				//System.out.println("one line comment");
			}
			else if(readchAgain('*')) {
				while(peek != '*') {
					readch();
				}
				while(peek != '/') {
					readch();
				}
				//System.out.println("multi-line comment");
			}
			else {
				return new Token('/');
			}
		}
		
		if(Character.isDigit(peek)) {
			int v = 0;
			do {
				 v = 10 * v + Character.digit(peek, 10);
				 readch();
			 }
			 while(Character.isDigit(peek));
			 
			 if(peek != '.') {
				 return new Num(v);
			 }
			 
			 float x = v;
			 float d = 10;
			 
			 for(; ;) {
				 readch();
				 
				 if(!Character.isDigit(peek)) {
					 break;
				 }
				 x = x + Character.digit(peek, 10) / d;
				 d = d * 10;
			 }
			 return new Real(x);
		}
		if(Character.isLetter(peek)) {
			StringBuffer b = new StringBuffer();
			
			do {
				b.append(peek);
				readch();
			}
			while(Character.isLetterOrDigit(peek));
			
			String s = b.toString();
			Word w = (Word) words.get(s);
			
			if(w != null) {
				return w;
			}
			w = new Word(s, Tag.T_IDENTIF);
			words.put(s, w);
			return w;
		}
		Token tok = new Token(peek);
		peek = ' ';
		return tok;
	}
	
}
