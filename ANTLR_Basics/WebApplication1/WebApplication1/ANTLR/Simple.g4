grammar Simple;


//lexer -> die mit Kleinbuchstaben -> definieren die Tokens
//parser -> die mit Großbuchstaben -> definieren die Grammatik

program: line* EOF;
line: statement | block | forStmt | repeatStmt | loopStmt | whileStmt | untilStmt | asLongStmt | doWhileStmt | repeatAsLongStmt | repeatUntilStmt | doAsLongStmt | writeFileStmt | isNullStmt | existsStmt | sleepStmt | readFileStmt | deleteFileStmt | createFolderStmt | deleteFolderStmt | openFileStmt | minExpr | minListFunctionStmt | absFunctionStmt | sqrtFunctionStmt | roundFunctionStmt | randomFunctionStmt | meanFunctionStmt | medianFunctionStmt | maxFunctionStmt | maxFromListStmt | toLowerFunctionStmt | toUpperFunctionStmt | trimFunctionStmt | trimStartFunctionStmt | trimEndFunctionStmt | replaceFunctionStmt | splitFunctionStmt | leftFunctionStmt | leftRangeFunctionStmt | concatFunctionStmt | containsFunctionStmt | lengthAccess;

statement: (assignment | functionCall) ';';
block: '{' line* '}'; //Block muss mindestens 1 line haben


functionCall: IDENTIFIER '(' (expression (',' expression)*)? ')'; //nach einem Ausdruck können beliebig viele genommen werden
/*expression 
    : constant				            #constantExpression
    | IDENTIFIER				        #identifierExpression
    | functionCall				        #functionCallExpression
    | '(' expression ')'			    #parenthesizedExpression
    | '!' expression				    #notExpression
    | expression multiOp expression		#multiplicateExpression
    | expression addOp expression		#additiveExpression
    | expression compareOp expression	#comparisonExpression
    ;
*/
assignment: IDENTIFIER '=' expression;

expression
    : additiveExpression
    ;
additiveExpression
    : multiplicativeExpression (('+' | '-') multiplicativeExpression)*
    ;

multiplicativeExpression
    : primary (('*' | '/') primary)*
    ;

primary
    : IDENTIFIER
    | CONSTANT
    | '(' expression ')'
    ;

CONSTANT: [0-9]+ ('.' [0-9]+)?;
IDENTIFIER: [a-zA-Z_][a-zA-Z_0-9]*;

multiOp: '*' | '/' | '%';
addOp: '+' | '-';
compareOp: '==' | '!=' | '<' | '<=' | '>' | '>=';

constant: INTEGER | NUMBER | STRING | BOOL | NULL | CHARACTER | TEXT | UTC_DATE | ISO8601 | BIN | BINARY;

BOOL: 'true' | 'false';

WS: [ \t\r\n]+ -> skip; //Leerzeichen, Tabs, Zeichenumbrüche

INTEGER: [0-9]+;

NUMBER: [0-9]+ '.' [0-9]+;

STRING: ('"' ~'"'* '"') | ('\'' ~'\''* '\'');

TEXT: ('"' ~'"'* '"') | ('\'' ~'\''* '\'');

CHAR: '\'' (ESC | ~['\\]) '\'';

CHARACTER: '\'' (ESC | ~['\\]) '\'';

fragment ESC: '\\' [btnr"'\\];

NULL: 'null';

BIN: '0' | '1';

BINARY: '0' | '1';

UTC_DATE
  : DIGIT DIGIT '-' DIGIT DIGIT '-' DIGIT DIGIT
    (':' DIGIT DIGIT
      (':' DIGIT DIGIT
        (':' DIGIT DIGIT)?
      )?
    )?
  ;

ISO8601
  : DIGIT DIGIT DIGIT DIGIT '-' DIGIT DIGIT '-' DIGIT DIGIT
    ':' DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT
    ('+' | '-') DIGIT DIGIT ':' DIGIT DIGIT
  ;

fragment DIGIT : [0-9];

LINE_COMMENT
  : '//' ~[\r\n]* -> skip
  ;

BLOCK_COMMENT
  : '!!' .*? '!!' -> skip
  ;

forStmt
  : 'for' IDENTIFIER 'from' INTEGER 'to' INTEGER '{' line* '}'
  ;

repeatStmt
  : 'repeat' INTEGER 'times' '{' line* '}'
  ;

loopStmt
  : 'loop from' INTEGER 'to' INTEGER '{' line* '}'
  ;

whileStmt
  : 'while' expr compareOp expr '{' line* '}'
  ;

expr
  : NUMBER
  | IDENTIFIER
  | expr OP expr
  ;

OP: '+' | '-' | '*' | '/' | '%';

untilStmt
  : 'until' expr compareOp expr '{' line* '}'
  ;

asLongStmt
  : 'as' 'long' 'as' expr customCompOp expr '{' line* '}'
  ;

customCompOp
  : 'isBigger'
  | 'isSmaller'
  | 'isEqual'
  | 'isNotEqual'
  | 'isBiggerThan'
  | 'isSmallerThan'
  | 'isNotEqualThan'
  ;

doWhileStmt
  : 'do' '{' line* '}' 'while' expr customCompOp expr
  ;

repeatAsLongStmt
  : 'repeat' '{' line* '}' 'as long' expr customCompOp expr
  ;

repeatUntilStmt
  : 'repeat' '{' line* '}' 'until' expr customCompOp expr
  ;

doAsLongStmt
  : 'do' '{' line* '}' 'as long' expr customCompOp expr
  ;

writeFileStmt
  : 'var' IDENTIFIER '.' 'WriteFile' '(' STRING ')'
  ;

isNullStmt
  : 'var' IDENTIFIER '.' 'IsNull' '(' IDENTIFIER ')'
  ;


existsStmt
  : 'var' IDENTIFIER '.' 'Exists' '(' (STRING | IDENTIFIER) ')'
  ;

sleepStmt
  : 'Sleep' '(' INTEGER ')'
  ;

readFileStmt
  : IDENTIFIER '.' 'ReadFile' '(' STRING ')'
  ;

deleteFileStmt
  : 'DeleteFile' '(' STRING ')'
  ;

createFolderStmt
  : 'CreateFolder' '(' STRING ')'
  ;

deleteFolderStmt
  : 'DeleteFolder' '(' STRING ')'
  ;


openFileStmt
  : 'OpenFile' '(' STRING ')'
  ;

minExpr
  : IDENTIFIER '.' 'Min' '(' numberList ')'        # minFunctionCall
  ;

numberList
  : NUMBER (',' NUMBER)*
  ;
//gehört zur minExpr

minListFunctionStmt
  : 'var' IDENTIFIER '.' 'Min' '(' IDENTIFIER ')'
  ;

absFunctionStmt
  : 'var' IDENTIFIER '.' 'Abs' '(' (NUMBER | IDENTIFIER) ')'
  ;

sqrtFunctionStmt
  : 'var' IDENTIFIER '.' 'Sqrt' '(' (NUMBER | IDENTIFIER) ',' (NUMBER | IDENTIFIER) ')'
  ;

roundFunctionStmt
  : 'var' IDENTIFIER '.' 'Round' '(' (NUMBER | IDENTIFIER) ',' (NUMBER | IDENTIFIER) ')'
  ;

randomFunctionStmt
  : 'var' IDENTIFIER '.' 'Random' '(' (NUMBER | IDENTIFIER) ',' (NUMBER | IDENTIFIER) ')'
  ;

meanFunctionStmt
  : 'var' IDENTIFIER '.' 'Mean' '(' IDENTIFIER ')'
  ;

medianFunctionStmt
  : 'var' IDENTIFIER '.' 'Median' '(' IDENTIFIER ')'
  ;

maxFunctionStmt
  : 'var' IDENTIFIER '.' 'Max' '(' valueList ')'
  ;

valueList
  : (NUMBER | IDENTIFIER) (',' (NUMBER | IDENTIFIER))*
  ;
//gehört zum maxFunctionStmt

maxFromListStmt
  : 'var' IDENTIFIER '.' 'Max' '(' IDENTIFIER ')'
  ;

toLowerFunctionStmt
  : 'var' IDENTIFIER '.' 'ToLower' '(' IDENTIFIER ')'
  ;

toUpperFunctionStmt
  : 'var' IDENTIFIER '.' 'ToUpper' '(' IDENTIFIER ')'
  ;

trimFunctionStmt
  : 'var' IDENTIFIER '.' 'Trim' '(' IDENTIFIER ')'
  ;

trimStartFunctionStmt
  : 'var' IDENTIFIER '.' 'TrimStart' '(' IDENTIFIER ')'
  ;

trimEndFunctionStmt
  : 'var' IDENTIFIER '.' 'TrimEnd' '(' IDENTIFIER ')'
  ;

replaceFunctionStmt
  : 'var' IDENTIFIER '.' 'Replace' '(' IDENTIFIER ',' STRING ',' STRING ')'
  ;

splitFunctionStmt
  : 'var' IDENTIFIER'.' 'Split' '(' IDENTIFIER ',' STRING ')'
  ;

leftFunctionStmt
  : 'var' IDENTIFIER '.' 'Left' '(' IDENTIFIER ',' INTEGER ')'
  ;

leftRangeFunctionStmt
  : 'var' IDENTIFIER '.' 'Left' '(' IDENTIFIER ',' INTEGER ',' INTEGER ')'
  ;

concatFunctionStmt
  : 'var' IDENTIFIER '.' 'Concat' '(' IDENTIFIER ',' IDENTIFIER ',' STRING ')'
  ;

containsFunctionStmt
  : 'var' IDENTIFIER '.' 'Contains' '(' IDENTIFIER ',' STRING ')'
  ;

lengthAccess
  : IDENTIFIER '.' 'Length'
  ;


//end hinzufügen