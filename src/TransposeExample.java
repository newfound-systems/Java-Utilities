import java.util.Map;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;
import com.google.common.collect.Tables;

public class TransposeExample {

	public static void main(String[] args) {

		Table<String, String, String> kpi = HashBasedTable.create();
		kpi.put("AE", "ECOMM", "5.0");
		kpi.put("AE", "ITSKILLS", "2.0");

		kpi.put("ZA", "ECOMM", "15.0");
		kpi.put("ZA", "ITSKILLS", "12.0");

		System.out.println("Size: " + kpi.size());

		System.out.println(kpi);
		Table<String, String, String> transposed = Tables.transpose(kpi);
		System.out.println(transposed);

		for (Cell<String, String, String> cell : kpi.cellSet()) {
			System.out.println(cell.getRowKey() + " " + cell.getColumnKey() + " " + cell.getValue());
		}
		System.out.println(kpi.rowMap());

		for (String key : kpi.rowKeySet()) {
			Map<String, String> kpiMap = kpi.row(key);
			System.out.println("Key: " + key + " Values: " + kpiMap);
		}
	}
}
