package dataDriven;

public class DataDriver 
{

	public static void main(String[] args) throws Exception 
	{
		ExcelAPI e1=new ExcelAPI("C:\\Users\\DELL\\Desktop\\testdata.xlsx");
		
		System.out.println(e1.getCellData("login", 1, 1));
		System.out.println(e1.getCellData("login", "UserName", 2));
		
		e1.setCellData("login", 4, 1, "passed");

	}

}
