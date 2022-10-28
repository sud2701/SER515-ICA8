package src;

/*

Author - Sudheer Reddy Kunduru
skundur1@asu.edu
1226291354

 */



public class urinals {
    public static void main(String[] args){

    }
    public boolean isValid(String inpstr){
        int len=inpstr.length();
        if(len==0 || len >20){
            return false;
        }
        for(int i=0;i<len;i++){
            if(inpstr.charAt(i)=='0' || inpstr.charAt(i)=='1'){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }

}

