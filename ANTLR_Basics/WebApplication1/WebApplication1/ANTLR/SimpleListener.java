// Generated from Simple.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleParser}.
 */
public interface SimpleListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpleParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(SimpleParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(SimpleParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(SimpleParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(SimpleParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(SimpleParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(SimpleParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(SimpleParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(SimpleParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesizedExpression}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedExpression(SimpleParser.ParenthesizedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesizedExpression}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedExpression(SimpleParser.ParenthesizedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AdditiveExpression}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(SimpleParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AdditiveExpression}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(SimpleParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LengthAccessExpression}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLengthAccessExpression(SimpleParser.LengthAccessExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LengthAccessExpression}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLengthAccessExpression(SimpleParser.LengthAccessExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryMinusExpression}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinusExpression(SimpleParser.UnaryMinusExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryMinusExpression}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinusExpression(SimpleParser.UnaryMinusExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ObjectCreationExpression}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterObjectCreationExpression(SimpleParser.ObjectCreationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ObjectCreationExpression}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitObjectCreationExpression(SimpleParser.ObjectCreationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstantExpression}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConstantExpression(SimpleParser.ConstantExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstantExpression}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConstantExpression(SimpleParser.ConstantExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultiplicateExpression}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicateExpression(SimpleParser.MultiplicateExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultiplicateExpression}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicateExpression(SimpleParser.MultiplicateExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdentifierExpression}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpression(SimpleParser.IdentifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdentifierExpression}
	 * labeled alternative in {@link SimpleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpression(SimpleParser.IdentifierExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#addOp}.
	 * @param ctx the parse tree
	 */
	void enterAddOp(SimpleParser.AddOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#addOp}.
	 * @param ctx the parse tree
	 */
	void exitAddOp(SimpleParser.AddOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#multiOp}.
	 * @param ctx the parse tree
	 */
	void enterMultiOp(SimpleParser.MultiOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#multiOp}.
	 * @param ctx the parse tree
	 */
	void exitMultiOp(SimpleParser.MultiOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(SimpleParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(SimpleParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(SimpleParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(SimpleParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(SimpleParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(SimpleParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#compareOp}.
	 * @param ctx the parse tree
	 */
	void enterCompareOp(SimpleParser.CompareOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#compareOp}.
	 * @param ctx the parse tree
	 */
	void exitCompareOp(SimpleParser.CompareOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(SimpleParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(SimpleParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#repeatStmt}.
	 * @param ctx the parse tree
	 */
	void enterRepeatStmt(SimpleParser.RepeatStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#repeatStmt}.
	 * @param ctx the parse tree
	 */
	void exitRepeatStmt(SimpleParser.RepeatStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#loopStmt}.
	 * @param ctx the parse tree
	 */
	void enterLoopStmt(SimpleParser.LoopStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#loopStmt}.
	 * @param ctx the parse tree
	 */
	void exitLoopStmt(SimpleParser.LoopStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(SimpleParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(SimpleParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(SimpleParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(SimpleParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#untilStmt}.
	 * @param ctx the parse tree
	 */
	void enterUntilStmt(SimpleParser.UntilStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#untilStmt}.
	 * @param ctx the parse tree
	 */
	void exitUntilStmt(SimpleParser.UntilStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#asLongStmt}.
	 * @param ctx the parse tree
	 */
	void enterAsLongStmt(SimpleParser.AsLongStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#asLongStmt}.
	 * @param ctx the parse tree
	 */
	void exitAsLongStmt(SimpleParser.AsLongStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#customCompOp}.
	 * @param ctx the parse tree
	 */
	void enterCustomCompOp(SimpleParser.CustomCompOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#customCompOp}.
	 * @param ctx the parse tree
	 */
	void exitCustomCompOp(SimpleParser.CustomCompOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#doWhileStmt}.
	 * @param ctx the parse tree
	 */
	void enterDoWhileStmt(SimpleParser.DoWhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#doWhileStmt}.
	 * @param ctx the parse tree
	 */
	void exitDoWhileStmt(SimpleParser.DoWhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#repeatAsLongStmt}.
	 * @param ctx the parse tree
	 */
	void enterRepeatAsLongStmt(SimpleParser.RepeatAsLongStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#repeatAsLongStmt}.
	 * @param ctx the parse tree
	 */
	void exitRepeatAsLongStmt(SimpleParser.RepeatAsLongStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#repeatUntilStmt}.
	 * @param ctx the parse tree
	 */
	void enterRepeatUntilStmt(SimpleParser.RepeatUntilStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#repeatUntilStmt}.
	 * @param ctx the parse tree
	 */
	void exitRepeatUntilStmt(SimpleParser.RepeatUntilStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#doAsLongStmt}.
	 * @param ctx the parse tree
	 */
	void enterDoAsLongStmt(SimpleParser.DoAsLongStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#doAsLongStmt}.
	 * @param ctx the parse tree
	 */
	void exitDoAsLongStmt(SimpleParser.DoAsLongStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#writeFileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWriteFileStmt(SimpleParser.WriteFileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#writeFileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWriteFileStmt(SimpleParser.WriteFileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#isNullStmt}.
	 * @param ctx the parse tree
	 */
	void enterIsNullStmt(SimpleParser.IsNullStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#isNullStmt}.
	 * @param ctx the parse tree
	 */
	void exitIsNullStmt(SimpleParser.IsNullStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#existsStmt}.
	 * @param ctx the parse tree
	 */
	void enterExistsStmt(SimpleParser.ExistsStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#existsStmt}.
	 * @param ctx the parse tree
	 */
	void exitExistsStmt(SimpleParser.ExistsStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#sleepStmt}.
	 * @param ctx the parse tree
	 */
	void enterSleepStmt(SimpleParser.SleepStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#sleepStmt}.
	 * @param ctx the parse tree
	 */
	void exitSleepStmt(SimpleParser.SleepStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#readFileStmt}.
	 * @param ctx the parse tree
	 */
	void enterReadFileStmt(SimpleParser.ReadFileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#readFileStmt}.
	 * @param ctx the parse tree
	 */
	void exitReadFileStmt(SimpleParser.ReadFileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#deleteFileStmt}.
	 * @param ctx the parse tree
	 */
	void enterDeleteFileStmt(SimpleParser.DeleteFileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#deleteFileStmt}.
	 * @param ctx the parse tree
	 */
	void exitDeleteFileStmt(SimpleParser.DeleteFileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#createFolderStmt}.
	 * @param ctx the parse tree
	 */
	void enterCreateFolderStmt(SimpleParser.CreateFolderStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#createFolderStmt}.
	 * @param ctx the parse tree
	 */
	void exitCreateFolderStmt(SimpleParser.CreateFolderStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#deleteFolderStmt}.
	 * @param ctx the parse tree
	 */
	void enterDeleteFolderStmt(SimpleParser.DeleteFolderStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#deleteFolderStmt}.
	 * @param ctx the parse tree
	 */
	void exitDeleteFolderStmt(SimpleParser.DeleteFolderStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#openFileStmt}.
	 * @param ctx the parse tree
	 */
	void enterOpenFileStmt(SimpleParser.OpenFileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#openFileStmt}.
	 * @param ctx the parse tree
	 */
	void exitOpenFileStmt(SimpleParser.OpenFileStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code minFunctionCall}
	 * labeled alternative in {@link SimpleParser#minExpr}.
	 * @param ctx the parse tree
	 */
	void enterMinFunctionCall(SimpleParser.MinFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code minFunctionCall}
	 * labeled alternative in {@link SimpleParser#minExpr}.
	 * @param ctx the parse tree
	 */
	void exitMinFunctionCall(SimpleParser.MinFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#minListFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void enterMinListFunctionStmt(SimpleParser.MinListFunctionStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#minListFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void exitMinListFunctionStmt(SimpleParser.MinListFunctionStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#absFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void enterAbsFunctionStmt(SimpleParser.AbsFunctionStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#absFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void exitAbsFunctionStmt(SimpleParser.AbsFunctionStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#sqrtFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void enterSqrtFunctionStmt(SimpleParser.SqrtFunctionStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#sqrtFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void exitSqrtFunctionStmt(SimpleParser.SqrtFunctionStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#roundFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void enterRoundFunctionStmt(SimpleParser.RoundFunctionStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#roundFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void exitRoundFunctionStmt(SimpleParser.RoundFunctionStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#randomFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void enterRandomFunctionStmt(SimpleParser.RandomFunctionStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#randomFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void exitRandomFunctionStmt(SimpleParser.RandomFunctionStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#meanFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void enterMeanFunctionStmt(SimpleParser.MeanFunctionStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#meanFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void exitMeanFunctionStmt(SimpleParser.MeanFunctionStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#medianFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void enterMedianFunctionStmt(SimpleParser.MedianFunctionStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#medianFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void exitMedianFunctionStmt(SimpleParser.MedianFunctionStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#maxFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void enterMaxFunctionStmt(SimpleParser.MaxFunctionStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#maxFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void exitMaxFunctionStmt(SimpleParser.MaxFunctionStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#valueList}.
	 * @param ctx the parse tree
	 */
	void enterValueList(SimpleParser.ValueListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#valueList}.
	 * @param ctx the parse tree
	 */
	void exitValueList(SimpleParser.ValueListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#maxFromListStmt}.
	 * @param ctx the parse tree
	 */
	void enterMaxFromListStmt(SimpleParser.MaxFromListStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#maxFromListStmt}.
	 * @param ctx the parse tree
	 */
	void exitMaxFromListStmt(SimpleParser.MaxFromListStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#toLowerFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void enterToLowerFunctionStmt(SimpleParser.ToLowerFunctionStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#toLowerFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void exitToLowerFunctionStmt(SimpleParser.ToLowerFunctionStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#toUpperFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void enterToUpperFunctionStmt(SimpleParser.ToUpperFunctionStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#toUpperFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void exitToUpperFunctionStmt(SimpleParser.ToUpperFunctionStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#trimFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void enterTrimFunctionStmt(SimpleParser.TrimFunctionStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#trimFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void exitTrimFunctionStmt(SimpleParser.TrimFunctionStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#trimStartFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void enterTrimStartFunctionStmt(SimpleParser.TrimStartFunctionStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#trimStartFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void exitTrimStartFunctionStmt(SimpleParser.TrimStartFunctionStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#trimEndFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void enterTrimEndFunctionStmt(SimpleParser.TrimEndFunctionStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#trimEndFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void exitTrimEndFunctionStmt(SimpleParser.TrimEndFunctionStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#replaceFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void enterReplaceFunctionStmt(SimpleParser.ReplaceFunctionStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#replaceFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void exitReplaceFunctionStmt(SimpleParser.ReplaceFunctionStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#splitFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void enterSplitFunctionStmt(SimpleParser.SplitFunctionStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#splitFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void exitSplitFunctionStmt(SimpleParser.SplitFunctionStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#leftFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void enterLeftFunctionStmt(SimpleParser.LeftFunctionStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#leftFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void exitLeftFunctionStmt(SimpleParser.LeftFunctionStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#leftRangeFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void enterLeftRangeFunctionStmt(SimpleParser.LeftRangeFunctionStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#leftRangeFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void exitLeftRangeFunctionStmt(SimpleParser.LeftRangeFunctionStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#concatFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void enterConcatFunctionStmt(SimpleParser.ConcatFunctionStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#concatFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void exitConcatFunctionStmt(SimpleParser.ConcatFunctionStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#containsFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void enterContainsFunctionStmt(SimpleParser.ContainsFunctionStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#containsFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void exitContainsFunctionStmt(SimpleParser.ContainsFunctionStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#lengthAccessExpr}.
	 * @param ctx the parse tree
	 */
	void enterLengthAccessExpr(SimpleParser.LengthAccessExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#lengthAccessExpr}.
	 * @param ctx the parse tree
	 */
	void exitLengthAccessExpr(SimpleParser.LengthAccessExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#rightFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void enterRightFunctionStmt(SimpleParser.RightFunctionStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#rightFunctionStmt}.
	 * @param ctx the parse tree
	 */
	void exitRightFunctionStmt(SimpleParser.RightFunctionStmtContext ctx);
}