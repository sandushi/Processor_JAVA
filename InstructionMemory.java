public class InstructionMemory{
static int ProgramCounter=0;
String Instructions[]={"10001100001001000000000000000111",//lw r4,r7(r1)
                    "10001100010001010000000000000111",  //lw r5,r7(r2)
                    "00000000100001010011000000100000", //add r6,r4,r5
                    "00000000110001000011100000100010", //sub r7,r6,r4
                   "10101101010001100000000000001010"}; //sw r4,r10(r10);


      String instruction;
      int numOfInstructions=Instructions.length;

      int getNumOfInstructions(){
        return numOfInstructions;
      }


       String InstructionFetch(){
           instruction=Instructions[ProgramCounter];

           ProgramCounter++;
           return instruction;
       }



}
