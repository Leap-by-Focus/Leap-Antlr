grammar Simple;

//--Notizen--
//Grammatik für Listen notwendig
// bis dahin explizite Listen
// Garbage Collection "aktivieren"
//String-Methoden
//Kommentare


// Basisstruktur
program
    : (statement | line)+ EOF
    ;

statement
    : assignment ';'
    | functionCall ';'
    ;

// Variablenzuweisung
assignment
    : IDENTIFIER '=' expression
    ;

// Funktionsaufrufe
functionCall
    : IDENTIFIER '(' expression? ')'
    ;

// Expressions
expression
    : '-' expression                          #UnaryMinusExpression
    | expression addOp expression             #AdditiveExpression
    | expression multiOp expression           #MultiplicateExpression
    | '(' expression ')'                      #ParenthesizedExpression
    | constant                                #ConstantExpression
    | IDENTIFIER                              #IdentifierExpression
    | 'new' IDENTIFIER '(' ')'                #ObjectCreationExpression
    ;

// addieren und subtrahieren
addOp
    : '+'
    | '-'
    ;

// multiplizieren und dividieren
multiOp
    : '*'
    | '/'
    ;

// Datentypen
constant
    : NUMBER
    | STRING
    | CHARACTER
    | NULL
    ;

// Token-Definitionen
NUMBER
    : [0-9]+ ('.' [0-9]+)?
    | [0-9]+
    ;

IDENTIFIER
    : [a-zA-Z_][a-zA-Z0-9_]*
    ;

// AS_LONG als ein Token mit optionalem Whitespace
AS_LONG: 'as' [ \t\r\n]* 'long';

// 'from' als separates Token für LOOP
FROM: 'from';

WS
    : [ \t\r\n]+ -> skip
    ;

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

// Vergleichsoperatoren
compareOp: '==' | '!=' | '<' | '<=' | '>' | '>=';

// Schleifen und Bedingungen

// erledigt -> for-Schleife
forStmt
    : 'for' IDENTIFIER 'from' expr 'to' expr '{' line* '}'
    ;

// erledigt -> repeat-Schleife
repeatStmt
    : 'repeat' expr 'times' '{' line* '}'
    ;

// erledigt -> loop-Schleife
loopStmt
    : 'loop' 'from' expr 'to' expr '{' line* '}'
    ;

// erledigt -> while-Schleife
whileStmt
    : 'while' expr compareOp expr '{' line* '}'
    ;

expr
    : NUMBER
    | IDENTIFIER
    | STRING
    | expr OP expr
    ;

OP: '+' | '-' | '*' | '/' | '%';

// erledigt -> until-Schleife
untilStmt
    : 'until' expr compareOp expr '{' line* '}'
    ;

// erledigt -> as-long-Schleife
asLongStmt
  : AS_LONG 'as' expr customCompOp expr '{' line* '}'
  ;


// muss noch implementiert werden
customCompOp
    : 'isBigger'
    | 'isSmaller'
    | 'isEqual'
    | 'isNotEqual'
    | 'isBiggerThan'
    | 'isSmallerThan'
    | 'isNotEqualThan'
    | '>'
    | '<'
    | '=='
    | '>='
    | '<='
    | '!='
    ;

// erledigt -> do-while-Schleife
doWhileStmt
    : 'do' '{' line* '}' 'while' expr customCompOp expr
    ;

// erledigt -> repeat-as-Long-Schleife
repeatAsLongStmt
    : 'repeat' '{' line* '}' AS_LONG expr customCompOp expr
    ;

// erledigt -> repeat-until-Schleife
repeatUntilStmt
    : 'repeat' '{' line* '}' 'until' expr customCompOp expr
    ;

// erledigt -> do-as-Long-Schleife
doAsLongStmt
    : 'do' '{' line* '}' AS_LONG expr customCompOp expr
    ;

// File

// erledigt -> Datei schreiben
writeFileStmt
    : IDENTIFIER '.' 'WriteFile' '(' STRING ')' ';'
    ;

// erledigt -> ist null
isNullStmt
    : 'var' IDENTIFIER '.' 'IsNull' '(' (IDENTIFIER | STRING) ')' ';'
    ;

// erledigt -> Datei existiert
existsStmt
    : 'var' IDENTIFIER '.' 'Exists' '(' (STRING | IDENTIFIER) ')' ';'
    ;

// erledigt -> schlafen
sleepStmt
    : 'Sleep' '(' NUMBER ')' ';'
    ;

// erledigt -> Datei lesen
readFileStmt
    : IDENTIFIER '.' 'ReadFile' '(' STRING ')' ';'
    ;

// erledigt -> Datei löschen
deleteFileStmt
    : 'DeleteFile' '(' STRING ')' ';'
    ;

// erledigt -> Ordner erstellen
createFolderStmt
    : 'CreateFolder' '(' STRING ')' ';'
    ;

// erledigt -> Ordner löschen
deleteFolderStmt
    : 'DeleteFolder' '(' STRING ')' ';'
    ;

// erledigt -> Datei öffnen
openFileStmt
    : 'OpenFile' '(' STRING ')' ';'
    ;

// Mathematische Funktionen

// erledigt -> kleinste Zahl 
minExpr
    : IDENTIFIER '.' 'Min' '(' numberList ')' ';' #minFunctionCall
    ;

numberList
    : NUMBER (',' NUMBER)*
    ;

// erledigt -> kleineste Zahl aus Liste
minListFunctionStmt
    : 'var' IDENTIFIER '.' 'Min' '(' (IDENTIFIER | numberList) ')' ';'
    ;

// erledigt -> Absolutwert (immer positiv)
absFunctionStmt
    : 'var' IDENTIFIER '.' 'Abs' '(' (NUMBER | IDENTIFIER) ')' ';'
    ;

// erledigt -> Quadratwurzel
sqrtFunctionStmt
    : 'var' IDENTIFIER '.' 'Sqrt' '(' (NUMBER | IDENTIFIER) ',' (NUMBER | IDENTIFIER) ')' ';'
    ;

// erledigt -> Runden
roundFunctionStmt
    : 'var' IDENTIFIER '.' 'Round' '(' (NUMBER | IDENTIFIER) ',' (NUMBER | IDENTIFIER) ')' ';'
    ;

// erledigt -> Zufallszahl
randomFunctionStmt
    : 'var' IDENTIFIER '.' 'Random' '(' (NUMBER | IDENTIFIER) ',' (NUMBER | IDENTIFIER) ')' ';'
    ;

// erledigt -> Durchschnitt (Mittelwert)
meanFunctionStmt
    : 'var' IDENTIFIER '.' 'Mean' '(' (IDENTIFIER | numberList) ')' ';'
    ;

// erledigt -> Zentralwert (Median)
medianFunctionStmt
    : 'var' IDENTIFIER '.' 'Median' '(' (IDENTIFIER | numberList) ')' ';'
    ;

// erledigt -> größte Zahl
maxFunctionStmt
    : 'var' IDENTIFIER '.' 'Max' '(' valueList ')' ';'
    ;

valueList
    : (NUMBER | IDENTIFIER) (',' (NUMBER | IDENTIFIER))*
    ;

// erledigt -> größter Wert aus Liste
maxFromListStmt
    : 'var' IDENTIFIER '.' 'Max' '(' IDENTIFIER ')' ';'
    ;

// String-Funktionen

// erledigt -> Text in Kleinbuchstaben umwandeln
toLowerFunctionStmt
    : 'var' IDENTIFIER '.' 'ToLower' '(' IDENTIFIER ')' ';'
    ;
// erledigt -> Text in Großbuchstaben umwandeln
toUpperFunctionStmt
    : 'var' IDENTIFIER '.' 'ToUpper' '(' IDENTIFIER ')' ';'
    ;
// erledigt -> Leerzeichen außen entfernen (an beiden Seiten)
trimFunctionStmt
    : 'var' IDENTIFIER '.' 'Trim' '(' IDENTIFIER ')' ';'
    ;

// ereledigt -> Leerzeichen am Anfang entfernen
trimStartFunctionStmt
    : 'var' IDENTIFIER '.' 'TrimStart' '(' IDENTIFIER ')' ';'
    ;

// erledigt -> Leerzeichen am Ende entfernen
trimEndFunctionStmt
    : 'var' IDENTIFIER '.' 'TrimEnd' '(' IDENTIFIER ')' ';'
    ;

// erledigt -> bestimmten Text ersetzen
replaceFunctionStmt
    : 'var' IDENTIFIER '.' 'Replace' '(' IDENTIFIER ',' STRING ',' STRING ')' ';'
    ;

// erledigt -> Text aufteilen durch bestimmtes Trennzeichen
splitFunctionStmt
    : 'var' IDENTIFIER'.' 'Split' '(' IDENTIFIER ',' STRING ')' ';'
    ;

// erledigt -> linke Zeichen extrahieren
leftFunctionStmt
    : 'var' IDENTIFIER '.' 'Left' '(' IDENTIFIER ',' NUMBER ')' ';'
    ;

// erledigt -> linke Zeichen mit Bereich extrahieren
leftRangeFunctionStmt
    : 'var' IDENTIFIER '.' 'Left' '(' IDENTIFIER ',' NUMBER ',' NUMBER ')' ';'
    ;

//c
concatFunctionStmt
    : 'var' IDENTIFIER '.' 'Concat' '(' IDENTIFIER ',' IDENTIFIER ',' STRING ')' ';'
    ;

//c
containsFunctionStmt
    : 'var' IDENTIFIER '.' 'Contains' '(' IDENTIFIER ',' STRING ')' ';'
    ;

//c
lengthAccess
    : IDENTIFIER '.' 'Length' ';'
    ;

// Datentyp-Tokens
BOOL: 'true' | 'false';
STRING: ('"' ~'"'* '"') | ('\'' ~'\''* '\'');
TEXT: ('"' ~'"'* '"') | ('\'' ~'\''* '\'');
CHARACTER: '\'' (ESC | ~['\\]) '\'';
fragment ESC: '\\' [btnr"'\\];
NULL: 'null';
BIN: '0' | '1';
BINARY: '0' | '1';

// Kommentare (müssen noch implementiert werden)
LINE_COMMENT: '//' ~[\r\n]* -> skip;
//BLOCK_COMMENT: '!!' .*? '!!' -> skip; -> deaktiviert, weil nicht besprochen