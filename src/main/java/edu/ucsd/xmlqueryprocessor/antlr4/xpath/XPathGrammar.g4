grammar XPathGrammar;

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

fileName: STRING;
tagName: NAME;
attName: '@' NAME;
stringConstant: STRING;

NAME: [a-zA-Z_][a-zA-Z_0-9]*;
STRING: '"' (~["\\] | '\\\\' | '\\"')* '"';
WS : [ \t\r\n]+ -> skip;
