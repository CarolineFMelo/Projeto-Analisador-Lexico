package lexer;

public class Word extends Token {
	
	public String lexeme = "";
	
	public Word(String s, int tag) {
		super(tag);
		lexeme = s;
	}
	
	public String toString() {
		return lexeme;
	}
	
	public static final Word and = new Word("&&", Tag.AND), or = new Word("||", Tag.OR),
			eq = new Word("==", Tag.EQ), ne = new  Word("!=", Tag.NE),
			le = new Word("<=", Tag.LE), ge = new Word(">=", Tag.GE),
			minus = new Word("minus", Tag.MINUS), True = new Word("true", Tag.TRUE),
			False = new Word("false", Tag.FALSE), temp = new Word("t", Tag.TEMP),
			
			mais = new Word("+", Tag.MAIS), menos = new Word("-", Tag.MENOS),
			multiplicacao = new Word("*", Tag.MULTIPLICACAO), divisao = new Word("div", Tag.DIVISAO),
			maiorque = new Word(">", Tag.MAIORQUE), menorque = new Word("<", Tag.MENORQUE),
			e = new Word("e", Tag.E), ou = new Word("ou", Tag.OU), nao = new Word("nao", Tag.NAO),
			recebe = new Word("<-", Tag.RECEBE), abreparenteses = new Word("(", Tag.ABREPARENTESES), 
			fechaparenteses = new Word(")", Tag.FECHAPARENTESES), inteiro = new Word("inteiro", Tag.INTEIRO),
			logico = new Word("logico", Tag.LOGICO), verdadeiro = new Word("V", Tag.VERDADEIRO),
			falso = new Word("F", Tag.FALSO), igual = new Word("=", Tag.IGUAL);
	
}
