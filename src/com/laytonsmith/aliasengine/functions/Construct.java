/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.laytonsmith.aliasengine.functions;

/**
 *
 * @author layton
 */
public class Construct{
    public enum ConstructType{
        TOKEN, COMMAND, FUNCTION, VARIABLE, LITERAL
    }

    public enum TType{
        UNKNOWN, OPT_VAR_START, OPT_VAR_END, OPT_VAR_ASSIGN, ALIAS_END, COMMA, FUNC_NAME, FUNC_START,
        FUNC_END, STRING, NEWLINE, MULTILINE_START, MULTILINE_END, COMMAND, SEPERATOR, VARIABLE,
        IVARIABLE, FINAL_VAR, LIT, ROOT
    }

    public ConstructType ctype;
    public TType type;
    public String value;
    public int line_num;

    public Construct(TType type, String value, ConstructType ctype, int line_num){
        this.type = type;
        this.value = value;
        this.ctype = ctype;
        this.line_num = line_num;
    }

    public String val(){
        return value;
    }
}
