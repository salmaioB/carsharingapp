package cs.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.text.DateFormatter;

public class OfferWithCustomerAccount
{
        private Integer id;
        private Integer gender;
        private String lastName;
        private String firstName;
        
        private String startingCity;
        private String finishingCity;
        private Integer numberOfPlaceRemaining;
        private Float pricePerPassenger;

        private Date datetimeStarted;
        
        
        public Integer getId() {
                return id;
        }
        
        public void setId(Integer id) {
                this.id = id;
        }
    
        public Integer getGender() {
                return gender;
        }
        
        public void setGender(Integer gender) {
                this.gender = gender;
        }
        
        public String getLastName() {
                return lastName;
        }
        
        public void setLastName(String lastName) {
                this.lastName = lastName;
        }
        
        public String getFirstName() {
                return firstName;
        }
        
        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }
        
        public String getStartingCity() {
                return startingCity;
        }

        public void setStartingCity(String startingCity) {
                this.startingCity = startingCity;
        }

        public String getFinishingCity() {
                return finishingCity;
        }

        public void setFinishingCity(String finishingCity) {
                this.finishingCity = finishingCity;
        }
        
        public Float getPricePerPassenger() {
                return pricePerPassenger;
        }
        
        public void setPricePerPassenger(Float pricePerPassenger) {
                this.pricePerPassenger = pricePerPassenger;
        }

        public Integer getNumberOfPlaceRemaining() {
                return numberOfPlaceRemaining;
        }

        public void setNumberOfPlaceRemaining(Integer numberOfPlaceRemaining) {
                this.numberOfPlaceRemaining = numberOfPlaceRemaining;
        }

        /**
         * Todo modif
         * Idealement faudrait retourner un objet Date
         * @return
         */
        public String getDatetimeStarted() {
    		//SimpleDateFormat  simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		//DateFormatter df = new DateFormatter();
    		//return simpleFormat.format(datetimeStarted);
            //return DateFormat.getDateInstance( DateFormat.MEDIUM ).format( datetimeStarted ) ;
        	SimpleDateFormat  simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        	System.out.println( simpleFormat.format(datetimeStarted) );
        	return simpleFormat.format(datetimeStarted);
        }

        public void setDatetimeStarted(Date datetimeStarted) {
                this.datetimeStarted = datetimeStarted;
        }
}
