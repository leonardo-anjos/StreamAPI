package lab.datascience.insight;

public class FieldsFileCSV {

	private String report_date;
	private String location;
	private String location_type;
	private String data_field;
	private String data_field_code;
	private String time_period;
	private String time_period_type;
	private String value;
	private String unit;

	public FieldsFileCSV() {
		super();
	}

	public FieldsFileCSV(String report_date, String location, String location_type, String data_field,
			String data_field_code, String time_period, String time_period_type, String value, String unit) {
		super();
		this.report_date = report_date;
		this.location = location;
		this.location_type = location_type;
		this.data_field = data_field;
		this.data_field_code = data_field_code;
		this.time_period = time_period;
		this.time_period_type = time_period_type;
		this.value = value;
		this.unit = unit;
	}

	public String getReport_date() {
		return report_date;
	}

	public void setReport_date(String report_date) {
		this.report_date = report_date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocation_type() {
		return location_type;
	}

	public void setLocation_type(String location_type) {
		this.location_type = location_type;
	}

	public String getData_field() {
		return data_field;
	}

	public void setData_field(String data_field) {
		this.data_field = data_field;
	}

	public String getData_field_code() {
		return data_field_code;
	}

	public void setData_field_code(String data_field_code) {
		this.data_field_code = data_field_code;
	}

	public String getTime_period() {
		return time_period;
	}

	public void setTime_period(String time_period) {
		this.time_period = time_period;
	}

	public String getTime_period_type() {
		return time_period_type;
	}

	public void setTime_period_type(String time_period_type) {
		this.time_period_type = time_period_type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public String toString() {
		return this.getData_field() + " " + this.getData_field_code() + " " + this.getLocation() + " "
				+ this.getLocation_type() + " " + this.getTime_period() + " " + this.getTime_period_type() + " "
				+ this.getUnit() + " " + this.getValue();
	}

}
