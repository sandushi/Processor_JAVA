


public class ALUControl {
	public  String getControl(boolean ALUOp1, boolean ALUOp0, String funct){
		if(!ALUOp1 && !ALUOp0) {
			return ALU.ADD;
		}
		if(ALUOp0) {
			return ALU.SUBTRACT;
		}
		switch(funct) {
		case "100000":
			return ALU.ADD;
		case "100010":
			return ALU.SUBTRACT;
		case "100100":
			return ALU.AND;
		case "100101":
			return ALU.OR;
		case "100111":
			return ALU.NOR;

		case "101010":
			return ALU.SLT;

		case "011000":
		   return ALU.MULTIPLY;
		case "011010":
	 		   return ALU.DIVIDE;
	  case "000010":
		     return ALU.SHIFT_RIGHT;
	  case "000000":
		     return ALU.SHIFT_LEFT;

		}

		assert false;
		return "0";
	}
}
