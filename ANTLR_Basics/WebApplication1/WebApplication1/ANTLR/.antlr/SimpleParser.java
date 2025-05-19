// Generated from c:/Users/shram/Desktop/ANTLR_Basics/WebApplication1/WebApplication1/ANTLR/Simple.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SimpleParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, BOOL=51, WS=52, IDENTIFIER=53, 
		INTEGER=54, NUMBER=55, STRING=56, TEXT=57, CHAR=58, CHARACTER=59, NULL=60, 
		BIN=61, BINARY=62, UTC_DATE=63, ISO8601=64, LINE_COMMENT=65, BLOCK_COMMENT=66, 
		OP=67;
	public static final int
		RULE_program = 0, RULE_line = 1, RULE_statement = 2, RULE_block = 3, RULE_assignment = 4, 
		RULE_functionCall = 5, RULE_expression = 6, RULE_multiOp = 7, RULE_addOp = 8, 
		RULE_compareOp = 9, RULE_constant = 10, RULE_forStmt = 11, RULE_repeatStmt = 12, 
		RULE_loopStmt = 13, RULE_whileStmt = 14, RULE_expr = 15, RULE_untilStmt = 16, 
		RULE_asLongStmt = 17, RULE_customCompOp = 18, RULE_doWhileStmt = 19, RULE_repeatAsLongStmt = 20, 
		RULE_repeatUntilStmt = 21, RULE_doAsLongStmt = 22, RULE_writeFileStmt = 23, 
		RULE_isNullStmt = 24, RULE_existsStmt = 25, RULE_sleepStmt = 26, RULE_readFileStmt = 27, 
		RULE_deleteFileStmt = 28, RULE_createFolderStmt = 29, RULE_deleteFolderStmt = 30, 
		RULE_openFileStmt = 31, RULE_minExpr = 32, RULE_numberList = 33;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "line", "statement", "block", "assignment", "functionCall", 
			"expression", "multiOp", "addOp", "compareOp", "constant", "forStmt", 
			"repeatStmt", "loopStmt", "whileStmt", "expr", "untilStmt", "asLongStmt", 
			"customCompOp", "doWhileStmt", "repeatAsLongStmt", "repeatUntilStmt", 
			"doAsLongStmt", "writeFileStmt", "isNullStmt", "existsStmt", "sleepStmt", 
			"readFileStmt", "deleteFileStmt", "createFolderStmt", "deleteFolderStmt", 
			"openFileStmt", "minExpr", "numberList"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'{'", "'}'", "'='", "'('", "','", "')'", "'!'", "'*'", 
			"'/'", "'%'", "'+'", "'-'", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='", 
			"'for'", "'from'", "'to'", "'repeat'", "'times'", "'loop from'", "'while'", 
			"'until'", "'as'", "'long'", "'isBigger'", "'isSmaller'", "'isEqual'", 
			"'isNotEqual'", "'isBiggerThan'", "'isSmallerThan'", "'isNotEqualThan'", 
			"'do'", "'as long'", "'var'", "'.'", "'WriteFile'", "'IsNull'", "'Exists'", 
			"'Sleep'", "'ReadFile'", "'DeleteFile'", "'CreateFolder'", "'DeleteFolder'", 
			"'OpenFile'", "'Min'", null, null, null, null, null, null, null, null, 
			null, "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "BOOL", "WS", "IDENTIFIER", "INTEGER", "NUMBER", "STRING", 
			"TEXT", "CHAR", "CHARACTER", "NULL", "BIN", "BINARY", "UTC_DATE", "ISO8601", 
			"LINE_COMMENT", "BLOCK_COMMENT", "OP"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Simple.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SimpleParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SimpleParser.EOF, 0); }
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==IDENTIFIER) {
				{
				{
				setState(68);
				line();
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(74);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LineContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_line);
		try {
			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				statement();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(80);
				assignment();
				}
				break;
			case 2:
				{
				setState(81);
				functionCall();
				}
				break;
			}
			setState(84);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(T__1);
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==IDENTIFIER) {
				{
				{
				setState(87);
				line();
				}
				}
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(93);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SimpleParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(IDENTIFIER);
			setState(96);
			match(T__3);
			setState(97);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SimpleParser.IDENTIFIER, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(IDENTIFIER);
			setState(100);
			match(T__4);
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 5)) & ~0x3f) == 0 && ((1L << (_la - 5)) & 1143703199119573001L) != 0)) {
				{
				setState(101);
				expression(0);
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(102);
					match(T__5);
					setState(103);
					expression(0);
					}
					}
					setState(108);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(111);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesizedExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenthesizedExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConstantExpressionContext extends ExpressionContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ConstantExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AdditiveExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AddOpContext addOp() {
			return getRuleContext(AddOpContext.class,0);
		}
		public AdditiveExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierExpressionContext extends ExpressionContext {
		public TerminalNode IDENTIFIER() { return getToken(SimpleParser.IDENTIFIER, 0); }
		public IdentifierExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicateExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MultiOpContext multiOp() {
			return getRuleContext(MultiOpContext.class,0);
		}
		public MultiplicateExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallExpressionContext extends ExpressionContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FunctionCallExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public CompareOpContext compareOp() {
			return getRuleContext(CompareOpContext.class,0);
		}
		public ComparisonExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				_localctx = new ConstantExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(114);
				constant();
				}
				break;
			case 2:
				{
				_localctx = new IdentifierExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(115);
				match(IDENTIFIER);
				}
				break;
			case 3:
				{
				_localctx = new FunctionCallExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(116);
				functionCall();
				}
				break;
			case 4:
				{
				_localctx = new ParenthesizedExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(117);
				match(T__4);
				setState(118);
				expression(0);
				setState(119);
				match(T__6);
				}
				break;
			case 5:
				{
				_localctx = new NotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(121);
				match(T__7);
				setState(122);
				expression(4);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(139);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(137);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicateExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(125);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(126);
						multiOp();
						setState(127);
						expression(4);
						}
						break;
					case 2:
						{
						_localctx = new AdditiveExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(129);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(130);
						addOp();
						setState(131);
						expression(3);
						}
						break;
					case 3:
						{
						_localctx = new ComparisonExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(133);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(134);
						compareOp();
						setState(135);
						expression(2);
						}
						break;
					}
					} 
				}
				setState(141);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultiOpContext extends ParserRuleContext {
		public MultiOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiOp; }
	}

	public final MultiOpContext multiOp() throws RecognitionException {
		MultiOpContext _localctx = new MultiOpContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_multiOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3584L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AddOpContext extends ParserRuleContext {
		public AddOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addOp; }
	}

	public final AddOpContext addOp() throws RecognitionException {
		AddOpContext _localctx = new AddOpContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_addOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_la = _input.LA(1);
			if ( !(_la==T__11 || _la==T__12) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompareOpContext extends ParserRuleContext {
		public CompareOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compareOp; }
	}

	public final CompareOpContext compareOp() throws RecognitionException {
		CompareOpContext _localctx = new CompareOpContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_compareOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1032192L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(SimpleParser.INTEGER, 0); }
		public TerminalNode NUMBER() { return getToken(SimpleParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(SimpleParser.STRING, 0); }
		public TerminalNode BOOL() { return getToken(SimpleParser.BOOL, 0); }
		public TerminalNode NULL() { return getToken(SimpleParser.NULL, 0); }
		public TerminalNode CHARACTER() { return getToken(SimpleParser.CHARACTER, 0); }
		public TerminalNode TEXT() { return getToken(SimpleParser.TEXT, 0); }
		public TerminalNode UTC_DATE() { return getToken(SimpleParser.UTC_DATE, 0); }
		public TerminalNode ISO8601() { return getToken(SimpleParser.ISO8601, 0); }
		public TerminalNode BIN() { return getToken(SimpleParser.BIN, 0); }
		public TerminalNode BINARY() { return getToken(SimpleParser.BINARY, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			_la = _input.LA(1);
			if ( !(((((_la - 51)) & ~0x3f) == 0 && ((1L << (_la - 51)) & 16249L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForStmtContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SimpleParser.IDENTIFIER, 0); }
		public List<TerminalNode> INTEGER() { return getTokens(SimpleParser.INTEGER); }
		public TerminalNode INTEGER(int i) {
			return getToken(SimpleParser.INTEGER, i);
		}
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public ForStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStmt; }
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_forStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(T__19);
			setState(151);
			match(IDENTIFIER);
			setState(152);
			match(T__20);
			setState(153);
			match(INTEGER);
			setState(154);
			match(T__21);
			setState(155);
			match(INTEGER);
			setState(156);
			match(T__1);
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==IDENTIFIER) {
				{
				{
				setState(157);
				line();
				}
				}
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(163);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RepeatStmtContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(SimpleParser.INTEGER, 0); }
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public RepeatStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatStmt; }
	}

	public final RepeatStmtContext repeatStmt() throws RecognitionException {
		RepeatStmtContext _localctx = new RepeatStmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_repeatStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(T__22);
			setState(166);
			match(INTEGER);
			setState(167);
			match(T__23);
			setState(168);
			match(T__1);
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==IDENTIFIER) {
				{
				{
				setState(169);
				line();
				}
				}
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(175);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LoopStmtContext extends ParserRuleContext {
		public List<TerminalNode> INTEGER() { return getTokens(SimpleParser.INTEGER); }
		public TerminalNode INTEGER(int i) {
			return getToken(SimpleParser.INTEGER, i);
		}
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public LoopStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopStmt; }
	}

	public final LoopStmtContext loopStmt() throws RecognitionException {
		LoopStmtContext _localctx = new LoopStmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_loopStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(T__24);
			setState(178);
			match(INTEGER);
			setState(179);
			match(T__21);
			setState(180);
			match(INTEGER);
			setState(181);
			match(T__1);
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==IDENTIFIER) {
				{
				{
				setState(182);
				line();
				}
				}
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(188);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStmtContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CompareOpContext compareOp() {
			return getRuleContext(CompareOpContext.class,0);
		}
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_whileStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(T__25);
			setState(191);
			expr(0);
			setState(192);
			compareOp();
			setState(193);
			expr(0);
			setState(194);
			match(T__1);
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==IDENTIFIER) {
				{
				{
				setState(195);
				line();
				}
				}
				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(201);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(SimpleParser.NUMBER, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SimpleParser.IDENTIFIER, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OP() { return getToken(SimpleParser.OP, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				{
				setState(204);
				match(NUMBER);
				}
				break;
			case IDENTIFIER:
				{
				setState(205);
				match(IDENTIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(213);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(208);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(209);
					match(OP);
					setState(210);
					expr(2);
					}
					} 
				}
				setState(215);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UntilStmtContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CompareOpContext compareOp() {
			return getRuleContext(CompareOpContext.class,0);
		}
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public UntilStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_untilStmt; }
	}

	public final UntilStmtContext untilStmt() throws RecognitionException {
		UntilStmtContext _localctx = new UntilStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_untilStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(T__26);
			setState(217);
			expr(0);
			setState(218);
			compareOp();
			setState(219);
			expr(0);
			setState(220);
			match(T__1);
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==IDENTIFIER) {
				{
				{
				setState(221);
				line();
				}
				}
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(227);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AsLongStmtContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CustomCompOpContext customCompOp() {
			return getRuleContext(CustomCompOpContext.class,0);
		}
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public AsLongStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asLongStmt; }
	}

	public final AsLongStmtContext asLongStmt() throws RecognitionException {
		AsLongStmtContext _localctx = new AsLongStmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_asLongStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(T__27);
			setState(230);
			match(T__28);
			setState(231);
			match(T__27);
			setState(232);
			expr(0);
			setState(233);
			customCompOp();
			setState(234);
			expr(0);
			setState(235);
			match(T__1);
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==IDENTIFIER) {
				{
				{
				setState(236);
				line();
				}
				}
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(242);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CustomCompOpContext extends ParserRuleContext {
		public CustomCompOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_customCompOp; }
	}

	public final CustomCompOpContext customCompOp() throws RecognitionException {
		CustomCompOpContext _localctx = new CustomCompOpContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_customCompOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 136365211648L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DoWhileStmtContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CustomCompOpContext customCompOp() {
			return getRuleContext(CustomCompOpContext.class,0);
		}
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public DoWhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhileStmt; }
	}

	public final DoWhileStmtContext doWhileStmt() throws RecognitionException {
		DoWhileStmtContext _localctx = new DoWhileStmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_doWhileStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(T__36);
			setState(247);
			match(T__1);
			setState(251);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==IDENTIFIER) {
				{
				{
				setState(248);
				line();
				}
				}
				setState(253);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(254);
			match(T__2);
			setState(255);
			match(T__25);
			setState(256);
			expr(0);
			setState(257);
			customCompOp();
			setState(258);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RepeatAsLongStmtContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CustomCompOpContext customCompOp() {
			return getRuleContext(CustomCompOpContext.class,0);
		}
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public RepeatAsLongStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatAsLongStmt; }
	}

	public final RepeatAsLongStmtContext repeatAsLongStmt() throws RecognitionException {
		RepeatAsLongStmtContext _localctx = new RepeatAsLongStmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_repeatAsLongStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(T__22);
			setState(261);
			match(T__1);
			setState(265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==IDENTIFIER) {
				{
				{
				setState(262);
				line();
				}
				}
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(268);
			match(T__2);
			setState(269);
			match(T__37);
			setState(270);
			expr(0);
			setState(271);
			customCompOp();
			setState(272);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RepeatUntilStmtContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CustomCompOpContext customCompOp() {
			return getRuleContext(CustomCompOpContext.class,0);
		}
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public RepeatUntilStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatUntilStmt; }
	}

	public final RepeatUntilStmtContext repeatUntilStmt() throws RecognitionException {
		RepeatUntilStmtContext _localctx = new RepeatUntilStmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_repeatUntilStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(T__22);
			setState(275);
			match(T__1);
			setState(279);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==IDENTIFIER) {
				{
				{
				setState(276);
				line();
				}
				}
				setState(281);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(282);
			match(T__2);
			setState(283);
			match(T__26);
			setState(284);
			expr(0);
			setState(285);
			customCompOp();
			setState(286);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DoAsLongStmtContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CustomCompOpContext customCompOp() {
			return getRuleContext(CustomCompOpContext.class,0);
		}
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public DoAsLongStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doAsLongStmt; }
	}

	public final DoAsLongStmtContext doAsLongStmt() throws RecognitionException {
		DoAsLongStmtContext _localctx = new DoAsLongStmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_doAsLongStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(T__36);
			setState(289);
			match(T__1);
			setState(293);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==IDENTIFIER) {
				{
				{
				setState(290);
				line();
				}
				}
				setState(295);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(296);
			match(T__2);
			setState(297);
			match(T__37);
			setState(298);
			expr(0);
			setState(299);
			customCompOp();
			setState(300);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WriteFileStmtContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SimpleParser.IDENTIFIER, 0); }
		public TerminalNode STRING() { return getToken(SimpleParser.STRING, 0); }
		public WriteFileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writeFileStmt; }
	}

	public final WriteFileStmtContext writeFileStmt() throws RecognitionException {
		WriteFileStmtContext _localctx = new WriteFileStmtContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_writeFileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			match(T__38);
			setState(303);
			match(IDENTIFIER);
			setState(304);
			match(T__39);
			setState(305);
			match(T__40);
			setState(306);
			match(T__4);
			setState(307);
			match(STRING);
			setState(308);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IsNullStmtContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(SimpleParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(SimpleParser.IDENTIFIER, i);
		}
		public IsNullStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_isNullStmt; }
	}

	public final IsNullStmtContext isNullStmt() throws RecognitionException {
		IsNullStmtContext _localctx = new IsNullStmtContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_isNullStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			match(T__38);
			setState(311);
			match(IDENTIFIER);
			setState(312);
			match(T__39);
			setState(313);
			match(T__41);
			setState(314);
			match(T__4);
			setState(315);
			match(IDENTIFIER);
			setState(316);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExistsStmtContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(SimpleParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(SimpleParser.IDENTIFIER, i);
		}
		public TerminalNode STRING() { return getToken(SimpleParser.STRING, 0); }
		public ExistsStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_existsStmt; }
	}

	public final ExistsStmtContext existsStmt() throws RecognitionException {
		ExistsStmtContext _localctx = new ExistsStmtContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_existsStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			match(T__38);
			setState(319);
			match(IDENTIFIER);
			setState(320);
			match(T__39);
			setState(321);
			match(T__42);
			setState(322);
			match(T__4);
			setState(323);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==STRING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(324);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SleepStmtContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(SimpleParser.INTEGER, 0); }
		public SleepStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sleepStmt; }
	}

	public final SleepStmtContext sleepStmt() throws RecognitionException {
		SleepStmtContext _localctx = new SleepStmtContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_sleepStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			match(T__43);
			setState(327);
			match(T__4);
			setState(328);
			match(INTEGER);
			setState(329);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReadFileStmtContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SimpleParser.IDENTIFIER, 0); }
		public TerminalNode STRING() { return getToken(SimpleParser.STRING, 0); }
		public ReadFileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readFileStmt; }
	}

	public final ReadFileStmtContext readFileStmt() throws RecognitionException {
		ReadFileStmtContext _localctx = new ReadFileStmtContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_readFileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			match(IDENTIFIER);
			setState(332);
			match(T__39);
			setState(333);
			match(T__44);
			setState(334);
			match(T__4);
			setState(335);
			match(STRING);
			setState(336);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeleteFileStmtContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(SimpleParser.STRING, 0); }
		public DeleteFileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deleteFileStmt; }
	}

	public final DeleteFileStmtContext deleteFileStmt() throws RecognitionException {
		DeleteFileStmtContext _localctx = new DeleteFileStmtContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_deleteFileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			match(T__45);
			setState(339);
			match(T__4);
			setState(340);
			match(STRING);
			setState(341);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CreateFolderStmtContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(SimpleParser.STRING, 0); }
		public CreateFolderStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createFolderStmt; }
	}

	public final CreateFolderStmtContext createFolderStmt() throws RecognitionException {
		CreateFolderStmtContext _localctx = new CreateFolderStmtContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_createFolderStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			match(T__46);
			setState(344);
			match(T__4);
			setState(345);
			match(STRING);
			setState(346);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeleteFolderStmtContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(SimpleParser.STRING, 0); }
		public DeleteFolderStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deleteFolderStmt; }
	}

	public final DeleteFolderStmtContext deleteFolderStmt() throws RecognitionException {
		DeleteFolderStmtContext _localctx = new DeleteFolderStmtContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_deleteFolderStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
			match(T__47);
			setState(349);
			match(T__4);
			setState(350);
			match(STRING);
			setState(351);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OpenFileStmtContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(SimpleParser.STRING, 0); }
		public OpenFileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_openFileStmt; }
	}

	public final OpenFileStmtContext openFileStmt() throws RecognitionException {
		OpenFileStmtContext _localctx = new OpenFileStmtContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_openFileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			match(T__48);
			setState(354);
			match(T__4);
			setState(355);
			match(STRING);
			setState(356);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MinExprContext extends ParserRuleContext {
		public MinExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_minExpr; }
	 
		public MinExprContext() { }
		public void copyFrom(MinExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MinFunctionCallContext extends MinExprContext {
		public TerminalNode IDENTIFIER() { return getToken(SimpleParser.IDENTIFIER, 0); }
		public NumberListContext numberList() {
			return getRuleContext(NumberListContext.class,0);
		}
		public MinFunctionCallContext(MinExprContext ctx) { copyFrom(ctx); }
	}

	public final MinExprContext minExpr() throws RecognitionException {
		MinExprContext _localctx = new MinExprContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_minExpr);
		try {
			_localctx = new MinFunctionCallContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			match(IDENTIFIER);
			setState(359);
			match(T__39);
			setState(360);
			match(T__49);
			setState(361);
			match(T__4);
			setState(362);
			numberList();
			setState(363);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NumberListContext extends ParserRuleContext {
		public List<TerminalNode> NUMBER() { return getTokens(SimpleParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(SimpleParser.NUMBER, i);
		}
		public NumberListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberList; }
	}

	public final NumberListContext numberList() throws RecognitionException {
		NumberListContext _localctx = new NumberListContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_numberList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			match(NUMBER);
			setState(370);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(366);
				match(T__5);
				setState(367);
				match(NUMBER);
				}
				}
				setState(372);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 15:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001C\u0176\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0001\u0000\u0005"+
		"\u0000F\b\u0000\n\u0000\f\u0000I\t\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0003\u0001O\b\u0001\u0001\u0002\u0001\u0002\u0003"+
		"\u0002S\b\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0005"+
		"\u0003Y\b\u0003\n\u0003\f\u0003\\\t\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0005\u0005i\b\u0005\n\u0005\f\u0005l\t"+
		"\u0005\u0003\u0005n\b\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0003\u0006|\b\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u008a"+
		"\b\u0006\n\u0006\f\u0006\u008d\t\u0006\u0001\u0007\u0001\u0007\u0001\b"+
		"\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005"+
		"\u000b\u009f\b\u000b\n\u000b\f\u000b\u00a2\t\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u00ab\b\f\n\f\f\f\u00ae"+
		"\t\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005"+
		"\r\u00b8\b\r\n\r\f\r\u00bb\t\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u00c5\b\u000e"+
		"\n\u000e\f\u000e\u00c8\t\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0003\u000f\u00cf\b\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0005\u000f\u00d4\b\u000f\n\u000f\f\u000f\u00d7\t\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010"+
		"\u00df\b\u0010\n\u0010\f\u0010\u00e2\t\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0005\u0011\u00ee\b\u0011\n\u0011\f\u0011\u00f1\t\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0005\u0013\u00fa\b\u0013\n\u0013\f\u0013\u00fd\t\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u0108\b\u0014\n\u0014\f\u0014"+
		"\u010b\t\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u0116\b\u0015"+
		"\n\u0015\f\u0015\u0119\t\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0005"+
		"\u0016\u0124\b\u0016\n\u0016\f\u0016\u0127\t\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001!\u0001!\u0001"+
		"!\u0005!\u0171\b!\n!\f!\u0174\t!\u0001!\u0000\u0002\f\u001e\"\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.02468:<>@B\u0000\u0006\u0001\u0000\t\u000b\u0001\u0000\f\r\u0001"+
		"\u0000\u000e\u0013\u0003\u00003369;@\u0001\u0000\u001e$\u0002\u000055"+
		"88\u016d\u0000G\u0001\u0000\u0000\u0000\u0002N\u0001\u0000\u0000\u0000"+
		"\u0004R\u0001\u0000\u0000\u0000\u0006V\u0001\u0000\u0000\u0000\b_\u0001"+
		"\u0000\u0000\u0000\nc\u0001\u0000\u0000\u0000\f{\u0001\u0000\u0000\u0000"+
		"\u000e\u008e\u0001\u0000\u0000\u0000\u0010\u0090\u0001\u0000\u0000\u0000"+
		"\u0012\u0092\u0001\u0000\u0000\u0000\u0014\u0094\u0001\u0000\u0000\u0000"+
		"\u0016\u0096\u0001\u0000\u0000\u0000\u0018\u00a5\u0001\u0000\u0000\u0000"+
		"\u001a\u00b1\u0001\u0000\u0000\u0000\u001c\u00be\u0001\u0000\u0000\u0000"+
		"\u001e\u00ce\u0001\u0000\u0000\u0000 \u00d8\u0001\u0000\u0000\u0000\""+
		"\u00e5\u0001\u0000\u0000\u0000$\u00f4\u0001\u0000\u0000\u0000&\u00f6\u0001"+
		"\u0000\u0000\u0000(\u0104\u0001\u0000\u0000\u0000*\u0112\u0001\u0000\u0000"+
		"\u0000,\u0120\u0001\u0000\u0000\u0000.\u012e\u0001\u0000\u0000\u00000"+
		"\u0136\u0001\u0000\u0000\u00002\u013e\u0001\u0000\u0000\u00004\u0146\u0001"+
		"\u0000\u0000\u00006\u014b\u0001\u0000\u0000\u00008\u0152\u0001\u0000\u0000"+
		"\u0000:\u0157\u0001\u0000\u0000\u0000<\u015c\u0001\u0000\u0000\u0000>"+
		"\u0161\u0001\u0000\u0000\u0000@\u0166\u0001\u0000\u0000\u0000B\u016d\u0001"+
		"\u0000\u0000\u0000DF\u0003\u0002\u0001\u0000ED\u0001\u0000\u0000\u0000"+
		"FI\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000"+
		"\u0000HJ\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000JK\u0005\u0000"+
		"\u0000\u0001K\u0001\u0001\u0000\u0000\u0000LO\u0003\u0004\u0002\u0000"+
		"MO\u0003\u0006\u0003\u0000NL\u0001\u0000\u0000\u0000NM\u0001\u0000\u0000"+
		"\u0000O\u0003\u0001\u0000\u0000\u0000PS\u0003\b\u0004\u0000QS\u0003\n"+
		"\u0005\u0000RP\u0001\u0000\u0000\u0000RQ\u0001\u0000\u0000\u0000ST\u0001"+
		"\u0000\u0000\u0000TU\u0005\u0001\u0000\u0000U\u0005\u0001\u0000\u0000"+
		"\u0000VZ\u0005\u0002\u0000\u0000WY\u0003\u0002\u0001\u0000XW\u0001\u0000"+
		"\u0000\u0000Y\\\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000\u0000Z[\u0001"+
		"\u0000\u0000\u0000[]\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000"+
		"]^\u0005\u0003\u0000\u0000^\u0007\u0001\u0000\u0000\u0000_`\u00055\u0000"+
		"\u0000`a\u0005\u0004\u0000\u0000ab\u0003\f\u0006\u0000b\t\u0001\u0000"+
		"\u0000\u0000cd\u00055\u0000\u0000dm\u0005\u0005\u0000\u0000ej\u0003\f"+
		"\u0006\u0000fg\u0005\u0006\u0000\u0000gi\u0003\f\u0006\u0000hf\u0001\u0000"+
		"\u0000\u0000il\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000jk\u0001"+
		"\u0000\u0000\u0000kn\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000"+
		"me\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000no\u0001\u0000\u0000"+
		"\u0000op\u0005\u0007\u0000\u0000p\u000b\u0001\u0000\u0000\u0000qr\u0006"+
		"\u0006\uffff\uffff\u0000r|\u0003\u0014\n\u0000s|\u00055\u0000\u0000t|"+
		"\u0003\n\u0005\u0000uv\u0005\u0005\u0000\u0000vw\u0003\f\u0006\u0000w"+
		"x\u0005\u0007\u0000\u0000x|\u0001\u0000\u0000\u0000yz\u0005\b\u0000\u0000"+
		"z|\u0003\f\u0006\u0004{q\u0001\u0000\u0000\u0000{s\u0001\u0000\u0000\u0000"+
		"{t\u0001\u0000\u0000\u0000{u\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000"+
		"\u0000|\u008b\u0001\u0000\u0000\u0000}~\n\u0003\u0000\u0000~\u007f\u0003"+
		"\u000e\u0007\u0000\u007f\u0080\u0003\f\u0006\u0004\u0080\u008a\u0001\u0000"+
		"\u0000\u0000\u0081\u0082\n\u0002\u0000\u0000\u0082\u0083\u0003\u0010\b"+
		"\u0000\u0083\u0084\u0003\f\u0006\u0003\u0084\u008a\u0001\u0000\u0000\u0000"+
		"\u0085\u0086\n\u0001\u0000\u0000\u0086\u0087\u0003\u0012\t\u0000\u0087"+
		"\u0088\u0003\f\u0006\u0002\u0088\u008a\u0001\u0000\u0000\u0000\u0089}"+
		"\u0001\u0000\u0000\u0000\u0089\u0081\u0001\u0000\u0000\u0000\u0089\u0085"+
		"\u0001\u0000\u0000\u0000\u008a\u008d\u0001\u0000\u0000\u0000\u008b\u0089"+
		"\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\r\u0001"+
		"\u0000\u0000\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008e\u008f\u0007"+
		"\u0000\u0000\u0000\u008f\u000f\u0001\u0000\u0000\u0000\u0090\u0091\u0007"+
		"\u0001\u0000\u0000\u0091\u0011\u0001\u0000\u0000\u0000\u0092\u0093\u0007"+
		"\u0002\u0000\u0000\u0093\u0013\u0001\u0000\u0000\u0000\u0094\u0095\u0007"+
		"\u0003\u0000\u0000\u0095\u0015\u0001\u0000\u0000\u0000\u0096\u0097\u0005"+
		"\u0014\u0000\u0000\u0097\u0098\u00055\u0000\u0000\u0098\u0099\u0005\u0015"+
		"\u0000\u0000\u0099\u009a\u00056\u0000\u0000\u009a\u009b\u0005\u0016\u0000"+
		"\u0000\u009b\u009c\u00056\u0000\u0000\u009c\u00a0\u0005\u0002\u0000\u0000"+
		"\u009d\u009f\u0003\u0002\u0001\u0000\u009e\u009d\u0001\u0000\u0000\u0000"+
		"\u009f\u00a2\u0001\u0000\u0000\u0000\u00a0\u009e\u0001\u0000\u0000\u0000"+
		"\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u00a3\u0001\u0000\u0000\u0000"+
		"\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005\u0003\u0000\u0000"+
		"\u00a4\u0017\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005\u0017\u0000\u0000"+
		"\u00a6\u00a7\u00056\u0000\u0000\u00a7\u00a8\u0005\u0018\u0000\u0000\u00a8"+
		"\u00ac\u0005\u0002\u0000\u0000\u00a9\u00ab\u0003\u0002\u0001\u0000\u00aa"+
		"\u00a9\u0001\u0000\u0000\u0000\u00ab\u00ae\u0001\u0000\u0000\u0000\u00ac"+
		"\u00aa\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad"+
		"\u00af\u0001\u0000\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000\u00af"+
		"\u00b0\u0005\u0003\u0000\u0000\u00b0\u0019\u0001\u0000\u0000\u0000\u00b1"+
		"\u00b2\u0005\u0019\u0000\u0000\u00b2\u00b3\u00056\u0000\u0000\u00b3\u00b4"+
		"\u0005\u0016\u0000\u0000\u00b4\u00b5\u00056\u0000\u0000\u00b5\u00b9\u0005"+
		"\u0002\u0000\u0000\u00b6\u00b8\u0003\u0002\u0001\u0000\u00b7\u00b6\u0001"+
		"\u0000\u0000\u0000\u00b8\u00bb\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001"+
		"\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba\u00bc\u0001"+
		"\u0000\u0000\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bc\u00bd\u0005"+
		"\u0003\u0000\u0000\u00bd\u001b\u0001\u0000\u0000\u0000\u00be\u00bf\u0005"+
		"\u001a\u0000\u0000\u00bf\u00c0\u0003\u001e\u000f\u0000\u00c0\u00c1\u0003"+
		"\u0012\t\u0000\u00c1\u00c2\u0003\u001e\u000f\u0000\u00c2\u00c6\u0005\u0002"+
		"\u0000\u0000\u00c3\u00c5\u0003\u0002\u0001\u0000\u00c4\u00c3\u0001\u0000"+
		"\u0000\u0000\u00c5\u00c8\u0001\u0000\u0000\u0000\u00c6\u00c4\u0001\u0000"+
		"\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7\u00c9\u0001\u0000"+
		"\u0000\u0000\u00c8\u00c6\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005\u0003"+
		"\u0000\u0000\u00ca\u001d\u0001\u0000\u0000\u0000\u00cb\u00cc\u0006\u000f"+
		"\uffff\uffff\u0000\u00cc\u00cf\u00057\u0000\u0000\u00cd\u00cf\u00055\u0000"+
		"\u0000\u00ce\u00cb\u0001\u0000\u0000\u0000\u00ce\u00cd\u0001\u0000\u0000"+
		"\u0000\u00cf\u00d5\u0001\u0000\u0000\u0000\u00d0\u00d1\n\u0001\u0000\u0000"+
		"\u00d1\u00d2\u0005C\u0000\u0000\u00d2\u00d4\u0003\u001e\u000f\u0002\u00d3"+
		"\u00d0\u0001\u0000\u0000\u0000\u00d4\u00d7\u0001\u0000\u0000\u0000\u00d5"+
		"\u00d3\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000\u00d6"+
		"\u001f\u0001\u0000\u0000\u0000\u00d7\u00d5\u0001\u0000\u0000\u0000\u00d8"+
		"\u00d9\u0005\u001b\u0000\u0000\u00d9\u00da\u0003\u001e\u000f\u0000\u00da"+
		"\u00db\u0003\u0012\t\u0000\u00db\u00dc\u0003\u001e\u000f\u0000\u00dc\u00e0"+
		"\u0005\u0002\u0000\u0000\u00dd\u00df\u0003\u0002\u0001\u0000\u00de\u00dd"+
		"\u0001\u0000\u0000\u0000\u00df\u00e2\u0001\u0000\u0000\u0000\u00e0\u00de"+
		"\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1\u00e3"+
		"\u0001\u0000\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000\u00e3\u00e4"+
		"\u0005\u0003\u0000\u0000\u00e4!\u0001\u0000\u0000\u0000\u00e5\u00e6\u0005"+
		"\u001c\u0000\u0000\u00e6\u00e7\u0005\u001d\u0000\u0000\u00e7\u00e8\u0005"+
		"\u001c\u0000\u0000\u00e8\u00e9\u0003\u001e\u000f\u0000\u00e9\u00ea\u0003"+
		"$\u0012\u0000\u00ea\u00eb\u0003\u001e\u000f\u0000\u00eb\u00ef\u0005\u0002"+
		"\u0000\u0000\u00ec\u00ee\u0003\u0002\u0001\u0000\u00ed\u00ec\u0001\u0000"+
		"\u0000\u0000\u00ee\u00f1\u0001\u0000\u0000\u0000\u00ef\u00ed\u0001\u0000"+
		"\u0000\u0000\u00ef\u00f0\u0001\u0000\u0000\u0000\u00f0\u00f2\u0001\u0000"+
		"\u0000\u0000\u00f1\u00ef\u0001\u0000\u0000\u0000\u00f2\u00f3\u0005\u0003"+
		"\u0000\u0000\u00f3#\u0001\u0000\u0000\u0000\u00f4\u00f5\u0007\u0004\u0000"+
		"\u0000\u00f5%\u0001\u0000\u0000\u0000\u00f6\u00f7\u0005%\u0000\u0000\u00f7"+
		"\u00fb\u0005\u0002\u0000\u0000\u00f8\u00fa\u0003\u0002\u0001\u0000\u00f9"+
		"\u00f8\u0001\u0000\u0000\u0000\u00fa\u00fd\u0001\u0000\u0000\u0000\u00fb"+
		"\u00f9\u0001\u0000\u0000\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc"+
		"\u00fe\u0001\u0000\u0000\u0000\u00fd\u00fb\u0001\u0000\u0000\u0000\u00fe"+
		"\u00ff\u0005\u0003\u0000\u0000\u00ff\u0100\u0005\u001a\u0000\u0000\u0100"+
		"\u0101\u0003\u001e\u000f\u0000\u0101\u0102\u0003$\u0012\u0000\u0102\u0103"+
		"\u0003\u001e\u000f\u0000\u0103\'\u0001\u0000\u0000\u0000\u0104\u0105\u0005"+
		"\u0017\u0000\u0000\u0105\u0109\u0005\u0002\u0000\u0000\u0106\u0108\u0003"+
		"\u0002\u0001\u0000\u0107\u0106\u0001\u0000\u0000\u0000\u0108\u010b\u0001"+
		"\u0000\u0000\u0000\u0109\u0107\u0001\u0000\u0000\u0000\u0109\u010a\u0001"+
		"\u0000\u0000\u0000\u010a\u010c\u0001\u0000\u0000\u0000\u010b\u0109\u0001"+
		"\u0000\u0000\u0000\u010c\u010d\u0005\u0003\u0000\u0000\u010d\u010e\u0005"+
		"&\u0000\u0000\u010e\u010f\u0003\u001e\u000f\u0000\u010f\u0110\u0003$\u0012"+
		"\u0000\u0110\u0111\u0003\u001e\u000f\u0000\u0111)\u0001\u0000\u0000\u0000"+
		"\u0112\u0113\u0005\u0017\u0000\u0000\u0113\u0117\u0005\u0002\u0000\u0000"+
		"\u0114\u0116\u0003\u0002\u0001\u0000\u0115\u0114\u0001\u0000\u0000\u0000"+
		"\u0116\u0119\u0001\u0000\u0000\u0000\u0117\u0115\u0001\u0000\u0000\u0000"+
		"\u0117\u0118\u0001\u0000\u0000\u0000\u0118\u011a\u0001\u0000\u0000\u0000"+
		"\u0119\u0117\u0001\u0000\u0000\u0000\u011a\u011b\u0005\u0003\u0000\u0000"+
		"\u011b\u011c\u0005\u001b\u0000\u0000\u011c\u011d\u0003\u001e\u000f\u0000"+
		"\u011d\u011e\u0003$\u0012\u0000\u011e\u011f\u0003\u001e\u000f\u0000\u011f"+
		"+\u0001\u0000\u0000\u0000\u0120\u0121\u0005%\u0000\u0000\u0121\u0125\u0005"+
		"\u0002\u0000\u0000\u0122\u0124\u0003\u0002\u0001\u0000\u0123\u0122\u0001"+
		"\u0000\u0000\u0000\u0124\u0127\u0001\u0000\u0000\u0000\u0125\u0123\u0001"+
		"\u0000\u0000\u0000\u0125\u0126\u0001\u0000\u0000\u0000\u0126\u0128\u0001"+
		"\u0000\u0000\u0000\u0127\u0125\u0001\u0000\u0000\u0000\u0128\u0129\u0005"+
		"\u0003\u0000\u0000\u0129\u012a\u0005&\u0000\u0000\u012a\u012b\u0003\u001e"+
		"\u000f\u0000\u012b\u012c\u0003$\u0012\u0000\u012c\u012d\u0003\u001e\u000f"+
		"\u0000\u012d-\u0001\u0000\u0000\u0000\u012e\u012f\u0005\'\u0000\u0000"+
		"\u012f\u0130\u00055\u0000\u0000\u0130\u0131\u0005(\u0000\u0000\u0131\u0132"+
		"\u0005)\u0000\u0000\u0132\u0133\u0005\u0005\u0000\u0000\u0133\u0134\u0005"+
		"8\u0000\u0000\u0134\u0135\u0005\u0007\u0000\u0000\u0135/\u0001\u0000\u0000"+
		"\u0000\u0136\u0137\u0005\'\u0000\u0000\u0137\u0138\u00055\u0000\u0000"+
		"\u0138\u0139\u0005(\u0000\u0000\u0139\u013a\u0005*\u0000\u0000\u013a\u013b"+
		"\u0005\u0005\u0000\u0000\u013b\u013c\u00055\u0000\u0000\u013c\u013d\u0005"+
		"\u0007\u0000\u0000\u013d1\u0001\u0000\u0000\u0000\u013e\u013f\u0005\'"+
		"\u0000\u0000\u013f\u0140\u00055\u0000\u0000\u0140\u0141\u0005(\u0000\u0000"+
		"\u0141\u0142\u0005+\u0000\u0000\u0142\u0143\u0005\u0005\u0000\u0000\u0143"+
		"\u0144\u0007\u0005\u0000\u0000\u0144\u0145\u0005\u0007\u0000\u0000\u0145"+
		"3\u0001\u0000\u0000\u0000\u0146\u0147\u0005,\u0000\u0000\u0147\u0148\u0005"+
		"\u0005\u0000\u0000\u0148\u0149\u00056\u0000\u0000\u0149\u014a\u0005\u0007"+
		"\u0000\u0000\u014a5\u0001\u0000\u0000\u0000\u014b\u014c\u00055\u0000\u0000"+
		"\u014c\u014d\u0005(\u0000\u0000\u014d\u014e\u0005-\u0000\u0000\u014e\u014f"+
		"\u0005\u0005\u0000\u0000\u014f\u0150\u00058\u0000\u0000\u0150\u0151\u0005"+
		"\u0007\u0000\u0000\u01517\u0001\u0000\u0000\u0000\u0152\u0153\u0005.\u0000"+
		"\u0000\u0153\u0154\u0005\u0005\u0000\u0000\u0154\u0155\u00058\u0000\u0000"+
		"\u0155\u0156\u0005\u0007\u0000\u0000\u01569\u0001\u0000\u0000\u0000\u0157"+
		"\u0158\u0005/\u0000\u0000\u0158\u0159\u0005\u0005\u0000\u0000\u0159\u015a"+
		"\u00058\u0000\u0000\u015a\u015b\u0005\u0007\u0000\u0000\u015b;\u0001\u0000"+
		"\u0000\u0000\u015c\u015d\u00050\u0000\u0000\u015d\u015e\u0005\u0005\u0000"+
		"\u0000\u015e\u015f\u00058\u0000\u0000\u015f\u0160\u0005\u0007\u0000\u0000"+
		"\u0160=\u0001\u0000\u0000\u0000\u0161\u0162\u00051\u0000\u0000\u0162\u0163"+
		"\u0005\u0005\u0000\u0000\u0163\u0164\u00058\u0000\u0000\u0164\u0165\u0005"+
		"\u0007\u0000\u0000\u0165?\u0001\u0000\u0000\u0000\u0166\u0167\u00055\u0000"+
		"\u0000\u0167\u0168\u0005(\u0000\u0000\u0168\u0169\u00052\u0000\u0000\u0169"+
		"\u016a\u0005\u0005\u0000\u0000\u016a\u016b\u0003B!\u0000\u016b\u016c\u0005"+
		"\u0007\u0000\u0000\u016cA\u0001\u0000\u0000\u0000\u016d\u0172\u00057\u0000"+
		"\u0000\u016e\u016f\u0005\u0006\u0000\u0000\u016f\u0171\u00057\u0000\u0000"+
		"\u0170\u016e\u0001\u0000\u0000\u0000\u0171\u0174\u0001\u0000\u0000\u0000"+
		"\u0172\u0170\u0001\u0000\u0000\u0000\u0172\u0173\u0001\u0000\u0000\u0000"+
		"\u0173C\u0001\u0000\u0000\u0000\u0174\u0172\u0001\u0000\u0000\u0000\u0016"+
		"GNRZjm{\u0089\u008b\u00a0\u00ac\u00b9\u00c6\u00ce\u00d5\u00e0\u00ef\u00fb"+
		"\u0109\u0117\u0125\u0172";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}