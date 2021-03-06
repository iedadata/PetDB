package petdb.data;

import java.util.*; 
import java.sql.*;
import jxl.*;
import jxl.write.*;

public class RockModeFSDS extends ResultSetFSDS
{
	static public int Analysis_Key 	 = 1;  
	static public int Sample_ID 	 = 2;  
	static public int Latitude 	     = 3;  
	static public int Longitute 	 = 4;  
	static public int Elevation 	 = 5;  
	static public int Tectonic 	     = 6;  
	static public int Rock 		     = 7;  
	static public int Reference 	 = 8;  
	static public int Reference_Num	 = 9;  
    static public int Sample_Num     = 10;
	static public int Latitude_N 	 = 11;  
    static public int Longitute_N    = 12;
    static public int Expedition     = 13;
    static public int Expedition_Num = 14;
    static public int Sample_IGSN    = 15;
    
	public RockModeFSDS(ResultSet rs, int count)
	{
		super(rs,count);
	}
    
	public boolean getExlRow(int offset,Vector v, int dynamic_counter, boolean flag) throws Exception
    {
		int i = -1;
		String val ="";
        boolean r =next();
        if (r)
        {	
			if (!flag)
			{
                v.setElementAt(new Label(++i,offset,getExlValue(dynamic_counter+Sample_ID)),i);
                v.setElementAt(new Label(++i,offset,getExlValue(dynamic_counter+Sample_IGSN)),i);
                
                for (int j=1 ;j<= dynamic_counter; j++)
				    v.setElementAt(getNumCell(++i,offset,getExlValue(j)),i);
			
			    val = getExlValue(dynamic_counter+Latitude_N);
                v.setElementAt(getNumCell(++i,offset,val),i);

                val = getExlValue(dynamic_counter+Longitute_N);
                v.setElementAt(getNumCell(++i,offset,val),i);

                val = getExlValue(dynamic_counter+Elevation);
                v.setElementAt(getNumCell(++i,offset,val),i);

                v.setElementAt(new Label(++i,offset,getExlValue(dynamic_counter+Tectonic)),i);
                v.setElementAt(new Label(++i,offset,getExlValue(dynamic_counter+Rock)),i);
                v.setElementAt(new Label(++i,offset,getExlValue(dynamic_counter+Reference)),i);
                v.setElementAt(new Label(++i,offset,getExlValue(dynamic_counter+Expedition)),i);
			} else {
                v.setElementAt(getExlValue(dynamic_counter+Sample_ID),++i);
                v.setElementAt(getExlValue(dynamic_counter+Sample_IGSN),++i);
                
                for (int j=1 ;j<= dynamic_counter; j++)
				    v.setElementAt(getExlValue(j),++i);
			
			    val = getExlValue(dynamic_counter+Latitude_N);
                v.setElementAt(val,++i);

                val = getExlValue(dynamic_counter+Longitute_N);
                v.setElementAt(val,++i);

                val = getExlValue(dynamic_counter+Elevation);
                v.setElementAt(val,++i);

                v.setElementAt(getExlValue(dynamic_counter+Tectonic),++i);
                v.setElementAt(getExlValue(dynamic_counter+Rock),++i);
                v.setElementAt(getExlValue(dynamic_counter+Reference),++i);
                v.setElementAt(getExlValue(dynamic_counter+Expedition),++i);
            }
		}
        return r;
    }
 
    public int getTitleRow(Vector v)
    {
                v.insertElementAt("Sample_ID",0);
                v.insertElementAt("IGSN",1);
                v.add("Latitude");
                v.add("Longitute");
                v.add("Elevation");
                v.add("Tectonic");
                v.add("Rock");
                v.add("Reference");
                v.add("Expedition");

                return 1;
    }
}
