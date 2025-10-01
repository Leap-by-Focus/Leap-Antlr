// Generated from Simple.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SimpleParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SimpleVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SimpleParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(SimpleParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine(SimpleParser.LineContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(SimpleParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(SimpleParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(SimpleParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(SimpleParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenthesizedExpression}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedExpression(SimpleParser.ParenthesizedExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constantExpression}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantExpression(SimpleParser.ConstantExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code additiveExpression}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(SimpleParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierExpression(SimpleParser.IdentifierExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplicateExpression}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicateExpression(SimpleParser.MultiplicateExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpression(SimpleParser.FunctionCallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(SimpleParser.NotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparisonExpression}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpression(SimpleParser.ComparisonExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#multiOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiOp(SimpleParser.MultiOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#addOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddOp(SimpleParser.AddOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#compareOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareOp(SimpleParser.CompareOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(SimpleParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(SimpleParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#repeatStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatStmt(SimpleParser.RepeatStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#loopStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStmt(SimpleParser.LoopStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(SimpleParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(SimpleParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#untilStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUntilStmt(SimpleParser.UntilStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#asLongStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsLongStmt(SimpleParser.AsLongStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#customCompOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCustomCompOp(SimpleParser.CustomCompOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#doWhileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhileStmt(SimpleParser.DoWhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#repeatAsLongStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatAsLongStmt(SimpleParser.RepeatAsLongStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#repeatUntilStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatUntilStmt(SimpleParser.RepeatUntilStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#doAsLongStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoAsLongStmt(SimpleParser.DoAsLongStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#writeFileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteFileStmt(SimpleParser.WriteFileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#isNullStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsNullStmt(SimpleParser.IsNullStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#existsStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExistsStmt(SimpleParser.ExistsStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#sleepStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSleepStmt(SimpleParser.SleepStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#readFileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadFileStmt(SimpleParser.ReadFileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#deleteFileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteFileStmt(SimpleParser.DeleteFileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#createFolderStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateFolderStmt(SimpleParser.CreateFolderStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#deleteFolderStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteFolderStmt(SimpleParser.DeleteFolderStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#openFileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpenFileStmt(SimpleParser.OpenFileStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code minFunctionCall}
	 * labeled alternative in {@link SimpleParser#minExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinFunctionCall(SimpleParser.MinFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#numberList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberList(SimpleParser.NumberListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#minListFunctionStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinListFunctionStmt(SimpleParser.MinListFunctionStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#absFunctionStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbsFunctionStmt(SimpleParser.AbsFunctionStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#sqrtFunctionStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSqrtFunctionStmt(SimpleParser.SqrtFunctionStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#roundFunctionStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoundFunctionStmt(SimpleParser.RoundFunctionStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#randomFunctionStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRandomFunctionStmt(SimpleParser.RandomFunctionStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#meanFunctionStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMeanFunctionStmt(SimpleParser.MeanFunctionStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#medianFunctionStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMedianFunctionStmt(SimpleParser.MedianFunctionStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#maxFunctionStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaxFunctionStmt(SimpleParser.MaxFunctionStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#valueList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueList(SimpleParser.ValueListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#maxFromListStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaxFromListStmt(SimpleParser.MaxFromListStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#toLowerFunctionStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToLowerFunctionStmt(SimpleParser.ToLowerFunctionStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#toUpperFunctionStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToUpperFunctionStmt(SimpleParser.ToUpperFunctionStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#trimFunctionStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrimFunctionStmt(SimpleParser.TrimFunctionStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#trimStartFunctionStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrimStartFunctionStmt(SimpleParser.TrimStartFunctionStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#trimEndFunctionStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrimEndFunctionStmt(SimpleParser.TrimEndFunctionStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#replaceFunctionStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReplaceFunctionStmt(SimpleParser.ReplaceFunctionStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#splitFunctionStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSplitFunctionStmt(SimpleParser.SplitFunctionStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#leftFunctionStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftFunctionStmt(SimpleParser.LeftFunctionStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#leftRangeFunctionStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftRangeFunctionStmt(SimpleParser.LeftRangeFunctionStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#concatFunctionStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatFunctionStmt(SimpleParser.ConcatFunctionStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#containsFunctionStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContainsFunctionStmt(SimpleParser.ContainsFunctionStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#lengthAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLengthAccess(SimpleParser.LengthAccessContext ctx);
}