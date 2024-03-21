package execution;
import java.io.IOException;
import lexer.*;

public class Main {
	
	public static void main(String[] args) throws IOException, IllegalAccessException {
		Lexer lex = new Lexer();
		Token tok = new Token(0);
		Tag tag = new Tag();
		
		while(tok.tag != 278) {
			tok = lex.scan();
			tag.getNameTag(tag, tok.tag, tok);
		}
	}
	
}
