/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laytonsmith.core.compiler;

import com.laytonsmith.core.ParseTree;
import com.laytonsmith.core.constructs.Construct;
import com.laytonsmith.core.constructs.DocComment;
import com.laytonsmith.core.constructs.Target;
import com.laytonsmith.core.environments.Env;
import java.util.List;

/**
 *
 * @author Layton
 */
public class ProcedureDefinition extends Construct{
	String name;
	DocComment comment;
	Env env;
	List<String> varNames;
	List<ParseTree> varDefaults;
	ParseTree code;	
	public ProcedureDefinition(String name, DocComment comment, List<String> varNames, List<ParseTree> varDefaults, ParseTree code, Target target){
		super(name, Construct.ConstructType.FUNCTION, target);
	}

	public boolean isDynamic() {
		boolean ret = true;
		for(ParseTree defs : varDefaults){
			if(defs.isDynamic()){
				ret = false;
				break;
			}
		}
		if(code.isDynamic()){
			ret = false;
		}
		return ret;
	}
}