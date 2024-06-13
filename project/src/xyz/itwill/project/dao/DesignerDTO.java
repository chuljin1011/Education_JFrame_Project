package xyz.itwill.project.dao;

public class DesignerDTO {
   private String id;
   private String pw;
   private String birth;
   private String name;
   private String gender;
   private String rank;
   private int sal;
   private String hire_date;
   private String phone;
   private int career;
   
   public DesignerDTO() {
      // TODO Auto-generated constructor stub
   }

   public DesignerDTO(String id, String pw, String birth, String name, String gender, String rank, int sal,
         String hire_date, String phone, int career) {
      super();
      this.id = id;
      this.pw = pw;
      this.birth = birth;
      this.name = name;
      this.gender = gender;
      this.rank = rank;
      this.sal = sal;
      this.hire_date = hire_date;
      this.phone = phone;
      this.career = career;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getPw() {
      return pw;
   }

   public void setPw(String pw) {
      this.pw = pw;
   }

   public String getBirth() {
      return birth;
   }

   public void setBirth(String birth) {
      this.birth = birth;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getGender() {
      return gender;
   }

   public void setGender(String gender) {
      this.gender = gender;
   }

   public String getRank() {
      return rank;
   }

   public void setRank(String rank) {
      this.rank = rank;
   }

   public int getSal() {
      return sal;
   }

   public void setSal(int sal) {
      this.sal = sal;
   }

   public String getHire_date() {
      return hire_date;
   }

   public void setHire_date(String hire_date) {
      this.hire_date = hire_date;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public int getCareer() {
      return career;
   }

   public void setCareer(int career) {
      this.career = career;
   }   

}
