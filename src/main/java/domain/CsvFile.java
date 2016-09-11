package domain;

public class CsvFile {

	 private long _id;
	 private String name;
	 private String type;
	 private double latitude;
	 private double longitude;
	 
	public CsvFile(long _id, String name, String type, double latitude, double longitude) {
		this._id = _id;
		this.name = name;
		this.type = type;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public long get_id() {
		return _id;
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public double getLatitude() {
		return latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void set_id(long _id) {
		this._id = _id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CsvFile [_id=");
		builder.append(_id);
		builder.append(", ");
		if (name != null) {
			builder.append("name=");
			builder.append(name);
			builder.append(", ");
		}
		if (type != null) {
			builder.append("type=");
			builder.append(type);
			builder.append(", ");
		}
		builder.append("latitude=");
		builder.append(latitude);
		builder.append(", longitude=");
		builder.append(longitude);
		builder.append("]");
		return builder.toString();
	}
	 
}
