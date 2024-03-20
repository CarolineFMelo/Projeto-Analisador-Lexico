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
			
			mais = new Word("+", Tag.T_MAIS), menos = new Word("-", Tag.T_MENOR),
			multiplicacao = new Word("*", Tag.T_VEZES), divisao = new Word("div", Tag.T_DIV),
			maiorque = new Word(">", Tag.T_MAIOR), menorque = new Word("<", Tag.T_MENOR),
			e = new Word("e", Tag.T_E), ou = new Word("ou", Tag.T_OU), nao = new Word("nao", Tag.T_NAO),
			recebe = new Word("<-", Tag.T_ATRIB), abreparenteses = new Word("(", Tag.T_ABRE), 
			fechaparenteses = new Word(")", Tag.T_FECHA), inteiro = new Word("inteiro", Tag.T_INTEIRO),
			logico = new Word("logico", Tag.T_LOGICO), verdadeiro = new Word("V", Tag.T_V),
			falso = new Word("F", Tag.T_F), igual = new Word("=", Tag.T_IGUAL);
	
}
