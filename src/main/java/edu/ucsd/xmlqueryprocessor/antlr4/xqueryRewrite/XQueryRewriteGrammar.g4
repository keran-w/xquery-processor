grammar XQueryRewriteGrammar;

xquery
    : var
    | stringConstant
    | absolutePath
    | '(' xquery ')'
    | xquery ',' xquery
    | xquery '/' relativePath
    | xquery '//' relativePath
    | '<' tagName '>' '{' xquery '}' '</' tagName '>'
    | forClause letClause? whereClause? returnClause
    | letClause whereClause? returnClause
    | letClause xquery
    ;

//path :
//     ( 'doc(' FileName ')' | Var ) Sep n1 Sep ... Sep nm
//    | ('doc('FileName')'|Var) Sep n1 Sep ... Sep 'text()'

Sep: '/' | '//';

forClause
    : 'for' var 'in' xquery
    | forClause ',' var 'in' xquery
    ;

letClause
    : 'let' var ':=' xquery
    | letClause ',' 'let' var ':=' xquery
    ;

whereClause
    : 'where' cond
    ;

returnClause
    : 'return' xquery
    ;

cond
    : xquery
    | xquery '=' xquery


    | xquery 'eq' xquery
    | xquery '==' xquery
    | xquery 'is' xquery
    | 'empty' '(' xquery ')'
    | 'some' var 'in' xquery 'satisfies' cond
    | '(' cond ')'
    | cond 'and' cond
    | cond 'or' cond
    | 'not' cond
    ;

absolutePath
    : 'doc' '(' fileName ')' '/' relativePath
    | 'doc' '(' fileName ')' '//' relativePath
    ;


relativePath
     : tagName
    | '*'
    | '.'
    | '..'
    | 'text()'
    | attName
    | relativePath '[' pathFilter ']'
    | '(' relativePath ')'
    | relativePath ',' relativePath
    | relativePath '/' relativePath
    | relativePath '//' relativePath
    ;


pathFilter
    : relativePath
    | relativePath '=' relativePath
    | relativePath 'eq' relativePath
    | relativePath '==' relativePath
    | relativePath 'is' relativePath
    | relativePath '=' stringConstant
    | '(' pathFilter ')'
    | pathFilter 'and' pathFilter
    | pathFilter 'or' pathFilter
    | 'not' pathFilter
    ;

var: '$' NAME;
fileName: STRING;
tagName: NAME;
attName: '@' NAME;
stringConstant: STRING;

NAME: [a-zA-Z_][a-zA-Z_0-9]*;
STRING: '"' (~["\\] | '\\\\' | '\\"')* '"';
WS : [ \t\r\n]+ -> skip;
