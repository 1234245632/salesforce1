package AutomationSFDC;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;



public class Driver extends Reusable {
	
	static int resultflag = 0;
	
	
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		Reusable re1=new Reusable();
		
		// TODO Auto-generated method stub
		

		 String dt_table="C:\\Users\\seema\\OneDrive\\Desktop\\fwsa.xls"; 
		String[][] recData=Reusable.get_readXlData( dt_table,"Sheet1");
//	Method testCase=AutomationScripts.class.getMethod("ForgotPassword_4B");
//   testCase.invoke(testCase);
	

		     for(int i = 1; i <recData.length; i++) {
			 resultflag = 0;
			 if(recData[i][1].equalsIgnoreCase("Y")) {
			 String testScript = recData[i][2];
			 Method testCase = AutomationScripts.class.getMethod(testScript);
			 testCase.invoke(testCase);
			 
			
				
			}else   {
				
				resultflag = 1;	
				System.out.println("Row number "+i+" script execution is skipped");
			}
//			 else if( ) {
//				 resultflag =2;
//				System.out.println("Row number "+i+" script execution is failed");
//				
//			}
//				resultflag = 2;
//				System.out.println("Row number "+i+" script execution is Failed");
			 if(resultflag == 1) {

					writeXlData(i,"skip","Blue");

				}else if(resultflag == 0) {

				
					writeXlData(i,"Pass","Green");

				}
				else 
				{
					writeXlData(i,"Fail","Red");
				}
			}
			

			
		}
}





	
	


