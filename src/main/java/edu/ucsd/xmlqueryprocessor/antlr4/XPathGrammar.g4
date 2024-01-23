grammar XPathGrammar;

/*
(absolute path)
ap -> doc(fileName)/rp | doc(fileName)//rp

(relative path)
rp -> tagName | ∗ | . | .. | text() | @attName | (rp) | rp1/rp2 | rp1//rp2 | rp[f] | rp1,rp2

(path filter)
f -> rp | rp1=rp2| rp1 eq rp2 | rp1==rp2 | rp1 is rp2 | rp=StringConstant | (f) | f1 and f2 | f1 or f2 | not f

// Find all persons in the play
doc("j_caesar.xml")//PERSONA

// Find the scenes in which CAESAR speaks
doc("j_caesar.xml")//SCENE[SPEECH/SPEAKER/text() = "CAESAR"]

// Find the acts containing some scene in which both CAESAR and BRUTUS speak
doc("j_caesar.xml")//ACT[SCENE [SPEECH/SPEAKER/text() = "CAESAR" and SPEECH/SPEAKER/text() = "BRUTUS"]]

// Same as previous, but different syntax
doc("j_caesar.xml")//ACT[SCENE [SPEECH/SPEAKER/text() = "CAESAR"][SPEECH/SPEAKER/text() = "BRUTUS"]]

// Find the acts in which CAESAR no longer appears
doc("j_caesar.xml")//ACT[not .//SPEAKER/text() = "CAESAR"]

*/


// Parser Rules
absolutePath
    : 'doc' '(' fileName ')' '/' relativePath
    | 'doc' '(' fileName ')' '//' relativePath
    ;


relativePath
    : rpLeaf
    | relativePath '[' pathFilter ']'
    | '(' relativePath ')'
    | rpLeaf ',' relativePath
    | rpLeaf '/' relativePath
    | rpLeaf '//' relativePath
    ;

rpLeaf
    : tagName
    | '*'
    | '.'
    | '..'
    | 'text()'
    | '@' attName
    ;

pathFilter
    : relativePath
    | relativePath '=' relativePath
    | relativePath 'eq' relativePath
    | relativePath '==' relativePath
    | relativePath 'is' relativePath
    | relativePath ' = ' stringConstant
    | '(' pathFilter ')'
    | pathFilter 'and' pathFilter
    | pathFilter 'or' pathFilter
    | 'not' pathFilter
    ;

fileName: STRING;
tagName: NAME;
attName: NAME;
stringConstant: STRING;

NAME: [a-zA-Z_][a-zA-Z_0-9]*;
STRING: '"' (~["\\] | '\\\\' | '\\"')* '"';
WS : [ \t\r\n]+ -> skip;
