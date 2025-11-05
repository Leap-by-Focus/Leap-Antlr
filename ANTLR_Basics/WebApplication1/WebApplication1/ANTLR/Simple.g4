grammar Simple;

//Basisstruktur
program
    : (statement | line)+ EOF
    ;

statement
    : assignment ';'
    | functionCall ';'
    ;

//Variablenzuweisung
assignment
    : IDENTIFIER '=' expression
    ;

//Funktionsaufrufe
functionCall
    : IDENTIFIER '(' expression? ')'
    ;

//Expressions
expression
    : expression addOp expression             #AdditiveExpression
    | expression multiOp expression           #MultiplicateExpression
    | '(' expression ')'                      #ParenthesizedExpression
    | constant                                #ConstantExpression
    | IDENTIFIER                              #IdentifierExpression
    ;

addOp
    : '+'
    | '-'
    ;

multiOp
    : '*'
    | '/'
    ;

constant
    : NUMBER
    | STRING
    | CHARACTER
    ;

//Token-Definitionen
NUMBER
    : [0-9]+ ('.' [0-9]+)?
    ;

IDENTIFIER
    : [a-zA-Z_][a-zA-Z0-9_]*
    ;

WS
    : [ \t\r\n]+ -> skip
    ;

//Rest
line
    : statement
    | block
    | forStmt
    | repeatStmt
    | loopStmt
    | whileStmt
    | untilStmt
    | asLongStmt
    | doWhileStmt
    | repeatAsLongStmt
    | repeatUntilStmt
    | doAsLongStmt
    | writeFileStmt
    | isNullStmt
    | existsStmt
    | sleepStmt
    | readFileStmt
    | deleteFileStmt
    | createFolderStmt
    | deleteFolderStmt
    | openFileStmt
    | minExpr
    | minListFunctionStmt
    | absFunctionStmt
    | sqrtFunctionStmt
    | roundFunctionStmt
    | randomFunctionStmt
    | meanFunctionStmt
    | medianFunctionStmt
    | maxFunctionStmt
    | maxFromListStmt
    | toLowerFunctionStmt
    | toUpperFunctionStmt
    | trimFunctionStmt
    | trimStartFunctionStmt
    | trimEndFunctionStmt
    | replaceFunctionStmt
    | splitFunctionStmt
    | leftFunctionStmt
    | leftRangeFunctionStmt
    | concatFunctionStmt
    | containsFunctionStmt
    | lengthAccess
    ;

block: '{' line* '}';

compareOp: '==' | '!=' | '<' | '<=' | '>' | '>=';

//Schleifen und Bedingungen
forStmt
  : 'for' IDENTIFIER 'from' expr 'to' expr '{' line* '}'
  ;

repeatStmt
  : 'repeat' expr 'times' '{' line* '}'
  ;

loopStmt
  : 'loop from' expr 'to' expr '{' line* '}'
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


//File
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


//Mathematische Funktionen
minExpr
  : IDENTIFIER '.' 'Min' '(' numberList ')'        #minFunctionCall
  ;

numberList
  : NUMBER (',' NUMBER)*
  ;

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

maxFromListStmt
  : 'var' IDENTIFIER '.' 'Max' '(' IDENTIFIER ')'
  ;

// ==========================
//  STRING-FUNKTIONEN
// ==========================

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

//Basics

BOOL: 'true' | 'false';
INTEGER: [0-9]+;
STRING: ('"' ~'"'* '"') | ('\'' ~'\''* '\'');
TEXT: ('"' ~'"'* '"') | ('\'' ~'\''* '\'');
CHARACTER: '\'' (ESC | ~['\\]) '\'';
fragment ESC: '\\' [btnr"'\\];
NULL: 'null';
BIN: '0' | '1';
BINARY: '0' | '1';

LINE_COMMENT: '//' ~[\r\n]* -> skip;
BLOCK_COMMENT: '!!' .*? '!!' -> skip;
