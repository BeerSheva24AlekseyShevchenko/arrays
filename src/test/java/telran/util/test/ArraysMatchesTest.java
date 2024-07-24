package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;
import static telran.util.Arrays.*;

import org.junit.jupiter.api.Test;

import telran.util.CharacterRule;

public class ArraysMatchesTest {
    @Test
    void matchesRulesTest() {    
        CharacterRule[] rulesPositive = new CharacterRule[] {
            new CharacterRule(true, Character::isUpperCase, "no capital"),
            new CharacterRule(true, Character::isLowerCase, "no lower"),
            new CharacterRule(true, Character::isDigit, "no digit"),
            new CharacterRule(true, a -> a == '.', "no dot"),
        };

        CharacterRule[] rulesNegative = new CharacterRule[] {
            new CharacterRule(false, Character::isWhitespace,  "space disallowed"),
        };

        char[] charArr1 = new char[] {'a', 'n', '*', 'G', '.', '.', '1'};
        char[] charArr2 = new char[]  {'a', 'n', '*', 'G', '.', '.', '1', ' '};
        char[] charArr3 = new char[] {'a', 'n', '*',  '.', '.', '1'};
        char[] charArr4 = new char[] {'*', 'G', '.', '.', '1'};
        char[] charArr5 = new char[] {'a', 'n', '*', 'G', '.', '.'};
        char[] charArr6 = new char[] {'a', 'n', '*', 'G', '1'};
        char[] charArr7 = new char[] {' '};

        assertEquals("", matchesRules(charArr1, rulesPositive, rulesNegative));
        assertEquals("space disallowed", matchesRules(charArr2, rulesPositive, rulesNegative));
        assertEquals("no capital", matchesRules(charArr3, rulesPositive, rulesNegative));
        assertEquals("no lower", matchesRules(charArr4, rulesPositive, rulesNegative));
        assertEquals("no digit", matchesRules(charArr5, rulesPositive, rulesNegative));
        assertEquals("no dot", matchesRules(charArr6, rulesPositive, rulesNegative));
        assertEquals("no capital, no lower, no digit, no dot, space disallowed", matchesRules(charArr7, rulesPositive, rulesNegative));
    }
}
