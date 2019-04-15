import java.util.Arrays;


public class InstructionDecode{
     private int readRegister1=0;
     private int readRegister2=0;
     private int writeRegister=0;
     int  [] instructionNew =new int[32];
     private boolean is_r_type = false;
     String opcode = "0";
	    String funct = "0";
     String [] opcodearr=new String[6];
     String [] functarr=new String[6];
     String readReg1="0";
     String readReg2="0";
     String writeReg="0";
     String immVal="0";



     String [] readRegis1=new String[5];
     String [] readRegis2=new String[5];
     String [] writeRegis=new String[5];
     String [] imm=new String[16];



     int  k,l,m,n,p=0;


     public  InstructionDecode(String instruction){
       String[] ins=instruction.split("");
       for(int i=0;i<ins.length;i++){
       instructionNew[i] = Integer.parseInt(ins[i]);
      }
}

//get the opcode of instruction
    public String getOpcode(){
      for(int j=0;j<opcodearr.length;j++){
        opcodearr[j]=String.valueOf(instructionNew[j]);
        }
    opcode = convertStringArrayToString(opcodearr, "");

    return opcode;
}

//get the functioncode of the r_type instructions
public String getFunct(String opcode){

       is_r_type=true;

      for(int j=26;j<32;j++){

          functarr[k]=String.valueOf(instructionNew[j]);
          k++;
      }

      funct = convertStringArrayToString(functarr,"");

          return funct;
    }

//get the readRegister1
   public int getReadRegister1(){
         for(int x=6;x<11;x++){
           if(l<=4){
           readRegis1[l]=String.valueOf(instructionNew[x]);
           l++;
         }}
   readReg1 = convertStringArrayToString(readRegis1,"");
  return Integer.parseInt(readReg1,2);


}
//get the readRegistre2
public int getReadRegister2(){
      for(int z=11;z<16;z++){
       if(m<=4){
        readRegis2[m]=String.valueOf(instructionNew[z]);
        m++;
       }
}
readReg2 = convertStringArrayToString(readRegis2,"");
return Integer.parseInt(readReg2,2);
}

//get the writeRegister
public int getWriteRegister(){

      for(int y=16;y<21;y++){
        writeRegis[n]=String.valueOf(instructionNew[y]);
        n++;
      }


writeReg = convertStringArrayToString(writeRegis,"");
return Integer.parseInt(writeReg,2);

}

//get the immediate value
public int getImm(){
      for(int y=16;y<32;y++){
        imm[p]=String.valueOf(instructionNew[y]);
        p++;
      }
    immVal = convertStringArrayToString(imm,"");
return Integer.parseInt(immVal,2);

}

//convert string array to a string
    private static String convertStringArrayToString(String[] strArr, String delimiter) {
    		StringBuilder sb = new StringBuilder();
    		for (String str : strArr)
    			sb.append(str).append(delimiter);
    		return sb.substring(0, sb.length() );
    	}


      }
