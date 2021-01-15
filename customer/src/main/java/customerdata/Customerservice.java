package customerdata;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;
@Service
public class Customerservice {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public Map<String, String> addCustomer1 (Customer product) {
 
		
		Map<String, String> data = new HashMap<String, String>();
		int result = 0;
		String sql = "INSERT INTO Customer ( CustomerID,CustomerName, PhoneNumber, ShipToAddress, ShipToZip, ShipToCity, ShipToState) VALUES (:CustomerName, :PhoneNumber, :ShipToAddress, :ShipToZip, :ShipToCity, :ShipToState)";
		try
		{
			SqlParameterSource parameters = new MapSqlParameterSource()
					.addValue("CustomerName", product.getCustomerName())
					.addValue("PhoneNumber",product.getPhoneNumber())
					.addValue("ShipToAddress", product.getShipToAddress())
					.addValue("ShipToZip",product.getShipToZip())
					.addValue("ShipToCity",product.getShipToCity())
					.addValue("ShipToState",product.getShipToState());
					

			result = namedParameterJdbcTemplate.update(sql, parameters);
			if (result > 0)
				data.put("success", "Record inserted successfully");
			else
				data.put("failed", "Record failed to insert, please try again!");
		} catch (Exception e) {
			data.put("error", "Error occured, please try again!");
			
		}
		
		return data;

	}

	public Map addCustomer(Customer product) {
		Map<String, String> data = new HashMap<String, String>();
		int result = 0;
		String sql = "INSERT INTO Customer (CustomerName,PhoneNumber,ShipToAddress,ShipToZip,ShipToCity,ShipToState) VALUES (:CustomerName,:PhoneNumber,:ShipToAddress,:ShipToZip,:ShipToCity,:ShipToState)";
		try
		{
			System.out.println (product.getCustomerName());
			SqlParameterSource parameters = new MapSqlParameterSource()
					.addValue("CustomerName", product.getCustomerName())
					.addValue("PhoneNumber",product.getPhoneNumber())
					.addValue("ShipToAddress", product.getShipToAddress())
					.addValue("ShipToZip",product.getShipToZip())
					.addValue("ShipToCity",product.getShipToCity())
					.addValue("ShipToState",product.getShipToState());
					

			result = namedParameterJdbcTemplate.update(sql, parameters);
			if (result > 0)
				data.put("success", "Record inserted successfully");
			else
				data.put("failed", "Record failed to insert, please try again!");
		} catch (Exception e) {
			data.put("error", "Error occured, please try again!");
			System.out.println(e.getMessage());
			
		}
		
		return data;

	}

	

}
