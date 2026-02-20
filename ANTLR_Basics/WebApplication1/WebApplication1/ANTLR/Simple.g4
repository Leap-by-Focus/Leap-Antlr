grammar Simple;

//--Notizen--
//Grammatik für Listen notwendig
// bis dahin explizite Listen
// Garbage Collection "aktivieren"
//right string methode


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
    : (IDENTIFIER | PRINT) '(' expression? ')'
    ;

//Objektorientiert -> Collections
COLLECTION_TYPE
    : 'LinkedList' | 'List' | 'Set' | 'Map' | 'HashMap' 
    | 'Stack' | 'Dictionary' | 'Tuple' | 'Queue'
    ;

//Methoden für Collections -> add,put,remove,delete,sort,getAll,getBy,getByIndex

method_type
    : 'add' | 'put' | 'remove' | 'delete' | 'sort' | 'getAll' | 'getBy' | 'getByIndex' | 'sort'
    ;

// Expressions
expression
    : '-' expression                                #UnaryMinusExpression
    | expression addOp expression                   #AdditiveExpression
    | expression multiOp expression                 #MultiplicateExpression
    | '(' expression ')'                            #ParenthesizedExpression
    | constant                                      #ConstantExpression
    | IDENTIFIER                                    #IdentifierExpression
    | 'new' IDENTIFIER '(' ')'                      #ObjectCreationExpression
    | lengthAccessExpr                              #LengthAccessExpression 
    | 'new' COLLECTION_TYPE '(' expressionList? ')' #ObjectCreationExpression
    ;

expressionList
    : expression (',' expression)*
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
    | '%'
    ;

// Datentypen
constant
    : NUMBER
    | STRING
    | CHARACTER
    | NULL
    | BOOL
    | BINARY
    ;

// Datentyp-Tokens
NUMBER
    : [0-9]+ ('.' [0-9]+)?
    | [0-9]+
    ;

// Logik & Bedingungen
IF     : 'if' | 'wenn';
WHILE  : 'while' | 'solange';
LOOP   : 'loop' | 'schleife';
FROM   : 'from' | 'von';
TO     : 'to' | 'bis';
PRINT  : 'print' | 'ausgeben' | 'drucke';
BOOL   : 'true' | 'false' | 'wahr' | 'falsch';
STRING: ('"' ~'"'* '"');
SONST    : 'else' | 'default' | 'sonst';
SWITCH  : 'switch' | 'entscheidung' | 'wahl';
CASE    : 'case' | 'fall';
//TEXT: ('"' ~'"'* '"') | ('\'' ~'\''* '\''); -> doppelte Deklaration
CHARACTER: '\'' (ESC | ~['\\]) '\'';
fragment ESC: '\\' [btnr"'\\];
NULL: 'null';
//BIN: '0' | '1'; -> doppelte Deklaration
BINARY: '0' | '1';

// Kommentare
LINE_COMMENT: '//' ~[\r\n]* -> skip;
ARROW_COMMENT: '--' ~[\r\n]* -> skip;

IDENTIFIER
    : [a-zA-Z_][a-zA-Z0-9_]*
    ;

// AS_LONG als ein Token mit optionalem Whitespace
AS_LONG: 'as' [ \t\r\n]* 'long';


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
    | rightFunctionStmt
    | ifStmt
    | switchStmt
    ;

block: '{' line* '}';

// Vergleichsoperatoren
compareOp: '==' | '!=' | '<' | '<=' | '>' | '>=';

// ---Schleifen und Bedingungen---

// erledigt -> if-Bedingung
ifStmt
    : IF '(' expression compareOp expression ')' '{' line* '}' (SONST '{' line* '}')?
    ;

// wird erledigt -> switch-case-Bedingung
switchStmt
    : SWITCH '(' expression ')' '{' caseStmt* defaultStmt? '}'
    ;

//für switch-case erforderlich!
caseStmt
    : CASE constant ':' line*
    ;

//für switch-case erforderlich!
defaultStmt
    : SONST ':' line*
    ;

// erledigt -> for-Schleife
forStmt
    : 'for' IDENTIFIER FROM expr TO expr '{' line* '}'
    ;

// erledigt -> repeat-Schleife
repeatStmt
    : 'repeat' expr 'times' '{' line* '}'
    ;

// erledigt -> loop-Schleife
loopStmt
    : LOOP FROM expr TO expr '{' line* '}'
    ;

// erledigt -> while-Schleife
whileStmt
    : WHILE expr compareOp expr '{' line* '}'
    ;

expr
    : NUMBER
    | IDENTIFIER
    | STRING
    | expr (addOp | multiOp) expr
    ;

//OP: '+' | '-' | '*' | '/' | '%'; doppelte Deklaration

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
    : 'isSmaller'
    | 'isEqual'
    | 'isNotEqual'
    | 'isSmallerOrEqual' //-> neu
    | 'isNotEqualThan'
    | 'isGreater' //-> neu
    | 'isGreaterOrEqual' //-> neu
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

// ---File-Methoden---

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

// ---Mathematische Funktionen---

// erledigt -> kleinste Zahl 
minExpr
    : IDENTIFIER '.' 'Min' '(' valueList ')' ';' #minFunctionCall
    ;

// erledigt -> kleineste Zahl aus Liste
minListFunctionStmt
    : 'var' IDENTIFIER '.' 'Min' '(' (IDENTIFIER | valueList) ')' ';'
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
    : 'var' IDENTIFIER '.' 'Mean' '(' (IDENTIFIER | valueList) ')' ';'
    ;

// erledigt -> Zentralwert (Median)
medianFunctionStmt
    : 'var' IDENTIFIER '.' 'Median' '(' (IDENTIFIER | valueList) ')' ';'
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

//---String-Funktionen---

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
    : 'var' IDENTIFIER '.' 'Left' '(' IDENTIFIER ',' expression ')' ';' //geändert
    ;

// erledigt -> linke Zeichen mit Bereich extrahieren
leftRangeFunctionStmt
    : 'var' IDENTIFIER '.' 'Left' '(' IDENTIFIER ',' NUMBER ',' NUMBER ')' ';'
    ;

// erledigt -> Text verketten
concatFunctionStmt
    : 'var' IDENTIFIER '.' 'Concat' '(' IDENTIFIER ',' IDENTIFIER ',' STRING ')' ';'
    ;

// erledigt -> Text nach bestimmtem Wert durchsuchen
containsFunctionStmt
    : 'var' IDENTIFIER '.' 'Contains' '(' IDENTIFIER ',' STRING ')' ';'
    ;

// erledigt -> Länge einen Textes
lengthAccessExpr
    : IDENTIFIER '.' 'Length'
    ;

//rechte Zeichen mit Bereich extrahieren -> noch hinzugefügt
rightFunctionStmt
    : 'var' IDENTIFIER '.' 'Right' '(' (IDENTIFIER | STRING) ',' expression ')' ';'
    ;