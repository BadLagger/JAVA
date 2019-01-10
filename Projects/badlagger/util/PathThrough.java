package badlagger.util;

public class PathThrough{
	private String path = null;
	private final  String alphabeth;
	private int    min;
	private int    max;
	/* Constructors */
	public PathThrough(String alphabeth, int min, int max){
		this.alphabeth = alphabeth;
		if(min > max){
			this.max = min;
			this.min = max;
		} else {
			this.min = min;
			this.max = max;
		}
	}
	/* Methods */
	public void setFileOutput(String path){
		this.path = path;		
	}
	
	public String getInfo(){
		return ("Alphabeth len: " + alphabeth.length() +
		        "\r\nStart from " + min + " symbols" +
				"\r\nEnd at " + max + " symbols" +
				"\r\nNumber of all combinations: " + (int)Math.pow(alphabeth.length(), (max - min)) +
				"\r\nOtput file: " + path +
				"\r\nAlphabeth: " + alphabeth);
	}
}