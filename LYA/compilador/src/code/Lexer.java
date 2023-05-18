/* The following code was generated by JFlex 1.4.3 on 5/2/23, 9:29 PM */

package code;
import static code.Tokens.*;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 5/2/23, 9:29 PM from the specification file
 * <tt>/home/appsidal/Desktop/GT/sixthProyects/LYA/compilador/src/code/lexer.flex</tt>
 */
class Lexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\4\1\6\2\0\1\4\22\0\1\4\1\33\3\0\1\3"+
    "\1\36\1\0\1\7\1\7\1\3\1\22\1\4\1\23\1\40\1\5"+
    "\1\2\1\2\1\2\1\2\1\2\1\2\1\2\1\2\1\2\1\2"+
    "\2\0\1\32\1\31\1\32\2\0\32\1\1\7\1\0\1\7\1\3"+
    "\1\1\1\0\1\25\1\35\1\24\1\34\1\11\1\27\2\1\1\16"+
    "\2\1\1\30\1\10\1\12\1\21\1\15\1\1\1\14\1\17\1\13"+
    "\1\20\1\26\4\1\1\7\1\37\1\7\uff82\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\4\1\6"+
    "\5\2\2\4\3\2\1\1\1\7\2\2\2\1\1\0"+
    "\1\10\1\0\1\5\4\2\1\11\2\2\1\12\4\2"+
    "\1\7\2\2\1\13\2\14\1\0\1\10\2\2\1\15"+
    "\11\2\1\0\7\2\1\16\2\2\1\14\5\2\1\17"+
    "\4\2\1\20\12\2\1\21\2\2";

  private static int [] zzUnpackAction() {
    int [] result = new int[96];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\41\0\102\0\143\0\41\0\204\0\245\0\41"+
    "\0\306\0\347\0\u0108\0\u0129\0\u014a\0\u016b\0\u018c\0\u01ad"+
    "\0\u01ce\0\u01ef\0\u0210\0\u0210\0\u0231\0\u0252\0\u0273\0\u0294"+
    "\0\u02b5\0\143\0\u02d6\0\u02f7\0\u0318\0\u0339\0\u035a\0\u037b"+
    "\0\102\0\u039c\0\u03bd\0\41\0\u03de\0\u03ff\0\u0420\0\u0441"+
    "\0\41\0\u0462\0\u0483\0\41\0\u04a4\0\u04c5\0\u04e6\0\u02d6"+
    "\0\u0507\0\u0528\0\102\0\u0549\0\u056a\0\u058b\0\u05ac\0\u05cd"+
    "\0\u05ee\0\u060f\0\u0630\0\u0651\0\u0672\0\u0693\0\u06b4\0\u06d5"+
    "\0\u06f6\0\u0717\0\u0738\0\u0759\0\102\0\u077a\0\u079b\0\u07bc"+
    "\0\u07dd\0\u07fe\0\u081f\0\u0840\0\u0861\0\102\0\u0882\0\u08a3"+
    "\0\u08c4\0\u08e5\0\102\0\u0906\0\u0927\0\u0948\0\u0969\0\u098a"+
    "\0\u09ab\0\u09cc\0\u09ed\0\u0a0e\0\u0a2f\0\102\0\u0a50\0\u0a71";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[96];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\6\1\10"+
    "\1\11\3\3\1\12\1\13\1\14\1\15\2\3\1\16"+
    "\1\17\1\20\1\3\1\21\1\22\1\3\1\23\1\24"+
    "\1\23\1\25\1\26\1\27\1\30\1\2\42\0\2\3"+
    "\5\0\12\3\2\0\5\3\1\31\2\0\2\3\5\0"+
    "\1\32\35\0\1\33\4\0\1\6\1\0\1\6\37\0"+
    "\1\34\34\0\2\3\5\0\1\3\1\35\10\3\2\0"+
    "\5\3\1\31\2\0\2\3\4\0\2\3\5\0\6\3"+
    "\1\36\3\3\2\0\5\3\1\31\2\0\2\3\4\0"+
    "\2\3\5\0\1\3\1\37\10\3\2\0\5\3\1\31"+
    "\2\0\2\3\4\0\2\3\5\0\2\3\1\40\7\3"+
    "\2\0\5\3\1\31\2\0\2\3\4\0\2\3\5\0"+
    "\1\3\1\41\1\3\1\42\6\3\2\0\1\43\4\3"+
    "\1\31\2\0\2\3\25\0\1\44\20\0\1\32\20\0"+
    "\1\44\16\0\2\3\5\0\11\3\1\45\2\0\1\3"+
    "\1\46\3\3\1\31\2\0\2\3\4\0\2\3\5\0"+
    "\1\3\1\47\10\3\2\0\5\3\1\31\2\0\2\3"+
    "\4\0\2\3\5\0\12\3\2\0\1\3\1\50\3\3"+
    "\1\31\2\0\2\3\34\0\1\51\10\0\2\3\5\0"+
    "\11\3\1\52\2\0\5\3\1\31\2\0\2\3\4\0"+
    "\2\3\5\0\11\3\1\53\2\0\5\3\1\31\2\0"+
    "\2\3\41\0\1\54\41\0\1\54\2\0\1\55\1\56"+
    "\5\0\12\55\1\0\1\57\5\55\3\0\2\55\5\0"+
    "\1\60\36\0\6\34\1\0\32\34\1\0\2\3\5\0"+
    "\2\3\1\61\7\3\2\0\5\3\1\31\2\0\2\3"+
    "\4\0\2\3\5\0\5\3\1\62\4\3\2\0\5\3"+
    "\1\31\2\0\2\3\4\0\2\3\5\0\4\3\1\63"+
    "\5\3\2\0\5\3\1\31\2\0\2\3\4\0\2\3"+
    "\5\0\3\3\1\64\6\3\2\0\5\3\1\31\2\0"+
    "\2\3\4\0\2\3\5\0\12\3\2\0\1\3\1\65"+
    "\3\3\1\31\2\0\2\3\4\0\2\3\5\0\12\3"+
    "\2\0\1\3\1\66\3\3\1\31\2\0\2\3\4\0"+
    "\2\3\5\0\4\3\1\67\5\3\2\0\5\3\1\31"+
    "\2\0\2\3\4\0\2\3\5\0\4\3\1\70\5\3"+
    "\2\0\5\3\1\31\2\0\2\3\4\0\2\3\5\0"+
    "\4\3\1\71\5\3\2\0\5\3\1\31\2\0\2\3"+
    "\4\0\2\3\5\0\12\3\2\0\4\3\1\72\1\31"+
    "\2\0\2\3\4\0\2\3\5\0\5\3\1\73\4\3"+
    "\2\0\5\3\1\31\2\0\2\3\4\0\2\3\5\0"+
    "\11\3\1\74\2\0\5\3\1\31\2\0\2\3\4\0"+
    "\2\55\1\31\1\0\1\31\2\0\12\55\2\31\5\55"+
    "\3\0\2\55\5\0\1\56\1\31\1\0\1\31\14\0"+
    "\2\31\14\0\1\75\2\0\1\56\37\0\2\3\5\0"+
    "\3\3\1\76\6\3\2\0\5\3\1\31\2\0\2\3"+
    "\4\0\2\3\5\0\1\3\1\77\10\3\2\0\5\3"+
    "\1\31\2\0\2\3\4\0\2\3\5\0\1\3\1\100"+
    "\10\3\2\0\5\3\1\31\2\0\2\3\4\0\2\3"+
    "\5\0\1\101\11\3\2\0\5\3\1\31\2\0\2\3"+
    "\4\0\2\3\5\0\2\3\1\102\7\3\2\0\5\3"+
    "\1\31\2\0\2\3\4\0\2\3\5\0\12\3\2\0"+
    "\5\3\1\31\2\0\1\103\1\3\4\0\2\3\5\0"+
    "\12\3\2\0\1\3\1\104\3\3\1\31\2\0\2\3"+
    "\4\0\2\3\5\0\11\3\1\105\2\0\5\3\1\31"+
    "\2\0\2\3\4\0\2\3\5\0\7\3\1\71\2\3"+
    "\2\0\5\3\1\31\2\0\2\3\4\0\2\3\5\0"+
    "\5\3\1\106\4\3\2\0\5\3\1\31\2\0\2\3"+
    "\4\0\2\3\5\0\12\3\2\0\4\3\1\107\1\31"+
    "\2\0\2\3\5\0\1\110\37\0\2\3\5\0\4\3"+
    "\1\111\5\3\2\0\5\3\1\31\2\0\2\3\4\0"+
    "\2\3\5\0\3\3\1\112\6\3\2\0\5\3\1\31"+
    "\2\0\2\3\4\0\2\3\5\0\4\3\1\113\5\3"+
    "\2\0\5\3\1\31\2\0\2\3\4\0\2\3\5\0"+
    "\5\3\1\114\4\3\2\0\5\3\1\31\2\0\2\3"+
    "\4\0\2\3\5\0\7\3\1\115\2\3\2\0\5\3"+
    "\1\31\2\0\2\3\4\0\2\3\5\0\12\3\2\0"+
    "\1\3\1\116\3\3\1\31\2\0\2\3\4\0\2\3"+
    "\5\0\3\3\1\117\6\3\2\0\5\3\1\31\2\0"+
    "\2\3\4\0\2\3\5\0\12\3\2\0\4\3\1\120"+
    "\1\31\2\0\2\3\4\0\2\3\5\0\1\3\1\121"+
    "\10\3\2\0\5\3\1\31\2\0\2\3\5\0\1\110"+
    "\1\31\1\0\1\31\14\0\2\31\16\0\2\3\5\0"+
    "\1\3\1\63\10\3\2\0\5\3\1\31\2\0\2\3"+
    "\4\0\2\3\5\0\1\3\1\76\10\3\2\0\5\3"+
    "\1\31\2\0\2\3\4\0\2\3\5\0\4\3\1\122"+
    "\4\3\1\116\2\0\5\3\1\31\2\0\2\3\4\0"+
    "\2\3\5\0\12\3\2\0\1\3\1\123\3\3\1\31"+
    "\2\0\2\3\4\0\2\3\5\0\6\3\1\124\3\3"+
    "\2\0\5\3\1\31\2\0\2\3\4\0\2\3\5\0"+
    "\3\3\1\125\6\3\2\0\5\3\1\31\2\0\2\3"+
    "\4\0\2\3\5\0\11\3\1\116\2\0\5\3\1\31"+
    "\2\0\2\3\4\0\2\3\5\0\12\3\2\0\1\3"+
    "\1\126\3\3\1\31\2\0\2\3\4\0\2\3\5\0"+
    "\10\3\1\127\1\3\2\0\5\3\1\31\2\0\2\3"+
    "\4\0\2\3\5\0\11\3\1\130\2\0\5\3\1\31"+
    "\2\0\2\3\4\0\2\3\5\0\1\3\1\131\10\3"+
    "\2\0\5\3\1\31\2\0\2\3\4\0\2\3\5\0"+
    "\2\3\1\120\7\3\2\0\5\3\1\31\2\0\2\3"+
    "\4\0\2\3\5\0\3\3\1\132\6\3\2\0\5\3"+
    "\1\31\2\0\2\3\4\0\2\3\5\0\2\3\1\133"+
    "\7\3\2\0\5\3\1\31\2\0\2\3\4\0\2\3"+
    "\5\0\4\3\1\134\5\3\2\0\5\3\1\31\2\0"+
    "\2\3\4\0\2\3\5\0\3\3\1\135\6\3\2\0"+
    "\5\3\1\31\2\0\2\3\4\0\2\3\5\0\1\3"+
    "\1\136\10\3\2\0\5\3\1\31\2\0\2\3\4\0"+
    "\2\3\5\0\1\3\1\116\10\3\2\0\5\3\1\31"+
    "\2\0\2\3\4\0\2\3\5\0\11\3\1\137\2\0"+
    "\5\3\1\31\2\0\2\3\4\0\2\3\5\0\4\3"+
    "\1\140\5\3\2\0\5\3\1\31\2\0\2\3\4\0"+
    "\2\3\5\0\1\3\1\41\10\3\2\0\5\3\1\31"+
    "\2\0\2\3\3\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[2706];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\2\1\1\11\2\1\1\11\20\1\1\0"+
    "\1\1\1\0\10\1\1\11\4\1\1\11\2\1\1\11"+
    "\2\1\1\0\15\1\1\0\43\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[96];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    public String lexeme;


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Lexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 134) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Tokens yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 10: 
          { return Linde;
          }
        case 18: break;
        case 14: 
          { lexeme=yytext(); return Lbooleanos;
          }
        case 19: break;
        case 1: 
          { return ERROR;
          }
        case 20: break;
        case 11: 
          { return Land;
          }
        case 21: break;
        case 6: 
          { return limitesBloques;
          }
        case 22: break;
        case 2: 
          { lexeme=yytext(); return Variable;
          }
        case 23: break;
        case 15: 
          { lexeme=yytext(); return LtipoDato;
          }
        case 24: break;
        case 13: 
          { lexeme=yytext(); return ciclos;
          }
        case 25: break;
        case 9: 
          { lexeme=yytext(); return sentenciasSelectivas;
          }
        case 26: break;
        case 4: 
          { return Loperadores;
          }
        case 27: break;
        case 16: 
          { lexeme=yytext(); return Lsalida;
          }
        case 28: break;
        case 3: 
          { return Lnumeros;
          }
        case 29: break;
        case 8: 
          { lexeme=yytext(); return Numero;
          }
        case 30: break;
        case 12: 
          { lexeme=yytext(); return Loperaciones;
          }
        case 31: break;
        case 5: 
          { /*Ignore*/
          }
        case 32: break;
        case 17: 
          { lexeme=yytext(); return Lentrada;
          }
        case 33: break;
        case 7: 
          { lexeme=yytext(); return Lcomparadores;
          }
        case 34: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return null;
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
