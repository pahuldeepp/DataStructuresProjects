public class PostalCode implements Comparable<PostalCode> {
    private String code;
    private String area;
    private String province;
    private double latitude;
    private double longitude;
    public PostalCode(){
        code="unknown";
        area= "unknown";
        province="unknown";
        latitude=0;
        longitude=0;
    }
    public PostalCode(String code,String area,String province,double latitude, double longitude){
        this.code=code;
        this.area=area;
        this.province=province;
        this.latitude=latitude;
        this.longitude=longitude;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public int compareTo(PostalCode p){

        return this.getCode().compareTo(p.getArea());
        
    }
    public String toString(){
        return code+ " "+area+" "+province+" "+latitude+" "+longitude;
    }
}
