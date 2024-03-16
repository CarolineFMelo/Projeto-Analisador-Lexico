package lexer;

import java.io.IOException;
import java.util.Hashtable;
import symbols.*;

public class Lexer {

	public static int line = 1;
	char peek = ' ';
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
		
		reserve(new Word("programa", Tag.PROGRAMA));
		reserve(new Word("inicio", Tag.INICIO));
		reserve(new Word("fimprograma", Tag.FIMPROGRAMA));
		reserve(new Word("leia", Tag.LEIA));
		reserve(new Word("escreva", Tag.ESCREVA));
		reserve(new Word("se", Tag.SE));
		reserve(new Word("entao", Tag.ENTAO));
		reserve(new Word("senao", Tag.SENAO));
		reserve(new Word("fimse", Tag.FIMSE));
		reserve(new Word("enquanto", Tag.ENQUANTO));
		reserve(new Word("faca", Tag.FACA));
		reserve(new Word("fimenquanto", Tag.FIMENQUANTO));
		reserve(new Word("div", Tag.DIVISAO));
		reserve(new Word("e", Tag.E));
		reserve(new Word("ou", Tag.OU));
		reserve(new Word("nao", Tag.NAO));
		reserve(new Word("inteiro", Tag.INTEIRO));
		reserve(new Word("logico", Tag.LOGICO));
	}
	
	void readch() throws IOException {
		peek = (char)System.in.read();
	}
	
	boolean readch(char c) throws IOException {
		readch();
		
		if(peek != c) {
			return false;
		}
		peek = ' ';
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
			else if(readch('-')) {
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
			w = new Word(s, Tag.ID);
			words.put(s, w);
			return w;
		}
		Token tok = new Token(peek);
		peek = ' ';
		return tok;
	}
	
}
