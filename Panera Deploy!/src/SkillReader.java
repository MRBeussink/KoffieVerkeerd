import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SkillReader {
	
	private EmployeeSkillMap skillMap;
	private FileInputStream fis;
	private XSSFWorkbook wb;
	private XSSFSheet sheet;
	
	public SkillReader() throws IOException{
		skillMap = new EmployeeSkillMap();
		fis = new FileInputStream (new File("Skills.xlsx"));
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(0);
	}
	
	public EmployeeSkillMap makeEmployeeSkillMap(){
		 String name = "";
		
		for (Row row : sheet){
			for (int column = 0; true; column++){
				Cell cell = row.getCell(column);
				if( cell != null){
					String info = cell.getStringCellValue();
					if (info == null || info.equals("")){
						break;
					}
					if(column == 0){
						name = info;
						if(Driver.test)
							System.out.println("Adding Employee " + info + " to SkillMap");
						skillMap.addEmployee(info);
					}else {
						if(Driver.test)
							System.out.println("Adding Skill: " + info +" to employee: " + name);
						if(Driver.test && info == null)
							System.out.println("ERROR: Trying to parse null string to Enum");
						skillMap.addSkill(name, info);
					}
				}else
					break;
				
			}
		}
		return skillMap;
	}
	
}
