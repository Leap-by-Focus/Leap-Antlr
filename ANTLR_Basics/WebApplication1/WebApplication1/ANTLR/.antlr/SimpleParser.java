// Generated from c:/Users/shram/Documents/GitHub/Leap-Antlr/ANTLR_Basics/WebApplication1/WebApplication1/ANTLR/Simple.g4 by ANTLR 4.13.1
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
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, BOOL=58, WS=59, IDENTIFIER=60, 
		INTEGER=61, NUMBER=62, STRING=63, TEXT=64, CHAR=65, CHARACTER=66, NULL=67, 
		BIN=68, BINARY=69, UTC_DATE=70, ISO8601=71, LINE_COMMENT=72, BLOCK_COMMENT=73, 
		OP=74;
	public static final int
		RULE_program = 0, RULE_line = 1, RULE_statement = 2, RULE_block = 3, RULE_assignment = 4, 
		RULE_functionCall = 5, RULE_expression = 6, RULE_multiOp = 7, RULE_addOp = 8, 
		RULE_compareOp = 9, RULE_constant = 10, RULE_forStmt = 11, RULE_repeatStmt = 12, 
		RULE_loopStmt = 13, RULE_whileStmt = 14, RULE_expr = 15, RULE_untilStmt = 16, 
		RULE_asLongStmt = 17, RULE_customCompOp = 18, RULE_doWhileStmt = 19, RULE_repeatAsLongStmt = 20, 
		RULE_repeatUntilStmt = 21, RULE_doAsLongStmt = 22, RULE_writeFileStmt = 23, 
		RULE_isNullStmt = 24, RULE_existsStmt = 25, RULE_sleepStmt = 26, RULE_readFileStmt = 27, 
		RULE_deleteFileStmt = 28, RULE_createFolderStmt = 29, RULE_deleteFolderStmt = 30, 
		RULE_openFileStmt = 31, RULE_minExpr = 32, RULE_numberList = 33, RULE_minListFunctionStmt = 34, 
		RULE_absFunctionStmt = 35, RULE_sqrtFunctionStmt = 36, RULE_roundFunctionStmt = 37, 
		RULE_randomFunctionStmt = 38, RULE_meanFunctionStmt = 39, RULE_medianFunctionStmt = 40, 
		RULE_maxFunctionStmt = 41, RULE_valueList = 42, RULE_maxFromListStmt = 43;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "line", "statement", "block", "assignment", "functionCall", 
			"expression", "multiOp", "addOp", "compareOp", "constant", "forStmt", 
			"repeatStmt", "loopStmt", "whileStmt", "expr", "untilStmt", "asLongStmt", 
			"customCompOp", "doWhileStmt", "repeatAsLongStmt", "repeatUntilStmt", 
			"doAsLongStmt", "writeFileStmt", "isNullStmt", "existsStmt", "sleepStmt", 
			"readFileStmt", "deleteFileStmt", "createFolderStmt", "deleteFolderStmt", 
			"openFileStmt", "minExpr", "numberList", "minListFunctionStmt", "absFunctionStmt", 
			"sqrtFunctionStmt", "roundFunctionStmt", "randomFunctionStmt", "meanFunctionStmt", 
			"medianFunctionStmt", "maxFunctionStmt", "valueList", "maxFromListStmt"
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
			"'OpenFile'", "'Min'", "'Abs'", "'Sqrt'", "'Round'", "'Random'", "'Mean'", 
			"'Median'", "'Max'", null, null, null, null, null, null, null, null, 
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
			null, null, null, null, null, null, null, null, null, null, "BOOL", "WS", 
			"IDENTIFIER", "INTEGER", "NUMBER", "STRING", "TEXT", "CHAR", "CHARACTER", 
			"NULL", "BIN", "BINARY", "UTC_DATE", "ISO8601", "LINE_COMMENT", "BLOCK_COMMENT", 
			"OP"
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
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==IDENTIFIER) {
				{
				{
				setState(88);
				line();
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
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
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				statement();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
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
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(100);
				assignment();
				}
				break;
			case 2:
				{
				setState(101);
				functionCall();
				}
				break;
			}
			setState(104);
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
			setState(106);
			match(T__1);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==IDENTIFIER) {
				{
				{
				setState(107);
				line();
				}
				}
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(113);
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
			setState(115);
			match(IDENTIFIER);
			setState(116);
			match(T__3);
			setState(117);
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
			setState(119);
			match(IDENTIFIER);
			setState(120);
			match(T__4);
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -864691128455134944L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 253L) != 0)) {
				{
				setState(121);
				expression(0);
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(122);
					match(T__5);
					setState(123);
					expression(0);
					}
					}
					setState(128);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(131);
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
			setState(143);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				_localctx = new ConstantExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(134);
				constant();
				}
				break;
			case 2:
				{
				_localctx = new IdentifierExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(135);
				match(IDENTIFIER);
				}
				break;
			case 3:
				{
				_localctx = new FunctionCallExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(136);
				functionCall();
				}
				break;
			case 4:
				{
				_localctx = new ParenthesizedExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(137);
				match(T__4);
				setState(138);
				expression(0);
				setState(139);
				match(T__6);
				}
				break;
			case 5:
				{
				_localctx = new NotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(141);
				match(T__7);
				setState(142);
				expression(4);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(159);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(157);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicateExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(145);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(146);
						multiOp();
						setState(147);
						expression(4);
						}
						break;
					case 2:
						{
						_localctx = new AdditiveExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(149);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(150);
						addOp();
						setState(151);
						expression(3);
						}
						break;
					case 3:
						{
						_localctx = new ComparisonExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(153);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(154);
						compareOp();
						setState(155);
						expression(2);
						}
						break;
					}
					} 
				}
				setState(161);
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
			setState(162);
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
			setState(164);
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
			setState(166);
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
			setState(168);
			_la = _input.LA(1);
			if ( !(((((_la - 58)) & ~0x3f) == 0 && ((1L << (_la - 58)) & 16249L) != 0)) ) {
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
			setState(170);
			match(T__19);
			setState(171);
			match(IDENTIFIER);
			setState(172);
			match(T__20);
			setState(173);
			match(INTEGER);
			setState(174);
			match(T__21);
			setState(175);
			match(INTEGER);
			setState(176);
			match(T__1);
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==IDENTIFIER) {
				{
				{
				setState(177);
				line();
				}
				}
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(183);
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
			setState(185);
			match(T__22);
			setState(186);
			match(INTEGER);
			setState(187);
			match(T__23);
			setState(188);
			match(T__1);
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==IDENTIFIER) {
				{
				{
				setState(189);
				line();
				}
				}
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(195);
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
			setState(197);
			match(T__24);
			setState(198);
			match(INTEGER);
			setState(199);
			match(T__21);
			setState(200);
			match(INTEGER);
			setState(201);
			match(T__1);
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==IDENTIFIER) {
				{
				{
				setState(202);
				line();
				}
				}
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(208);
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
			setState(210);
			match(T__25);
			setState(211);
			expr(0);
			setState(212);
			compareOp();
			setState(213);
			expr(0);
			setState(214);
			match(T__1);
			setState(218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==IDENTIFIER) {
				{
				{
				setState(215);
				line();
				}
				}
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(221);
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
			setState(226);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				{
				setState(224);
				match(NUMBER);
				}
				break;
			case IDENTIFIER:
				{
				setState(225);
				match(IDENTIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(233);
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
					setState(228);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(229);
					match(OP);
					setState(230);
					expr(2);
					}
					} 
				}
				setState(235);
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
			setState(236);
			match(T__26);
			setState(237);
			expr(0);
			setState(238);
			compareOp();
			setState(239);
			expr(0);
			setState(240);
			match(T__1);
			setState(244);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==IDENTIFIER) {
				{
				{
				setState(241);
				line();
				}
				}
				setState(246);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(247);
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
			setState(249);
			match(T__27);
			setState(250);
			match(T__28);
			setState(251);
			match(T__27);
			setState(252);
			expr(0);
			setState(253);
			customCompOp();
			setState(254);
			expr(0);
			setState(255);
			match(T__1);
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==IDENTIFIER) {
				{
				{
				setState(256);
				line();
				}
				}
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(262);
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
			setState(264);
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
			setState(266);
			match(T__36);
			setState(267);
			match(T__1);
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==IDENTIFIER) {
				{
				{
				setState(268);
				line();
				}
				}
				setState(273);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(274);
			match(T__2);
			setState(275);
			match(T__25);
			setState(276);
			expr(0);
			setState(277);
			customCompOp();
			setState(278);
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
			setState(280);
			match(T__22);
			setState(281);
			match(T__1);
			setState(285);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==IDENTIFIER) {
				{
				{
				setState(282);
				line();
				}
				}
				setState(287);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(288);
			match(T__2);
			setState(289);
			match(T__37);
			setState(290);
			expr(0);
			setState(291);
			customCompOp();
			setState(292);
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
			setState(294);
			match(T__22);
			setState(295);
			match(T__1);
			setState(299);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==IDENTIFIER) {
				{
				{
				setState(296);
				line();
				}
				}
				setState(301);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(302);
			match(T__2);
			setState(303);
			match(T__26);
			setState(304);
			expr(0);
			setState(305);
			customCompOp();
			setState(306);
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
			setState(308);
			match(T__36);
			setState(309);
			match(T__1);
			setState(313);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==IDENTIFIER) {
				{
				{
				setState(310);
				line();
				}
				}
				setState(315);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(316);
			match(T__2);
			setState(317);
			match(T__37);
			setState(318);
			expr(0);
			setState(319);
			customCompOp();
			setState(320);
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
			setState(322);
			match(T__38);
			setState(323);
			match(IDENTIFIER);
			setState(324);
			match(T__39);
			setState(325);
			match(T__40);
			setState(326);
			match(T__4);
			setState(327);
			match(STRING);
			setState(328);
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
			setState(330);
			match(T__38);
			setState(331);
			match(IDENTIFIER);
			setState(332);
			match(T__39);
			setState(333);
			match(T__41);
			setState(334);
			match(T__4);
			setState(335);
			match(IDENTIFIER);
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
			setState(338);
			match(T__38);
			setState(339);
			match(IDENTIFIER);
			setState(340);
			match(T__39);
			setState(341);
			match(T__42);
			setState(342);
			match(T__4);
			setState(343);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==STRING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(344);
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
			setState(346);
			match(T__43);
			setState(347);
			match(T__4);
			setState(348);
			match(INTEGER);
			setState(349);
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
			setState(351);
			match(IDENTIFIER);
			setState(352);
			match(T__39);
			setState(353);
			match(T__44);
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
			setState(358);
			match(T__45);
			setState(359);
			match(T__4);
			setState(360);
			match(STRING);
			setState(361);
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
			setState(363);
			match(T__46);
			setState(364);
			match(T__4);
			setState(365);
			match(STRING);
			setState(366);
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
			setState(368);
			match(T__47);
			setState(369);
			match(T__4);
			setState(370);
			match(STRING);
			setState(371);
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
			setState(373);
			match(T__48);
			setState(374);
			match(T__4);
			setState(375);
			match(STRING);
			setState(376);
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
			setState(378);
			match(IDENTIFIER);
			setState(379);
			match(T__39);
			setState(380);
			match(T__49);
			setState(381);
			match(T__4);
			setState(382);
			numberList();
			setState(383);
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
			setState(385);
			match(NUMBER);
			setState(390);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(386);
				match(T__5);
				setState(387);
				match(NUMBER);
				}
				}
				setState(392);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MinListFunctionStmtContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(SimpleParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(SimpleParser.IDENTIFIER, i);
		}
		public MinListFunctionStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_minListFunctionStmt; }
	}

	public final MinListFunctionStmtContext minListFunctionStmt() throws RecognitionException {
		MinListFunctionStmtContext _localctx = new MinListFunctionStmtContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_minListFunctionStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(393);
			match(T__38);
			setState(394);
			match(IDENTIFIER);
			setState(395);
			match(T__39);
			setState(396);
			match(T__49);
			setState(397);
			match(T__4);
			setState(398);
			match(IDENTIFIER);
			setState(399);
			match(T__6);
			setState(400);
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
	public static class AbsFunctionStmtContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(SimpleParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(SimpleParser.IDENTIFIER, i);
		}
		public TerminalNode NUMBER() { return getToken(SimpleParser.NUMBER, 0); }
		public AbsFunctionStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_absFunctionStmt; }
	}

	public final AbsFunctionStmtContext absFunctionStmt() throws RecognitionException {
		AbsFunctionStmtContext _localctx = new AbsFunctionStmtContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_absFunctionStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(402);
			match(T__38);
			setState(403);
			match(IDENTIFIER);
			setState(404);
			match(T__39);
			setState(405);
			match(T__50);
			setState(406);
			match(T__4);
			setState(407);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(408);
			match(T__6);
			setState(409);
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
	public static class SqrtFunctionStmtContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(SimpleParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(SimpleParser.IDENTIFIER, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(SimpleParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(SimpleParser.NUMBER, i);
		}
		public SqrtFunctionStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqrtFunctionStmt; }
	}

	public final SqrtFunctionStmtContext sqrtFunctionStmt() throws RecognitionException {
		SqrtFunctionStmtContext _localctx = new SqrtFunctionStmtContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_sqrtFunctionStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(411);
			match(T__38);
			setState(412);
			match(IDENTIFIER);
			setState(413);
			match(T__39);
			setState(414);
			match(T__51);
			setState(415);
			match(T__4);
			setState(416);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(417);
			match(T__5);
			setState(418);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(419);
			match(T__6);
			setState(420);
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
	public static class RoundFunctionStmtContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(SimpleParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(SimpleParser.IDENTIFIER, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(SimpleParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(SimpleParser.NUMBER, i);
		}
		public RoundFunctionStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_roundFunctionStmt; }
	}

	public final RoundFunctionStmtContext roundFunctionStmt() throws RecognitionException {
		RoundFunctionStmtContext _localctx = new RoundFunctionStmtContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_roundFunctionStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(422);
			match(T__38);
			setState(423);
			match(IDENTIFIER);
			setState(424);
			match(T__39);
			setState(425);
			match(T__52);
			setState(426);
			match(T__4);
			setState(427);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(428);
			match(T__5);
			setState(429);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(430);
			match(T__6);
			setState(431);
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
	public static class RandomFunctionStmtContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(SimpleParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(SimpleParser.IDENTIFIER, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(SimpleParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(SimpleParser.NUMBER, i);
		}
		public RandomFunctionStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_randomFunctionStmt; }
	}

	public final RandomFunctionStmtContext randomFunctionStmt() throws RecognitionException {
		RandomFunctionStmtContext _localctx = new RandomFunctionStmtContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_randomFunctionStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(433);
			match(T__38);
			setState(434);
			match(IDENTIFIER);
			setState(435);
			match(T__39);
			setState(436);
			match(T__53);
			setState(437);
			match(T__4);
			setState(438);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(439);
			match(T__5);
			setState(440);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(441);
			match(T__6);
			setState(442);
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
	public static class MeanFunctionStmtContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(SimpleParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(SimpleParser.IDENTIFIER, i);
		}
		public MeanFunctionStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_meanFunctionStmt; }
	}

	public final MeanFunctionStmtContext meanFunctionStmt() throws RecognitionException {
		MeanFunctionStmtContext _localctx = new MeanFunctionStmtContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_meanFunctionStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			match(T__38);
			setState(445);
			match(IDENTIFIER);
			setState(446);
			match(T__39);
			setState(447);
			match(T__54);
			setState(448);
			match(T__4);
			setState(449);
			match(IDENTIFIER);
			setState(450);
			match(T__6);
			setState(451);
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
	public static class MedianFunctionStmtContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(SimpleParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(SimpleParser.IDENTIFIER, i);
		}
		public MedianFunctionStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_medianFunctionStmt; }
	}

	public final MedianFunctionStmtContext medianFunctionStmt() throws RecognitionException {
		MedianFunctionStmtContext _localctx = new MedianFunctionStmtContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_medianFunctionStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(453);
			match(T__38);
			setState(454);
			match(IDENTIFIER);
			setState(455);
			match(T__39);
			setState(456);
			match(T__55);
			setState(457);
			match(T__4);
			setState(458);
			match(IDENTIFIER);
			setState(459);
			match(T__6);
			setState(460);
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
	public static class MaxFunctionStmtContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SimpleParser.IDENTIFIER, 0); }
		public ValueListContext valueList() {
			return getRuleContext(ValueListContext.class,0);
		}
		public MaxFunctionStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_maxFunctionStmt; }
	}

	public final MaxFunctionStmtContext maxFunctionStmt() throws RecognitionException {
		MaxFunctionStmtContext _localctx = new MaxFunctionStmtContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_maxFunctionStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(462);
			match(T__38);
			setState(463);
			match(IDENTIFIER);
			setState(464);
			match(T__39);
			setState(465);
			match(T__56);
			setState(466);
			match(T__4);
			setState(467);
			valueList();
			setState(468);
			match(T__6);
			setState(469);
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
	public static class ValueListContext extends ParserRuleContext {
		public List<TerminalNode> NUMBER() { return getTokens(SimpleParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(SimpleParser.NUMBER, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(SimpleParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(SimpleParser.IDENTIFIER, i);
		}
		public ValueListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueList; }
	}

	public final ValueListContext valueList() throws RecognitionException {
		ValueListContext _localctx = new ValueListContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_valueList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(476);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(472);
				match(T__5);
				setState(473);
				_la = _input.LA(1);
				if ( !(_la==IDENTIFIER || _la==NUMBER) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(478);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MaxFromListStmtContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(SimpleParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(SimpleParser.IDENTIFIER, i);
		}
		public MaxFromListStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_maxFromListStmt; }
	}

	public final MaxFromListStmtContext maxFromListStmt() throws RecognitionException {
		MaxFromListStmtContext _localctx = new MaxFromListStmtContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_maxFromListStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(479);
			match(T__38);
			setState(480);
			match(IDENTIFIER);
			setState(481);
			match(T__39);
			setState(482);
			match(T__56);
			setState(483);
			match(T__4);
			setState(484);
			match(IDENTIFIER);
			setState(485);
			match(T__6);
			setState(486);
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
		"\u0004\u0001J\u01e9\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0001\u0000\u0005\u0000"+
		"Z\b\u0000\n\u0000\f\u0000]\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0003\u0001c\b\u0001\u0001\u0002\u0001\u0002\u0003\u0002"+
		"g\b\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0005\u0003"+
		"m\b\u0003\n\u0003\f\u0003p\t\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0005\u0005}\b\u0005\n\u0005\f\u0005\u0080\t"+
		"\u0005\u0003\u0005\u0082\b\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u0090\b\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u009e"+
		"\b\u0006\n\u0006\f\u0006\u00a1\t\u0006\u0001\u0007\u0001\u0007\u0001\b"+
		"\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005"+
		"\u000b\u00b3\b\u000b\n\u000b\f\u000b\u00b6\t\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u00bf\b\f\n\f\f\f\u00c2"+
		"\t\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005"+
		"\r\u00cc\b\r\n\r\f\r\u00cf\t\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u00d9\b\u000e"+
		"\n\u000e\f\u000e\u00dc\t\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0003\u000f\u00e3\b\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0005\u000f\u00e8\b\u000f\n\u000f\f\u000f\u00eb\t\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010"+
		"\u00f3\b\u0010\n\u0010\f\u0010\u00f6\t\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0005\u0011\u0102\b\u0011\n\u0011\f\u0011\u0105\t\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0005\u0013\u010e\b\u0013\n\u0013\f\u0013\u0111\t\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u011c\b\u0014\n\u0014\f\u0014"+
		"\u011f\t\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u012a\b\u0015"+
		"\n\u0015\f\u0015\u012d\t\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0005"+
		"\u0016\u0138\b\u0016\n\u0016\f\u0016\u013b\t\u0016\u0001\u0016\u0001\u0016"+
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
		"!\u0005!\u0185\b!\n!\f!\u0188\t!\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001#\u0001#"+
		"\u0001#\u0001#\u0001#\u0001#\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001%\u0001%\u0001%\u0001%\u0001"+
		"%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001&\u0001&\u0001&\u0001"+
		"&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001\'\u0001\'\u0001"+
		"\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001(\u0001(\u0001"+
		"(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0001*\u0001*\u0001*\u0005*\u01db"+
		"\b*\n*\f*\u01de\t*\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001"+
		"+\u0001+\u0001+\u0000\u0002\f\u001e,\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDF"+
		"HJLNPRTV\u0000\u0007\u0001\u0000\t\u000b\u0001\u0000\f\r\u0001\u0000\u000e"+
		"\u0013\u0003\u0000::=@BG\u0001\u0000\u001e$\u0002\u0000<<??\u0002\u0000"+
		"<<>>\u01d7\u0000[\u0001\u0000\u0000\u0000\u0002b\u0001\u0000\u0000\u0000"+
		"\u0004f\u0001\u0000\u0000\u0000\u0006j\u0001\u0000\u0000\u0000\bs\u0001"+
		"\u0000\u0000\u0000\nw\u0001\u0000\u0000\u0000\f\u008f\u0001\u0000\u0000"+
		"\u0000\u000e\u00a2\u0001\u0000\u0000\u0000\u0010\u00a4\u0001\u0000\u0000"+
		"\u0000\u0012\u00a6\u0001\u0000\u0000\u0000\u0014\u00a8\u0001\u0000\u0000"+
		"\u0000\u0016\u00aa\u0001\u0000\u0000\u0000\u0018\u00b9\u0001\u0000\u0000"+
		"\u0000\u001a\u00c5\u0001\u0000\u0000\u0000\u001c\u00d2\u0001\u0000\u0000"+
		"\u0000\u001e\u00e2\u0001\u0000\u0000\u0000 \u00ec\u0001\u0000\u0000\u0000"+
		"\"\u00f9\u0001\u0000\u0000\u0000$\u0108\u0001\u0000\u0000\u0000&\u010a"+
		"\u0001\u0000\u0000\u0000(\u0118\u0001\u0000\u0000\u0000*\u0126\u0001\u0000"+
		"\u0000\u0000,\u0134\u0001\u0000\u0000\u0000.\u0142\u0001\u0000\u0000\u0000"+
		"0\u014a\u0001\u0000\u0000\u00002\u0152\u0001\u0000\u0000\u00004\u015a"+
		"\u0001\u0000\u0000\u00006\u015f\u0001\u0000\u0000\u00008\u0166\u0001\u0000"+
		"\u0000\u0000:\u016b\u0001\u0000\u0000\u0000<\u0170\u0001\u0000\u0000\u0000"+
		">\u0175\u0001\u0000\u0000\u0000@\u017a\u0001\u0000\u0000\u0000B\u0181"+
		"\u0001\u0000\u0000\u0000D\u0189\u0001\u0000\u0000\u0000F\u0192\u0001\u0000"+
		"\u0000\u0000H\u019b\u0001\u0000\u0000\u0000J\u01a6\u0001\u0000\u0000\u0000"+
		"L\u01b1\u0001\u0000\u0000\u0000N\u01bc\u0001\u0000\u0000\u0000P\u01c5"+
		"\u0001\u0000\u0000\u0000R\u01ce\u0001\u0000\u0000\u0000T\u01d7\u0001\u0000"+
		"\u0000\u0000V\u01df\u0001\u0000\u0000\u0000XZ\u0003\u0002\u0001\u0000"+
		"YX\u0001\u0000\u0000\u0000Z]\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000"+
		"\u0000[\\\u0001\u0000\u0000\u0000\\^\u0001\u0000\u0000\u0000][\u0001\u0000"+
		"\u0000\u0000^_\u0005\u0000\u0000\u0001_\u0001\u0001\u0000\u0000\u0000"+
		"`c\u0003\u0004\u0002\u0000ac\u0003\u0006\u0003\u0000b`\u0001\u0000\u0000"+
		"\u0000ba\u0001\u0000\u0000\u0000c\u0003\u0001\u0000\u0000\u0000dg\u0003"+
		"\b\u0004\u0000eg\u0003\n\u0005\u0000fd\u0001\u0000\u0000\u0000fe\u0001"+
		"\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000hi\u0005\u0001\u0000\u0000"+
		"i\u0005\u0001\u0000\u0000\u0000jn\u0005\u0002\u0000\u0000km\u0003\u0002"+
		"\u0001\u0000lk\u0001\u0000\u0000\u0000mp\u0001\u0000\u0000\u0000nl\u0001"+
		"\u0000\u0000\u0000no\u0001\u0000\u0000\u0000oq\u0001\u0000\u0000\u0000"+
		"pn\u0001\u0000\u0000\u0000qr\u0005\u0003\u0000\u0000r\u0007\u0001\u0000"+
		"\u0000\u0000st\u0005<\u0000\u0000tu\u0005\u0004\u0000\u0000uv\u0003\f"+
		"\u0006\u0000v\t\u0001\u0000\u0000\u0000wx\u0005<\u0000\u0000x\u0081\u0005"+
		"\u0005\u0000\u0000y~\u0003\f\u0006\u0000z{\u0005\u0006\u0000\u0000{}\u0003"+
		"\f\u0006\u0000|z\u0001\u0000\u0000\u0000}\u0080\u0001\u0000\u0000\u0000"+
		"~|\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0082"+
		"\u0001\u0000\u0000\u0000\u0080~\u0001\u0000\u0000\u0000\u0081y\u0001\u0000"+
		"\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000"+
		"\u0000\u0000\u0083\u0084\u0005\u0007\u0000\u0000\u0084\u000b\u0001\u0000"+
		"\u0000\u0000\u0085\u0086\u0006\u0006\uffff\uffff\u0000\u0086\u0090\u0003"+
		"\u0014\n\u0000\u0087\u0090\u0005<\u0000\u0000\u0088\u0090\u0003\n\u0005"+
		"\u0000\u0089\u008a\u0005\u0005\u0000\u0000\u008a\u008b\u0003\f\u0006\u0000"+
		"\u008b\u008c\u0005\u0007\u0000\u0000\u008c\u0090\u0001\u0000\u0000\u0000"+
		"\u008d\u008e\u0005\b\u0000\u0000\u008e\u0090\u0003\f\u0006\u0004\u008f"+
		"\u0085\u0001\u0000\u0000\u0000\u008f\u0087\u0001\u0000\u0000\u0000\u008f"+
		"\u0088\u0001\u0000\u0000\u0000\u008f\u0089\u0001\u0000\u0000\u0000\u008f"+
		"\u008d\u0001\u0000\u0000\u0000\u0090\u009f\u0001\u0000\u0000\u0000\u0091"+
		"\u0092\n\u0003\u0000\u0000\u0092\u0093\u0003\u000e\u0007\u0000\u0093\u0094"+
		"\u0003\f\u0006\u0004\u0094\u009e\u0001\u0000\u0000\u0000\u0095\u0096\n"+
		"\u0002\u0000\u0000\u0096\u0097\u0003\u0010\b\u0000\u0097\u0098\u0003\f"+
		"\u0006\u0003\u0098\u009e\u0001\u0000\u0000\u0000\u0099\u009a\n\u0001\u0000"+
		"\u0000\u009a\u009b\u0003\u0012\t\u0000\u009b\u009c\u0003\f\u0006\u0002"+
		"\u009c\u009e\u0001\u0000\u0000\u0000\u009d\u0091\u0001\u0000\u0000\u0000"+
		"\u009d\u0095\u0001\u0000\u0000\u0000\u009d\u0099\u0001\u0000\u0000\u0000"+
		"\u009e\u00a1\u0001\u0000\u0000\u0000\u009f\u009d\u0001\u0000\u0000\u0000"+
		"\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\r\u0001\u0000\u0000\u0000\u00a1"+
		"\u009f\u0001\u0000\u0000\u0000\u00a2\u00a3\u0007\u0000\u0000\u0000\u00a3"+
		"\u000f\u0001\u0000\u0000\u0000\u00a4\u00a5\u0007\u0001\u0000\u0000\u00a5"+
		"\u0011\u0001\u0000\u0000\u0000\u00a6\u00a7\u0007\u0002\u0000\u0000\u00a7"+
		"\u0013\u0001\u0000\u0000\u0000\u00a8\u00a9\u0007\u0003\u0000\u0000\u00a9"+
		"\u0015\u0001\u0000\u0000\u0000\u00aa\u00ab\u0005\u0014\u0000\u0000\u00ab"+
		"\u00ac\u0005<\u0000\u0000\u00ac\u00ad\u0005\u0015\u0000\u0000\u00ad\u00ae"+
		"\u0005=\u0000\u0000\u00ae\u00af\u0005\u0016\u0000\u0000\u00af\u00b0\u0005"+
		"=\u0000\u0000\u00b0\u00b4\u0005\u0002\u0000\u0000\u00b1\u00b3\u0003\u0002"+
		"\u0001\u0000\u00b2\u00b1\u0001\u0000\u0000\u0000\u00b3\u00b6\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000"+
		"\u0000\u0000\u00b5\u00b7\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000"+
		"\u0000\u0000\u00b7\u00b8\u0005\u0003\u0000\u0000\u00b8\u0017\u0001\u0000"+
		"\u0000\u0000\u00b9\u00ba\u0005\u0017\u0000\u0000\u00ba\u00bb\u0005=\u0000"+
		"\u0000\u00bb\u00bc\u0005\u0018\u0000\u0000\u00bc\u00c0\u0005\u0002\u0000"+
		"\u0000\u00bd\u00bf\u0003\u0002\u0001\u0000\u00be\u00bd\u0001\u0000\u0000"+
		"\u0000\u00bf\u00c2\u0001\u0000\u0000\u0000\u00c0\u00be\u0001\u0000\u0000"+
		"\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1\u00c3\u0001\u0000\u0000"+
		"\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c3\u00c4\u0005\u0003\u0000"+
		"\u0000\u00c4\u0019\u0001\u0000\u0000\u0000\u00c5\u00c6\u0005\u0019\u0000"+
		"\u0000\u00c6\u00c7\u0005=\u0000\u0000\u00c7\u00c8\u0005\u0016\u0000\u0000"+
		"\u00c8\u00c9\u0005=\u0000\u0000\u00c9\u00cd\u0005\u0002\u0000\u0000\u00ca"+
		"\u00cc\u0003\u0002\u0001\u0000\u00cb\u00ca\u0001\u0000\u0000\u0000\u00cc"+
		"\u00cf\u0001\u0000\u0000\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000\u00cd"+
		"\u00ce\u0001\u0000\u0000\u0000\u00ce\u00d0\u0001\u0000\u0000\u0000\u00cf"+
		"\u00cd\u0001\u0000\u0000\u0000\u00d0\u00d1\u0005\u0003\u0000\u0000\u00d1"+
		"\u001b\u0001\u0000\u0000\u0000\u00d2\u00d3\u0005\u001a\u0000\u0000\u00d3"+
		"\u00d4\u0003\u001e\u000f\u0000\u00d4\u00d5\u0003\u0012\t\u0000\u00d5\u00d6"+
		"\u0003\u001e\u000f\u0000\u00d6\u00da\u0005\u0002\u0000\u0000\u00d7\u00d9"+
		"\u0003\u0002\u0001\u0000\u00d8\u00d7\u0001\u0000\u0000\u0000\u00d9\u00dc"+
		"\u0001\u0000\u0000\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00da\u00db"+
		"\u0001\u0000\u0000\u0000\u00db\u00dd\u0001\u0000\u0000\u0000\u00dc\u00da"+
		"\u0001\u0000\u0000\u0000\u00dd\u00de\u0005\u0003\u0000\u0000\u00de\u001d"+
		"\u0001\u0000\u0000\u0000\u00df\u00e0\u0006\u000f\uffff\uffff\u0000\u00e0"+
		"\u00e3\u0005>\u0000\u0000\u00e1\u00e3\u0005<\u0000\u0000\u00e2\u00df\u0001"+
		"\u0000\u0000\u0000\u00e2\u00e1\u0001\u0000\u0000\u0000\u00e3\u00e9\u0001"+
		"\u0000\u0000\u0000\u00e4\u00e5\n\u0001\u0000\u0000\u00e5\u00e6\u0005J"+
		"\u0000\u0000\u00e6\u00e8\u0003\u001e\u000f\u0002\u00e7\u00e4\u0001\u0000"+
		"\u0000\u0000\u00e8\u00eb\u0001\u0000\u0000\u0000\u00e9\u00e7\u0001\u0000"+
		"\u0000\u0000\u00e9\u00ea\u0001\u0000\u0000\u0000\u00ea\u001f\u0001\u0000"+
		"\u0000\u0000\u00eb\u00e9\u0001\u0000\u0000\u0000\u00ec\u00ed\u0005\u001b"+
		"\u0000\u0000\u00ed\u00ee\u0003\u001e\u000f\u0000\u00ee\u00ef\u0003\u0012"+
		"\t\u0000\u00ef\u00f0\u0003\u001e\u000f\u0000\u00f0\u00f4\u0005\u0002\u0000"+
		"\u0000\u00f1\u00f3\u0003\u0002\u0001\u0000\u00f2\u00f1\u0001\u0000\u0000"+
		"\u0000\u00f3\u00f6\u0001\u0000\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000"+
		"\u0000\u00f4\u00f5\u0001\u0000\u0000\u0000\u00f5\u00f7\u0001\u0000\u0000"+
		"\u0000\u00f6\u00f4\u0001\u0000\u0000\u0000\u00f7\u00f8\u0005\u0003\u0000"+
		"\u0000\u00f8!\u0001\u0000\u0000\u0000\u00f9\u00fa\u0005\u001c\u0000\u0000"+
		"\u00fa\u00fb\u0005\u001d\u0000\u0000\u00fb\u00fc\u0005\u001c\u0000\u0000"+
		"\u00fc\u00fd\u0003\u001e\u000f\u0000\u00fd\u00fe\u0003$\u0012\u0000\u00fe"+
		"\u00ff\u0003\u001e\u000f\u0000\u00ff\u0103\u0005\u0002\u0000\u0000\u0100"+
		"\u0102\u0003\u0002\u0001\u0000\u0101\u0100\u0001\u0000\u0000\u0000\u0102"+
		"\u0105\u0001\u0000\u0000\u0000\u0103\u0101\u0001\u0000\u0000\u0000\u0103"+
		"\u0104\u0001\u0000\u0000\u0000\u0104\u0106\u0001\u0000\u0000\u0000\u0105"+
		"\u0103\u0001\u0000\u0000\u0000\u0106\u0107\u0005\u0003\u0000\u0000\u0107"+
		"#\u0001\u0000\u0000\u0000\u0108\u0109\u0007\u0004\u0000\u0000\u0109%\u0001"+
		"\u0000\u0000\u0000\u010a\u010b\u0005%\u0000\u0000\u010b\u010f\u0005\u0002"+
		"\u0000\u0000\u010c\u010e\u0003\u0002\u0001\u0000\u010d\u010c\u0001\u0000"+
		"\u0000\u0000\u010e\u0111\u0001\u0000\u0000\u0000\u010f\u010d\u0001\u0000"+
		"\u0000\u0000\u010f\u0110\u0001\u0000\u0000\u0000\u0110\u0112\u0001\u0000"+
		"\u0000\u0000\u0111\u010f\u0001\u0000\u0000\u0000\u0112\u0113\u0005\u0003"+
		"\u0000\u0000\u0113\u0114\u0005\u001a\u0000\u0000\u0114\u0115\u0003\u001e"+
		"\u000f\u0000\u0115\u0116\u0003$\u0012\u0000\u0116\u0117\u0003\u001e\u000f"+
		"\u0000\u0117\'\u0001\u0000\u0000\u0000\u0118\u0119\u0005\u0017\u0000\u0000"+
		"\u0119\u011d\u0005\u0002\u0000\u0000\u011a\u011c\u0003\u0002\u0001\u0000"+
		"\u011b\u011a\u0001\u0000\u0000\u0000\u011c\u011f\u0001\u0000\u0000\u0000"+
		"\u011d\u011b\u0001\u0000\u0000\u0000\u011d\u011e\u0001\u0000\u0000\u0000"+
		"\u011e\u0120\u0001\u0000\u0000\u0000\u011f\u011d\u0001\u0000\u0000\u0000"+
		"\u0120\u0121\u0005\u0003\u0000\u0000\u0121\u0122\u0005&\u0000\u0000\u0122"+
		"\u0123\u0003\u001e\u000f\u0000\u0123\u0124\u0003$\u0012\u0000\u0124\u0125"+
		"\u0003\u001e\u000f\u0000\u0125)\u0001\u0000\u0000\u0000\u0126\u0127\u0005"+
		"\u0017\u0000\u0000\u0127\u012b\u0005\u0002\u0000\u0000\u0128\u012a\u0003"+
		"\u0002\u0001\u0000\u0129\u0128\u0001\u0000\u0000\u0000\u012a\u012d\u0001"+
		"\u0000\u0000\u0000\u012b\u0129\u0001\u0000\u0000\u0000\u012b\u012c\u0001"+
		"\u0000\u0000\u0000\u012c\u012e\u0001\u0000\u0000\u0000\u012d\u012b\u0001"+
		"\u0000\u0000\u0000\u012e\u012f\u0005\u0003\u0000\u0000\u012f\u0130\u0005"+
		"\u001b\u0000\u0000\u0130\u0131\u0003\u001e\u000f\u0000\u0131\u0132\u0003"+
		"$\u0012\u0000\u0132\u0133\u0003\u001e\u000f\u0000\u0133+\u0001\u0000\u0000"+
		"\u0000\u0134\u0135\u0005%\u0000\u0000\u0135\u0139\u0005\u0002\u0000\u0000"+
		"\u0136\u0138\u0003\u0002\u0001\u0000\u0137\u0136\u0001\u0000\u0000\u0000"+
		"\u0138\u013b\u0001\u0000\u0000\u0000\u0139\u0137\u0001\u0000\u0000\u0000"+
		"\u0139\u013a\u0001\u0000\u0000\u0000\u013a\u013c\u0001\u0000\u0000\u0000"+
		"\u013b\u0139\u0001\u0000\u0000\u0000\u013c\u013d\u0005\u0003\u0000\u0000"+
		"\u013d\u013e\u0005&\u0000\u0000\u013e\u013f\u0003\u001e\u000f\u0000\u013f"+
		"\u0140\u0003$\u0012\u0000\u0140\u0141\u0003\u001e\u000f\u0000\u0141-\u0001"+
		"\u0000\u0000\u0000\u0142\u0143\u0005\'\u0000\u0000\u0143\u0144\u0005<"+
		"\u0000\u0000\u0144\u0145\u0005(\u0000\u0000\u0145\u0146\u0005)\u0000\u0000"+
		"\u0146\u0147\u0005\u0005\u0000\u0000\u0147\u0148\u0005?\u0000\u0000\u0148"+
		"\u0149\u0005\u0007\u0000\u0000\u0149/\u0001\u0000\u0000\u0000\u014a\u014b"+
		"\u0005\'\u0000\u0000\u014b\u014c\u0005<\u0000\u0000\u014c\u014d\u0005"+
		"(\u0000\u0000\u014d\u014e\u0005*\u0000\u0000\u014e\u014f\u0005\u0005\u0000"+
		"\u0000\u014f\u0150\u0005<\u0000\u0000\u0150\u0151\u0005\u0007\u0000\u0000"+
		"\u01511\u0001\u0000\u0000\u0000\u0152\u0153\u0005\'\u0000\u0000\u0153"+
		"\u0154\u0005<\u0000\u0000\u0154\u0155\u0005(\u0000\u0000\u0155\u0156\u0005"+
		"+\u0000\u0000\u0156\u0157\u0005\u0005\u0000\u0000\u0157\u0158\u0007\u0005"+
		"\u0000\u0000\u0158\u0159\u0005\u0007\u0000\u0000\u01593\u0001\u0000\u0000"+
		"\u0000\u015a\u015b\u0005,\u0000\u0000\u015b\u015c\u0005\u0005\u0000\u0000"+
		"\u015c\u015d\u0005=\u0000\u0000\u015d\u015e\u0005\u0007\u0000\u0000\u015e"+
		"5\u0001\u0000\u0000\u0000\u015f\u0160\u0005<\u0000\u0000\u0160\u0161\u0005"+
		"(\u0000\u0000\u0161\u0162\u0005-\u0000\u0000\u0162\u0163\u0005\u0005\u0000"+
		"\u0000\u0163\u0164\u0005?\u0000\u0000\u0164\u0165\u0005\u0007\u0000\u0000"+
		"\u01657\u0001\u0000\u0000\u0000\u0166\u0167\u0005.\u0000\u0000\u0167\u0168"+
		"\u0005\u0005\u0000\u0000\u0168\u0169\u0005?\u0000\u0000\u0169\u016a\u0005"+
		"\u0007\u0000\u0000\u016a9\u0001\u0000\u0000\u0000\u016b\u016c\u0005/\u0000"+
		"\u0000\u016c\u016d\u0005\u0005\u0000\u0000\u016d\u016e\u0005?\u0000\u0000"+
		"\u016e\u016f\u0005\u0007\u0000\u0000\u016f;\u0001\u0000\u0000\u0000\u0170"+
		"\u0171\u00050\u0000\u0000\u0171\u0172\u0005\u0005\u0000\u0000\u0172\u0173"+
		"\u0005?\u0000\u0000\u0173\u0174\u0005\u0007\u0000\u0000\u0174=\u0001\u0000"+
		"\u0000\u0000\u0175\u0176\u00051\u0000\u0000\u0176\u0177\u0005\u0005\u0000"+
		"\u0000\u0177\u0178\u0005?\u0000\u0000\u0178\u0179\u0005\u0007\u0000\u0000"+
		"\u0179?\u0001\u0000\u0000\u0000\u017a\u017b\u0005<\u0000\u0000\u017b\u017c"+
		"\u0005(\u0000\u0000\u017c\u017d\u00052\u0000\u0000\u017d\u017e\u0005\u0005"+
		"\u0000\u0000\u017e\u017f\u0003B!\u0000\u017f\u0180\u0005\u0007\u0000\u0000"+
		"\u0180A\u0001\u0000\u0000\u0000\u0181\u0186\u0005>\u0000\u0000\u0182\u0183"+
		"\u0005\u0006\u0000\u0000\u0183\u0185\u0005>\u0000\u0000\u0184\u0182\u0001"+
		"\u0000\u0000\u0000\u0185\u0188\u0001\u0000\u0000\u0000\u0186\u0184\u0001"+
		"\u0000\u0000\u0000\u0186\u0187\u0001\u0000\u0000\u0000\u0187C\u0001\u0000"+
		"\u0000\u0000\u0188\u0186\u0001\u0000\u0000\u0000\u0189\u018a\u0005\'\u0000"+
		"\u0000\u018a\u018b\u0005<\u0000\u0000\u018b\u018c\u0005(\u0000\u0000\u018c"+
		"\u018d\u00052\u0000\u0000\u018d\u018e\u0005\u0005\u0000\u0000\u018e\u018f"+
		"\u0005<\u0000\u0000\u018f\u0190\u0005\u0007\u0000\u0000\u0190\u0191\u0005"+
		"\u0001\u0000\u0000\u0191E\u0001\u0000\u0000\u0000\u0192\u0193\u0005\'"+
		"\u0000\u0000\u0193\u0194\u0005<\u0000\u0000\u0194\u0195\u0005(\u0000\u0000"+
		"\u0195\u0196\u00053\u0000\u0000\u0196\u0197\u0005\u0005\u0000\u0000\u0197"+
		"\u0198\u0007\u0006\u0000\u0000\u0198\u0199\u0005\u0007\u0000\u0000\u0199"+
		"\u019a\u0005\u0001\u0000\u0000\u019aG\u0001\u0000\u0000\u0000\u019b\u019c"+
		"\u0005\'\u0000\u0000\u019c\u019d\u0005<\u0000\u0000\u019d\u019e\u0005"+
		"(\u0000\u0000\u019e\u019f\u00054\u0000\u0000\u019f\u01a0\u0005\u0005\u0000"+
		"\u0000\u01a0\u01a1\u0007\u0006\u0000\u0000\u01a1\u01a2\u0005\u0006\u0000"+
		"\u0000\u01a2\u01a3\u0007\u0006\u0000\u0000\u01a3\u01a4\u0005\u0007\u0000"+
		"\u0000\u01a4\u01a5\u0005\u0001\u0000\u0000\u01a5I\u0001\u0000\u0000\u0000"+
		"\u01a6\u01a7\u0005\'\u0000\u0000\u01a7\u01a8\u0005<\u0000\u0000\u01a8"+
		"\u01a9\u0005(\u0000\u0000\u01a9\u01aa\u00055\u0000\u0000\u01aa\u01ab\u0005"+
		"\u0005\u0000\u0000\u01ab\u01ac\u0007\u0006\u0000\u0000\u01ac\u01ad\u0005"+
		"\u0006\u0000\u0000\u01ad\u01ae\u0007\u0006\u0000\u0000\u01ae\u01af\u0005"+
		"\u0007\u0000\u0000\u01af\u01b0\u0005\u0001\u0000\u0000\u01b0K\u0001\u0000"+
		"\u0000\u0000\u01b1\u01b2\u0005\'\u0000\u0000\u01b2\u01b3\u0005<\u0000"+
		"\u0000\u01b3\u01b4\u0005(\u0000\u0000\u01b4\u01b5\u00056\u0000\u0000\u01b5"+
		"\u01b6\u0005\u0005\u0000\u0000\u01b6\u01b7\u0007\u0006\u0000\u0000\u01b7"+
		"\u01b8\u0005\u0006\u0000\u0000\u01b8\u01b9\u0007\u0006\u0000\u0000\u01b9"+
		"\u01ba\u0005\u0007\u0000\u0000\u01ba\u01bb\u0005\u0001\u0000\u0000\u01bb"+
		"M\u0001\u0000\u0000\u0000\u01bc\u01bd\u0005\'\u0000\u0000\u01bd\u01be"+
		"\u0005<\u0000\u0000\u01be\u01bf\u0005(\u0000\u0000\u01bf\u01c0\u00057"+
		"\u0000\u0000\u01c0\u01c1\u0005\u0005\u0000\u0000\u01c1\u01c2\u0005<\u0000"+
		"\u0000\u01c2\u01c3\u0005\u0007\u0000\u0000\u01c3\u01c4\u0005\u0001\u0000"+
		"\u0000\u01c4O\u0001\u0000\u0000\u0000\u01c5\u01c6\u0005\'\u0000\u0000"+
		"\u01c6\u01c7\u0005<\u0000\u0000\u01c7\u01c8\u0005(\u0000\u0000\u01c8\u01c9"+
		"\u00058\u0000\u0000\u01c9\u01ca\u0005\u0005\u0000\u0000\u01ca\u01cb\u0005"+
		"<\u0000\u0000\u01cb\u01cc\u0005\u0007\u0000\u0000\u01cc\u01cd\u0005\u0001"+
		"\u0000\u0000\u01cdQ\u0001\u0000\u0000\u0000\u01ce\u01cf\u0005\'\u0000"+
		"\u0000\u01cf\u01d0\u0005<\u0000\u0000\u01d0\u01d1\u0005(\u0000\u0000\u01d1"+
		"\u01d2\u00059\u0000\u0000\u01d2\u01d3\u0005\u0005\u0000\u0000\u01d3\u01d4"+
		"\u0003T*\u0000\u01d4\u01d5\u0005\u0007\u0000\u0000\u01d5\u01d6\u0005\u0001"+
		"\u0000\u0000\u01d6S\u0001\u0000\u0000\u0000\u01d7\u01dc\u0007\u0006\u0000"+
		"\u0000\u01d8\u01d9\u0005\u0006\u0000\u0000\u01d9\u01db\u0007\u0006\u0000"+
		"\u0000\u01da\u01d8\u0001\u0000\u0000\u0000\u01db\u01de\u0001\u0000\u0000"+
		"\u0000\u01dc\u01da\u0001\u0000\u0000\u0000\u01dc\u01dd\u0001\u0000\u0000"+
		"\u0000\u01ddU\u0001\u0000\u0000\u0000\u01de\u01dc\u0001\u0000\u0000\u0000"+
		"\u01df\u01e0\u0005\'\u0000\u0000\u01e0\u01e1\u0005<\u0000\u0000\u01e1"+
		"\u01e2\u0005(\u0000\u0000\u01e2\u01e3\u00059\u0000\u0000\u01e3\u01e4\u0005"+
		"\u0005\u0000\u0000\u01e4\u01e5\u0005<\u0000\u0000\u01e5\u01e6\u0005\u0007"+
		"\u0000\u0000\u01e6\u01e7\u0005\u0001\u0000\u0000\u01e7W\u0001\u0000\u0000"+
		"\u0000\u0017[bfn~\u0081\u008f\u009d\u009f\u00b4\u00c0\u00cd\u00da\u00e2"+
		"\u00e9\u00f4\u0103\u010f\u011d\u012b\u0139\u0186\u01dc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}