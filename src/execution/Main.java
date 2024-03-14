package execution;
import java.io.IOException;

import lexer.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Lexer lex = new Lexer();
		Token tok = new Token(0);
		tok = lex.scan();
		System.out.println(tok.toString() + " Tag: "+ tok.tag);
	}
	
}
