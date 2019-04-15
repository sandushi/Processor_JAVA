

/**
 * The processor register file
 */
public class RegisterFile extends DataField {
	private int rr1;
	private int rr2;
	private int wr;

	public RegisterFile() {
		super(32);
	}

	public void setRegisters(int read1, int read2, int write) {
		rr1 = read1;
		rr2 = read2;
		wr = write;
	}

	public int readData1() {
		return get(rr1);
	}

	public int readData2() {
		return get(rr2);
	}

	public void write(boolean RegWrite, int data) {
		if(RegWrite) {
			set(wr, data);
		}
	}


	@Override
	protected int get(int index) {
		if(index == 0) {
			return 0; // $zero register
		}
		return super.get(index);
	}

	@Override
	protected void set(int index, int value) {
		if(index == 0) {
			return;
		}
		super.set(index, value);
	}

	public static String name(int index) {
		String[] names = {
				"R0",
				"R1",
				"R2",
				"R3",
				"R4",
				"R5",
				"R6",
				"R7",
				"R8",
				"R9",
				"R10",
				"R11",
				"R12",
				"R13",
				"R14",
				"R15",
				"R16",
				"r17",
				"r18",
				"R19",
				"R20",
				"R21",
				"R22",
				"R23",
				"R24",
				"R25",
				"R26",
				"R27",
				"R28",
				"R29",
				"R30",
				"R31"
		};
		return names[index];
	}
}
