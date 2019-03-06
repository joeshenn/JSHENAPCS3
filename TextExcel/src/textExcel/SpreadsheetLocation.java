package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private String location;
	private char[] input;
    public SpreadsheetLocation(String cellName)
    {
        // TODO: Fill this out with your own code
    	location = cellName.toUpperCase();
    	input = new char[location.length()];
    	for(int i=0;i<location.length();i++) {
    		input[i]=location.charAt(i);
    		}
    	}
    @Override
    public int getRow()
    {
        // TODO Auto-generated method stub
        return input[0]-65;
    	
    }

    @Override
    public int getCol()
    {
        // TODO Auto-generated method stub
    	if (location.length()==2){
            return input[1];
    	}
    	else if (location.length()==3) {
    	return Integer.parseInt((""+input[1])+(""+input[2])) - 1;
    	}
    	else {
    		return 0;
    	}

    }
    }


