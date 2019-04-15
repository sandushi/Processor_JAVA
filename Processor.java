
public class Processor{

  private static int mux(int value1, int value2, boolean getSecond) {
     if(getSecond) {
       return value2;
     }
     return value1;
    }


public static void main(String[] args) {
    String ins;
    String opcode;
    String funct;
    int rs,rt,rd,imm;
    int alu_out = 0;
		boolean alu_zero = false;
		int data_out = 0;
    int regData1 = 0;
		int regData2 = 0;
    	int write_data;


    ALU alu= new ALU();
    ALUControl aluControl=new ALUControl();
    InstructionMemory insMem=new InstructionMemory();
    int numOfInstructions=insMem.getNumOfInstructions();
    InstructionDecode decode;
    RegisterFile register=new RegisterFile();
    MemoryFile memory=new MemoryFile();


		for(int i=0;i<numOfInstructions;i++){
    ins=insMem.InstructionFetch();

    //System.out.println(ins);
    decode=new InstructionDecode(ins);
    opcode=decode.getOpcode();
    Control control = new Control(decode);


    //reg
     rd = mux(decode.getReadRegister2(), decode.getWriteRegister(), control.isRegDist());

     register.setRegisters(decode.getReadRegister1(),decode.getReadRegister2(),rd);
     regData1=register.readData1();
     regData2=register.readData2();
     System.out.println("rs="+decode.getReadRegister1()+" "+"rt="+decode.getReadRegister2()+" "+"rd="+rd+" "+"readData1="+regData1+" "+"readData2="+regData2);



//memory
data_out = memory.cycle(alu_out, decode.getReadRegister2(), control.isMemRead(), control.isMemWrite());
//System.out.println(data_out);


//Writeback
		write_data = mux(alu_out, data_out, control.isMemtoReg());
		register.write(control.isRegWrite(), rd);







  }




}

  }
