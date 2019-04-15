
/**
 * The mathematical/logical unit of themips processor
 */
public class ALU {
	public static final String AND = "100100";
  public static final String OR = "100101";
  public static final String ADD = "100000";
  public static final String SUBTRACT = "100010";
  public static final String NOR = "100111";
		public static final String SLT = "101010";
		public static final String MULTIPLY = "011000";
	public static final String DIVIDE=	"011010";
	public static final String SHIFT_RIGHT=	"000010";
	public static final String SHIFT_LEFT=	"000000";



	private int out;
	/**
	 * @return the out value
	 */
	public int getOut() {
		return out;
	}

	/**
	 * @return the zero line control
	 */
	public boolean isZero() {
		return zero;
	}

	private boolean zero;

	public void setOperation( String control, int srcv, int rsv) {
		zero = false;
		out = 0;

		switch(control) {
		case ADD:
			out =  rsv + srcv;
			break;
		case SUBTRACT:
			out = rsv - srcv;
			if(out == 0) {
				zero = true;
			}
			break;
		case AND:
			out = rsv & srcv;
			break;

		case OR:
			out = rsv | srcv;
			break;
		case NOR:
			out = ~(rsv | srcv);
			break;
      case MULTIPLY:
  			out =  rsv * srcv;
  			break;
     case DIVIDE:
    			out =  rsv / srcv;
    			break;
      case "100110":
      			out =  rsv ^ srcv;
      			break;
		  case SLT:
			      out = rsv < srcv ? 1 : 0;
			      break;
		case SHIFT_RIGHT:
							out =  rsv >> srcv;
							break;
		case SHIFT_LEFT:
								out =  rsv << srcv;
								break;
		}

	}
}
