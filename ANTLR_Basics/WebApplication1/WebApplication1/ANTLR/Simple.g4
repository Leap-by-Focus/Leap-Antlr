grammar Simple;

//lexer -> die mit Kleinbuchstaben -> definieren die Tokens
//parser -> die mit Großbuchstaben -> definieren die Grammatik
program: line* EOF;
line: statement | block;
statement: (assignment | functionCall) ';';
//ifBlock: 'if' expression block ('else' elseIfBlock)?;
//elseIfBlock: block | ifBlock;
block: '{' line* '}'; //Block muss mindestens 1 line haben
//whileBlock: WHILE expression block ('else' elseIfBlock)?; //null oder 1mal
assignment: IDENTIFIER '=' expression;
//WHILE: 'while' | 'until';

functionCall: IDENTIFIER '(' (expression (',' expression)*)? ')'; //nach einem Ausdruck können beliebig viele genommen werden
expression 
    : constant				            #constantExpression
    | IDENTIFIER				        #identifierExpression
    | functionCall				        #functionCallExpression
    | '(' expression ')'			    #parenthesizedExpression
    | '!' expression				    #notExpression
    | expression multiOp expression		#multiplicateExpression
    | expression addOp expression		#additiveExpression
    | expression compareOp expression	#comparisonExpression
    ;

multiOp: '*' | '/' | '%';
addOp: '+' | '-';
compareOp: '==' | '!=' | '<' | '<=' | '>' | '>=';

constant: INTEGER | NUMBER | STRING | BOOL | NULL | CHARACTER | TEXT | UTC_DATE | ISO8601 | BIN | BINARY;

BOOL: 'true' | 'false';

WS: [ \t\r\n]+ -> skip; //Leerzeichen, Tabs, Zeichenumbrüche

IDENTIFIER: [a-zA-Z_][a-zA-Z0-9_]*;

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


//end hinzufügen